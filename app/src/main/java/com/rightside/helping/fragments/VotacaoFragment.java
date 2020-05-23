package com.rightside.helping.fragments;

import android.app.Dialog;
import android.media.Rating;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.rightside.helping.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotacaoFragment extends DialogFragment {

    private RatingBar ratingBar;

    public static VotacaoFragment novaInstancia(String idProjeto) {
        VotacaoFragment votacaoFragment = new VotacaoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("id", idProjeto);
        votacaoFragment.setArguments(bundle);
        return votacaoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_votacao, container, false);
       ratingBar = view.findViewById(R.id.ratingBar_projetos);
        Button button = view.findViewById(R.id.button_votar);

       ratingBar.setNumStars(5);

       button.setOnClickListener(view1 -> {
           Toast.makeText(getContext(), "Você votou no projeto", Toast.LENGTH_SHORT).show();
       });


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog!= null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
