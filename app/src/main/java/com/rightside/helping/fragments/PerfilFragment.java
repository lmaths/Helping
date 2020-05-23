package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rightside.helping.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ImageView imageViewFoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        imageViewFoto = view.findViewById(R.id.imageView_perfil);

        Glide.with(getActivity()).load(getString(R.string.foto_perfil)).circleCrop().into(imageViewFoto);

        return view;
    }
}
