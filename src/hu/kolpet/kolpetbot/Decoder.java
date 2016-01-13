package hu.kolpet.kolpetbot;

import java.util.Base64;
import java.util.logging.Level;

public final class Decoder {
	public static String Base64(String input)
	{
		return new String(Base64.getDecoder().decode(input.getBytes()));
	}
	
	public static String Rot(String input, int value)
	{
	    if (value < 0) {
	    	value = (26 - ((0 - value) % 26));
	    }
	    int rot = value % 26;
	    String output = "";
	    for (char ch : input.toCharArray()) {
	        if (ch >= 65 && ch <= 90) {
	            if (ch + rot <= 90) {
	                output += (char) (ch + rot);
	            } else {
	            	output += (char) (ch + rot - 26);
	            }
	        } else if (ch >= 97 && ch <= 122) {
	            if (ch + rot <= 122) {
	            	output += (char) (ch + rot);
	            } else {
	            	output += (char) (ch + rot - 26);
	            }
	        } else {
	        	output += ch;
	        }
	    }
	    return output;
	}
	
	public static String Viginere(String input, String value)
	{
		int x = 0;
		int[] rot = new int[value.length()];
		char[] rotvalue = value.toCharArray();
		for(int i = 0; i < value.length(); i++)
		{
			if (rotvalue[i] >= 65 && rotvalue[i] <= 90) {
				rot[i] = rotvalue[i] - 65;
	        } else if (rotvalue[i] >= 97 && rotvalue[i] <= 122) {
	        	rot[i] = rotvalue[i] - 97;
	        } else {
	        	rot[i] = 0;
	        }
		}
		String output = "";
		for (char ch : input.toCharArray()) {
			if(ch != ' ')
			{
				if(x == rot.length) x = 0;
		        if (ch >= 65 && ch <= 90) {
		            if (ch + rot[x] <= 90) {
		                output += (char) (ch + rot[x]);
		            } else {
		            	output += (char) (ch + rot[x] - 26);
		            }
	
		        } else if (ch >= 97 && ch <= 122) {
		            if (ch + rot[x] <= 122) {
		            	output += (char) (ch + rot[x]);
		            } else {
		            	output += (char) (ch + rot[x] - 26);
		            }
		        } else {
		        	output += ch;
		        }
		        x++;
			}
			else
				output += " ";
				
	    }
		return output;
	}
	
	public static String Reverse(String input)
	{
	    String output = "";
	    for (char ch : input.toCharArray()) {
	        if (ch >= 65 && ch <= 90) {
	        	output += (char) (-1 * (ch - 155));
	        } else if (ch >= 97 && ch <= 122) {
	        	output += (char) (-1 * (ch - 219));
	        } else {
	        	output += ch;
	        }
	    }
	    return output;
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
	
	public static String ASCII(String input)
	{
		String output = "";
		String[] letters = input.split(" ");
		for(String letter : letters)
		{
			output += ((char) Integer.parseInt(letter));
		}
		return output;
	}
}
