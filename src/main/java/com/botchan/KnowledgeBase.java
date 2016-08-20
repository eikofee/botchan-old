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
	private ArrayList<ArrayList<Fact>> global_knowledges; // See KnowledgeType.java for indices
	
	public KnowledgeBase() {
		this.global_knowledges = new ArrayList<>();
		for (@SuppressWarnings("unused") KnowledgeType t : KnowledgeType.values())
			this.global_knowledges.add(new ArrayList<Fact>());
	}
	
	public void learnFact(Fact f, KnowledgeType t) {
		this.global_knowledges.get(t.ordinal()).add(f);
	}

	public void rememberFact() {
		try {
			FileOutputStream fout = new FileOutputStream(KnowledgeBase.path);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this.global_knowledges);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void retriveKnowledge() {
		ArrayList<ArrayList<Fact>> global_knowledges = new ArrayList<>();
		try {
			FileInputStream fin = new FileInputStream(KnowledgeBase.path);
			ObjectInputStream ois = new ObjectInputStream(fin);
			global_knowledges = (ArrayList<ArrayList<Fact>>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.global_knowledges = global_knowledges;
	}
}
