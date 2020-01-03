//1.编写函数：
//unsigned int reverse_bit(unsigned int value);
//这个函数的返回值value的二进制位模式从左到右翻转后的值。
//
//如：
//在32位机器上25这个值包含下列各位：
//00000000000000000000000000011001
//翻转后：（2550136832）
//10011000000000000000000000000000
//程序结果返回：
//2550136832

unsigned int reverse_bit(unsigned int value){
	unsigned int tmp, sum = 0;
	for (int i = 0; i < 32; i++, value /= 2){
		tmp = value % 2;
		sum = sum * 2 + tmp;
	}
	return sum;
}
int main(){
	printf("%u\n", reverse_bit(25));
	system("pause");
	return 0;
}

//2.不使用（a + b） / 2这种方式，求两个数的平均值。
int average(int *a, int *b){
	*a = *a ^ *b;
	*b = *a ^ *b;
	*a = *a ^ *b;
	printf("%d %d", *a, *b);
}
int main(){
	int a, b;
	scanf("%d%d", &a, &b);
	average(&a, &b);
	system("pause");
	return 0;
}
//
//3.编程实现：
//一组数据中只有一个数字出现了一次。其他所有数字都是成对出现的。
//请找出这个数字。（使用位运算）

int main(){
	int a[10] = { 5, 1, 1, 2, 3, 3, 2, 4, 4 };
	int temp = 0;
	for (int i = 0; i < sizeof(a) / sizeof(a[0]); i++){
		temp ^= a[i];
	}
	printf("%d\n", temp);
	system("pause");
	return 0;
}
//有一个字符数组的内容为:"student a am i",
//	请你将数组的内容改为"i am a student".
//	要求：
//	不能使用库函数。
//	只能开辟有限个空间（空间个数和字符串的长度无关）。
//
//	student a am i
//	i ma a tneduts
//	i am a student


	void reverse(char *left, char *right){
		char temp;
		while (left < right){
			temp = *right;
			*right = *left;
			*left = temp;
			left++;
			right--;
		}
	}
			void reverse_str(char arr[], int sz)
			{
				char *left = arr;
				char *right = arr + sz - 1;
				char *start = arr;
				char *end = arr;
				reverse(left, right);
				printf("%s\n", arr);
				while (*end != '\0')
				{
					while ((*end != ' ') && (*end != '\0'))
					{
						end++;
					}
					reverse(start, end - 1);
					if (*end != '\0')
					{
						start = end + 1;
						end = start;
					}
				}
			}
			int main()
			{
				char arr[] = "student a am i";
				int sz = sizeof(arr) / sizeof(arr[0]) - 1;
				reverse_str(arr, sz);
				printf("%s\n", arr);
				system("pause");
				return 0;
			}


			//调整数组使奇数全部都位于偶数前面。

			//	题目：

			//	输入一个整数数组，实现一个函数，
			//	来调整该数组中数字的顺序使得数组中所有的奇数位于数组的前半部分，
			//	所有偶数位于数组的后半部分。

				void Sort(int num[], int len) {
					for (int i = 0; i < len - 1; ++i) {
						for (int j = 0; j < len - i - 1; ++j) {
							if (num[j] % 2 == 0 && num[j + 1] % 2 != 0) {
								int tmp = num[j];
								num[j] = num[j + 1];
								num[j + 1] = tmp;
							}
						}
					}
				}
			int main() {
				int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
				Sort(num, sizeof(num) / sizeof(int));
				for (int i = 0; i < sizeof(num) / sizeof(int); ++i) {
					printf("%d ", num[i]);
				}
				printf("\n");
				system("pause");
				return 0;
			}

			/*杨氏矩阵*/
				int Reseach_sou(int arr[][3], int row, int col, int key)
			{
					int i = 0;
					int j = col - 1;
					//从第一行,最后一列开始寻找
					while ((j >= 0) && (i <= 2))
					{
						if (arr[i][j] == key){
							return 1;
						}
						else if (arr[i][j] < key){
							i++;
						}
						else{
							j--;
						}
					}
					return 0;
				}
			int main()
			{
				int arr[][3] = { 1, 2, 3, 2, 3, 4, 3, 4, 5 };
				int key = 0;
				int row = 3;
				int col = 3;
				printf("输入你要找的数字:");
				scanf("%d", &key);
				if (Reseach_sou(arr, row, col, key)){
					printf("找到了\n");
				}
				else{
					printf("没有找到\n");
				}
				system("pause");
				return 0;
			}


