
public class HelpPasswordGenerator {

	public void printHelp() {
		
		System.out.println("uso: java PwdGen [-opciones]");
		System.out.println("La lista de opciones para generar la contrase�a puede incluir:");
		System.out.println("-? 				Muestra esta ayuda");
		System.out.println("-Size:[n�mero] 			Incluir la longitud suministrada (e.j. -Size:16)");
		System.out.println("-U 				Incluir letras en may�scula");
		System.out.println("-L 				Incluir letras en min�scula");
		System.out.println("-N 				Incluir n�meros");
		System.out.println("-S 				Incluir s�mbolos (e.j. $%&()=# entre otros)");
		System.out.println("-A 				Excluir caracteres amb�guos (i, I, L, l, 1, o, O, 0)");
		System.out.println("-E:[caracter] 			Excluir s�mbolos suministrados (e.j. -E:$%&()=#)");
		System.out.println("-T:[n�mero] 			Incluir la cantidad de contrase�as suministrada (e.j. -T:5)");
		System.out.println("-C 				Incluir la posibilidad de la contrase�a generada para solo hacer CTRL + V y utilizarla. Solo se copiar� la �ltima contrase�a generada");
		System.out.println("Nota: Si se omiten las opciones, se generar� una contrase�a por defecto (incluye una longitud de 16 caracteres (letras may�sculas, min�sculas y n�meros), sin s�mbolos, sin exclusiones y sin la posibilidad de poderse copiar usando CTRL + V)");
	}

}
