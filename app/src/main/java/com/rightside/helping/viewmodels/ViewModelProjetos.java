package com.rightside.helping.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.models.Pessoa;
import com.rightside.helping.models.Projeto;

import java.util.List;

public class ViewModelProjetos extends androidx.lifecycle.ViewModel {

    private FirebaseLiveDataViagens liveDataViagens = new FirebaseLiveDataViagens();

    public LiveData<QuerySnapshot> getQuerySnapshotLiveDataViagens(){
        return liveDataViagens;
    }

}
