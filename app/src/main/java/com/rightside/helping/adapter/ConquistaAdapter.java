package com.rightside.helping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rightside.helping.R;
import com.rightside.helping.adapter.ConquistaAdapter.ConquistaViewHolder;
import com.rightside.helping.models.Conquista;
import com.rightside.helping.models.Recompensa;
import com.rightside.helping.utils.ConstantUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.rightside.helping.utils.GeralUtils.criaImagemCircular;

public class ConquistaAdapter extends RecyclerView.Adapter<ConquistaViewHolder> {

   private List<?> conquistas;
    private Context context;
    private int tipo;

    public ConquistaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ConquistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_conquista, parent, false);
        if(viewType == 0){
            return new ConquistaViewHolder(view);
        }else{
            return new ConquistaViewHolder(view);
        }
    }


    @Override
    public int getItemViewType(int position) {
        try{
            Conquista conquista = (Conquista) conquistas.get(position);
            return 0;
        }catch (Exception e){
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ConquistaViewHolder holder, int position) {

        if(tipo == 0) {
            Conquista c = (Conquista) conquistas.get(position);
            holder.textViewNome.setText(c.getNome());
            Glide.with(context).load(c.getIcone()).into(holder.imageViewIcone);
            holder.textViewDescricao.setText(c.getDescricao());
            holder.textViewXp.setText("EXP +" + c.getXp());
        } else if(tipo == 1) {
            Recompensa recompensa = (Recompensa) conquistas.get(position);
            Glide.with(context).load(recompensa.getIcone()).into(holder.imageViewIcone);
            holder.textViewNome.setText(recompensa.getNome());
            holder.textViewDescricao.setText(recompensa.getDescricao());
            holder.textViewXp.setText("Level necessário +" + recompensa.getLevel());
        }

    }

    @Override
    public int getItemCount() {

        if(conquistas == null) {
            return 0;
        }
        return conquistas.size();
    }


    public void atualizaConquistas(List<?> conquistaList, int tipo) {
        this.conquistas = conquistaList;
        this.tipo = tipo;
        notifyDataSetChanged();
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
