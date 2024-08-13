// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'appDatabase.dart';

// **************************************************************************
// FloorGenerator
// **************************************************************************

abstract class $AppDatabaseBuilderContract {
  /// Adds migrations to the builder.
  $AppDatabaseBuilderContract addMigrations(List<Migration> migrations);

  /// Adds a database [Callback] to the builder.
  $AppDatabaseBuilderContract addCallback(Callback callback);

  /// Creates the database and initializes it.
  Future<AppDatabase> build();
}

// ignore: avoid_classes_with_only_static_members
class $FloorAppDatabase {
  /// Creates a database builder for a persistent database.
  /// Once a database is built, you should keep a reference to it and re-use it.
  static $AppDatabaseBuilderContract databaseBuilder(String name) =>
      _$AppDatabaseBuilder(name);

  /// Creates a database builder for an in memory database.
  /// Information stored in an in memory database disappears when the process is killed.
  /// Once a database is built, you should keep a reference to it and re-use it.
  static $AppDatabaseBuilderContract inMemoryDatabaseBuilder() =>
      _$AppDatabaseBuilder(null);
}

class _$AppDatabaseBuilder implements $AppDatabaseBuilderContract {
  _$AppDatabaseBuilder(this.name);

  final String? name;

  final List<Migration> _migrations = [];

  Callback? _callback;

  @override
  $AppDatabaseBuilderContract addMigrations(List<Migration> migrations) {
    _migrations.addAll(migrations);
    return this;
  }

  @override
  $AppDatabaseBuilderContract addCallback(Callback callback) {
    _callback = callback;
    return this;
  }

  @override
  Future<AppDatabase> build() async {
    final path = name != null
        ? await sqfliteDatabaseFactory.getDatabasePath(name!)
        : ':memory:';
    final database = _$AppDatabase();
    database.database = await database.open(
      path,
      _migrations,
      _callback,
    );
    return database;
  }
}

class _$AppDatabase extends AppDatabase {
  _$AppDatabase([StreamController<String>? listener]) {
    changeListener = listener ?? StreamController<String>.broadcast();
  }

  TasksDao? _tasksDAOInstance;

  Future<sqflite.Database> open(
    String path,
    List<Migration> migrations, [
    Callback? callback,
  ]) async {
    final databaseOptions = sqflite.OpenDatabaseOptions(
      version: 1,
      onConfigure: (database) async {
        await database.execute('PRAGMA foreign_keys = ON');
        await callback?.onConfigure?.call(database);
      },
      onOpen: (database) async {
        await callback?.onOpen?.call(database);
      },
      onUpgrade: (database, startVersion, endVersion) async {
        await MigrationAdapter.runMigrations(
            database, startVersion, endVersion, migrations);

        await callback?.onUpgrade?.call(database, startVersion, endVersion);
      },
      onCreate: (database, version) async {
        await database.execute(
            'CREATE TABLE IF NOT EXISTS `TaskNoSQL` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `desc` TEXT NOT NULL, `finish` INTEGER NOT NULL)');

        await callback?.onCreate?.call(database, version);
      },
    );
    return sqfliteDatabaseFactory.openDatabase(path, options: databaseOptions);
  }

  @override
  TasksDao get tasksDAO {
    return _tasksDAOInstance ??= _$TasksDao(database, changeListener);
  }
}

class _$TasksDao extends TasksDao {
  _$TasksDao(
    this.database,
    this.changeListener,
  )   : _queryAdapter = QueryAdapter(database),
        _taskNoSQLInsertionAdapter = InsertionAdapter(
            database,
            'TaskNoSQL',
            (TaskNoSQL item) => <String, Object?>{
                  'id': item.id,
                  'desc': item.desc,
                  'finish': item.finish
                }),
        _taskNoSQLUpdateAdapter = UpdateAdapter(
            database,
            'TaskNoSQL',
            ['id'],
            (TaskNoSQL item) => <String, Object?>{
                  'id': item.id,
                  'desc': item.desc,
                  'finish': item.finish
                }),
        _taskNoSQLDeletionAdapter = DeletionAdapter(
            database,
            'TaskNoSQL',
            ['id'],
            (TaskNoSQL item) => <String, Object?>{
                  'id': item.id,
                  'desc': item.desc,
                  'finish': item.finish
                });

  final sqflite.DatabaseExecutor database;

  final StreamController<String> changeListener;

  final QueryAdapter _queryAdapter;

  final InsertionAdapter<TaskNoSQL> _taskNoSQLInsertionAdapter;

  final UpdateAdapter<TaskNoSQL> _taskNoSQLUpdateAdapter;

  final DeletionAdapter<TaskNoSQL> _taskNoSQLDeletionAdapter;

  @override
  Future<List<TaskNoSQL>> findAllTasks() async {
    return _queryAdapter.queryList('SELECT * FROM TaskNoSQL',
        mapper: (Map<String, Object?> row) => TaskNoSQL(
            id: row['id'] as int?,
            desc: row['desc'] as String,
            finish: row['finish'] as int));
  }

  @override
  Future<void> insertTask(TaskNoSQL task) async {
    await _taskNoSQLInsertionAdapter.insert(task, OnConflictStrategy.abort);
  }

  @override
  Future<void> updateTask(TaskNoSQL task) async {
    await _taskNoSQLUpdateAdapter.update(task, OnConflictStrategy.abort);
  }

  @override
  Future<void> deleteTask(TaskNoSQL task) async {
    await _taskNoSQLDeletionAdapter.delete(task);
  }
}
