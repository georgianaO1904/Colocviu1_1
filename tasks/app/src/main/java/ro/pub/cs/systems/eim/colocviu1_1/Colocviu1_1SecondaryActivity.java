package ro.pub.cs.systems.eim.colocviu1_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Colocviu1_1SecondaryActivity extends AppCompatActivity {

    private TextView messageTextView;
    private Button CancelButton;
    private Button RegisterButton;

    public void onClick(View view){
        switch (view.getId()){
            case R.id.cancelButton:
                setResult(RESULT_CANCELED, null);
                break;
            case R.id.registerButton:
                setResult(RESULT_OK, null);
                break;
        }
        finish();
    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        messageTextView = (TextView) findViewById(R.id.text_secondary);
        Intent intent = getIntent();
        if(intent != null)
        {
            String action = intent.getAction();
            Uri data  = intent.getData();
            Bundle extras = intent.getExtras();
        }

    }



}

