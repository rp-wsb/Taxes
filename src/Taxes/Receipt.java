package Taxes;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Receipt {
    private final List<Item> items = new ArrayList<>();
    private double totalTaxes = 0;
    private double totalAmount = 0;

    void addItem(Item item) {
        items.add(item);
        totalTaxes += item.getTaxes();
        totalAmount += item.getTotalPriceWithTax();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Item item : items) {
            builder.append(item.getQuantity()).append(" ")
                    .append(item.getName()).append(": ")
                    .append(String.format(Locale.US, "%.2f", item.getTotalPriceWithTax())).append("\n");
        }

        builder.append("Sales Taxes: ").append(String.format(Locale.US, "%.2f", totalTaxes)).append("\n");
        builder.append("Total: ").append(String.format(Locale.US, "%.2f", totalAmount));

        return builder.toString();
    }
}