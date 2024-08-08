import 'package:cursos_fiap/shift.dart';

class Programacao {
  List<Shift> shifts;

  Programacao.fromJson(dynamic json) : shifts = encodeToShiftList(json);
}

List<Shift> encodeToShiftList(List list) {
  List<Shift> jsonList = <Shift>[];
  if (list != null) {
    list.map((item) => jsonList.add(Shift.fromJson(item))).toList();
  }
  return jsonList;
}
