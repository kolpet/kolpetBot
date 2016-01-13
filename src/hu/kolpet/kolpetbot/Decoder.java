package hu.kolpet.kolpetbot;

import java.util.Base64;
import java.util.logging.Level;

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
			if(letters[i].equalsIgnoreCase("._"))
				output += "A";
			else if (letters[i].equalsIgnoreCase("_..."))
				output += "B";
			else if(letters[i].equalsIgnoreCase("_._."))
				output += "C";
			else if(letters[i].equalsIgnoreCase("_.."))
				output += "D";
			else if(letters[i].equalsIgnoreCase("."))
				output += "E";
			else if(letters[i].equalsIgnoreCase(".._."))
				output += "F";
			else if(letters[i].equalsIgnoreCase("__."))
				output += "G";
			else if(letters[i].equalsIgnoreCase("...."))
				output += "H";
			else if(letters[i].equalsIgnoreCase(".."))
				output += "I";
			else if(letters[i].equalsIgnoreCase(".___"))
				output += "J";
			else if(letters[i].equalsIgnoreCase("_._"))
				output += "K";
			else if(letters[i].equalsIgnoreCase("._.."))
				output += "L";
			else if(letters[i].equalsIgnoreCase("__"))
				output += "M";
			else if(letters[i].equalsIgnoreCase("_."))
				output += "N";
			else if(letters[i].equalsIgnoreCase("___"))
				output += "O";
			else if(letters[i].equalsIgnoreCase(".__."))
				output += "P";
			else if(letters[i].equalsIgnoreCase("__._"))
				output += "Q";
			else if(letters[i].equalsIgnoreCase("._."))
				output += "R";
			else if(letters[i].equalsIgnoreCase("..."))
				output += "S";
			else if(letters[i].equalsIgnoreCase("_"))
				output += "T";
			else if(letters[i].equalsIgnoreCase(".._"))
				output += "U";
			else if(letters[i].equalsIgnoreCase("..._"))
				output += "V";
			else if(letters[i].equalsIgnoreCase(".__"))
				output += "W";
			else if(letters[i].equalsIgnoreCase("_.._"))
				output += "X";
			else if(letters[i].equalsIgnoreCase("_.__"))
				output += "Y";
			else if(letters[i].equalsIgnoreCase(".__."))
				output += "Z";
			else if(letters[i].equalsIgnoreCase(".____"))
				output += "1";
			else if(letters[i].equalsIgnoreCase("..___"))
				output += "2";
			else if(letters[i].equalsIgnoreCase("...__"))
				output += "3";
			else if(letters[i].equalsIgnoreCase("...._"))
				output += "4";
			else if(letters[i].equalsIgnoreCase("....."))
				output += "5";
			else if(letters[i].equalsIgnoreCase("_...."))
				output += "6";
			else if(letters[i].equalsIgnoreCase("__..."))
				output += "7";
			else if(letters[i].equalsIgnoreCase("___.."))
				output += "8";
			else if(letters[i].equalsIgnoreCase("____."))
				output += "9";
			else if(letters[i].equalsIgnoreCase("_____"))
				output += "0";
			else if(letters[i].equalsIgnoreCase("/") || letters[i].equalsIgnoreCase(""))
				output += " ";
			else
				output += "?";
		}
		return output;
	}
}
