import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class TeamInformation {
	public static void main(String[] args) {
		if (args.length == 1) {
			ArrayList<Team> team = new ArrayList<Team>();
			File info = new File(args[0]);
			try {
				Scanner sc=new Scanner(info);
				while(sc.hasNext()) {
					String[] parts = sc.nextLine().split("::");
					Team a = new Team();
					a.setName(parts[0]);
					a.setNationality(parts[1]);
					a.setStadium(parts[2]);
					a.setCapacity(Integer.parseInt(parts[3]));
				}
			}catch (FileNotFoundException e) {
				System.out.println("You must enter the path of a text file.");
				System.out.println("example: ../TeamInformation.txt");
			}
		}else {
			System.out.println("You must enter just one path of a text file.");
			System.out.println("example: ../TeamInformation.txt");
		}
	}
}
