import java.text.ParseException;
import java.util.*;

/**
 * La classe Archivo instancia un sistema de gestiÃ³n documental
 *
 * @author Juan Pedro Cerro MartÃ­nez
 * @version 2.0
 */
public class Archivo
{
    // Propiedades se la clase principal
    private String nombre;
    private ArrayList<Coleccion> colecciones;

    /**
     * Constructor por defecto
     */
    public Archivo() throws ParseException {
        this.colecciones=new ArrayList<Coleccion>();
    }

    /**
     * MÃ©todo constructor especÃ­fico de la clase
     *
     * @param pNombre Nombre del archivo
     */
    public Archivo(String pNombre) {
        this.nombre=pNombre;
        this.colecciones=new ArrayList<Coleccion>();
    }

    /**
     * MÃ©todo accesor de la propiedad "nombre"
     *
     * @param
     * @return El nombre con el contenido de la propiedad
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * MÃ©todo instanciador de la propiedad "nombre"
     *
     * @param pNombre Nombre del archivo
     * @return
     */
    public void setNombre(String pNombre) {
        this.nombre=pNombre;
    }

    /**
     * MÃ©todo agregador de una Coleccion a un Archivo
     * @param pColeccion El objeto de una colecciÃ³n del archivo que queremos agregar
     * @return
     */
    public void agregarColeccion(Coleccion pColeccion) {
        if (colecciones.contains(pColeccion)) {
            System.out.println("ERROR ARCHIVO: La colecciÃ³n '"+pColeccion.getNombre()+"'"+" ya estÃ¡ incluida en el archivo '"+this.nombre+"'\n");
        } else {
            this.colecciones.add(pColeccion);
        }
    }

    /**
     * MÃ©todo accesor de la propiedad "colecciones"
     * @param
     * @return El ArrayList con las colecciones del archivo
     */
    public ArrayList<Coleccion> getColecciones() {
        return this.colecciones;
    }

    /**
     * MÃ©todo eliminador de una Coleccion a un Archivo
     * @param pColeccion El objeto de una colecciÃ³n del archivo que queremos eliminar
     * @return
     */
    public void eliminarColeccion(Coleccion pColeccion) {
        if (colecciones.contains(pColeccion)) {
            this.colecciones.remove(pColeccion);
        } else {
            System.out.println("ERROR ARCHIVO: La colecciÃ³n '"+pColeccion.getNombre()+"'"+" NO estÃ¡ asignada al archivo '"+this.nombre+"' y no puede eliminarse\n");
        }
    }
}