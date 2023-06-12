package com.example.uasnim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText IdNim;
    EditText IdNama;
    Button tombolLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IdNim = (EditText) findViewById(R.id.IdNim);
        IdNama = (EditText) findViewById(R.id.IdNama);

        tombolLogin = (Button) findViewById(R.id.tombolOk);
        tombolLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                tombolLoginKlik();
            }
        });

    }

    public void setTombolLogindiKlik(View view){
        tombolLoginKlik();
    }



    public void tombolLoginKlik(){

        String user, pswd;
        user = IdNim.getText().toString();
        pswd = IdNama.getText().toString();


        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String IdNim= SP.getString("user", "2003030007");

        String IdNama= SP.getString("password","Admin");


        if(user.equals(IdNim) && pswd.equals(IdNama)){


            Intent Menu2 = new Intent(this, MenuActivity2.class);


            Bundle data = new Bundle();
            data.putString("User", user);
            Menu2.putExtras(data);


            startActivity(Menu2);



        }else{
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();Toast.makeText(this.getBaseContext(),"User atau password salah", Toast.LENGTH_LONG).show();
        }
    }
    public void RegistrasiDiklik(View v){
        Intent i = new Intent(this.getBaseContext(),com.example.uasnim.MenuActivity2.class);
        startActivity(i);
    }

}
