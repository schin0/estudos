import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:teste/providers/todo_list_provider.dart';
import 'package:teste/views/todo_list_item_view.dart';

class TodoListView extends ConsumerWidget {
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final todos = ref.watch(todoListProvider);
    final todoInputController = TextEditingController();

    void addTodoItem(String description, WidgetRef ref) {
      ref.read(todoListProvider.notifier).add(description);
      todoInputController.clear();
    }

    void removeTodoItem(String id, WidgetRef ref) {
      ref.read(todoListProvider.notifier).remove(id);
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text('Atividades'),
      ),
      body: Container(
        padding: const EdgeInsets.all(24),
        child: Column(
          children: [
            // Adição de atividades:
            Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: todoInputController,
                    decoration: const InputDecoration(
                      label: Text('Insira nova atividade'),
                    ),
                    onSubmitted: (value) {
                      addTodoItem(value, ref);
                    },
                  ),
                ),
                IconButton(
                    onPressed: () {
                      addTodoItem(todoInputController.text, ref);
                    },
                    icon: const Icon(Icons.add))
              ],
            ),

            // Listagem de atividades:
            Expanded(
                child: ListView(
                  children: [
                    for (var i = 0; i < todos.length; i++)
                      Dismissible(
                        key: ValueKey(todos[i].id),
                        child: TodoListItemView(todo: todos[i], ref: ref),
                        onDismissed:(value) {
                          removeTodoItem(todos[i].id, ref);
                        },),
                  ],
                )),
          ],
        ),
      ),
    );
  }
}
