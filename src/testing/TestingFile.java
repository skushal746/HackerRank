package testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TestingFile {
	public static void main(String[] args) {
		FileInputStream inputStream = null;
		Scanner sc = null;
		String pathString = "C:/Users/skush/Downloads";
		try
		{
			
			inputStream = new FileInputStream(pathString);
			sc = new Scanner(inputStream);
			if(sc.hasNextLine())
			{
				String yolo = sc.nextLine();
			}
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.out.println("File could not be found");
		}

		try(FileInputStream inputStream1 = new FileInputStream(pathString))
		{
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
