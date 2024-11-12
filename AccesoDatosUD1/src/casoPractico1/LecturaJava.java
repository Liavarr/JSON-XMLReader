package casoPractico1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaJava {
    public static void leerfichero(String ruta) {
        String salida="";
        FileReader fr = null;
        BufferedReader br = null;
        try {
        	fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            int cuentaLineas = 0;
            //lectura del fichero mediante bucle while
            while((salida = br.readLine())!=null) {
            	cuentaLineas++;
            	System.out.println(salida+" --> "+salida.length());
            }
            System.out.println("El archivo tiene "+cuentaLineas+" lineas.");
            
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo, error: "+e);
		} catch (IOException e){
			System.out.println("Ha ocurrido un error de lectura/escritura, error:"+e);
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        

    }

     public static void main(String[] args) throws IOException {
     //llamamos a leerfichero con la ruta donde se encuentra

     leerfichero("c://prueba.txt");

     }
}
