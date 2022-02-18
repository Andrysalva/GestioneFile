package com.example.filemanager;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class GestoreFile {

    String nomeFile;

    public GestoreFile(){

    }

    public GestoreFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public String readFile(String nf, Context c){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(c.openFileInput(nf)));
            String str = "";
            while((str = reader.readLine())  != null ){
                sb.append(str + "\n");
            }
        } catch (FileNotFoundException e) {
            Log.e("gestione","file inesistente");
        } catch (IOException e) {
            Log.e("gestione","errore nella lettura");
        }
        return sb.toString();
    }

    public String scriviFile(String nf, String content, Context c){
        String esito = "File creato con successo ";
        FileOutputStream file;
        try{
            file = c.openFileOutput(nf,Context.MODE_PRIVATE);
            file.write(content.getBytes());
            file.close();
        } catch (FileNotFoundException e) {
            Log.e("gestione","file inesistente");
            esito = "errore";
        } catch (IOException e) {
            Log.e("gestione","errore nella lettura");
            esito = "errore";
        }
        return esito;
    }

    public String scriviFileBuffered(String nf, String content, Context c){
        String esito = "File creato con successo ";
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new OutputStreamWriter(c.openFileOutput(nf,Context.MODE_PRIVATE)));
            writer.write(content);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("gestione","file inesistente");
            esito = "file inesistente";
        } catch (IOException e) {
            Log.e("gestione","errore generico nella lettura");
            esito = "errore generico nella lettura";
        }
        return esito;
    }

    public String leggiRawFile(String nf, Context c){
        Resources res = c.getResources();
        InputStream is= res.openRawResource(R.raw.filedaleggere);
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while((str = reader.readLine())  != null ){
                sb.append(str + "\n");
            }
        } catch (FileNotFoundException e) {
            Log.e("gestione","file inesistente");
        } catch (IOException e) {
            Log.e("gestione","errore nella lettura");
        }
        return sb.toString();
    }

    public String getNomeFile() {
        return nomeFile;
    }

    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }
}
