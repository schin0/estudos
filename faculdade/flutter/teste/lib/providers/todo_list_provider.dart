import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:teste/models/todo.dart';
import 'package:teste/notifiers/todo_list_notifier.dart';

final todoListProvider =
    NotifierProvider<TodoListNotifier, List<Todo>>(TodoListNotifier.new);
