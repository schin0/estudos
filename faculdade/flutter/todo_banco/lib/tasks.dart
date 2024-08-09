import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:todo_banco/taskModel_nosql.dart';

import 'appDatabase.dart';
import 'login.dart';

enum Status { openDb, readingTasks, done }

class TasksPage extends StatefulWidget {
  @override
  _TasksPageState createState() => _TasksPageState();
}

class _TasksPageState extends State<TasksPage> {
  // DatabaseManager dbMgr = DatabaseManager();
  late AppDatabase database;
  late List<TaskNoSQL> tasks;

  Status status = Status.openDb;

  // late List<Task> tasks;
  final myController = TextEditingController();

  @override
  void initState() {
    super.initState();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.manual,
        overlays: SystemUiOverlay.values);

    _init();
  }

  @override
  void dispose() {
    myController.dispose();
    super.dispose();
  }

  void _init() async {
    // await dbMgr.createDatabase();
    // setState(() {
    //   status = Status.readingTasks;
    // });
    database =
        await $FloorAppDatabase.databaseBuilder('tasks_nosql.db').build();

    _readTasks();
  }

  void _readTasks() {
    database.tasksDAO.findAllTasks().then((list) {
      setState(() {
        tasks = list;
        status = Status.done;
      });
    });

    // dbMgr.tasks().then((list) {
    //   setState(() {
    //     tasks = list;
    //     status = Status.done;
    //   });
    // });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Tasks"),
        actions: <Widget>[
          IconButton(
            onPressed: () {
              _logout();
            },
            icon: const Icon(Icons.exit_to_app),
          )
        ],
      ),
      body: status == Status.openDb
          ? const Padding(
              padding: EdgeInsets.all(30.0),
              child: Center(child: Text('Abrindo banco de dados...')),
            )
          : status == Status.readingTasks
              ? const Padding(
                  padding: EdgeInsets.all(30.0),
                  child: Center(child: Text('Lendo as tarefas já salvas...')),
                )
              : _doneWidget(),
    );
  }

  Widget _doneWidget() {
    return Column(
      children: <Widget>[
        Expanded(
          child: ListView.separated(
            padding: const EdgeInsets.all(8),
            itemCount: tasks.length,
            itemBuilder: (BuildContext context, int index) {
              return CheckboxListTile(
                title: Text(tasks[index].desc),
                value: tasks[index].finish == 1,
                //2
                onChanged: (bool? value) {
                  tasks[index].finish = tasks[index].finish == 1 ? 0 : 1;
                  database.tasksDAO.updateTask(tasks[index]).then((value) {
                    myController.clear();
                    _readTasks();
                  });

                  // dbMgr.update(tasks[index]).then((value) {
                  //   myController.clear();
                  //   _readTasks();
                  // });
                },
                //3
                secondary: InkWell(
                  onTap: () {
                    database.tasksDAO.deleteTask(tasks[index]).then((value) {
                      myController.clear();
                      _readTasks();
                    });

                    // dbMgr.delete(tasks[index].id ?? 0).then((value) {
                    //   myController.clear();
                    //   _readTasks();
                    // });
                  },
                  child: const Icon(Icons.delete, color: Colors.red),
                ),
              );
            },
            separatorBuilder: (BuildContext context, int index) =>
                const Divider(),
          ),
        ),
        Padding(
          padding: const EdgeInsets.all(8),
          child: Row(
            children: <Widget>[
              // 1
              Expanded(
                child: TextFormField(
                  controller: myController,
                  decoration: const InputDecoration(
                      border: OutlineInputBorder(),
                      labelText: 'Insira o nome da tarefa'),
                ),
              ),
              InkWell(
                onTap: () {
                  TaskNoSQL task =
                      TaskNoSQL(desc: myController.text, finish: 0);

                  database.tasksDAO.insertTask(task).then((value) {
                    myController.clear();
                    _readTasks();
                  });
                  // dbMgr.insert(task).then((value) {
                  //   myController.clear();
                  //   _readTasks();
                  // });
                },
                child: const Padding(
                  padding: EdgeInsets.all(10),
                  child: Icon(Icons.add),
                ),
              ),
            ],
          ),
        ),
      ],
    );
  }

  _logout() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    prefs.setBool('login', false).then((value) {
      Navigator.pushReplacement(
        context,
        MaterialPageRoute(builder: (context) => LoginPage()),
      );
    });
  }
}
