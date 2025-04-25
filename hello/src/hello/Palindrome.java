package hello;

public class Palindrome {
	public static void main(String[] args) {
		String a = "pappa" ;
		
		String b = new StringBuilder(a).reverse().toString();
		
		if ( a.equals(b))
			System.out.println(a + " is a palindrome ");
		
		else 
			System.out.println(a + " is not a palindrome");
	}

}
