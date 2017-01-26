package ProducaoAcademica;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		short n = -1;
		String c;
		
		do{
		
			System.out.println("\n--------- RoboVision 2001 ---------");
			System.out.println("\nPlease, insert the number of your action:");
			System.out.println("1 - Edit a research project");
			System.out.println("2 - Include an information");
			System.out.println("3 - Consult");
			System.out.println("4 - Report");
			
			n = input.nextShort();
			System.out.println();
			
			switch(n){
				
				case 0:
					System.out.println("Thank's for been using our services!");
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				default:
					
					System.out.println("Invalid command! please try again");
					
					System.out.println("Press any button to continue");
					c = input.next();
					
					break;
			}
			
		} while(n != 0);
		
		input.close();

	}

}
