package hu.kolpet.kolpetbot;

import java.util.logging.Logger;

import me.itsghost.jdiscord.DiscordAPI;
import me.itsghost.jdiscord.DiscordBuilder;
import me.itsghost.jdiscord.OnlineStatus;
import me.itsghost.jdiscord.event.EventListener;
import me.itsghost.jdiscord.events.UserChatEvent;
import me.itsghost.jdiscord.exception.BadUsernamePasswordException;
import me.itsghost.jdiscord.exception.DiscordFailedToConnectException;
import me.itsghost.jdiscord.message.Message;
import me.itsghost.jdiscord.message.MessageBuilder;

public class KolpetBot implements EventListener{
	private static String Username;
	private static String Password;
	private final static String NAME = "kolpetBot";
	private final static double VERSION = 0.6;
	private final static String VERSIONNAME = "ValuableLittleHelper";
	public static final Logger logger =
		        Logger.getLogger(KolpetBot.class.getName());
	//private Slots _Slots = new Slots();
	
	private DiscordAPI API;
	
	public KolpetBot(String username, String password)
	{
		Username = username;
		Password = password;
		API = new DiscordBuilder().build();
		API.getEventManager().registerListener(this);
	}
	
	public void userMessageEvent(UserChatEvent e)
	{
		String rawMessage = e.getMsg().getMessage();
		char key = rawMessage.toCharArray()[0];
		String message = rawMessage.substring(1);
		String cmd = message.split(" ")[0];
		String[] args = argsCut(message.split(" "), 1);
		
		if("!$;ÃŸÅ|/&~".contains(String.valueOf(key)))
		{
			if(cmd.equalsIgnoreCase("bots"))
			{
				MessageBuilder builder = new MessageBuilder();
				Message reply;
				builder.addItalic(NAME + ", lining up! Current version: ");
				builder.addBold("v" + Double.toString(VERSION) + " (" + VERSIONNAME + ")");
				reply = builder.build(API);
				e.getGroup().sendMessage(reply);
			}
		}
		else if(key == '+')
		{
			MessageBuilder builder = new MessageBuilder();
			Message reply;
			
			switch(cmd.toLowerCase())
			{
				case "hello":
					builder.addItalic(NAME + ", reporting in! Current version: ");
					builder.addBold("v" + Double.toString(VERSION) + " (" + VERSIONNAME + ")");
					break;
				case "help":
					builder.addItalic("Hello, I am ");
					builder.addBold(NAME);
					builder.addItalic(", and these are my commands:");
					builder.addString("\n```+help : Hello?");
					builder.addString("\n+hello : Small introduction!");
					builder.addString("\n+soon : Soon.");
					builder.addString("\n+source : Sauce.");
					builder.addString("\n+slots : Spin it");
					builder.addString("\n+rot {n} {String} : ROT the message to n.");
					builder.addString("\n+vigenere {key} {String} : Decode String with Vigenere Cipher using key.");
					builder.addString("\n+eb64 {String} : Encode String into Base64.");
					builder.addString("\n+db64 {Base64} : Decode Base64 into String.");
					builder.addString("\n+dmorse {long} {short} {String}  : Decode morse String with long and short keys to String.");
					builder.addString("```");
					break;
				case "slots":
					builder.addUserTag(e.getUser(), e.getGroup());
					builder.addItalic(" this function is only for 4chan gold users.");
					break;
				case "soon":
					builder.addBold("soon");
					break;
				case "master":
					if(e.getServer().getGroupUserById("119371468055379968").getUser().getOnlineStatus() == OnlineStatus.OFFLINE)
						builder.addString("Sensei kolpet is offline at the moment, sorry!");
					else
					{
						builder.addUserTag("kolpet", e.getGroup());
						builder.addString("-sama, they are asking about you again!");
					}
					break;
				case "source":
					builder.addString("*But... senpai... You will see me naked....* https://github.com/kolpet/kolpetBot");
					break;
				case "math":
					builder.addString("*Of course I know math! 1+1=3, beat that.*");
					break;
				case "robot":
					builder.addItalic("Me robot. Me clever. ");
					builder.addString("***ME SUPERIOR.***\n");
					builder.addItalic("Beep, Boop.");
					break;
				case "rot":
					builder.addString("*From:* ***" + argsMelt(args, 1) + "***\n");
					builder.addString("*To:* ***" + Encoder.Rot(argsMelt(args, 1), Integer.parseInt(args[0])) + "***\n");
					break;
				case "vigenere":
					builder.addString("*From:* ***" + argsMelt(args, 1) + "***\n");
					builder.addString("*To:* ***" + Encoder.Viginere(argsMelt(args, 1), args[0]) + "***\n");
					break;
				case "reverse":
					builder.addString("*From:* ***" + argsMelt(args, 0) + "***\n");
					builder.addString("*To:* ***" + Encoder.Reverse(argsMelt(args, 0)) + "***\n");
					break;
				case "eb64":
					builder.addString("*From:* ***" + argsMelt(args, 0) + "***\n");
					builder.addString("*To:* ***" + Encoder.Base64(argsMelt(args, 0)) + "***\n");
					break;
				case "db64":
					builder.addString("*From:* ***" + argsMelt(args, 0) + "***\n");
					builder.addString("*To:* ***" + Decoder.Base64(argsMelt(args, 0)) + "***\n");
					break;
				case "dmorse":
					builder.addString("*From:* ***" + argsMelt(args, 2) + "***\n");
					builder.addString("*To:* ***" + Decoder.Morse(argsMelt(args, 2), args[0], args[1]) + "***\n");
					break;
				/*case "general":
					builder.addBold("BOTS, ATTEND ME!");
					reply = builder.build(API);
					e.getGroup().sendMessage(reply);
					e.getGroup().sendMessage("!bots");*/
					
			}
			reply = builder.build(API);
			e.getGroup().sendMessage(reply);
		}
	}
	
	public void connect()
	{
		try {
			API.login(Username, Password);
		} catch (BadUsernamePasswordException | DiscordFailedToConnectException e) {
			e.printStackTrace();
		}
	}
	
	private String[] argsCut(String[] input, int fromIndex)
	{
		String[] output = new String[input.length - fromIndex];
		for(int i = fromIndex; i < input.length; i++)
		{
			output[i-fromIndex] = input[i];
		}
		return output;
	}
	
	private String argsMelt(String[] input, int fromIndex)
	{
		String output = input[fromIndex];
		for(int i = fromIndex + 1; i < input.length; i++)
		{
			output += " " + input[i];
		}
		return output;
	}
}
