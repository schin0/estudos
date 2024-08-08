import 'package:flutter/cupertino.dart';

@immutable
class Todo {
  final String id;
  final String description;
  final bool completed;

  const Todo(
      {required this.id, required this.description, this.completed = false});
}
