package menu;

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
	 * Affichage de la problématique menant à ce projet.
	 */
	public static void displayLaunch()
	{
		System.out.println("|=============================================================|");
		System.out.println("|======== Projet Programmation: Construction d'écoles ========|");
		System.out.println("|=============================================================|");
		System.out.println("|                      - Amanda Messahel                      |");
		System.out.println("|                       - Johan Laforge                       |");
		System.out.println("|                         - Jack Thay                         |");
		System.out.println("|=============================================================|");
		System.out.println("|Problématique:                                               |");
		System.out.println("|Dans le cadre d’une politique ambitieuse concernant          |");
		System.out.println("|l’éducation, un élu souhaite construire de nouvelles écoles, |");
		System.out.println("|modernes, dans la communauté d’agglomération dont il est     |");
		System.out.println("|responsable.                                                 |");
		System.out.println("|Durant la campagne électorale, il a promit deux choses:      |");
		System.out.println("| -Chaque ville doit posséder son école, ou être directement  |");
		System.out.println("|  reliée à une ville qui possède une école.                  |");
		System.out.println("| -Le coût du projet doit être le plus bas possible, ce qui   |");
		System.out.println("|  signifie que le nombre d’écoles à construire               |");
		System.out.println("|  doit être le plus petit possible.                          |");
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
	 * Affichage des choix lors de la création de liens entre villes.
	 */
	public static void displayInterface1()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|============== Création de route entre villes ===============|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Ajouter une route.                                        |");
		System.out.println("|2) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage des choix lors de l'ajout et retrait d'écoles.
	 */
	public static void displayInterface2()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|================== Ajout/Retrait d'écoles ===================|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Ajouter une école.                                        |");
		System.out.println("|2) Retirer une école.                                        |");
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
	 * Affichage des invites de commandes utilisateurs pour créer des villes.
	 */
	public static int displayCreateTown()
	{
		int choice1;
		String commandPrompt = "==>Veuillez entrer le nombre de ville(s) que vous voulez créer :";
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
	 * Affichage des invites de commandes utilisateurs pour créer des routes entre villes.
	 * @param villeTab tableau de ville créé précédemment
	 */
	public static void displayCreateLink(Town[] villeTab) {
		int choice2;
		String commandPrompt2 = "==>Veuillez entrer votre choix :";
		do {
			Display.displayInterface1();
			choice2 = protectedIntInput(commandPrompt2);
			if (choice2 == 1) // l'utilisateur veut créer une route
			{
				String commandPrompt2_1 = "===>Veuillez entrer le numéro de la ville qui va avoir une route :";
				int town1 = protectedIntInput(commandPrompt2_1); // = choix 1
				if (Town.checkTownExist(villeTab,town1)==true) // On vérifie que le choix 1 éxiste
				{
					String commandPrompt2_2 = "====>Veuillez entrer le numéro de la ville qui va relier " +villeTab[town1-1].getSerial() + ". " + villeTab[town1-1].getName() + ".";
					int town2 = protectedIntInput(commandPrompt2_2); // = choix 2
					if (town1==town2) // On vérifie que l'utilisateur n'essaye pas de créer une route d'une ville a elle même
					{
						System.out.println("<!>Nous ne pouvons créer une route d'une ville vers elle même<!>");
					}
					else if(Town.checkLinkExist(villeTab[town1-1], town2)) // On vérifie que choix 1 est pas déjà relié choix 2
					{
						System.out.println(ToString.toStringLinkExist(villeTab[town1-1], villeTab[town2-1]));
					}
					else if(Town.checkTownExist(villeTab,town2)==true) // On vérifie que les 2 villes éxiste
					{
						villeTab[town1-1].addToLink(villeTab[town1-1].getLink(), town2); // On ajoute le choix 2 de l'utilisateur dans la liste d'adjacence du choix 1
						System.out.println(ToString.toStringLinkCreated(villeTab[town1-1])); // On affiche la liste d'adjacence du choix 1
						villeTab[town2-1].addToLink(villeTab[town2-1].getLink(), town1); // On ajoute le choix 1 de l'utilisateur dans la liste d'adjacence du choix 2
						System.out.println(ToString.toStringLinkCreated(villeTab[town2-1])); // On affiche la liste d'adjacence du choix 2
					}
					else // on suppose que le 2ème choix l'utilisateur n'existe pas
					{
						System.out.println("<!>La ville "+ town2 +" n'existe pas<!>");
					}
				}
				else // on suppose que le 1er choix l'utilisateur n'existe pas
				{
					System.out.println("<!>La ville "+ town1 +" n'existe pas<!>");
				}
			}
			else if (choice2 == 2) // l'utilisateur a fini la création de route
			{
				for (int i = 0; i < villeTab.length; ++i) 
				{
					villeTab[i].setSchool(true); // on ajoute une école par défaut dans chaque ville
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
				System.out.println("<!>Vous n'avez pas entré un choix valide<!>");
			}
		} while (choice2 != 2);
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour ajouter ou retirer des écoles dans une ville.
	 * @param villeTab tableau de ville précedemment créé
	 */
	public static void displaySchool(Town[] villeTab) {
		//TODO: empêcher la selection d'école inéxistante.
		int choice3;
		String commandPrompt3 = "==>Veuillez entrer votre choix :";
		do {
			Display.displayInterface2();
			choice3 = protectedIntInput(commandPrompt3);
			if (choice3 == 1) // l'utilisateur choisi d'ajouter une école
			{
				String commandPrompt3_1 = "===>Veuillez entrer le numéro de la ville qui va avoir une nouvelle école :";
				int town = protectedIntInput(commandPrompt3_1);
				if (Town.checkTownExist(villeTab,town)==true) // On vérifie que la ville existe
				{
					if(villeTab[town-1].isSchool()==true) System.out.println("<!>Cette ville possède déjà une école<!>"); // on vérifie que la ville n'a pas déjà une école
					else if (villeTab[town-1].isSchool()==false) { // si cette ville n'a pas d'école
						villeTab[town-1].setSchool(true);
						System.out.println(ToString.toStringSchoolAdded(villeTab[town-1]));
					}
					System.out.println(ToString.toStringSchoolList(villeTab));
				}
				else // on suppose que le choix l'utilisateur n'existe pas
				{
					System.out.println("<!>La ville "+ town +" n'existe pas<!>");
				}
			}
			else if (choice3 == 2) // l'utilisateur choisi de retirer une école
			{
				String commandPrompt3_2 = "===>Veuillez entrer le numéro de la ville qui va perdre son école :";
				int town = protectedIntInput(commandPrompt3_2);
				if (Town.checkTownExist(villeTab,town)==true) // On vérifie que la ville existe
				{
					if(villeTab[town-1].isSchool()==true) // On vérifie qu'il y'a une école à retirer.
					{
						if(Town.checkLinkSchool(villeTab, town)==true) // On vérifie la liste d'adjacence de la ville
						{
							villeTab[town-1].setSchool(false);
							System.out.println(ToString.toStringSchoolRemoved(villeTab[town-1]));
						}
						else System.out.println(ToString.toStringNoSchool(villeTab[town-1]));
					}
					else if (villeTab[town-1].isSchool()==false) System.out.println("<!>Cette ville n'a pas d'école<!>");
					System.out.println(ToString.toStringSchoolList(villeTab));
				}
				else // on suppose que le choix l'utilisateur n'existe pas
				{
					System.out.println("<!>La ville "+ town +" n'existe pas<!>");
				}
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
				System.out.println("<!>Vous n'avez pas entré un choix valide<!>");
			}
		} while (choice3 != 3);
	}
	
	/**
	 * Affichage des invites de commandes utilisateurs pour saisir un nombre, si erreur, on redemande à l'utilisateur.
	 * @param prompt la question a posé à l'utilisateur avant qu'il tape sa saisie
	 * @return tempInt le nombre entré par l'utilisateur lorsqu'il n'a pas fait d'erreur.
	 */
	public static int protectedIntInput(String prompt)
	{
		//TODO: trouver où mettre le sc.close()
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
