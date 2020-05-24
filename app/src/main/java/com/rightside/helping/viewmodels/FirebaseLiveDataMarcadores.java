package com.rightside.helping.viewmodels;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.rightside.helping.Repository.FirebaseRepository;


public class FirebaseLiveDataMarcadores extends LiveData<QuerySnapshot> {

    private QueryListenerProjetos listener = new QueryListenerProjetos();

    @Override
    protected void onActive() {
        super.onActive();
        FirebaseRepository.getEmpresas().addSnapshotListener(listener);
    }

    private class QueryListenerProjetos implements EventListener<QuerySnapshot> {

        @Override
        public void onEvent(@Nullable QuerySnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
            setValue(documentSnapshot);
        }
    }
}
