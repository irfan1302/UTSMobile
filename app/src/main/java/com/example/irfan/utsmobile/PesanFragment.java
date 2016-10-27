package com.example.irfan.utsmobile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class PesanFragment extends Fragment {
    public static final String intent_nama="nama";
    public static final String intent_detail="detail";
    public static final Integer intent_image=0;

    public static ArrayList<String> datacheckbox = new ArrayList<String>();
    public static ArrayList<Integer> datajumlah = new ArrayList<Integer>();
    public static ArrayList<Double> dataharga = new ArrayList<Double>();


    public PesanFragment() {
        // Required empty public constructor
    }

    String[] NamaMakanan = {
            "Sushi",
            "Okonomiyaki",
            "Nikujaga",
            "Ramen",
            "Karaage",
            "takoyaki"
    };

    Double[] Harga = {
            19000.0,
            18000.0,
            20000.0,
            15000.0,
            16000.0,
            17000.0
    };
    String[] Detail = {
            "Makanan Paling terkenal jepang dari ikan dan nasi",
            "pzzza nya orang jepang",
            "Semur daging ala jepang",
            "mie ala jepang",
            "semacam ayam goreng",
            "bola-bola cumi "
    };

    LinearLayout view;
    Button bOrder;
    CheckBox checkBox;
    ListView list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=(LinearLayout) inflater.inflate(R.layout.fragment_pesan, container, false);
        // View view = inflater.inflate(R.layout.fragment_pesanan, container, false);
        bOrder=(Button) view.findViewById(R.id.btnOrder);
        checkBox = (CheckBox) view.findViewById(R.id.checkBox);

        list = (ListView) view.findViewById(R.id.list);
        MakananAdapter adapter = new MakananAdapter(getActivity(), NamaMakanan, Harga);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), DetailMakanan.class);
                intent.putExtra(intent_nama,NamaMakanan[position]);
                intent.putExtra(intent_detail,Detail[position]);

                startActivity(intent);

            }
        });


        bOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent i = new Intent(getActivity(), PembayaranActivity.class);
                startActivity(i);

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}