package mileber.demoglide.model;

import mileber.demoglide.bean.User;

/**
 * Created by Mileber on 2016/10/18.
 */

public interface OnLoginListener {

    void loginSuccess(User user);
    void loginFailed();

}
