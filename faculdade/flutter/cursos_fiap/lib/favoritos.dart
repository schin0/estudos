import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:cursos_fiap/model.dart';
import 'package:cursos_fiap/shift.dart';
import 'package:provider/provider.dart';

class FavoritosPage extends StatefulWidget {
  @override
  _FavoritosPageState createState() => _FavoritosPageState();
}

class _FavoritosPageState extends State<FavoritosPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Cursos Favoritos"),
      ),
      body: Consumer<ShiftModel>(
        builder: (context, model, child) {
          List<Shift> cursos = model.shifts.where((shift) {
            return shift.favorite;
          }).toList();
          return cursos.isEmpty
              ? const Text("Nenhum curso favoritado")
              : ListView.separated(
                  itemCount: cursos.length,
                  separatorBuilder: (BuildContext context, int index) =>
                      const Divider(),
                  itemBuilder: (BuildContext context, int index) {
                    return ListTile(
                      leading: Container(
                        width: 76.0,
                        height: 76.0,
                        decoration: new BoxDecoration(
                          color: Colors.orange,
                          shape: BoxShape.circle,
                          border: new Border.all(
                              color: Colors.black45,
                              width: 5.0,
                              style: BorderStyle.solid),
                        ),
                        child: Center(
                          child: Text(
                            "R${cursos[index].value},00${cursos[index].init}",
                            textAlign: TextAlign.center,
                            style: const TextStyle(fontSize: 11),
                          ),
                        ),
                      ),
                      title: Text(cursos[index].title),
                      subtitle: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: <Widget>[
                          Text("Professor: ${cursos[index].teacher}",
                              style: const TextStyle(
                                fontWeight: FontWeight.bold,
                                fontSize: 12,
                              )),
                          Text(cursos[index].local,
                              style: const TextStyle(
                                fontSize: 11,
                              )),
                          Text(cursos[index].description,
                              style: const TextStyle(
                                fontSize: 10,
                              )),
                        ],
                      ),
                      isThreeLine: true,
                    );
                  },
                );
        },
      ),
    );
  }
}
