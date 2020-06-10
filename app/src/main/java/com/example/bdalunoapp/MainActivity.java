package com.example.bdalunoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //CREATE DB
            SQLiteDatabase bdAlunos = openOrCreateDatabase("AppAlunos", MODE_PRIVATE, null);
            bdAlunos.execSQL("CREATE TABLE IF NOT EXISTS tbAluno (name VARCHAR, email VARCHAR, tel VARCHAR)");


            //INSERTS bdAlunos
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Lucas', 'lucas.pu007@gmail.com', '1234-5678')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Pedro', 'pe.soares@yahoo.com', '4002-8927')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Amanda', 'amanda.Nass@gmail.com', '2132-0990')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Robson', 'robson8564@hotmail.com', '5527-7667')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Leonardo', 'shaollin@gmail.com', '5624-6024')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Ronald', 'ronald.ceo90@outlook.com', '4002-8922')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Mariana', 'marianaecorp@gmail.com', '1567-2775')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Joana', 'joana.moraes@etec.sp.gov.br', '8665-8123')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Moana', 'moanasilva@gmail.com', '3101-1141')");
            bdAlunos.execSQL("INSERT INTO tbAluno(name, email, tel) VALUES ('Flavia', 'flaviaaraujo80@hotmail.com', '5526-8076')");

            Cursor cursor = bdAlunos.rawQuery("SELECT nome, email, telefone FROM tbAluno", null);


            int IndNome = cursor.getColumnIndex("name");
            int IndEmail = cursor.getColumnIndex("email");
            int IndTel = cursor.getColumnIndex("tel");

            cursor.moveToFirst();
            while (cursor != null){
                Log.i("resultado - nome: ", cursor.getString(IndNome));
                Log.i("resultado - email: ", cursor.getString(IndEmail));
                Log.i("resultado - tel: ", cursor.getString(IndTel));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}