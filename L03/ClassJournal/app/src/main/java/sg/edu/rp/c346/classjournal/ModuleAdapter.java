package sg.edu.rp.c346.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> moduleCA;
    private Context context;
    private TextView tvCode;
    private TextView tvModule;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects) {
        super(context, resource, objects);
        moduleCA = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.module_row, parent, false);

        tvCode = rowView.findViewById(R.id.textViewCode);
        tvModule = rowView.findViewById(R.id.textViewModule);

        Module currentModule = moduleCA.get(position);

        tvCode.setText(currentModule.getCode());
        tvModule.setText(currentModule.getName());

        return rowView;
    }
}
