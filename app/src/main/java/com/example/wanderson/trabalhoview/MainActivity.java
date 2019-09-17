package com.example.wanderson.trabalhoview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btButton;
    EditText editTextNome;
    EditText editTextTelefone;
    EditText editTextEmail;
    EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btButton = findViewById(R.id.buttonSalvar);
        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextSenha = findViewById(R.id.editTextSenha);

        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextNome.getText().toString().trim().equals("") ||
                        editTextTelefone.getText().toString().trim().equals("") ||
                        editTextEmail.getText().toString().trim().equals("") ||
                        editTextSenha.getText().toString().trim().equals("")) {

                    Toast.makeText(MainActivity.this, "Dados Incopleto", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i("Dados", "Nome: " + editTextNome.getText().toString());
                    Log.i("Dados", "Telefone: " + editTextTelefone.getText().toString());
                    Log.i("Dados", "Email: " + editTextEmail.getText().toString());
                    Log.i("Dados", "Senha: " + editTextSenha.getText().toString());

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
