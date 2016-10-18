package mileber.demoglide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import mileber.demoglide.bean.User;
import mileber.demoglide.presenter.UserLoginPresenter;
import mileber.demoglide.view.UserLoginView;

public class UserLoginActivity extends AppCompatActivity implements UserLoginView{

    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);
    private EditText editText_username,editText_password;
    private Button button_login;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        editText_username = (EditText) findViewById(R.id.et_username);
        editText_password = (EditText) findViewById(R.id.et_password);
        button_login = (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });
    }

    @Override
    public String getUsername() {
        return editText_username.getText().toString();
    }

    @Override
    public String getPassword() {
        return editText_password.getText().toString();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showLoginSuccess(User user) {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this,"登录失败，请确认用户名和密码是否正确",Toast.LENGTH_SHORT).show();
    }
}
