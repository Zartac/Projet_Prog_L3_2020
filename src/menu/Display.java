package menu;

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

}
