package mileber.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().post(new MessageEvent("Hello~"));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent){
        Toast.makeText(getApplicationContext(),messageEvent.message,Toast.LENGTH_LONG).show();
    }

    public void onStart(){
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
