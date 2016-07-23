package com.botchan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class SynonymDictionary {
    private LinkedList<Synonym> list;

    public SynonymDictionary() {
        this.list = new LinkedList<>();
    }

    public SynonymDictionary(String fileName) throws Exception {
        this.list = new LinkedList<>();
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
        this.list.add(s);
    }

    public String GetMeaningOf(String s) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).Means(s))
                return list.get(i).getName();
        }
        return s;
    }

    public String GetSynonymOf(String s){
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equals(s))
            {
                int r = (int) Math.random();
                return list.get(i).getSynonyms()[r % list.get(i).getSynonyms().length];
            }
        }
        return s;
    }
}
