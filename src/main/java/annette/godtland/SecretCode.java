package annette.godtland;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SecretCode extends MYWindow {

  public SecretCode() {
    String fileName = "key.txt";
    try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
      //   read the alphabet and key from the file
      String alphabet = in.readLine();
      String key = in.readLine();
      boolean quit = false;
      while (!quit) {
        String option = promptForString("Do you want to encode(E) or decode(D) a message, or quit(Q)?");
        switch (option) {
          case "Q":
          case "q":
            quit = true;
            break;
          case "E":
          case "e":
            String messageToEncode = promptForString("Enter a message: ");
            String encodedMessage = encode(messageToEncode, alphabet, key);
            print(encodedMessage + "\n");
            break;

          case "D":
          case "d":
            String messageToDecode = promptForString("Enter a message: ");
            String decodedMessage = encode(messageToDecode, key, alphabet);
            print(decodedMessage + "\n");
            break;

          default:

            print(option + " is not a valid option!");
            break;

        }
      }
      System.exit(0);
    } catch (FileNotFoundException e) {
      print("Could not found file: " + fileName);

    } catch (IOException e) {
      print("Could not open file: " + fileName);
    }
  }

  private String encode(String message, String fromAlphabet, String toAlphabet) {
    StringBuilder newMessage = new StringBuilder();

    for (int i = 0; i < message.length(); i++) {
      String letter = message.substring(i, i + 1);

      // Find the index of that letter in the "from alphabet"
      int letterPos = fromAlphabet.indexOf(letter);

      // If it is in the "from alphabet", find the letter in the same position
      // In the "to alphabet" and add that new letter to the new message
      if (letterPos > -1) {
        String newLetter = toAlphabet.substring(letterPos, letterPos + 1);
        newMessage.append(newLetter);
      }

      // If it is not in the "from alphabet", add that letter to the new message
      else {
        newMessage.append(letter);
      }
    }
    return newMessage.toString();
  }

  public static void main(String[] args) {
    new SecretCode();
  }
}
