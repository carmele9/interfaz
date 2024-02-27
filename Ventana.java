import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ventana extends WindowAdapter implements WindowListener{

    public Ventana(String pTitulo, Archivo archivo) {
        //Establecemos la ventana y la hacemos visible
        Frame ventana = new Frame(pTitulo);
        ventana.setVisible(true);
        ventana.setResizable(false);

        //Damos formato a la ventana
        int x = Toolkit.getDefaultToolkit().getScreenSize().width;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height;
        ventana.setBounds(x/2 - 200, y/2 - 300, 500, 600);
        BorderLayout layout = new BorderLayout();
        ventana.setLayout(layout);

        //Establecemos las variables
        Label lbl1 = new Label("Bienvenid@ al Sistema de Gestión Documental");
        Label lbl2 = new Label("Escoge una opcion: ");
        Choice choice = new Choice();
        Label lbl3 = new Label("Publicaciones: ");
        List listaPublicaciones = new List();
        Label lbl4 = new Label("Descripcion: ");
        TextArea descripcion = new TextArea();
        Label lbl5 = new Label("Autores: ");
        TextArea autores = new TextArea();
        Button cerrar = new Button("CERRAR");

        //Posicionamos lbl1 y añadimos formato
        ventana.add(lbl1);
        lbl1.setBounds(20, 30, 400, 30);
        lbl1.setFont( new Font( "Helvetica", Font.BOLD, 12 ) );
        lbl1.setForeground(Color.RED);

        //Posicionamos lbl2 y choice
        ventana.add(lbl2);
        lbl2.setBounds(20, 80, 125,30);
        ventana.add(choice);
        choice.setBounds(200, 80, 250, 30);

        //Posicionamos lbl3 y listaPublicaciones
        ventana.add(lbl3);
        lbl3.setBounds(20, 130, 125, 30);
        ventana.add(listaPublicaciones);
        listaPublicaciones.setBounds(20, 170, 450, 100 );

        //Posicionamos lbl4 y descripcion
        ventana.add(lbl4);
        lbl4.setBounds(20, 300, 125, 30);
        ventana.add(descripcion);
        descripcion.setBounds(20, 350, 225, 100);
        descripcion.setEditable(false);

        //Posicionamos lbl5 y autores
        ventana.add(lbl5);
        lbl5.setBounds(250, 300, 125, 30);
        ventana.add(autores);
        autores.setBounds(250, 350, 225, 100);
        autores.setEditable(false);

        //Posicionamos el boton CERRAR
        ventana.add(cerrar);
        cerrar.setBounds(200,475,100,50);

        //Añadimos las colecciones a choice
        for (Coleccion coleccion : archivo.getColecciones()) {
            choice.add(coleccion.getNombre());
        }

        //Metodo para salirnos de la ventana
        ventana.addWindowListener(this);
        //Metodo para activar el buton cerrar
        cerrar.addActionListener(new EventoBoton());
        //Metodo para mostrar las respectivas publicaciones de una coleccion
        choice.addItemListener(new PublicacionesColeccion(archivo, choice, listaPublicaciones));
    }

    //Metodo para salirnos de la ventana
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }

    /**
     * Establecemos una clase para poder usar el boton
     */
    private class EventoBoton implements ActionListener{
        public void actionPerformed(ActionEvent a){
            System.exit(0);
        }
    }

    /**
     * Creamos clase para mostrar las publicaciones de una coleccion
     */

    private class PublicacionesColeccion implements ItemListener {

        /**
         * Establecemos las variables
         */
        Choice eleccion;
        List publicationList;
        Archivo archivo;

        /**
         * Definimos el constructor de la clase
         */
        public PublicacionesColeccion(Archivo archivo, Choice choice, List publication) {
            this.eleccion = choice;
            this.publicationList = publication;
            this.archivo = archivo;
        }

        /**
         * Establecemos el metodo para mostrar el cambio en la seleccion de choice
         *
         * @param e the event to be processed
         */

        public void itemStateChanged(ItemEvent e) {
            publicationList.removeAll();
            String coleccionSeleccionada = eleccion.getSelectedItem();
            for (Coleccion coleccion : archivo.getColecciones()) {
                ArrayList<Publicacion> pub = null;
                if (coleccion.getNombre().equals(coleccionSeleccionada)) {
                    pub = coleccion.getPublicaciones();
                }
                if (pub != null) {
                    for (Publicacion publicacion : pub) {
                        publicationList.add(publicacion.getTitulo());
                    }
                }

            }
        }

    }


}
