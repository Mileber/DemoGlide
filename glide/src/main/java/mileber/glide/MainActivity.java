package mileber.glide;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import mileber.glide.util.GlideCircleTransform;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewLocal;
    private ImageView imageViewNet;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        imageViewLocal = (ImageView) findViewById(R.id.imageViewLocal);
        imageViewNet = (ImageView) findViewById(R.id.imageViewNet);

        final Context context = getApplicationContext();

        button = (Button) findViewById(R.id.btnLoadImage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过ResourceId加载图片
                loadImageLocal(context,R.mipmap.ic_launcher, imageViewLocal);

                //通过URL加载图片
                String url = "http://imgstore.cdn.sogou.com/app/a/100540002/503008.png";
                loadImageNet(url, imageViewNet);

                //TODO:通过本地图片加载

                //TODO:加载圆角，圆形图片
                //loadImageCircle(R.mipmap.ic_launcher);
                //loadImageRounded();
            }
        });
    }

    private void loadImageLocal(Context context,int resId, ImageView imageViewLocal){

        Glide.with(context)
                .load(resId)
                //.transform(new GlideCircleTransform(context))
                .into(imageViewLocal);

    }

    private void loadImageNet(String url, ImageView imageViewNet){
        Glide.with(this)
                .load(url)
                .fitCenter()
                .crossFade()
                .into(imageViewNet);
    }

}
