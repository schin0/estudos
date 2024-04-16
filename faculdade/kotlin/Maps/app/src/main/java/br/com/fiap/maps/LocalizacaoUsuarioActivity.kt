package br.com.fiap.maps

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Typeface
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker

class LocalizacaoUsuarioActivity : AppCompatActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
    LocationListener, OnMapReadyCallback
{
    private lateinit var mapa: GoogleMap;
    private var mGoogleApiClient: GoogleApiClient? = null;
    private var mLocationManager: LocationManager? = null;
    private var mLocationRequest: LocationRequest? = null;
    private var locationManager: LocationManager? = null;
    private var fusedLocationClient: FusedLocationProviderClient? = null;

    val UPDATE_INTERVAL = 20000.toLong();
    val FASTEST_INTERVAL: Long = 2000;

    val isLocationEnabled: Boolean
        get() {
            locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager;
            return locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localizacao_usuario)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.localizacao) as SupportMapFragment;
        mapFragment.getMapAsync(this);

        mGoogleApiClient =
            GoogleApiClient
                .Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocationManager = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager;

        checkLocation();
        startLocationUpdates();
    }

    override fun onStart() {
        super.onStart()

        if (mGoogleApiClient != null)
            mGoogleApiClient!!.connect();
    }

    override fun onStop() {
        super.onStop()

        if (mGoogleApiClient!!.isConnected)
            mGoogleApiClient!!.disconnect();
    }

    override fun onConnected(p0: Bundle?) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED &&
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_DENIED)  {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION))
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
            else
               ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
    }

    override fun onConnectionSuspended(p0: Int) {
        mGoogleApiClient!!.connect();
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }

    override fun onMapReady(p0: GoogleMap) {
        TODO("Not yet implemented")
    }

    override fun onLocationChanged(p0: Location) {
        TODO("Not yet implemented")
    }

    fun checkLocation() {

    }

    fun startLocationUpdates() {
        mLocationRequest =
            LocationRequest
                .create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL)

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED &&
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_DENIED)
            return;

        fusedLocationClient?.lastLocation?.addOnSuccessListener {  location: Location ->
            location?.let {
                val msg = "Localização Atualizada:\n\n" + java.lang.Double.toString(location.latitude) + "," + java.lang.Double.toString(location.longitude);

                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

                val latLng = LatLng(location.latitude, location.longitude)
                updateMap(mapa, latLng);
            } ?: Toast.makeText(this, "Localização não detectada", Toast.LENGTH_SHORT).show();
        }
    }

    fun updateMap(googleMap: GoogleMap, latLng: LatLng) {
        mapa = googleMap;

        var meuTitulo = "FIAP Campus Vila Mariana";
        var meuSnippet = "Av. Lins de Vasconcelos,1264\nSão Paulo - SP\nCEP: 01538-001";
        var localizacao = LatLng(-23.5746685, - 46.6232043);

        var bitmap = arrayOf(0.0F, 30.0F, 60.0F, 120.0F, 180.0F, 210.0F, 240.0F ,270.0F, 300.0F, 330.0F);

        var bitmapSorted = bitmap[((Math.random() * bitmap.size).toInt())];

        mapa.moveCamera(
            CameraUpdateFactory.newLatLngZoom(localizacao, 12.5F)
        )

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