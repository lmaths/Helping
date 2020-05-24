package com.rightside.helping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
import com.rightside.helping.activity.RankingActivity;
import com.rightside.helping.fragments.NovoProjetoDialogFragment;
import com.rightside.helping.fragments.VotacaoFragment;
import com.rightside.helping.models.Empresa;
import com.rightside.helping.utils.GeralUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrincipalActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Marker> listaDeMarkers = new ArrayList<>();
    private List<Empresa> listaEmpresas = new ArrayList<>();

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.imageView_foto_produto) ImageView imageViewFoto;
    @BindView(R.id.textView_oferta_nome) TextView textViewNome;
    @BindView(R.id.textView_oferta_nome_empresa) TextView textViewNomeEmpresa;
    @BindView(R.id.textView_oferta_preco) TextView textViewPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        criaToolbar();
        getSupportActionBar().hide();



        FirebaseRepository.getEmpresas().addSnapshotListener((queryDocumentSnapshots, e) -> {
            criaMarkersEmpresas(queryDocumentSnapshots);
        });

        FirebaseRepository.getProjetos().addSnapshotListener((queryDocumentSnapshots, e) -> {
            criaMarkers(queryDocumentSnapshots);
        });

//Deletar isso tudo depois
        //   startActivity(new Intent(PrincipalActivity.this, NavigationActivity.class));

        GeralUtils.criaImagemCircular(this, "https://www.setegotas.com.br/wp-content/uploads/2017/09/%C3%81gua-Sarandi-20-l.jpg" , imageViewFoto);
        textViewNome.setText("Água mineral");
        textViewNomeEmpresa.setText("Mercearia do Luiz");
        textViewPreco.setText("R$ 6.50");
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

               if(GeralUtils.isUsuario(PrincipalActivity.this)) {
                   if(marker.getTag().toString().equalsIgnoreCase("empresa")) {
                       startActivity(new Intent(PrincipalActivity.this, NavigationActivity.class));
                   } else {
                       VotacaoFragment.novaInstancia(marker.getTag().toString()).show(getSupportFragmentManager(), "Votacao");
                   }
               }




            }
        });

        mMap.setOnMapClickListener(latLng -> {
                if(GeralUtils.isUsuario(this)) {
                    NovoProjetoDialogFragment.novaInstancia(latLng.latitude, latLng.longitude).show(getSupportFragmentManager(), "NOVOPROJETO");
                }

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

    private void criaToolbar() {
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.perfil:
                    startActivity(new Intent(PrincipalActivity.this, PerfilPessoaActivity.class));
                    break;
                case R.id.ranking:
                    startActivity(new Intent(PrincipalActivity.this, RankingActivity.class));
            }
            return false;
        });
    }

}







