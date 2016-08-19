package com.botchan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class KnowledgeBase {
	
	private final static String path = "knowledges.pomf";
	private ArrayList<Fact> knowledges;
	
	public KnowledgeBase() {
		this.knowledges = new ArrayList<>();
	}
	
	public void learnFact(Fact f) {
		this.knowledges.add(f);
	}

	public void rememberFact() {
		try {
			FileOutputStream fout = new FileOutputStream(KnowledgeBase.path);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this.knowledges);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void retriveKnowledge() {
		ArrayList<Fact> knowledges = new ArrayList<>();
		try {
			FileInputStream fin = new FileInputStream(KnowledgeBase.path);
			ObjectInputStream ois = new ObjectInputStream(fin);
			knowledges = (ArrayList<Fact>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.knowledges = knowledges;
	}
}
