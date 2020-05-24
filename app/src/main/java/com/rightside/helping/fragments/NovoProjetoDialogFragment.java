package com.rightside.helping.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.rightside.helping.R;
import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.models.Projeto;
import com.rightside.helping.utils.GeralUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovoProjetoDialogFragment extends DialogFragment {

    @BindView(R.id.editText_nome_projeto) TextView textViewNomeProjeto;
    @BindView(R.id.editText_descricao_projeto) TextView textViewDescricaoProjeto;

    private double latitude, longitude;

    public static NovoProjetoDialogFragment novaInstancia(double latitude, double longitude) {
        NovoProjetoDialogFragment novoProjetoDialogFragment = new NovoProjetoDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putDouble("latitude", latitude);
        bundle.putDouble("longitude", longitude);
        novoProjetoDialogFragment.setArguments(bundle);
        return novoProjetoDialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_projeto_dialog, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
         latitude = bundle.getDouble("latitude");
         longitude = bundle.getDouble("longitude");
        return view;
    }

    @OnClick(R.id.button_salvar_projeto)
    public void salvarProjeto() {
        Projeto projeto = new Projeto(FirebaseRepository.getIdPessoaLogada(), textViewNomeProjeto.getText().toString(), textViewDescricaoProjeto.getText().toString(), latitude, longitude);
        FirebaseRepository.salvarProjeto(projeto);
        dismiss();
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
