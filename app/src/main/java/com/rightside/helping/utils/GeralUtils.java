package com.rightside.helping.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rightside.helping.R;
import com.rightside.helping.models.Projeto;

public class GeralUtils {

    public static Marker criaMarker(GoogleMap mMap, Projeto projeto, Context context) {
        int height = 120;
        int width = 90;
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.coop);
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        Marker marker = mMap.addMarker(new MarkerOptions().position(projeto.getLatLng()).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title(projeto.getNome()));
        marker.setTag(projeto.getId());
        return marker;
    }
}
