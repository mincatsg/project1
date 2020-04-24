// 三个类就是在根据钱判断状态

package StatePattern;
public class GreenState extends AccountState {
    public GreenState(Account acc) {
        this.acc = acc;
    }
    public GreenState(AccountState state) {
        this.acc = state.acc;
    }
    @Override
    public void stateCheck() {
        if (acc.balance >= -1000 && acc.balance < 0) {
            acc.setState(new YellowState(this));
        } else if (acc.balance < -1000) {
            acc.setState(new RedState(this));
        }
    }
}
