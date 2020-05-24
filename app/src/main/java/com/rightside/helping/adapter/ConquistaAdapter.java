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
import com.rightside.helping.adapter.ConquistaAdapter.ConquistaViewHolder;
import com.rightside.helping.models.Conquista;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConquistaAdapter extends RecyclerView.Adapter<ConquistaViewHolder> {

    List<Conquista> conquistas;
    Context context;

    public ConquistaAdapter(List<Conquista> conquistas, Context context) {
        this.conquistas = conquistas;
        this.context = context;
    }

    @NonNull
    @Override
    public ConquistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_conquista, parent, false);

        return new ConquistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConquistaViewHolder holder, int position) {
        Conquista c = conquistas.get(position);

        holder.textViewNome.setText(c.getNome());
        holder.textViewDescricao.setText(c.getDescricao());
        holder.textViewXp.setText("EXP +" + c.getXp());
    }

    @Override
    public int getItemCount() {
        return conquistas.size();
    }

    public class ConquistaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textView_nome_conquista) TextView textViewNome;
        @BindView(R.id.textView_descricao_conquista) TextView textViewDescricao;
        @BindView(R.id.imageView_icone_conquista) ImageView imageViewIcone;
        @BindView(R.id.textView_xp) TextView textViewXp;

        public ConquistaViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
