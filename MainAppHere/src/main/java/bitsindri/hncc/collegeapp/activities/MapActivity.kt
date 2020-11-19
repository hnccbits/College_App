package bitsindri.hncc.collegeapp.activities

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import bitsindri.hncc.collegeapp.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.karan.churi.PermissionManager.PermissionManager
import java.io.IOException

class MapActivity : AppCompatActivity(),OnMapReadyCallback {

    private lateinit var mMap: GoogleMap//entry point for all the mthods related to map

    final var LOCATION_REQUEST=500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapFragment = this.fragmentManager?.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap?) {

        if (googleMap != null) {
            mMap = googleMap
        }
     mMap.uiSettings.isZoomControlsEnabled = true
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),LOCATION_REQUEST)
            return
        }
mMap.isMyLocationEnabled= true

    }


    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {

        when(requestCode){
            LOCATION_REQUEST->{
                if(grantResults.size >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                    Toast.makeText(this,"permission granted",Toast.LENGTH_SHORT).show()

                    }

                }
            }
        }
    }
