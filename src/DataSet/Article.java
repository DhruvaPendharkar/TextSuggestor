package DataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhruv on 2/14/2018.
 */
public class Article {

    private String title;
    private int id;
    private List<Passage> passages = new ArrayList<>();

    private Article(int id, String title, List<Passage> passages) {
        this.id = id;
        this.title = title;
        this.passages = passages;
    }

    public static Article CreateArticle(int id, JSONObject object) throws JSONException {
        if(object == null) return null;
        String title = object.getString("title");
        JSONArray paragraphArrays = object.getJSONArray("paragraphs");
        List<Passage> passages = new ArrayList<>();
        for(int i=0;i<paragraphArrays.length();i++){
            object = paragraphArrays.getJSONObject(i);
            Passage passage = Passage.CreatePassage(i+1, object);
            passages.add(passage);
        }

        Article article = new Article(id, title, passages);
        return article;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //builder.append(String.format("DataSet.Article : %s\n", this.title));
        for(Passage passage : passages) {
            builder.append(passage);
        }

        return builder.toString();
    }
}
