package com.gdeaditya.eventku;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageView gambar1;
    TextView txt_judul, txt_kat, txt_lok, txt_tgl;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("dataku", MODE_PRIVATE);
        editor = pref.edit();

        gambar1 = (ImageView) findViewById(R.id.img_header);
        txt_judul = (TextView) findViewById(R.id.tx_judul);
        txt_tgl = (TextView) findViewById(R.id.tx_tanggal);
        txt_lok = (TextView) findViewById(R.id.tx_lokasi);
        txt_kat = (TextView) findViewById(R.id.tx_kategori);
    }

    public void ubahText1(View view) {
        merubahText(R.drawable.bg_event,
                getResources().getString(R.string.judul_1),
                getResources().getString(R.string.kategori_1),
                getResources().getString(R.string.lokasi_1),
                getResources().getString(R.string.tanggal_1));
    }

    public void ubahText2(View view) {
        merubahText(R.drawable.bg_event2,
                getResources().getString(R.string.judul_2),
                getResources().getString(R.string.kategori_2),
                getResources().getString(R.string.lokasi_2),
                getResources().getString(R.string.tanggal_2));
    }

    public void ubahText3(View view) {
        merubahText(R.drawable.bg_event3,
                getResources().getString(R.string.judul_3),
                getResources().getString(R.string.kategori_3),
                getResources().getString(R.string.lokasi_3),
                getResources().getString(R.string.tanggal_3));
    }

    public void merubahText(int gambar, String tgl, String lok, String kat, String jdl) {
        gambar1.setImageResource(gambar);
        txt_judul.setText(jdl);
        txt_kat.setText(kat);
        txt_lok.setText(lok);
        txt_tgl.setText(tgl);
    }

    public void logout(View view) {
        editor.clear();
        editor.commit();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

}
