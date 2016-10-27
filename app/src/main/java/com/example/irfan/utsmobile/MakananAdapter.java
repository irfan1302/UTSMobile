package com.example.irfan.utsmobile;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


public class MakananAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] NamaMakanan;
    private final Double[] Harga;
    Dialog dialog;
    View dialogView;
    LayoutInflater inflater;
    NumberPicker np;

    public MakananAdapter(Activity context, String[] NamaMakanan, Double[] Harga) {
        super(context, R.layout.list_meja, NamaMakanan);

        this.context=context;
        this.NamaMakanan=NamaMakanan;
        this.Harga=Harga;

    }

    public View getView(final int position, View view, ViewGroup parent) {
        inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_meja, null,true);

        final CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkBox);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView txtJumlah = (TextView) rowView.findViewById(R.id.txt_jumlah);
        ImageView gambar = (ImageView) rowView.findViewById(R.id.icon);
        TextView txtHarga = (TextView) rowView.findViewById(R.id.ket);

        txtTitle.setText(NamaMakanan[position]);
        txtHarga.setText("Rp. "+String.valueOf(Harga[position]));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    dialog = new Dialog(context);
                    dialog.setContentView(R.layout.numberpicker_dialog);
                    dialog.setTitle("Jumlah Pesanan");
                    np = (NumberPicker) dialog.findViewById(R.id.num1);
                    Button b1 = (Button) dialog.findViewById(R.id.button1);
                    Button b2 = (Button) dialog.findViewById(R.id.button2);
                    dialog.setCancelable(false);

                    np.setMinValue(1);
                    np.setMaxValue(10);

                    b1.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {
                            PesanFragment.datacheckbox.add(NamaMakanan[position]);
                            PesanFragment.datajumlah.add(np.getValue());
                            PesanFragment.dataharga.add(Harga[position]);
                            Toast.makeText(getContext(),NamaMakanan[position]+ " ditambahkan",Toast.LENGTH_SHORT).show();

                            dialog.dismiss();
                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {
                            checkBox.setChecked(false);
                            dialog.dismiss();
                        }
                    });



                    dialog.show();

                }else{
                    Toast.makeText(getContext(),NamaMakanan[position]+ " dibatalkan",Toast.LENGTH_SHORT).show();
                    PesanFragment.datacheckbox.remove(PesanFragment.datacheckbox.get(position));
                    PesanFragment.dataharga.remove(PesanFragment.dataharga.get(position));
                    PesanFragment.datajumlah.remove(PesanFragment.datajumlah.get(position));

                }
            }
        });
        return rowView;
    }
}