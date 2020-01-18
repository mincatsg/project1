#include<stdio.h>
#include<stdlib.h>
#include<string.h>

unsigned int reverse_bit(unsigned int value){
	int a[33] = {0};
	unsigned int sum = 0;
	for (int i = 0; i < 32; ++i){  
		if ((value & 1) == 1){    
			a[i] = 1;
			value = value >> 1;
		
		
		}
		else{ a[i] = 0; value = value >> 1; }
	    
	} 
	unsigned int c = 1;             //必须声明无符号，这样计算时不会左移溢出
	for (int j = 0; j < 32; ++j){ 
		
		sum =sum+((c<<(31-j)) * a[j]);
	}
		


	return sum;



}
void aver(int x, int y){
	//float a= x - (x - y) / 2.0;      //割补、、
	//float  a = (x + y) >> 1;      //移位。有bug
	float a = (x&y) + ((x^y) / 2.0);   //找出不同除以2，加上相同的
	printf("%f\n", a);
}
void find_one(){
	int a[9] = { 23, 4, 5, 6, 11, 23, 4, 5, 6 };
	int number = 0;
	for (int i = 0; i < 9; ++i){
	
		number ^= a[i];
	
	}
	printf("%d\n", number);
}
void reverse(char *left, char *right)
	{
		
			while (left < right)
			{
				char tmp = *left;
				*left = *right;
				*right = tmp;
				++left;
				--right;
			}
		

	}
void reverse_str(char *str, int len)
{
	reverse(str, str + len - 1);//整体逆置
    char *pCur = str;
	while (*str){
		pCur = str;
		char *end = str;
		while (' ' != *end && *end != '\0'){
		
			++end;
		}
         reverse(pCur, end - 1);//单词逆置
		 str = end;
		if (*str == ' '){
			++str;
			continue;
		}
	}
}

int main(){

	//printf("%u\n", reverse_bit(25));   //无符号输出
	//aver(10,15);
	//find_one();
	char str[] = "student a am i";
	printf("string=%s\n", str);
	reverse_str(str, strlen(str));
	printf("string=%s\n", str);
	system("pause");
	return 0;

}