import java.text.NumberFormat;
import java.util.Scanner;

class Account {
    private long tk;
    private String tentk;
    private double tientrongtk;
    Scanner sc = new Scanner(System.in);

    // Default constructor
    public Account() {
        this.tk = 0;
        this.tentk = "";
        this.tientrongtk = 0.0;
    }

    // Parameterized constructor
    public Account(long tk, String tentk, double tientrongtk) {
        this.tk = tk;
        this.tentk = tentk;
        this.tientrongtk = tientrongtk;
    }

    public long getTk() {
        return tk;
    }

    public String getTentk() {
        return tentk;
    }

    public double getTientrongtk() {
        return tientrongtk;
    }

    public void setTk(long tk) {
        this.tk = tk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public void setTientrongtk(double tientrongtk) {
        this.tientrongtk = tientrongtk;
    }

    public void intk() {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(tientrongtk);
        System.out.printf("%-10d %-20s %-20s \n", tk, tentk, str1);
    }

    public void napTien() {
        System.out.println("Enter amount to deposit: ");
        double nap = sc.nextDouble();
        if (nap >= 0) {
            tientrongtk += nap;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("You have deposited " + str1 + " into your account.");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void rutTien() {
        System.out.println("Enter amount to withdraw: ");
        double rut = sc.nextDouble();
        double phi = 5;  // withdrawal fee
        if (rut <= (tientrongtk - phi)) {
            tientrongtk -= (rut + phi);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);Ma
            System.out.println("You have withdrawn " + str1 + " from your account.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void daoHan() {
        double laisuat = 0.35;  // 35% interest rate
        tientrongtk += tientrongtk * laisuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(tientrongtk);
        System.out.println("You have earned " + str1 + " from 1-month maturity.");
    }
}

/-----------------------------------/
/Main.java
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void nhap(Account tk) {
        System.out.println("Enter account number: ");
        tk.setTk(sc.nextLong());
        sc.nextLine(); // consume newline
        System.out.println("Enter account name: ");
        tk.setTentk(sc.nextLine());
        tk.setTientrongtk(50);  // Default initial balance
    }

    public static void main(String[] args) {
        Account[] a = null;
        int b, n = 0;
        boolean flag = true;

        do {
            System.out.println("Your choice:");
            System.out.println("1. Enter customer information.");
            System.out.println("2. Export list of customer information.");
            System.out.println("3. Deposit to an account.");
            System.out.println("4. Withdraw from an account.");
            System.out.println("5. Maturity.");
            System.out.println("6. Transfer money.");
            System.out.println("Other numbers to exit.");
            b = sc.nextInt();
            
            switch (b) {
                case 1:
                    System.out.println("Number of customers: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Customer " + (i + 1) + ":");
                        a[i] = new Account();
                        nhap(a[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s\n", "Account No.", "Account Name", "Balance");
                    for (int i = 0; i < n; i++) {
                        a[i].intk();
                    }
                    break;
                case 3:
                    System.out.println("Enter account number to deposit: ");
                    long s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        if (a[i].getTk() == s) {
                            a[i].napTien();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter account number to withdraw: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        if (a[i].getTk() == s) {
                            a[i].rutTien();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter account number for maturity: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        if (a[i].getTk() == s) {
                            a[i].daoHan();
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter sender's account number: ");
                    long fromAccount = sc.nextLong();
                    System.out.println("Enter receiver's account number: ");
                    long toAccount = sc.nextLong();
                    System.out.println("Enter amount to transfer: ");
                    double amount = sc.nextDouble();
                    boolean success = false;
                    for (int i = 0; i < n; i++) {
                        if (a[i].getTk() == fromAccount) {
                            for (int j = 0; j < n; j++) {
                                if (a[j].getTk() == toAccount) {
                                    if (a[i].getTientrongtk() >= amount) {
                                        a[i].setTientrongtk(a[i].getTientrongtk() - amount);
                                        a[j].setTientrongtk(a[j].getTientrongtk() + amount);
                                        System.out.println("Transfer successful!");
                                    } else {
                                        System.out.println("Insufficient balance!");
                                    }
                                    success = true;
                                    break;
                                }
                            }
                        }
                        if (success) break;
                    }
                    if (!success) System.out.println("Transfer failed.");
                    break;
                default:
                    System.out.println("Bye!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
