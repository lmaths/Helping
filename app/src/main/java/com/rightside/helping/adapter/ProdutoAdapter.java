package com.rightside.helping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rightside.helping.R;
import com.rightside.helping.adapter.ProdutoAdapter.ProdutoViewHolder;
import com.rightside.helping.models.Produto;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.rightside.helping.utils.GeralUtils.formataMoeda;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoViewHolder> {

    List<Produto> produtos ;
    Context context;

    public ProdutoAdapter(List<Produto> produtos, Context context) {
        this.produtos = produtos;
        this.context = context;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto, parent, false);
        return new ProdutoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoViewHolder holder, int position) {
        Produto p = produtos.get(position);
        holder.textViewNome.setText(p.getNome());
        holder.textViewPreco.setText(formataMoeda(p.getPreco()));
        Glide.with(context).load(p.getUrl()).into(holder.imageViewFotoProduto);
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ProdutoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textView_nome_produto) TextView textViewNome;
        @BindView(R.id.textView_preco_produto) TextView textViewPreco;
        @BindView(R.id.imageView) ImageView imageViewFotoProduto;

        public ProdutoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
