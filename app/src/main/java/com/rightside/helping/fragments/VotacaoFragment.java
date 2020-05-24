package com.rightside.helping.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.rightside.helping.R;
import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.models.Pessoa;
import com.rightside.helping.models.Projeto;
import com.rightside.helping.utils.GeralUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotacaoFragment extends DialogFragment {

    @BindView(R.id.ratingBar_projetos) RatingBar ratingBar;
    @BindView(R.id.button_votar) Button buttonVotar;
    @BindView(R.id.imageView_foto_projetista) ImageView imageViewFoto;
    @BindView(R.id.textView_titulo_projeto) TextView textViewNomeProjeto;
    @BindView(R.id.textView_descricao_projeto) TextView textViewDescricaoProjeto;
    @BindView(R.id.text_view_autor_projeto) TextView textViewAutorProjeto;
    @BindView(R.id.text_view_pontos) TextView textViewPontos;
    private Projeto projeto;
    private Pessoa pessoa;

    public static VotacaoFragment novaInstancia(String idProjeto) {
        VotacaoFragment votacaoFragment = new VotacaoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", idProjeto);
        votacaoFragment.setArguments(bundle);
        return votacaoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_votacao, container, false);
        ButterKnife.bind(this, view);

        ratingBar.setMax(5);

        Bundle bundle = getArguments();
        String idProjeto = bundle.getString("id");

        FirebaseRepository.getProjeto(idProjeto).addSnapshotListener((documentSnapshot, e) -> {
            if (documentSnapshot.exists()) {
                projeto = documentSnapshot.toObject(Projeto.class);
                textViewNomeProjeto.setText(projeto.getNome());
                textViewDescricaoProjeto.setText(projeto.getDescricao());
                textViewPontos.setText(String.valueOf(projeto.getPontos()) + " gostaram");
            }
        });


        FirebaseRepository.getPessoa(idProjeto).addSnapshotListener((documentSnapshot, e) -> {
            pessoa = documentSnapshot.toObject(Pessoa.class);
            GeralUtils.criaImagemCircular(getContext(), pessoa.getFoto(), imageViewFoto);
            textViewAutorProjeto.setText(pessoa.getNome());

        });


        buttonVotar.setOnClickListener(view1 -> {
            projeto.setPontos(projeto.getPontos() + (int) ratingBar.getRating());
            projeto.setQuantidadeDeVotos(projeto.getQuantidadeDeVotos() + 1);
            FirebaseRepository.salvarVoto(projeto);
        });


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
