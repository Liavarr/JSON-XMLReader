package xmlTest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LeeJSONGSON {
    public static void main(String[] args) {
        // JSON de ejemplo
        String json = "[{\"nombre\":\"Ana\",\"edad\":22,\"cursos\":[\"Matemáticas\",\"Historia\"]},{\"nombre\":\"Luis\",\"edad\":25,\"cursos\":[\"Física\",\"Química\"]}]";

        // Crear una instancia de Gson
        Gson gson = new Gson();

        // Parsear el JSON a un JsonArray
        JsonArray estudiantes = JsonParser.parseString(json).getAsJsonArray();

        // Imprimir la lista de estudiantes
        imprimirEstudiantes(estudiantes);

        // Agregar un nuevo estudiante
        JsonObject nuevoEstudiante = new JsonObject();
        nuevoEstudiante.addProperty("nombre", "Maria");
        nuevoEstudiante.addProperty("edad", 20);
        JsonArray cursos = new JsonArray();
        cursos.add("Biología");
        cursos.add("Química");
        nuevoEstudiante.add("cursos", cursos);
        estudiantes.add(nuevoEstudiante);

        // Imprimir la lista de estudiantes después de agregar uno nuevo
        System.out.println("\nDespués de agregar un nuevo estudiante:");
        imprimirEstudiantes(estudiantes);

        // Quitar un estudiante (por nombre, por ejemplo)
        quitarEstudiante(estudiantes, "Luis");

        // Imprimir la lista de estudiantes después de quitar uno
        System.out.println("\nDespués de quitar un estudiante:");
        imprimirEstudiantes(estudiantes);
    }

    // Método para imprimir la lista de estudiantes
    private static void imprimirEstudiantes(JsonArray estudiantes) {
        for (JsonElement estudiante : estudiantes) {
            JsonObject obj = estudiante.getAsJsonObject();
            System.out.println("Nombre: " + obj.get("nombre").getAsString());
            System.out.println("Edad: " + obj.get("edad").getAsInt());
            System.out.println("Cursos: " + obj.get("cursos").getAsJsonArray());
            System.out.println();
        }
    }

    // Método para quitar un estudiante por nombre
    private static void quitarEstudiante(JsonArray estudiantes, String nombre) {
        for (int i = 0; i < estudiantes.size(); i++) {
            JsonObject obj = estudiantes.get(i).getAsJsonObject();
            if (obj.get("nombre").getAsString().equals(nombre)) {
                estudiantes.remove(i);
                break;
            }
        }
    }
}
