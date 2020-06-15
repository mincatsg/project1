#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int judge(int *b,int size){
	for (int j = 0; j < size-1; ++j){
		if (b[j] < b[j + 1]){
               
			continue;
				             }

		else return -1;

	}

	return 1;
	
}
void swap(int *a, int i, int j)
{
	int tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
}
void randomsort(int *a,int size){
	
	int count = 0;
	while (1){
	srand(time(0));
	int i = 0;
	int c[100];
	int b[100];
	for (i = 0; i < size; i++)
		c[i] = i;
	for (i = 0; i < size; i++)//交换a[i]和a[i]后面的随机序号
		swap(c, i, i + rand() % (size - i));

	for (i = 0; i < size; ++i){
		b[i] = a[c[i]];
	
	
	
	}

			 
		    
		 if (judge(b, size) == 1){
			 printf("成功,执行次数为:%d\n", count);
			 for (int j = 0; j < size; ++j){
			 
				 printf("%d\t", b[j]);
			 }
			 break;
			 
		 }
		 ++count;
		 printf("执行次数为:%d\n", count);
	
	}

}

int main(){

	int a[] = {2,3,1,6};
	int size = sizeof(a) / sizeof(int);
	//printf("%d", size);
	randomsort(a,size);
	system("pause");
	return 0;
}