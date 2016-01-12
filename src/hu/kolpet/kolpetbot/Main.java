package hu.kolpet.kolpetbot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		String fileName = "C://Users//kolpet//git//kolpetBot//login.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName)))
		{
			Object[] lines = stream.toArray();
			String username = String.valueOf(lines[0]);
			String password = String.valueOf(lines[1]);
			KolpetBot _KolpetBot = new KolpetBot(username, password);
			_KolpetBot.connect();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
