import java.util.ArrayList;

/**
 * La clase Publicacion instancia una publicacion de un/varios autor(es)
 *
 * @author Carmen de los Angeles Camacho Tejada
 * @version 1.0
 */
public abstract class Publicacion {

    /**
     * Propiedades de la clase principal
     */
    protected String titulo;
    protected boolean bestseller;
    protected Departamento departamento;
    protected ArrayList<Autor> autorias = new ArrayList<Autor>();

    /**
     * Metodo constructor de la clase
     */
    public Publicacion(String titulo, boolean bestseller, Departamento departamento){
        this.titulo = titulo;
        this.bestseller = bestseller;
        this.departamento = departamento;
    }

    /**
     * Metodo accesor de titulo
     * @return string
     */
    protected String getTitulo(){return titulo;}

    /**
     * Metodo instaciador de titulo
     * @param titulo
     */
    protected void setTitulo(String titulo){this.titulo = titulo;}

    /**
     * Metodo accesor de esBestSeller
     * @return boolean
     */
    protected boolean esBestseller(){return bestseller;}

    /**
     * Metodo instaciador de esBestSeller
     * @param esBestseller
     */
    protected void setBestseller(boolean esBestseller){this.bestseller = esBestseller;}

    /**
     * Metodo accesor de departamento
     * @return departamento
     */
    protected Departamento getDepartamento(){return departamento;}

    /**
     * Metodo instaciador de departamento
     * @param departamento
     */
    protected void setDepartamento(Departamento departamento){this.departamento = departamento;}

    /**ç
     * Metodo accesor de las autorias de una publicacion
     * @return array
     */
    protected ArrayList<Autor> getAutorias(){return autorias;}

    /**
     * Metodo para agregar un autor a las autorias de una publicacion
     * @param autor
     */
    protected void agregarAutor(Autor autor){
        if (this.autorias.contains(autor)){
            System.out.println(" ERROR PUBLICACION: El autor/a " + autor.getNombreCompleto() + " ya esta asignado a la publicaion "+ this.titulo );
        } else{
            this.autorias.add(autor);
        }
    }

    /**
     * Metodo para eliminar un autor de las autorias de una publicacion
     * @param autor
     */
    protected void eliminarAutor(Autor autor){
        if (!this.autorias.contains(autor)){
            System.out.println("ERROR PUBLICACION: El autor/a " + autor.getNombreCompleto() + " NO esta asignado a la publicaion "+ this.titulo + " y no puede eliminarse" );
        } else {
            this.autorias.remove(autor);
        }
    }

    /**
     * Metodo abstracto para determinar le descripcion de la publicacion; DocumentoPapel o DocumentoElectronico
     * @return String
     */
    protected abstract String getDescripcion();
}
