package com.rightside.helping.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rightside.helping.R;
import com.rightside.helping.adapter.ProjetosAdapter;
import com.rightside.helping.models.Projeto;
import com.rightside.helping.viewmodels.ViewModelProjetos;
import com.rightside.helping.viewmodels.ViewModelRanking;

import java.util.List;

import lombok.val;

public class RankingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_ranking);
        ProjetosAdapter projetosAdapter = new ProjetosAdapter();

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(projetosAdapter);
        val viewModelRanking = new ViewModelProvider(this).get(ViewModelRanking.class);

        viewModelRanking.getCadastrados().observe(this, projetoList -> {
            projetosAdapter.atualizaProjetos(projetoList);
        });


    }
}
