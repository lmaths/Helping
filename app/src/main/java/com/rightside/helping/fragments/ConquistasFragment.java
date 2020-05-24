package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.helping.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConquistasFragment extends Fragment {

    public ConquistasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_conquistas, container, false);


        return view;
    }
}
