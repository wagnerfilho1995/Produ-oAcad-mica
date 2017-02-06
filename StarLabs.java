package ProducaoAcademica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StarLabs {
	
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
	
	public static void informationsDev(Developers dev){
		
		System.out.println(" *---------------- DEVELOPER --------------");
		
		System.out.println(" | Name: " + dev.name);
		
		System.out.println(" | Email: " + dev.getEmail());
		
		if(dev instanceof graduatingDegree){
			System.out.println(" | Occupation: Graduating Student");
		}
		else if(dev instanceof masterDegree){
			System.out.println(" | Occupation: Master Student");
		}
		else if(dev instanceof doctorateDegree){
			System.out.println(" | Occupation: Doctorate Student");
		}
		else if(dev instanceof professor){
			System.out.println(" | Occupation: Professor");
			System.out.print(" | Orientations:");
			for(Developers d : ((professor) dev).getOrientations()){
				System.out.print(d.name + " ; ");
			}
			System.out.print("\n");
		}
		else if(dev instanceof research){
			System.out.println(" | Occupation: Research");
		}
		System.out.println(" | Projects: ");
		for(Project proj : dev.projects){
			System.out.println(" |    * " + proj.headline);
		}
		
		System.out.println(" | Publications: ");
		for(Publications pub : dev.publications){
			System.out.println(" |    * " + pub.headline);
		}
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
		
		System.out.println("--------- NEW PUBLISH ---------" + "\n");
		
		System.out.println("Insert a Title to your Publish:");
		pub.setHeadline(input.nextLine());
		
		System.out.println("Congress of the publication:");
		pub.setCongress(input.nextLine());
		
		System.out.println("Insert the year of the publishing:");
		pub.setDateOfPublishing(input.nextInt());
		
		String c = input.nextLine();
		
		System.out.println("Describe your publish:");
		pub.setDescriptions(input.nextLine());
		
		System.out.println("Please report the participants:");
		
		int n = 1;
		int id;
		
		do{
			
			System.out.println("Full Name:");
			c = input.nextLine();
			
			for(Developers d : dev){
				if(c.equals(d.name)){
					d.setPublications(pub);
				}
			}
			
			System.out.println("\n1 - Report anotherone");
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
			System.out.println("Please insert the ID of the project");
			id = input.nextInt();
			Project p = proj.get(id);
			if(p.status == 2){
				p.setPublication(pub);
			}
			else{
				System.out.println("Sorry, but this project is not in progress.");
			}
		}
		
		System.out.println("Publicated!");
		
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
				System.out.println(" * ID: " + dev.indexOf(d) + " - " + d + " - ( Graduating Student )");
			}
			else if(d instanceof masterDegree){
				System.out.println(" * ID: " + dev.indexOf(d) + " - " + d + " - ( Master Student )");
			}
			else if(d instanceof doctorateDegree){
				System.out.println(" * ID: " + dev.indexOf(d) + " - " + d + " - ( Doctorate Student )");
			}
			else if(d instanceof professor){
				System.out.println(" * ID: " + dev.indexOf(d) + " - " + d + " - ( Professor )");
			}
			else if(d instanceof research){
				System.out.println(" * ID: " + dev.indexOf(d) + " - " + d + " - ( Research )");
			}
		}
	}
	
	public static void printProjects(ArrayList <Project> proj){
		for(Project p : proj){
			System.out.print(" * ID: " + proj.indexOf(p) + " - " + p + " - ");
			if(p.status == 1){
				System.out.println("In preparing...");
			}
			else if(p.status == 2){
				System.out.println("... In progress ...");
			}
			else if(p.status == 3){
				System.out.println("... Accomplished!");
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
		
		Developers dev6 = new graduatingDegree();
		dev6.setName("Barry Allen");
		dev6.setEmail("fastermanalive@yahoo.com");
		((student)dev6).setCollege("Central University");
		
		dev.add(dev6);
		
		Developers dev7 = new graduatingDegree();
		dev7.setName("Amanda Félix");
		dev7.setEmail("amandafelix@gmail.com");
		((student)dev7).setCollege("Ufal");
		
		dev.add(dev7);
		
		Developers dev8 = new professor();
		dev8.setName("Harrison Wells");
		dev8.setEmail("harrisonwells@gmail.com");
		
		dev.add(dev8);
		
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
		
		Project proj2 = new Project();
		proj2.setHeadline("Meta Humans");
		proj2.starDate = 2000;
		proj2.setFunder("Harrison Wells");
		proj2.financedValue = 100000;
		proj2.setGoal("Learn all about Super Powers");
		proj2.setDescription("Study the efects caused by the explosion of the Acelerator");
		proj2.status = 1;
		
		proj.add(proj2);
		
	}
	
	public static void edit(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("--------- EDITING ---------" + "\n");
		
		short d;
		String s;
		int i;
		int id;
		Project proje;
		
		do{
			
			System.out.println("Choose an option:");
			
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
					System.out.println("\nPlease insert the ID of the Developer");
					id = input.nextInt();
					Developers deve = dev.get(id);
					if(deve instanceof graduatingDegree){
						if(((graduatingDegree) deve).getNumberOfProjects() >= 2){
							System.out.println("Sorry, but this student can't participate of more then two projects");
							break;
						}
					}
					System.out.println(dev.get(id) + " was choose!\n");
					System.out.println("------ Projects ------");
					printProjects(proj);
					System.out.println("\nPlease insert the ID of the Project");
					id = input.nextInt();
					
					System.out.println(proj.get(id) + " was choose!");
					proje = proj.get(id);
					if(proje.status != 1){
						System.out.println("Sorry, but this project already pass of this stage of allocation");
						break;
					}

					proje.setDevelopers(deve);
					deve.setProjects(proje);
		
					System.out.println("Well Done!");
					System.out.println(deve.name + " was allocated in " + proje.headline);
		
					break;
				
				case 2: // MUDAR STATUS
					
					System.out.println("------ Projects ------");
					printProjects(proj);
					System.out.println("\nPlease insert the ID of the Project");
					id = input.nextInt();
					
					proje = proj.get(id);
					
					System.out.println("Choose a new Status:");
					System.out.println("1 - In Preparing");
					System.out.println("2 - In Progress");
					System.out.println("3 - Conclude!");
					Short st = input.nextShort();
					
					if(st == 2){
						System.out.println("You'll can not allocate anyother member to this project");
						System.out.println("Are you sure?");
						System.out.println("1 - Yes");
						System.out.println("2 - No");
						short sure = input.nextShort();
						if(sure == 2){
							break;
						}
					}
					if(st == 3){
						System.out.println("Insert the End Date:");
						proje.setEndDate(input.nextInt());
					}
					
					proje.status = st;
					System.out.println("Done!");
				
					break;
					
				default:
		
					System.out.println("Invalid Command!");
					
					break;
			}
			
			if(d != 0){
				System.out.println("---------- * -----------");
			}
			
		} while(d != 0);
	
	}
	
	public static void orientation(ArrayList <Developers> dev){
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("------ All Professors ------");
		
		for(Developers d : dev){
			if(d instanceof professor){
				System.out.println(d.name);
			}
		}
		
		System.out.println("--------- * ----------\n");
		
		System.out.println("Please insert the name of the Professor:");
		String prof = input.nextLine();
		
		System.out.println("\n------ All Students ------");
		
		for(Developers d : dev){
			if(d instanceof student){
				System.out.println(d.name);
			}
		}
		
		System.out.println("--------- * ----------\n");
		
		
		System.out.println("Please insert the name of the Student:");
		String stu = input.nextLine();
		
		for(Developers d : dev){
			if(prof.equals(d.name)){
				if(d instanceof professor){
					for(Developers e : dev){
						if(stu.equals(e.name)){
							
							((professor) d).setOrientations(e);

							System.out.println("Well Done!");
							System.out.println("Now " + d.name + " is Guilding " + e.name + " !");

							break;
						}
					}
					break;
				}
			}
		}
	}
	
	public static void consult(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Scanner input  = new Scanner(System.in);

		String s;
		
		System.out.println("1 - Developers");
		System.out.println("2 - Projects");
		Short d = input.nextShort();
		s = input.nextLine();
		
		if(d == 1){
			if(dev.size() > 1){
				System.out.println("------ Developers ------");
				printDevelopers(dev);
				System.out.println("---------- * ----------");
				
				System.out.println("Choose one of them");
				s = input.nextLine();
				
				for(Developers de : dev){
					if(s.equals(de.name)){
						informationsDev(de);
					}
				}
			}
			else{
				System.out.println("There are no Developers in our Lab now :(");
			}
		}
		else if(d == 2){
			if(dev.size() > 1){
				printProjects(proj);
			}
			else{
				System.out.println("There are no Projects in our Lab now :(");
			}
		}
		
	
	}
	
	public static void report(ArrayList <Developers> dev, ArrayList <Project> proj, int ori, int publi){
		
		System.out.println("--------- REPORT ---------\n");
		
		int grad = 0, mast = 0, doct = 0, prof = 0, res = 0;
		
		for(Developers d : dev){
			if(d instanceof graduatingDegree){
				grad++;
			}
			else if(d instanceof masterDegree){
				mast++;
			}
			else if(d instanceof doctorateDegree){
				doct++;
			}
			else if(d instanceof professor){
				prof++;
			}
			else if(d instanceof research){
				res++;
			}
		}
		
		System.out.println(" --> Developers");
		
		System.out.println(" * Graduating Students: " + grad);
		System.out.println(" * Master Students: " + mast);
		System.out.println(" * Doctorate Students: " + doct);
		System.out.println(" * Professors: " + prof);
		System.out.println(" * Researchs: " + res);
		
		System.out.println("\n # Total of Developers: " + dev.size());
		
		System.out.println("--------- *  ---------");
		
		int preparing = 0, progress = 0, conclude = 0;
		
		for(Project p : proj){
		
			if(p.status == 1){
				preparing++;
			}
			else if(p.status == 2){
				progress++;
			}
			else if(p.status == 3){
				conclude++;
			}
			
		}
		
		System.out.println(" --> Projects");
		
		System.out.println(" * Projects in preparing: " + preparing);
		System.out.println(" * Projects in progress: " + progress);
		System.out.println(" * Projects completed: " + conclude);
		
		System.out.println("\n # Total of Projects: " + proj.size());
		
		System.out.println("--------- * ---------");
		
		System.out.println(" --> Academic Production");
		
		System.out.println(" * Orientations: " + ori);
		System.out.println(" * Publications:  " + publi);
		System.out.println("\nTotal of The Academic production:  " + (publi + ori));
		
		System.out.println("--------- *  ---------");
		
	}

	public static void main(String[] args) {

		Scanner input  = new Scanner(System.in);
		
		ArrayList <Developers> dev = new ArrayList <Developers>();
		
		ArrayList <Project> proj = new ArrayList <Project>();
		
		ArrayList <Publications> pub = new ArrayList <Publications>();
		
		int acao = 1; // Ações
		short d; // Decisões
		String s; // Captura de respostas em Strings
		
		int ori = 0, publi = 0; // Contadores de orientações e publicações
		
		int year = 2001; // Ano "atual"
		
		initialConfiguration(dev, proj);
		
		while(acao != 0){
			
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
			
			acao = input.nextInt();
			
			s = input.nextLine(); // Pega o '\n' do último scanner
			
			System.out.println();
			
			switch(acao){
				
				case 0: // SAIR
					
					System.out.println("Do you really wanna exit?");
					System.out.println("1 - Yes");
					System.out.println("2 - No");
					d = input.nextShort();
					
					if(d == 1){
						System.out.println("Thank's for been using our services!");
					}
					else acao = 9;
					
					break;
				
				case 1: // NOVO PROJETO
					
					proj.add(createProject(year, dev));
					System.out.println("Congratulations!! A new Developer was added to our Lab!\n");
					
					break;
				
				case 2: // ADICIONAR
				
					dev.add(createDeveloper());
					System.out.println("Congratulations!! A new Project was added to our Lab!\n");
					
					break;
				
				case 3: // EDITAR
					
					edit(dev, proj);
					
					break;
				
				case 4: // PUBLICAR
					
					pub.add(createPublish(dev, proj));
					publi++;
					
					break;
					
				case 5: // ORIENTAÇÃO
					
					orientation(dev);
					ori++;
					 
					break;
				
				case 6: // CONSULTAS
					
					consult(dev, proj);
					
					break;
				
				case 7:  // RELATÓRIO
		
					report(dev, proj, ori, publi);
					
					break;
				
				default:
					
					System.out.println("Invalid command! please try again\n");
					
					System.out.println("Press any button to continue");
					s = input.next();
					
					break;
			}
			
		}
		
		input.close();
	}
}
