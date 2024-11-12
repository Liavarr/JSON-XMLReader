package accesoDatosTests;

public class Lista implements java.io.Serializable {
	private int[] cantidadProductos;
	private String[] listaProductos;
	private int numMax,contadorProducto;


	public Lista (int productosAlmacenar) {
		this.listaProductos = new String[productosAlmacenar];
		this.cantidadProductos = new int[productosAlmacenar];
		numMax= productosAlmacenar;
		contadorProducto=1;
	}

	public int  nuevoProducto(String producto, int cantidad){
		if(contadorProducto< numMax){
		  this.cantidadProductos[contadorProducto-1] = cantidad;
		  this.listaProductos [contadorProducto-1] = producto;
		  contadorProducto++;
		  return cantidad;
		}else{
		  return -1;
		}

	}
	
	public void mostrarObjeto() {
		System.out.println("Este objeto tiene: "+this.cantidadProductos+"y es: "+this.listaProductos);
	}

}
