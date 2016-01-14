package hu.kolpet.kolpetbot;

import java.util.Base64;

public final class Encoder {
	public static String ASCII(String input)
	{
		String output = "";
		for(char ch : input.toCharArray())
		{
			input += (ch + 0) + " ";
		}
		return output;
	}
	
	public static String Base64(String input)
	{
		return new String(Base64.getEncoder().encode(input.getBytes()));
	}
}
