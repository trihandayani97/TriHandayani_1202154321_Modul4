package com.example.trihandayani.tri_1202154321_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toListMahasiswa(View view) {

        Intent toListMhsw = new Intent(this,ListMahasiswa.class);
        startActivity(toListMhsw);

    }

    public void toImgSearch(View view) {

        Intent toImgSearch = new Intent(this,LoadImage.class);
        startActivity(toImgSearch);

    }
}
