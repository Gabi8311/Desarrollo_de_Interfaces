package ejercicio_15_XML;
/**
 *
 * @author Gabriel Moreno
 */
public class Cliente {
    private String NIF;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    
    public Cliente(){
        
    }

    public Cliente(String NIF, String nombre, String direccion, String ciudad, String telefono) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getNIF() {
        return NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
