package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.helping.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovoProjetoDialogFragment extends Fragment {

    public NovoProjetoDialogFragment novaInstancia() {
        NovoProjetoDialogFragment novoProjetoDialogFragment = new NovoProjetoDialogFragment();
        return novoProjetoDialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_projeto_dialog, container, false);
        ButterKnife.bind(this, view);



        return view;
    }
}
