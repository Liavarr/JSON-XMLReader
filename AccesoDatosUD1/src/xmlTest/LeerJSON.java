package xmlTest;

// Importar las clases de Jackson necesarias para trabajar con JSON
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeerJSON {
    public static void main(String[] args) {
        try {
            // Crear un ObjectMapper para manejar JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Ejemplo de JSON como String (puedes cambiarlo a leer desde un archivo)
            String jsonInput = "{\"nombre\": \"Paco Gomez\", \"edad\": 30}";

            // Leer y parsear el JSON a un árbol de nodos (JsonNode)
            JsonNode rootNode = objectMapper.readTree(jsonInput);

            // Extraer nodos específicos por nombre
            JsonNode nombreNode = rootNode.get("nombre");
            JsonNode edadNode = rootNode.get("edad");

            // Imprimir el contenido de los nodos
            System.out.println("Nombre: " + nombreNode.asText());
            System.out.println("Edad: " + edadNode.asInt());

        } catch (Exception e) {
            e.printStackTrace(); // Manejar excepciones
        }
    }
}
