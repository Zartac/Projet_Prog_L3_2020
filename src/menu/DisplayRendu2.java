package menu;

import java.util.ArrayList;

import agglomeration.Town;
import algorithm.Algorithm;
import savemanagement.Save;

public class DisplayRendu2 {
	
	/**
	 * Affichage des choix lors de la résolution de l'accessibilité des écoles.
	 */
	public static void displayInterface1()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|========= Résolution de l'accessibilité des écoles ==========|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Résoudre manuellement.                                    |");
		System.out.println("|2) Résoudre automatiquement.                                 |");
		System.out.println("|3) Sauvegarder.                                              |");
		System.out.println("|4) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage des choix lors de la résolution automatique de l'accessibilité des écoles.
	 */
	public static void displayInterface2()
	{
		System.out.println("");
		System.out.println("|=============================================================|");
		System.out.println("|================= Sélection de l'algorithme =================|");
		System.out.println("|=============================================================|");
		System.out.println("|1) Utiliser l'algorithme 1 (naïf).                           |");
		System.out.println("|2) Utiliser l'algorithme 2 (moins naïf).                     |");
		System.out.println("|3) Demander à Thanos.                                        |");
		System.out.println("|4) Fin.                                                      |");
		System.out.println("|=============================================================|");
	}
	
	/**
	 * Affichage du Easter Egg, aujourd'hui, c'est sur le thème Avengers!
	 * @param villeTab l'agglomeration qui subit l'algorithme
	 */
	public static void displayThanos(Town[] villeTab)
	{
		String thanos1[] = {
				"- The hardest choices",
				"- Require the strongest wills.",
				"- I am inevitable.",
				"- *SNAP*"
            };
        for (int i = 0; i < thanos1.length; ++i) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
            System.out.println(thanos1[i]);
        }
        System.out.println("");
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
    	System.out.println("<!>Toutes les écoles se sont volatilisées<!>");        
        ArrayList<Integer> tempSchool = new ArrayList<Integer>();
        for (int i = 0; i < villeTab.length; ++i)
        {
        	if (villeTab[i].getSchool()==true)
        	{
        		tempSchool.add(villeTab[i].getSerial());
        	}
        }
        System.out.println("");
		String thanos2[] = {
                "- Reality can be whatever I want.",
				"- What did it cost?",
				"- Everything."
            };
        for (int i = 0; i < thanos2.length; ++i) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
            System.out.println(thanos2[i]);
        }
        System.out.println("");
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
    	for (int i = 0; i < tempSchool.size(); ++i)
    	{
    		System.out.println(ToString.toStringSchoolAdded(villeTab[tempSchool.get(i)-1]));    		
    	}
    	System.out.println(ToString.toStringSchoolList(villeTab));
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
        System.out.println("");
		String thanos3[] = {
                "- You couldn't live with your own failure.",
				"- And where did that bring you?",
				"- Back to me."
            };
        for (int i = 0; i < thanos2.length; ++i) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
            System.out.println(thanos3[i]);
        }
    	
    	
	}
	/**
	 * Affichage Easter Egg NyanCat
	 */
	public static void nyan() 
	{
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::##############                              :::::::::::::::::::");
		System.out.println("############################  ##############################  :::::::::::::::::");
		System.out.println("#########################  ######???????????????????????######  :::::::::::::::");
		System.out.println("=========================  ####??????????()????()?????????####  :::::::::::::::");
		System.out.println("=========================  ##????()??????????????    ()?????##  ::::    :::::::");
		System.out.println("------------=============  ##??????????????????  ;;;;  ?????##  ::  ;;;;  :::::");
		System.out.println("-------------------------  ##??????????()??????  ;;;;;;?????##    ;;;;;;  :::::");
		System.out.println("-------------------------  ##??????????????????  ;;;;;;         ;;;;;;;;  :::::");
		System.out.println("++++++++++++-------------  ##??????????????????  ;;;;;;;;;;;;;;;;;;;;;;;  :::::");
		System.out.println("+++++++++++++++++++++++++  ##????????????()??  ;;;;;;;;;;;;;;;;;;;;;;;;;;;  :::");
		System.out.println("+++++++++++++++++    ;;;;  ##??()????????????  ;;;;;;@@  ;;;;;;;;@@  ;;;;;  :::");
		System.out.println("~~~~~~~~~~~~~++++;;;;;;;;  ##????????????????  ;;;;;;    ;;;  ;;;    ;;;;;  :::");
		System.out.println("~~~~~~~~~~~~~~~  ;;  ~~~~  ####??????()??????  ;;[];;;;;;;;;;;;;;;;;;;;;[]  :::");
		System.out.println("$$$$$$$$$$$$$~~~~  ~~~~~~  ######?????????????  ;;;;;;              ;;;;  :::::");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$    ###################  ;;;;;;;;;;;;;;;;;;;;  :::::::");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$  ;;;;                                       :::::::::::");
		System.out.println(":::::::::::::$$$$$$$$$$  ;;;;  ::  ;;  ::::::::::::  ;;  ::  ;;;;  ::::::::::::");
		System.out.println(":::::::::::::::::::::::      ::::::    :::::::::::::     ::::      ::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::::NN::YY::::YY:::AAAAAA:::NN::::NN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NNNN::NN::YY::::YY::AA::::AA::NNNN::NN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NNNN::NN::YY::::YY::AA::::AA::NNNN::NN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::NNNN::::YYYY::::AAAAAAAA::NN::NNNN:::!!::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::NNNN:::::YY:::::AA::::AA::NN::NNNN:::::::::::::::::::::::::");
		System.out.println("::::::::::::::::NN::::NN:::::YY:::::AA::::AA::NN::::NN:::!!::::::::::::::::::::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");	
	}
	
	/**
	 * Affichage Easter Egg Thanos
	 */
	public static void afficheThanos() {
		System.out.println(
				  "``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````````````````````,;i++++*i:``````````````````````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````````````````,*zMWWWWWWWMWWWn+:``````````````````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````````````````inWWWWWWWMMMWMWWWWWWx*.```````````````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````````````ixWWWWMz+i;:,:,:i*#xWWWWM+.`````````````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````````````:xWWWMzi::,:,,,,,,,,,,;#xWWWM*````````````````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````````````+WWWM#::,,,:,:,,,,,,:,,,:,*xWWWn,``````````````````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````````````````,nWWW#::,:,::,::,,,:,,,,,,:,,:*MWWM;`````````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````````:MWWxi:,:::,,::::,:,::,:,,,,,:,,:zWWW*````````````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````````;MWW#::::::,,,:,:::,::,::,,,,,::::;*WWW+```````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````;WWW*,,:,::::,::,:::,,:,:,,:::,,,::::;MWW+``````````````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````````````:MWW*,:,:,,::,,::,:,:,,,,:,,,::,:::::;,:MWWi`````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````.xWW*.,::,,:::,,:,,:,,,,:,:,,,::,:,,,:::,:MWM:````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````+WW+`,:,::::,:,,:,,,:,,,:,:,,:.:,:,,,::::.:WWn````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````MWx`.,,:::,,,:,::,,,,,,,::,:,:.,,,::,::::,`#WM:```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````,WW*`:,,,,,:,,:,:,,:::,,,:::,:,,,,:,:,:::,:`,WW*```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````iWW:.:,,,,:,:::::,,,,,,,,:,::,,,,,:,,::,:::.`MW#```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````*WW,.:,,,,,;nnnz+i:,,,,,,:,:,,;*#znn*::::::.`xWn```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````+WW:.:,,,,,;WWWWWWWxz+i;ii+zxMWWWWWW#;;::::..MWx```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````#WWx,,,,,:::xxxMWWWWWWWWWWWWWWWWMxxM*;;:,::,zWWM```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````zWWW#::,:::,,:::;*#nMWWWWWWWx#+i:,,:::::;::iWWWW```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````nWMWM::::,;,::,:,:,,::i++*;::,,,,,::::;::::nWWWW```````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````xWWWW;,:::;#nnz#*i:,:,,:,,,::::*#zzzz*,::::MWWWW,``````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````MWWWWi,,::iWWWWWWWMn#*i;;;i#nMWWWWWWW#::::;WWMWW,``````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````WWMWWi,,::;MMMMWWWWWMWWWWWWWWWWWWMxMWi:::::WWxWW:``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````.WWxWWi:,,:,;,:,:i+zxMMWWWWWWMn#*;:,:::;::,:WWnWW;``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````,WWnWWi::,:,,,::,,:,,:i*+#*i::,,:,::,,:::,::WWzWWi``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````,WWzWWi,:,:,:,,:,,:,:,,.,,,:,,,,,,,:::::::,:WW#WW*``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````:WW#WWi,,:::,,,,,,,:::,,,,:,,,:,::,::::,,:,,WW+MM+``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````;WW+WWi,,,,:,,,,,,,:,:,:,,:,,,:,:,,::::,,:::WW+MW#``````````````````````````````````````````````````\r\n"
				+ "````` ````````````````````````````````````````````iWW*WWi:,,,:,:::,,,::,,:,,,::,,:,,,:::::::::WW+xWz``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````*WWiWWi,,,,,:,::,,,,::,:,:::,:,:,,,::,::,:::WW*nWn``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````+WMiWWi:,,,,,,,:,,,::,,:,,:,:,::::.,:,,,,,,:WW*zWx``````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````;+*.#WM:#z:,,,,::::::::,,,*+*:+*i,,,::,:::;:,:,:zz;#WM`i+i``````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````#WWWxxWx`.,,:,;zMWWM#i::,,:xWn;WW#,,,,;*zMWWM#;:,,.`+WMnWMWz`````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````.WWWWWWWn`.,::*MWWWWWWWMz*:,xWn:WW+,;+nWWWWWWWWx;,..`*WWWWWWW:````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*zWWWz`.:;+WWMWWWWWWWWWWnWWz:MWxxWWWWWWWWWWWWM;,,`iWWWn;MW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WWi`nWW#`.,*WWWWWWWWWWWWWWWWW*:zWWWWWWWWWWWWWWWWx:,`;WWM.:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`,WW+`,:MWWWWMWWWWWWWzzMx*:::#xx#xWWWWWWWMWWWWn,`:WWi`:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WWi`.WW*`,,*M###*MWWWMMx::;:::::;::,iMxWWWWn*#+nx;,`,WWi`:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`,WWi`,,:;,:::*MWxi;;:;WW+,,;MM#:,i:+MWn:,:,::,,`.WW*`:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`:WW;`,,::,,:,::,,:,::iWW+,,:WW#:,,:,::,:,,,,,,,`.WW+`:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`;WWi`,:,::::::,::::::;WW+,::MW#;,,,:::::,,,,,:,`.MW#`:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`iWWn`,:::,::::::,,:,:;WW+::;WW#:,,:::,::,,,:::,`iWWz`:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`*WWW,:::::,:::::,,:,:+WW*::;WWn;:::::,:::,,:,:,`nWWn`:WW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`+WWW+:::::::::::,,:;xWWW*,,;WWWW*:::::::::,,:::,WWWx`:MW;````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````,WW*`#WWWx::;;::::::,::,iWWM*,,::ixWW#,::::::::,::::+WWWM`;WW;````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````MWx`zWWWW*::::;::,i:,:,iWWM+;:,:*xWW#:::;;:;:::::::xWWWM`#WW.````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````+WWinWMWW#:::::::iWz:::iWWWWMz+xWWWW#:::ixx;::::::;WWWWW;WWz`````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````.MWWMWnxWx:::::,;MWWi:::;#MWWWWWWWzi::;:zWWz:::::,+WWzWWMWW:`````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````iWWWWzzWM:,::::nWW#::::::;+xWWM#::,::::ixWW*::,,:#WW*WWMW+``````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````#WWW#+WW;::::#WWn::::::::::**:::,::::::iWWM;:::,nWx;WWWn```````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````.xWW+iWWi:::iWWM:::::,,:::::::::,,:::::;*WWx:::,xWx:WWM,```````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````;WW*iWW;,,;MWWi::,:::,:,:::::::,,,::::;,zWWz:::xWn,WW+````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````:WWiiWWi::xWW#:::,;::,::;:::,::,,,:::;;:;xWW*:,xWn.WW*````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````;WW;iWW;:+WWn;::;::i#zzz#;,::+znnz*;:;;;;iWWM:,xWn`WW+````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````iWW:iWWi:zWW;;::::nWWWWWWWnzMWWWWWWx;:;;;;#WWi,xWn`MWz````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````*WW,iWWi;zWW:;;;;xWWWMMWWWWWWWWMMWWWMi;::;#WWi:xWn`xWn````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````+WW.iWW;:zWW:;**xWWxi:::inMMx+:::;zWWW*i;;#WW;;xWn`nWn````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````#WW`iWW;:zWW;iWWWWx;:::::::,,,:::;:zWWWW+:#WW;:xWn`zWM````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````zWM`ixx;:#xM;;WWWx;;::::::,,:,:,::::#WWW+,*MM;:nxz`#WW````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````nWx``::::,,::,****xi:::,:,,,:::,:::zz**+;::::;,::.`+WW.```````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````xWn``:::::::,i::;MWM;::::,::::::::nWW+:;*;:::::::.`*WW.```````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````MWz``::::,,:;WM*;MWWWMMMMMMMMMWMMMWWW*ixW+:;:::,:.`iWW,```````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````MW#``:::::::zWW*:WWWWWWWWWWWWWWWWWWWWi;WWM:,:::::,`iWW:```````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````MWz`.::::::iWWWi:MWxnxWWznWWxzMWWnnWW*:MWW+,:::,,.`*WW,```````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````zWM`.:::::,zWWWi:MWz:zWW,iWW+:nWM;*WW*:MWWM;:::,,.`zWW````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````*WW:.:::::;WWWWi:MWz:zWW,iWW+:nWM:*WWi:MWWW+::::,.`MWn````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````,WW#`:::::#WWWWi;MWz;zWW,;WW+:nWM:*WWi:MWWWx:::,,.iWWi````````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````````nWM.,:::;MWWWWi;MWz,zMW,;WW+:nWM;*WM*:MWWWW+;:::`nWM.````````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````````;WW+,;::#WWxWWi;WWz,zWW,;WW+:nWM:*WM*:MWxMWx::,,:WW#`````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````xWM,;;;MWM+WWi:MW#:#WW,;WW+:nWM:*WWi:MWn#WWi::.zWW,`````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````iWW#,;*WW#+WW*:MW#:zWW:;WW#:nWx:*WWi:MWn;WW#::;WWz``````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````xWW::#WWi+WWi;MWz:zWW:;WW+:nWx:*WW*:MWz:MWn,,xWM,``````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````;WWx:zWM:+WW;:WWz;#WW:iWW+:nWx:*WW*:MWz:nWM:+WW+```````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````#WW#zWM:+WW;:MW#:zWW:iWW+;nWM:*WW*:MWz:zWMiWWx````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````.MWWxWW;+WWi:MWz:zWW,iWW+:nWM:*WWi:MWn:xWMMWW:````````````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````````````:WWWWW*+WWi,MWz,zWW,;WW+:nWx:*WW*:MWn:MWWWW*`````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````iWWWWz+WWi,MWz,#WW:iWW+:nWx:iWWi:MWn*WWWW#``````````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````````+WWWW#WWi:MWz,#WW:iWW+:nWM:iWW*:MWznWWWn```````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````````#WWWWWWi:MWz:zWW:iWW+:nWx,*WWi:MWMWWWn.```````````````````````````````````````````````````````\r\n"
				+ "`````````````````````````````````````````````````````````+WWWWWi:MWz:zWW:;WW+:nWM,*WWi,MWWWWn.````````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````````*WWWW*:WWz,zWW:;WW+,nWM:iWWi:MWWWz.`````````````````````````````````````````````````````````\r\n"
				+ "```````````````````````````````````````````````````````````;MWWWzWWz:zWW:iWW+:nWM:*WWzMWWW*```````````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````````````,nWWWWWWMWWWMMWWMMWWWMMWWWWWx:````````````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````````````;nWWWWWWWWWWWWWWWWWWWWWWM*``````````````````````````````````````````````````````````````\r\n"
				+ "````````````````````````````````````````````````````````````````,i+#################*:````````````````````````````````````````````````````````````````\r\n"
				+ "``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````\r\n"
				+ "");
	}
	
	
	
	
	
	/**
	 * Affichage de l'invite de commandes utilisateurs pour le menu principale .
	 * @param villeTab tableau de ville précedemment créé
	 */
	public static void displayTopMenu(Town[] villeTab) {
		if (villeTab.length!=0)
		{
			int choice4;
			String commandPrompt3 = "==>Veuillez entrer votre choix :";
			do {
				displayInterface1();
				choice4 = Display.protectedIntInput(commandPrompt3);
				if (choice4 == 1) // l'utilisateur choisi résoudre manuellement
				{
					Display.displaySchool(villeTab);
					displayScore(villeTab);
				}
				else if (choice4 == 2) // l'utilisateur choisi résoudre automatiquement
				{
					displayAutoMenu(villeTab);
				}
				else if (choice4 == 3) // l'utilisateur choisi de sauvegarder
				{
					ArrayList<String> save = Save.createStringSave(villeTab);
					Save.createSave(save);
				}
				else if (choice4 == 4)
				{
					break;
				}
				else // l'utilisateur saisie un choix qui n'existe pas
				{
					System.out.println("<!>Vous n'avez pas entré un choix valide<!>");
				}
			} while (choice4 != 4);
		}
	}
	
	/**
	 * Affichage de la selection des algorithmes.
	 * @param villeTab tableau de ville précedemment créé
	 */
	public static void displayAutoMenu(Town[] villeTab) {
		int choice5;
		String commandPrompt3 = "==>Veuillez entrer votre choix :";
		do {
			displayInterface2();
			choice5 = Display.protectedIntInput(commandPrompt3);
			System.out.println("");
			if (choice5 == 1) // l'utilisateur choisi algorithme 1
			{
				System.out.println("~~>Execution de l'algorithme 1 :");
				Algorithm.algorithm1(villeTab, villeTab.length);
				
			}
			else if (choice5 == 2) // l'utilisateur choisi algorithme 2
			{
				System.out.println("~~>Execution de l'algorithme 2 :");
				Algorithm.algorithm2(villeTab, villeTab.length);
			}
			else if (choice5 == 3) // l'utilisateur choisi Thanos
			{
				System.out.println("~~>Intervention de Thanos :");
				afficheThanos();
				Algorithm.algorithmCustom(villeTab);
				displayThanos(villeTab);
				displayConstraint(villeTab);
				displayScore(villeTab);
			}
			else if (choice5 == 4)
			{
				break;
			}
			else // l'utilisateur tape un choix qui n'existe pas
			{
				System.out.println("<!>Vous n'avez pas entré un choix valide<!>");
			}
		} while (choice5 != 4);
	}
	
	/**
	 * Affichage du score de l'agglomeration.
	 * @param villeTab agglomeration dont on veut le score.
	 */	
	public static void displayScore(Town[] villeTab)
	{
		System.out.println("");
		System.out.println("~~>Score de l'agglomération :");
		System.out.println(ToStringRendu2.toStringScore(villeTab));
	}
	
	/**
	 * Affichage du respect des contraintes d'accessibilité de l'agglomeration.
	 * @param villeTab agglomeration dont on veut le score.
	 */	
	public static void displayConstraint(Town[] villeTab)
	{
		System.out.println("");
		System.out.println("~~>Vérification des contraintes d'accessibilité :");
		if (Town.checkConstraintAccess(villeTab)==false)
		{
			System.out.println("<!>L'agglomération ne respecte pas les contraintes d'accessibilité<!>");
		}
		else if (Town.checkConstraintAccess(villeTab)==true)
		{
			System.out.println("*L'agglomération respecte les contraintes d'accessibilité*");
		}
	}

}