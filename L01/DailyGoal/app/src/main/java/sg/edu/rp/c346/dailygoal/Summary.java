package sg.edu.rp.c346.dailygoal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {
    TextView tv1, tv2, tv3, tvR;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent i = getIntent();

        String[] info = ((Intent) i).getStringArrayExtra("info");

        tv1 = findViewById(R.id.textViewOne);
        tv2 = findViewById(R.id.textViewTwo);
        tv3 = findViewById(R.id.textViewThree);
        tvR = findViewById(R.id.textViewReflect);

        String One = getString(R.string.one);
        String Two = getString(R.string.two);
        String Three = getString(R.string.three);

        tv1.setText(One + ": " + info[0]);
        tv2.setText(Two + ": " + info[1]);
        tv3.setText(Three + ": " + info[2]);
        tvR.setText("Reflection: " + info[3]);

        btnBack = findViewById(R.id.buttonBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
