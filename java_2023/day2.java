import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day2 {
  public static void main(String[] args) {
    try {
      String filePath = "problemInputs/day2.txt";
      List<String> lines = Files.readAllLines(Paths.get(filePath));

      int validGameTotal = 0;

      for (String line : lines) {
        validGameTotal += isGameValid(line);
      }

      System.out.println(validGameTotal);

    } catch(IOException e) {
      e.printStackTrace();
    };
  };

  private static int isGameValid(String line) {
    int validRed = 12;
    int validGreen = 13;
    int validBlue = 14;

    Pattern redPattern = Pattern.compile("(\\d+) red", Pattern.CASE_INSENSITIVE);
    Pattern greenPattern = Pattern.compile("(\\d+) green", Pattern.CASE_INSENSITIVE);
    Pattern bluePattern = Pattern.compile("(\\d+) blue", Pattern.CASE_INSENSITIVE);

    String gameId = line.split(":")[0].split(" ")[1];
    String gameSessions = line.split(":")[1];
    int numberOfGameSessions = line.split(";").length;

    for (int i = 0; i < numberOfGameSessions; i++) {
      String game = gameSessions.split(";")[i];

      Matcher redMatcher = redPattern.matcher(game);
      Matcher greenMatcher = greenPattern.matcher(game);
      Matcher blueMatcher = bluePattern.matcher(game);

      boolean redMatchFound = redMatcher.find();
      boolean greenMatchFound = greenMatcher.find();
      boolean blueMatchFound = blueMatcher.find();

      if (redMatchFound) {
        String redValue = redMatcher.group(1);
        int redConvertedToInt = Integer.parseInt(redValue);
        if (redConvertedToInt > validRed) return 0;
      };

      if (greenMatchFound) {
        String greenValue = greenMatcher.group(1);
        int greenConvertedToInt = Integer.parseInt(greenValue);
        if (greenConvertedToInt > validGreen) return 0;
      };

      if (blueMatchFound) {
        String blueValue = blueMatcher.group(1);
        int blueConvertedToInt = Integer.parseInt(blueValue);
        if (blueConvertedToInt > validBlue) return 0;
      };
    };

    return Integer.parseInt(gameId);
  };
};