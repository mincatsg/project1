#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>
////.ʵ��һ��ͨѶ¼��
////ͨѶ¼���������洢1000���˵���Ϣ��ÿ���˵���Ϣ������
////�������Ա����䡢�绰��סַ
////1.	�����ϵ����Ϣ
////2.	ɾ��ָ����ϵ����Ϣ
////3.	����ָ����ϵ����Ϣ
////4.	�޸�ָ����ϵ����Ϣ
////5.	��ʾ������ϵ����Ϣ
////6.	���������ϵ��
////7.	����������������ϵ��
#define Name 5
#define Sex  4
#define Phone 20
#define Address 20
#define Per 1000
#define MAX_STR  1000
int j = 0;

typedef struct inform{
	char name[Name];
	char sex[Sex];
	int age;
	char phone[Phone];
	char address[Address];
}inform;

typedef struct Contacts{
	inform per[Per];
	int num;
} Contacts;




void Init(Contacts *p){
	assert(p != NULL);
	p->num = 0;
	memset(p->per, 0, sizeof(p));
}
void Define(Contacts *p){
	if (p->num == Per){
		printf("ͨѶ¼����\n");
		return;
	}
	printf("������");
	scanf("%s", p->per[p->num].name);
	printf("�Ա�:");
	scanf("%s", p->per[p->num].sex);
	printf("����:");
	scanf("%d", &p->per[p->num].age);
	printf("�绰:");
	scanf("%s", p->per[p->num].phone);
	printf("סַ:");
	scanf("%s", p->per[p->num].address);
	++(p->num);
	printf("��ӳɹ�\n");
}
int Find(Contacts *p){
	char search[20] = { 0 };
	assert(p != NULL);
	if (p->num == 0){
		printf("��û��¼����Ϣ\n");
		return -1;
	}
	printf("������ϵ��������");
	scanf("%s", search);
	for (j = 0; j < p->num; j++){
		if (strcmp(search, p->per[j].name) == 0){
			return j;
		}
	}
	if (p->num == 0){
		printf("�������ϵ��");
		return -1;
	}
}
void Delete(Contacts *p){
	assert(p != NULL);
	int ret = Find(p);
	if (ret == -1){
		printf("�������ϵ��\n");
		return;
	}
	if (ret != p->num - 1){
		strcpy(p->per[ret].address, p->per[p->num - 1].address);
		p->per[ret].age = p->per[p->num - 1].age;
		strcpy(p->per[ret].name, p->per[p->num - 1].name);
		strcpy(p->per[ret].sex, p->per[p->num - 1].sex);
		strcpy(p->per[ret].phone, p->per[p->num - 1].phone);
	}
	p->num--;
	printf("ɾ���ɹ�\n");
}
void Clear(Contacts *p){
	assert(p != NULL);
	if (p->num == 0){
		printf("��û��¼����Ϣ\n");
		return -1;
	}
	Init(p);
	printf("������\n");
}
void Show(Contacts *p){
	assert(p != NULL);
	if (p->num == 0){
		printf("δ¼��\n");
		return;
	}
	for (int i = 0; i < p->num; i++){
		printf("%s    ", p->per[i].name);
		printf("%s    ", p->per[i].sex);
		printf("%d    ", p->per[i].age);
		printf("%s    ", p->per[i].phone);
		printf("%s    ", p->per[i].address);
		printf("\n");
	}
}
void Change(Contacts *p){
	assert(p != NULL);
	int ret = Find(p);
	if (ret == -1){
		printf("�������ϵ��\n");
		return;
	}
	printf("��������(*������):");
	char tem[20] = { 0 };
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].name, tem);
	}
	printf("�Ա����(*������):");
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].sex, tem);
	}
	printf("�������(0������):");
	int num = 0;
	scanf("%d", &num);
	if (num != 0){
		p->per[ret].age = num;
	}
	printf("�绰����(*������):");
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].phone, tem);
	}
	printf("��ַ����(*������):");
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].address, tem);
	}
	
}
void Sort(Contacts *p){

	assert(p != NULL);
	Contacts con1;
	Contacts *p1 = &con1;
	if (p->num == 0){
		printf("δ¼��\n");
		return;
	}
	for (int i = 0; i < p->num - 1; i++){
		for (int j = 0; j < p->num - i - 1; j++){
			if ((strcmp(p->per[j].name, p->per[j + 1].name)) > 0){
				{
					strcpy(p1->per[0].address, p->per[j].address);
					p1->per[0].age = p->per[j].age;
					strcpy(p1->per[0].name, p->per[j].name);
					strcpy(p1->per[0].sex, p->per[j].sex);
					strcpy(p1->per[0].phone, p->per[j].phone);
				}
				{
					strcpy(p->per[j].address, p->per[j + 1].address);
					p->per[j].age = p->per[j + 1].age;
					strcpy(p->per[j].name, p->per[j + 1].name);
					strcpy(p->per[j].sex, p->per[j + 1].sex);
					strcpy(p->per[j].phone, p->per[j + 1].phone);
				}
				{
					strcpy(p->per[j + 1].address, p1->per[0].address);
					p->per[j + 1].age = p1->per[0].age;
					strcpy(p->per[j + 1].name, p1->per[0].name);
					strcpy(p->per[j + 1].sex, p1->per[0].sex);
					strcpy(p->per[j + 1].phone, p1->per[0].phone);
				}
			}
		}
	}
	printf("����ɹ�\n");
}
void start(){
	printf("********************************************************\n");
	printf("1.�����ϵ����Ϣ\n");
	printf("2.������ϵ����Ϣ\n");
	printf("3.ɾ����ϵ����Ϣ\n");
	printf("4.������ϵ����Ϣ\n");
	printf("5.չʾ��ϵ����Ϣ\n");
	printf("6.������ϵ����Ϣ\n");
	printf("7.�����ϵ����Ϣ\n");
	printf("8.���\n");
	printf("********************************************************\n");
	void(*p[])(Contacts *p) = {NULL,Define,Find,Delete, Change, Show,Sort, Clear };
	Contacts con;
	int choice = 0;
	Init(&con);
	while (1){
		printf("��������Ҫ���еĲ���: ");
		scanf("%d", &choice);
		if (choice == 8){
			printf("�˳�ͨѶ¼\n");
			break;
		}
		else if (choice < 0 || choice > 7){
			continue;
		}
		else if (choice > 0 && choice <= 7){
			p[choice](&con);
			if (choice == 2){
				printf("������ %s\n", con.per[j].name);
				printf("�Ա��� %s\n", con.per[j].sex);
				printf("������ %d\n", con.per[j].age);
				printf("�绰�� %s\n", con.per[j].phone);
				printf("��ַ�� %s\n", con.per[j].address);
			}
		}
		else{
			printf("��������\n");
			break;
		}
	}
}
int main(){
	start();
	system("pause");
	return 0;

}





void delete(Contacts *p){
	char delete[20];
	printf("��Ҫɾ������ϵ��������");
	scanf("%s", delete[20]);
	while (p->num >= 0){
		if (!(strcpy(delete[20], p->per[p->num].name))){
			memset(p->per, 0, sizeof(p->per[p->num]));
			printf("��ɾ��\n");
			break;
		}
		(p->num)--;
	}
	if (p->num == 0){
		printf("�������ϵ��");
	}

}

