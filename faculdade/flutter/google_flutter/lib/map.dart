import 'dart:async';
import 'package:flutter/material.dart';
import 'package:google_flutter/searchlocation.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:mobx/mobx.dart';
import 'city.dart';

class MapScreen extends StatefulWidget {
  final List<City> cities;

  MapScreen(this.cities);

  @override
  MapState createState() => MapState();
}

class MapState extends State<MapScreen> {
  final Completer<GoogleMapController> _controller = Completer();
  final _searchLocation = SearchLocation();

  static const CameraPosition fiapPosition = CameraPosition(
    target: LatLng(-23.595157, -46.687052),
    zoom: 14.4746,
  );

  Set<Marker> citiesMarkers = {};

  @override
  void initState() {
    for (City city in widget.cities) {
      citiesMarkers.add(Marker(
        markerId: MarkerId(city.name),
        position: LatLng(
          city.latitude,
          city.longitude,
        ),
        infoWindow: InfoWindow(title: city.name, snippet: city.state),
      ));
    }

    reaction((_) => _searchLocation.currentLocation, (value) {
      if (_searchLocation.currentLocation != null) {
        List<String> positions = _searchLocation.currentLocation.split(",");
        CameraPosition myLocation = CameraPosition(
          target:
              LatLng(double.parse(positions[0]), double.parse(positions[1])),
          zoom: 14.4746,
        );
        _controller.future.then((controller) {
          controller.animateCamera(CameraUpdate.newCameraPosition(myLocation));
        });
      }
    });

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: <Widget>[
          Expanded(
            child: GoogleMap(
              mapType: MapType.normal,
              initialCameraPosition: fiapPosition,
              onMapCreated: (GoogleMapController controller) {
                _controller.complete(controller);
              },
              markers: citiesMarkers,
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          _searchLocation.startSearch();
        },
        child: const Icon(Icons.gps_fixed),
      ),
    );
  }
}
