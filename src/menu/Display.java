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
	 * Affichage de la problématique menant à ce projet.
	 */
	public static void displayLaunch() // Oui, je pourrais améliorer ça... -- Jack
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
		System.out.println("|Durant la campagne électorale, il a promis deux choses:      |");
		System.out.println("| -Chaque ville doit posséder son école, ou être directement  |");
		System.out.println("|  reliée à une ville qui possède une école.                  |");
		System.out.println("| -Le coût du projet doit être le plus bas possible, ce qui   |");
		System.out.println("|  signifie que le nombre d’écoles à construire               |");
		System.out.println("|  doit être le plus petit possible.                          |");
		System.out.println("|=============================================================|");		
	}
	
	/**
	 * Affichage de la création de liens entre villes.
	 */
	public static void displayInterface1() // Les options suivantes sont celle INDIQUE par le sujet! -- Jack
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|============== Création de route entre villes ===============|");
		System.out.println("|=============================================================|");
		System.out.println("|1. Ajouter une route.                                        |");
		System.out.println("|2. Fin.                                                      |");
		System.out.println("|=============================================================|");
	}

}
