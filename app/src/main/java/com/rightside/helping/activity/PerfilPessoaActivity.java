package com.rightside.helping.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rightside.helping.R;
import com.rightside.helping.models.Pessoa;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfilPessoaActivity extends AppCompatActivity {

    @BindView(R.id.textView_nome_perfil) TextView textViewNome;
    @BindView(R.id.textView_email_perfil) TextView textViewEmail;
    @BindView(R.id.imageView_perfil) ImageView imageViewFoto;
    @BindView(R.id.textView_nome_do_level) TextView textViewLevel;
    @BindView(R.id.progressBar_xp) ProgressBar progressBar;
    @BindView(R.id.textView_progresso) TextView textViewProgresso;

    private String foto = "https://instagram.fitp1-1.fna.fbcdn.net/v/t51.2885-15/e35/70896049_406990440015205_6863133250444648192_n.jpg" +
            "?_nc_ht=instagram.fitp1-1.fna.fbcdn.net&_nc_cat=101&_nc_ohc=aEyeRipTB7AAX_jMHrM&oh=2cb5dced3bf925d866a5b8c9083fee3b&oe=5EF4D6A5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_pessoa);
        ButterKnife.bind(this);

        Pessoa p = new Pessoa("1", "Ivan Viana", "ivan.viana@live.com", foto, "28 999741833", "");

        textViewNome.setText(p.getNome());
        textViewEmail.setText(p.getEmail());
        textViewLevel.setText("Iniciante");
        progressBar.setProgress(32);
        textViewProgresso.setText(progressBar.getProgress() + "/100");
        Glide.with(this).load(p.getFoto()).circleCrop().into(imageViewFoto);
    }
}