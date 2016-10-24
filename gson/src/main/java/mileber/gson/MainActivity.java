package mileber.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btnSimpleObject;
    private Button btnGenericObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        textView = (TextView) findViewById(R.id.textView);

        btnSimpleObject = (Button) findViewById(R.id.btn_simple_object);
        btnSimpleObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleObject();
            }
        });

        btnGenericObject = (Button) findViewById(R.id.btn_generic_object);
        btnGenericObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genericObject();
            }
        });
    }

    private void simpleObject(){
        final Gson gson = new Gson();

        ModelObject modelObject = new ModelObject("十六",16,true,5.20);
        //original object
        textView.setText("toJson---\n");
        textView.append("Original Java object : " + modelObject + "\n");
        //converting an object to json object
        String json = gson.toJson(modelObject);
        textView.append("Converted Json object : " + json + "\n");

        textView.append("fromJson---\n");
        // getting object from json representation
        textView.append("Original JSON string is : " + json + "\n");
        // converting json to object
        ModelObject modelObject1 = gson.fromJson(json, ModelObject.class);
        textView.append("Converted Java object : " + modelObject1 + "\n");
    }

    private void genericObject(){
        Gson gson = new Gson();

        textView.setText("Generic Object Model\n");
        GenericModel<Integer> model = new GenericModel<>(12);

        //converting to json repersentation
        String json = gson.toJson(model);
        textView.append("Json representation : " + json + "\n");

        //converting back to object
        Type collectionType = new TypeToken<GenericModel<Integer>>(){}.getType();
        GenericModel<Integer> model2 = gson.fromJson(json, collectionType);
        textView.append("Converted object representation : " + model2);

        textView.append("\nA object from collection framework\n");

        List<String> listOfString = new ArrayList<>();
        listOfString.add("qwerty");
        listOfString.add("asdfgh");

        //converting to Json
        String jsonStr = gson.toJson(listOfString);
        textView.append("Json representation : " + jsonStr);

        Type collectionType2 = new TypeToken<List<String>>() {
        }.getType();
        List<String> listObj = gson.fromJson(jsonStr, collectionType2);
        System.out.println("converted object representation: " + listObj);
    }
}
