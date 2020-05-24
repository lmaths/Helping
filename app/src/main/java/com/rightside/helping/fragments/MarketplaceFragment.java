package com.rightside.helping.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.helping.R;
import com.rightside.helping.adapter.ProdutoAdapter;
import com.rightside.helping.models.Produto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarketplaceFragment extends Fragment {

    @BindView(R.id.recycler_view_market_place) RecyclerView recyclerView;

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_marketplace, container, false);
        ButterKnife.bind(this,view);
        setProdutos();

        return view;
    }

    private void setProdutos(){
        Produto pao = new Produto("1", "Pão Francês", 1.00, "https://smartsupermercados.com/wp-content/uploads/2019/06/pao_0.jpeg");
        Produto paoDoce = new Produto("2", "Pão doce", 1.50, "https://abrilmdemulher.files.wordpress.com/2016/10/receita-pao-doce-recheado-creme-laranja1.jpg?quality=90&strip=info&w=620&h=372&crop=1");
        Produto rosquinha = new Produto("3", "Rosquinha", 0.75, "https://cdn.guiadacozinha.com.br/wp-content/uploads/2019/10/rosquinha-frita.jpg");

        produtos.add(pao);
        produtos.add(paoDoce);
        produtos.add(rosquinha);
        ProdutoAdapter produtoAdapter = new ProdutoAdapter(produtos, getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(produtoAdapter);
    }
}
