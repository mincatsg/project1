//1.��д������
//unsigned int reverse_bit(unsigned int value);
//��������ķ���ֵvalue�Ķ�����λģʽ�����ҷ�ת���ֵ��
//
//�磺
//��32λ������25���ֵ�������и�λ��
//00000000000000000000000000011001
//��ת�󣺣�2550136832��
//10011000000000000000000000000000
//���������أ�
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

//2.��ʹ�ã�a + b�� / 2���ַ�ʽ������������ƽ��ֵ��
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
//3.���ʵ�֣�
//һ��������ֻ��һ�����ֳ�����һ�Ρ������������ֶ��ǳɶԳ��ֵġ�
//���ҳ�������֡���ʹ��λ���㣩

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
//��һ���ַ����������Ϊ:"student a am i",
//	���㽫��������ݸ�Ϊ"i am a student".
//	Ҫ��
//	����ʹ�ÿ⺯����
//	ֻ�ܿ������޸��ռ䣨�ռ�������ַ����ĳ����޹أ���
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


			//��������ʹ����ȫ����λ��ż��ǰ�档

			//	��Ŀ��

			//	����һ���������飬ʵ��һ��������
			//	�����������������ֵ�˳��ʹ�����������е�����λ�������ǰ�벿�֣�
			//	����ż��λ������ĺ�벿�֡�

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

			/*���Ͼ���*/
				int Reseach_sou(int arr[][3], int row, int col, int key)
			{
					int i = 0;
					int j = col - 1;
					//�ӵ�һ��,���һ�п�ʼѰ��
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
				printf("������Ҫ�ҵ�����:");
				scanf("%d", &key);
				if (Reseach_sou(arr, row, col, key)){
					printf("�ҵ���\n");
				}
				else{
					printf("û���ҵ�\n");
				}
				system("pause");
				return 0;
			}


