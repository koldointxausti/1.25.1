import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class Matches {
	public static void main(String[] args){
		File matches = new File(args[0]);
		ArrayList<FootballMatch> list = new ArrayList<FootballMatch>();
		try {
			Scanner sc = new Scanner (matches);
			while(sc.hasNextLine()) {
				FootballMatch a = new FootballMatch();
				String tokens[] = sc.nextLine().split("::");
				a.setLocalTeam(tokens[0]);
				System.out.print(a.getLocalTeam()+" - ");
				a.setVisitorTeam(tokens[1]);
				System.out.println(a.getVisitorTeam());
				a.setGoalsLocal(Integer.parseInt(tokens[2]));
				System.out.print(a.getGoalsLocal()+" - ");
				a.setGoalsVisitor(Integer.parseInt(tokens[3]));
				System.out.println(a.getGoalsVisitor());
				list.add(a);
			}
		}catch (FileNotFoundException e) {
			System.out.println("Enter the path of the file you want to read.");
			System.out.println("example: java Matches ../matches.txt");
		}
	}
}
