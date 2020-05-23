package com.rightside.helping.Repository;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rightside.helping.models.Pessoa;
import com.rightside.helping.utils.ConstantUtils;

public class FirebaseRepository {

    public static FirebaseFirestore getBanco() {
        return FirebaseFirestore.getInstance();
    }

    public static Task<Void> salvarPessoa(final Pessoa user) {
        return getBanco().collection(ConstantUtils.PESSOAS).document(user.getId()).set(user.returnPessoa());
    }


}
