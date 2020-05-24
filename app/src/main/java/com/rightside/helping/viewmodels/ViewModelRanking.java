package com.rightside.helping.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.models.Projeto;

import java.util.List;

public class ViewModelRanking extends AndroidViewModel {

    FirebaseRepository firebaseRepository;

    public ViewModelRanking(@NonNull Application application) {
        super(application);
        firebaseRepository = new FirebaseRepository();
    }

    public LiveData<List<Projeto>> getCadastrados() {
        return firebaseRepository.getMutableLiveDataProjetosRanking();
    }

}
