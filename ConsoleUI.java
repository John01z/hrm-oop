import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
  private static final int CONTENT_WIDTH = 120;

  private String safeFit(String text, int maxLen) {
    if (text == null) {
      return "";
    }
    if (text.length() > maxLen) {
      return (maxLen > 3) ? text.substring(0, maxLen - 3) + "..." : text.substring(0, Math.max(0, maxLen));
    }
    return text;
  }

  private void printCentered(String content) {
    String safe = safeFit(content, CONTENT_WIDTH);
    int leftPadding = Math.max(0, (CONTENT_WIDTH - safe.length()) / 2);
    int rightPadding = Math.max(0, CONTENT_WIDTH - safe.length() - leftPadding);

    System.out.println("║" + " ".repeat(leftPadding)
        + "\u001B[1m" + safe + "\u001B[0m"
        + " ".repeat(rightPadding) + "║");
  }

  private void printHeader(String title) {
    System.out.print("\033[H\033[2J");
    System.out.println("╔" + "═".repeat(CONTENT_WIDTH) + "╗");
    printCentered(title);
    System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
  }

  private void printSubtitle(String subtitle) {
    String safe = safeFit(subtitle, CONTENT_WIDTH - 2);
    int rightPadding = Math.max(0, CONTENT_WIDTH - 1 - safe.length());
    System.out.println("║ "
        + "\u001B[3m" + safe + "\u001B[0m"
        + " ".repeat(rightPadding) + "║");
  }

  private void printContent(String content) {
    String safe = safeFit(content, CONTENT_WIDTH - 2);
    int rightPadding = Math.max(0, CONTENT_WIDTH - 1 - safe.length());
    System.out.println("║ " + safe + " ".repeat(rightPadding) + "║");
  }

  private String printChoice(Scanner sc) {
    int rightPadding = Math.max(0, CONTENT_WIDTH - 1 - 8);
    System.out.println("║ Choice: " + " ".repeat(rightPadding) + "║");
    System.out.println("╚" + "═".repeat(CONTENT_WIDTH) + "╝");

    System.out.print("\u001B[1A");
    System.out.print("\u001B[1A");
    System.out.print("\u001B[10C");
    System.out.flush();

    return sc.nextLine();
  }

  private String printChoice(String input, Scanner sc) {
    String safeInput = safeFit(input, CONTENT_WIDTH - 10);
    int rightPadding = Math.max(0, CONTENT_WIDTH - 1 - safeInput.length() - 2);
    System.out.println("║ " + safeInput + ": " + " ".repeat(rightPadding) + "║");
    System.out.println("╚" + "═".repeat(CONTENT_WIDTH) + "╝");

    System.out.print("\u001B[1A");
    System.out.print("\u001B[1A");
    System.out.print("\u001B[" + (safeInput.length() + 4) + "C");
    System.out.flush();

    return sc.nextLine();
  }

  private String printMenu(String subtitle, String[] options, Scanner sc) {
    if (subtitle != null && !subtitle.isEmpty()) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      printSubtitle(subtitle);
    }

    if (options != null && options.length != 0) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      for (int i = 0; i < options.length; i++) {
        String line = "[" + i + "] " + options[i];
        printContent(line);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    return printChoice(sc);
  }

  private String printMenu(String subtitle, String[] options, String input, Scanner sc) {
    if (subtitle != null && !subtitle.isEmpty()) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      printSubtitle(subtitle);
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    }

    if (options != null && options.length != 0) {
      for (int i = 0; i < options.length; i++) {
        String line = "[" + i + "] " + options[i];
        printContent(line);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    return printChoice(input, sc);
  }

  public String printMenu(String subtitle, String content, Scanner sc) {
    if (subtitle != null && !subtitle.isEmpty()) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      printSubtitle(subtitle);
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    }

    String[] lines = (content == null ? "" : content).split("\n");
    if (lines.length != 0) {
      for (int i = 0; i < lines.length; i++) {
        printContent(lines[i]);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    return printChoice(sc);
  }

  public String printMenu(String subtitle, String content, String input, Scanner sc) {
    if (subtitle != null && !subtitle.isEmpty()) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      printSubtitle(subtitle);
    }

    String[] lines = (content == null ? "" : content).split("\n");
    System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    if (lines.length != 0) {
      for (int i = 0; i < lines.length; i++) {
        printContent(lines[i]);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    return printChoice(input, sc);
  }

  public String printMenu(String subtitle, String content, String[] options, Scanner sc) {
    if (subtitle != null && !subtitle.isEmpty()) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      printSubtitle(subtitle);
    }

    String[] lines = (content == null ? "" : content).split("\n");
    System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    if (lines.length != 0) {
      for (int i = 0; i < lines.length; i++) {
        printContent(lines[i]);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    if (options != null && options.length != 0) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      for (int i = 0; i < options.length; i++) {
        String line = "[" + i + "] " + options[i];
        printContent(line);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    return printChoice(sc);
  }

  public String printMenu(String subtitle, String content, String[] options, String input, Scanner sc) {
    if (subtitle != null && !subtitle.isEmpty()) {
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      printSubtitle(subtitle);
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    }

    String[] lines = (content == null ? "" : content).split("\n");
    if (lines.length != 0) {
      for (int i = 0; i < lines.length; i++) {
        printContent(lines[i]);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    if (options != null && options.length != 0) {
      for (int i = 0; i < options.length; i++) {
        String line = "[" + i + "] " + options[i];
        printContent(line);
      }
      System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
      System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");
    }

    return printChoice(input, sc);
  }

  public String printUI(String title, String subtitle, String[] options, Scanner sc) {
    printHeader(title);
    return printMenu(subtitle, options, sc);
  }

  public String printUI(String title, String subtitle, String[] options, String input, Scanner sc) {
    printHeader(title);
    return printMenu(subtitle, options, input, sc);
  }

  public String printUI(String title, String subtitle, String content, Scanner sc) {
    printHeader(title);
    return printMenu(subtitle, content, sc);
  }

  public String printUI(String title, String subtitle, String content, String input, Scanner sc) {
    printHeader(title);
    return printMenu(subtitle, content, input, sc);
  }

  public String printUI(String title, String subtitle, String content, String[] options, Scanner sc) {
    printHeader(title);
    return printMenu(subtitle, content, options, sc);
  }

  public String printUI(String title, String subtitle, String content, String[] options, String input, Scanner sc) {
    printHeader(title);
    return printMenu(subtitle, content, options, input, sc);
  }

  public void printResult(String title, String result, Scanner sc) {
    printHeader(title);

    String[] lines = (result == null ? "" : result).split("\n");

    System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    for (int i = 0; i < lines.length; i++) {
      printContent(lines[i]);
    }
    System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    printContent("Nhấn Enter để quay lại");
    System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    System.out.println("╚" + "═".repeat(CONTENT_WIDTH) + "╝");

    sc.nextLine();
  }

  public LocalDate printDateUI(String title, String subtitle, String[] options, String input, Scanner sc) {
    DataCheck checker = new DataCheck("^(\\d{2})/(\\d{2})/(\\d{4})$");
    while (true) {
      String date = printUI(title, subtitle, options, input, sc).trim();
      if (checker.check(date)) {
        try {
          int day = Integer.parseInt(date.substring(0, 2));
          int month = Integer.parseInt(date.substring(3, 5));
          int year = Integer.parseInt(date.substring(6, 10));
          return LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
          printResult(title, "Ngày không tồn tại trên lịch! Vui lòng nhập lại.", sc);
        }
      } else {
        printResult(title, "Ngày không hợp lệ! Vui lòng nhập lại.", sc);
      }
    }
  }

  public LocalDate printDateUI(String title, String subtitle, String content, String input, Scanner sc) {
    DataCheck checker = new DataCheck("^(\\d{2})/(\\d{2})/(\\d{4})$");
    while (true) {
      String date = printUI(title, subtitle, content, input, sc).trim();
      if (checker.check(date)) {
        try {
          int day = Integer.parseInt(date.substring(0, 2));
          int month = Integer.parseInt(date.substring(3, 5));
          int year = Integer.parseInt(date.substring(6, 10));
          return LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
          printResult(title, "Ngày không tồn tại trên lịch! Vui lòng nhập lại.", sc);
        }
      } else {
        printResult(title, "Ngày không hợp lệ! Vui lòng nhập lại.", sc);
      }
    }
  }

  public String printUIWithSections(Scanner sc, String title, String[] sectionNames, String[][] sections) {
    printHeader(title);

    int idx = 0;
    if (sectionNames != null && sections != null) {
      int limit = Math.min(sectionNames.length, sections.length);
      for (int i = 0; i < limit; i++) {
        System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
        System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
        printSubtitle(sectionNames[i]);
        System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");

        if (sections[i] != null) {
          for (int j = 0; j < sections[i].length; j++) {
            String line = "[" + idx + "] " + sections[i][j];
            printContent(line);
            idx++;
          }
        }
      }
    }

    System.out.println("║" + " ".repeat(CONTENT_WIDTH) + "║");
    System.out.println("╠" + "═".repeat(CONTENT_WIDTH) + "╣");

    return printChoice(sc);
  }
}
