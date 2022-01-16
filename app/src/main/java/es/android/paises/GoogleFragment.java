package es.android.paises;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class GoogleFragment extends Fragment {

   private GoogleFragment mMap;

    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    LatLng argentina = new LatLng(-34.85025888421061, -65.11216160528267);
    LatLng australia = new LatLng(-25.027054766850014, 134.51839833267354);
    LatLng belgica = new LatLng(50.518090648153276, 4.761884249205673);
    LatLng canada = new LatLng(59.96344368194559, -110.60186212567048);
    LatLng dinamarca = new LatLng(55.61873209894309, 10.311044410363163);
    LatLng españa = new LatLng(39.37839084032124, -3.522928981003058);

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            for (int i=0;i<arrayList.size();i++) {
                googleMap.addMarker(new MarkerOptions().position(arrayList.get(i)));

            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_google, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);

            arrayList.add(argentina);
            arrayList.add(australia);
            arrayList.add(belgica);
            arrayList.add(canada);
            arrayList.add(dinamarca);
            arrayList.add(españa);
        }
    }
}