import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class MatchInterator {
	public static void main(String[] args){
		File matches = new File("matches.txt");
		ArrayList<FootballMatch> list = new ArrayList<FootballMatch>();
		try {
			Scanner sc = new Scanner (matches);
			while(sc.hasNextLine()) {
				FootballMatch a = new FootballMatch();
				String tokens[] = sc.nextLine().split("::");
				a.setLocalTeam(tokens[0]);
				a.setVisitorTeam(tokens[1]);
				a.setGoalsLocal(Integer.parseInt(tokens[2]));
				a.setGoalsVisitor(Integer.parseInt(tokens[3]));
				list.add(a);
			}
			ListIterator<FootballMatch> it = list.listIterator();
			while (it.hasNext()) {
				if (it.next().getGoalsLocal()==it.previous().getGoalsVisitor()) {
					System.out.println(it.next().getLocalTeam()+" - "+ it.previous().getVisitorTeam());
					System.out.println(it.next().getGoalsLocal()+" - "+ it.previous().getGoalsVisitor());
					it.remove();
				}else {
					it.next();
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("Enter the path of the file you want to read.");
			System.out.println("example: java Matches ../matches.txt");
		}
	}
}
