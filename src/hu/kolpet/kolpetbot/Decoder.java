package hu.kolpet.kolpetbot;

import java.util.Base64;

public final class Decoder {
	public static String Base64(String input)
	{
		return new String(Base64.getDecoder().decode(input.getBytes()));
	}
	
	public static String Morse(String input, String dash, String dot)
	{
		input = input.replace(dash, "_").replace(dot, ".");
		String[] letters = input.split(" ");
		String output = "";
		for(int i = 0; i < letters.length; i++)
		{
			if(letters[i] == "._")
				output += "A";
			else if (letters[i] == "_...")
				output += "B";
			else if(letters[i] == "_._.")
				output += "C";
			else if(letters[i] == "_..")
				output += "D";
			else if(letters[i] == ".")
				output += "E";
			else if(letters[i] == ".._.")
				output += "F";
			else if(letters[i] == "__.")
				output += "G";
			else if(letters[i] == "....")
				output += "H";
			else if(letters[i] == "..")
				output += "I";
			else if(letters[i] == ".___")
				output += "J";
			else if(letters[i] == "_._")
				output += "K";
			else if(letters[i] == "._..")
				output += "L";
			else if(letters[i] == "__")
				output += "M";
			else if(letters[i] == "_.")
				output += "N";
			else if(letters[i] == "___")
				output += "O";
			else if(letters[i] == ".__.")
				output += "P";
			else if(letters[i] == "__._")
				output += "Q";
			else if(letters[i] == "._.")
				output += "R";
			else if(letters[i] == "...")
				output += "S";
			else if(letters[i] == "_")
				output += "T";
			else if(letters[i] == ".._")
				output += "U";
			else if(letters[i] == "..._")
				output += "V";
			else if(letters[i] == ".__")
				output += "W";
			else if(letters[i] == "_.._")
				output += "X";
			else if(letters[i] == "_.__")
				output += "Y";
			else if(letters[i] == ".__.")
				output += "Z";
			else if(letters[i] == ".____")
				output += "1";
			else if(letters[i] == "..___")
				output += "2";
			else if(letters[i] == "...__")
				output += "3";
			else if(letters[i] == "...._")
				output += "4";
			else if(letters[i] == ".....")
				output += "5";
			else if(letters[i] == "_....")
				output += "6";
			else if(letters[i] == "__...")
				output += "7";
			else if(letters[i] == "___..")
				output += "8";
			else if(letters[i] == "____.")
				output += "9";
			else if(letters[i] == "_____")
				output += "0";
			else
				output += "?";
		}
		return output;
	}
}
