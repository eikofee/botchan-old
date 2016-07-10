import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

/**
 * Created by Echoffee on 11/07/2016.
 */
public class SynonymDictionary {
    private LinkedList<Synonym> list;

    public SynonymDictionary() {
        this.list = new LinkedList<>();
    }

    public SynonymDictionary(String fileName) throws Exception {
        this.list = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("synonyms.txt"));
            String line = br.readLine();
            while (line != null) {
                String name = line.split(":")[0];
                String[] synonyms = line.split(":")[1].split("(?!\")([^\"])+\\b(?=\")");
                AddSynonym(new Synonym(name, synonyms));
                line = br.readLine();
            }
        } catch (Exception e) {
            throw new Exception("Error while reading synonyms file");
        }
    }

    public void AddSynonym(Synonym s)
    {
        this.list.add(s);
    }
}
