package hello;

import java.util.Scanner;

public class BankingSystem {
	private static final int choice = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Balance = 1000;
		int choice;
		
		while(true){
		
		
		System.out.println("\n ATM Menu");
	    System.out.println("1. check balance:");
	    System.out.println("2. withdraw:");
	    System.out.println("3. Deposit");
	    System.out.println("4. exit");
	    
	    System.out.println(" Enter your choice");
	    
	    
	    if(choice==1) {
	    	System.out.println("your Balance is "+ Balance);
	    }else if(choice == 2) {
	    	
	    	System.out.println("enter amount to withdraw:");
	    	int withdraw = sc.nextInt();
	   if(withdraw <= Balance) {
	    	Balance-= withdraw;
	    	System.out.println("withdrawal Successful");
	   }   else  {
		    System.out.println("insufficient balance");
		}
	    }else if(choice ==3) {
		 
		   System.out.println("Enter amount to deposit");
		   int deposit = sc.nextInt();
		   Balance+= deposit;
		   System.out.println("deposit successful");
	    }
		else if( choice == 4) {
			 System.out.println("thanks for using ATM");
	         break;
		 }else {
			 
			 System.out.println("invalid choice");
		 }
	    
	    	
		}	
		
	
	}
	



