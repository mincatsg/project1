#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>


int main(){
	int i, j, k, a;
	for (i = 100; i <= 999; i++){
		j = i / 100;
		a = i % 10;
		k = (i - a * 100) / 10;
		if (i == j*j*j + k*k*k + a*a*a)
			printf("%d", i);

	}
	system("pause");
	return 0;


}





int main(){
int i, j;
for (i = 1; i <=1000; ++i){
     int sum = 0;
for (j = 1; j < i; ++j){
     if (i%j == 0){
     sum = sum + j;
  }

}
    if (sum == i){
    printf("%d its factors are: ", i);
        for (j = 1; j < i; ++j){
         if (i%j == 0){
       printf("%d   ", j);
    }
}
    printf("\n");
  }

}




   system("pause");
   return 0;


}

int main(){
    for (int i = 1; i <= 10; i++){
       printf("%d\n", i);

}
     system("pause");

return 0;
}





int main(){
        int i, j, k;
          for (i = 0; i < 4; i++){
           for (j = 0; j < 3 - i; j++)
        printf(" ");
       for (k = 0; k < 2*i + 1; k++)
        printf("*");
       printf("\n");
       }
          for (i = 0; i < 3; i++){
            for (j = 0; j <= i; j++)
       printf(" ");
        for (k = 0; k <= 4 - 2 * i; k++)
      printf("*");
       printf("\n");
}
       system("pause");
     return 0;
}



int main(){
int a[20][20] = { 0 };
int i, j;
for (i = 0; i < 20; i++){
for (j = 0; j < 20; j++){
a[i][0] = 1;
if (i == j){
a[i][j] = 1;
}
}
}
for (i = 2; i < 20; i++){
for (j = 1; j <= i-1; j++){
a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
}
}
for (i = 0; i < 20; i++){
for (j = 0; j < 20; j++){
if (a[i][j] != 0){
printf("%6d", a[i][j]);
}
}
printf("\n");

system("pause");
return 0;
}


//题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？

//程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去 掉不满足条件的排列。

int main(){

int i, j, k;
int count = 0;
       for (i = 1; i <= 4; i++){
        for (j = 1; j <= 4; j++){
         for (k = 1; k <= 4; k++){
if (i != j && i != k && j != k){
printf("%d%d%d   ", i, j, k);
}

count++;
if (count % 4 == 0){
printf("\n");

}
}
}
}
system("pause");
return 0;
}


int main(){
int   c,i;
int a;
printf("请输入你的月利润: ");
scanf("%d", &i);
if (i > 1000000) c = 11;
else 	c = i / 100000;
switch (c){
case 0: a = i*0.1; printf("%d\n", a); break;
case 1: a = 100000 * 0.1 + (i - 100000)*0.075; printf("%d\n", a); break;
case 2: a = 100000 * 0.1 + (i - 100000)*0.075; printf("%d\n", a); break;
case 3: a = 100000 * 0.1 + 100000 * 0.075 + (i - 200000)*0.05; printf("%d\n", a); break;
case 4: a = 100000 * 0.1 + 100000 * 0.075 + (i - 200000)*0.05; printf("%d\n", a); break;
case 5: a = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (i - 400000)*0.03; printf("%d\n", a); break;
case 6: a = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + (i - 400000)*0.03; printf("%d\n", a); break;
case 7: a = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 400000 * 0.03 + (i - 600000)*0.015; printf("%d\n", a); break;
case 8: a = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 400000 * 0.03 + (i - 600000)*0.015; printf("%d\n", a); break;
case 9: a = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 400000 * 0.03 + (i - 600000)*0.015; printf("%d\n", a); break;
case 10: a = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 400000 * 0.03 + (i - 600000)*0.015; printf("%d\n", a); break;
case 11: a = 100000 * 0.1 + 100000 * 0.075 + 200000 * 0.05 + 400000 * 0.03 + 600000 * 0.015 + (i - 1000000)*0.01; printf("%d\n", a); break;
default: printf("error"); break;
}

system("pause");
return 0;


}
