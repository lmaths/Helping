package com.rightside.helping.fragments;

import android.app.Dialog;
import android.media.Rating;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.rightside.helping.R;
import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.models.Projeto;
import com.rightside.helping.utils.GeralUtils;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class VotacaoFragment extends DialogFragment {

    private RatingBar ratingBar;
    private Projeto projeto;

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_votacao, container, false);
        ratingBar = view.findViewById(R.id.ratingBar_projetos);
        Button button = view.findViewById(R.id.button_votar);
        ImageView imageViewFoto = view.findViewById(R.id.imageView_foto_projetista);
        ratingBar.setMax(5);

       Bundle bundle = getArguments();
       String idProjeto = bundle.getString("id");

       FirebaseRepository.getProjeto(idProjeto).addSnapshotListener((documentSnapshot, e) -> {
            if(documentSnapshot.exists()) {
                projeto =  documentSnapshot.toObject(Projeto.class);
            }
       });

        GeralUtils.criaImagemCircular(getContext(), "https://media-exp1.licdn.com/dms/image/C4E03AQHnXO_fLFlLEQ/profile-displayphoto-shrink_200_200/0?e=1596067200&v=beta&t=wOJypA_b993EZMjnGnHDWFlZ6kaEz0LJ9TbGcfFEklw", imageViewFoto);

       button.setOnClickListener(view1 -> {
           projeto.setPontos(projeto.getPontos() +  (int) ratingBar.getRating());
           projeto.setQuantidadeDeVotos(projeto.getQuantidadeDeVotos() + 1);
            FirebaseRepository.salvarVoto(projeto);
       });


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog!= null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
