package com.example.wanderson.trabalhoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main2Activity extends AppCompatActivity {
    RadioGroup radioGroupSexo;
    RadioButton radioButtonEscolhido;
    CheckBox checkBoxIngles;
    CheckBox checkBoxEspanhol;
    CheckBox checkBoxItaliano;
    CheckBox checkBoxFrances;
    Spinner spinnerEstado;
    Spinner spinnerCidade;
    Button buttonCadastro;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addListenerSpinnerEstado();
        addListenerSpinnerCidade();

        toggleButton = findViewById(R.id.toggleButton);
        buttonCadastro = findViewById(R.id.buttonCadastro);

        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    addListenerOnButton();
                    onCheckbox();

                    String itemEstado = spinnerEstado.getSelectedItem().toString();
                    Log.i("Dados"," Estado: "+itemEstado);

                    String itemCidade = spinnerCidade.getSelectedItem().toString();
                    Log.i("Dados", "Cidade: "+itemCidade);
                    Toast.makeText(Main2Activity.this, "Cadastro Realizados Com Susseco!!!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Main2Activity.this, "Click em Aceitar nossos Termos de Uso", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void addListenerOnButton() {
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        int selectedId = radioGroupSexo.getCheckedRadioButtonId();
        radioButtonEscolhido = findViewById(selectedId);
        Log.i("Dados", "Sexo: "+(String) radioButtonEscolhido.getText());
    }

    public void onCheckbox() {
        checkBoxIngles = findViewById(R.id.checkBoxIngles);
        checkBoxEspanhol = findViewById(R.id.checkBoxEspanhol);
        checkBoxItaliano = findViewById(R.id.checkBoxItaliano);
        checkBoxFrances = findViewById(R.id.checkBoxFrances);
        if (checkBoxIngles.isChecked()) {
            Log.i("Dados","Idioma: "+ (String) checkBoxIngles.getText());
        }
        if (checkBoxEspanhol.isChecked()) {
            Log.i("Dados", "Idioma: "+ (String) checkBoxEspanhol.getText());
        }
        if (checkBoxItaliano.isChecked()) {
            Log.i("Dados","Idioma: "+ (String) checkBoxItaliano.getText());
        }
        if (checkBoxFrances.isChecked()) {
            Log.i("Dados","Idioma: "+ (String) checkBoxFrances.getText());
        }
    }

    public void addListenerSpinnerEstado() {

        spinnerEstado = findViewById(R.id.spinnerEstado);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estado_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstado.setAdapter(adapter);
    }

    public void addListenerSpinnerCidade() {

        spinnerCidade = findViewById(R.id.spinnerCidade);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cidade_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCidade.setAdapter(adapter);
    }
}
