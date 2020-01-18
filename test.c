#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
void bottle(int money){

	int num = 0;                 
 	int count = 0;                 
	while (money != 0){          
		num = num + money;
		if ((money % 2) != 0){
			money = money - 1;
		    if (money == 0){
				num += count;
				break;
			}
			money=money/ 2;
			++count;
		
		}
		else money = money / 2;
	
	}


	printf("%d", num);
}
int main(){

	int money = 0;
	scanf("%d", &money);
	bottle(money);
	system("pause");
	return 0;
}