

import java.util.Scanner;

public class Menua {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int aukera;
        String erantzuna = null;

        do {
            // Menu nagusia
            System.out.println("===== MENU NAGUSIA =====");
            System.out.println("1. Aukera 1");
            System.out.println("2. Aukera 2");
            System.out.println("3. Aukera 3");
            System.out.println("4. Saioa Itxi");
            System.out.print("Aukeratu aukera bat: ");

            aukera = sc.nextInt();
            sc.nextLine();

            switch (aukera) {

                case 1:
                    System.out.println("Aukera 1 aukeratu duzu");
                    break;

                case 2:
                    System.out.println("Aukera 2 aukeratu duzu");
                    break;

                case 3:
                    System.out.println("Aukera 3 aukeratu duzu");
                    break;

                case 4:

                    do {
                        System.out.print("Ziur zaude saioa itxi nahi duzula? (bai/ez): ");
                        erantzuna = sc.nextLine();

                    } while (!erantzuna.equalsIgnoreCase("bai")
                            && !erantzuna.equalsIgnoreCase("ez"));

                    if (erantzuna.equalsIgnoreCase("bai")) {
                        System.out.println("Saioa itxi da.");
                    } else {
                        System.out.println("Menu nagusira itzultzen...");
                    }

                    break;

                default:
                    System.out.println("Aukera ez da zuzena.");
            }

        } while (aukera != 4 || erantzuna.equalsIgnoreCase("ez"));

        sc.close();
    }
}