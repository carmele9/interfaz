/**
 * La clase DocumentoPapel instancia un documento de papel  perteneciente a las publicaciones de un/a autor
 *
 * @author Carmen de los Angeles Camacho Tejada
 * @version 1.0
 */

public class DocumentoPapel extends Publicacion{

    /**
     * Propiedades de la clase principal
     */
    private int numPaginas;
    private boolean color;


    /**
     * Metodo constructor de la clase
     */
    public DocumentoPapel(String titulo, boolean bestseller, Departamento departamento, int numPaginas, boolean color) {
        super(titulo, bestseller, departamento);
        this.numPaginas = numPaginas;
        this.color = color;
    }

    /**
     * Metodo accesor de numPaginas
     * @return int
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     * Metodo instaciador de numPaginas
     * @param numPaginas
     */
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    /**
     * Metodo accesor de esColor
     * @return boolean
     */
    public boolean esColor() {
        return color;
    }

    /**
     * Metodo accesor de esColor
     * @param color
     */
    public void setColor(boolean color) {
        this.color = color;
    }

    /**
     * Metodo que establece la descripcion de un Documento de Papel
     * @return string
     */
    public String getDescripcion(){
        if (esBestseller()){
            return "Publicación bestseller en B/N titulada " + titulo + " custodiada por el Dpto. " + departamento.getNombre();
        }
        return "Publicación titulada " + titulo + " custodiada por el Dpto. " + departamento.getNombre();
    }
}
