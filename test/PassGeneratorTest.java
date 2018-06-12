import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassGeneratorTest {
	
	String numbers = "0123456789";
	String letters_upper = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	String letters_lower = "abcdefghijklmnñopqrstuvwxyz";
	String symbols = "!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~";
	String ambiguos = "iILl1oO0";
	
	PassGenerator pg = new PassGenerator();

	@Before
	public void setUp() {
		
		pg = new PassGenerator();
	}
	
	@Test
	public void Without() {
		String[] args = {};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_U() {
		String[] args = {"-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_L() {
		String[] args = {"-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_N() {
		String[] args = {"-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_S() {
		String[] args = {"-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationUL() {
		String[] args = {"-U", "-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLU() {
		String[] args = {"-L", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationUN() {
		String[] args = {"-U", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNU() {
		String[] args = {"-N", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationUS() {
		String[] args = {"-U", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSU() {
		String[] args = {"-S", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLN() {
		String[] args = {"-L", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNL() {
		String[] args = {"-N", "-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLS() {
		String[] args = {"-L", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_lower.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSL() {
		String[] args = {"-S", "-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_lower.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSN() {
		String[] args = {"-S", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(numbers.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNS() {
		String[] args = {"-N", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(numbers.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationULN() {
		String[] args = {"-U", "-L", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLNU() {
		String[] args = {"-L", "-N", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNUL() {
		String[] args = {"-N", "-U", "-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNLU() {
		String[] args = {"-N", "-L", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLUN() {
		String[] args = {"-L", "-U", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationUNL() {
		String[] args = {"-U", "-N", "-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSLN() {
		String[] args = {"-S", "-L", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLNS() {
		String[] args = {"-L", "-N", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNSL() {
		String[] args = {"-N", "-S", "-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNLS() {
		String[] args = {"-N", "-L", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLSN() {
		String[] args = {"-L", "-S", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSNL() {
		String[] args = {"-S", "-N", "-L"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationUSN() {
		String[] args = {"-U", "-S", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSNU() {
		String[] args = {"-S", "-N", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNUS() {
		String[] args = {"-N", "-U", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNSU() {
		String[] args = {"-N", "-S", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSUN() {
		String[] args = {"-S", "-U", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationUNS() {
		String[] args = {"-U", "-N", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationNSLU() {
		String[] args = {"-N", "-S", "-L", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationSULN() {
		String[] args = {"-S", "-U", "-L", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationLNUS() {
		String[] args = {"-L", "-N", "-U", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_PermutationUNLS() {
		String[] args = {"-U", "-N", "-L", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size1() {
		String[] args = {"-Size:1"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 1);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size2() {
		String[] args = {"-Size:2"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 2);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size3() {
		String[] args = {"-Size:3"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 3);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size255() {
		String[] args = {"-Size:255"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 255);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size10_U() {
		String[] args = {"-Size:10", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 10);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_U_Size25() {
		String[] args = {"-U", "-Size:25"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 25);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_S_Size8() {
		String[] args = {"-U", "-Size:8"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 8);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_L_N_Size16() {
		String[] args = {"-L", "-N", "-Size:16"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size4_S_U() {
		String[] args = {"-Size:4", "-S", "-U"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 4);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_L_Size11_S_N() {
		String[] args = {"-L", "-Size:11", "-S", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_lower.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 11);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_N_U_Size19_L_S() {
		String[] args = {"-N", "-U", "-Size:19", "-S"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}   
		}
		
		Assert.assertEquals(password.length(), 19);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_A() {
		
		
		String[] args = {"-A"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 16);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_A_Size17() {
		String[] args = {"-A", "-Size:17"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 17);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size9_A() {
		String[] args = {"-Size:9", "-A"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(letters_upper.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 9);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_Size13_A_N() {
		String[] args = {"-Size:13", "-A", "-N"};
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(numbers.indexOf(password.charAt(i)) == -1) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 13);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_E_S_Size21_A_N() {
		String[] args = {"-E:()", "-S", "-Size:21", "-A", "-N"};
		String excludechar = "()";
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 ) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
			for(int j = 0; j < excludechar.length() ; j++) {
				if(password.charAt(i) == excludechar.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 21);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void With_L_E_S_Size33_A_N_U() {
		String[] args = {"-L", "-E:*+/-", "-S", "-Size:33", "-A", "-N", "-U"};
		String excludechar = "*+/-";
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && letters_upper.indexOf(password.charAt(i)) == -1 ) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
			for(int j = 0; j < excludechar.length() ; j++) {
				if(password.charAt(i) == excludechar.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 33);
		Assert.assertEquals(validate, true);
		
	}
	
	public void With_L_E_S_Size99_A_N_U_T5() {
		String[] args = {"-L", "-E:*+/-", "-S", "-Size:99", "-A", "-N", "-U", "-T:5"};
		String excludechar = "*+/-";
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && letters_upper.indexOf(password.charAt(i)) == -1 ) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
			for(int j = 0; j < excludechar.length() ; j++) {
				if(password.charAt(i) == excludechar.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 99);
		Assert.assertEquals(validate, true);
		
	}
	
	public void With_L_E_S_Size18_A_N_U_T1_C() {
		String[] args = {"-L", "-E:*+/-", "-S", "-Size:18", "-A", "-N", "-U", "-T:1", "-C"};
		String excludechar = "*+/-";
		boolean validate = true;
		String password = pg.returnPassword(args);
		
		for(int i = 0; i < password.length() ; i++) {
			if(symbols.indexOf(password.charAt(i)) == -1 && numbers.indexOf(password.charAt(i)) == -1 && letters_lower.indexOf(password.charAt(i)) == -1 && letters_upper.indexOf(password.charAt(i)) == -1 ) {
				validate = false;
			}
			for(int j = 0; j < ambiguos.length() ; j++) {
				if(password.charAt(i) == ambiguos.charAt(j)) {
					validate = false;
				}
			}
			for(int j = 0; j < excludechar.length() ; j++) {
				if(password.charAt(i) == excludechar.charAt(j)) {
					validate = false;
				}
			}
		}
		
		Assert.assertEquals(password.length(), 18);
		Assert.assertEquals(validate, true);
		
	}
	
	/*Casos de prueba de argumentos con errores */
	
	@Test
	public void no_sign() {
		String[] args = {"U"};
		boolean validate = false;
		String password = pg.returnPassword(args);
				
		if(password.indexOf("dir") == -1) {
			validate = true;
		}
		
		Assert.assertEquals(password.length(), 0);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void does_no_exist() {
		String[] args = {"-R"};
		boolean validate = false;
		String password = pg.returnPassword(args);
				
		if(password.indexOf("dir") == -1) {
			validate = true;
		}
		
		Assert.assertEquals(password.length(), 0);
		Assert.assertEquals(validate, true);
		
	}
	
	@Test
	public void with_help() {
		String[] args = {"-?"};
		boolean validate = false;
		String password = pg.returnPassword(args);
				
		if(password == "") {
			validate = true;
		}
		
		Assert.assertEquals(password.length(), 0);
		Assert.assertEquals(validate, true);
		
	}
}
