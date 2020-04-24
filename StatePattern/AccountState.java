// 存款取款都在这完成，如果状态已经是redState的话，只能存不能取
package StatePattern;
public abstract class AccountState {
    public Account acc;
    public abstract void stateCheck();
    public void deposit(double amount){
        acc.balance += amount;
        stateCheck();
    }
    public void withdraw(double  amount){
        if(acc.balance < -1000){
            System.out.println("状态受限，禁止操作！");
        }else {
            acc.balance -= amount;
            stateCheck();
        }
    }
}
