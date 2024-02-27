import java.awt.*;
import java.awt.event.*;

public class Ventana extends WindowAdapter implements WindowListener{

    public Ventana(String pTitulo){
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

        //Posicionamos lbl5 y autores
        ventana.add(lbl5);
        lbl5.setBounds(250, 300, 125, 30);
        ventana.add(autores);
        autores.setBounds(250, 350, 225, 100);

        //Posicionamos el boton CERRAR
        ventana.add(cerrar);
        cerrar.setBounds(200,475,100,50);





        ventana.addWindowListener(this);
        cerrar.addActionListener(new EventoBoton());
    }

    public void windowClosing(WindowEvent e){
        System.exit(0);
    }

    private class EventoBoton implements ActionListener{
        public void actionPerformed(ActionEvent a){
            System.exit(0);
        }
    }
}
