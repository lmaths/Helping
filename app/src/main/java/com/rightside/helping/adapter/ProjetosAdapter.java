package com.rightside.helping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.helping.R;
import com.rightside.helping.models.Projeto;

import java.util.List;

public class ProjetosAdapter extends RecyclerView.Adapter<ProjetosAdapter.ProjetosViewHolder> {

    private List<Projeto> projetoList;

    public ProjetosAdapter() {

    }

    @NonNull
    @Override
    public ProjetosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_projetos, parent, false);
       return new ProjetosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjetosViewHolder holder, int position) {
        Projeto projeto = projetoList.get(position);
        holder.projetoPonto.setText(String.valueOf(projeto.getPontos()));
        holder.projetoNome.setText(projeto.getNome());
    }

    @Override
    public int getItemCount() {
        if(projetoList == null) {
            return 0;
        }
        return projetoList.size();
    }

    public void atualizaProjetos(List<Projeto> projetoList) {
        this.projetoList = projetoList;
        notifyDataSetChanged();
    }

    class ProjetosViewHolder extends RecyclerView.ViewHolder {
        TextView projetoNome, projetoPonto;

        public ProjetosViewHolder(@NonNull View itemView) {
            super(itemView);
            projetoNome = itemView.findViewById(R.id.textView_projeto_nome);
            projetoPonto = itemView.findViewById(R.id.textView_projeto_pontos);
        }
    }
}
