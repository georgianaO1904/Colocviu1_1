package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    //b1
    private Button coordinatesButton;
    private TextView coordinatesShowText;
    //b2
    private int numberOfClicks = 0;
    private final String key = "savedNumber";

    final public static int buttons[] = {
            R.id.northButton,
            R.id.southButton,
            R.id.eastButton,
            R.id.westButton,
    };
    //b1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatesShowText = findViewById(R.id.clikedButtonsText);

        for (int i = 0; i < buttons.length; i++) {
            coordinatesButton = (Button)findViewById(buttons[i]);
            coordinatesButton.setOnClickListener(buttonClickListener);
        }
        //b.2.b
        if(savedInstanceState == null){
            Log.d("COLOCVIU TAG", "onCreate() method was invoked without a previous state");
        } else {
            Log.d("COLOCVIU TAG", "onCreate() method was invoked with a previous state");
            if(savedInstanceState.containsKey(key)){
                int no = savedInstanceState.getInt(key, 0);
                Toast.makeText(getApplicationContext(), "Saved number of clicks: " + numberOfClicks , Toast.LENGTH_SHORT).show();
            }
        }

    }
    //b1
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //b.2.a
            numberOfClicks++;
            Toast.makeText(getApplicationContext(), "No of clicks: " + numberOfClicks , Toast.LENGTH_SHORT).show();

            String clikedText = ((Button)view).getText().toString();
            String oldText = coordinatesShowText.getText().toString();
            String virgula = "";
            if(!oldText.equals("")){
                virgula = ",";
            }
            coordinatesShowText.setText(oldText + virgula + clikedText);
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(key, String.valueOf(numberOfClicks));
    }
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(key)) {
            numberOfClicks = savedInstanceState.getInt(key);
        }
    }

}