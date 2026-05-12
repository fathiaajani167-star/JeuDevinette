import java.util.Random;
import java.util.Scanner;

public class Devinette {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int nombreSecret = random.nextInt(100) + 1; // Entre 1 et 100
        int tentativesMax = 10;
        boolean gagne = false;

        System.out.println("--- Bienvenue au Jeu de Devinettes (Java) ---");
        System.out.println("J'ai choisi un nombre entre 1 et 100. Saurez-vous le trouver en 10 essais ?");

        for (int essai = 1; essai <= tentativesMax; essai++) {
            System.out.print("Essai " + essai + "/" + tentativesMax + " - Votre proposition : ");

            // Vérification que l'entrée est bien un nombre
            if (!scanner.hasNextInt()) {
                System.out.println("Erreur : Veuillez entrer un nombre entier.");
                scanner.next(); // Consomme l'entrée invalide
                essai--; // Ne compte pas l'essai
                continue;
            }

            int proposition = scanner.nextInt();

            if (proposition < nombreSecret) {
                System.out.println("C'est PLUS ! ↑");
            } else if (proposition > nombreSecret) {
                System.out.println("C'est MOINS ! ↓");
            } else {
                System.out.println("Félicitations ! Vous avez trouvé le nombre " + nombreSecret + " en " + essai + " essais. 🎉");
                gagne = true;
                break;
            }
        }

        if (!gagne) {
            System.out.println("Dommage ! Vous avez épuisé vos 10 essais. Le nombre était : " + nombreSecret);
        }

        scanner.close();
    }
}