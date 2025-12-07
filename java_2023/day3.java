import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class day3 {
  public static void main(String[] args) {
    try {
      String filePath = "problemInputs/day3.txt";
      List<String> lines = Files.readAllLines(Paths.get(filePath));

      int enginePartTotalSum = 0;

      List<List<Integer>> symbolCoordinates = getCoordinatesOfSymbolsInMap(lines);

      enginePartTotalSum += calculateEnginePartSum(lines, symbolCoordinates);

      // System.out.println(enginePartTotalSum);

    } catch(IOException e) {
      e.printStackTrace();
    };
  };

  private static List<List<Integer>> getCoordinatesOfSymbolsInMap(List<String> lines) {
    List<List<Integer>> symbolCoordinatesForEachLine = new ArrayList<>();

    for (String line : lines) {
      List<Integer> lineCoordinates = getLineCoordinates(line);
      symbolCoordinatesForEachLine.add(lineCoordinates);
    };

    System.out.println(symbolCoordinatesForEachLine);

    return symbolCoordinatesForEachLine;
  };

  private static List<Integer> getLineCoordinates(String line) {
    List<Integer> lineCoordinates = new ArrayList<>();

    for (int i = 0; i < line.length(); i++) {
      char character = line.charAt(i);
      if (!Character.isLetterOrDigit(character) && !Character.isWhitespace(character) && character != '.') {
          lineCoordinates.add(i); // If the character is a symbol, add its index to the list
      };
    };

    return lineCoordinates;
  };

  private static int calculateEnginePartSum(List<String> lines, List<List<Integer>> symbolCoordinates) {
    int sum = 0;

    // "l" loop will loop through each line, "l" can be used to inspect each array list for each line in symbolCoordinates
    // "c" loop will loop through each character in a line

    for (int l = 0; l < lines.size(); l++) {
      String line = lines.get(l);

      List<Integer> symbolCoordinatesForLine = symbolCoordinates.get(l);

      // Calculate lineBefore only when 'l' is not at index 0
      List<Integer> symbolForCoordinatesLineBefore = new ArrayList<>();
      if (l > 0) symbolForCoordinatesLineBefore = symbolCoordinates.get(l - 1);

      // Calculate lineAfter only when 'l' is not at the last index
      List<Integer> symbolForCoordinatesLineAfter = new ArrayList<>();
      if (l < lines.size() - 1) symbolForCoordinatesLineAfter = symbolCoordinates.get(l + 1);

      String[] allNumbersInLine = line.split("[^0-9]+");
    };

    return sum;
  };
};
