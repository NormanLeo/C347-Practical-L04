package sg.edu.rp.c346.practical;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnRetrieve;
    EditText etBrand, etLitre;
    TextView tvResults;
    ArrayList<Car> car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsert);
        btnRetrieve = findViewById(R.id.buttonRetrieve);
        tvResults = findViewById(R.id.textView);
        etBrand = findViewById(R.id.editTextBrand);
        etLitre = findViewById(R.id.editTextLitre);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertCar(etBrand.getText().toString(), Double.parseDouble(etLitre.getText().toString()));
                db.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                etBrand.setText("");
                etLitre.setText("");
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<Car> data = db.getAllCars();

                String txt = "";
                for (int i=0; i<data.size(); i++){
                    txt += data.get(i).getBrand() + ", " + data.get(i).getLitre() + "\n";
                }

                tvResults.setText(txt);
                db.close();
            }
        });
    }
}
