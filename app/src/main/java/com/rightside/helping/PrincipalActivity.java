package com.rightside.helping;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.firestore.QuerySnapshot;
import com.rightside.helping.Repository.FirebaseRepository;
import com.rightside.helping.activity.NavigationActivity;
import com.rightside.helping.activity.PerfilPessoaActivity;
import com.rightside.helping.fragments.NovoProjetoDialogFragment;
import com.rightside.helping.fragments.VotacaoFragment;
import com.rightside.helping.models.Empresa;
import com.rightside.helping.models.Pontuacao;
import com.rightside.helping.utils.GeralUtils;
import com.rightside.helping.viewmodels.ViewModelProjetos;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.val;

public class PrincipalActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Marker> listaDeMarkers = new ArrayList<>();
    private List<Empresa> listaEmpresas = new ArrayList<>();

    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        criaToolBar();
        getSupportActionBar().hide();

        val viewModelProjetos = new ViewModelProvider(this).get(ViewModelProjetos.class);

        FirebaseRepository.getEmpresas().addSnapshotListener((queryDocumentSnapshots, e) -> {
            criaMarkersEmpresas(queryDocumentSnapshots);
        });

        FirebaseRepository.getProjetos().addSnapshotListener((queryDocumentSnapshots, e) -> {
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
        empresa.setLatitude(-21.658840);
        empresa.setLongitude(-42.347542);
        //    new FirebaseRepository().salva(empresa);

        //  startActivity(new Intent(PrincipalActivity.this, NavigationActivity.class));

    }


    private void criaMarkersEmpresas(QuerySnapshot queryDocumentSnapshots) {
        listaEmpresas = queryDocumentSnapshots.toObjects(Empresa.class);
        try {
            for (Empresa projeto : listaEmpresas) {
                try {
                    Marker marker = GeralUtils.criaMarkerEmpresa(mMap, projeto, this);
                    marker.setTag("empresa");
                    listaDeMarkers.add(marker);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {

        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapStyle(new MapStyleOptions(getResources().getString(R.string.style_json)));

        //necessitamos pegar a localização do usuario aqui para mover a camera até ele ao abri o mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-21.658840, -42.347542), 15f));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                if(marker.getTag().toString().equalsIgnoreCase("empresa")) {
                    startActivity(new Intent(PrincipalActivity.this, NavigationActivity.class));
                } else {
                    VotacaoFragment.novaInstancia(marker.getTag().toString()).show(getSupportFragmentManager(), "Votacao");
                }



            }
        });

        mMap.setOnMapClickListener(latLng -> {
            //verificar se o usuario já está logado e descomentar isso, se estiver logado ao clicar no mapa ele deve abrir um formulario e após isso salvar o projeto abaixo,
            //passar no projeto as coisas do formulario
            /*  LoginDialogFragment.novaInstancia().show(getSupportFragmentManager(), "LOGIN"); */

            NovoProjetoDialogFragment.novaInstancia(latLng.latitude, latLng.longitude).show(getSupportFragmentManager(), "NOVOPROJETO");
        });

    }


    private void criaMarkers(QuerySnapshot queryDocumentSnapshots) {

        listaEmpresas = queryDocumentSnapshots.toObjects(Empresa.class);
        try {

            for (Empresa projeto : listaEmpresas) {
                try {
                    Marker marker = GeralUtils.criaMarker(mMap, projeto, PrincipalActivity.this);
                    listaDeMarkers.add(marker);
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }

        } catch (Exception e) {

        }

    }

    private void criaToolBar() {
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.perfil:
                    startActivity(new Intent(PrincipalActivity.this, PerfilPessoaActivity.class));
                    break;
            }
            return false;
        });
    }

}







