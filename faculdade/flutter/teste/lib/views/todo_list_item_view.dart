import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:teste/providers/todo_list_provider.dart';

import '../models/todo.dart';

class TodoListItemView extends StatelessWidget {
  final Todo todo;
  final WidgetRef ref;

  const TodoListItemView({super.key, required this.todo, required this.ref});

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: Checkbox(
        key: ValueKey(todo.id),
        value: todo.completed,
        onChanged: (value) {
          ref.read(todoListProvider.notifier).toggle(todo.id);
        },
      ),
      title: Text(todo.description),
    );
  }
}
