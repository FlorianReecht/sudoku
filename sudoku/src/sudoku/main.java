package sudoku;
/**
 * 
 * @author reflo
 *Dans ce fichier main seront testé 10 grilles 3 faciles 2 moyennes 2 difficiles et 2 trèsDifficiles et 1 a la difficulte maximum.
 *Pour chacunes des grilles j'afficherai le temps de résolution et le nombre de boucles réalisé par mon algorithme
 *Toutes les grilles se trouvent dans l'attribut static de la classe jeu ensembleSudoku.
 *Une fois tous les tests éffectués, un appel de la fonction de jeu sera effectué.
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
				System.out.println("le sudoku numero "+ cp +" est résolu en "+ nbCoups +" tours de boucle");
				System.out.println("l'algoritmhe a resolu le sudoku numero "+ cp +" en " + (fin-debut)+"ms");
				cp++;
			}
			
		}
		//appel de la classe jeu et de la méthode lancerPartie
		jeu j= new jeu();
		j.lancerPartie();
	
		


	}

}
