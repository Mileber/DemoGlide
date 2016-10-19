package mileber.glide;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    //private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        imageView = (ImageView) findViewById(R.id.imageView);

        String url = "http://i.imgur.com/idojSYm.png";
        loadImage(url,imageView);
    }

    private void loadImage(final String url, final ImageView image){

        Glide.with(getApplicationContext()).load(url)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(image);

    }

}
