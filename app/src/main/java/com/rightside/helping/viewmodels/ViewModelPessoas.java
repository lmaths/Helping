package com.rightside.helping.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.models.Pessoa;

import java.util.List;

public class ViewModelPessoas extends AndroidViewModel {

    private FirebaseRepository firebaseRepository;

    public ViewModelPessoas(@NonNull Application application) {
        super(application);
        firebaseRepository = new FirebaseRepository();
    }


    public LiveData<List<Pessoa>> getPessoas() {
        return firebaseRepository.getMutableLiveDataPessoas();
    }
}
