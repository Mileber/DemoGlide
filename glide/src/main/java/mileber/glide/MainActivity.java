package mileber.glide;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btnLoadImage;
    //private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        imageView = (ImageView) findViewById(R.id.imageView);
        btnLoadImage = (Button) findViewById(R.id.btnLoadImage);
    }

    public void loadImage(View view){
        String url = "http://i.imgur.com/idojSYm.png";

        Glide.with(getApplicationContext()).load(url)
                .centerCrop()
                .into(imageView);

    }

}
