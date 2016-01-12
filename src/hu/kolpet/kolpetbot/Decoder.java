package hu.kolpet.kolpetbot;

import java.util.Base64;

public final class Decoder {
	public static String Base64(String input)
	{
		return new String(Base64.getDecoder().decode(input.getBytes()));
	}
	
	public static String Morse(String input, String dot, String dash)
	{
		String[] letters = input.split(" ");
		String output = "";
		for(String letter : letters)
		{
			if(letter == dot + dash)
				output += "A";
			else if (letter == dash + dot + dot + dot)
				output += "B";
			else if(letter == dash + dot + dash + dot)
				output += "C";
			else if(letter == dash + dot + dot)
				output += "D";
			else if(letter == dot)
				output += "E";
			else if(letter == dot + dot + dash + dot)
				output += "F";
			else if(letter == dash + dash + dot)
				output += "G";
			else if(letter == dot + dot + dot + dot)
				output += "H";
			else if(letter == dot + dot)
				output += "I";
			else if(letter == dot + dash + dash + dash)
				output += "J";
			else if(letter == dash + dot + dash)
				output += "K";
			else if(letter == dot + dash + dot + dot)
				output += "L";
			else if(letter == dash + dash)
				output += "M";
			else if(letter == dash + dot)
				output += "N";
			else if(letter == dash + dash + dash)
				output += "O";
			else if(letter == dot + dash + dash + dot)
				output += "P";
			else if(letter == dash + dash + dot + dash)
				output += "Q";
			else if(letter == dot + dash + dot)
				output += "R";
			else if(letter == dot + dot + dot)
				output += "S";
			else if(letter == dash)
				output += "T";
			else if(letter == dot + dot + dash)
				output += "U";
			else if(letter == dot + dot + dot + dash)
				output += "V";
			else if(letter == dot + dash + dash)
				output += "W";
			else if(letter == dash + dot + dot + dash)
				output += "X";
			else if(letter == dash + dot + dash + dash)
				output += "Y";
			else if(letter == dash + dash + dot + dot)
				output += "Z";
			else if(letter == dot + dash + dash + dash + dash)
				output += "1";
			else if(letter == dot + dot + dash + dash + dash)
				output += "2";
			else if(letter == dot + dot + dot + dash + dash)
				output += "3";
			else if(letter == dot + dot + dot + dot + dash)
				output += "4";
			else if(letter == dot + dot + dot + dot + dot)
				output += "5";
			else if(letter == dash + dot + dot + dot + dot)
				output += "6";
			else if(letter == dash + dash + dot + dot + dot)
				output += "7";
			else if(letter == dash + dash + dash + dot + dot)
				output += "8";
			else if(letter == dash + dash + dash + dash + dot)
				output += "9";
			else if(letter == dash + dash + dash + dash + dash)
				output += "0";
			else
				output += "?";
		}
		return output;
	}
}
