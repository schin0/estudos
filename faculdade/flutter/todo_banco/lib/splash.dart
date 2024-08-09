import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:todo_banco/login.dart';
import 'package:todo_banco/tasks.dart';

class Splash extends StatefulWidget {
  @override
  _SplashState createState() => _SplashState();
}

class _SplashState extends State<Splash> {
  late bool logged;

  @override
  void initState() {
    super.initState();
    _checkLogin();
    SystemChrome.setEnabledSystemUIMode(SystemUiMode.manual, overlays: []);

    Future.delayed(const Duration(seconds: 4)).then((_) {
      Navigator.pushReplacement(
          context,
          MaterialPageRoute(
              builder: (context) => logged ? TasksPage() : LoginPage()));
    });
  }

  _checkLogin() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    bool? login = prefs.getBool('login');
    if (login == null || !login) {
      logged = false;
    } else {
      logged = true;
    }
  }

  @override
  Widget build(BuildContext context) {
    return const Center(
      child: Text(
          "Aqui o Designer entra em ação e fornece uma splash screen arrasadora"),
    );
  }
}
