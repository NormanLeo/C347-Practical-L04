package sg.edu.rp.c346.dailygoal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDone = findViewById(R.id.button);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup rgOne = findViewById(R.id.radioGroup);
                int selectedButtonIdOne = rgOne.getCheckedRadioButtonId();
                RadioButton rbOne = findViewById(selectedButtonIdOne);

                RadioGroup rgTwo = findViewById(R.id.radioGroup2);
                int selectedButtonIdTwo = rgTwo.getCheckedRadioButtonId();
                RadioButton rbTwo = findViewById(selectedButtonIdTwo);

                RadioGroup rgThree = findViewById(R.id.radioGroup3);
                int selectedButtonThree = rgThree.getCheckedRadioButtonId();
                RadioButton rbThree = findViewById(selectedButtonThree);

                EditText etReflect = findViewById(R.id.editText);

                String[] info = {rbOne.getText().toString(), rbTwo.getText().toString(), rbThree.getText().toString(), etReflect.getText().toString()};
                Intent i =new Intent (MainActivity.this, Summary.class);
                i.putExtra("info", info);
                startActivity(i);

            }
        });
    }
}
