package com.smkn4bdg.webViewFirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smkn4bdg.webViewFirebase.Model.MusicList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference MusicArtist;
    Spinner spinnerDat;
    EditText etData;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MusicArtist = FirebaseDatabase.getInstance().getReference("musics");
        etData = (EditText) findViewById(R.id.et_musics);
        spinnerDat = (Spinner) findViewById(R.id.spinner) ;
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
    }

    public void addArtist(){
        String name = etData.getText().toString().trim();
        String genre = spinnerDat.getSelectedItem().toString();

       if(TextUtils.isEmpty("name")){
           String id = MusicArtist.push().getKey();
           MusicList musicList = new MusicList(id,name,genre);

          MusicArtist.child(id).setValue(musicList);

       }else{
           Toast.makeText(null,"Database gagal",Toast.LENGTH_LONG).show();
       }
    }
}
