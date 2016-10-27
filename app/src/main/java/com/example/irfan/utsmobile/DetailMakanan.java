package com.example.irfan.utsmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMakanan extends AppCompatActivity {

    TextView txtID,txtDetail;
    ImageView gmb;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        //Inisiasi view
        txtID = (TextView) findViewById(R.id.txtNama);
        txtDetail = (TextView) findViewById(R.id.txtDetail);

        //getting intent
        Intent intent = getIntent();

        //display value by fetching from intent
        txtID.setText(intent.getStringExtra(PesanFragment.intent_nama));
        Log.d(intent.getStringExtra(PesanFragment.intent_detail), " rtess");
        txtDetail.setText(intent.getStringExtra(PesanFragment.intent_detail));
        gmb.setImageResource(intent.getIntExtra(String.valueOf(PesanFragment.intent_image),0));


    }
}
