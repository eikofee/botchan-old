package com.botchan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RelationEngine {
	
	// Affection steps
	private static int neutral_threshold = 0;
	private static int like_threshold = 50;
	private static int dislike_threshold = -50;
	private static int friend_threshold = 100;
	private static int love_threshold = 200;
	private static int hate_threshold = -200;
	
	private final static String path = "relations.pomf";
	private ArrayList<Person> acquaintances;
	
	public RelationEngine() {
		acquaintances = new ArrayList<Person>();
	}
	
	public void meet(String discordTag) {
		acquaintances.add(new Person(discordTag));
	}
	
	public void rememberRelations() {
		try {
			FileOutputStream fout = new FileOutputStream(RelationEngine.path);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this.acquaintances);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadRelations() {
		ArrayList<Person> acquaintances = new ArrayList<>();
		try {
			FileInputStream fin = new FileInputStream(RelationEngine.path);
			ObjectInputStream ois = new ObjectInputStream(fin);
			acquaintances = (ArrayList<Person>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.acquaintances = acquaintances;
	}
	
	// Relational updates
	
	public void strenghen_link(String discordTag, int amount) {
		for (Person p : this.acquaintances) {
			if (p.getIdentifier().equals(discordTag))
				p.setLink_strength(p.getLink_strength()+amount);
		}
	}

}
