// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'searchlocation.dart';

// **************************************************************************
// StoreGenerator
// **************************************************************************

// ignore_for_file: non_constant_identifier_names, unnecessary_brace_in_string_interps, unnecessary_lambdas, prefer_expression_function_bodies, lines_longer_than_80_chars, avoid_as, avoid_annotating_with_dynamic, no_leading_underscores_for_local_identifiers

mixin _$SearchLocation on SearchLocationBase, Store {
  late final _$currentLocationAtom =
      Atom(name: 'SearchLocationBase.currentLocation', context: context);

  @override
  String get currentLocation {
    _$currentLocationAtom.reportRead();
    return super.currentLocation;
  }

  bool _currentLocationIsInitialized = false;

  @override
  set currentLocation(String value) {
    _$currentLocationAtom.reportWrite(
        value, _currentLocationIsInitialized ? super.currentLocation : null,
        () {
      super.currentLocation = value;
      _currentLocationIsInitialized = true;
    });
  }

  late final _$SearchLocationBaseActionController =
      ActionController(name: 'SearchLocationBase', context: context);

  @override
  void startSearch() {
    final _$actionInfo = _$SearchLocationBaseActionController.startAction(
        name: 'SearchLocationBase.startSearch');
    try {
      return super.startSearch();
    } finally {
      _$SearchLocationBaseActionController.endAction(_$actionInfo);
    }
  }

  @override
  String toString() {
    return '''
currentLocation: ${currentLocation}
    ''';
  }
}
