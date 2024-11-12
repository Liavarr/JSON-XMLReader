package accesoDatosTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Archivos {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String rutaOrigen = "textoorigen.txt";
		String rutaDestino = "textodestino.txt";
		try {
			File miarchivo = new File (rutaOrigen);
			boolean valor = miarchivo.canRead();
			//miarchivo.createNewFile();
			System.out.println(valor);

		} catch (Exception e) {
			System.out.println("No se puede abrir el archivo: "+e);
		}
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(rutaOrigen);
			out = new FileOutputStream (rutaDestino);
			int b;
			while ((b=in.read()) != -1) {
			    out.write(b); //Imprimimos el byte como carácter
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error de L/E"+e);
		}finally {
			if (in!=null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (out!=null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		LeerFicheroBytes (rutaOrigen);
		
		EscribirDatos (rutaOrigen);
		
	}
	
	public static void LeerFicheroBytes(String ruta) {
		FileInputStream leerArchivo = null;
		try {
			leerArchivo = new FileInputStream(ruta);
			int b;
			while ((b = leerArchivo.read())!= -1) {
				System.out.println(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				leerArchivo.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void EscribirDatos(String ruta) {
		RandomAccessFile archivo = null;
		System.out.println("Escribe la cantidad deseada:");
		int valor = sc.nextInt();
		
		
		
		try {
			archivo = new RandomAccessFile(ruta, "rw");
			System.out.println("Fichero antes:");
			LeerFicheroBytes(ruta);
			
			archivo.seek(archivo.length());
			archivo.writeInt(valor);
			
			System.out.println("Fichero despues:");
			LeerFicheroBytes(ruta);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
