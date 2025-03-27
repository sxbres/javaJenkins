package app;

import java.util.Scanner;

public class DrSlump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arale arale = new Arale("Arale Norimaki", 50);
        Senbei senbei = new Senbei("Senbei Norimaki", 70);

        while (true) {
            System.out.println("\nDr. Slump App");
            System.out.println("1. Veure estats");
            System.out.println("2. Arale menja Ncha");
            System.out.println("3. Senbei inventa");
            System.out.println("4. Sortir");
            System.out.print("Selecciona una opció: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Arale - Energia: " + arale.getEnergy());
                    System.out.println("Senbei - Intel·ligència: " + senbei.getIntelligence());
                    break;
                case 2:
                    arale.eatNcha();
                    System.out.println("Arale ha menjat Ncha!");
                    break;
                case 3:
                    senbei.invent();
                    System.out.println("Senbei ha inventat alguna cosa!");
                    break;
                case 4:
                    System.out.println("Adeu!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opció no vàlida!");
            }
        }
    }
}