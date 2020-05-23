package com.rightside.helping.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rightside.helping.R;
import com.rightside.helping.adapter.ProdutoAdapter;
import com.rightside.helping.models.Produto;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProdutosActivity extends AppCompatActivity {

    @BindView(R.id.recyclrView_produtos) RecyclerView recyclerView;

    private List<Produto> produtos = new ArrayList<>();
    private ProdutoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        ButterKnife.bind(this);
        setProdutos();

    }

    private void setProdutos() {
        Produto p = new Produto("1", "Arroz", 12.90);
        produtos.add(p);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new ProdutoAdapter(produtos, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
