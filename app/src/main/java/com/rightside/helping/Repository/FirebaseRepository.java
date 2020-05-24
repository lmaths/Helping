package com.rightside.helping.Repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rightside.helping.models.Pessoa;
import com.rightside.helping.models.Produto;
import com.rightside.helping.models.Projeto;
import com.rightside.helping.utils.ConstantUtils;

import java.util.List;

public class FirebaseRepository {

    private MutableLiveData<List<Pessoa>> mutableLiveDataPessoas = new MutableLiveData<>();
    private MutableLiveData<List<Projeto>> mutableLiveDataProjetos = new MutableLiveData<>();


    public static FirebaseFirestore getBanco() {
        return FirebaseFirestore.getInstance();
    }

    public static Task<Void> salvarProjeto(final Projeto projeto) {
        return getBanco().collection(ConstantUtils.PROJETOS).document(getIdPessoaLogada()).set(projeto.returnProjeto());
    }


    public static Task<Void> salvarPessoa(final Pessoa user) {
        return getBanco().collection(ConstantUtils.PESSOAS).document(user.getId()).set(user.returnPessoa());
    }


    public static Task<Void> salvarProduto(final Produto p) {
        return getBanco().collection(ConstantUtils.PRODUTO).document(p.getId()).set(p.returnProduto());
    }

    public static String getIdPessoaLogada() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public static DocumentReference getPessoa(String id) {
        return getBanco().collection(ConstantUtils.PESSOAS).document(id);
    }

    public static CollectionReference getPessoas() {
        return getBanco().collection(ConstantUtils.PESSOAS);
    }

    public static CollectionReference getProjetos() {
        return getBanco().collection(ConstantUtils.PROJETOS);
    }

    public static DocumentReference getProjeto(String id) {
        return getBanco().collection(ConstantUtils.PROJETOS).document(id);
    }


    public static Task<Void> salvarVoto(Projeto projeto) {
        return getBanco().collection(ConstantUtils.PROJETOS).document(projeto.getId()).update(projeto.returnProjeto());
    }



    public LiveData<List<Pessoa>> getMutableLiveDataPessoas() {
        getPessoas().addSnapshotListener((queryDocumentSnapshots, e) -> {
           mutableLiveDataPessoas.setValue(queryDocumentSnapshots.toObjects(Pessoa.class));
        });
        return mutableLiveDataPessoas;
    }

    public LiveData<List<Projeto>> getMutableLiveDataProjetos() {
        getProjetos().addSnapshotListener((queryDocumentSnapshots, e) -> {
            mutableLiveDataProjetos.setValue(queryDocumentSnapshots.toObjects(Projeto.class));
        });
        return mutableLiveDataProjetos;
    }





}
