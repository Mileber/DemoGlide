package mileber.demoglide.presenter;

import android.os.Handler;

import mileber.demoglide.bean.User;
import mileber.demoglide.model.OnLoginListener;
import mileber.demoglide.model.UserLogin;
import mileber.demoglide.view.UserLoginView;

/**
 * Created by Mileber on 2016/10/18.
 */

public class UserLoginPresenter {
    private UserLogin userLogin;
    private UserLoginView userLoginView;
    private Handler handler = new Handler();

    public UserLoginPresenter(UserLoginView userLoginView){
        this.userLoginView = userLoginView;
        this.userLogin = new UserLogin();
    }

    public void login(){
        userLoginView.showLoading();
        userLogin.login(userLoginView.getUsername(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable(){

                    @Override
                    public void run() {
                        userLoginView.showLoginSuccess(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.showLoginError();
                    }
                });
            }
        });
    }
}
