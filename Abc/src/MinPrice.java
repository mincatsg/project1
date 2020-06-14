import java.util.Scanner;

class Commodity{
    int piece;//��������
    int price;//����۸�
}

public class MinPrice {
    private static int MAXCODE = 999;//��Ʒ��������ֵ
    private static int SALECOMB = 99;//�Ż���Ʒ�����
    private static int KIND = 5;     //��Ʒ����
    private static int QUANTITY = 5; //����ĳ����Ʒ���������ֵ

    private static int b;//������Ʒ������
    private static int s;//��ǰ�Ż������
    private static int[] num = new int[MAXCODE+1];//��¼��Ʒ��������Ʒ����Ķ�Ӧ��ϵ
    private static int[] product = new int[KIND+1];//��¼��ͬ������Ʒ�Ĺ�������
    private static int[][] offer = new int[SALECOMB+1][KIND+1];//offer[i][j]: ��Ʒ��ϵ��Żݼ�(j=0)��ĳ���Ż������ĳ����Ʒ��Ҫ���������(j>0)
    private static Commodity[] purch = new Commodity[KIND+1];//��¼��ͬ��Ʒ�Ĺ��������͹���۸�
    private static int[][][][][] cost = new int[QUANTITY+1][QUANTITY+1][QUANTITY+1][QUANTITY+1][QUANTITY+1];//��¼���ι�����ܻ���

    private static void init(){
        Scanner input = new Scanner(System.in);

        int i,j,n,p,t,code;
        //��0��ʼ��
        for(i=0; i<100; i++)
            for(j=0; j<6; j++)
                offer[i][j] = 0;
        for(i=0; i<6; i++){
            purch[i] = new Commodity();
            purch[i].piece = 0;
            purch[i].price = 0;
            product[i] = 0;
        }

        //�ӿ���̨¼������
        b = input.nextInt();  //������Ʒ����
        for(i=1; i<=b; i++){
            code = input.nextInt();
            purch[i].piece = input.nextInt();
            purch[i].price = input.nextInt();
            num[code] = i;//һ������ʵ�ֵĹ�ϣ��Ŀ������O(1)��ʱ�临�Ӷ��ҵ�������Ʒ�������ڵ������±�
        }

        s = input.nextInt();  // ������Ϸ�ʽ
        for(i=1; i<=s; i++){
            t = input.nextInt();  // �����Ϸ�ʽ�м���
            for(j=1; j<=t; j++){
                n = input.nextInt(); // ����
                p = input.nextInt(); //����
                offer[i][num[n]] = p;   //�����������������
            }
            offer[i][0] = input.nextInt();   //�Żݼ۸�
        }
    }


    /**
     *����ȷ������b����Ʒ������ÿ����Ʒ�Ĺ�����������С����
     *��ȷ������������Ž�
     */
    private static void minicost(){
        //�Ѿ�����1~5����Ʒ������
        int i,j,k,m,n;
        //�ҵ���Ӧ�Żݺ�Ļ���
        int p;
        //��С����
        int minm = 0;
        //����С���ѳ�ʼ��Ϊû���Żݲ���ʱ�Ļ���
        for(i=1; i<=b; i++)
            minm += product[i]*purch[i].price;

        //��s���Żݲ�����������
        for(p=1; p<=s; p++){    //���� p   //s �Ǽ����Żݷ���
            i = product[1] - offer[p][1];//��һ����Ʒ�۳���ǰ�Ż���Ϻ��ʣ�๺������offer[i][j]: ��Ʒ��ϵ��Żݼ�(j=0)��ĳ���Ż������ĳ����Ʒ��Ҫ���������(j>0)��
            j = product[2] - offer[p][2];
            k = product[3] - offer[p][3];
            m = product[4] - offer[p][4];
            n = product[5] - offer[p][5];
            //�ж��ڵ�ǰ�Ż�����£��������Ʒ�ܻ����Ƿ��û���Ż����ߵĻ�����
            if(i>=0 && j>=0 && k>=0 && m>=0 && n>=0 && cost[i][j][k][m][n]+offer[p][0] < minm)
                //�����Ż����ǰ�Ļ���+��ǰ�Ż���ϻ���
                minm = cost[i][j][k][m][n] + offer[p][0];
        }
        //������������ϻ���
        cost[product[1]][product[2]][product[3]][product[4]][product[5]] = minm;
    }



    /**
     *���ڵ�i����Ʒ,���i���������Ʒ����bʱ�������ʱ��ϵ���С����
     */
    private static void comp(int i){//i����Ʒ
        //ȷ��һ�������⣬����һ�ε�ǰ��С����
        if(i > b){
            minicost();
            return;
        }

        for(int j=0; j<=purch[i].piece; j++){//purch[i].piece��ʾ��i����Ʒ���������
            product[i] = j;//��¼��i����Ʒ��������j�����
            comp(i+1);//���Ʊ������е���Ʒ��
        }
    }

    /**
     * ������
     */
    private static void out(){
        System.out.println(cost[product[1]][product[2]][product[3]][product[4]][product[5]]);
    }

    public static void main(String[] args){
        init();
        comp(1);//�ӵ�һ����Ʒ��ʼ
        out();
    }
}
