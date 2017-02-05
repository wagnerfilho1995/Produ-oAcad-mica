package ProducaoAcademica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class lab {
	
	public static Developers createStudentGraduate(String name, String email, String university){
		
		graduatingDegree genin = new graduatingDegree();
		
		genin.setName(name);
		genin.setEmail(email);
		genin.setCollege(university);
		
		return genin;
	}
	
	public static Developers createStudentMaster(String name, String email, String university){
		
		masterDegree chunin = new masterDegree();
		
		chunin.setName(name);
		chunin.setEmail(email);
		chunin.setCollege(university);
				
		return chunin;
	}
	
	public static Developers createStudentDoctorate(String name, String email, String university){
		
		doctorateDegree jounin = new doctorateDegree();
		
		jounin.setName(name);
		jounin.setEmail(email);
		jounin.setCollege(university);
		
		return jounin;
	}
	
	public static Developers createProfessor(String name, String email){
		
		professor sensei = new professor();
		
		sensei.setName(name);
		sensei.setEmail(email);
		
		return sensei;
	}
	
	public static Developers createResearch(String name, String email){
		
		research anbu = new research();
		
		anbu.setName(name);
		anbu.setEmail(email);
		
		return anbu;
	}
	
	public static Developers createDeveloper(){
		
		Scanner input  = new Scanner(System.in);
		
		short r; // Respostas
		
		System.out.println("--------- NEW DEVELOPER ---------" + "\n");
		
		System.out.println("Full Name:");
		String name = input.nextLine();
		
		System.out.println("Email:");
		String email = input.nextLine();
		
		System.out.println("Occupation:\n");
		System.out.println("1 - Student");
		System.out.println("2 - Professor");
		System.out.println("3 - Research");
		r = input.nextShort();
		
		String c = input.nextLine();
		
		switch(r){
		
			case 1: // ADD ESTUDANTE
				
				System.out.println("--------- NEW STUDENT ---------" + "\n");
				
				System.out.println("University:\n");
				String university = input.nextLine();
				
				System.out.println("Degree:\n");
				System.out.println("1 - Graduate");
				System.out.println("2 - Master");
				System.out.println("3 - Doctorate");
				r = input.nextShort();
				
				switch(r){
					case 1:
						return createStudentGraduate(name, email, university);
						
					case 2:
						return createStudentMaster(name, email, university);
						
					case 3:
						return createStudentDoctorate(name, email, university);
				}
				
			case 2: // ADD PROFESSOR
				
				return createProfessor(name, email);
				
			case 3: // ADD PESQUISADOR
				
				return createResearch(name, email);
				
			default:
				
				System.out.println("Invalid Command!");
				
		}

		input.close();
		return null;
	}
	
	public static Publications createPublish(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Scanner input  = new Scanner(System.in);
		
		Publications pub = new Publications();
		
		System.out.println("------ NEW PUBLISH ------" + "\n");
		
		System.out.println("Insert a Title to your Publish:" + "\n");
		pub.setHeadline(input.nextLine());
		
		System.out.println("Insert the year of the publishing:");
		pub.setDateOfPublishing(input.nextInt());
		
		String c = input.nextLine();
		
		System.out.println("Describe your publish:");
		pub.setDescriptions(input.nextLine());
		
		System.out.println("Please report the participants:");
		
		int n = 1;
		
		do{
			
			System.out.println("Full Name:");
			c = input.nextLine();
			
			for(Developers d : dev){
				if(c.equals(d.name)){
					d.setPublications(pub);
				}
			}
			
			System.out.println("1 - Report anotherone");
			System.out.println("2 - Done!");
			n = input.nextInt();
			c = input.nextLine();
		}while(n != 2);

		System.out.println("The Publish is related with some Project of our Lab?");
		System.out.println("1 - Yes");
		System.out.println("2 - No");
		n = input.nextInt();
		if(n == 1){
			printProjects(proj);
			System.out.println("Please insert the name of the project");
			c = input.nextLine();
			for(Projects p : proj){
				if(c.equals(p.name)){
					p.setPublications(pub);
				}
			}
		}
		
		System.out.println("Well Done!");
		
		input.close();
		
		return pub;
	}
	
	public static Project createProject(int year, ArrayList <Developers> dev){

		Scanner input  = new Scanner(System.in);
		
		Project proj = new Project();

		System.out.println("------ NEW PROJECT ------" + "\n");
		
		System.out.println("Headline:");
		proj.setHeadline(input.nextLine());
		
		proj.setStarDate(year);
		
		System.out.println("Funder Agency:");
		proj.setFunder(input.nextLine());
		
		System.out.println("Value:");
		proj.setFinancedValue(input.nextDouble());
		
		System.out.println("Write down the goals of this project:");
		proj.setGoal(input.nextLine());

		proj.status = 1;
		
		System.out.println("Please, insert an professor to this new project: ");
		for(Developers d : dev){
			if(d instanceof professor){
				System.out.println(d);
			}
		}
		System.out.println("1 - Insert one of this teachers");
		System.out.println("2 - Add a new professor to insert");
		Short d = input.nextShort();
		String s = input.nextLine();
		if(d == 1){
			System.out.println("Insert the name:");
			s = input.nextLine();
			for(Developers de : dev){
				if(s.equals(de)){
					proj.setDevelopers(de);
				}
			}
		}
		else if(d == 2){
			proj.setDevelopers(createDeveloper());
		}
		
		System.out.println("Congratulations!");
		
		System.out.println("The Project " + proj.headline + " was add to our Lab!");
		
		return proj;
	}
	
	public static void printDevelopers(ArrayList <Developers> dev){
		for(Developers d : dev){
			if(d instanceof graduatingDegree){
				System.out.println("Graduating Student: " + d);
			}
			else if(d instanceof masterDegree){
				System.out.println("Master Student: " + d);
			}
			else if(d instanceof doctorateDegree){
				System.out.println("Doctorate Student: " + d);
			}
			else if(d instanceof professor){
				System.out.println("Professor: " + d);
			}
			else if(d instanceof research){
				System.out.println("Research: " + d);
			}
		}
	}
	
	public static void printProjects(ArrayList <Project> proj){
		for(Project p : proj){
			System.out.print(p + " - ");
			if(p.status == 1){
				System.out.println("In preparing");
			}
			else if(p.status == 2){
				System.out.println("In progress");
			}
			else if(p.status == 3){
				System.out.println("Accomplished!");
			}
		}
	}
	
	public static void initialConfiguration(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Developers dev1 = new graduatingDegree();
		dev1.setName("Barney Stinson");
		dev1.setEmail("legendarystinson@gmail.com");
		((student)dev1).setCollege("Legendary University");
		
		dev.add(dev1);
		
		Developers dev2 = new masterDegree();
		dev2.setName("Oliver Queen");
		dev2.setEmail("greenarrow@gmail.com");
		((student)dev2).setCollege("Star University");
		
		dev.add(dev2);
		
		Developers dev3 = new professor();
		dev3.setName("Walter Bishop");
		dev3.setEmail("walterbishop@gmail.com");
		
		dev.add(dev3);
		
		Developers dev4 = new research();
		dev4.setName("Sr. Spock");
		dev4.setEmail("spock_enterprise@gmail.com");
		
		dev.add(dev4);
		
		Developers dev5 = new professor();
		dev5.setName("Daniel Faraday");
		dev5.setEmail("danielfaraday@gmail.com");
		
		dev.add(dev5);
		
		Project proj1 = new Project();
		proj1.setHeadline("Dharma Iniciative");
		proj1.starDate = 1970;
		proj1.setFunder("Charlie Widmore");
		proj1.financedValue = 10000000;
		proj1.setGoal("Dominate the holy World");
		proj1.setDescription("Explore the stranges properties of a strange Island");
		proj1.status = 1; // Em elaboração
		proj1.setDevelopers(dev5);
		
		proj.add(proj1);
		
	}
	
	public static void edit(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("--------- EDITING ---------" + "\n");
		
		short d;
		String s;
		String project;
		int i;
		
		do{
			System.out.println("------------------------");
			
			System.out.println("1 - Allocate");
			System.out.println("2 - Project Status");
			System.out.println("\n0 - Back to the Main Menu");
			
			d = input.nextShort();
			s = input.nextLine();
			
			switch(d){
				
				case 0: // VOLTAR
				
					break;
				
				case 1:  // ALOCAR
					
					System.out.println("------ Developers ------");
					printDevelopers(dev);
					System.out.println("\nPlease insert the name of the Developer");
					String name = input.nextLine();
					
					System.out.println(name + " was choose!\n");
					System.out.println("------ Projects ------");
					printProjects(proj);
					System.out.println("\nPlease insert the name of the Project");
					project = input.nextLine();
					
					System.out.println(project + " was choose!");
					
					for(Project p : proj){
						if(project.equals(p.headline)){
							for(Developers q : dev){
								if(name.equals(q.name)){
									p.setDevelopers(q);
									System.out.println("Well Done!");
									System.out.println(q.name + " was allocated in " + p.headline);
								}
							}
						}
					}
					
					break;
				
				case 2: // MUDAR STATUS
					
					System.out.println("------ Projects ------");
					printProjects(proj);
					System.out.println("\nPlease insert the name of the Project");
					
					project = input.nextLine();
					
					for(Project p : proj){
						if(project.equals(p.headline)){
	
							System.out.println(p.headline + " was choose!");
							System.out.println("New Status:");
							System.out.println("1 - In Preparing");
							System.out.println("1 - In Progress");
							System.out.println("3 - Conclude!");
							Short st = input.nextShort();
					
							p.status = st;
							System.out.println("Done!");
						}
					}
					
					break;
					
				default:
		
					System.out.println("Invalid Command!");
					
					break;
			}
			
		} while(d != 0);
	
	}
	
	public static void consult(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		int size = dev.size();
		
		if(size == 0){
			System.out.println("There are no Developers in our Lab now :(");
			return;
		}
		
		size = proj.size();
		
		if(size == 0){
			System.out.println("There are no Projects in our Lab now :(");
			return;
		}
		
		printDevelopers(dev);
	
	}
	
	public static void report(ArrayList <Project> proj){
		
		for(Project p : proj){
		
			System.out.print(p + " - ");
			if(p.status == 1){
				System.out.print(" In Preparation");
			}
			else if(p.status == 2){
				System.out.print(" In Progress");
			}
			else if(p.status == 3){
				System.out.print(" Accomplished");
			}
			
			System.out.println();
			
			for(Developers d: p.developers){
				System.out.print(d);
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		
		ArrayList <Developers> dev = new ArrayList <Developers>();
		
		ArrayList <Project> proj = new ArrayList <Project>();
		
		ArrayList <Publications> pub = new ArrayList <Publications>();
		
		short n; // Ações
		short d; // Decisões
		String s;
		
		int year = 2001; // Ano "atual"
		
		initialConfiguration(dev, proj);
		
		do{
			
			System.out.println("\n--------- RoboVision 2001 ---------");
			System.out.println("\nPlease, insert the number of your action:");
			System.out.println("1 - Open a new Project");
			System.out.println("2 - Add a new Developer");
			System.out.println("3 - Edit a Research Project");
			System.out.println("4 - Publish");
			System.out.println("5 - Orientation");
			System.out.println("6 - Consult");
			System.out.println("7 - Report");
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
					
					proj.add(createProject(year, dev));
					
					break;
				
				case 2: // ADICIONAR
				
					dev.add(createDeveloper());
					
					break;
				
				case 3: // EDITAR
					
					edit(dev, proj);
					
					break;
				
				case 4: // PUBLICAR
					
					pub.add(createPublish(dev, proj));
					
					break;
					
				case 5: // ORIENTAÇÃO
					
					break;
				
				case 6: // CONSULTAS
					
					consult(dev, proj);
					
					break;
				
				case 7:  // RELATÓRIO
		
					report(proj);
					
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
