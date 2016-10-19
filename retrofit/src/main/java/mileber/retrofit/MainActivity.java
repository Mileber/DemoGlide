package mileber.retrofit;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private  void initView(){
        textView = (TextView) findViewById(R.id.tv_response);
    }

    public void requestText(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:// https://api.heweather.com/")
                .build();

        BaiduService baiduService = retrofit.create(BaiduService.class);
        Call<ResponseBody> call = baiduService.getResponse("CN101020100");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                System.out.println(response.body().toString());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(response.body().toString());
                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
