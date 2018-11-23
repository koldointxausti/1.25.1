import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayList2 {
	public static void main(String[] args) {
		if(args.length<1) {
			System.out.println("Enter the file name of the file you want to read.");
			System.out.println("example: java Matches ../Champions.txt");
		}
		File teamInfo = new File("../TeamInfo.txt");
		ArrayList<Team> teams = new ArrayList<Team>();
		try {
			Scanner sc1 = new Scanner(teamInfo);
			while (sc1.hasNextLine()) {
				Team a = new Team();
				String tokens[] = sc1.nextLine().split("::");
				a.setName(tokens[0]);
				a.setNationality(tokens[1]);
				a.setStadium(tokens[2]);
				a.setCapacity(Integer.parseInt(tokens[3]));
				teams.add(a);
			}
			
			
			ArrayList<FootballMatch> list = new ArrayList<FootballMatch>();

			for(int i=0; i<args.length;i++) {
				System.out.println(args[i]);
				File matches= new File(args[i]);
				try {
					Scanner sc = new Scanner (matches);
					while(sc.hasNextLine()) {
						FootballMatch a = new FootballMatch();
						String tokens[] = sc.nextLine().split("::");
						for(int x = 0; x < teams.size();x++) {
							if (tokens[0]==teams.get(i).getName()) {
								a.setLocalTeam(teams.get(i));
								break;
							}
						}
						for(int x = 0; x < teams.size();x++) {
							if (tokens[1]==teams.get(i).getName()) {
								a.setVisitorTeam(teams.get(i));
								break;
							}
						}
						a.setGoalsLocal(Integer.parseInt(tokens[2]));
						a.setGoalsVisitor(Integer.parseInt(tokens[3]));
						list.add(a); 
					}
				}catch (FileNotFoundException e) {
					System.out.println("Enter the name of the file you want to read.");
					System.out.println("example: java MatchArrayList ../Champions.txt ../CopaDelRey.txt");
				}
			}
			for(int x=0; x<list.size();x++) {
					System.out.print(((FootballMatch) list.get(x)).getLocalTeam().getName()+" - ");
					System.out.println(((FootballMatch) list.get(x)).getVisitorTeam().getName());
					System.out.print(((FootballMatch) list.get(x)).getGoalsLocal()+" - ");
					System.out.println(((FootballMatch) list.get(x)).getGoalsVisitor());
						
						System.out.println("*LOCAL TEMA INFORMATION*");
						System.out.println("Name: "+((FootballMatch) list.get(x)).getLocalTeam().getName());
						System.out.println("Nationality: "+((FootballMatch) list.get(x)).getLocalTeam().getNationality());
						System.out.println("Stadium: "+((FootballMatch) list.get(x)).getLocalTeam().getStadium());
						System.out.println("Capacity: "+((FootballMatch) list.get(x)).getLocalTeam().getCapacity());
						
					}
				System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("File of Team Information is not found.");
		}
		
		
	}
}
