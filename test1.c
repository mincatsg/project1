//#define  _CRT_SECURE_NO_WARNINGS
//#include<stdio.h>
//#include<stdlib.h>
//#define true 1
//#define false 0
//#define max_process 100
//#define max_source 100
//int p[max_process];                             //��¼����
//int Max[max_process][max_source]; //����������
//int Allocation[max_process][max_source]; //�ѷ������
//int Need[max_process][max_source]; //�������
//int Available[max_source]; //������Դ����
//int Sum[max_process][max_source];
//int Work[max_process][max_source];
//int Finish[max_source];
//int Request[max_process][max_source];
//int a = 0;
//int b = 0;
//void init(){
//	printf("��������Ľ��̸���\n");
//	scanf("%d", &a);
//	printf("�����������Դ������\n");
//	scanf("%d", &b);
//	printf("������ÿ����������������Դ��Ŀ\n");
//	for (int i = 0; i < a; i++){
//		for (int j = 0; j < b; j++){
//			scanf("%d", &Max[i][j]);
//		}
//	}
//	printf("������ÿ�������ѷ���ĸ���Դ��Ŀ\n");
//	for (int i = 0; i < a; i++){
//		for (int j = 0; j < b; j++){
//			scanf("%d", &Allocation[i][j]);
//			Need[i][j] = Max[i][j] - Allocation[i][j];
//		}
//	}
//	printf("�����������Դ��������Ŀ\n");
//	for (int i = 0; i < b; i++){
//		scanf("%d", &Available[i]);
//	}
//	printf("������              Max                 Allocation              Need            Available  ");
//	printf("\n");
//	for (int i = 0; i < a; i++){
//		printf("%d ", i);
//		printf("                  ");
//		for (int j = 0; j < b; j++){
//			printf("%d ", Max[i][j]);
//		}
//		printf("                 ");
//		for (int j = 0; j < b; j++){
//			printf("%d ", Allocation[i][j]);
//		}
//		printf("              ");
//		for (int k = 0; k < b; k++){
//			printf("%d ", Need[i][k]);
//		}
//		if (i == 0){
//			printf("              ");
//			for (int k = 0; k < b; k++){
//				printf("%d ", Available[k]);
//			}
//		}
//		printf("\n");
//	}
//}
//int testing(){   //��ȫ���㷨
//	{
//		for (int m = 0; m < a; m++){
//			p[m] = 999;
//		}
//		int i, j, k, l = 0;
//		int h = 1;
//		int Work[max_source]; //��������,����ʾϵͳ���ṩ�����̼�����������ĸ�����Դ��Ŀ  
//		int Finish[max_process];  //ϵͳ�Ƿ����㹻����Դ��������̣�ʹ֮������� 
//		for (i = 0; i < b; i++)   //���������ʼ�� 
//		{
//			Work[i] = Available[i];
//			Sum[0][i] = Work[i];
//		}
//		//Finishÿ�������Ƿ�ȫ
//		for (i = 0; i < a; i++)
//		{
//			Finish[i] = 0;
//		}
//		for (i = 0; i < a; i++) //a �ǽ��̸��� b ����Դ������
//		{
//			if (Finish[i]) continue;
//			for (j = 0; j<b; j++)//ѭ�����ҵ�i��������Ҫ�ĸ�����Դ���Ƿ񳬹�ϵͳ���еĶ�Ӧ����Դ��  
//			{
//				//��i��������Ҫ�ĵ�j����Դ�� �� ϵͳ���еĵ�j����Դ�� 
//				if (Need[i][j]>Work[j]) break;
//			}
//			if (j == b)//�����i����������ĸ�����Դ����û�г���ϵͳ���еĶ�Ӧ��Դ��  
//			{
//				Finish[i] = 1;//���ý��̵�FINISH���Ϊtrue  
//				for (k = 0; k < b; k++)
//				{
//					Work[k] += Allocation[i][k];//��Work��ֵΪ ��i�����̸����ѷ�����Դ����ϵͳ���еĶ�Ӧ��Դ��(��Ϊ���Ľ���ȫ����Դ��������ʱ�߳̽���������Դ������ϵͳ) 
//				}
//				p[l++] = i;//��¼���̺�  
//				i = -1;  //�н��̳ɹ��ͷ���ѭ��
//			}
//			else continue; //�����������ѭ����һ������ 
//			if (l == a)//�����н��̶��ܹ�����������ʱ  
//			{
//				printf("ϵͳ�ǰ�ȫ��\n");
//				printf("��ȫ����Ϊ:\n");
//				for (k = 0; k < l - 1; k++)
//				{
//					printf("%d-->", p[k]);
//				}
//				printf("%d\n", p[l - 1]);
//				return true;
//			}
//		}
//		//����ȫ��
//		int arr[10];
//		for (int z = 0; z < 10; z++){
//			arr[z] = 66;
//		}
//		int z;
//		int count = 0;
//		for (int x = 0; x < a; x++){
//			for (z = 0; z < a; z++){
//				if (x == p[z]){
//					break;
//				}
//			}
//			if (z >= a){
//				arr[count++] = x;
//			}
//		}
//		printf("ϵͳ�ǲ���ȫ�ģ�û����ɵĽ�������Ϊ\n");
//		for (int m = 0; m < count; m++){
//			printf("%d ", arr[m]);
//		}
//		printf("\n");
//		return false;
//	}
//}
//int Bank()                //���м��㷨  
//{
//	int i, num;
//	while (1)
//	{
//		printf("������Ҫ������Դ�Ľ��̺�(ע:��1�����̺�Ϊ0,��������)");
//		scanf("%d", &num);
//		printf("���������������ĸ���Դ������:\n");
//		for (i = 0; i<b; i++)
//		{
//			scanf("%d", &Request[num][i]);
//			if (Request[num][i]>Need[num][i])//����û�ѡ����̵߳ĵ�i����Դ�����������̸߳���Դ���������  
//			{
//				printf("������������������ý��̶Ը���Դ��������!����������!");
//				i--;
//				return 0;
//			}
//			if (Request[num][i]>Available[i])//����û�ѡ����̵߳ĵ�i����Դ��������ϵͳ���еĵ�i����Դ������  
//			{
//				printf("�����������������ϵͳӵ�и���Դ����Ŀ!����������!");
//				i--;
//				return 0;
//			}
//			//��������������ִ��
//			Available[i] -= Request[num][i];//ϵͳ������Դ��ȥ�����˵�  
//			Allocation[num][i] += Request[num][i];//�̱߳��������Դ�����������˵�  
//			Need[num][i] -= Request[num][i];//�̻߳���Ҫ����Դ��ȥ������õ���  
//		}
//		if (testing())//AVAILABLE  ALLOCATION  NEED�䶯֮���Ƿ�ᵼ�²���ȫ  
//		{
//			printf("ͬ���������!\n");
//			return 0;
//		}
//		else
//		{
//			printf("�������󱻾ܾ�!\n");
//			for (i = 0; i<b; i++)
//			{
//				Available[i] += Request[num][i];
//				Allocation[num][i] -= Request[num][i];
//				Need[num][i] += Request[num][i];
//			}
//			return 0;
//		}
//	}
//}
//int main(){
//	while (true){
//		printf("******************************\n");
//		printf("**********1.��ʼ������*******\n");
//		printf("*********2.���м��㷨********\n");
//		printf("*********3.��ȫ�Լ��********\n");
//		printf("************5.�˳�***********\n");
//		printf("�������������");
//		int choice = 0;
//		scanf("%d", &choice);
//		if (choice == 1){
//			init();
//		}
//		else if (choice == 2){
//			Bank();
//		}
//		else if (choice == 3){
//			testing();
//		}
//		else if (choice == 5){
//			break;
//		}
//	}
//	return 0;
//}
