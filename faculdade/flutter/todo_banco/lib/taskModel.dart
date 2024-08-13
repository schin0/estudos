class Task {
  final int? id;
  final String desc;
  int finish;

  Task({this.id, required this.desc, required this.finish});

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'desc': desc,
      'finish': finish,
    };
  }
}
