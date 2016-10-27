package com.example.irfan.utsmobile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MejaAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] NamaMeja;
    private final Integer[] GbrMeja;

    public MejaAdapter(Activity context, String[] NamaMeja, Integer[] GbrMeja) {
        super(context, R.layout.list_meja, NamaMeja);

        this.context=context;
        this.NamaMeja=NamaMeja;
        this.GbrMeja=GbrMeja;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_meja, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        txtTitle.setText(NamaMeja[position]);
        imageView.setImageResource(GbrMeja[position]);

        return rowView;

    };
}

