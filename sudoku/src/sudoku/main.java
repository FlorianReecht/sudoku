package sudoku;
/**
 * 
 * @author reflo
 *Dans ce fichier main seront test� 10 grilles 3 faciles 2 moyennes 2 difficiles et 2 tr�sDifficiles et 1 a la difficulte maximum.
 *Pour chacunes des grilles j'afficherai le temps de r�solution et le nombre de boucles r�alis� par mon algorithme
 *Toutes les grilles se trouvent dans l'attribut static de la classe jeu ensembleSudoku.
 *Une fois tous les tests �ffectu�s, un appel de la fonction de jeu sera effectu�.
 */
public class main {
	public static void main(String[] args) 
	{
		
		int cp=1;
		for(int i=0;i<jeu.ensembleSudoku.length;i++)
		{
			for(int j=0;j<jeu.ensembleSudoku[i].length;j++)
			{
				System.out.println("grille Initiale sudoku numero "+ cp +" :\n");
				grille sudoku= new grille(jeu.ensembleSudoku[i][j]);
				System.out.println(sudoku);
				long debut=System.currentTimeMillis();
				int nbCoups=sudoku.resolutionSudokuV1();
				long fin=System.currentTimeMillis();
				System.out.println("grille Resolue sudoku numero "+ cp +" :\n");
				System.out.println(sudoku);
				System.out.println("le sudoku numero "+ cp +" est r�solu en "+ nbCoups +" tours de boucle");
				System.out.println("l'algoritmhe a resolu le sudoku numero "+ cp +" en " + (fin-debut)+"ms");
				cp++;
			}
			
		}
		//appel de la classe jeu et de la m�thode lancerPartie
		jeu j= new jeu();
		j.lancerPartie();
	
		


	}

}
