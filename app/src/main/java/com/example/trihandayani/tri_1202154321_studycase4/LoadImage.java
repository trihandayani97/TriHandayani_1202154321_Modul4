package com.example.trihandayani.tri_1202154321_studycase4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class LoadImage extends AppCompatActivity {

    Button imgLoadButton;
    ImageView imgResult;
    Bitmap imgBitmap;
    EditText urlInput;
    String imgURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        imgResult = (ImageView) findViewById(R.id.image_result);
        urlInput = (EditText) findViewById(R.id.editText_url_input);
        imgLoadButton = (Button) findViewById(R.id.btn_load_image);
        imgLoadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgURL = urlInput.getText().toString();
                new ImageLoader().execute(imgURL);
            }
        });
    }

    class ImageLoader extends AsyncTask<String, String, Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... args) {

            try{

                imgBitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

            }catch (Exception e){
                e.printStackTrace();
            }

            return imgBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap image) {

            if(image != null){
                imgResult.setImageBitmap(image);
            }

        }
    }
}
