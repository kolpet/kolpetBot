package hu.kolpet.kolpetbot;

import java.util.Base64;

public final class Decoder {
	public static String Base64(String input)
	{
		return new String(Base64.getDecoder().decode(input.getBytes()));
	}
}
