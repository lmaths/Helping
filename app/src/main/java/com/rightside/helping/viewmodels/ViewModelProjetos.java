package com.rightside.helping.viewmodels;

import androidx.lifecycle.LiveData;

import com.google.firebase.firestore.QuerySnapshot;

public class ViewModelProjetos extends androidx.lifecycle.ViewModel {

    private FirebaseLiveDataMarcadores liveDataMarcadores = new FirebaseLiveDataMarcadores();

    public LiveData<QuerySnapshot> getQuerySnapshotLiveDataMarcadores(){
        return liveDataMarcadores;
    }

}
