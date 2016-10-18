package mileber.demoglide.model;

/**
 * Created by Mileber on 2016/10/18.
 */

public interface Login {

    public void login(String username, String password, OnLoginListener onLoginListener);

}
