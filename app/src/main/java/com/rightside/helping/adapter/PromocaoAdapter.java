package com.rightside.helping.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rightside.helping.R;
import com.rightside.helping.adapter.PromocaoAdapter.PromocaoViewHolder;
import com.rightside.helping.models.Promocao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.rightside.helping.utils.GeralUtils.formataMoeda;

public class PromocaoAdapter extends RecyclerView.Adapter<PromocaoViewHolder> {

    List<Promocao> promocoes;
    Context context;

    public PromocaoAdapter(List<Promocao> promocoes, Context context) {
        this.promocoes = promocoes;
        this.context = context;
    }

    @NonNull
    @Override
    public PromocaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_promocao, parent, false);

        return new PromocaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromocaoViewHolder holder, int position) {
        Promocao p = promocoes.get(position);

        holder.textViewNome.setText(p.getNome());
        holder.textViewPrecoOriginal.setText("De: " + formataMoeda(p.getPrecoOriginal()));
        holder.textViewPrecoPromocao.setText("Por: " + formataMoeda(p.getPrecoPromocao()));
        Glide.with(holder.itemView).load(p.getFoto()).centerCrop().into(holder.imageViewProduto);
    }

    @Override
    public int getItemCount() {
        return promocoes.size();
    }

    public class PromocaoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textView_nome_produto) TextView textViewNome;
        @BindView(R.id.textView_preco_original) TextView textViewPrecoOriginal;
        @BindView(R.id.textView_preco_promocao) TextView textViewPrecoPromocao;
        @BindView(R.id.imageView_produto) ImageView imageViewProduto;

        public PromocaoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            textViewPrecoOriginal.setPaintFlags(textViewPrecoOriginal.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
