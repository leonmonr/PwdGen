package circularprimenumbers;

public class BinarySearch {

	public int search(int[] numbers, String newnumber) {
		
		int number = Integer.parseInt(newnumber);
		int central;
		int bajo = 0;
		int alto = numbers.length-1;
		
		while (bajo <= alto) {
			
			central = (bajo + alto)/2; 
			if (number == numbers[central]) {
				return central;
			}
			if (number < numbers[central]) {
				alto = central -1;
			}
			else {
				bajo = central + 1;
			}
		}
		return -1;
	}
}
