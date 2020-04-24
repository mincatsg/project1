package StatePattern;

public class YellowState extends AccountState {
    public YellowState(Account acc) {
        this.acc = acc;
    }
    public YellowState(AccountState state) {
        this.acc = state.acc;
    }
    @Override
    public void stateCheck() {
        if (acc.balance > 0) {
            acc.setState(new GreenState(this));
        } else if (acc.balance < -1000) {
            acc.setState(new RedState(this));
            System.out.println("操作受限！");
        }
    }
}
