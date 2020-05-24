package com.rightside.helping.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.helping.R;
import com.rightside.helping.adapter.ProjetosAdapter;
import com.rightside.helping.viewmodels.ViewModelRanking;

import lombok.val;

public class RankingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_ranking);
        ProjetosAdapter projetosAdapter = new ProjetosAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(projetosAdapter);
        val viewModelRanking = new ViewModelProvider(this).get(ViewModelRanking.class);

        viewModelRanking.getCadastrados().observe(this, projetoList -> {
            projetosAdapter.atualizaProjetos(projetoList);
        });


    }
}
