package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import agglomeration.Town;

/**
 * Classe pour l'affichage du sujet et des invites de commandes utilisateurs.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Display 
{
	/**
	 * Cr�ation d'un ArrayList de taille 26 qui contiendra les lettres de l'alphabet.
	 * @return alphabet une ArrayList contenant les lettres de l'alphabet.
	 */
	public static ArrayList<String> createAlphabet()
	{
		ArrayList<String> alphabet = new ArrayList<String>();
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		alphabet.add("D");
		alphabet.add("E");
		alphabet.add("F");
		alphabet.add("G");
		alphabet.add("H");
		alphabet.add("I");
		alphabet.add("J");
		alphabet.add("K");
		alphabet.add("L");
		alphabet.add("M");
		alphabet.add("N");
		alphabet.add("O");
		alphabet.add("P");
		alphabet.add("Q");
		alphabet.add("R");
		alphabet.add("S");
		alphabet.add("T");
		alphabet.add("U");
		alphabet.add("V");
		alphabet.add("W");
		alphabet.add("X");
		alphabet.add("Y");
		alphabet.add("Z");
		return alphabet;
	}
	
	/**
	 * Affichage de la probl�matique menant � ce projet.
	 */
	public static void displayLaunch()
	{
		System.out.println("|=============================================================|");
		System.out.println("|======== Projet Programmation: Construction d'�coles ========|");
		System.out.println("|=============================================================|");
		System.out.println("|                      - Amanda Messahel                      |");
		System.out.println("|                       - Johan Laforge                       |");
		System.out.println("|                         - Jack Thay                         |");
		System.out.println("|=============================================================|");
		System.out.println("|Probl�matique:                                               |");
		System.out.println("|Dans le cadre d�une politique ambitieuse concernant          |");
		System.out.println("|l��ducation, un �lu souhaite construire de nouvelles �coles, |");
		System.out.println("|modernes, dans la communaut� d�agglom�ration dont il est     |");
		System.out.println("|responsable.                                                 |");
		System.out.println("|Durant la campagne �lectorale, il a promit deux choses:      |");
		System.out.println("| -Chaque ville doit poss�der son �cole, ou �tre directement  |");
		System.out.println("|  reli�e � une ville qui poss�de une �cole.                  |");
		System.out.println("| -Le co�t du projet doit �tre le plus bas possible, ce qui   |");
		System.out.println("|  signifie que le nombre d��coles � construire               |");
		System.out.println("|  doit �tre le plus petit possible.                          |");
		System.out.println("|=============================================================|");		
	}
	
	/**
	 * Affichage du message de fin.
	 */
	public static void displayEnd()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|====================== Fin du programme =====================|");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage des choix lors de la cr�ation de liens entre villes.
	 */
	public static void displayInterface1()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|============== Cr�ation de route entre villes ===============|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Ajouter une route.                                        |");
		System.out.println("|2) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage des choix lors de l'ajout et retrait d'�coles.
	 */
	public static void displayInterface2()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|================== Ajout/Retrait d'�coles ===================|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Ajouter une �cole.                                        |");
		System.out.println("|2) Retirer une �cole.                                        |");
		System.out.println("|3) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage du Easter Egg, tradition du DUT AS de l'IUT Descartes!
	 */
	public static void displayEasterEgg()
	{
		String song[] = {
				"But we will:",
				">Never gonna give you up",
                ">>Never gonna let you down",
                ">>>Never gonna run around and desert you",
                ">>>>Never gonna make you cry",
                ">>>>>Never gonna say goodbye",
                ">>>>>>Never gonna tell a lie and hurt you"
            };
		System.out.println("");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("|~~~~~~~~~~~~~~~~~~ <!> 2020's the worst <!> ~~~~~~~~~~~~~~~~~|");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");

            for (int i = 0; i < song.length; ++i) {
            	try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
                System.out.println(song[i]);
            }
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour cr�er des villes.
	 */
	public static int displayCreateTown()
	{
		int choice1;
		String commandPrompt = "==>Veuillez entrer le nombre de ville(s) que vous voulez cr�er :";
		do {
			choice1 = protectedIntInput(commandPrompt);
			if (choice1 > 26 )
			{
				System.out.println("<!>Le nombre choisit est incorrect<!>");
				System.out.println("<!>Cette version du projet ne peut avoir plus de 26 villes<!>");
			}
			else if (choice1 <= 0)
			{
				System.out.println("<!>Le nombre choisit est incorrect<!>");
				System.out.println("<!>Vous ne pouvez pas avoir 0 villes ou moins<!>");
			}
		} while (choice1>26 || choice1<=0 );
		return choice1;
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour cr�er des routes entre villes.
	 * @param villeTab tableau de ville cr�� pr�c�demment
	 */
	public static void displayCreateLink(Town[] villeTab) {
		int choice2;
		String commandPrompt2 = "==>Veuillez entrer votre choix :";
		do {
			Display.displayInterface1();
			choice2 = protectedIntInput(commandPrompt2);
			if (choice2 == 1) // l'utilisateur veut cr�er une route
			{
				String commandPrompt2_1 = "===>Veuillez entrer le num�ro de la ville qui va avoir une route :";
				int town1 = protectedIntInput(commandPrompt2_1); // = choix 1
				if (Town.checkTownExist(villeTab,town1)==true) // On v�rifie que le choix 1 �xiste
				{
					String commandPrompt2_2 = "====>Veuillez entrer le num�ro de la ville qui va relier " +villeTab[town1-1].getSerial() + ". " + villeTab[town1-1].getName() + ".";
					int town2 = protectedIntInput(commandPrompt2_2); // = choix 2
					Town.securedLinkCreation(villeTab, town1, town2);
				}
				else // on suppose que le 1er choix l'utilisateur n'existe pas
				{
					System.out.println("<!>La ville "+ town1 +" n'existe pas<!>");
				}
			}
			else if (choice2 == 2) // l'utilisateur a fini la cr�ation de route
			{
				for (int i = 0; i < villeTab.length; ++i) 
				{
					villeTab[i].setSchool(true); // on ajoute une �cole par d�faut dans chaque ville
					System.out.println(ToString.toStringDefaultSchool(villeTab[i]));
				}
				break;
			}
			else if (choice2 == 2020) // l'utilisateur est au courant de notre Easter Egg ;)
			{
				displayEasterEgg();
			}
			else // l'utilisateur tape un choix qui n'existe pas
			{
				System.out.println("<!>Vous n'avez pas entr� un choix valide<!>");
			}
		} while (choice2 != 2);
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour ajouter ou retirer des �coles dans une ville.
	 * @param villeTab tableau de ville pr�cedemment cr��
	 */
	public static void displaySchool(Town[] villeTab) {
		int choice3;
		String commandPrompt3 = "==>Veuillez entrer votre choix :";
		do {
			Display.displayInterface2();
			choice3 = protectedIntInput(commandPrompt3);
			if (choice3 == 1) // l'utilisateur choisi d'ajouter une �cole
			{
				String commandPrompt3_1 = "===>Veuillez entrer le num�ro de la ville qui va avoir une nouvelle �cole :";
				int town = protectedIntInput(commandPrompt3_1);
				Town.securedAddSchool(villeTab, town);
			}
			else if (choice3 == 2) // l'utilisateur choisi de retirer une �cole
			{
				String commandPrompt3_2 = "===>Veuillez entrer le num�ro de la ville qui va perdre son �cole :";
				int town = protectedIntInput(commandPrompt3_2);
				Town.securedRemoveSchool(villeTab, town);
			}
			else if (choice3 == 3) // l'utilisateur met fin au programme
			{
				displayEnd();
				break;
			}
			else if (choice3 == 2020) // l'utilisateur est au courant de notre Easter Egg ;)
			{
				displayEasterEgg();
			}
			else // l'utilisateur tape un choix qui n'existe pas
			{
				System.out.println("<!>Vous n'avez pas entr� un choix valide<!>");
			}
		} while (choice3 != 3);
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour saisir un nombre, si erreur, on redemande � l'utilisateur.
	 * @param prompt la question a pos� � l'utilisateur avant qu'il tape sa saisie
	 * @return tempInt le nombre entr� par l'utilisateur lorsqu'il n'a pas fait d'erreur.
	 */
	public static int protectedIntInput(String prompt)
	{
		//TODO: trouver o� mettre le sc.close()
		boolean correct = false;
		Scanner sc = new Scanner(System.in);
		int tempInt=0;
		do {
			System.out.println(prompt);
			try 
			{
				tempInt = sc.nextInt();
				correct = true;
			} catch(InputMismatchException e ) {
				System.out.println("<!>Erreur de saisie<!>");
				System.out.println("<!>Vous devez saisir un nombre<!>");
				sc.nextLine();
			}
		} while(!correct);
		return tempInt;
	}
}
