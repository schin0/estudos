package br.com.fiap.maps

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapa) as SupportMapFragment;
        mapFragment.getMapAsync(this);
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val unidadesFiap = arrayOf(
            arrayOf("FIAP Campus Vila Olimpia", "Rua Olimpíadas,186\nSão Paulo - SP\nCEP: 04551-000"),
            arrayOf("FIAP Campus Paulista", "Av. Paulista,1166\nSão Paulo - SP\nCEP: 01311-0"),
            arrayOf("FIAP Campus Vila Mariana", "Av. Lins de Vasconcelos,1264\nSão Paulo - SP\nCEP: 01538-001")
        )

        val fiapVilaOlimpia = LatLng(-23.5955843, - 46.6851937);
        val fiapPaulista = LatLng(-23.5643721, - 46.652857);
        val fiapVilaMariana = LatLng(-23.5746685, - 46.6232043);

        googleMap.addMarker(
            MarkerOptions()
                .position(fiapVilaOlimpia)
                .title(unidadesFiap[0][0])
                .snippet(unidadesFiap[0][1])
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        )

        googleMap.addMarker(
            MarkerOptions()
                .position(fiapPaulista)
                .title(unidadesFiap[1][0])
                .snippet(unidadesFiap[1][1])
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        )

        googleMap.addMarker(
            MarkerOptions()
                .position(fiapVilaMariana)
                .title(unidadesFiap[2][0])
                .snippet(unidadesFiap[2][1])
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        )

        // Movimentar a camera
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fiapPaulista, 12.5F));

        // Configurar a exibição dos títulos e endereços das unidades:
        googleMap.setInfoWindowAdapter(object: GoogleMap.InfoWindowAdapter {
            override fun getInfoContents(marker: Marker): View? {
                val info = LinearLayout(applicationContext);
                info.orientation = LinearLayout.VERTICAL;

                val titulo = TextView(applicationContext);
                titulo.setTextColor(Color.BLACK);
                titulo.gravity = Gravity.LEFT;
                titulo.setTypeface(null, Typeface.BOLD);
                titulo.text = marker.title;

                val snippet = TextView(applicationContext);
                snippet.setTextColor(Color.GRAY);
                snippet.text = marker.snippet;

                info.addView(titulo);
                info.addView(snippet);

                return info;
            }

            override fun getInfoWindow(p0: Marker): View? {
                TODO("Not yet implemented")
            }
        });
    }

}