package mileber.demoglide.view;

import mileber.demoglide.bean.User;

/**
 * Created by Mileber on 2016/10/18.
 */

public interface UserLoginView {
    String getUsername();
    String getPassword();
    void showLoading();
    void hideLoading();
    void showLoginSuccess(User user);
    void showLoginError();
}
