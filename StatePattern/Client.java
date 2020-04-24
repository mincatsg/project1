package StatePattern;
public class Client {
    public static void main(String[] args) {
        Account account = new Account("段誉",5.0);
        account.deposit(100);    //存
        account.withdraw(200);   //取
        account.deposit(1000);
        account.withdraw(2000);
        account.withdraw(100);
    }
}
