package hu.kolpet.kolpetbot;

import java.util.Base64;

public final class Encoder {
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
		return output;
	}
	
	public static String Base64(String input)
	{
		return new String(Base64.getEncoder().encode(input.getBytes()));
	}
}
