package lesson3;

public class SingtonSafe {
    private static SingtonSafe SIMGTON_SAFE = null;

    private SingtonSafe() {


    }
    public static SingtonSafe getInstance() {
        if (SIMGTON_SAFE == null) {
            synchronized (SingtonSafe.class) {
                if(SIMGTON_SAFE == null) {
                    SIMGTON_SAFE = new SingtonSafe();
                }
            }
        }
        return SIMGTON_SAFE;
    }
}
