#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void rotate(char *str1,int size,int k){
	
     if(k == size || k == 0 ){ printf("%s\n", str1); }
	else{   // k  1 2 3
         for (int i = 0; i < k; i++)
			   {           
				   
				   char tmp = str1[0];
				   for (int j = 0; j < size; j++)
				   {                   
					   str1[j] = str1[j + 1];
				   }
				   str1[size - 1] = tmp;   //ǰ�ƺ�
			   }

		//printf("%s\n", str1);
	}

}
void judge(char *str1, char *str2,int size){

	
	for (int k = 1; k < size; ++k){
		rotate(str1, size, k);
		if (strcmp(str1, str2) == 0){
		
			printf("ƥ��ɹ�,��ת�ַ�����Ϊ:%d\n",k);
			break;
		}

	}

}
int main(){
	char str1[] = "ABCDEFGH";
	char str2[] = "CDEFGHAB";
	printf("ԭ�ַ���Ϊ��%s\n", str1);
	printf("ƥ���ַ���Ϊ��%s\n", str2);
	int size = (sizeof(str1) / sizeof(char)) - 1;
	judge(str1, str2,size);
	system("pause");
	return 0;
}