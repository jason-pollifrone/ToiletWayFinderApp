package com.twf.admin.toiletwayfinder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ToiletMap extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toilet_map);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //MarkerOptions opts = new MarkerOptions();

        //opts.position(new LatLng(-37.806121499077804, 144.95653844268273),MarkerOptions.title("Queen Victoria Market (153 Victoria Street"));

        //googleMap.addMarker(opts);

        {LatLng loc = new LatLng(-37.806121499077804, 144.95653844268273);
            mMap.addMarker(new MarkerOptions().position(loc).title("Queen Victoria Market (153 Victoria Street)"));}
        {LatLng loc = new LatLng(-37.785598387452595, 144.96303536032559);
            mMap.addMarker(new MarkerOptions().position(loc).title("128 - Princes Park South Playground (Princes Park Drive)"));}
        {LatLng loc = new LatLng(-37.819795975740334, 144.93766540530564);
            mMap.addMarker(new MarkerOptions().position(loc).title("Victoria Harbour, Shed 3 (North Wharf Road)"));}
        {LatLng loc = new LatLng(-37.812933099245598, 144.9600121469519);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 36 - Lonsdale Street (Opposite 424 Lonsdale Street)"));}
        {LatLng loc = new LatLng(-37.821248276239892, 144.93452651062867);
            mMap.addMarker(new MarkerOptions().position(loc).title("Yarra's Edge (160-186 Lorimer Street, No 19 Berth)"));}
        {LatLng loc = new LatLng(-37.818924455699296, 144.9342385117904);
            mMap.addMarker(new MarkerOptions().position(loc).title("Victoria Harbour, Shed 2 (North Wharf Road)"));}
        {LatLng loc = new LatLng(-37.821720681669966, 144.95557809313962);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 169 - Batman Park (2A Spencer Street)"));}
        {LatLng loc = new LatLng(-37.802645554985112, 144.96982128721504);
            mMap.addMarker(new MarkerOptions().position(loc).title(" Toilet 138 - Carlton Gardens North (Opposite 199 Rathdowne Street)"));}
        {LatLng loc = new LatLng(-37.821758603307991, 144.94738341867807);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 182 - Docklands Park South - 25 Harbour Esplanade"));}
        {LatLng loc = new LatLng(-37.817903197056161, 144.96626425526381);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 41 - Flinders Street (No 245 Flinders Street Station)"));}
        {LatLng loc = new LatLng(-37.814345522392365, 144.95511794643781);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 1 - Lonsdale Street (Opposite 581 Lonsdale Street)"));}
        {LatLng loc = new LatLng(-37.814358311080689, 144.94168216712015);
            mMap.addMarker(new MarkerOptions().position(loc).title("Saint Mangos Lane, The Palladio (New Quay)"));}
        {LatLng loc = new LatLng(-37.813439207943993, 144.96292272645067);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 6 - Elizabeth Street (Toilet Adjacent 200 Elizabeth Street)"));}
        {LatLng loc = new LatLng(-37.783032484176857, 144.94185635299425);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 120 - Royal Park, Wetland (off Oak Street)"));}
        {LatLng loc = new LatLng(-37.815282812212352, 144.97759328333041);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 118 - Fitzroy Gardens (2 Lansdowne Street)"));}
        {LatLng loc = new LatLng(-37.817220590528038, 144.93400271183998);
            mMap.addMarker(new MarkerOptions().position(loc).title("Ron Barassi Senior Park Pavilion"));}
        {LatLng loc = new LatLng(-37.808235451072591, 144.96018982931108);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 34 - Franklin Street (Opposite 80 Franklin Street)"));}
        {LatLng loc = new LatLng(-37.823310834435333, 144.94182760665478);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 181 - Point Park (Point Park Crescent)"));}
        {LatLng loc = new LatLng(-37.820342128586269, 144.96421972799456);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 172 - Southbank Promenade (opposite Esso House)"));}
        {LatLng loc = new LatLng(-37.840147692965054, 144.98138308753735);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 102 - Fawkner Park, North Pavilion (Male)"));}
        {LatLng loc = new LatLng(-37.808942068473357, 144.96564884552271);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 7 - Latrobe Street (Adjacent 120 La Trobe Street)"));}
        {LatLng loc = new LatLng(-37.798064023886866, 144.92110584392117);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 173 - JJ Holland Park, Skate Park (113 Kensington Road)"));}
        {LatLng loc = new LatLng(-37.793732291282353, 144.93035186163311);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 177 - Bellair Street (Opposite 180 Bellair Street)"));}
        {LatLng loc = new LatLng(-37.840017793263222, 144.98122701462214);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 102 - Fawkner Park, North Pavilion (Female)"));}
        {LatLng loc = new LatLng(-37.813837792176308, 144.96309721024045);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 6 - Elizabeth Street (Toilet Adjacent 200 Elizabeth Street)"));}
        {LatLng loc = new LatLng(-37.827643046165278, 144.98181166075949);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 107 - Alexandra Park"));}
        {LatLng loc = new LatLng(-37.803994634967303, 144.95909066756946);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 140 - Queensberry Street (Opposite 286 Queensberry Street)"));}
        {LatLng loc = new LatLng(-37.812240775587128, 144.97392555886628);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 125 - Gordon Reserve (74-108 Spring Street)"));}
        {LatLng loc = new LatLng(-37.802076294207453, 144.96642403988702);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 178 - Argyle Place North (Opposite 4 Argyle Place North)"));}
        {LatLng loc = new LatLng(-37.830857486649528, 144.97516941294074);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 104 - Kings Domain South (off Birdwood Avenue)"));}
        {LatLng loc = new LatLng(-37.806379618970517, 144.95905779158946);
            mMap.addMarker(new MarkerOptions().position(loc).title("Queen Victoria Market (Food Court - 65-81 Victoria Street)"));}
        {LatLng loc = new LatLng(-37.798709597015986, 144.9675938800973);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 137 - Faraday Street (Opposite 208-212 Faraday Street)"));}
        {LatLng loc = new LatLng(-37.830132537548096, 144.96501222835187);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 105 -Sturt Street Reserve (280 Sturt Street)"));}
        {LatLng loc = new LatLng(-37.819406114138467, 144.96127683121782);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 3 - Flinders Street (399 Flinders Street)"));}
        {LatLng loc = new LatLng(-37.806821292018469, 144.95874700464088);
            mMap.addMarker(new MarkerOptions().position(loc).title("Queen Victoria Market - (Meat Hall /H Shed)"));}
        {LatLng loc = new LatLng(-37.790174410412384, 144.94366905096865);
            mMap.addMarker(new MarkerOptions().position(loc).title(" Toilet 131 - Royal Park (Flemington Rd - Near North Park Tennis Club)"));}
        {LatLng loc = new LatLng(-37.803077866412252, 144.94986517956968);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 170 - Queensberry Street (Opposite 530 Queensberry Street)"));}
        {LatLng loc = new LatLng(-37.810035679928596, 144.96990246330486);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 11 - Lonsdale Street (Opposite 88 Lonsdale Street)"));}
        {LatLng loc = new LatLng(-37.809546046362321, 144.96940711871059);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 12 - Exhibition Street (Opposite 242 Exhibition Street)"));}
        {LatLng loc = new LatLng(-37.802711824554478, 144.96226812695767);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 179 - Lincoln Square (138-142 Bouverie Street)"));}
        {LatLng loc = new LatLng(-37.81203205502802, 144.98307968055312);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 119 - Fitzroy Gardens Toilets (150 Clarendon Street)"));}
        {LatLng loc = new LatLng(-37.822891598588569, 144.97528095733401);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 109 - Kings Domain Myer Music Bowl Rear of"));}
        {LatLng loc = new LatLng(-37.778936987424146, 144.9604666156205);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 127 - Princes Park Royal Parade (near Park Street)"));}
        {LatLng loc = new LatLng(-37.796798998057568, 144.95196665126468);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 136 - Ievers Reserve - Flemington Road"));}
        {LatLng loc = new LatLng(-37.798125461506082, 144.92642466756246);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 162 - JJ Holland Park (Opposite, 48 Altona Street)"));}
        {LatLng loc = new LatLng(-37.813245433601978, 144.9668965896814);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 46 - Bourke Street (opposite 225 Bourke Street)"));}
        {LatLng loc = new LatLng(-37.786221248397048, 144.9550008758734);
            mMap.addMarker(new MarkerOptions().position(loc).title("Royal Park Brens Pavilion"));}
        {LatLng loc = new LatLng(-37.818598872293919, 144.97105956826815);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 48 - Birrarung Marr (Opposite Artplay)"));}
        {LatLng loc = new LatLng(-37.788488821143041, 144.92356372197429);
            mMap.addMarker(new MarkerOptions().position(loc).title("Newmarket Reserve (26 Smithfield Road)"));}
        {LatLng loc = new LatLng(-37.821004779775386, 144.97593322373976);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 111 - Birrarung Marr Speakers Corner"));}
        {LatLng loc = new LatLng(-37.82691574923448, 144.97464778387879);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 106 - Kings Domain Government House Drive"));}
        {LatLng loc = new LatLng(-37.815215766196921, 144.96694328510318);
            mMap.addMarker(new MarkerOptions().position(loc).title("Town Hall Melbourne (200 Collins Street)"));}
        {LatLng loc = new LatLng(-37.813418435008913, 144.97746700744847);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 122 - Treasury Gardens (Store and Toilet)"));}
        {LatLng loc = new LatLng(-37.80786399579295, 144.95794775127476);
            mMap.addMarker(new MarkerOptions().position(loc).title("Queen Victoria Market (465 Queen Street)"));}
        {LatLng loc = new LatLng(-37.845206563009405, 144.9826144313013);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 42 - Fawkner Park, Opposite 55 Commercial Road"));}
        {LatLng loc = new LatLng(-37.820355272841098, 144.97331290887431);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 112 - Alexandra Gardens (Riverslide Skate Park)"));}
        {LatLng loc = new LatLng(-37.781871317866852, 144.95614252894822);
            mMap.addMarker(new MarkerOptions().position(loc).title("Royal Park Golf Course Club House"));}
        {LatLng loc = new LatLng(-37.833938266337292, 144.98178404635061);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 103 - Kings Domain South (Opposite 169 Domain Road)"));}
        {LatLng loc = new LatLng(-37.808920475347513, 144.95504330920312);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 154 - Flagstaff Gardens (cnr William & Dudley)"));}
        {LatLng loc = new LatLng(-37.806258933018739, 144.96920270220019);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 145 - Carlton Gardens South (Opposite 39 Rathdowne Street)"));}
        {LatLng loc = new LatLng(-37.83825284124979, 144.98438921994168);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 44 - Fawkner Park, Opposite 150W Toorak Road"));}
        {LatLng loc = new LatLng(-37.817469892096391, 144.96025433528794);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 4 - Market Street (Opposite 74 Market Street)"));}
        {LatLng loc = new LatLng(-37.806805767380247, 144.96264850030644);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 146 - Swanston Street (Opposite 475-511 Swanston Street)"));}
        {LatLng loc = new LatLng(-37.793011678725762, 144.97399489761827);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 133- Canning Street Reserve (49 Princes Street)"));}
        {LatLng loc = new LatLng(-37.804641804090586, 144.96285016183216);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 142 - Queensberry Street (Adjacent 179 Queensberry Street)"));}
        {LatLng loc = new LatLng(-37.792511464486978, 144.95685172084129);
            mMap.addMarker(new MarkerOptions().position(loc).title(" Toilet 100 - Royal Park - Native Garden (off Gatehouse Street)"));}
        {LatLng loc = new LatLng(-37.787904827147685, 144.95949479077186);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 52 - Princes Park (Adjacent Southern Sports Pavilion)"));}
        {LatLng loc = new LatLng(-37.810942328096331, 144.98685873937842);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 117 - Powlett Reserve (Opposite 128 Albert Street)"));}
        {LatLng loc = new LatLng(-37.795523148389002, 144.95214296280201);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 55 - Royal Park (Nature Play, Opposite 51 Gatehouse Street)"));}
        {LatLng loc = new LatLng(-37.815989825999871, 144.97279836576897);
            mMap.addMarker(new MarkerOptions().position(loc).title(" Toilet 14 - Flinders Street (27 Flinders Street)"));}
        {LatLng loc = new LatLng(-37.815838165017645, 144.96106207300267);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 43 - Queen Street (opposite 113 Queen Street)"));}
        {LatLng loc = new LatLng(-37.813846416649952, 144.97137409472111);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 13 - Exhibition Street (Opposite 77 Exhibition Street)"));}
        {LatLng loc = new LatLng(-37.809452028942459, 144.97307695563703);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 124 - Nicholson Street (1A Nicholson Street)"));}
        {LatLng loc = new LatLng(-37.822948288677665, 144.97098568179823);
            mMap.addMarker(new MarkerOptions().position(loc).title("Toilet 110 - Queen Victoria Gardens (Linlithgow Avenue)"));}

        //LatLng test1 = new LatLng(-37.806121499077804,144.95653844268273);
        //mMap.addMarker(new MarkerOptions().position(test1).title("Queen Victoria Market (153 Victoria Street)"));

        //LatLng test2 = new LatLng(-37.785598387452595,144.96303536032559);
        //mMap.addMarker(new MarkerOptions().position(test2).title("actual name etc"));

        //LatLng test3 = new LatLng(-37.819795975740334,144.93766540530564);
        //mMap.addMarker(new MarkerOptions().position(test3).title("so good at this"));

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18));
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

        }
    }
}
