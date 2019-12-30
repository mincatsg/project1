#define  _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define ProNum 100
#define ResNum 100
int sum;//ʵ�ʽ��̸���
int res_sum;//ʵ����Դ����
int allocation[ProNum][ResNum];//ÿ�������ѷ�����Դ����
int max[ProNum][ResNum];//ÿ�������������
int need[ProNum][ResNum];//ÿ���������������Դ
int Available[ResNum];//������Դ�ĸ���
int MaxRes[ResNum];//������Դ�����и���
bool finish[ProNum];
bool res = false;//��Դ�Ƿ��ʼ��
bool pro = false;//�����Ƿ��ʼ��

int _allocation[ProNum][ResNum];//ÿ�������ѷ�����Դ����
int _need[ProNum][ResNum];//ÿ���������������Դ
int _Available[ResNum];//������Դ�ĸ���
bool _finish[ProNum];

void init() {
	int i, j;
	for (i = 0; i < ProNum; i++){
		for (j = 0; j < ResNum; j++){
			allocation[i][j] = 0;
		}
	}
	for (i = 0; i < ProNum; i++){
		for (j = 0; j < ResNum; j++){
			max[i][j] = 0;
		}
	}
	for (j = 0; j < ResNum; j++){
		Available[j] = 0;
	}
	for (j = 0; j < ResNum; j++){
		MaxRes[j] = 0;
	}
}

void backupinit() {  //��Ű�ȫ����ǰ��ֵ.
	int i, j;
	for (i = 0; i < sum; i++)
	for (j = 0; j < res_sum; j++) {
		_allocation[i][j] = allocation[i][j];
		_need[i][j] = need[i][j];
		_Available[j] = Available[j];
	}
}

void release() {  //�Ѵ�ŵ�ֵŪ���� ��������Ϊ����ȫ.
	int i, j;
	for (i = 0; i < ProNum; i++)
	for (j = 0; j < ResNum; j++) {
		allocation[i][j] = _allocation[i][j];
		need[i][j] = _need[i][j];
		Available[j] = _Available[j];
		finish[j] = false;
	}
}

void initRes() {//��ʼ����Դ����
	printf("��������Դ����:");
	scanf("%d", &res_sum);
	for (int i = 0; i < res_sum; i++) {
		printf("�������%d����Դ����:", i + 1);
		scanf("%d", &MaxRes[i]);
		printf("\n");
	}
	res = true;//��Դ�Ѿ���ʼ�����
}

void initPro() {//��ʼ��������Ϣ	
	if (res == false) {
		printf("���ʼ����Դ��Ϣ\n");
	}
	else if (res == true) {
		printf("��������̸���:");
		scanf("%d", &sum);
		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++) {
				printf("\n�������%d�����̶Ե�%d����Դ�����������:", i + 1, j + 1);
				scanf("%d", &max[i][j]);
			}
		}

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++) {
				printf("\n�������%d�����̶Ե�%d����Դ��ռ����:", i + 1, j + 1);
				scanf("%d", &allocation[i][j]);
			}
		}
		for (int i = 0; i < sum; i++)
		for (int j = 0; j < res_sum; j++)
			need[i][j] = max[i][j] - allocation[i][j];
		int allsum[ResNum];
		for (int i = 0; i < res_sum; i++)
			allsum[i] = 0;
		for (int i = 0; i < sum; i++)
		for (int j = 0; j < res_sum; j++)
			allsum[j] = allsum[j] + allocation[i][j];
		for (int j = 0; j < res_sum; j++)
			Available[j] = MaxRes[j] - allsum[j];
		for (int i = 0; i < sum; i++) {
			finish[i] = false;
			_finish[i] = finish[i];
		}
		backupinit();  //��ʼ����ȥ��ֵ.
	}
	pro = true;//�����Ѿ���ʼ�����
}

void display() {//���������Ϣ
	if (pro == true && res == true) {
		printf("������Դ����Ϊ��\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t��%d����Դ", i + 1);
		printf("\n");

		for (int i = 0; i < res_sum; i++)
			printf("\t\t%d", MaxRes[i]);
		printf("\n");

		printf("������Դ����Ϊ��\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t��%d����Դ", i + 1);
		printf("\n");

		for (int i = 0; i < res_sum; i++)
			printf("\t\t%d", Available[i]);
		printf("\n");

		printf("������������Ϊ(max)��\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t��%d����Դ", i + 1);
		printf("\n");

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++)
				printf("\t\t%d", max[i][j]);
			printf("\n");
		}

		printf("����ռ������Ϊ(allocation)��\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t��%d����Դ", i + 1);
		printf("\n");

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++)
				printf("\t\t%d", allocation[i][j]);
			printf("\n");
		}

		printf("������������Ϊ(need)��\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t��%d����Դ", i + 1);
		printf("\n");

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++)
				printf("\t\t%d", need[i][j]);
			printf("\n");
		}
	}                                  //�������� д����
	else {
		printf("���ȳ�ʼ��������Ϣ\n");
	}
}

int banker() {//���м��㷨��ⰲȫ��
	if (res == true && pro == true) {   //��ʼ���ɹ���Ż�ȥ���м��.
		int name[ProNum];  //��ȫ����
		//int j = 0;
		int a = 0;   //�洢��ȫ���еĸ���.
		for (int s = 0; s < sum; s++) {
			for (int i = 0; i < sum; i++) {
				if (finish[i] == false) {  
					for (int j = 0; j < res_sum; j++) {
						if (need[i][j] <= Available[j]) {
							if (j + 1 == res_sum) {
								finish[i] = true;
								name[a] = i + 1;
								a++;
								for (int m = 0; m < res_sum; m++) {
									Available[m] = Available[m] + allocation[i][m];
								}
							}
							else {
								continue;
							}
						}
						else {
							break;
						}
					}   //������forѭ���˳���
				}  //��ǰ�߳��Ѿ�����,��continue.
				else {
					continue;
				}
			}  //�ڶ���forѭ���˳���.

		}  //��1��forѭ���˳���


		//�а�ȫ���е�.
		if (a == sum) {
			printf("��ȫ����Ϊ��");
			for (int j = 0; j < sum; j++)
				printf("P%d ", name[j]);
			printf("\n");
			return 1;
		}
		else {
			printf("��״̬����ȫ\n");
			return 0;
		}
	}
	else {
		printf("���ȳ�ʼ����Ϣ\n");
	}
}

int distribute() {
	   // sum ʵ�ʽ�����   res_sum ʵ����Դ����

	int temporary[3][10] = { 0 }; //ȥ��������Ǹ����������������ռ�к�����Ŀɷ�����Դ
	printf("��������Ҫ�����Ž�������");
	int index = 0;
	scanf("%d", &index);
	index = index - 1;
	int request[10] = {0};
	printf("���������������Դ��");
	for (int i = 0; i < res_sum; i++){
		scanf("%d", &request[i]);
	}
	//ȥ������ԴУ�飬���������ж���.
	int judge = 0; //Ϊ1��ͨ��.
	//1.�͸ý��̵�����ȥУ��.
	for (int i = 0; i < res_sum; i++){
		if (request[i] > need[index][i]){
			judge = 1; //����
		}
	}
	//2.ȥ�жϸ�����ͨ��1Ҫ����û,��ȥ������ԴУ��2,ͨ���͸ı�ֵ.
	if (judge == 1){
		printf("�������޷�ͨ���ý��̵�����(need)����");
		return 0;
	}
	else{
		//ͨ����
		int i;
		for (i = 0; i < res_sum; i++){
			if (request[i] > Available[i]){
				break;
			}
		}
		//���ڶ�����˭ͨ����.
		//ͨ����
		if (i >= res_sum){
			//1.ȥ�޸����������и������ֵ.
			for (int z = 0; z < res_sum; z++){
				temporary[0][z] = need[index][z]; //��0�д�����
				need[index][z] -= request[z];
			}
			//2.��ȥ�޸Ŀɷ�����Դ����ֵ.��ռ����Ҳ�øı�
			for (int z = 0; z < res_sum; z++){
				temporary[1][z] = Available[z]; //�ڶ���ȥ��ɷ����
				Available[z] -= request[z];
			}
			//�޸ĸý���ռ����

			for (int z = 0; z < res_sum; z++){
				temporary[2][z] = allocation[index][z]; //�����д�ռ����
				allocation[index][z] += request[z];
			}
			//3.���а�ȫ�Լ���.
			//Ϊtrue�ͳ��˷���true�������ȫ����
			for (int i = 0; i < sum; i++){
				finish[i] = false;
			}
			if (banker()) {
				printf("������ɹ���������"); 
				for (int i = 0; i < res_sum; i++){
					Available[i] = temporary[1][i] - request[i];   //����Available��ֵ.
				}
				//�������ж� need Ϊ 0 0 0ʱ�Ķ���.
				int a = 0;
				for (a = 0; a < res_sum; a++){
					if (need[index][a] != 0){
						break;
					}
				}
				if (a == res_sum){
					for (int i = 0; i < res_sum; i++){
						Available[i] = allocation[index][i];
						allocation[index][i] = 0;
					}
				}
				return 1;
			}
			else{
				//������ֵ�޸Ļ�ȥ
				for (int b = 0; b < res_sum; b++){
					need[index][b] = temporary[0][b];
					Available[b] = temporary[1][b];
					allocation[index][b] = temporary[2][b];
				}
				printf("������ͨ����,�����ް�ȫ����");
				return 0;
			}
		}
		else{
			printf("�������޷�ͨ����������Դ��(available)���������");
			return 0;
		}
	}
}

void main() {
	init();
	int option;
	printf("*********���м��㷨*********\n");
	printf("1:��������Դ����\n");
	printf("2:�༭������Ϣ\n");
	printf("3:�鿴��Դ��Ϣ\n");
	printf("4:��鵱ǰ״̬��ȫ��\n");
	printf("5:��������Ԥ����\n");
	printf("����������ѡ�����\n");
	printf("*********���м��㷨*********\n");
	while (1) {
		scanf("%d", &option);
		printf("\n");
		switch (option) {
		case 1: initRes(); break;
		case 2: initPro(); break;
		case 3: display(); break;
		case 4: banker(); release(); break;//�ж����ָ�ԭ״̬
		case 5: distribute(); break;
		}
		printf("�����ѡ�������");
	}
	system("pause");
}