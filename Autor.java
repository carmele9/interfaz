import java.text.ParseException;
import java.util.ArrayList;

    /**
     * La clase Autor instancia un autor que tendra publicaciones
     *
     * @author Carmen de los Angeles Camacho Tejada
     * @version 1.0
     */
    public class Autor extends Persona {

        /**
         * Propiedades de la clase principal
         */

        private boolean esFamoso;
        private String fichaAutorUrl;
        private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

        /**
         * Metodo constructor de la clase
         */
        public Autor(String pNombreCompleto, char pSexo, String pFechaNacimiento, int pTelefono, String pCorreoElectronico, boolean esFamoso) throws ParseException {
            super(pNombreCompleto, pSexo, pFechaNacimiento, pTelefono, pCorreoElectronico);
            this.esFamoso = esFamoso;
        }

        /**
         * Metodo accesor de esFamoso
         * @return boolean
         */
        public boolean esFamoso() {
            return esFamoso;
        }

        /**
         * Metodo instaciador de esFamoso
         * @param esFamoso
         */
        public void setFamoso(boolean esFamoso) {
            this.esFamoso = esFamoso;
        }

        /**
         * Metodo accesor de fichaAutorUrl
         * @return string
         */
        public String getFichaAutorUrl() {
            return fichaAutorUrl;
        }

        /**
         * Metodo instaciador de fichaAutorUrl
         * @param fichaAutorUrl
         */
        public void setFichaAutorUrl(String fichaAutorUrl) {
            this.fichaAutorUrl = fichaAutorUrl;
        }

        /**
         * Metodo para agregar una publicacion a las publicaciones del autor
         * @param publicacion
         */
        public void agregarPublicacion(Publicacion publicacion) {
            if (this.publicaciones.contains(publicacion)){
                System.out.println("ERROR AUTOR: La publicacion " + publicacion.getTitulo() + " ya esta asignada al autor/a "+ this.nombreCompleto);
            } else {
                this.publicaciones.add(publicacion);
            }

        }

        /**
         * Metodo para eliminar una publicacion de las publicaciones del autor
         * @param publicacion
         */
        public void eliminarPublicacion(Publicacion publicacion){
            if (!this.publicaciones.contains(publicacion)){
                System.out.println("ERROR AUTOR: La publicacion " + publicacion.getTitulo() + " NO esta asignada al autor/a "+ this.nombreCompleto + " y no puede eliminarse");
            } else{
                this.publicaciones.remove(publicacion);
            }
        }

        /**
         * Metodo accesor a la lista de publicaciones del autor
         * @return
         */
        public ArrayList<Publicacion> getPublicaciones() {
            return publicaciones;
        }

        /**
         * Metodo para mostrar por pantalla todos los detales de cada una de las publicaciones del autor
         * @return
         */
        public String listarPublicaciones(){
            StringBuilder listado = new StringBuilder();
            listado.append("Listado de publicaciones de ").append(nombreCompleto).append(":\n");
            for (Publicacion publicacion : publicaciones) {
                listado.append(publicacion.getTitulo()).append(" ");
                if (publicacion instanceof DocumentoPapel){
                    listado.append(((DocumentoPapel) publicacion).getNumPaginas()).append(" paginas \n");
                }
                else{
                    listado.append(((DocumentoElectronico) publicacion).getPesoKb()).append(" kilobytes \n");
                }
            }
            return listado.toString();
        }


    }

