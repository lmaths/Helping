package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rightside.helping.R;
import com.rightside.helping.models.Pessoa;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilEmpresaFragment extends Fragment {

    @BindView(R.id.imageView_perfil) ImageView imageViewFoto;
    @BindView(R.id.textView_nome_perfil) TextView textViewNome;
    @BindView(R.id.textView_email_perfil) TextView textViewEmail;
    @BindView(R.id.textView_telefone) TextView textViewTelefone;
    @BindView(R.id.textView_nome_do_level) TextView textViewLevel;
    @BindView(R.id.textView_descricao_perfil) TextView textViewDescricao;

    @BindView(R.id.progressBar_xp) ProgressBar progressBar;
    @BindView(R.id.textView_progresso) TextView textViewProgresso;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil_empresa, container, false);
        ButterKnife.bind(this, view);
        Pessoa p = new Pessoa("1", "Padaria Pão Gostoso", "paogostoso@gmail.com", "https://blog.sebraees.com.br/wp-content/uploads/2019/05/padaria-1.jpg", "(22) 98765-4321");

        textViewNome.setText(p.getNome());
        textViewEmail.setText(p.getEmail());
        textViewTelefone.setText(p.getTelefone());
        textViewLevel.setText("Mestre");
        textViewDescricao.setText("A Padaria Pão Gostoso reúne em um único espaço delicias gastronômicas de encher a boca d’água. " +
                "São 10 seções distribuídas em um ambiente confortável e funcional, tudo para que você se sinta totalmente a vontade..");
        progressBar.setProgress(89);
        textViewProgresso.setText(progressBar.getProgress() + "/100");
        Glide.with(this).load(p.getFoto()).circleCrop().into(imageViewFoto);

        return view;
    }
}
