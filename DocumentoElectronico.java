/**
 * La clase DocumentoElectronico instancia un documento electronico que pertenece a las publicaciones de un/a autor
 *
 * @author Carmen de los Angeles Camacho Tejada
 * @version 1.0
 */

public class DocumentoElectronico extends Publicacion{

    /**
     * Propiedades de la clase principal
     */
    private long pesoKb;
    private String uri;

    /**
     * Metodo constructor de la clase
     */
    public DocumentoElectronico(String titulo, boolean bestseller, Departamento departamento, long pesoKb, String uri) {
        super(titulo, bestseller, departamento);
        this.pesoKb = pesoKb;
        this.uri = uri;
    }

    /**
     * Metodo accesor de pesoKB
     * @return long
     */
    public long getPesoKb() {
        return pesoKb;
    }

    /**
     * Metodo instaciador de pesoKB
     * @param pesoKb
     */
    public void setPesoKb(long pesoKb) {
        this.pesoKb = pesoKb;
    }

    /**
     * Metodo accesor de uri
     * @return string
     */
    public String getUri() {
        return uri;
    }

    /**
     * Metodo instaciador de uri
     * @param uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Metodo que describe las propiedades del Documento electronico
     * @return
     */
    public String getDescripcion(){
        return "Publicación de " + pesoKb + " Kb de espacio en disco titulada " + titulo + " custodiada por el Dpto. " + departamento.getNombre();
    }
}