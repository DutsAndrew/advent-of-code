import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class day1Solution {
  public static void main(String[] args) {
    try {
      String filePath = "problemInputs/day1Input.txt";
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

    for (char letter : line.toCharArray()) {
      if (Character.isDigit(letter)) {
        int digitValue = letter - '0';
        if (!firstIntFound) {
          firstIntFound = true;
          firstInt = digitValue;
          continue;
        };

        lastInt = digitValue;
      };
    };

    int summedDigits = sumDigitsInLine(firstInt, lastInt);
    return summedDigits;
  };

  private static int sumDigitsInLine(int firstInt, int lastInt) {
    String firstIntAsString = String.valueOf(firstInt);
    String lastIntAsString = String.valueOf(lastInt);

    String summedDigits = (lastInt == 0) ? firstIntAsString + firstIntAsString : firstIntAsString + lastIntAsString;

    return Integer.parseInt(summedDigits);
  };
};