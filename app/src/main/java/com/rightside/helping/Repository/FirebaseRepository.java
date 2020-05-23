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
import com.rightside.helping.utils.ConstantUtils;

import java.util.List;

public class FirebaseRepository {

    private MutableLiveData<List<Pessoa>> mutableLiveDataPessoas = new MutableLiveData<>();

    public static FirebaseFirestore getBanco() {
        return FirebaseFirestore.getInstance();
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



    public LiveData<List<Pessoa>> getMutableLiveDataPessoas() {
        getPessoas().addSnapshotListener((queryDocumentSnapshots, e) -> {
           mutableLiveDataPessoas.setValue(queryDocumentSnapshots.toObjects(Pessoa.class));
        });
        return mutableLiveDataPessoas;
    }




}
