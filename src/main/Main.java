package main;

import java.util.Arrays;
import java.util.Scanner;
import town.Town;
import menu.Display;

/**
 * Classe principale pour le lancement de l'application.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Main {
	public static void main(String[]args)
	{
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K'
				,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		Display.displayLaunch();
		int choice1=Display.displayCreateTown();
		Town[] tab = new Town[choice1]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(alphabet[i]); // On crée autant de ville que l'utilsateur a choisi
			System.out.println(tab[i].getSerial() + ". La ville " + tab[i].getName() + " a été crée.");
		}
		int choice2;
		do {
			Display.displayInterface1();
			System.out.println("==>Veuillez entrer votre choix:");
			Scanner sc2 = new Scanner(System.in);
			int tempChoice2 = sc2.nextInt();
			choice2 = tempChoice2;
			if (choice2 == 1)
			{
				System.out.println("==>Veuillez entrer le numéro de la ville qui va avoir une route");
				Scanner sc2_1 = new Scanner(System.in);
				int town1 = sc2_1.nextInt();
				System.out.println("===>Veuillez entrer le numéro de la ville qui va relier " +tab[town1-1].getSerial() + ". " + tab[town1-1].getName());
				Scanner sc2_2 = new Scanner(System.in);
				int town2 = sc2_2.nextInt();
				tab[town1-1].addToLink(tab[town1-1].getLink(), town2);
				System.out.println("La ville " + tab[town1-1].getSerial() + ". " + tab[town1-1].getName() + " est relié à" + Arrays.toString(tab[town1-1].getLink()));
			}
			else if (choice2 == 2)
			{
				for (int i = 0; i < tab.length; ++i) 
				{
					tab[i].setSchool(true);
					System.out.println("Une école a été établi par défaut dans la ville " +tab[i].getSerial() + ". " + tab[i].getName());
				}
				break;
			}
			else
			{
				System.out.println("Vous n'avez pas rentrer un choix valide!");
			}
		} while (choice2 != 2);
		Display.displayInterface2();
		
	}

}

