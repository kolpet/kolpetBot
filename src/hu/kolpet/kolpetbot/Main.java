package hu.kolpet.kolpetbot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("login.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
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
		KolpetBot _KolpetBot = new KolpetBot(username, password);
		_KolpetBot.connect();
	}
}
