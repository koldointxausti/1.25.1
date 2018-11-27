import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddPlayerInfo {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Enter the file name of the file you want to read.");
			System.out.println("example: java Matches ../Champions.txt");
		} else {
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
				sc1.close();
				ArrayList<Player> players = new ArrayList<Player>();
				File playerInfo = new File("../PlayerInfo.txt");
				Scanner sc2 = new Scanner(playerInfo);
				while (sc2.hasNextLine()) {
					Player a = new Player();
					String tokens[] = sc2.nextLine().split("::");
					a.setName(tokens[0]);
					a.setAge(Integer.parseInt(tokens[1]));
					a.setPosition(tokens[2]);
					for (int i = 0; i < teams.size(); i++) {
						if (tokens[3].compareTo(teams.get(i).getName()) == 0) {
							a.setTeam(teams.get(i));
							break;
						}
					}
					players.add(a);
				}
				sc2.close();

				ArrayList<FootballMatch> list = new ArrayList<FootballMatch>();

				System.out.println(args[0]);
				File matches = new File(args[0]);
				try {
					Scanner sc = new Scanner(matches);
					while (sc.hasNextLine()) {
						FootballMatch a = new FootballMatch();
						String tokens[] = sc.nextLine().split("::");
						for (int x = 0; x < teams.size(); x++) {
							if (tokens[0].compareTo(teams.get(x).getName()) == 0) {
								a.setLocalTeam(teams.get(x));
								break;
							}
						}
						for (int x = 0; x < teams.size(); x++) {
							if (tokens[1].compareTo(teams.get(x).getName()) == 0) {
								a.setVisitorTeam(teams.get(x));
								break;
							}
						}
						a.setGoalsLocal(Integer.parseInt(tokens[2]));
						a.setGoalsVisitor(Integer.parseInt(tokens[3]));
						list.add(a);
					}
				} catch (FileNotFoundException e) {
					System.out.println("Enter the name of the file you want to read.");
					System.out.println("example: java MatchArrayList ../Champions.txt");
				}
				for (int x = 0; x < list.size(); x++) {
					System.out.print(((FootballMatch) list.get(x)).getLocalTeam().getName() + " - ");
					System.out.println(((FootballMatch) list.get(x)).getVisitorTeam().getName());
					System.out.print(((FootballMatch) list.get(x)).getGoalsLocal() + " - ");
					System.out.println(((FootballMatch) list.get(x)).getGoalsVisitor());
					System.out.println();

					System.out.println("*LOCAL TEAM INFORMATION*");
					System.out.println("Name: " + ((FootballMatch) list.get(x)).getLocalTeam().getName());
					System.out.println("Nationality: " + ((FootballMatch) list.get(x)).getLocalTeam().getNationality());
					System.out.println("Stadium: " + ((FootballMatch) list.get(x)).getLocalTeam().getStadium());
					System.out.println("Capacity: " + ((FootballMatch) list.get(x)).getLocalTeam().getCapacity());
					System.out.println();

					for (int i = 0; i < players.size(); i++) {
						if (players.get(i).getTeam().getName().compareTo(list.get(x).getLocalTeam().getName())== 0) {
							System.out.println("*LOCAL TEAM'S PLAYERS' INFORMATION*");
							System.out.println("Name: " + players.get(i).getName());
							System.out.println("Age: " + players.get(i).getAge());
							System.out.println("Position: " + players.get(i).getPosition());
							System.out.println();
						}
					}
					System.out.println("*VISITOR TEAM INFORMATION*");
					System.out.println("Name: " + ((FootballMatch) list.get(x)).getVisitorTeam().getName());
					System.out.println("Nationality: " + ((FootballMatch) list.get(x)).getVisitorTeam().getNationality());
					System.out.println("Stadium: " + ((FootballMatch) list.get(x)).getVisitorTeam().getStadium());
					System.out.println("Capacity: " + ((FootballMatch) list.get(x)).getVisitorTeam().getCapacity());
					System.out.println();

					for (int i = 0; i < players.size(); i++) {
						if (players.get(i).getTeam().getName().compareTo(list.get(x).getVisitorTeam().getName()) == 0) {
							System.out.println("*VISITOR TEAM'S PLAYERS' INFORMATION*");
							System.out.println("Name: " + players.get(i).getName());
							System.out.println("Age: " + players.get(i).getAge());
							System.out.println("Position: " + players.get(i).getPosition());
							System.out.println();
						}
					}

				}
				System.out.println();
			} catch (FileNotFoundException e) {
				System.out.println("File of Team Information is not found.");
			}
		}

	}
}
