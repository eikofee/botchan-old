package com.botchan;

public class Synonym {
    private String name;
    private String[] synonyms;

    public Synonym(String name, String[] synonyms)
    {
        this.setName(name);
        this.setSynonyms(synonyms);
    }

    public boolean Means (String s)
    {
        for (int i = 0; i < synonyms.length; i++)
        {
            if (synonyms[i].equals(s))
                return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }
}