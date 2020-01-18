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
				   str1[size - 1] = tmp;   //前推后补
			   }

		//printf("%s\n", str1);
	}

}
void judge(char *str1, char *str2,int size){

	
	for (int k = 1; k < size; ++k){
		rotate(str1, size, k);
		if (strcmp(str1, str2) == 0){
		
			printf("匹配成功,旋转字符个数为:%d\n",k);
			break;
		}

	}

}
int main(){
	char str1[] = "ABCDEFGH";
	char str2[] = "CDEFGHAB";
	printf("原字符串为：%s\n", str1);
	printf("匹配字符串为：%s\n", str2);
	int size = (sizeof(str1) / sizeof(char)) - 1;
	judge(str1, str2,size);
	system("pause");
	return 0;
}