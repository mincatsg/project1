import java.util.*;
class Dadianqi{
	 Scanner sb=new Scanner(System.in);
	String leibie;
	Dianqi dianqi[]=new Dianqi [3];
	Dadianqi(String l){
		leibie=l;
	}
	public void add() {
		System.out.println(leibie);
		for(int i=0;i<3;i++) {
		dianqi[i]=new Dianqi();
		}
	}
	public double jisuan() {
 		double sum=0;
 		double ave=0;
 		for(int i=0;i<3;i++) {
 			
 			sum+=dianqi[i].jiage;
 		}
 		ave=sum/3;
 		
 		System.out.println(ave);
 	return ave;
 		
 	}
	public void jisuanda() {
		double max=dianqi[0].jiage;
		double min=dianqi[0].jiage;
		for(int i=0;i<3;i++) {
			if (max<dianqi[i].jiage) {
				max=dianqi[i].jiage;
			}
			else if (min>dianqi[i].jiage) {
				min=dianqi[i].jiage;
			}
		}
		System.out.println("���ֵ"+max);
		System.out.println("��Сֵ"+min);

	}
	public void tongji() {
		System.out.println("��ƽ��ֵ��");
		double av=jisuan();
		int a=0;
		int b=0;
		for(int i=0;i<3;i++) {
			if (dianqi[i].jiage>av) {
				a++;
			}
			if (dianqi[i].jiage<av) {
				b++;
			}
		}
		System.out.println("����ƽ��ֵ��������"+a);
		System.out.println("����ƽ��ֵ��������"+b);
		
	}
	public void chazhao() {
		String n;
		System.out.println("�����ͺţ�");
		n=sb.nextLine();
		for(int i=0;i<3;i++) {
			if (dianqi[i].dqxinghao.equals(n)) {
				System.out.println("�۸�"+dianqi[i].jiage);
				System.out.println("��棺"+dianqi[i].kucui);
			}
			
		}
		System.out.println("��ѯ��ϣ�");
	}
}
class Dianqi {
	
	 String dqxinghao;
     double jiage;
	 int kucui;
	 Scanner sb=new Scanner(System.in);
     	Dianqi() {
		 System.out.print("����������ͺ�:");
		 dqxinghao=sb.nextLine();
		 System.out.print("����������۸�:");
		 jiage=sb.nextDouble();
		 sb.nextLine();
		 System.out.print("������������:");
		 kucui=sb.nextInt();
		 sb.nextLine();
     	}
     	
}    


public  class work{
	
	public static void main(String[] args ) {
		
		Dadianqi da1=new Dadianqi("��һ��");
		Dadianqi da2=new Dadianqi("�ڶ���");
		Dadianqi da3=new Dadianqi("������");
		Dadianqi da4=new Dadianqi("������");
		da1.add();
		da2.add();
		da3.add();
		da4.add();
		System.out.println("��һ���ƽ��ֵ�����ֵ��Сֵ");
		da1.jisuan();
		da1.jisuanda();
		da1.tongji();
		System.out.println("�ڶ����ƽ��ֵ�����ֵ��Сֵ");
		da2.jisuan();
		da2.jisuanda();
		da2.tongji();
		System.out.println("�������ƽ��ֵ�����ֵ��Сֵ");
		da3.jisuan();
		da3.jisuanda();
		da3.tongji();
		System.out.println("�������ƽ��ֵ�����ֵ��Сֵ");
		da4.jisuan();
		da4.jisuanda();
		da4.tongji();
		System.out.println("����ǰ");
		double d[]=new double[4];
		d[0]=da1.jisuan();
		d[1]=da2.jisuan();
		d[2]=da3.jisuan();
		d[3]=da4.jisuan();
		Arrays.sort(d);
		System.out.println(" �����");
		for(int i=d.length-1;i>=0;i--) {
			System.out.println(d[i]);
		}
		da1.chazhao();
		da2.chazhao();
		da3.chazhao();
		da4.chazhao();
	
	}
}


















/*public void paixu() {
		double c[]=new double[4];
		for(int i=0;i<4;i++) {
			double sum=0;
			double ave=0;
	 		for(int j=0;j<3;j++) {
	 			
	 			sum+=dianqi[j].jiage;
	 		}
	 		ave=sum/3;
	 		c[i]=ave;
		}
		Arrays.sort(c);
		System.out.println("�����");
		for(int i=c.length-1;i>=0;i--) {
			System.out.println(c[i]);

		}
	}*/
		


 