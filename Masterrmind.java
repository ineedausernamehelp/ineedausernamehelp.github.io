package mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Masterrmind {

	public static void main(String[] args) {

		System.out.println("Welcome to Mastermind.");

		// een scanner die de input leest van de speler
		Scanner game = new Scanner(System.in);
		// win conditie
		boolean win = false;

		Random random = new Random();

		// je beurten aantal
		int aantalBeurten = 10;

		boolean[] blackPins = new boolean[4];
		boolean[] whitePins = new boolean[4];

		int[] code = new int[4];
		int[] raden = new int[4];

		Arrays.fill(blackPins, Boolean.FALSE);
		Arrays.fill(whitePins, Boolean.FALSE);

		// random code maken
		for (int i = 0; i < code.length; i++) {
			code[i] = random.nextInt(6) + 1;

			// voor testen
			System.out.println(code[i]);
		}

		// geeft spelregels aan
		System.out.println("vul een getal in tussen de 1 en 6");
		System.out.println("je krijgt er een witte of zwarte pin voor");
		System.out.println("een zwarte pin krijg je door een getal van de code goed te raden");
		System.out.println(
				"Een witte pin krijg je door een getal van de code goed raden alleen op de verkeerd plaats zetten");
		System.out.println("je hebt 10 beurten");

		// herhaalt alles wat erin staat als de winconditie false is
		while (win == false) {

			// leest een getal tussen de 1 en 6
			for (int i = 0; i < raden.length; i++) {
				System.out.println("vul getal " + (i + 1) + " in: ");
				raden[i] = game.nextInt();
			}

			// zo kan je niet 5 getallen opgeven
			game.nextLine();

			// een som om na iedere beurt 1 van het aantalBeurten af te halen
			aantalBeurten--;

			// zwarte pinnen
			for (int i = 0; i < raden.length; i++) {
				if (raden[i] == code[i]) {
					blackPins[i] = true;
					System.out.println("je hebt een zwarte pin");
				}
			}
			
	

			// kijkt of je de goede code hebt geraden

			// als je witte pinnen niet goed geraden zijn komt er te staan dat je geen witte
			// pinnen hebt geraden
			if (whitePins[0] == false && whitePins[1] == false && whitePins[2] == false && whitePins[3] == false) {
				System.out.println("Je hebt geen witte pinnen.");
			}

			// als al je witte pinnen niet goed geraden zijn komt er te staan dat je geen
			// zwarte pinnen hebt geraden
			if (blackPins[0] == false && blackPins[1] == false && blackPins[2] == false && blackPins[3] == false) {
				System.out.println("Je hebt geen zwarte pinnen.");
			}
			// als blackPin1 tm 4 waar is heb je gewonnen
			if (blackPins[0] == true && blackPins[1] == true && blackPins[2] == true && blackPins[3] == true) {
				System.out.println("you win");
				win = true;
			} else if (aantalBeurten > 1) // als je nog meer als 1 beurt hebt print de computer dit hier onder uit
			{
				System.out.println("fout");
				System.out.println("Je hebt nog: " + aantalBeurten + " Beurten.");
				System.out.println("je vulde " + raden[0] + raden[1] + raden[2] + raden[3] + " in");
				System.out.println("Probeer nog eens: ");
				// reset alle pinnen

				Arrays.fill(blackPins, Boolean.FALSE);
				Arrays.fill(whitePins, Boolean.FALSE);
			}

			else if (aantalBeurten == 1)// anders als je nog 1 beurt hebt print dit is je laatste beurt
			{
				System.out.println("je vulde " + raden[0] + raden[1] + raden[2] + raden[3] + " in");
				System.out.println("Dit is je laatste beurt.");
				// reset alle pinnen

				Arrays.fill(blackPins, Boolean.FALSE);
				Arrays.fill(whitePins, Boolean.FALSE);

			} else // anders heb je verloren
			{
				System.out.println("Je hebt je beurten op gemaakt.");
				System.out.println("je vulde " + raden[0] + raden[1] + raden[2] + raden[3] + " in");
				System.out.print("De code was: " + code[0] + code[1] + code[2] + code[3]);
				win = true;

			}
		}
		game.close();
	}

}