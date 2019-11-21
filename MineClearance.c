#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h> 
#include<time.h>

#define ROW 10 
#define COLUMN 10 
#define Mine 10
void Init(char a[ROW][COLUMN]){
	srand(time(0));
	for (int i = 0; i < ROW; i++){
		for (int j = 0; j < COLUMN; j++){
			a[i][j] = '*';
		}
	}
}
void Init1(char b[ROW][COLUMN]){
	for (int i = 0; i < ROW; i++){
		for (int j = 0; j < COLUMN; j++){
			b[i][j] = 0;
		}
	}
	int n = Mine;
	while (n > 0){
	 int row = rand() % ROW;
	 int column = rand() % COLUMN;
		if (b[row][column] == '#'){    //用#号来表示雷
			continue;
		}
		b[row][column] = '#';
		n--;
	}

}
void print(char a[ROW][COLUMN]){
	for (int i = 0; i < ROW; i++){
		for (int j = 0; j < COLUMN; j++){
			printf("| %c ", a[i][j]);
		}
		printf("|");
		printf("\n");
		for (int z = 0; z < COLUMN; z++){
			printf("----");
		}
		printf("\n");
	}
}
void game(char a[ROW][COLUMN], char b[ROW][COLUMN]){
	int amount = 0;
	Init(a);
	Init1(b);
	printf("有雷的数组为: \n");
	print(b);
	int row, column;
	while (1){
		printf("数组为: \n");
		print(a);
		printf("请输入你要点的图案的坐标: ");
		scanf("%d%d", &row, &column);
		if (row - 1 < 0 && row - 1 >= ROW && column - 1 < 0 && column - 1 >= COLUMN){
			printf("你的输入有误，请重输");
			continue;
		}
		if (a[row - 1][column - 1] == ' '){
			continue;
		}
//判断
		if (b[row - 1][column - 1] == '#'){
			printf("Game over \n");
			break;
		}
		amount++;
		if (amount == ROW * COLUMN - Mine){
			printf("你成功了扫除所有雷\n");
			break;
		}
		a[row - 1][column - 1] = ' ';
	}
}
int main(){
	char a[ROW][COLUMN];
	char b[ROW][COLUMN];
	game(a, b);
	system("pause");
	return 0;
}