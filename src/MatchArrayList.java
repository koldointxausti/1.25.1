import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class MatchArrayList {
	public static void main(String[] args){
		if(args.length<1) {
			System.out.println("Enter the path of the file you want to read.");
			System.out.println("example: java Matches ../matches.txt");
		}
		ArrayList<FootballMatch> list = new ArrayList<FootballMatch>();
		ArrayList<ArrayList> all = new ArrayList<ArrayList>();
		for(int i=0; i<args.length;i++) {
			System.out.println(args[i]);
			File matches= new File(args[i]);
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
			}catch (FileNotFoundException e) {
				System.out.println("Enter the path of the file you want to read.");
				System.out.println("example: java MatchArrayList ../Champions.txt");
			}all.add(list);
		}
		for(int i=0; i<all.size();i++) {
			System.out.println("There are "+all.get(i).size()+" matches in the number "+(i+1));
				for (int x = 0; all.get(i).size() >x;x++){
					System.out.print(((FootballMatch) all.get(i).get(x)).getLocalTeam()+" - ");
					System.out.println(((FootballMatch) all.get(i).get(x)).getLocalTeam());
					System.out.print(((FootballMatch) all.get(i).get(x)).getGoalsLocal()+" - ");
					System.out.println(((FootballMatch) all.get(i).get(x)).getGoalsVisitor());
				}
			System.out.println();
		}
	}
}
