//#define  _CRT_SECURE_NO_WARNINGS
//#include<stdio.h>
//#include<stdlib.h>
//#define true 1
//#define false 0
//#define max_process 100
//#define max_source 100
//int p[max_process];                             //记录序列
//int Max[max_process][max_source]; //最大需求矩阵
//int Allocation[max_process][max_source]; //已分配矩阵
//int Need[max_process][max_source]; //需求矩阵
//int Available[max_source]; //可用资源数组
//int Sum[max_process][max_source];
//int Work[max_process][max_source];
//int Finish[max_source];
//int Request[max_process][max_source];
//int a = 0;
//int b = 0;
//void init(){
//	printf("请输入你的进程个数\n");
//	scanf("%d", &a);
//	printf("请输入你的资源种类数\n");
//	scanf("%d", &b);
//	printf("请输入每个进程最多所需的资源数目\n");
//	for (int i = 0; i < a; i++){
//		for (int j = 0; j < b; j++){
//			scanf("%d", &Max[i][j]);
//		}
//	}
//	printf("请输入每个进程已分配的各资源数目\n");
//	for (int i = 0; i < a; i++){
//		for (int j = 0; j < b; j++){
//			scanf("%d", &Allocation[i][j]);
//			Need[i][j] = Max[i][j] - Allocation[i][j];
//		}
//	}
//	printf("请输入各个资源的现有数目\n");
//	for (int i = 0; i < b; i++){
//		scanf("%d", &Available[i]);
//	}
//	printf("进程名              Max                 Allocation              Need            Available  ");
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
//int testing(){   //安全性算法
//	{
//		for (int m = 0; m < a; m++){
//			p[m] = 999;
//		}
//		int i, j, k, l = 0;
//		int h = 1;
//		int Work[max_source]; //工作数组,他表示系统可提供给进程继续运行所需的各类资源数目  
//		int Finish[max_process];  //系统是否有足够的资源分配给进程，使之运行完成 
//		for (i = 0; i < b; i++)   //工作数组初始化 
//		{
//			Work[i] = Available[i];
//			Sum[0][i] = Work[i];
//		}
//		//Finish每个进程是否安全
//		for (i = 0; i < a; i++)
//		{
//			Finish[i] = 0;
//		}
//		for (i = 0; i < a; i++) //a 是进程个数 b 是资源种类数
//		{
//			if (Finish[i]) continue;
//			for (j = 0; j<b; j++)//循环查找第i个进程需要的各个资源数是否超过系统现有的对应的资源数  
//			{
//				//第i个进程需要的第j个资源数 ＞ 系统现有的第j个资源数 
//				if (Need[i][j]>Work[j]) break;
//			}
//			if (j == b)//如果第i个进程所需的各个资源数都没有超过系统现有的对应资源数  
//			{
//				Finish[i] = 1;//给该进程的FINISH标记为true  
//				for (k = 0; k < b; k++)
//				{
//					Work[k] += Allocation[i][k];//将Work赋值为 第i个进程各个已分配资源数＋系统现有的对应资源数(因为当改进程全部资源数都满足时线程结束并将资源返还给系统) 
//				}
//				p[l++] = i;//记录进程号  
//				i = -1;  //有进程成功就反复循环
//			}
//			else continue; //如果超过继续循环下一个进程 
//			if (l == a)//当所有进程都能够被满足运行时  
//			{
//				printf("系统是安全的\n");
//				printf("安全序列为:\n");
//				for (k = 0; k < l - 1; k++)
//				{
//					printf("%d-->", p[k]);
//				}
//				printf("%d\n", p[l - 1]);
//				return true;
//			}
//		}
//		//不安全的
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
//		printf("系统是不安全的，没有完成的进程序列为\n");
//		for (int m = 0; m < count; m++){
//			printf("%d ", arr[m]);
//		}
//		printf("\n");
//		return false;
//	}
//}
//int Bank()                //银行家算法  
//{
//	int i, num;
//	while (1)
//	{
//		printf("请输入要申请资源的进程号(注:第1个进程号为0,依次类推)");
//		scanf("%d", &num);
//		printf("请输入进程所请求的各资源的数量:\n");
//		for (i = 0; i<b; i++)
//		{
//			scanf("%d", &Request[num][i]);
//			if (Request[num][i]>Need[num][i])//如果用户选择的线程的第i个资源请求数＞该线程该资源所需的数量  
//			{
//				printf("您输入的请求数超过该进程对该资源的需求量!请重新输入!");
//				i--;
//				return 0;
//			}
//			if (Request[num][i]>Available[i])//如果用户选择的线程的第i个资源请求数＞系统现有的第i个资源的数量  
//			{
//				printf("您输入的请求数超过系统拥有该资源的数目!请重新输入!");
//				i--;
//				return 0;
//			}
//			//如果请求合理，接着执行
//			Available[i] -= Request[num][i];//系统可用资源减去申请了的  
//			Allocation[num][i] += Request[num][i];//线程被分配的资源加上已申请了的  
//			Need[num][i] -= Request[num][i];//线程还需要的资源减去已申请得到的  
//		}
//		if (testing())//AVAILABLE  ALLOCATION  NEED变动之后，是否会导致不安全  
//		{
//			printf("同意分配请求!\n");
//			return 0;
//		}
//		else
//		{
//			printf("您的请求被拒绝!\n");
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
//		printf("**********1.初始化数据*******\n");
//		printf("*********2.银行家算法********\n");
//		printf("*********3.安全性检测********\n");
//		printf("************5.退出***********\n");
//		printf("请输入你的请求");
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
