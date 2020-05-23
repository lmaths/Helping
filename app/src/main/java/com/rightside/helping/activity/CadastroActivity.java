package com.rightside.helping.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.rightside.helping.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroActivity extends AppCompatActivity {

    @BindView(R.id.editText_nome) TextInputEditText editTextNome;
    @BindView(R.id.spinner_tipo) Spinner spinnerTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);
        configuraSpinner();
    }

    private void configuraSpinner() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tipos_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapter);
    }
}
