package com.example.uasnim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
    }
    public void simpanDiKlik(View v){
        Toast.makeText(this.getBaseContext(), "Tersimpan", Toast.LENGTH_SHORT).show();

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        SharedPreferences.Editor edit = SP.edit();

        String IdUser = ((EditText) findViewById(R.id.IdNim)).getText().toString();
        String IdPass1 = ((EditText) findViewById(R.id.IdNama)).getText().toString();
        String IdPass2 = ((EditText) findViewById(R.id.IdNama)).getText().toString();

        if(!IdPass1.equals(IdPass2)) {
            Toast.makeText(this.getBaseContext(),"Password tidak sama", Toast.LENGTH_LONG).show();
            return;
        }

        edit.putString("user", IdUser);
        edit.putString("password", IdPass1);

        edit.commit();

        Toast.makeText(this.getBaseContext(), "Simpan data berhasil", Toast.LENGTH_SHORT).show();

    }
}