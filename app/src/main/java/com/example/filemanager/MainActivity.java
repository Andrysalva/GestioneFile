package com.example.filemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_leggi;
    Button btn_scrivi;
    TextView testo;
    EditText text;
    GestoreFile gf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringaricevuta = gf.readFile("fileDaLeggere.txt",getApplicationContext());
                testo.setText(stringaricevuta);
                Toast.makeText(getApplicationContext(),"letto con successo", Toast.LENGTH_LONG).show();
            }
        });
        btn_scrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), gf.scriviFile("fileDaLeggere.txt",text.getText().toString(),getApplicationContext()), Toast.LENGTH_LONG).show();
            }
        });
    }
    public void init(){
        btn_leggi=(Button) findViewById(R.id.btn_leggi);
        btn_scrivi=(Button) findViewById(R.id.btn_scrivi);
        testo=(TextView) findViewById(R.id.testo);
        text=(EditText) findViewById(R.id.userText);
        gf = new GestoreFile();
    }
}