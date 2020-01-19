#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define max_row 3
#define max_col 3
void init(char chess[max_row][max_col]){
	for (int i = 0; i < max_row; ++i){
		for (int j = 0; j < max_col; ++j){

			chess[i][j] = ' ';
		}
	}
	srand(time(0));
}
void print(char chess[max_row][max_col]){
	printf("-----+-----+------\n");
	for (int row = 0; row < max_row; ++row){
		printf("|  %c |  %c  |  %c  |\n", chess[row][0], chess[row][1], chess[row][2]);
		printf("-----+-----+------\n");
	}



}
void player(char chess[max_row][max_col]){
	int row = 0;
	int col = 0;
	while (1){
		printf("��������Ҫ���ӵĵط�\n");
		scanf("%d %d", &row, &col);
		if (row >= max_row || col >= max_row) {
			    printf("�������ֵ�������̣�����������\n");
				continue;
		}
		  else if (chess[row][col] == ' '){
              chess[row][col] = 'x';
			  break;}
		      else{
			printf("������ĵط��Ѿ������ӣ�������ѡ��\n");
			continue;
		}
		
		
		}
	
	
	
	}
char judege(char chess[max_row][max_col]){
	for (int i = 0; i < max_row; ++i){
		if (chess[i][0] == chess[i][1] &&
			chess[i][0] == chess[i][2] )
		{
			return chess[i][0];
		}
	}
	for (int j = 0; j < max_col; ++j){
		if (chess[0][j] == chess[1][j] &&
			chess[0][j] == chess[2][j])
		{
			return chess[0][j];

		}


	}
	if (chess[0][0] == chess[1][1] &&
		chess[0][0] == chess[2][2]){
		return chess[1][1];
	}
	if (chess[0][2] == chess[1][1] &&
		chess[0][2] == chess[2][0] ){
		return chess[1][1];
	}
	return 0;
}
int chessfull(char chess[max_row][max_col]){
	for (int row = 0; row < max_row; ++row){
			for (int col = 0; col < max_col; ++col){
				if (chess[row][col] == ' '){

					return 0;
				}
			}
			
		}
		return 1;

			}
void computer(char chess[max_row][max_col]){
	int row = 0;
	int col = 0;
	while (1){
		row = rand() % 3;
		col = rand() % 3;
		if (chess[row][col] == ' ')
		{
			chess[row][col] = 'o';
			break;
		}
		else{
			continue;
		}
	}
}
int main(){
	char chess[max_row][max_col];
	init(chess);   //��ʼ������
	char wanwin;
	int   heqi = 0;;
	while (1){
		print(chess);   //��ӡ����
		player(chess);    //�������
		wanwin=judege(chess);    //�ж���Ϸ����
		if (wanwin == 'x'){
			printf("��Ӯ��\n");
			break;
		
		}
		heqi=chessfull(chess);
		if (heqi == 1){
			system("cls");
			print(chess);
			printf("������\n");
			break;

		}
		print(chess);     //���´�ӡ����
		system("cls");
		computer(chess);   //��������
		wanwin=judege(chess);     //�ж���Ϸ����
		if (wanwin == 'o'){
			print(chess);
			printf("������\n");
			break;
		}
	}
	
	
	
	system("pause");
	return 0;


}