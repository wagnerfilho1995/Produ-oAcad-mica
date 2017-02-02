package ProducaoAcademica;

import java.util.Scanner;

public class main {
/*
	public static int search(Developers[] dev){
		int i = 0;
		while(dev[i].allocated != 0){
			i++;
		}
		return i;
	}
	
	public static int searchIndexProject(Project[] proj, String s){
		
		int i = 0; 
		while(proj[i].status > 0){
			if(s.equals(proj[i].headline)){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void projectsPrint(Project[] proj){
		int i = 0;
		while(proj[i].status > 0){
			System.out.println((i+1) + " - " + proj[i].headline);
			i++;
		}
	}
	
	public static void developersPrint(student[] stu, professor[] prof, research[] res){

		int i;
		
		System.out.println();
		
		System.out.println("--------- STUDENTS ---------");
		for(i = 0; stu[i].allocated != 0; i++){
			System.out.println((i+1) + " - " + stu[i].name + " - " + stu[i].College);
		}
		
		System.out.println();
		
		System.out.println("--------- PROFESSORS ---------");
		for(i = 0; prof[i].allocated != 0; i++){
			System.out.println((i+1) + " - " + prof[i].name + " - " + prof[i].Colleges);
		}
		
		System.out.println();
		
		System.out.println("--------- RESEARCHS ---------");
		for(i = 0; res[i].allocated != 0; i++){
			System.out.println((i+1) + " - " + res[i].name);
		}
		
		System.out.println();
		
	}
	
	public static void edit(student[] stu, professor[] prof, research[] res, Project[] proj){
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("--------- EDITING ---------" + "\n");
		
		short d;
		String s;
		int i;
		
		do{
			System.out.println("------------------------");
			
			System.out.println("1 - Allocate");
			System.out.println("2 - Project Status");
			System.out.println("\n0 - Exit");
			
			d = input.nextShort();
			
			switch(d){
				
				case 0:
				
					break;
				
				case 1:
					
					developersPrint(stu, prof, res);
					
					System.out.println("Witch one did you choose?");
					s = input.nextLine();
					
					break;
				
				case 2:
					
					projectsPrint(proj);
					
					System.out.println("Witch one did you choose?");
					s = input.nextLine();
					
					i = searchIndexProject(proj, s);
					if(i == -1){
						System.out.println("Project not find");
					}
					else{
						System.out.println("Actual stage:");
					}
					
					break;
					
				default:
		
					System.out.println("Invalid Command!");
					
					break;
			}
			
		} while(d != 0);
	}
	
	public static void createNewProject(Project[] proj, int p, int year){
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("------ NEW PROJECT ------" + "\n");
		
		System.out.println("Headline:");
		proj[p].headline = input.nextLine();
		
		proj[p].starDate = year;
		
		System.out.println("Funder Agency:");
		proj[p].funder = input.nextLine();
		
		System.out.println("Value:");
		proj[p].financedValue = input.nextDouble();
		
		System.out.println("Write down the goals of this project:");
		proj[p].goal = input.nextLine();
		
		proj[p].status = 1;
		
		System.out.println("Congratulations!");
		System.out.println("The Project " + proj[p].headline + " was add to our Lab!");
		
	}
	
	public static void add(student[] stu, professor[] prof, research[] res){
		
		Scanner input  = new Scanner(System.in);
		
		short r; // Respostas
		int i; // Indice para alocação
		String name, email, s; // Respostas em string
		
		System.out.println("------ NEW DEVELOPER ------" + "\n");
		
		System.out.println("Full Name:");
		name = input.nextLine();
		
		System.out.println("Email:");
		email = input.nextLine();
		
		System.out.println("Occupation:\n");
		System.out.println("1 - Student");
		System.out.println("2 - Professor");
		System.out.println("3 - Research");
		r = input.nextShort();
		
		switch(r){
		
			case 1: // ADD ESTUDANTE
				
				i = search(stu);
				
				stu[i].allocated = 1;
				
				stu[i].setName(name);
				stu[i].setEmail(email);
				
				s = input.nextLine();
				
				System.out.println("Educational institution:");
				s = input.nextLine();
				
				stu[i].setCollege(s);
				
				System.out.println("Degree:\n");
				System.out.println("1 - Graduate");
				System.out.println("2 - Master");
				System.out.println("3 - Doctor");
				r = input.nextShort();
				
				stu[i].type = r;
				
				System.out.println("Congratulations!");
				System.out.println("The Student " + stu[i].name + " was add to our Lab!");
				
				break;
				
			case 2: // ADD PROFESSOR
				
				i = search(prof);
				
				prof[i].allocated = 1;
				
				prof[i].setName(name);
				prof[i].setEmail(email);
				
				System.out.println("Educational(s) institution:");
				s = input.nextLine();
				
				prof[i].setColleges(s);
				
				System.out.println("Congratulations!");
				System.out.println("The Professor " + prof[i].name + " was add to our Lab!");
				
				break;
				
			case 3: // ADD PESQUISADOR
				
				i = search(res);
				
				res[i].allocated = 1;
				
				res[i].setName(name);
				res[i].setEmail(email);
				
				System.out.println("Insert the Research Area:");
				s = input.nextLine();
				
				res[i].setResearchArea(s);
				
				System.out.println("Congratulations!");
				System.out.println("The Research " + res[i].name + " was add to our Lab!");
				
				break;
				
			default:
				
				System.out.println("Invalid Command!");
				
				break;
		}

		input.close();

	}
*/
	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		short n = -1;
		
		short d; 
		
		String s;
		
		int max = 30;
		int i, j, k;
		
		Project [] proj = new Project[max];
		
		Developers[] dev = new Developers[max*10];
		
		for(i = 0; i < proj.length; i++){
			proj[i] = new Project();
		}
		
		for(i = 0; i < dev.length; i++){
			dev[i] = new Developers();
		}
		
		int c = 0; // Contador de Colaboradores
		int p = 0; // Contador de projetos
		int year = 2001; // Ano inicial
		
		// ALOCADOS
		
		dev[0].setName("Barney Stinson");;
		dev[0].setEmail("legendarystinson@gmail.com");;
		dev[0].setCollege("Legendary University");
		((student)dev[0]).setMatricula("11223344");
		((graduatingDegree)dev[0]).setNumberOfProjects(1);
		
		dev[1].name = "Oliver Queen";
		dev[1].setEmail("greenarrow@gmail.com");
		dev[1].setCollege("Star University");
		((student)dev[1]).setMatricula("55667788");
		((masterDegree)dev[1]).setMasterSubject("Archery");
		
		
		dev[2].setName("Walter Bishop");
		dev[2].setEmail("walterbishop@gmail.com");
		dev[2].setCollege("Harvard University");
		
		
		dev[3].setName("Spock");;
		dev[3].setEmail("spock_enterprise@gmail.com");
		
		
		proj[0].setHeadline("Dharma Iniciative");
		proj[0].starDate = 1970;
		proj[0].setFunder("Charlie Widmore");
		proj[0].financedValue = 10000000;
		proj[0].setGoal("Dominate the holy World");
		proj[0].setDescription("Explore the stranges properties of a strange Island");
		proj[0].status = 1; // Em elaboração
		
		do{
		
			System.out.println("\n--------- RoboVision 2001 ---------");
			System.out.println("\nPlease, insert the number of your action:");
			System.out.println("1 - Open a new Project");
			System.out.println("2 - Add a new Developer");
			System.out.println("3 - Edit a Research Project");
			System.out.println("4 - Include an information");
			System.out.println("5 - Consult");
			System.out.println("6 - Report");
			System.out.println("\n0 - Exit");
			
			n = input.nextShort();
			
			s = input.nextLine(); // Pega o '\n' do último scanner
			
			System.out.println();
			
			switch(n){
				
				case 0: // SAIR
					
					System.out.println("Do you really wanna exit?");
					System.out.println("1 - Yes");
					System.out.println("2 - No");
					d = input.nextShort();
					
					if(d == 1){
						System.out.println("Thank's for been using our services!");
					}
					else n = 9;
					
					break;
				
				case 1: // NOVO PROJETO
					
					//createNewProject(proj, p, year);
					p++;
					
					break;
				
				case 2: // ADICIONAR
				
					//add(stu, prof, res);
					i++;
					
					break;
				
				case 3: // EDITAR
					
					//edit(stu, prof, res, proj);
					
					break;
				
				case 4: // INFORMAÇÕES
					
					//projectsPrint(proj);
					
					System.out.println("Please report the name of the project:\n");
					s = input.nextLine();
					
					break;
				
				case 5:
				
					break;
				
				case 6:
				
					break;
				
				default:
					
					System.out.println("Invalid command! please try again\n");
					
					System.out.println("Press any button to continue");
					s = input.next();
					
					break;
			}
			
		} while(n != 0);
		
		input.close();

	}

}
