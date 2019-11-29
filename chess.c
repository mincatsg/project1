#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
//#include<stdlib.h>
//#include<time.h>
//
//#define ROW 3
//#define COLUMN 3
//
////判断是否棋盘满了
//int FULL(char chess_board[ROW][COLUMN]){
//	for (int i = 0; i < ROW; i++){
//		for (int j = 0; j < COLUMN; j++){
//			if (chess_board[i][j] == ' '){
//				return 0;
//			}
//		}
//	}
//	return 1;
//}
//
//// 0.游戏选择
//void choice_game(){
//	printf("*******************************\n");
//	printf("*******1. 游戏开始*************\n");
//	printf("*******0. 游戏结束*************\n");
//	printf("*******************************\n");
//}
//
//// 1.初始化棋盘
//void Initialize(char chess_board[ROW][COLUMN]){
//	for (int i = 0; i < ROW; i++){
//		for (int j = 0; j < COLUMN; j++){
//			chess_board[i][j] = ' ';
//		}
//	}
//	srand(time(0));
//}
//
//// 2. 打印棋盘
//void Define(char chess_board[ROW][COLUMN]){
//	printf("++++++++++++++++");
//	printf("\n");
//	for (int i = 0; i < ROW; i++){
//		printf("！");
//		for (int j = 0; j < COLUMN; j++){
//			printf(" %c ！", chess_board[i][j]);
//		}
//		printf("\n"); 
//		printf("++++++++++++++++");
//		printf("\n");
//	}
//}
//
//// 3. 玩家落子
//void chess_player(char chess_board[ROW][COLUMN]){
//	int row;
//	int column;
//	while (1){
//		printf("请输入你要落子的位置: ");
//		scanf("%d %d", &row, &column);
//		if (row < 0 || row > ROW || column < 0 || column > COLUMN){
//			printf("你的输入有误,请重输\n");
//			continue;
//		}
//		if (chess_board[row][column] != ' '){
//			printf("这个位置已落子,请重输\n");
//			continue;
//		}
//		chess_board[row][column] = 'o';
//		break;
//	}
//}
//
//// 4 .电脑落子
//void chess_computer(char chess_board[ROW][COLUMN]){
//	while (1){
//		int row = rand() % ROW;
//		int column = rand() % COLUMN;
//		if (chess_board[row][column] != ' '){
//			continue;
//		}
//		chess_board[row][column] = 'x';
//		break;
//	}
//}
//
//// 5. 判断游戏是否结束
//char Game_over(char chess_board[ROW][COLUMN]){
//	//行
//	for (int i = 0; i < ROW; i++){
//		if (chess_board[i][0] == chess_board[i][1]  && chess_board[i][0] == chess_board[i][2] && chess_board[i][0] != ' '){
//			return chess_board[i][0];
//		}
//	}
//	//列
//	for (int i = 0; i < COLUMN; i++){
//		if (chess_board[0][i] == chess_board[1][i] && chess_board[0][i] == chess_board[2][i] && chess_board[i][0] != ' '){
//			return chess_board[0][i];
//		}
//	}
//	//对角线
//	if (chess_board[0][0] == chess_board[1][1] && chess_board[0][0] == chess_board[2][2] && chess_board[0][0] != ' '){
//		return chess_board[0][0];
//	}
//	if (chess_board[0][2] == chess_board[1][1] && chess_board[0][2] == chess_board[2][0] && chess_board[0][2] != ' '){
//		return chess_board[0][2];
//	}
//	//和棋
//	if (FULL(chess_board)){
//		return '=';
//	}
//	return ' ';
//}
//
//int main(){
//	char chess_board[ROW][COLUMN] = {""};
//	Initialize(chess_board);
//	choice_game();
//	int choice;
//	printf("请输入你的选择：");
//	scanf("%d", &choice);
//	char b;
//	  while (1){
//		  if (choice == 1){
//			  Define(chess_board);
//			  chess_player(chess_board);
//			  b = Game_over(chess_board);
//			  if (b != ' '){            // 证明游戏已经分出胜负了
//				  Define(chess_board);
//				  break;
//			  }
//			  chess_computer(chess_board);
//			  b = Game_over(chess_board);
//			  if (b != ' '){
//				  Define(chess_board);
//				  break;
//			  }
//		  }
//		  else  if (choice == 0){
//			  break;
//		  }
//		  else{
//			  printf("你的输入有误,请重输\n");
//			  continue;
//		  }
//
//	  }
//	  if (b == 'o'){
//		  printf("玩家胜利\n");
//	  }
//	  else if (b == 'x'){
//		  printf("电脑胜利\n");
//	  }
//	  else if (b == '='){
//		  printf("和棋\n");
//	  }
//	system("pause");
//	return 0;
//}
