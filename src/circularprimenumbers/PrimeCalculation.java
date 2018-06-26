package circularprimenumbers;

public class PrimeCalculation {
	
	public void calculatePrime(int max_number) {
		int number = 1000000;
		int[] numbers = new int[78498];
		int inumber = 0;
		boolean[] array_prime = new boolean[1000000];
		
		for(long i = 2; i < number; i++) {
			if(!array_prime[(int) i]) {
				for(long j = i * i; j < number; j = j + i) {
					array_prime[(int) j] = true;
				}
				numbers[inumber] = (int) i;
				inumber++;
			}
		}
		circularPrime(numbers);
}
	
	public void circularPrime(int[] numbers) {
		for(int i = 0; i < 5; i++) {
			System.out.println(numbers[i]);
		}
		BinarySearch bSearch = new BinarySearch();
		StringBuilder newnumber = new StringBuilder();
		String number_rot;
		int k;
		char aux;
		int result = -1;
		int count = 5;
		for(int i = 5; i < numbers.length; i++) {
			k = 0;
			number_rot = String.valueOf(numbers[i]);
			while(k < number_rot.length()-1) {
				aux = number_rot.charAt(0);
				for(int j = 0; j < number_rot.length()-1; j++) {
					newnumber.append(number_rot.charAt(j+1));
				}
				newnumber.append(aux);
				result = bSearch.search(numbers, newnumber.toString());
				if(result == -1) {
					k+= number_rot.length();
				} 
				number_rot = newnumber.toString();
				newnumber.delete(0, newnumber.length());
				k++;
			}
			if(result > 0) {
				System.out.println(numbers[i]);
				count++;
			}
		}
		System.out.println("Cantidad de números primos circulares encontrados: " + count);
	}
}
