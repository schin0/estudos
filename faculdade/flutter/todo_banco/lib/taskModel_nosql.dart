import 'package:floor/floor.dart';

@entity
class TaskNoSQL {
  @PrimaryKey(autoGenerate: true)
  final int? id;
  final String desc;
  int finish;

  TaskNoSQL({this.id, required this.desc, required this.finish});
}
