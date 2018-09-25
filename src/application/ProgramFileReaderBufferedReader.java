package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProgramFileReaderBufferedReader {

	public static void main(String[] args) {
		String[] lines = new String[] { "Good Morning", "Good Afternoon", "Good Evening" };
		String path = "C:\\ASChaves\\JAVA\\temp\\out.txt";
		/**
		 * • Cria/recria o arquivo: new FileWriter(path) / new FileWriter(path, false) •
		 * Acrescenta ao arquivo existente: new FileWriter(path, true)
		 */
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
