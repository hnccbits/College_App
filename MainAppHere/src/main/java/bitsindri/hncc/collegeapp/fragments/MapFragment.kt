package bitsindri.hncc.collegeapp.fragments

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import bitsindri.hncc.collegeapp.R
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.karan.churi.PermissionManager.PermissionManager

class MapFragment : Fragment() , OnMapReadyCallback,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,
    LocationListener {

    private lateinit var mMap: GoogleMap//entry point for all the mthods related to map

    lateinit var client: GoogleApiClient//helps to access google api,GoogleApiClient r not thread safe i.e. to access google APIS from multiple threads simultaneously ,create
    // a GoogleApiClient on each thread GoogleApiClient service are cached internally ,so creating multiple instance is fast


    lateinit var request: LocationRequest//used to request a quality of service for location updates from the FusedLocationProviderApi/(parameters for request to the FusedLocationProviderApi)
    //helps in getting location with accuracy

    lateinit var manager: PermissionManager//asking permission for media camera....,used to check for run tie permission

    lateinit var latLng: LatLng//to get latitude and longitude with optional altitude

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_map,container,false)

        manager = object : PermissionManager() {}

        manager.checkAndRequestPermissions(activity)

        manager.checkAndRequestPermissions(activity)

        // setting activity layout i.e your location which get hidden by fragments
//
        val mapFragment = activity?.fragmentManager?.findFragmentById(R.id.map) as MapFragment


        //to use getMapAsync() we hve to implement onMapReady(googleMap: GoogleMap) callbacks via interface OnMapReadyCallback above unless it will throw error
        mapFragment.getMapAsync(this)

        //end setting activity layout i.e your location which get hidden by fragments

        return view
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        manager.checkResult(requestCode,permissions,grantResults)

        val denied_permission = manager.status.get(0).denied

        if(denied_permission.isEmpty()){
            Toast.makeText(activity as Context, "Permission Enabled", Toast.LENGTH_SHORT).show()
        }
    }

    //default location shown in google map,manipulate the map once available , this callback is triggered when yhe map is ready to be used
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //tracking location of user
        client = activity?.let { GoogleApiClient.Builder(it).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build() }!!
        client.connect()

    }


    override fun onConnected(p0: Bundle?) {//contains location request to connect
        request = LocationRequest()
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        request.setInterval(3000)

        if (activity?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED && activity?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(client,request,this)//onLocationChanged mthod is called,executed on adding permission for accessing coarse location in manifest
    }

    override fun onConnectionSuspended(p0: Int) {

    }

 override fun onConnectionFailed(p0: ConnectionResult) {

    }

  override fun onLocationChanged(location: Location?) {
        if ( location== null){
            Toast.makeText(activity as Context, "Could not get the location", Toast.LENGTH_SHORT).show()
        }
        else {

            latLng = LatLng(location.latitude, location.longitude)
            val options = MarkerOptions()
            options.position(latLng)
            options.title("Current Location")
            mMap.addMarker(options)

        }
    }

    override fun onDestroyView() {

        super.onDestroyView()
    }
}