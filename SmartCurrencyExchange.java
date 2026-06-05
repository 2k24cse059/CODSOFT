import java.util.Scanner;

enum Currency {
    INR(1.0),
    USD(0.012),
    EUR(0.011),
    GBP(0.0095),
    JPY(1.74);

    private final double rate;

    Currency(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}

class Converter {

    public double convert(Currency from, Currency to, double amount) {

        double amountInINR = amount / from.getRate();

        return amountInINR * to.getRate();
    }
}

public class SmartCurrencyExchange {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.println("=================================");
        System.out.println("      SMART CURRENCY EXCHANGE");
        System.out.println("=================================");

        System.out.println("\nAvailable Currencies:");
        for (Currency c : Currency.values()) {
            System.out.println("- " + c);
        }

        System.out.print("\nEnter Base Currency: ");
        Currency base = Currency.valueOf(sc.next().toUpperCase());

        System.out.print("Enter Target Currency: ");
        Currency target = Currency.valueOf(sc.next().toUpperCase());

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        double result = converter.convert(base, target, amount);

        System.out.println("\n========== RESULT ==========");
        System.out.println("From : " + base);
        System.out.println("To   : " + target);
        System.out.println("Amount Entered : " + amount);
        System.out.printf("Converted Value : %.2f %s\n",
                result, target);
        System.out.println("============================");

        sc.close();
    }
}