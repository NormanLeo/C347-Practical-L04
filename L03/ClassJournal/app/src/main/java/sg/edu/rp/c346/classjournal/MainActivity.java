package sg.edu.rp.c346.classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvModule;
    ArrayAdapter<Module> aa;
    ArrayList<Module> moduleCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = findViewById(R.id.moduleView);

        moduleCA = new ArrayList<Module>();

        moduleCA.add(new Module("C302", "Web Services"));
        moduleCA.add(new Module("C347", "Android Programmming II"));

        aa = new ModuleAdapter(this, R.layout.module_row, moduleCA);
        lvModule.setAdapter(aa);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Module selectedType = moduleCA.get(position);

                Intent i = new Intent(MainActivity.this, GradeActivity.class);
                i.putExtra("type", selectedType);
                startActivity(i);
            }
        });
    }
}
