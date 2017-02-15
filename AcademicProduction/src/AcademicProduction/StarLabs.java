package AcademicProduction;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
			System.out.print(" | Guiding: ");
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
		sortByDatesPub(dev.publications);
	}
	
	public static void informationsProj(Project proj){
		
		System.out.println(" *-------------- PROJECT -----------");
		
		System.out.println(" | Name: " + proj.headline);
		System.out.println(" | Start: " + proj.startDateDay + "/" + proj.startDateMonth + "/" + proj.startDateYear);
		if(proj.status == 1){
			System.out.println(" | Status: Starting...");
			System.out.println(" | End: " + " - ");
		}else if(proj.status == 2){
			System.out.println(" | Status: ...In Progress...");
			System.out.println(" | End: " + " - ");
		}else if(proj.status == 3){
			System.out.println(" | Status: ...Accomplished");
			System.out.println(" | Start: " + proj.endDateDay + "/" + proj.endDateMonth + "/" + proj.endDateYear);
		}
		
		System.out.println(" | Funder: " + proj.funder);
		System.out.println(" | Financed Value: " + proj.financedValue);
		System.out.println(" | Goal: " + proj.goal);
		System.out.println(" | Description: " + proj.description);
		
		System.out.println(" | Developers: ");
		ArrayList<Developers> deve = proj.developers;
		for(Developers d : deve){
			System.out.println("   * " + d.name + " ; ");
		}
		System.out.println(" | Publications: ");
		sortByDatesPub(proj.publications);
	}
	
	public static Developers createDeveloper(){
		
		Scanner input  = new Scanner(System.in);
		
		short r; // Respostas
		
		System.out.println("--------- NEW DEVELOPER ---------" + "\n");
		
		try{
		
		System.out.print("Full Name: ");
		String name = input.nextLine();
		
		System.out.print("\nEmail: ");
		String email = input.nextLine();
		
		System.out.println("\n---- Occupation ----");
		System.out.println("(1) - Student");
		System.out.println("(2) - Professor");
		System.out.println("(3) - Research");
		r = input.nextShort();
		
		String c = input.nextLine();
		
		switch(r){
		
			case 1: // ADD ESTUDANTE
				
				System.out.println("--------- NEW STUDENT ---------" + "\n");
				
				System.out.print("University: ");
				String university = input.nextLine();
				
				System.out.print("\n---- Degree ----\n");
				System.out.println("(1) - Graduate");
				System.out.println("(2) - Master");
				System.out.println("(3) - Doctorate");
				r = input.nextShort();
				
				switch(r){
					case 1:
						return createStudentGraduate(name, email, university);
						
					case 2:
						return createStudentMaster(name, email, university);
						
					case 3:
						return createStudentDoctorate(name, email, university);
					default:
						System.out.println("Invalid Command! Please, try again!");
				}
				
			case 2: // ADD PROFESSOR
				
				return createProfessor(name, email);
				
			case 3: // ADD PESQUISADOR
				
				return createResearch(name, email);
				
			default:
				
				System.out.println("Invalid Command! Please, try again!");
				
		}
		
		}catch(InputMismatchException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert characters unlike (1, 2, 3, 4...), please try again");
			
			input.nextLine();
			
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			String option = input.nextLine();
			if(option.equals("1")){
				createDeveloper();
			}
			else{
				return null;
			}
		}
		return null;
	}
	
	public static Publications createPublish(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Scanner input  = new Scanner(System.in);
		
		Publications pub = new Publications();
		
		String option;
		
		System.out.println("--------- NEW PUBLISH ---------" + "\n");
		
		try{

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
				printDevelopers(dev);
				System.out.println("ID:");
				
				id = input.nextInt();
				Developers deve = dev.get(id);
				deve.setPublications(pub);
				
				System.out.println("(1) - Report anotherone");
				System.out.println("(2) - Done!");
				n = input.nextInt();
				c = input.nextLine();
			}while(n != 2);

			System.out.println("The Publish is related with some Project in progress of our Lab?");
			System.out.println("(1) - Yes");
			System.out.println("(2) - No");
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

		}catch(InputMismatchException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert characters unlike (1, 2, 3, 4...), please try again");
			
			input.nextLine();
			
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			option = input.nextLine();
			if(option.equals("1")){
				createPublish(dev, proj);
			}
			else{
				return null;
			}
		}catch(IndexOutOfBoundsException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert an ID that doesn't exist, please try again.");
			
			input.nextLine();
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			option = input.nextLine();
			if(option.equals("1")){
				createPublish(dev, proj);
			}
			else{
				return null;
			}
		}
				
		return pub;
	}
	
	public static Project createProject(ArrayList <Developers> dev){

		Scanner input  = new Scanner(System.in);
	
		Project proj = new Project();
		String option;
		
		System.out.println("-------- NEW PROJECT --------" + "\n");
		
		try{
			
			System.out.println("Headline:");
			proj.setHeadline(input.nextLine());
			
			System.out.println("Please report the date to begin: (dd mm aaaa)");
			System.out.print("Day: ");
			int day = input.nextInt();
			System.out.print("Month: ");
			int mon = input.nextInt();
			System.out.print("Year: ");
			int year = input.nextInt();
			proj.setStartDate(day, mon, year);
			
			String s = input.nextLine();
			
			System.out.print("Funder Agency:");
			proj.setFunder(input.nextLine());
			
			System.out.print("Value:");
			proj.setFinancedValue(input.nextDouble());
			
			s = input.nextLine();
			
			System.out.println("Write down the goals of this project:");
			proj.setGoal(input.nextLine());

			proj.status = 1;
			
			System.out.println("\n-------- Professors --------");
			for(Developers d : dev){
				if(d instanceof professor){
					System.out.println(" * ID: " + dev.indexOf(d) + " - " + d);
				}
			}
			
			System.out.println("----------- * -----------");
			
			int id;
			
			System.out.println("Insert the ID of one of this teachers: ");
			
			id = input.nextInt();
			
			while(!(dev.get(id) instanceof professor)){
				System.out.println("Wrong ID! Please report an ID from a Professor of our lab");
				id = input.nextInt();
			}
			
			Developers de = dev.get(id);
			
			proj.setDevelopers(de);
			
			System.out.println("Congratulations!!");
			
			System.out.println("The Project " + proj.headline + " was add to our Lab!");
			
		}catch(IndexOutOfBoundsException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert an ID that doesn't exist, please try again.");
			
			input.nextLine();
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			option = input.nextLine();
			if(option.equals("1")){
				createProject(dev);
			}
			else{
				return null;
			}
		}catch(InputMismatchException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert characters unlike (1, 2, 3, 4...), please try again");
			
			input.nextLine();
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			
			option = input.nextLine();
			
			if(option.equals("1")){
				createProject(dev);
			}
			else{
				return null;
			}
		}
		
		return proj;
	
	}
	
	public static void sortByDates(ArrayList <Project> proj){
		int[] a = new int[proj.size()];
		int i = 0, j = 0;
		int aux;
		for(Project p : proj){
			a[i] = p.getEndDate();
			i++;
		}
		
		for(i = 0; i < a.length; i++){
			for(j = i+1; j < a.length; j++){
				if(a[i] < a[j]){
					aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				}
			}
		}
		
		for(i = 0; i < a.length; i++){
			for(Project pr : proj){
				if(a[i] == pr.getEndDate()){
					System.out.println(" -> Date: " + a[i] + " - " + pr.headline);
				}
			}
		}
	}
	
	public static void sortByDatesPub(ArrayList <Publications> pub){
		
		int[] a = new int[pub.size()];
		int i = 0, j = 0;
		int aux;
		for(Publications p : pub){
			a[i] = p.getDateOfPublishing();
			i++;
		}
		
		for(i = 0; i < a.length; i++){
			for(j = i+1; j < a.length; j++){
				if(a[i] < a[j]){
					aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				}
			}
		}
		
		for(i = 0; i < a.length; i++){
			for(Publications pu : pub){
				if(a[i] == pu.dateOfPublishing){
					System.out.println("   -> Date: " + pu.dateOfPublishing + " - " + pu.headline);
				}
			}
		}
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
		dev7.setName("Amanda F�lix");
		dev7.setEmail("amandafelix@gmail.com");
		((student)dev7).setCollege("Ufal");
		
		dev.add(dev7);
		
		Developers dev8 = new professor();
		dev8.setName("Harrison Wells");
		dev8.setEmail("harrisonwells@gmail.com");
		
		dev.add(dev8);
		
		Project proj1 = new Project();
		proj1.setHeadline("Dharma Iniciative");
		proj1.setStartDate(4, 8, 1996);;
		proj1.setFunder("Charlie Widmore");
		proj1.financedValue = 10000000;
		proj1.setGoal("Dominate the holy World");
		proj1.setDescription("Explore the stranges properties of a strange Island");
		proj1.status = 1; // Em elaboração
		proj1.setDevelopers(dev5);
		
		proj.add(proj1);
		
		Project proj2 = new Project();
		proj2.setHeadline("Meta-Humans");
		proj2.setStartDate(20, 10, 2000);
		proj2.setFunder("Harrison Wells");
		proj2.financedValue = 100000;
		proj2.setGoal("Learn all about Super Powers");
		proj2.setDescription("Study the efects caused by the explosion of the Acelerator");
		proj2.status = 1; // Em elaboração
		
		proj.add(proj2);
		
	}
	
	public static void edit(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Scanner input  = new Scanner(System.in);
		
		System.out.println("--------- EDITING ---------" + "\n");
		
		String option;
		try{
			short d;
			String s;
			int i, id;
			Project proje;
			
			do{
				
				System.out.println("Choose an option:");
				
				System.out.println("(1) - Allocate");
				System.out.println("(2) - Project Status");
				System.out.println("\n(0) - Back to the Main Menu");
				
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
						System.out.println("(1) - In Preparing");
						System.out.println("(2) - In Progress");
						System.out.println("(3) - Conclude!");
						Short st = input.nextShort();
						
						if(st == 1) proje.status = 1;
						if(st == 2){
							System.out.println("You'll can not allocate anyother member to this project");
							System.out.println("Are you sure?");
							System.out.println("(1) - Yes");
							System.out.println("(2) - No");
							short sure = input.nextShort();
							if(sure == 2){
								break;
							}
							proje.status = st;
							System.out.println("Done!");
						}
						else if(st == 3){
							ArrayList <Publications> pubs = proje.getPubs();
							if(pubs.size() > 0){
								System.out.println("Please report the date to begin:");
								System.out.print("Day: ");
								int day = input.nextInt();
								System.out.print("Month: ");
								int mon = input.nextInt();
								System.out.print("Year: ");
								int year = input.nextInt();
								proje.setEndDate(day, mon, year);
							
								proje.status = st;
								System.out.println("Done!");
							}
							else{
								System.out.println("Sorry but this Project haven't any Publish");
							}
						}
						else{
							System.out.println("Invalid Command! Please try again");
						}
					
						break;
						
					default:
			
						System.out.println("Invalid Command! Please try again");
						
						break;
				}
				
				if(d != 0){
					System.out.println("---------- * -----------");
				}
				
			} while(d != 0);

		}catch(IndexOutOfBoundsException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert an ID that doesn't exist, please try again.");
			
			input.nextLine();
			
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			option = input.nextLine();
			if(option.equals("1")){
				edit(dev, proj);
			}
			
		}catch(InputMismatchException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert characters unlike (1, 2, 3, 4...), please try again");
			
			input.nextLine();
			
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			option = input.nextLine();
			if(option.equals("1")){
				edit(dev, proj);
			}
		}
	}
	
	public static void orientation(ArrayList <Developers> dev){
		
		Scanner input  = new Scanner(System.in);
		String option;
		
		System.out.println("------ All Professors ------");
		try{
			
			for(Developers d : dev){
				if(d instanceof professor){
					System.out.println("ID: " + dev.indexOf(d) + " - " + d.name);
				}
			}
			System.out.println("--------- * ----------\n");
			
			System.out.println("Please insert the ID of the Professor:");
			int id = input.nextInt();
			
			Developers prof = dev.get(id);
			if(!(prof instanceof professor)){
				System.out.println("Invalid Command!! The ID is not from a professor");
				orientation(dev);
			}
			System.out.println("\n------ All Students ------");
			
			for(Developers d : dev){
				if(d instanceof student){
					System.out.println("ID: " + dev.indexOf(d) + " - " + d.name);
				}
			}
			System.out.println("--------- * ----------\n");
			
			System.out.println("Please insert the ID of the Student:");
			id = input.nextInt();
			Developers stu = dev.get(id);
			if(!(stu instanceof student)){
				System.out.println("Invalid Command!! The ID is not from an Student");
				orientation(dev);
			}
			
			ArrayList <Developers> a = ((professor)prof).getOrientations();
			a.add(stu);
			
			System.out.println("Well Done!");
			System.out.println("Now " + prof.name + " is Guilding " + stu.name + " !");
		
		}catch(IndexOutOfBoundsException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert an ID that doesn't exist, please try again.");
			
			input.nextLine();
			System.out.println("(1) - Try again");
			System.out.println("(2) - Back to menu");
			option = input.nextLine();
			
			if(option.equals("1")){
				orientation(dev);
			}
			
		}catch(InputMismatchException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert characters unlike (1, 2, 3, 4...), please try again");
			
			input.nextLine();
			System.out.println("(1) - Try again");
			System.out.println("(Any other Button) - Back to menu");
			option = input.nextLine();
			
			if(option.equals("1")){
				orientation(dev);
			}
		}
	}
	
	public static void consult(ArrayList <Developers> dev, ArrayList <Project> proj){
		
		Scanner input  = new Scanner(System.in);

		String s, option;
		Short d = -1;
		int id;
		
		try{
			do{
				System.out.println("\n--------- CONSULT ---------\n");
				
				System.out.println("(1) - Developers");
				System.out.println("(2) - Projects");
				System.out.println("\n(0) - Back to menu");
				d = input.nextShort();
				s = input.nextLine();
				
				if(d == 1){
					if(dev.size() > 1){
						System.out.println("------ Developers ------");
						printDevelopers(dev);
						System.out.println("---------- * ----------");
						
						System.out.println("Choose The ID of one");
						id = input.nextInt();
						
						Developers de = dev.get(id);
						informationsDev(de);
					}
					else{
						System.out.println("There are no Developers in our Lab now :(");
					}
				}
				else if(d == 2){
					
					if(dev.size() > 0){
						printProjects(proj);
						
						System.out.println("Choose The ID of one");
						id = input.nextInt();
						
						Project pr = proj.get(id);
						informationsProj(pr);
						
					}
					else{
						System.out.println("There are no Projects in our Lab now :(");
					}
				}
				else if(d != 0){
					System.out.println("Error! Please insert a valid option: 1, 2 or 0");
				}
			}while(d != 0);
		}catch(IndexOutOfBoundsException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert an ID that doesn't exist, please try again.");

			input.nextLine();
			System.out.println("(1) - Try again");
			System.out.println("(Any other Button) - Back to menu");
			option = input.nextLine();
			
			if(option.equals("1")){
				consult(dev, proj);
			}
		}catch(InputMismatchException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert characters unlike (1, 2, 3, 4...), please try again");
			
			input.nextLine();
			System.out.println("(1) - Try again");
			System.out.println("(Any other Button) - Back to menu");
			option = input.nextLine();
			
			if(option.equals("1")){
				consult(dev, proj);
			}
		}
		catch(Exception e){
			System.out.println("Try again");
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
		System.out.println("\n # Total of The Academic production:  " + (publi + ori));
		
		System.out.println("--------- *  ---------");
		
	}
	
	public static void lab(){
		
		Scanner input  = new Scanner(System.in);
		
		ArrayList <Developers> dev = new ArrayList <Developers>();
		
		ArrayList <Project> proj = new ArrayList <Project>();
		
		ArrayList <Publications> pub = new ArrayList <Publications>();
		
		int acao = 1; // Ações
		short d; // Decisões
		String s; // Captura de respostas em Strings
		
		int ori = 0, publi = 0; // Contadores de orientações e publicações
		
		initialConfiguration(dev, proj);
		
		try{
			
			while(acao != 0){
				
				System.out.println("\n--------- RoboVision 2001 ---------");
				System.out.println("\nPlease, insert the number of your action:");
				System.out.println("(1) - Open a new Project");
				System.out.println("(2) - Add a new Developer");
				System.out.println("(3) - Edit a Research Project");
				System.out.println("(4) - Publish");
				System.out.println("(5) - Orientation");
				System.out.println("(6) - Consult");
				System.out.println("(7) - Report");
				System.out.println("\n(0) - Exit");
				
				acao = input.nextInt();
				
				s = input.nextLine(); // Pega o '\n' do último scanner
				
				System.out.println();
				
				switch(acao){
					
					case 0: // SAIR
						
						System.out.println("Do you really wanna exit?");
						System.out.println("(1) - Yes");
						System.out.println("(Any Number) - No");
						d = input.nextShort();
						
						if(d != 1){
							acao = 9;
						}
						
						break;
					
					case 1: // NOVO PROJETO
						
						Project pr = createProject(dev);
						
						if(pr != null){
							proj.add(pr);
						}
						
						break;
					
					case 2: // ADICIONAR
					
						Developers dv = createDeveloper();
						
						if(dv != null){
							System.out.println("Congratulations!!" + dv.name + " was add to our lab!");
							dev.add(dv);
						}
						
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
					
					case 7:  // RELATӓRIO
			
						report(dev, proj, ori, publi);
						
						break;
					
					default:
						
						System.out.println("Invalid Option! please try again\n");
						System.out.println("Press any button to continue");
						
						s = input.next();
						
						break;
				}
				
			}
		}catch(InputMismatchException e){
			
			System.out.println("Invalid Command! Some date was put incorrectly.");
			System.out.println("Probably you insert characters unlike (1, 2, 3, 4...), please try again");
			
			input.nextLine();
			System.out.println("(1) - Back to Menu");
			System.out.println("(Any other Button) - Exit");
			String option = input.nextLine();
			
			if(option.equals("1")){
				lab();
			}
			
		}
		input.close();

	}

	public static void main(String[] args) {

		lab();
		System.out.println("Thank's for been using our services!");
			
	}
}
