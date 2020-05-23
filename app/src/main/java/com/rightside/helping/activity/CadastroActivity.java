package com.rightside.helping.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.rightside.helping.R;
import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.models.Pessoa;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroActivity extends AppCompatActivity {

    @BindView(R.id.editText_nome) TextInputEditText editTextNome;
    @BindView(R.id.spinner_tipo) Spinner spinnerTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        ButterKnife.bind(this);
        configuraSpinner();
        Bundle bundle = getIntent().getExtras();
        String nome = bundle.getString("nomeUsuario");
        editTextNome.setText(nome);
    }

    @OnClick(R.id.button_cadastro)
    public void salvarUsuario(){
        String nome = editTextNome.getText().toString();
        String tipo = spinnerTipo.getSelectedItem().toString();
        Pessoa p = new Pessoa(nome, FirebaseRepository.getIdPessoaLogada(), tipo);

        FirebaseRepository.salvarPessoa(p).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    finish();
                }
            }
        });

    }

    private void configuraSpinner() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tipos_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipo.setAdapter(adapter);
    }
}
