import 'dart:convert';
import 'package:cursos_fiap/programacao.dart';
import 'package:cursos_fiap/shift.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

class ShiftModel extends ChangeNotifier {
  List<Shift> shifts = [];

  ShiftModel() {
    if (shifts.isEmpty) {
      loadShifts();
    }
  }

  loadShifts() async {
    String jsonText =
        await rootBundle.loadString('assets/json/programacao.json');
    dynamic dyn = jsonDecode(jsonText);
    Programacao programacao = Programacao.fromJson(dyn);
    shifts = programacao.shifts;
    notifyListeners();
  }
}
