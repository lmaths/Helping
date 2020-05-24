package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.helping.R;
import com.rightside.helping.adapter.PromocaoAdapter;
import com.rightside.helping.models.Promocao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromocoesFragment extends Fragment {

    @BindView(R.id.recyclrView_promocoes) RecyclerView recyclerViewPromocoes;

    private List<Promocao> promocoes = new ArrayList<>();
    private PromocaoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promocoes, container, false);
        ButterKnife.bind(this, view);
        setPromocoes();

        return view;
    }

    private void setPromocoes(){
        Promocao p = new Promocao("1", "Leite em pó",
                "https://ecila.com.br/wp-content/uploads/2018/01/leite-em-po.png",
                12.90, 8.99);
        Promocao p2 = new Promocao("2", "Pão",
                "https://img.itdg.com.br/tdg/images/recipes/000/002/658/277270/277270_original.jpg?mode=crop&width=710&height=400",
                0.50, 0.35);
        Promocao p3 = new Promocao("3", "Presunto",
                "https://i.ytimg.com/vi/WKXt8f07RSo/maxresdefault.jpg",
                15.90, 11.50);
        promocoes.add(p);
        promocoes.add(p2);
        promocoes.add(p3);

        recyclerViewPromocoes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PromocaoAdapter(promocoes, getContext());
        recyclerViewPromocoes.setAdapter(adapter);
    }
}
