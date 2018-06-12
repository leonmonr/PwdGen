
public class HelpPasswordGenerator {

	public void printHelp() {
		
		System.out.println("uso: java PwdGen [-opciones]");
		System.out.println("La lista de opciones para generar la contraseña puede incluir:");
		System.out.println("-? 				Muestra esta ayuda");
		System.out.println("-Size:[número] 			Incluir la longitud suministrada (e.j. -Size:16)");
		System.out.println("-U 				Incluir letras en mayúscula");
		System.out.println("-L 				Incluir letras en minúscula");
		System.out.println("-N 				Incluir números");
		System.out.println("-S 				Incluir símbolos (e.j. $%&()=# entre otros)");
		System.out.println("-A 				Excluir caracteres ambíguos (i, I, L, l, 1, o, O, 0)");
		System.out.println("-E:[caracter] 			Excluir símbolos suministrados (e.j. -E:$%&()=#)");
		System.out.println("-T:[nùmero] 			Incluir la cantidad de contraseñas suministrada (e.j. -T:5)");
		System.out.println("-C 				Incluir la posibilidad de la contraseña generada para solo hacer CTRL + V y utilizarla. Solo se copiará la última contraseña generada");
		System.out.println("Nota: Si se omiten las opciones, se generará una contraseña por defecto (incluye una longitud de 16 caracteres (letras mayúsculas, minúsculas y números), sin símbolos, sin exclusiones y sin la posibilidad de poderse copiar usando CTRL + V)");
	}

}
