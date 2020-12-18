package algorithm;

import agglomeration.Town;
import menu.DisplayRendu2;
import menu.ToString;

import java.util.Random;
/**
 * Classe pour les de remplissage automatique des écoles dans une agglomération.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Algorithm {
	
	/**
	 * Un algorithme d’approximation (naïf) pour la résolution de l'accessibilité des écoles dans une agglomération donné dans l'énoncé.
	 * @param villeTab agglomération qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la résolution de l'accessibilité des écoles.
	 * @return villeTab agglomération après avoir subi l'algorithme.
	 */
	public static Town[] algorithm1(Town[] villeTab, int k)
	{
		int i = 0;
		do
		{
			int randomIndex = new Random().nextInt(villeTab.length); // selection d'un index au hasard parmi le tableau de Town.
			if (villeTab[randomIndex].isSchool()==true)
			{
				Town.securedRemoveSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index
			}
			else
			{
				Town.securedAddSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index				
			}
			i++;
		} while (i<k);
		System.out.println("");
		System.out.println("==>Vérification des contraintes d'accessibilité :");
		if (Town.checkConstraintAccess(villeTab)==false)
		{
			System.out.println("<!>L'agglomération ne respecte pas les contraintes d'accessibilité<!>");
		}
		else if (Town.checkConstraintAccess(villeTab)==true)
		{
			System.out.println("*L'agglomération respecte les contraintes d'accessibilité*");
		}
		return villeTab;
	}
	
	/**
	 * Un algorithme d’approximation (un peu moins naïf) pour la résolution de l'accessibilité des écoles dans une agglomération donné dans l'énoncé.
	 * @param villeTab agglomération qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la résolution de l'accessibilité des écoles.
	 * @return villeTab agglomération après avoir subi l'algorithme.
	 */
	public static Town[] algorithm2(Town[] villeTab, int k)
	{
		int i = 0;
		int scoreCourant = getScore(villeTab);
		do
		{
			int randomIndex = new Random().nextInt(villeTab.length); // selection d'un index au hasard parmi le tableau de Town.
			if (villeTab[randomIndex].isSchool()==true)
			{
				Town.securedRemoveSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index
			}
			else
			{
				Town.securedAddSchool(villeTab, randomIndex+1); // random+1 car cette fonction prend en parametre le serial de la ville et pas son index				
			}
			if (getScore(villeTab)<scoreCourant)
			{
				i = 0;
				scoreCourant = getScore(villeTab);
			}
			else
			{
				i++;
			}
		} while (i<k);
		System.out.println("");
		System.out.println("==>Vérification des contraintes d'accessibilité :");
		if (Town.checkConstraintAccess(villeTab)==false)
		{
			System.out.println("<!>L'agglomération ne respecte pas les contraintes d'accessibilité<!>");
		}
		else if (Town.checkConstraintAccess(villeTab)==true)
		{
			System.out.println("*L'agglomération respecte les contraintes d'accessibilité*");
		}
		return villeTab;
	}
	
	/**
	 * Un algorithme d’approximation developpé par nos soins pour la résolution de l'accessibilité des écoles dans une agglomération donné dans l'énoncé.
	 * @param villeTab agglomération qu'on souhaite remlir.
	 * @return villeTab agglomération après avoir subi l'algorithme.
	 */
	public static Town[] algorithmCustom(Town[] villeTab)
	{
		for (int i = 0; i < villeTab.length; ++i) // on retire toutes les écoles dans l'agglomération.
		{
			villeTab[i].setSchool(false);
		}
		for (int i = 0; i < villeTab.length; ++i) // on ajoute une école dans toutes les villes isolés.
		{
			if (villeTab[i].getLink().size()==0)
			{
				villeTab[i].setSchool(true);
			}
		}
		for (int i = 0; i < villeTab.length; ++i) // on ajoute une école dans les voisins des toutes les villes qui n'ont que 1 voisin.
		{
			if (villeTab[i].getLink().size()==1)
			{
				int voisin =villeTab[i].getLink().get(0);
				if (villeTab[voisin-1].isSchool()==false) 
				{
					villeTab[voisin-1].setSchool(true);
				}
			}
		}
		/*
		 * On commence par la ville avec la plus grande liste d'adjacence, et on lui ajoute une école,
		 * on vérifie ensuite les contraintes d'accessibilités.
		 * On continue avec le 2ème ville avec la plus grande liste d'adjacence, le 3ème...
		 * jusqu'à ce que l'agglomération respecte enfin les contraintes d'accessibilités
		 */
		do 
		{
			for (int i = villeTab.length-1; i >= 0; --i) // -1 car une ville peut être relié à toutes les autres, mais pas à elle-même.
			{
				if (villeTab[i].getLink().size()==i)
				{
					if (villeTab[i].isSchool()==false)
					{
						villeTab[i].setSchool(true);
					}
				}
			}
		} while (Town.checkConstraintAccess(villeTab)==false);
		for (int i = 0; i < villeTab.length; ++i) // dernier passage pour retirer les écoles superflues
		{
			if (villeTab[i].isSchool()==true)
			{
				if (Town.removableSchool(villeTab, i+1)==true)
				{
					villeTab[i].setSchool(false);
				}
			}
		}
		return villeTab;
	}
	
	/**
	 * Permet de récupérer un score d'une agglomération, le score étant le nombre d'école présente.
	 * @param villeTab agglomération qu'on souhaite éxaminer.
	 * @return score le score de l'agglomération éxaminé.
	 */
	public static int getScore(Town[] villeTab)
	{
		int score = 0;
		for (int i = 0; i < villeTab.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if(villeTab[i].isSchool()==true)
			{
				++score;
			}
		}
		return score;
	}

}
