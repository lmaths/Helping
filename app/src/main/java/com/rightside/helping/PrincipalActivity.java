package com.rightside.helping;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.firestore.QuerySnapshot;
import com.rightside.helping.Repository.FirebaseRepository;

import com.rightside.helping.fragments.VotacaoFragment;
import com.rightside.helping.models.Empresa;
import com.rightside.helping.models.Pontuacao;
import com.rightside.helping.models.Projeto;
import com.rightside.helping.utils.GeralUtils;
import com.rightside.helping.viewmodels.ViewModelProjetos;
import com.rightside.helping.activity.NavigationActivity;
import com.rightside.helping.fragments.LoginDialogFragment;
import com.rightside.helping.models.Pessoa;
import com.rightside.helping.utils.ConstantUtils;


import java.util.ArrayList;
import java.util.List;

import lombok.val;

public class PrincipalActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Marker> listaDeMarkers = new ArrayList<>();
    private List<Projeto> listaProjetos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        val viewModelProjetos = new ViewModelProvider(this).get(ViewModelProjetos.class);
        LiveData<QuerySnapshot> liveData = viewModelProjetos.getQuerySnapshotLiveDataViagens();
        liveData.observe(this, queryDocumentSnapshots -> {
            criaMarkers(queryDocumentSnapshots);
        });

//Deletar isso tudo depois
     //   startActivity(new Intent(PrincipalActivity.this, NavigationActivity.class));

        Empresa empresa = new Empresa();
        empresa.setDescricao("Teste descricao");
        empresa.setEmail("teste@gmail.com");
        empresa.setTelefone("2277777777");
        empresa.setNome("Oi");
        empresa.setImagem("https://upload.wikimedia.org/wikipedia/pt/9/91/Logotipo_da_Oi.png");
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setNomeDoLevel("Padawan");
        pontuacao.setPontuacaoAtual(50);
        pontuacao.setPontuacaoTotal(100);
        pontuacao.setPontuacaoTotal(600);
        empresa.setPontuacao(pontuacao);
        empresa.setLatitude(21.6631741343567);
        empresa.setLongitude(-42.34753601253032);
     //   new FirebaseRepository().salva(empresa);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapStyle(new MapStyleOptions(getResources().getString(R.string.style_json)));

        //necessitamos pegar a localização do usuario aqui para mover a camera até ele ao abri o mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-21.658840, -42.347542), 17f));


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                VotacaoFragment.novaInstancia(marker.getId()).show(getSupportFragmentManager(), "Votacao");
                return false;
            }
        });


        mMap.setOnMapClickListener(latLng -> {

            //verificar se o usuario já está logado e descomentar isso, se estiver logado ao clicar no mapa ele deve abrir um formulario e após isso salvar o projeto abaixo,
            //passar no projeto as coisas do formulario
            /*  LoginDialogFragment.novaInstancia().show(getSupportFragmentManager(), "LOGIN"); */
            Projeto projeto = new Projeto(FirebaseRepository.getIdPessoaLogada(), "Construção de um parque", "parque de diversão para crianças", latLng.latitude, latLng.longitude);
            FirebaseRepository.salvarProjeto(projeto);
        });

    }


    private void criaMarkers(QuerySnapshot queryDocumentSnapshots) {
        try {
            listaProjetos = queryDocumentSnapshots.toObjects(Projeto.class);
            for (Projeto projeto : listaProjetos) {
                try {
                    Marker marker = GeralUtils.criaMarker(mMap, projeto, this);
                    listaDeMarkers.add(marker);
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }

        } catch (Exception e) {

        }

    }

}
