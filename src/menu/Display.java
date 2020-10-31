package menu;

import java.util.Scanner;

import town.Town;

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
	 * Affichage de la cr�ation de liens entre villes.
	 */
	public static void displayInterface1() // Les options suivantes sont celle INDIQUE par le sujet! -- Jack
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|============== Cr�ation de route entre villes ===============|");
		System.out.println("|=============================================================|");
		System.out.println("|1. Ajouter une route.                                        |");
		System.out.println("|2. Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage de l'ajout et retrait d'�coles.
	 */
	public static void displayInterface2() // Les options suivantes sont celle INDIQUE par le sujet! -- Jack
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|================== Ajout/Retrait d'�coles ===================|");
		System.out.println("|=============================================================|");
		System.out.println("|1. Ajouter une �cole.                                        |");
		System.out.println("|2. Retirer une �cole.                                        |");
		System.out.println("|3. Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	public static int displayCreateTown() // Les options suivantes sont celle INDIQUE par le sujet! -- Jack
	{
		int choice1;
		do {
			System.out.println("==>Veuillez entrer le nombre de ville que vous voulez cr�er:");
			Scanner sc1 = new Scanner(System.in);
			int tempChoice1 = sc1.nextInt();
			choice1 = tempChoice1;
			if (choice1 > 26 )
			{
				System.out.println("<!>Le nombre choisit est incorrect<!>");
				System.out.println(">Cette version du projet ne peut avoir plus de 26 villes.<");
			}
			else if (choice1 <= 0)
			{
				System.out.println("<!>La nombre choisit est incorrect<!>");
				System.out.println(">Vous ne pouvez pas avoir 0 villes ou moins.<");
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
			if (choice2 == 1)
			{
				System.out.println("==>Veuillez entrer le num�ro de la ville qui va avoir une route");
				Scanner sc2_1 = new Scanner(System.in);
				int town1 = sc2_1.nextInt();
				System.out.println("===>Veuillez entrer le num�ro de la ville qui va relier " +tab[town1-1].getSerial() + ". " + tab[town1-1].getName());
				Scanner sc2_2 = new Scanner(System.in);
				int town2 = sc2_2.nextInt();
				tab[town1-1].addToLink(tab[town1-1].getLink(), town2);
				System.out.println(ToString.toStringLinkCreated(tab[town1-1]));
			}
			else if (choice2 == 2)
			{
				for (int i = 0; i < tab.length; ++i) 
				{
					tab[i].setSchool(true);
					System.out.println(ToString.toStringDefaultSchool(tab[i]));
				}
				break;
			}
			else
			{
				System.out.println("Vous n'avez pas rentrer un choix valide!");
			}
		} while (choice2 != 2);
	}
	
}
