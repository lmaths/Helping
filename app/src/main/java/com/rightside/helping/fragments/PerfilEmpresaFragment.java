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
        Pessoa p = new Pessoa("1", "Sicoob", "sac@sicoob.com.br", getString(R.string.foto_perfil), "0800 725 0996");

        textViewNome.setText(p.getNome());
        textViewEmail.setText(p.getEmail());
        textViewTelefone.setText(p.getTelefone());
        textViewLevel.setText("Jedi");
        textViewDescricao.setText("O Sistema de Cooperativas de Crédito (Sicoob) é o maior sistema financeiro cooperativo do Brasil com mais de 4,3 milhões de cooperados, " +
                "2,8 mil pontos de atendimento, distribuídos em todo país. É composto por cooperativas financeiras e empresas de apoio, que em conjunto oferecem aos cooperados " +
                "serviços de conta corrente, crédito, investimento, cartões, previdência, consórcio, seguros, cobrança bancária, adquirência de meios eletrônicos de pagamento, " +
                "dentre outros.");
        progressBar.setProgress(89);
        textViewProgresso.setText(progressBar.getProgress() + "/100");
        Glide.with(this).load(p.getFoto()).circleCrop().into(imageViewFoto);

        return view;
    }
}
