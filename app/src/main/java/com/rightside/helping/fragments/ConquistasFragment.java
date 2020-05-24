package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.rightside.helping.R;
import com.rightside.helping.adapter.ConquistaAdapter;
import com.rightside.helping.models.Conquista;
import com.rightside.helping.models.Recompensa;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConquistasFragment extends Fragment {

    private List<Conquista> conquistas = new ArrayList<>();
    private List<Recompensa> recompensas = new ArrayList<>();
    private ConquistaAdapter adapter;

    @BindView(R.id.recyclerView_conquistas) RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conquistas, container, false);
        ButterKnife.bind(this, view);
        adapter = new ConquistaAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);

        Conquista c1 = new Conquista(R.drawable.partner,"Parceiro", "Realizar mais de 10 compras no estabelecimento", 35);
        Conquista c2 = new Conquista(R.drawable.star,"Eu quero!", "Adicionar um produto ao favorito", 10);
        Conquista c3 = new Conquista(R.drawable.box, "Que venha!", "Comprar um produto para entrega", 20 );
        Conquista c4 = new Conquista(R.drawable.creditcard, "Compre com cartão", "Faça uma compra usando seu cartão de crédito", 30);
        Conquista c5 = new Conquista(R.drawable.podium,"Os melhores", "Compre em uma empresa com nível Mestre+", 50);

        Recompensa r1 = new Recompensa("", "5% de desconto!", "Receba 5% de desconto em todas as suas compras á vista","Intermediario Iniciante","RECOMPENSA" );
        Recompensa r2 = new Recompensa("", "15% de desconto!", "Receba 15% de desconto em todas as suas compras á vista","Intermediario","RECOMPENSA" );
        Recompensa r3 = new Recompensa("", "20% de desconto!", "Receba 20% de desconto em todas as suas compras á vista","Intermediario Mestre","RECOMPENSA" );


        conquistas.add(c1);
        conquistas.add(c2);
        conquistas.add(c3);
        conquistas.add(c4);
        conquistas.add(c5);

        adapter.atualizaConquistas(conquistas, 0);
        recompensas.add(r1);
        recompensas.add(r2);
        recompensas.add(r3);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    adapter.atualizaConquistas(conquistas, 0);
                } else {
                    adapter.atualizaConquistas(recompensas, 1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }

}
