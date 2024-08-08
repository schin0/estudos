import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:teste/models/todo.dart';
import 'package:uuid/uuid.dart';

final _uuid = Uuid();

class TodoListNotifier extends Notifier<List<Todo>> {
  @override
  List<Todo> build() => [];

  void add(String description) {
    state = [...state, Todo(id: _uuid.v4(), description: description)];
  }

  void toggle(String id) {
    state = [
      for (var i = 0; i < state.length; i++)
        if (state[i].id == id)
          Todo(
              id: state[i].id,
              description: state[i].description,
              completed: !state[i].completed)
        else
          state[i]
    ];
  }

  void remove(String id) {
    state = state.where((element) => element.id != id).toList();
  }

}
