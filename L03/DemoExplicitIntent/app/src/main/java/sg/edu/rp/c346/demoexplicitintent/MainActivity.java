package sg.edu.rp.c346.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSuperman, tvBatman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperman = findViewById(R.id.textViewSuperman);
        tvBatman = findViewById(R.id.textViewBatman);

        tvSuperman.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Create Hero object of strength 100 & technical 60
                Hero superman = new Hero("Superman", 100, 60);
                Intent i = new Intent(MainActivity.this,
                        HeroStatsActivity.class);
                // Put hero object in intent
                i.putExtra("hero", superman);
                startActivity(i);
            }});


        tvBatman.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // Create Hero object of strength 60 & technical 90
                Hero batman = new Hero("Batman", 60, 90);
                Intent i = new Intent(MainActivity.this,
                        HeroStatsActivity.class);
                // Put hero object in intent
                i.putExtra("hero", batman);
                // Start the activity
                startActivity(i);
            }});

    }
}
