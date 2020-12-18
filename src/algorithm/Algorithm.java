package algorithm;

import agglomeration.Town;
import menu.DisplayRendu2;
import menu.ToString;

import java.util.Random;
/**
 * Classe pour les de remplissage automatique des �coles dans une agglom�ration.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Algorithm {
	
	/**
	 * Un algorithme d�approximation (na�f) pour la r�solution de l'accessibilit� des �coles dans une agglom�ration donn� dans l'�nonc�.
	 * @param villeTab agglom�ration qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la r�solution de l'accessibilit� des �coles.
	 * @return villeTab agglom�ration apr�s avoir subi l'algorithme.
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
		System.out.println("==>V�rification des contraintes d'accessibilit� :");
		if (Town.checkConstraintAccess(villeTab)==false)
		{
			System.out.println("<!>L'agglom�ration ne respecte pas les contraintes d'accessibilit�<!>");
		}
		else if (Town.checkConstraintAccess(villeTab)==true)
		{
			System.out.println("*L'agglom�ration respecte les contraintes d'accessibilit�*");
		}
		return villeTab;
	}
	
	/**
	 * Un algorithme d�approximation (un peu moins na�f) pour la r�solution de l'accessibilit� des �coles dans une agglom�ration donn� dans l'�nonc�.
	 * @param villeTab agglom�ration qu'on souhaite remlir.
	 * @param k le nombre de tentative pour la r�solution de l'accessibilit� des �coles.
	 * @return villeTab agglom�ration apr�s avoir subi l'algorithme.
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
		System.out.println("==>V�rification des contraintes d'accessibilit� :");
		if (Town.checkConstraintAccess(villeTab)==false)
		{
			System.out.println("<!>L'agglom�ration ne respecte pas les contraintes d'accessibilit�<!>");
		}
		else if (Town.checkConstraintAccess(villeTab)==true)
		{
			System.out.println("*L'agglom�ration respecte les contraintes d'accessibilit�*");
		}
		return villeTab;
	}
	
	/**
	 * Un algorithme d�approximation developp� par nos soins pour la r�solution de l'accessibilit� des �coles dans une agglom�ration donn� dans l'�nonc�.
	 * @param villeTab agglom�ration qu'on souhaite remlir.
	 * @return villeTab agglom�ration apr�s avoir subi l'algorithme.
	 */
	public static Town[] algorithmCustom(Town[] villeTab)
	{
		for (int i = 0; i < villeTab.length; ++i) // on retire toutes les �coles dans l'agglom�ration.
		{
			villeTab[i].setSchool(false);
		}
		for (int i = 0; i < villeTab.length; ++i) // on ajoute une �cole dans toutes les villes isol�s.
		{
			if (villeTab[i].getLink().size()==0)
			{
				villeTab[i].setSchool(true);
			}
		}
		for (int i = 0; i < villeTab.length; ++i) // on ajoute une �cole dans les voisins des toutes les villes qui n'ont que 1 voisin.
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
		 * On commence par la ville avec la plus grande liste d'adjacence, et on lui ajoute une �cole,
		 * on v�rifie ensuite les contraintes d'accessibilit�s.
		 * On continue avec le 2�me ville avec la plus grande liste d'adjacence, le 3�me...
		 * jusqu'� ce que l'agglom�ration respecte enfin les contraintes d'accessibilit�s
		 */
		do 
		{
			for (int i = villeTab.length-1; i >= 0; --i) // -1 car une ville peut �tre reli� � toutes les autres, mais pas � elle-m�me.
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
		for (int i = 0; i < villeTab.length; ++i) // dernier passage pour retirer les �coles superflues
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
	 * Permet de r�cup�rer un score d'une agglom�ration, le score �tant le nombre d'�cole pr�sente.
	 * @param villeTab agglom�ration qu'on souhaite �xaminer.
	 * @return score le score de l'agglom�ration �xamin�.
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
