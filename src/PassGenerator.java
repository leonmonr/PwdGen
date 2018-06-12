
public class PassGenerator {
	
/**
 * Este método privado se encarga de excluir los caracretes de la contraseña a generar, siempre que lo haya indicado
 * así el usuario.
*/

	private String excludeCharacter(String exclude, String pass) {
		
		String wordseparate = exclude;
		String newpass = pass;
		String numbers = "0123456789";
		String letters_upper = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		String letters_lower = "abcdefghijklmnñopqrstuvwxyz";
		String symbols = "!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~";
		String new_number = numbers;
		String new_letterU = letters_upper;
		String new_letterL = letters_lower;
		String new_symbols = symbols;
		char word_find;

		//Busca cada caracter a excluir y lo reemplaza por un espacio en blanco en una nueva variable
		for(int i = 0; i < wordseparate.length() ; i++) {
			word_find = wordseparate.charAt(i);
			
			if(numbers.indexOf(Character.toString(word_find)) != -1 ) {
				new_number = new_number.replace(word_find, ' ');
			}
			if(letters_upper.indexOf(Character.toString(word_find)) != -1 ) {
				new_letterU = new_letterU.replace(word_find, ' ');
			}
			if(letters_lower.indexOf(Character.toString(word_find)) != -1 ) {
				new_letterL = new_letterL.replace(word_find, ' ');
			}
			if(symbols.indexOf(Character.toString(word_find)) != -1 ) {
				new_symbols = new_symbols.replace(word_find, ' ');
			}
		}
		
		//Elimina espacios en blanco
		new_number = new_number.replaceAll(" ", "");
		new_letterU = new_letterU.replaceAll(" ", "");
		new_letterL = new_letterL.replaceAll(" ","");
		new_symbols = new_symbols.replaceAll(" ", "");
		
		int new_valueN = (int) (Math.random()*new_number.length());
		int new_valueU = (int) (Math.random()*new_letterU.length());
		int new_valueL = (int) (Math.random()*new_letterL.length());
		int new_valueS = (int) (Math.random()*new_symbols.length());
		
		for(int i = 0; i < wordseparate.length() ; i++) {
			word_find = wordseparate.charAt(i);
			if(newpass.indexOf(Character.toString(word_find)) != -1 ) {
				if(numbers.indexOf(Character.toString(word_find)) != -1 ) {
					newpass = newpass.replace(word_find, new_number.charAt(new_valueN));
				}
				if(letters_upper.indexOf(Character.toString(word_find)) != -1 ) {
					newpass = newpass.replace(word_find, new_letterU.charAt(new_valueU));
				}
				if(letters_lower.indexOf(Character.toString(word_find)) != -1 ) {
					newpass = newpass.replace(word_find, new_letterL.charAt(new_valueL));
				}
				if(symbols.indexOf(Character.toString(word_find)) != -1 ) {
					newpass = newpass.replace(word_find, new_symbols.charAt(new_valueS));
				}
			}
		}
		
		return newpass;
		
	}

/**
 * Este método privado se encarga de calcular el valor entero de una variable tipo cadena de caracteres.
*/
	private int calculateInteger(String valueOnString) {
		String [] wordseparate = valueOnString.split(":");
		return Integer.parseInt(wordseparate[1]);
	}

/**
 * Este método privado se encarga de obtener hasta una contraseña a la vez de acuerdo a los argumentos expresados 
 * por el usuario (excepto la copia de la última contraseña generada si fuera el caso).
*/
	private String getPass(String array, int size, String ambiguous, String exclude) {
		
		StringBuilder pass = new StringBuilder();
		
		String generatedpassword = "";
		int num = array.length()-1;
		while (size > 0) {
			switch(array.charAt(num)) {
				case ('U'):
					pass.append(getChar(27, 10));
					num--;
					break;

				case ('L'):
					pass.append(getChar(27, 10).toLowerCase());
					num--;
					break;
				
				case ('N'):
					pass.append(getChar(10, 0));
					num--;
					break;
				
				case ('S'):
					pass.append(getChar(32, 37));
					num--;
					break;
			}
			if(num < 0) {
				num = array.length()-1;
			}
			size--;
		}
		
		generatedpassword = pass.toString();
		
		if(ambiguous != "") {
			generatedpassword = excludeCharacter(ambiguous, generatedpassword);
		}
		
		if(exclude != "") {
			generatedpassword = excludeCharacter(exclude, generatedpassword) ;
		}
		return generatedpassword;
	}

/**
 * Este método privado se encarga de obtener un caracter de manera aleatoria según el número de posición inicial
 * y el número de posición final en la cadena.
*/

	private String getChar(int intial_number, int final_number) {
		String ascii = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZ!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		char letter;
				
		letter = (char) (Math.random()*intial_number + final_number);
		return Character.toString(ascii.charAt(letter));
	}
	
	/**
	 * Este método se encarga de recibir los argumentos de método principal main y de acuerdo a su contenido, generar 
	 * la respectiva contraseña o en su defecto, mostrar el mensaje de error o ayuda al usuario.
	*/	
		
		public String returnPassword(String [] args) {
			
			StringBuilder characterArray = new StringBuilder();
			int copyPassword = 0;
			int size = 16;
			int numberPasswords = 1;
			String ambiguousCharacteres = "";
			String [] excludeCharacteres = {"", ""};
			//String characterArray = "";
			String password = "";
			
			//Recorre la lista de argumentos para determinar que opciones solicita el usuario
			for (int i = 0; i < args.length ; i++) {
				if(args[i].indexOf("-Size") != -1) {
					size = calculateInteger(args[i]);
					args[i] = "NE";
				}
				if(args[i].indexOf("-T") != -1) {
					numberPasswords = calculateInteger(args[i]);
					args[i] = "NE";
				}
				if(args[i].indexOf("-E") != -1) {
					excludeCharacteres = args[i].split(":");
					args[i] = "NE";
				}
				switch(args[i]) {
				
				case "-U":
					characterArray.append("U");
					break;
					
				case "-L":
					characterArray.append("L");
					break;
				
				case "-N":
					characterArray.append("N");
					break;
					
				case "-S":
					characterArray.append("S");
					break;
					
				case "-A":
					ambiguousCharacteres = "iILl1oO0";
					break;
					
				case "-C":
					copyPassword = 1;
					break;
				
				case "-?":
					HelpPasswordGenerator h = new HelpPasswordGenerator();
					h.printHelp();
					numberPasswords = 0;
					break;
					
				case "NE":
					break;
					
				default:
					System.out.println("dir /?");
					numberPasswords = 0;
					i = args.length;
					break;
				}
				
			}
			//Si el usuario no ingresa argumentos
			if(characterArray.length() == 0) {
				characterArray.append("ULN");
			}
			
			//Se genera la cantidad de contraseñas de acuerdo a lo indicado por el usuario
			for (int i = 0; i < numberPasswords ; i++) {
				password = getPass(characterArray.toString(), size, ambiguousCharacteres, excludeCharacteres[1]);
				System.out.println(password);
			}
			
			//Si el usuario solicita copiar la última contraseña generada
			while(copyPassword > 0) {
				ClipBoard cb = new ClipBoard();
				cb.copy(password);
				copyPassword--;
			}
			return password;
		}
}
