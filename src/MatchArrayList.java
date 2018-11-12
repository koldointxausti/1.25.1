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
		ArrayList all = new ArrayList();
		for(int i=0; i<args.length;i++) {
			System.out.println(args[i]);
			File matches= new File(args[i]);
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
					all.add(list);
				}
			}catch (FileNotFoundException e) {
				System.out.println("Enter the path of the file you want to read.");
				System.out.println("example: java MatchArrayList ../Champions.txt");
			}
		}
		for(int i=0; i<all.size();i++) {
			System.out.println(all.get(i));
		}
	}
}
