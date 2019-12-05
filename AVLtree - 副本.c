#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
int flag = FALSE;
struct element {
        int key;
};
struct tree_node {
        tree_node *left_child;
        tree_node *right_child;
        element data;
        int bf;
};
void left_rotation(tree_node *&parent)
{
        tree_node *child = parent->left_child;
        if(child->bf == 1) {
                parent->left_child = child->right_child;
                child->right_child = parent;
                parent->bf = 0;
                parent = child;
        } else {
                tree_node *grand_child = child->right_child;
                parent->left_child = grand_child->right_child;
                child->right_child = grand_child->left_child;
                grand_child->right_child = parent;
                grand_child->left_child = child;
                switch(grand_child->bf) {
                case 0:         parent->bf = child->bf = 0;
                                        break;
                case 1:         parent->bf = -1;
                                        child->bf = 0;
                                        break;
                case -1:        parent->bf = 0;
                                        child->bf = 1; 
                }
                parent = grand_child;
        }
        parent->bf = 0;
}
void right_rotation(tree_node *&parent)
{
        tree_node *child = parent->right_child;
        if(child->bf == -1) {
                parent->right_child = child->left_child;
                child->left_child = parent;
                parent->bf = 0;
                parent = child;
        } else {
                tree_node *grand_child = child->left_child;
                parent->right_child = grand_child->left_child;
                child->left_child = grand_child->right_child;
                grand_child->right_child = child;
                grand_child->left_child = parent;
                switch(grand_child->bf) {
                case 0:         parent->bf = child->bf = 0;
                                        break;
                case -1:        parent->bf = 1;
                                        child->bf = 0;
                                        break;
                case 1:         parent->bf = 0;
                                        child->bf = -1;
                }
                parent = grand_child;
        }
        parent->bf = 0;
}
void avl_insert(tree_node *&parent, element x, int &unbalanced)
{
        if(parent == NULL) {
                parent = (tree_node*)malloc(sizeof(tree_node));
                parent->left_child = parent->right_child = NULL;
                parent->data = x;
                parent->bf = 0;
                unbalanced = TRUE;
        } else if(x.key < parent->data.key) {
                avl_insert(parent->left_child, x, unbalanced);
                if(unbalanced) {
                        switch(parent->bf) {
                        case 0:         parent->bf = 1;
                                                break;
                        case -1:        parent->bf = 0;
                                                unbalanced = FALSE;
                                                break;
                        case 1:         left_rotation(parent);
                                                unbalanced = FALSE;
                        }
                }
        } else if(x.key > parent->data.key) {
                avl_insert(parent->right_child, x, unbalanced);
                if(unbalanced) {
                        switch(parent->bf) {
                        case 0:         parent->bf = -1;
                                                break;
                        case 1:         parent->bf = 0;
                                                unbalanced = FALSE;
                                                break;
                        case -1:        right_rotation(parent);
                                                unbalanced = FALSE;
                        }
                }
        } else {
                unbalanced = FALSE;
        }
}
void swap(tree_node *p, tree_node *q)
{
        element temp = p->data;
        p->data = q->data;
        q->data = temp;
}
void avl_del(tree_node *&parent, element x, int &unbalanced)
{
        if(parent->data.key == x.key) {
                unbalanced = TRUE;
                if(!parent->right_child && !parent->left_child) {
                        parent = NULL;
                } else if(parent->right_child && !parent->left_child) {
                        parent = parent->right_child;
                } else if(parent->left_child && !parent->right_child) {
                        parent = parent->left_child;
                } else if(parent->left_child && parent->right_child) {
                        tree_node *p = parent;
                        p = p->right_child;
                        while(p->left_child) {
                                p = p->left_child;
                        }
                        swap(parent, p);
                        avl_del(parent->right_child, x, unbalanced);
                }
        } else if(x.key > parent->data.key) {
                if(!parent->right_child) return;
                avl_del(parent->right_child, x, unbalanced);
                if(unbalanced) {
                        switch(parent->bf) {
                        case 0:         parent->bf = 1;
                                                unbalanced = FALSE;
                                                break;
                        case -1:        parent->bf = 0;
                                                unbalanced = FALSE;
                                                break;
                        case 1:         left_rotation(parent);
                        }
                }
        } else if(x.key < parent->data.key) {
                if(!parent->left_child) return;
                avl_del(parent->left_child, x, unbalanced);
                if(unbalanced) {
                        switch(parent->bf) {
                        case 0:         parent->bf = -1;
                                                unbalanced = FALSE;
                                                break;
                        case 1:         parent->bf = 0;
                                                unbalanced = FALSE;
                                                break;
                        case -1:                right_rotation(parent);
                        }
                }
        }
}
void inorder(tree_node*);
int depth(tree_node*);
int main()
{
        tree_node *root = NULL;
        for(int i=1; i<100; ++i) {
                element data;
                data.key = i;
                avl_insert(root, data, flag);
        }
        inorder(root);
        printf("/n");
        int depleft = depth(root->left_child);
        int depright = depth(root->right_child);
        printf("%d/n", depleft);
        printf("%d/n", depright);
        element data;
        data.key = 92;
        avl_del(root, data, flag);
        inorder(root);
        printf("/n");
}
int depth(tree_node *root)
{
        if(root == NULL) return 1;
        else {
                int rcd = depth(root->right_child);
                int lcd = depth(root->left_child);
                if(lcd > rcd) return lcd + 1;
                else return rcd + 1;
        }
}
struct stack {
        tree_node *data[1024];
        int top;
};
void initstack(stack *s)
{
        s->top = -1;
}
void pushstack(stack *s, tree_node *p)
{
        if(s->top >= 1024) {
                printf("stack full/n");
                exit(1);
        }
        s->data[++s->top] = p;
}
void popstack(stack *s, tree_node *&p)
{
        if(s->top == -1) {
                printf("stack empty/n");
                exit(1);
        }
        p = s->data[s->top--];
}
void inorder(tree_node *root)
{
        stack s;
        initstack(&s);
        while(root != NULL || s.top != -1) {
                if(root != NULL) {
                        pushstack(&s, root);
                        root = root->left_child;
                } else {
                        popstack(&s, root);
                        printf("%d ", root->data.key);
                        root = root->right_child;
                }
        }
}
