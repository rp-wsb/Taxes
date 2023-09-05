package Taxes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class SalesTaxApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StringBuilder input = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            input.append(line).append("\n");
        }

        String result = processInput(input.toString());
        System.out.println(result + "\n");
        scanner.close();
    }


    public static String processInput(String input) {
        Receipt receipt = new Receipt();
        String[] lines = input.split("\n");

        for (String line : lines) {
            Pattern pattern = Pattern.compile("(\\d+) (.+) at (\\d+.\\d{2})");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                int quantity = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                double price = Double.parseDouble(matcher.group(3));

                Item item = new Item(name, price, quantity);
                receipt.addItem(item);
            }
        }

        return receipt.toString();
    }


}
