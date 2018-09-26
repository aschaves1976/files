package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProgramExercicio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// C:\ASChaves\JAVA\temp\SoldItem.csv
		System.out.print("Enter file sourcePath: ");

		String strPath = sc.nextLine();
		File sourcePath = new File(strPath);

		String strOut = sourcePath.getParentFile() + "\\out\\summary.csv";
		File outPath = new File(sourcePath.getParentFile() + "\\out");

		boolean success = false;

		// Criar uma subpasta a partir do diretorio informado
		if (outPath.exists() && outPath.isDirectory()) {
			success = true;
		} else {
			success = new File(sourcePath.getParentFile() + "\\out").mkdir();
		}

		if (!success) {
			System.out.println("Diretório de Destino não foi criado.");
		} else {
			try (BufferedReader br = new BufferedReader(new FileReader(sourcePath))) {
				String line = br.readLine();
				while (line != null) {
					String[] lines = line.split(",");
					String produto = lines[0];
					Double valorTotal = Double.parseDouble(lines[1]) * Integer.parseInt(lines[2]);

					try (BufferedWriter bw = new BufferedWriter(new FileWriter(strOut, true))) {
						bw.write(produto + ", " + valorTotal);
						bw.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}

					line = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				sc.close();
			}
		}
	}
}