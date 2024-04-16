package annette.godtland;

import com.godtsoft.diyjava.DIYWindow;

public class MYWindow extends DIYWindow {

  double promptForDouble(String prompt) {
    double d = 0;
    print(prompt);
    String s = input();
    try {
      d = Double.parseDouble(s);
    } catch (NumberFormatException e) {
      print(s + " is not a valid number. Try again!");
      d = promptForDouble(prompt);
    }

    return d;
  }

  int promptForInt(String prompt) {
    int i = 0;
    print(prompt);
    String s = input();
    try {
      i = Integer.parseInt(s);
    } catch (NumberFormatException e) {
      print(i + " is not a valid number. Try again!");
      i = promptForInt(prompt);
    }

    return i;
  }

  String promptForString(String prompt) {
    print(prompt);
    return input();
  }
}
