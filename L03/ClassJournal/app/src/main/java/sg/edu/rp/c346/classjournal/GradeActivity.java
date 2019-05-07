package sg.edu.rp.c346.classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class GradeActivity extends AppCompatActivity {
    int requestCodeForAdd = 1;
    ListView lv;
    Button btnInfo, btnAdd, btnEmail;
    ArrayAdapter<DailyCA> aa;
    ArrayList<DailyCA> dailyCA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        lv = findViewById(R.id.listView);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        dailyCA = new ArrayList<DailyCA>();

        Intent i = getIntent();
        Module mod = (Module) i.getSerializableExtra("type");

        final String type = mod.getCode();
        this.setTitle("Info for " + type);

        if(type.equals("C347")) {
            dailyCA.add(new DailyCA("B", "C347", 1));
            dailyCA.add(new DailyCA("C", "C347", 2));
            dailyCA.add(new DailyCA("A", "C347", 3));
        } else {
            dailyCA.add(new DailyCA("C", "C302", 1));
            dailyCA.add(new DailyCA("A", "C302", 2));
            dailyCA.add(new DailyCA("A", "C302", 3));
        }

        aa = new DailyCAAdapter(this, R.layout.row_design, dailyCA);
        lv.setAdapter(aa);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rp = new Intent(Intent.ACTION_VIEW);
                if(type.equals("C347")) {
                    rp.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                } else {
                    rp.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                }
                startActivity(rp);
            }
        });
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder();
                for (DailyCA s : dailyCA) {
                    sb.append("Week " + s.getWeek() + ": DG: " + s.getDgGrade());
                    sb.append("\n");
                }

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "");


                email.putExtra(Intent.EXTRA_TEXT,
                        "Hi faci, \n\n I am ... \n Please see my remarks so far, thank you! \n\n " + sb.toString());
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GradeActivity.this, AddActivity.class);
                i.putExtra("week", lv.getAdapter().getCount()+1);
                startActivityForResult(i, requestCodeForAdd);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if (data != null) {
                String newGrade = data.getStringExtra("grade");
                dailyCA.add(new DailyCA(newGrade, "C302", lv.getAdapter().getCount()+1));
                aa.notifyDataSetChanged();
            }
        }
    }
}
