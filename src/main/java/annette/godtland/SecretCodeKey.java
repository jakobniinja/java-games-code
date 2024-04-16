package annette.godtland;

import com.godtsoft.diyjava.DIYWindow;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SecretCodeKey extends DIYWindow {

  private final Random random;

  public SecretCodeKey() {
    random = new Random();
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String scrambled = scramble(alphabet);

    print(alphabet);
    print(scrambled);

    String fileName = "key.txt";
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
      out.write(alphabet);
      out.newLine();
      out.write(scrambled);
      out.close();
    } catch (IOException e) {
      print("Could not open file " + fileName);
    }


  }

  public static void main(String[] args) {
    SecretCodeKey secretCodeKey = new SecretCodeKey();
    secretCodeKey.setFontSize(22);
  }

  private String scramble(String word) {
    StringBuilder scrambled = new StringBuilder();

    while (!word.isEmpty()) {
      int length = word.length();
      int index = random.nextInt(length);
      String letter = word.substring(index, index + 1);

      String first = word.substring(0, index);
      String second = word.substring(index + 1);
      word = first + second;
      scrambled.append(letter);
    }
    return scrambled.toString();
  }

}
