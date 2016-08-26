package com.botchan.reasoning;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.util.FileManager;

public class KnowledgeBase {
	
	private ArrayList<Model> knowledge_base;
	
	public KnowledgeBase() {
		knowledge_base = new ArrayList<>();
		for (@SuppressWarnings("unused") KnowledgeCategory k : KnowledgeCategory.values()) {
			this.knowledge_base.add(ModelFactory.createDefaultModel());
		}
		try {
			this.loadAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void learn(KnowledgeCategory k, String subject, String predicate, String object) {
		Property p = knowledge_base.get(k.ordinal()).createProperty("http://2huvi/Predicates#", predicate);
		Resource r1 = knowledge_base.get(k.ordinal()).createResource("http://2huvi/Object#"+subject);
		Resource r2 = knowledge_base.get(k.ordinal()).createResource("http://2huvi/Object#"+object);
		Statement statement = knowledge_base.get(k.ordinal()).createStatement(r1, p, r2);
		this.knowledge_base.get(k.ordinal()).add(statement);
		try {
			this.save(k);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String generatePath(KnowledgeCategory category) {
		return "knowledges/"+category.toString().toLowerCase()+".pomf";
	}
	
	public void saveAll() throws IOException {
		for (KnowledgeCategory k : KnowledgeCategory.values()) {
			this.save(k);
		}
	}
	
	public void loadAll() throws IOException {
		for (KnowledgeCategory k : KnowledgeCategory.values()) {
			this.load(k);
		}
	}
	
	public void save(KnowledgeCategory k) throws IOException {
		FileWriter out = new FileWriter(this.generatePath(k));
		try {
		    this.knowledge_base.get(k.ordinal()).write(out, "RDF/XML-ABBREV");
		}
		finally {
		    try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void load(KnowledgeCategory k) {
		String filename = this.generatePath(k);
		InputStream in = FileManager.get().open(filename);
		
		if (in == null) {
		    throw new IllegalArgumentException("File: " + filename + " not found");
		}
		this.knowledge_base.get(k.ordinal()).read(in, null);
	}
	
}
