package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.helping.R;
import com.rightside.helping.adapter.ConquistaAdapter;
import com.rightside.helping.models.Conquista;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConquistasFragment extends Fragment {

    private List<Conquista> conquistas = new ArrayList<>();
    private ConquistaAdapter adapter;

    @BindView(R.id.recyclerView_conquistas) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conquistas, container, false);
        ButterKnife.bind(this, view);
        setConquistas();

        return view;
    }

    private void setConquistas() {
        Conquista c1 = new Conquista(R.drawable.partner,"Parceiro", "Realizar mais de 10 compras no estabelecimento", 35);
        Conquista c2 = new Conquista(R.drawable.star,"Eu quero!", "Adicionar um produto ao favorito", 10);
        Conquista c3 = new Conquista(R.drawable.box, "Que venha!", "Comprar um produto para entrega", 20 );
        Conquista c4 = new Conquista(R.drawable.creditcard, "Compre com cartão", "Faça uma compra usando seu cartão de crédito", 30);
        Conquista c5 = new Conquista(R.drawable.podium,"Os melhores", "Compre em uma empresa com nível Mestre+", 50);
        conquistas.add(c1);
        conquistas.add(c2);
        conquistas.add(c3);
        conquistas.add(c4);
        conquistas.add(c5);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ConquistaAdapter(conquistas, getContext());
        recyclerView.setAdapter(adapter);
    }
}
