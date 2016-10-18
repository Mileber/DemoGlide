package mileber.demoglide.model;

import mileber.demoglide.bean.User;

/**
 * Created by Mileber on 2016/10/18.
 */

public class UserLogin implements Login{
    @Override
    public void login(final String username, final String password, final OnLoginListener onLoginListener) {
        new Thread(){
            public void run(){
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("qqq".equals(username) && "111".equals(password)){
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    onLoginListener.loginSuccess(user);
                }else{
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}
