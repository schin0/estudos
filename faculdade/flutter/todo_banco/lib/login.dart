import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:todo_banco/tasks.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  final _formKey = GlobalKey<FormState>();

  @override
  void initState() {
    super.initState();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.manual,
        overlays: SystemUiOverlay.values);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Login"),
      ),
      body: Form(
        key: _formKey,
        child: ListView(
          padding: const EdgeInsets.all(8),
          children: <Widget>[
            TextFormField(
              decoration: const InputDecoration(hintText: "Login"),
              validator: (value) {
                if (value!.isEmpty) {
                  return 'Por favor, informe o login!';
                }
                return null;
              },
            ),
            TextFormField(
              decoration: const InputDecoration(hintText: "Password"),
              obscureText: true,
              validator: (value) {
                if (value!.isEmpty) {
                  return 'Por favor, informe a senha!';
                }
                return null;
              },
            ),
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 16.0),
              child: ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    _successLogin();
                  }
                },
                child: const Text('Login'),
              ),
            ),
          ],
        ),
      ),
    );
  }

  _goToHome() {
    Navigator.pushReplacement(
      context,
      MaterialPageRoute(builder: (context) => TasksPage()),
    );
  }

  _successLogin() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    prefs.setBool('login', true).then((value) {
      _goToHome();
    });
  }
}
