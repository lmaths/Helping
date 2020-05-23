package com.rightside.helping;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rightside.helping.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Pessoa> pessoaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Pessoa pessoa = new Pessoa("joao", "1", "Donatario", -21.658840, -42.347540);
        Pessoa joao = new Pessoa("Pedro", "2","Donatario", -21.655753,-42.347941);
        pessoaList = new ArrayList<>();

        pessoaList.add(pessoa);
        pessoaList.add(joao);

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapStyle(new MapStyleOptions(getResources().getString(R.string.style_json)));
            for(Pessoa p : pessoaList) {
                mMap.addMarker(new MarkerOptions().position(p.getLatLng()).title(p.getNome()));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(p.getLatLng(), 17f));
            }

    }
}
