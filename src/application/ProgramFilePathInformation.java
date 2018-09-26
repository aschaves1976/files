package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProgramFilePathInformation {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a file path: ");
		// C:\\ASChaves\\JAVA\\temp\\out.txt
		String strPath = sc.nextLine();

		File path = new File(strPath);

		System.out.println("File Name(with getName):     " + path.getName());
		System.out.println("File Path(with getParent):   " + path.getParent());
		System.out.println("All File Path(with getPath): " + path.getPath());
		System.out.println("getAbsoluteFile: " + path.getAbsoluteFile());
		System.out.println("getCanonicalPath: " + path.getCanonicalPath());
		System.out.println("toString: " + path.toString());

		sc.close();
	}

}
