package menu;

import agglomeration.Town;
import algorithm.Algorithm;

public class ToStringRendu2 {
	/**
	 * Affichage du score d'une agglomération.
	 * @param villeTab tableau de ville qu'on veut examiner
	 * @return b sous format "* 0 *".
	 */
	public static String toStringScore(Town[] villeTab)
	{
		if (villeTab == null)
			return "null";
		String b;
		b = "*" + Algorithm.getScore(villeTab)+ "*";
		return b.toString();
	}

}
