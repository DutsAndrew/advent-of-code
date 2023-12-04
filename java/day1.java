import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class day1 {
  public static void main(String[] args) {
    try {
      String filePath = "problemInputs/day1.txt";
      List<String> lines = Files.readAllLines(Paths.get(filePath));

      int sum = 0;

      for (String line : lines) {
        sum += getNumberFromLine(line);
      };

      System.out.println(sum);

    } catch (IOException e) {
      e.printStackTrace();
    };
  };

  private static int getNumberFromLine(String line) {
    boolean firstIntFound = false;
    int firstInt = 0;
    int lastInt = 0;
    String characterNumber = "";

    for (int i = 0; i < line.length(); i++) {
      char letter = line.charAt(i);

      // Check for non-digit characters
      if (!Character.isDigit(letter)) {
        characterNumber += letter;
        characterNumber = checkForCharacterNumber(characterNumber);
        int isNumber = verifyStringIsNumber(characterNumber);

        if (isNumber != -1 && !firstIntFound) {
          firstIntFound = true;
          firstInt = isNumber;
          characterNumber = "";
          i--; // decrement in case char is still used in next possible number
          continue;
        };

        if (isNumber != -1 && firstIntFound) {
          lastInt = isNumber;
          characterNumber = "";
          i--; // decrement in case char is still used in next possible number
          continue;
        };
      };

      if (Character.isDigit(letter)) {
        if (characterNumber.length() > 0) characterNumber = "";

          int digitValue = letter - '0';

          if (!firstIntFound) {
            firstIntFound = true;
            firstInt = digitValue;
            continue;
          }

          lastInt = digitValue;
      };  
    };

    int summedDigits = sumDigitsInLine(firstInt, lastInt);
    return summedDigits;
  };

  private static String checkForCharacterNumber(String currentCharacters) {
    List<String> possibleNumbers = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    for (String word : possibleNumbers) {
      if (word.length() >= currentCharacters.length()) {
        if (word.substring(0, currentCharacters.length()).equals(currentCharacters)) {
          return currentCharacters;
        };
      };
    };

    // Check if the last character matches the first character of any word in possibleNumbers
    char lastCharacter = currentCharacters.charAt(currentCharacters.length() - 1);
    for (String word : possibleNumbers) {
      if (String.valueOf(word.charAt(0)).equals(String.valueOf(lastCharacter))) {
        return String.valueOf(lastCharacter);
      };
    };

    return "";
  };

  private static int verifyStringIsNumber(String characters) {
    switch(characters) {
      case "one":
        return 1;
      case "two":
        return 2;
      case "three":
        return 3;
      case "four":
        return 4;
      case "five":
        return 5;
      case "six":
        return 6;
      case "seven":
        return 7;
      case "eight":
        return 8;
      case "nine":
        return 9;
      default:
        return -1;
    }
  }

  private static int sumDigitsInLine(int firstInt, int lastInt) {
    String firstIntAsString = String.valueOf(firstInt);
    String lastIntAsString = String.valueOf(lastInt);

    String summedDigits = (lastInt == 0) ? firstIntAsString + firstIntAsString : firstIntAsString + lastIntAsString;

    System.out.println(summedDigits);

    return Integer.parseInt(summedDigits);
  };
};