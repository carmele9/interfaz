import java.text.ParseException;

/**
 * Clase ArchivoAWT - Esta clase instancia la interfaz del sistema de gestiÃ³n documental
 *
 * @author Juan Pedro Cerro MartÃ­nez
 * @version 13/03/2022
 */
public class ArchivoAWT {
    public static void main( String args[] ) throws ParseException {
        // CreaciÃ³n del Sistema de GestiÃ³n Documental
        Archivo archivoGui=new Archivo();
        archivoGui.setNombre("Archivo documental Carlemany");

        // En primer lugar damos de alta a todos los trabajadores de la organizaciÃ³n
        Trabajador trabajador1= new Trabajador("Elisabeth LÃ³pez Mur",'M',"11/05/1976",930000001,"elisabeth@carlemany.edu",null,(float)1700.00,"01/01/2022",false,"11223344556");
        Trabajador trabajador2= new Trabajador("RaÃºl Soria GarcÃ­a",'H',"10/10/1983",930000002,"raul.soria@carlemany.edu",null,(float)1430.00,"10/04/2021",false,"11223344557");
        Trabajador trabajador3= new Trabajador("MÂª Elena PÃ©rez Alhoma",'M',"21/08/1990",930000003,"elena.perez@carlemany.edu",null,(float)2200.00,"23/09/2020",false,"11223344558");
        Trabajador trabajador4= new Trabajador("Manuel Einstein RuÃ­z",'H',"03/03/1967",930000004,"manuel.einstein@carlemany.edu",null,(float)1950.00,"16/03/2021",false,"11223344559");
        Trabajador trabajador5= new Trabajador("Ana MÂª Ãvila MegÃ­a",'M',"19/05/1986",930000005,"ana.avila@carlemany.edu",null,(float)1630.00,"10/11/2020",false,"11223344560");

        // A continuaciÃ³n, creamos los diferentes departamentos de la organizaciÃ³n
        Departamento direccion=new Departamento("DirecciÃ³n","DirecciÃ³n general de la organizaciÃ³n", null, null);
        Departamento administracion=new Departamento("AdministraciÃ³n", "Departamento de soporte administrativo de la organizaciÃ³n",null, null);
        Departamento comercial=new Departamento("Comercial", "Departamento encargado de las funciones comerciales de la organizaciÃ³n",null, null);

        // Asignamos dependencias entre departamentos
        administracion.setDependencia(direccion);
        comercial.setDependencia(administracion);

        // Definimos los responsables de cada departamento
        direccion.setResponsable(trabajador1);
        administracion.setResponsable(trabajador3);
        comercial.setResponsable(trabajador2);
        comercial.setResponsable(trabajador5);

        // Asignamos los trabajadores a sus respectivos departamentos
        trabajador1.setDepartamento(direccion);
        trabajador2.setDepartamento(administracion);
        trabajador3.setDepartamento(administracion);
        trabajador4.setDepartamento(comercial);
        trabajador5.setDepartamento(comercial);

        // Identificamos diferentes autores para las publicaciones
        Autor autor1= new Autor("Manuel Hans RuÃ­z",'H',"01/05/1960",930000006,"manuel.hans@carlemany.edu",false);
        Autor autor2= new Autor("Eliana Swatch LÃ³pez",'M',"12/04/1970",930000007,"eliana.sw@carlemany.edu",true);
        Autor autor3= new Autor("Alberto MenÃ©ndez Mayo",'H',"22/12/1992",930000008,"albert.m@carlemany.edu",true);
        Autor autor4= new Autor("Rosa MÂª Silva Po",'M',"07/10/1995",930000009,"rosa.po@carlemany.edu",false);

        // Creamos cuatro publicaciones en papel y les asignamos sus autores
        DocumentoPapel libro1=new DocumentoPapel("Paradigma de programaciÃ³n orientada a objetos", false, comercial, 95, true);
        DocumentoPapel libro2=new DocumentoPapel("IntroducciÃ³n al lenguaje de modelado UML", true, comercial, 110, false);
        DocumentoPapel libro3=new DocumentoPapel("Â¿QuiÃ©n se ha llevado mi queso?", true, administracion, 106, false);
        DocumentoPapel libro4=new DocumentoPapel("La paradoja: un relato sobre la verdadera esencia del liderazgo", true, direccion, 192, false);
        libro1.agregarAutor(autor1);
        autor1.agregarPublicacion(libro1);
        libro1.agregarAutor(autor2);
        autor2.agregarPublicacion(libro1);
        libro2.agregarAutor(autor1);
        autor1.agregarPublicacion(libro2);
        libro2.agregarAutor(autor3);
        autor3.agregarPublicacion(libro2);
        libro3.agregarAutor(autor2);
        autor2.agregarPublicacion(libro3);
        libro4.agregarAutor(autor3);
        autor3.agregarPublicacion(libro4);
        libro4.agregarAutor(autor4);
        autor4.agregarPublicacion(libro4);
        libro4.agregarAutor(autor1);
        autor1.agregarPublicacion(libro4);

        // Creamos tres publicaciones digitales y les asignamos sus autores
        DocumentoElectronico fichero1=new DocumentoElectronico("PolÃ­tica de seguridad de los datos de la Intranet", false, direccion, 340, "C:\\Datos\\Soporte\\proteccion.pdf");
        DocumentoElectronico fichero2=new DocumentoElectronico("CatÃ¡logo de servicios y productos", false, comercial, 650, "C:\\Datos\\Trimestre1\\catalogo.pdf");
        DocumentoElectronico fichero3=new DocumentoElectronico("Protocolo de gestiÃ³n de RR.HH.", false, administracion, 1024, "http://dominio.com/protocolo/rrhh.pdf");
        fichero1.agregarAutor(autor2);
        autor2.agregarPublicacion(fichero1);
        fichero1.agregarAutor(autor4);
        autor4.agregarPublicacion(fichero1);
        fichero2.agregarAutor(autor3);
        autor3.agregarPublicacion(fichero2);
        fichero3.agregarAutor(autor1);
        autor1.agregarPublicacion(fichero3);

        // Definimos dos colecciones
        Coleccion coleccionTecnica=new Coleccion("ColecciÃ³n de documentaciÃ³n tÃ©cnica","ColecciÃ³n dedicada a las publicaciones cientÃ­fico-tÃ©cnicas mÃ¡s destacadas");
        Coleccion coleccionEmpresarial=new Coleccion("ColecciÃ³n de documentaciÃ³n administrativa","ColecciÃ³n dedicada a las publicaciones vinculadas al entorno empresarial");

        // Establecemos las relaciones entre las publicaciones y sus respectivas colecciones
        coleccionTecnica.agregarPublicacion(libro1);
        coleccionTecnica.agregarPublicacion(libro2);
        coleccionTecnica.agregarPublicacion(fichero1);

        coleccionEmpresarial.agregarPublicacion(libro3);
        coleccionEmpresarial.agregarPublicacion(libro4);
        coleccionEmpresarial.agregarPublicacion(fichero2);
        coleccionEmpresarial.agregarPublicacion(fichero3);

        // Registramos definitivamente las colecciones al archivo
        archivoGui.agregarColeccion(coleccionTecnica);
        archivoGui.agregarColeccion(coleccionEmpresarial);

        // Instanciamos la interfaz grÃ¡fica
        Ventana gui = new Ventana("Sistema de gestiÃ³n documental v.1.0",archivoGui);
    }
}