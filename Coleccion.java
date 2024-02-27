import java.util.ArrayList;
/**
 * La clase Coleccion instancia una coleccion de publicaciones de un/varios autor(es)
 *
 * @author Carmen de los Angeles Camacho Tejada
 * @version 1.0
 */

public class Coleccion {

    /**
     * Propiedades de la clase principal
     */

    private String nombre;
    private String descripcion;

    private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

    public int numPublicaciones;

    /**
     * Metodo constructor de la clase
     */
    public Coleccion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Metodo accesor del nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo instaciador del nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo accesor de la descripcion (con formato)
     * @return nombre
     */
    public String getDescripcion() {
        return nombre + " con un total de " + numPublicaciones;
    }

    /**
     * Metodo instaciador de la descripcion
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Metodo accesor de las publicaciones
     * @return publicaciones
     */
    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    /**
     * Metodo accesor del num de las publicaciones
     * @return numPublicaciones
     */
    public int getNumPublicaciones() {
        return numPublicaciones;
    }

    /**
     * Metodo para agregar publicaciones a la coleccion
     * @param publicacion
     */
    public void agregarPublicacion(Publicacion publicacion) {
        if (this.publicaciones.contains(publicacion)){
            System.out.println("ERROR COLECCION: La publicacion " + publicacion.getTitulo() + " ya esta asignada a la coleccion "+ this.nombre);
        } else {
            this.publicaciones.add(publicacion);
            numPublicaciones++;
        }

    }

    /**
     * Metodo para eliminar publicaciones de la coleccion
     * @param publicacion
     */

    public void eliminarPublicacion(Publicacion publicacion){
        if (!this.publicaciones.contains(publicacion)){
            System.out.println("ERROR COLECCION: La publicacion " + publicacion.getTitulo() + " NO esta asignada a la coleccion "+ this.nombre + " y no puede eliminarse");
        } else{
            this.publicaciones.remove(publicacion);
            numPublicaciones--;
        }
    }

    /**
     * Metodo para mostrar los detalles de cada una de las publicaciones de la coleción
     * @return string
     */

    public String listarDetallePublicaciones(){
        StringBuilder listadoPublicaciones = new StringBuilder();
        listadoPublicaciones.append("Detalles de la coleccion ").append(getDescripcion()).append('\n');;
        for (Publicacion publicacion : this.publicaciones){
            if (publicacion instanceof DocumentoElectronico){
                listadoPublicaciones.append("Detalles de la publicacion ").append(publicacion.getTitulo()).append(" en formato digital").append('\n');;
            }
            else{
                listadoPublicaciones.append("Detalles de la publicacion ").append(publicacion.getTitulo()).append(" en formato papel").append('\n');

            }
            listadoPublicaciones.append("Autorias -> ");
            for (Autor autor : publicacion.getAutorias()){
                listadoPublicaciones.append("'").append(autor.getNombreCompleto()).append("'");
            }
            listadoPublicaciones.append('\n');
            listadoPublicaciones.append("Responsable custodia -> ").append(publicacion.getDepartamento().getResponsable().getNombreCompleto()).append('\n');
        }
        return listadoPublicaciones.toString();
    }

}
