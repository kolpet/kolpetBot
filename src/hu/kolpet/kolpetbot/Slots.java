package hu.kolpet.kolpetbot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Random;

import me.itsghost.jdiscord.message.MessageBuilder;
import me.itsghost.jdiscord.talkable.User;

public class Slots {
	private Map<SlotsUser, Long> Gamblers = new HashMap<SlotsUser, Long>();
	private final static int Cooldown = 10000;
	private int SessionLoses = 0;
	private int SessionWins = 0;
	
	public Slots()
	{
		
	}
	
	public void Spin(User u, MessageBuilder builder)
	{
		SlotsUser su;
		if(!contains(u))
		{
			su = new SlotsUser(u.getUsername());
		}
		else
		{
			su = getSlotsUser(u);
			Gamblers.remove(su);
		}
		Gamblers.put(su, System.nanoTime());
		
		String[] faces = {":smile:",":smiley:",":smirk:",":grin:",":grinning:",":wink:",":sunglasses:", ":laughing:", ":disappointed:"};
		Random rand = new Random();
		
		builder.addItalic(" spins the slot machine...\n");
		
		int[] result = {rand.nextInt(faces.length), 
						rand.nextInt(faces.length), 
						rand.nextInt(faces.length)};
		
		builder.addString("**...And its ( " + faces[result[0]] + 
						  " " + faces[result[1]] + 
						  " " + faces[result[2]] + " )** \n");
		
		if(result[0] == result[1] && result[1] == result[2])
		{
			builder.addItalic("Congratulations!");
			su.addWin();
			SessionWins++;
		}
		else
		{
			builder.addItalic("Sorry, but you lost!");
			su.addLoss();
			SessionLoses++;
		}
	}
	
	public void getUserStats(User u, MessageBuilder builder)
	{
		SlotsUser su;
		if(!contains(u))
		{
			builder.addItalic("You haven't played yet!");
		}
		else
		{
			su = getSlotsUser(u);
			builder.addItalic(", here are your stats (for my session):\n");
			builder.addString("* -spins:* **" + (su.getWins() + su.getLoses()) + "**");
			builder.addString("* -wins:* **" + su.getWins() + "**");
			builder.addString("* -loses:* **" + su.getLoses() + "**");
		}
	}
	
	public void getStats(MessageBuilder builder)
	{
		builder.addString(" *, here are the global stats (for my session):*\n");
		builder.addString(" *-spins:* ***" + (SessionWins + SessionLoses) + "***\n");
		builder.addString(" *-wins:* ***" + SessionWins + "***\n");
		builder.addString(" *-loses:* ***" + SessionLoses + "***");
	}
	
	public boolean onCooldown(User u)
	{
		if(contains(u))
			if((System.nanoTime()-getTime(u))/1000000L < Cooldown)
				return true;
		return false;
	}
	
	public boolean contains(User u)
	{
		for(Entry<SlotsUser, Long> entry : Gamblers.entrySet())
		{
			if(entry.getKey().getName() == u.getUsername()) return true;
		}
		return false;
	}
	
	public SlotsUser getSlotsUser(User u)
	{
		for(Entry<SlotsUser, Long> entry : Gamblers.entrySet())
		{
			if(entry.getKey().getName() == u.getUsername()) return entry.getKey();
		}
		return null;
	}
	
	public Long getTime(User u)
	{
		for(Entry<SlotsUser, Long> entry : Gamblers.entrySet())
		{
			if(entry.getKey().getName() == u.getUsername()) return entry.getValue();
		}
		return -1L;
	}
	
	public class SlotsUser
	{
		private String name;
		private int wins = 0;
		private int loses = 0;
		
		public SlotsUser(String name)
		{
			this.name = name;
		}
		
		public String getName() {
			return name;
		}

		public int getWins() {
			return wins;
		}

		public void addWin() {
			wins++;
		}

		public int getLoses() {
			return loses;
		}

		public void addLoss() {
			loses++;
		}
	}
}
