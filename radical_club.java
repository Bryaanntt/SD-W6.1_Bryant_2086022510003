import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class radical_club {
    public static void main(String[] args) {
        radical_club club = new radical_club();
        club.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your recruitment Age:");
        String n = scanner.nextLine();

        // Pengecekan jika input kosong
        if (n.isEmpty()) {
            System.out.println("No recruitment data available.");
            scanner.close();
            return;
        }

        // Split input berdasarkan spasi
        String[] agerequitment = n.split(" ");
        int[] ages = new int[agerequitment.length];

        // Pengecekan jika dimasukkan bukan angka & validasi range 0-1000
        for (int i = 0; i < agerequitment.length; i++) {
            try {
                ages[i] = Integer.parseInt(agerequitment[i]);
                if (ages[i] < 0 || ages[i] > 1000) {
                    System.out.println("Error: Input harus berupa angka antara 0 dan 1000!");
                    scanner.close();
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka!");
                scanner.close();
                return;
            }
        }

        System.out.println("Radical Club Recruitment: " + Arrays.toString(ages));

        // LinkedList digunakan karena Queue adalah interface
        Queue<Integer> AgeLolos = new LinkedList<>();
        Queue<Integer> AgeTidakLolos = new LinkedList<>();

        for (int i = 0; i < ages.length; i++) {
            if (ages[i] >= 28 && ages[i] <= 118) {
                AgeLolos.add(ages[i]);
            } else {
                AgeTidakLolos.add(ages[i]);
            }
        }

        System.out.println("Age Lolos: " + AgeLolos);
        System.out.println("Age Tidak Lolos: " + AgeTidakLolos);

        scanner.close();
    }
}