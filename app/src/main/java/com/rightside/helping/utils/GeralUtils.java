package com.rightside.helping.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rightside.helping.PrincipalActivity;
import com.rightside.helping.R;
import com.rightside.helping.models.Empresa;

import java.text.NumberFormat;

public class GeralUtils {

    public static Marker criaMarker(GoogleMap mMap, Empresa projeto, Context context) {
        int height = 120;
        int width = 90;
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.project_wt);
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        Marker marker = mMap.addMarker(new MarkerOptions().position(projeto.getLatLng()).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title(projeto.getNome()));
        marker.setTag(projeto.getId());
        return marker;
    }

    public static Marker criaMarkerEmpresa(GoogleMap mMap, Empresa projeto, Context context) {
        int height = 110;
        int width = 130;
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.company);
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        Marker marker = mMap.addMarker(new MarkerOptions().position(projeto.getLatLng()).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title(projeto.getNome()));
        marker.setTag(projeto.getId());
        return marker;
    }


    public static String formataMoeda(double valor) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(valor);
    }

    public static void criaImagemCircular(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).circleCrop().into(imageView);
    }
}
