import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:cursos_fiap/favoritos.dart';
import 'package:cursos_fiap/model.dart';
import 'package:provider/provider.dart';

class CatalogoPage extends StatefulWidget {
  @override
  _CatalogoPageState createState() => _CatalogoPageState();
}

class _CatalogoPageState extends State<CatalogoPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Catálogo de Cursos"),
        actions: <Widget>[
          Container(
              margin: const EdgeInsets.only(right: 10),
              child: InkWell(
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => FavoritosPage()),
                    );
                  },
                  child: const Center(child: Text("Favoritos")))),
        ],
      ),
      body: Consumer<ShiftModel>(
        builder: (context, model, child) {
          return model.shifts.isEmpty
              ? const Text("Carregando")
              : ListView.separated(
                  itemCount: model.shifts.length,
                  separatorBuilder: (BuildContext context, int index) =>
                      const Divider(),
                  itemBuilder: (BuildContext context, int index) {
                    return ListTile(
                      leading: Container(
                        width: 76.0,
                        height: 76.0,
                        decoration: BoxDecoration(
                          color: Colors.orange,
                          shape: BoxShape.circle,
                          border: Border.all(
                              color: Colors.black45,
                              width: 5.0,
                              style: BorderStyle.solid),
                        ),
                        child: Center(
                          child: Text(
                            "R${model.shifts[index].value},00${model.shifts[index].init}",
                            textAlign: TextAlign.center,
                            style: const TextStyle(fontSize: 11),
                          ),
                        ),
                      ),
                      title: Text(model.shifts[index].title),
                      subtitle: Text(model.shifts[index].teacher),
                      trailing: InkWell(
                        onTap: () {
                          model.shifts[index].favorite =
                              !model.shifts[index].favorite;
                          model.notifyListeners();
                        },
                        child: Icon(
                          model.shifts[index].favorite
                              ? Icons.favorite
                              : Icons.favorite_border,
                          color: model.shifts[index].favorite
                              ? Colors.orange
                              : Colors.black38,
                        ),
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
