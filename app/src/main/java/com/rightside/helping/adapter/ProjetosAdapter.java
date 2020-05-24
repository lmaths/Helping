package com.rightside.helping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.helping.R;
import com.rightside.helping.models.Projeto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        holder.projetoPonto.setText("Votos\n" + projeto.getQuantidadeDeVotos());
        holder.projetoNome.setText(projeto.getNome());

        switch (position){
            case 0:
                holder.imageViewPosicao.setImageResource(R.drawable.gold);
                holder.imageViewPosicao.setVisibility(View.VISIBLE);
                break;
            case 1:
                holder.imageViewPosicao.setImageResource(R.drawable.silver);
                holder.imageViewPosicao.setVisibility(View.VISIBLE);
                break;
            case 2:
                holder.imageViewPosicao.setImageResource(R.drawable.bronze);
                holder.imageViewPosicao.setVisibility(View.VISIBLE);
                break;
        }
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
        @BindView(R.id.textView_nome_projeto) TextView projetoNome;
        @BindView(R.id.textView_pontos) TextView projetoPonto;
        @BindView(R.id.imageView_posicao) ImageView imageViewPosicao;

        public ProjetosViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
