package Taxes;

public class Item {
    private static final double SALES_TAX = 0.10;
    private static final double IMPORT_DUTY = 0.05;

    private final String name;
    private final double price;
    private final int quantity;
    private final double taxes;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.taxes = calculateTaxes();
    }

    public double getTaxes() {
        return taxes * quantity;
    }

    public double getTotalPriceWithTax() {
        return (price + taxes) * quantity;
    }

    private double calculateTaxes() {
        double tax = 0;
        if (!isExempt()) {
            tax += SALES_TAX * price;
        }
        if (isImported()) {
            tax += IMPORT_DUTY * price;
        }

        return roundUp(tax);
    }

    private boolean isExempt() {
        return name.contains("book") || name.contains("chocolate") || name.contains("pill");
    }

    private boolean isImported() {
        return name.contains("imported");
    }

    private double roundUp(double value) {
        return Math.ceil(value * 20) / 20.0;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}