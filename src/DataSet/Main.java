package DataSet;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        String jsonDataPath = "C:\\Users\\dhruv\\Desktop\\Research\\thesis-material\\QADataset\\dataset\\dev-v1.1.json";
        List<Article> articles = Dataset.ReadDataset(jsonDataPath);
        for(Article article : articles) {
            System.out.println(article);
            break;
        }
    }
}
