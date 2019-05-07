package sg.edu.rp.c346.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DailyCAAdapter extends ArrayAdapter<DailyCA> {

    private ArrayList<DailyCA> dailyCA;
    private Context context;
    private TextView tvWeek;
    private TextView tvDG;
    private TextView tvGrade;
    private ImageView ivGrade;

    public DailyCAAdapter(Context context, int resource, ArrayList<DailyCA> objects) {
        super(context, resource, objects);
        dailyCA = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_design, parent, false);

        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvDG = rowView.findViewById(R.id.textViewDG);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        ivGrade = rowView.findViewById(R.id.imageView);

        DailyCA currentDaily = dailyCA.get(position);

        tvDG.setText("DG");
        tvWeek.setText("Week " + currentDaily.getWeek());
        tvGrade.setText(currentDaily.getDgGrade());
        ivGrade.setImageResource(R.drawable.dg);

        return rowView;
    }
}
