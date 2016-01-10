package hu.kolpet.kolpetbot;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import me.itsghost.jdiscord.message.MessageBuilder;
import me.itsghost.jdiscord.talkable.User;

public class Slots {
	private Map<SlotsUser, Long> Gamblers = new HashMap<SlotsUser, Long>();
	private final static int Cooldown = 5000;
	
	public Slots()
	{
		
	}
	
	public MessageBuilder Spin(User u, MessageBuilder builder)
	{
		SlotsUser su;
		if(!contains(u))
		{
			su = new SlotsUser(u);
			Gamblers.put(su, System.nanoTime());
		}
		else
		{
			su = getSlotsUser(u);
		}
		
		String[] faces = {":)",":D",";)",":P",":o",":(","8-)", ":')", ":'("};
		Random rand = new Random();
		builder.addItalic(" spins the slot machine...");
		
		int[] result = {rand.nextInt(faces.length), 
						rand.nextInt(faces.length), 
						rand.nextInt(faces.length)};
		
		builder.addItalic("...And its " + faces[result[0]] + 
						  " : " + faces[result[1]] + 
						  " : " + faces[result[2]]);
		
		if(result[0] == result[1] && result[1] == result[2])
		{
			builder.addItalic("Congratulations!");
		}
		
		return builder;
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
			if(entry.getKey().getUser() == u) return true;
		}
		return false;
	}
	
	public SlotsUser getSlotsUser(User u)
	{
		for(Entry<SlotsUser, Long> entry : Gamblers.entrySet())
		{
			if(entry.getKey().getUser() == u) return entry.getKey();
		}
		return null;
	}
	
	public Long getTime(User u)
	{
		for(Entry<SlotsUser, Long> entry : Gamblers.entrySet())
		{
			if(entry.getKey().getUser() == u) return entry.getValue();
		}
		return -1L;
	}
	
	public class SlotsUser
	{
		private User user;
		private int spins = 0;
		private int wins = 0;
		private int losses = 0;
		
		public SlotsUser(User u)
		{
			user = u;
		}
		
		public User getUser() {
			return user;
		}

		public int getSpins() {
			return spins;
		}

		public int getWins() {
			return wins;
		}

		public void addWin() {
			wins++;
		}

		public int getLosses() {
			return losses;
		}

		public void addLoss() {
			losses++;
		}
	}
}
