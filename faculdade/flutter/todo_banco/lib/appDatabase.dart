import 'package:floor/floor.dart';
import 'dart:async';
import 'package:sqflite/sqflite.dart' as sqflite;
import 'package:todo_banco/taskDAO.dart';
import 'package:todo_banco/taskModel_nosql.dart';

part 'appDatabase.g.dart';

@Database(version: 1, entities: [TaskNoSQL])
abstract class AppDatabase extends FloorDatabase {
  TasksDao get tasksDAO;
}
