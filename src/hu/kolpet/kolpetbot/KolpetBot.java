package hu.kolpet.kolpetbot;

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
	private final static String Username = "kolpet1997@gmail.com";
	private final static String Password = "gVsLpVtsaFSPfd5qVx6Z";
	private final static String NAME = "kolpetBot";
	private final static double VERSION = 0.4;
	private final static String VERSIONNAME = "ImprovingLittleHelper";
	//private Slots _Slots = new Slots();
	
	private DiscordAPI API;
	
	public KolpetBot()
	{
		API = new DiscordBuilder().build();
		API.getEventManager().registerListener(this);
	}
	
	public void userMessageEvent(UserChatEvent e)
	{
		String rawMessage = e.getMsg().getMessage();
		char cmd = rawMessage.toCharArray()[0];
		String message = rawMessage.substring(1);
		String[] args = message.split(" ");
		
		if("!$;ߣ��|/&~".contains(String.valueOf(cmd)))
		{
			if(args[0].equalsIgnoreCase("bots"))
			{
				MessageBuilder builder = new MessageBuilder();
				Message reply;
				builder.addItalic(NAME + ", lining up! Current version: ");
				builder.addBold("v" + Double.toString(VERSION) + " (" + VERSIONNAME + ")");
				reply = builder.build(API);
				e.getGroup().sendMessage(reply);
			}
		}
		else if(cmd == '+')
		{
			MessageBuilder builder = new MessageBuilder();
			Message reply;
			
			switch(args[0].toLowerCase())
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
					builder.addString("\n+slots : Spin it");
					builder.addString("\n+rot {n} {String} : ROT the message to n.");
					builder.addString("\n+viginere {key} {String} : Decode String with Viginere Cipher using key.");
					builder.addString("```");
					break;
				case "slots":
					builder.addUserTag(e.getUser(), e.getGroup());
					break;
				case "soon":
					builder.addBold("soon");
					break;
				case "robot":
					builder.addItalic("Me robot. Me clever. ");
					builder.addString("***ME SUPERIOR.***\n");
					builder.addItalic("Beep, Boop.");
					break;
				case "rot":
					builder.addString("*From:* ***" + args[2] + "***\n");
					builder.addString("*To:* ***" + Encoder.Rot(args[2], Integer.parseInt(args[1])) + "***\n");
					break;
				case "viginere":
					builder.addString("*From:* ***" + args[2] + "***\n");
					builder.addString("*To:* ***" + Encoder.Viginere(args[2], args[1]) + "***\n");
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
		
		if(rawMessage.contains("@kolpet") && e.getServer().getGroupUserByUsername("kolpet").getUser().getOnlineStatus() == OnlineStatus.OFFLINE)
		{
			MessageBuilder builder = new MessageBuilder();
			builder.addItalic("Sorry, but my master kolpet is offline.");
			Message reply= builder.build(API);
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
}
