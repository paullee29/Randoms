package fileRenamer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Prompter {
	public static int Counter () {
		Scanner sc = new Scanner (System.in);
		System.out.println("Where are the files?");
		String filePath = sc.nextLine();
		Path path = Paths.get(filePath);
		System.out.println("What extension would you like to rename the files for?");
		
		String fileExtension = sc.nextLine();

		
		
		return 0;
		
	}

}
