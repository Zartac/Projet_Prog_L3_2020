package menu;

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
	 * Affichage de la probl�matique menant � ce projet.
	 */
	public static void displayLaunch() // Oui, je pourrais am�liorer �a... -- Jack
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
		System.out.println("|Durant la campagne �lectorale, il a promis deux choses:      |");
		System.out.println("| -Chaque ville doit poss�der son �cole, ou �tre directement  |");
		System.out.println("|  reli�e � une ville qui poss�de une �cole.                  |");
		System.out.println("| -Le co�t du projet doit �tre le plus bas possible, ce qui   |");
		System.out.println("|  signifie que le nombre d��coles � construire               |");
		System.out.println("|  doit �tre le plus petit possible.                          |");
		System.out.println("|=============================================================|");		
	}
	
	/**
	 * Affichage des choix lors de la cr�ation de liens entre villes.
	 */
	public static void displayInterface1() // Les options suivantes sont identique � celle du sujet! -- Jack
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
	public static void displayInterface2() // Les options suivantes sont identique � celle du sujet! -- Jack
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
		String song[] = { // J'y tiens � mon RickRoll! -- Jack
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
	
	public static int displayCreateTown()
	{
		int choice1;
		do {
			System.out.println("==>Veuillez entrer le nombre de ville(s) que vous voulez cr�er:");
			Scanner sc1 = new Scanner(System.in);
			int tempChoice1 = sc1.nextInt();
			choice1 = tempChoice1;
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
	
	public static void displayCreateLink(Town[] tab) {
		int choice2;
		do {
			Display.displayInterface1();
			System.out.println("==>Veuillez entrer votre choix:");
			Scanner sc2 = new Scanner(System.in);
			int tempChoice2 = sc2.nextInt();
			choice2 = tempChoice2;
			if (choice2 == 1) // l'utilisateur veut cr�er une route
			{
				System.out.println("===>Veuillez entrer le num�ro de la ville qui va avoir une route");
				Scanner sc2_1 = new Scanner(System.in);
				int town1 = sc2_1.nextInt(); // =choix1
				if (Town.checkTownExist(tab,town1)==true) // On v�rifie que le choix 1 �xiste
				{
					System.out.println("====>Veuillez entrer le num�ro de la ville qui va relier " +tab[town1-1].getSerial() + ". " + tab[town1-1].getName() + ".");
					Scanner sc2_2 = new Scanner(System.in);
					int town2 = sc2_2.nextInt(); // =choix2
					// Code converti d'Amanda
					if (town1==town2) // On v�rifie que l'utilisateur n'essaye pas de cr�er une route d'une ville a elle m�me
					{
						System.out.println("<!>Nous ne pouvons cr�er une route d'une ville vers elle m�me<!>");
					}
					else if(Town.checkLinkExist(tab[town1-1], town2)) // On v�rifie que choix 1 est pas d�j� reli� choix 2
					{
						System.out.println(ToString.toStringLinkExist(tab[town1-1], tab[town2-1]));
					}
					else if(Town.checkTownExist(tab,town2)==true) // On v�rifie que les 2 villes �xiste
					{
						tab[town1-1].addToLink(tab[town1-1].getLink(), town2); // On ajoute le choix 2 de l'utilisateur dans la liste d'adjacence du choix 1
						System.out.println(ToString.toStringLinkCreated(tab[town1-1])); // On affiche la liste d'adjacence du choix 1
						tab[town2-1].addToLink(tab[town2-1].getLink(), town1); // On ajoute le choix 1 de l'utilisateur dans la liste d'adjacence du choix 2
						System.out.println(ToString.toStringLinkCreated(tab[town2-1])); // On affiche la liste d'adjacence du choix 2
					}
					else // on suppose que le 2�me choix l'utilisateur n'existe pas
					{
						System.out.println("<!>La ville "+ town2 +" n'existe pas<!>");
					}
				}
				else // on suppose que le 1er choix l'utilisateur n'existe pas
				{
					System.out.println("<!>La ville "+ town1 +" n'existe pas<!>");
				}
			}
			else if (choice2 == 2) // l'utilisateur a fini la cr�ation de route
			{
				for (int i = 0; i < tab.length; ++i) 
				{
					tab[i].setSchool(true); // on ajoute une �cole par d�faut dans chaque ville
					System.out.println(ToString.toStringDefaultSchool(tab[i]));
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
	
	public static void displaySchool(Town[] tab) {
		int choice3;
		do {
			Display.displayInterface2();
			System.out.println("==>Veuillez entrer votre choix:");
			Scanner sc3 = new Scanner(System.in);
			int tempChoice3 = sc3.nextInt();
			choice3 = tempChoice3;
			if (choice3 == 1) // l'utilisateur choisi d'ajouter une �cole
			{
				System.out.println("==>Veuillez entrer le num�ro de la ville qui va avoir une nouvelle �cole");
				Scanner sc3_1 = new Scanner(System.in);
				int town = sc3_1.nextInt();
				if(tab[town-1].isSchool()==true) System.out.println("<!>Cette ville poss�de d�j� une �cole<!>"); // on v�rifie que la ville n'a pas d�j� une �cole
				else if (tab[town-1].isSchool()==false) { // si cette ville n'a pas d'�cole
					tab[town-1].setSchool(true);
					System.out.println(ToString.toStringSchoolAdded(tab[town-1]));
				}
				System.out.println(ToString.toStringSchoolList(tab));
			}
			else if (choice3 == 2) // l'utilisateur choisi de retirer une �cole
			{
				System.out.println("==>Veuillez entrer le num�ro de la ville qui va perdre son �cole");
				Scanner sc3_2 = new Scanner(System.in);
				int town = sc3_2.nextInt();
				if(tab[town-1].isSchool()==true) {
					if(Town.checkLinkSchool(tab, town)==true) {
						tab[town-1].setSchool(false);
						System.out.println(ToString.toStringSchoolRemoved(tab[town-1]));
					}
					else System.out.println(ToString.toStringNoSchool(tab[town-1]));
				}
				else if (tab[town-1].isSchool()==false) System.out.println("<!>Cette ville n'a pas d'�cole<!>");
				System.out.println(ToString.toStringSchoolList(tab));
			}
			else if (choice3 == 3) // l'utilisateur met fin au programme
			{
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
}
