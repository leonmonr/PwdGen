package circularprimenumbers;

public class NumberPrimeSpecial {

	public static void main(String[] args) {
		long initial_time = System.nanoTime();
		PrimeCalculation pCalculation = new PrimeCalculation();
		pCalculation.calculatePrime(1000000);
		long final_time = System.nanoTime();
		System.out.println("Tiempo de ejecución (en nanosegundos): " + (final_time - initial_time));
		System.out.println("Tiempo de ejecución (en segundos): " + (final_time - initial_time)/1000000000f);

	}
}
