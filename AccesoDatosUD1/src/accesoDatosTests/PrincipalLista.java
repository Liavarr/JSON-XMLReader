package accesoDatosTests;

import java.io.*;
import java.util.Scanner;

public class PrincipalLista {

    public static void main(String[] args) 
            throws IOException, ClassNotFoundException {

        Lista lista = new Lista(5);  // Supongo que Lista es una clase definida por ti
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos
        System.out.println("Introduce las unidades recibidas (-1 para finalizar): ");                    
        int numero = scanner.nextInt();
        while (numero >= 0) {
            scanner.nextLine();  // Consumir el salto de línea
            System.out.println("Introduce el nombre del producto: ");                    
            String producto = scanner.nextLine();
            lista.nuevoProducto(producto, numero);  // Supongo que tienes este método en Lista
            System.out.println("Introduce las unidades recibidas (-1 para finalizar): ");                    
            numero = scanner.nextInt();
        }

        // Escritura del objeto y string en el archivo
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("media.obj"))) {
            salida.writeObject("guardar este string y un objeto\n");
            salida.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();  // Manejo de excepciones de escritura
        }

        // Lectura del objeto y string del archivo
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("media.obj"))) {
            String str = (String) entrada.readObject();
            Lista obj1 = (Lista) entrada.readObject();
            System.out.println("Texto leído: " + str);
            System.out.println("Objeto Lista leído: " + obj1);  // Requiere que Lista implemente `toString()`
            lista.mostrarObjeto();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();  // Manejo de excepciones de lectura
        }

        scanner.close();
    }
}
