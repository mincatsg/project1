#define  _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define ProNum 100
#define ResNum 100
int sum;//实际进程个数
int res_sum;//实际资源个数
int allocation[ProNum][ResNum];//每个进程已分配资源个数
int max[ProNum][ResNum];//每个进程最大需求
int need[ProNum][ResNum];//每个进程尚需多少资源
int Available[ResNum];//可用资源的个数
int MaxRes[ResNum];//所有资源的所有个数
bool finish[ProNum];
bool res = false;//资源是否初始化
bool pro = false;//进程是否初始化

int _allocation[ProNum][ResNum];//每个进程已分配资源个数
int _need[ProNum][ResNum];//每个进程尚需多少资源
int _Available[ResNum];//可用资源的个数
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

void backupinit() {  //存放安全序列前的值.
	int i, j;
	for (i = 0; i < sum; i++)
	for (j = 0; j < res_sum; j++) {
		_allocation[i][j] = allocation[i][j];
		_need[i][j] = need[i][j];
		_Available[j] = Available[j];
	}
}

void release() {  //把存放的值弄回来 并且设置为不安全.
	int i, j;
	for (i = 0; i < ProNum; i++)
	for (j = 0; j < ResNum; j++) {
		allocation[i][j] = _allocation[i][j];
		need[i][j] = _need[i][j];
		Available[j] = _Available[j];
		finish[j] = false;
	}
}

void initRes() {//初始化资源个数
	printf("请输入资源种数:");
	scanf("%d", &res_sum);
	for (int i = 0; i < res_sum; i++) {
		printf("请输入第%d类资源总数:", i + 1);
		scanf("%d", &MaxRes[i]);
		printf("\n");
	}
	res = true;//资源已经初始化完成
}

void initPro() {//初始化进程信息	
	if (res == false) {
		printf("请初始化资源信息\n");
	}
	else if (res == true) {
		printf("请输入进程个数:");
		scanf("%d", &sum);
		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++) {
				printf("\n请输入第%d个进程对第%d个资源的最大需求量:", i + 1, j + 1);
				scanf("%d", &max[i][j]);
			}
		}

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++) {
				printf("\n请输入第%d个进程对第%d个资源的占有量:", i + 1, j + 1);
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
		backupinit();  //初始化后去存值.
	}
	pro = true;//进程已经初始化完成
}

void display() {//输出所有信息
	if (pro == true && res == true) {
		printf("所有资源总数为：\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t第%d类资源", i + 1);
		printf("\n");

		for (int i = 0; i < res_sum; i++)
			printf("\t\t%d", MaxRes[i]);
		printf("\n");

		printf("可用资源总数为：\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t第%d类资源", i + 1);
		printf("\n");

		for (int i = 0; i < res_sum; i++)
			printf("\t\t%d", Available[i]);
		printf("\n");

		printf("进程需求总数为(max)：\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t第%d类资源", i + 1);
		printf("\n");

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++)
				printf("\t\t%d", max[i][j]);
			printf("\n");
		}

		printf("进程占有总数为(allocation)：\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t第%d类资源", i + 1);
		printf("\n");

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++)
				printf("\t\t%d", allocation[i][j]);
			printf("\n");
		}

		printf("进程尚需总数为(need)：\n");
		for (int i = 0; i < res_sum; i++)
			printf("\t第%d类资源", i + 1);
		printf("\n");

		for (int i = 0; i < sum; i++) {
			for (int j = 0; j < res_sum; j++)
				printf("\t\t%d", need[i][j]);
			printf("\n");
		}
	}                                  //垃圾代码 写你妈
	else {
		printf("请先初始化进程信息\n");
	}
}

int banker() {//银行家算法检测安全性
	if (res == true && pro == true) {   //初始化成功后才会去进行检测.
		int name[ProNum];  //安全队列
		//int j = 0;
		int a = 0;   //存储安全序列的个数.
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
					}   //第三个for循环退出点
				}  //当前线程已经存在,就continue.
				else {
					continue;
				}
			}  //第二个for循环退出点.

		}  //第1个for循环退出点


		//判安全序列的.
		if (a == sum) {
			printf("安全序列为：");
			for (int j = 0; j < sum; j++)
				printf("P%d ", name[j]);
			printf("\n");
			return 1;
		}
		else {
			printf("该状态不安全\n");
			return 0;
		}
	}
	else {
		printf("请先初始化信息\n");
	}
}

int distribute() {
	   // sum 实际进程数   res_sum 实际资源总数

	int temporary[3][10] = { 0 }; //去存请求的那个最初的需求和最初的占有和最初的可分配资源
	printf("请输入你要给几号进程请求");
	int index = 0;
	scanf("%d", &index);
	index = index - 1;
	int request[10] = {0};
	printf("请输入你的请求资源数");
	for (int i = 0; i < res_sum; i++){
		scanf("%d", &request[i]);
	}
	//去进行资源校验，继续设置判断器.
	int judge = 0; //为1就通过.
	//1.和该进程的请求去校验.
	for (int i = 0; i < res_sum; i++){
		if (request[i] > need[index][i]){
			judge = 1; //不过
		}
	}
	//2.去判断该请求通过1要求了没,在去进行资源校验2,通过就改变值.
	if (judge == 1){
		printf("该请求无法通过该进程的需求(need)检验");
		return 0;
	}
	else{
		//通过了
		int i;
		for (i = 0; i < res_sum; i++){
			if (request[i] > Available[i]){
				break;
			}
		}
		//看第二轮有谁通过了.
		//通过了
		if (i >= res_sum){
			//1.去修改需求数组中该请求的值.
			for (int z = 0; z < res_sum; z++){
				temporary[0][z] = need[index][z]; //第0行存需求
				need[index][z] -= request[z];
			}
			//2.再去修改可分配资源数的值.和占有数也得改变
			for (int z = 0; z < res_sum; z++){
				temporary[1][z] = Available[z]; //第二行去存可分配的
				Available[z] -= request[z];
			}
			//修改该进程占有量

			for (int z = 0; z < res_sum; z++){
				temporary[2][z] = allocation[index][z]; //第三行存占有量
				allocation[index][z] += request[z];
			}
			//3.进行安全性检验.
			//为true就成了返回true并输出安全序列
			for (int i = 0; i < sum; i++){
				finish[i] = false;
			}
			if (banker()) {
				printf("该请求成功！！！！"); 
				for (int i = 0; i < res_sum; i++){
					Available[i] = temporary[1][i] - request[i];   //更新Available的值.
				}
				//下面是判断 need 为 0 0 0时的东西.
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
				//把所有值修改回去
				for (int b = 0; b < res_sum; b++){
					need[index][b] = temporary[0][b];
					Available[b] = temporary[1][b];
					allocation[index][b] = temporary[2][b];
				}
				printf("该请求通过了,但是无安全序列");
				return 0;
			}
		}
		else{
			printf("该请求无法通过可利用资源数(available)的需求检验");
			return 0;
		}
	}
}

void main() {
	init();
	int option;
	printf("*********银行家算法*********\n");
	printf("1:请输入资源总数\n");
	printf("2:编辑进程信息\n");
	printf("3:查看资源信息\n");
	printf("4:检查当前状态安全性\n");
	printf("5:进程申请预分配\n");
	printf("请输入数字选择操作\n");
	printf("*********银行家算法*********\n");
	while (1) {
		scanf("%d", &option);
		printf("\n");
		switch (option) {
		case 1: initRes(); break;
		case 2: initPro(); break;
		case 3: display(); break;
		case 4: banker(); release(); break;//判断完后恢复原状态
		case 5: distribute(); break;
		}
		printf("请继续选择操作：");
	}
	system("pause");
}