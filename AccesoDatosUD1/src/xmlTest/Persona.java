package xmlTest;

import javax.xml.bind.annotation.XmlAttribute; 

import javax.xml.bind.annotation.XmlElement; 

import javax.xml.bind.annotation.XmlRootElement; 

import javax.xml.bind.annotation.XmlTransient; 

@XmlRootElement // Define la clase como el elemento raíz del documento XML 

public class Persona { 

    private int id; 

    private String nombre; 
    
    private String apellido;

    private String clave; 

    // Constructor con parámetros 

    public Persona(int id, String nombre, String apellido, String clave) { 

        this.id = id; 

        this.nombre = nombre; 

        this.apellido = apellido; 

        this.clave = clave; 

    } 

 

 

    @XmlAttribute // Mapea el campo id a un atributo del elemento XML 

    public int getId() {        return id;    } 

    public void setId(int id) {        this.id = id;    } 

 

    @XmlElement // Mapea el campo nombre a un elemento XML 

    public String getNombre() {        return nombre;    } 

    public void setNombre(String nombre) {        this.nombre = nombre;    } 

 

    @XmlTransient // Indica que el campo clave no debe ser incluido en el XML 

    public String getClave() {        return clave;    } 

    public void setClave(String clave) {        this.clave = clave;    

} 

} 