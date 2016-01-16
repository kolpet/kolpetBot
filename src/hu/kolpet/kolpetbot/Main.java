package hu.kolpet.kolpetbot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static KolpetBot _KolpetBot;
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			if(System.getProperty("os.name").startsWith("Windows"))
				reader = new BufferedReader(new FileReader("login.txt"));
			else
				reader = new BufferedReader(new FileReader("./login.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String line = null;
		String[] lines = new String[2];
		int x = 0;
		try {
			while ((line = reader.readLine()) != null) {
				lines[x] = line;
				x++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String username = lines[0];
		String password =lines[1];
		_KolpetBot = new KolpetBot(username, password);
		_KolpetBot.connect();
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			if (scanner.next().equalsIgnoreCase("exit"))
			{
				scanner.close();
				_KolpetBot.shutdown();
			}
		}
	}
}
