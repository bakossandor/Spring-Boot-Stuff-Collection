import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonTest {

    public static void main(String[] args) throws JsonProcessingException {

        String source = "{ \"title\": \"This is the title\", \"description\": \"This is the description\" }";

        JsonNode node = Json.parse(source);
        System.out.println(node.get("title").asText());

        Film first = Json.toPojo(node, Film.class);
        System.out.println(first.getTitle());

        Film second = new Film();
        second.setTitle("Second film");

        JsonNode node2 = Json.toJson(second);
        System.out.println(node2.get("title").asText());

        System.out.println(Json.stringify(node2));

    }

}
