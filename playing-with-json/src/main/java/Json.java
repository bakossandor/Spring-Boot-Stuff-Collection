import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Json {
    private static ObjectMapper objectmapper = defaultObjectMapper();

    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectmapper.readTree(src);
    }

    public static <T> T toPojo(JsonNode node, Class<T> classs) throws JsonProcessingException {
        return objectmapper.treeToValue(node, classs);
    }

    public static JsonNode toJson(Object a) {
        return objectmapper.valueToTree(a);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        ObjectWriter objectWriter = objectmapper.writer();
        return objectWriter.writeValueAsString(node);
    }

}
