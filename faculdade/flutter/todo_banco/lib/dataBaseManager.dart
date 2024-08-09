import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';
import 'package:todo_banco/taskModel.dart';

class DatabaseManager {
  late Database database;

  Future<bool> createDatabase() async {
    var db = await openDatabase(
      join(await getDatabasesPath(), 'tasks_db.db'),
      onCreate: (db, version) {
        return db.execute(
          "CREATE TABLE tasks(id INTEGER PRIMARY KEY AUTOINCREMENT, desc TEXT, finish INTEGER)",
        );
      },
      version: 1,
    );
    database = db;
    return true;
  }

  Future<void> insert(Task task) async {
    await database.insert(
      'tasks',
      task.toMap(),
      conflictAlgorithm: ConflictAlgorithm.replace,
    );
  }

  Future<List<Task>> tasks() async {
    final List<Map<String, dynamic>> maps = await database.query('tasks');
    return List.generate(maps.length, (i) {
      return Task(
        id: maps[i]['id'],
        desc: maps[i]['desc'],
        finish: maps[i]['finish'],
      );
    });
  }

  Future<void> update(Task task) async {
    await database.update(
      'tasks',
      task.toMap(),
      where: "id = ?",
      whereArgs: [task.id],
    );
  }

  Future<void> delete(int id) async {
    await database.delete(
      'tasks',
      where: "id = ?",
      whereArgs: [id],
    );
  }
}
