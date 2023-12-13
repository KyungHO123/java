package day04;

public class StarEx4 {

	public static void main(String[] args) {
		/*      *           i=1
		 *     ***          i=2
		 *    *****			i=3
		 *   *******		i=4
		 *  *********		i=5
		 * */
		
		int rows = 5;
		for(int i = 1;i <= rows; i++) {
			
			for(int j=1;j<=rows-i;j++) {
				System.out.print(' ');
			}
			
			for(int j= 1; j<=i*2-1;j++) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}
		/*      *           i=1
		 *     ** *         i=2
		 *    *** **		i=3
		 *   **** ***		i=4
		 *  ***** ****		i=5
		 *               ' '= 5-i        i           i-1
		 *            */ 
		
		
		
		
		
		
		
	}

}
