#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>
////.实现一个通讯录；
////通讯录可以用来存储1000个人的信息，每个人的信息包括：
////姓名、性别、年龄、电话、住址
////1.	添加联系人信息
////2.	删除指定联系人信息
////3.	查找指定联系人信息
////4.	修改指定联系人信息
////5.	显示所有联系人信息
////6.	清空所有联系人
////7.	以名字排序所有联系人
#define Name 5
#define Sex  4
#define Phone 20
#define Address 20
#define Per 1000
#define MAX_STR  1000
int j = 0;

typedef struct inform{
	char name[Name];
	char sex[Sex];
	int age;
	char phone[Phone];
	char address[Address];
}inform;

typedef struct Contacts{
	inform per[Per];
	int num;
} Contacts;




void Init(Contacts *p){
	assert(p != NULL);
	p->num = 0;
	memset(p->per, 0, sizeof(p));
}
void Define(Contacts *p){
	if (p->num == Per){
		printf("通讯录已满\n");
		return;
	}
	printf("姓名：");
	scanf("%s", p->per[p->num].name);
	printf("性别:");
	scanf("%s", p->per[p->num].sex);
	printf("年龄:");
	scanf("%d", &p->per[p->num].age);
	printf("电话:");
	scanf("%s", p->per[p->num].phone);
	printf("住址:");
	scanf("%s", p->per[p->num].address);
	++(p->num);
	printf("添加成功\n");
}
int Find(Contacts *p){
	char search[20] = { 0 };
	assert(p != NULL);
	if (p->num == 0){
		printf("还没有录入信息\n");
		return -1;
	}
	printf("输入联系人姓名：");
	scanf("%s", search);
	for (j = 0; j < p->num; j++){
		if (strcmp(search, p->per[j].name) == 0){
			return j;
		}
	}
	if (p->num == 0){
		printf("无这个联系人");
		return -1;
	}
}
void Delete(Contacts *p){
	assert(p != NULL);
	int ret = Find(p);
	if (ret == -1){
		printf("无这个联系人\n");
		return;
	}
	if (ret != p->num - 1){
		strcpy(p->per[ret].address, p->per[p->num - 1].address);
		p->per[ret].age = p->per[p->num - 1].age;
		strcpy(p->per[ret].name, p->per[p->num - 1].name);
		strcpy(p->per[ret].sex, p->per[p->num - 1].sex);
		strcpy(p->per[ret].phone, p->per[p->num - 1].phone);
	}
	p->num--;
	printf("删除成功\n");
}
void Clear(Contacts *p){
	assert(p != NULL);
	if (p->num == 0){
		printf("还没有录入信息\n");
		return -1;
	}
	Init(p);
	printf("清除完毕\n");
}
void Show(Contacts *p){
	assert(p != NULL);
	if (p->num == 0){
		printf("未录入\n");
		return;
	}
	for (int i = 0; i < p->num; i++){
		printf("%s    ", p->per[i].name);
		printf("%s    ", p->per[i].sex);
		printf("%d    ", p->per[i].age);
		printf("%s    ", p->per[i].phone);
		printf("%s    ", p->per[i].address);
		printf("\n");
	}
}
void Change(Contacts *p){
	assert(p != NULL);
	int ret = Find(p);
	if (ret == -1){
		printf("无这个联系人\n");
		return;
	}
	printf("姓名更改(*不更改):");
	char tem[20] = { 0 };
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].name, tem);
	}
	printf("性别更改(*不更改):");
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].sex, tem);
	}
	printf("年龄更改(0不更改):");
	int num = 0;
	scanf("%d", &num);
	if (num != 0){
		p->per[ret].age = num;
	}
	printf("电话更改(*不更改):");
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].phone, tem);
	}
	printf("地址更改(*不更改):");
	scanf("%s", tem);
	if ((strcmp(tem, "*")) != 0){
		strcpy(p->per[ret].address, tem);
	}
	
}
void Sort(Contacts *p){

	assert(p != NULL);
	Contacts con1;
	Contacts *p1 = &con1;
	if (p->num == 0){
		printf("未录入\n");
		return;
	}
	for (int i = 0; i < p->num - 1; i++){
		for (int j = 0; j < p->num - i - 1; j++){
			if ((strcmp(p->per[j].name, p->per[j + 1].name)) > 0){
				{
					strcpy(p1->per[0].address, p->per[j].address);
					p1->per[0].age = p->per[j].age;
					strcpy(p1->per[0].name, p->per[j].name);
					strcpy(p1->per[0].sex, p->per[j].sex);
					strcpy(p1->per[0].phone, p->per[j].phone);
				}
				{
					strcpy(p->per[j].address, p->per[j + 1].address);
					p->per[j].age = p->per[j + 1].age;
					strcpy(p->per[j].name, p->per[j + 1].name);
					strcpy(p->per[j].sex, p->per[j + 1].sex);
					strcpy(p->per[j].phone, p->per[j + 1].phone);
				}
				{
					strcpy(p->per[j + 1].address, p1->per[0].address);
					p->per[j + 1].age = p1->per[0].age;
					strcpy(p->per[j + 1].name, p1->per[0].name);
					strcpy(p->per[j + 1].sex, p1->per[0].sex);
					strcpy(p->per[j + 1].phone, p1->per[0].phone);
				}
			}
		}
	}
	printf("排序成功\n");
}
void start(){
	printf("********************************************************\n");
	printf("1.添加联系人信息\n");
	printf("2.查找联系人信息\n");
	printf("3.删除联系人信息\n");
	printf("4.更改联系人信息\n");
	printf("5.展示联系人信息\n");
	printf("6.排序联系人信息\n");
	printf("7.清除联系人信息\n");
	printf("8.完毕\n");
	printf("********************************************************\n");
	void(*p[])(Contacts *p) = {NULL,Define,Find,Delete, Change, Show,Sort, Clear };
	Contacts con;
	int choice = 0;
	Init(&con);
	while (1){
		printf("请输入你要进行的操作: ");
		scanf("%d", &choice);
		if (choice == 8){
			printf("退出通讯录\n");
			break;
		}
		else if (choice < 0 || choice > 7){
			continue;
		}
		else if (choice > 0 && choice <= 7){
			p[choice](&con);
			if (choice == 2){
				printf("姓名是 %s\n", con.per[j].name);
				printf("性别是 %s\n", con.per[j].sex);
				printf("年龄是 %d\n", con.per[j].age);
				printf("电话是 %s\n", con.per[j].phone);
				printf("地址是 %s\n", con.per[j].address);
			}
		}
		else{
			printf("输入有误\n");
			break;
		}
	}
}
int main(){
	start();
	system("pause");
	return 0;

}





void delete(Contacts *p){
	char delete[20];
	printf("你要删除的联系人姓名：");
	scanf("%s", delete[20]);
	while (p->num >= 0){
		if (!(strcpy(delete[20], p->per[p->num].name))){
			memset(p->per, 0, sizeof(p->per[p->num]));
			printf("已删除\n");
			break;
		}
		(p->num)--;
	}
	if (p->num == 0){
		printf("无这个联系人");
	}

}

