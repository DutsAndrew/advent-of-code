import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class day4 {
  public static void main(String[] args) {
    try {
      String filePath = "problemInputs/day4.txt";
      List<String> lines = Files.readAllLines(Paths.get(filePath));

      int totalScratchCardPoints = 0;

      for (String line : lines) {
        totalScratchCardPoints += calculateScratchCardPoints(line);
      };

      System.out.println(totalScratchCardPoints);

    } catch(IOException e) {
      e.printStackTrace();
    };
  };

  private static int calculateScratchCardPoints(String line) {
    String card = line.split(":")[1];
    List<String> winningNumbers = buildNumbersArrayForCard(card, 0);
    List<String> cardNumbers = buildNumbersArrayForCard(card, 1);
    int pointsEarnedOnCard = calculatePoints(winningNumbers, cardNumbers);
    return pointsEarnedOnCard;
  };

  private static List<String> buildNumbersArrayForCard(String card, int cardIndex) {
    String sideOfCard = card.split("\\|")[cardIndex];
    String[] allItemsOnSideOfCard = sideOfCard.split(" ");

    List<String> numbersFound = new ArrayList<>();

    for (String item : allItemsOnSideOfCard) { // don't add spaces, just numbers
      if (item.length() > 0) numbersFound.add(item);
    };

    return numbersFound;
  };

  private static int calculatePoints(List<String> winningNumbers, List<String> cardNumbers) {
    int points = 0;

    for (String item : cardNumbers) {
      for (String winningNumber : winningNumbers) {
        if (item.equals(winningNumber)) {
          if (points == 0) {
            points = 1;
            continue;
          };
          points += points;
        } else {
          continue;
        };
      };
    };

    return points;
  };
};