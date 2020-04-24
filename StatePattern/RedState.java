package StatePattern;

public class RedState extends AccountState {
    public RedState(Account acc) {
        this.acc = acc;
    }
    public RedState(AccountState state){
        this.acc = state.acc;
    }
    @Override
    public void stateCheck() {
        if (acc.balance >=  0) {
            acc.setState(new GreenState(this));
        } else if (acc.balance > -1000 && acc.balance <0) {
            acc.setState(new YellowState(this));
        }
    }


}
