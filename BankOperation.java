package BankerAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BankOperation {

    public int resourceType; //资源种类
    public int process; //进程个数
    public int[][] maxNeed;    //t0时刻各进程的最大需求数
    public int[][] possess; //每个进程的资源已分配数
    public int[][] need; //每个进程的资源需要数
    public int[] resources; //各类资源总数
    public int[] available; //可利用资源数
    public boolean[] finish; //判断进程是否可被安全
    public int[] securitySequence; //安全序列
    public int[][] availableTrue; //实际的可利用资源数.

    public void Init(){  //初始化
        Scanner scanner = new Scanner(System.in);
        //资源初始化
        System.out.println("请你输入你的资源种类");
        resourceType = scanner.nextInt();
        //去具体初始化各类资源数
        resources = new int[resourceType];
        System.out.println("请你输入这" +resourceType+ "类资源的具体值");
        for(int i = 0; i < resourceType; i++){
            System.out.println("请你输入第" +i+ "类资源总数");
            resources[i] = scanner.nextInt();
        }

        //进程初始化
        System.out.println("请你输入你的进程总数");
        process = scanner.nextInt();

        //可以去初始化各个二维数组的空间大小了
        maxNeed = new int[process][resourceType];
        possess = new int[process][resourceType];
        need = new int[process][resourceType];
        availableTrue = new int[process][resourceType];

        //给t0时刻个进程需求数赋值
        System.out.println("请你给t0时刻各进程去赋资源数");
        assignment(maxNeed);

        //给各个进程已分配数组赋值
        System.out.println("请你给各进程已分配资源数赋值");
        assignment(possess);

        //去求个进程的需求数组

        for(int i = 0; i < need.length; i++){
            for(int j = 0; j < need[i].length; j++){
                need[i][j] = maxNeed[i][j] - possess[i][j];
            }
        }

        //去初始化一下可利用资源数,去遍历已分配数组,用总数一减就OK了.
        int row = possess.length;
        int col = possess[0].length;
        available = new int[resourceType];
        for(int i = 0; i < col; i++){
            int sum = 0; //记录那一列之和
            for(int j = 0; j < row; j++){
                 sum += possess[j][i];
            }
            available[i] = resources[i] - sum;
            availableTrue[0][i] = available[i]; //给实际的可利用数组赋值.
        }

        //去初始化一下boolean数组,初值为false不用管
        finish = new boolean[process];

        //去初始化一下安全序列,全为666预防0那个.

        securitySequence = new int[process];
        for(int i = 0; i < securitySequence.length; i++){
            securitySequence[i] = 666;
        }
    }

    public void assignment(int[][] tem){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < tem.length; i++){
            System.out.println("请你给第" +i+ "进程赋值");
            for(int j = 0; j < tem[i].length; j++){
                tem[i][j] = scanner.nextInt();
            }
        }
    }



    public boolean SafetyInspection(){  //安全性检验
        int count = 0; //用来记录进程数.和遍历一遍看有无改变.
        boolean judge = false; //再进程每行判断起作用
        int index1 = 0; //去记录一下第一次安全队列执行的哪一个下标.
        //去遍历需求数组,如果可利用的资源数大于等于某个进程的需求数,就回收.
        // 否则继续遍历,这时候就看count与finish数组了.

        while(true){
            int tem = count;
            for(int i = 0; i < need.length; i++){
                judge = false; //每次都需要布置初始值
                for(int j = 0; j < need[0].length; j++){
                    //去判断
                    if(finish[i] == true || available[j] < need[i][j]){
                      judge = true;
                    }
                    if(judge == true){  //是true就没必要在继续了.因为一个小了,其他无所谓
                        break;
                    }
                }
                if(judge == false){ //回收
                    for(int z = 0; z < possess[i].length; z++){
                        available[z] += possess[i][z];
                        availableTrue[i][z] = available[z];  //给实际的可利用数组赋值.
                    }
                    finish[i] = true;  //置true
                    securitySequence[count] = i; //更新安全序列
                    count += 1;  //每次循环完有进程被回收就加1.
                    //来个输出的过2秒输一下.
                    try {
                        Thread.sleep(2000);//括号里面的5000代表5000毫秒，也就是5秒，可以该成你需要的时间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    print();
                    if(count == 1){  //记录第一个进入安全队列的.
                        index1 = i;
                    }
                }
            }

            if(count == process){ //完成完之后,其余值不变,把假的可利用值赋回来.
                System.out.print("该作业安全,你的安全序列为: ");
                System.out.println(Arrays.toString(securitySequence));

                //把假的可分配资源数置为初始值.
                for(int i = 0; i < availableTrue[i].length; i++){
                    available[i] = availableTrue[index1][i] - possess[index1][i];
                }

                //把finish数组置为初始值
                for(int i = 0; i < finish.length; i++){
                    finish[i] = false;
                }
                //安全队列也得重新赋回初值,要不我的不安全队列就不行了.
                for(int i = 0; i < securitySequence.length; i++){
                    securitySequence[i] = 666;
                }
                return true;
            }
            //在一次循环之后，如果count值没有改变,则就没有进程要求被满足,就应该break,不安全.
            if(count == tem && count < process){
                int[] nosafe = new int[process];
                int j;
                System.out.println("不安全,因为这几个序列中需求不被满足");
                for(int i = 0; i < securitySequence.length; i++){
                    for(j = 0; j < securitySequence.length; j++){
                        if(i == securitySequence[j]){  //安全序列数值肯定是 0 ~ process里这些数,所以直接去遍历安全序列数组,谁没有谁不安全.
                            break;
                        }
                    }
                    if(j >= securitySequence.length){
                        nosafe[i] = i;  //不安全的全存在nosafe数组中
                    }
                }
                System.out.println(Arrays.toString(nosafe));

                //2.把所有值都赋值为原来的部分.
                //把初始值赋回来.
                for(int i = 0; i < availableTrue[i].length; i++){
                    available[i] = availableTrue[index1][i] - possess[index1][i];  //找到第一次进安全序列的进程
                                                                                   // ,然后直接求出开始的可分配资源.
                }

                //把finish数组中执行过的数组置为false
                for(int i = 0; i < finish.length; i++){
                    finish[i] = false;
                }
                //安全队列也得重新赋回初值,要不我的不安全队列就不行了.
                for(int i = 0; i < securitySequence.length; i++){
                    securitySequence[i] = 666;
                }
                return false;
            }
        }
  }


  public boolean ResourceRequest(){  //资源性请求
        //如果你的检验通过了,但是没有安全序列,则不能修改这个数组
      int[][] temporary = new int[3][resourceType]; //去存请求的那个最初的需求和最初的占有和最初的可分配资源
        Scanner scanner = new Scanner(System.in);
      System.out.println("请输入你要给几号进程请求");
      int index = scanner.nextInt();
      int[] request = new int[resourceType];
      System.out.println("请输入你的请求资源数");
      for(int i = 0; i < request.length; i++){
          request[i] = scanner.nextInt();
      }
      //去进行资源校验，继续设置判断器.
      boolean judge = false; //为true就通过.
      //1.和该进程的请求去校验.
      for(int i = 0; i < need[index].length; i++){
          if(request[i] > need[index][i]){
              judge = true;
          }
      }
      //2.去判断该请求通过1要求了没,在去进行资源校验2,通过就改变值.
      if(judge == true){
          System.out.println("该请求无法通过该进程的需求检验");
          return false;
      }else{
          //通过了
          int i;
          for(i = 0; i < available.length; i++){
              if(request[i] > available[i]){
                  break;
              }
          }
          //看第二轮有谁通过了.
          //通过了
          if(i >= available.length){
             //1.去修改需求数组中该请求的值.
              for(int z = 0; z < need[index].length; z++){
                  temporary[0][z] = need[index][z]; //第0行存需求
                  need[index][z] -= request[z];
              }
              //2.再去修改可分配资源数的值.和占有数也得改变
              for(int z = 0; z < available.length; z++){
                  temporary[1][z] = available[z]; //第二行去存可分配的
                  available[z] -= request[z];
              }
              //修改该进程占有量

              for(int z = 0; z < possess[index].length; z++){
                  temporary[2][z] = possess[index][z]; //第三行存占有量
                  possess[index][z] += request[z];
              }
              //3.进行安全性检验.
              //为true就成了返回true并输出安全序列
              if(SafetyInspection()) {
                  return true;
              }else{
                  //把所有值修改回去
                  for(int b = 0; b < possess[index].length; b++){
                      need[index][b] = temporary[0][b];
                      available[b] = temporary[1][b];
                      possess[index][b] = temporary[2][b];
                  }
                  System.out.println("该请求通过了,但是无安全序列");
                  return false;
              }
          }else{
              System.out.println("该请求无法通过可利用资源数的需求检验");
              return false;
          }
      }
  }

    public void print(){
        //System.out.println("      " + "   Allocation     " + "         Need   " + "         Available   "  + "     finish ")
        System.out.println("      " + "   Allocation     " + "  Need   " + "   Available   "  + "   finish ");
        for(int i = 0; i < need.length; i++){
            System.out.print(i);
            System.out.print(" |");
            System.out.print("  ");
            for(int j = 0; j < possess[i].length; j++){
                System.out.print("   "+possess[i][j]);
            }
            System.out.print(" | ");
            for(int k = 0; k < need[i].length; k++){
                System.out.print("   "+need[i][k]);
            }
            System.out.print(" |");
            for(int z = 0; z < availableTrue[i].length; z++){
                System.out.print("   "+availableTrue[i][z]);
            }
            System.out.print(" |  ");
            System.out.print(finish[i]);
            System.out.println();
        }
    }
    public void menu(){
        System.out.println("欢迎来到银行家算法");
        System.out.println("***********************");
        System.out.println("*****1.初始化**********");
        System.out.println("*****2.安全性检验********");
        System.out.println("*****3.资源性请求*********");
        System.out.println("*****4.输出**********");
        System.out.println("*****5.exit************");
        System.out.println("***********************");
    }
    public  void perform() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true) {
            menu();
            System.out.println("请输入你的选择");
            choice = scanner.nextInt();
            if (choice == 1) {
                Init();
            } else if(choice == 2) {
                SafetyInspection();
            } else if(choice == 3){
                ResourceRequest();
            } else if (choice == 4) {
                print();
            }else if(choice == 5){
                break;
            }else{
                System.out.println("你的输入有误,请重输");
                continue;
            }
        }
    }
    public static void main(String[] args) {
        BankOperation use = new BankOperation();
        use.perform();
    }
}
