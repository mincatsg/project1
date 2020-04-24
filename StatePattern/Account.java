package StatePattern;


public class Account {
    private AccountState state;
    private String owner;
    public double balance;
    public Account(String owner,double init){
        this.owner = owner;      //构造方法
        this.balance = init;
        this.state = new GreenState(this);
    }
    public void setState(AccountState state){
        this.state = state;     //设置状态
    }
    public void deposit(double amount){
        System.out.println(this.owner + "存款" + amount);
        state.deposit(amount); //调用状态对象的deposit()方法
        System.out.println("现在余额为"+ this.balance);
        //这行主要是去除前面类名，有点长，没什么实际含义
        System.out.println("现在帐户状态为"+ (this.state.getClass().getName()).substring(this.state.getClass().getName().lastIndexOf('.')+1));
        System.out.println("-----------------------------------------");
    }
    public void withdraw(double  amount){
        System.out.println(this.owner + "取款" + amount);
        state.withdraw(amount); //调用状态对象的withdraw()方法
        System.out.println("现在余额为"+ this.balance);
        System.out.println("现在帐户状态为"+ (this.state.getClass().getName()).substring(this.state.getClass().getName().lastIndexOf('.')+1));
        System.out.println("------------------------------------------");
    }
}
