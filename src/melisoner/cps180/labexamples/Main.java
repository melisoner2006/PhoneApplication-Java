/*
 * @auth: Melis Oner
 * @date: 10-14-2014
 */


package melisoner.cps180.labexamples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		displayPhoneScreen();
		Scanner keyboard = new Scanner(System.in);
		String userInput = keyboard.next();
		if(userInput.length() == 1){
			speedDial(userInput);
		}
		else{
			call(userInput);
		}

	}

	private static void speedDial(String userInput) throws FileNotFoundException {
		switch(Integer.parseInt(userInput)){
		case 1:
			callMom();
			break;
		case 2:
			callDad();
			break;
		case 3: 
			callNana();
			break;
		default:
			call("911");
		}
		
		
	}

	//Takes phone number as the parameter. Returns tha contact name
	private static String findRecipient(String userInput) throws FileNotFoundException {
		
		File file = new File("phone_book.txt");
		Scanner fileScanner = new Scanner(file);
		String recipient = userInput;
		
		while(fileScanner.hasNext()){
			String name = fileScanner.next();
			String phoneNumber = fileScanner.next();
			if(phoneNumber.equals(userInput)){
				recipient =  name;
			}
		}
		return recipient;
		
	}
	
	//Takes the phone number as a parameter. No return type
	private static void call(String userInput) throws FileNotFoundException{
		String name = findRecipient(userInput);	
		
		for(int i = 1; i<=300000000;i++){
			if(i%100000000 == 0){
				System.out.print(".");
			}
		}
		
		System.out.println("\nCalling "+ name);
	}

	//No parameters, no return type
	private static void callMom() throws FileNotFoundException {
		call("9891001256");
	}
	
	//No parameters, no return type
	private static void callDad() throws FileNotFoundException {
		call("9894562313");
		
	}

	//No parameters, no return type
	private static void callNana() throws FileNotFoundException {
		call("9897095648");
		
	}
	
	//No parameters, no return type
	private static void displayPhoneScreen() {
		System.out.println(" 1 | 2 | 3 ");
		System.out.println(" 4 | 5 | 6 ");
		System.out.println(" 7 | 8 | 9 ");
		System.out.println(" * | 0 | # ");
		
	}

}
