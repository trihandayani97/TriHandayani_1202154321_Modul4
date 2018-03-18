package com.example.trihandayani.tri_1202154321_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {

    ListView listMahasiswa;
    Button showList;
    ProgressDialog progress;

    String[] namaMahasiswa = {"Tri Handayani",
            "Alexia Lambert",
            "Aoi Shinohara",
            "Charlotte Widson",
            "Aili Chen",
            "Maria McQueen",
            "George William",
            "Yui Tachibana",
            "Luna Weitzmann",
            "Laurent Philippon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listMahasiswa = (ListView) findViewById(R.id.listView_list_mahasiswa);
        listMahasiswa.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));

        showList = (Button) findViewById(R.id.btn_showlist);
        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress = new ProgressDialog(ListMahasiswa.this);
                progress.setCancelable(true);
                progress.setTitle("Loading Data");
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.setMax(100);
                progress.setProgress(0);
                progress.show();
                new showList().execute();

            }
        });

    }

    class showList extends AsyncTask<Void, String, Void>{

        ArrayAdapter<String> adapter;
        int count = 0;

        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) listMahasiswa.getAdapter();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            for(String Nama: namaMahasiswa){
                publishProgress(Nama);
                count += 10;
                try {
                    Thread.sleep(1000); //1 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {

            adapter.add(values[0]);
            int progres = count;
            progress.setProgress(progres);
            progress.setMessage("Loading..."+ "("+progres+"%)");

        }

        @Override
        protected void onPostExecute(Void aVoid) {

            progress.cancel();
            Toast.makeText(listMahasiswa.getContext(), "Showing List Complete!", Toast.LENGTH_LONG).show();

        }
    }
}


