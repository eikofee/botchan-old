package com.botchan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class SynonymDictionary {
    private LinkedList<Synonym> simpleList;
	
	private LinkedList<Synonym> complexList;

    public SynonymDictionary() {
        this.simpleList = new LinkedList<>();
		this.complexList = new LinkedList<>();
    }

    public SynonymDictionary(String fileName) throws Exception {
        this.simpleList = new LinkedList<>();
		this.complexList = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                String name = line.split(":")[0];
                //String[] synonyms = line.split(":")[1].("(?!\")([^\"])+\\b(?=\")");
				String[] synonyms = line.split(":")[1].split(",");
				AddSynonym(new Synonym(name, synonyms));
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error while reading synonyms file");
        }
    }

    public void AddSynonym(Synonym s) {
		LinkedList<String> xs = new LinkedList<>();
		LinkedList<String> xc = new LinkedList<>();
		for (int i = 0; i < s.getSynonyms().length; i++)
		{
			if (s.getSynonyms()[i].split("[ -]").length > 1)
				xc.add(s.getSynonyms()[i]);
			else
				xs.add(s.getSynonyms()[i]);
		}
		if (xs.size() > 0)
			AddSimpleSynonym(new Synonym(s.getName(), xs.toArray(new String[xs.size()])));
		if (xc.size() > 0)
			AddComplexSynonym(new Synonym(s.getName(), xc.toArray(new String[xc.size()])));

	}

	public void AddSimpleSynonym(Synonym s){
		this.simpleList.add(s);
	}

	public void AddComplexSynonym(Synonym s){
		this.complexList.add(s);
	}

	public String FindComplexPatterns(String s){
		for (int i = 0; i < complexList.size(); i++){
			for (int j = 0; j < complexList.get(i).getSynonyms().length; j++){
				s = s.replace(complexList.get(i).getSynonyms()[j], complexList.get(i).getName());
			}
		}
		return s;
	}

    public String GetMeaningOf(String s) {
        for (int i = 0; i < simpleList.size(); i++) {
            if (simpleList.get(i).Means(s))
                return simpleList.get(i).getName();
        }
        return s;
    }

	public String GetSynonymOf(String s){
		for (int i = 0; i < simpleList.size(); i++)
		{
			if (simpleList.get(i).getName().equals(s))
			{
				int r = (int) Math.floor(Math.random() *10 );
				return simpleList.get(i).getSynonyms()[r % simpleList.get(i).getSynonyms().length];
			}
		}
		return s;
	}
	public String GetSynonymOfUsingComplexes(String s){
		LinkedList<String> results = new LinkedList<>();
		for (int i = 0; i < simpleList.size(); i++)
		{
			if (simpleList.get(i).getName().equals(s))
			{
				for (int j = 0; j < simpleList.get(i).getSynonyms().length; j++)
				{
					results.add(simpleList.get(i).getSynonyms()[j]);
				}
			}
		}
		for (int i = 0; i < complexList.size(); i++)
		{
			if (complexList.get(i).getName().equals(s))
			{
				for (int j = 0; j < complexList.get(i).getSynonyms().length; j++)
				{
					results.add(complexList.get(i).getSynonyms()[j]);
				}
			}
		}
		if (results.size() > 0)
		{
			int i = (int) Math.floor(Math.random()) % results.size();
			return results.get(i);
		}
		return s;
	}

	public String Naturalize(String pattern) {
		for (int i = 0; i < simpleList.size(); i++)
		{
			pattern = pattern.replace(simpleList.get(i).getName(), GetSynonymOf(simpleList.get(i).getName()));
		}
		return pattern;
	}
	public String NaturalizeUsingComplexes(String pattern) {
		for (int i = 0; i < simpleList.size(); i++)
		{
			pattern = pattern.replace(simpleList.get(i).getName(), GetSynonymOfUsingComplexes(simpleList.get(i).getName()));
		}
		return pattern;
	}
}
