import 'package:floor/floor.dart';
import 'package:todo_banco/taskModel_nosql.dart';

@dao
abstract class TasksDao {
  @Query('SELECT * FROM TaskNoSQL')
  Future<List<TaskNoSQL>> findAllTasks();

  @insert
  Future<void> insertTask(TaskNoSQL task);

  @delete
  Future<void> deleteTask(TaskNoSQL task);

  @update
  Future<void> updateTask(TaskNoSQL task);
}
