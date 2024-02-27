/**
 * Abstract class Persona - Esta clase abstracta contiene la generalidad
 * de propiedades y métodos propios de un actor modelado del sistema
 *
 * @author Juan Pedro Cerro Martínez
 * @version 01/01/2024
 */

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public abstract class Persona {
    // Propiedades de la clase
    protected String nombreCompleto;
    protected char sexo;
    protected Date fechaNacimiento;
    protected int telefono;
    protected String correoElectronico;

    /**
     * Método constructor específico de la clase
     *
     * @param pNombreCompleto Nombre de la persona
     * @param pSexo El sexo de la persona {"H" - Hombre | "M" - Mujer}
     * @param pFechaNacimiento Fecha de nacimiento de la persona en formato "dd/mm/aaaa"
     * @param pTelefono Teléfono de contacto de la persona
     * @param pCorreoElectronico Correo electrónico de contacto de la persona
     */
    public Persona(String pNombreCompleto, char pSexo, String pFechaNacimiento, int pTelefono, String pCorreoElectronico) throws ParseException  {
        try {
            Date fecha=new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            fecha=formatoFecha.parse(pFechaNacimiento);
            this.fechaNacimiento=fecha;

            this.nombreCompleto=new String(pNombreCompleto);
            this.sexo=pSexo;
            this.telefono=pTelefono;
            this.correoElectronico=new String(pCorreoElectronico);
        } catch (ParseException excepcion) {
            System.out.println("La fecha de nacimiento '"+pFechaNacimiento+"' no cumple con el formato 'dd/mm/aaaa'");
        }
    }

    /**
     * Método accesor de la propiedad "nombreCompleto"
     *
     * @param
     * @return El String con el contenido de la propiedad
     */
    protected String getNombreCompleto() {
        return this.nombreCompleto;
    }

    /**
     * Método instanciador de la propiedad "nombreCompleto"
     *
     * @param pNombreCompleto Nombre de la persona
     * @return
     */
    protected void setNombreCompleto(String pNombreCompleto) {
        this.nombreCompleto=pNombreCompleto;
    }

    /**
     * Método accesor de la propiedad "sexo"
     *
     * @param
     * @return El char con el contenido de la propiedad
     */
    protected char getSexo() {
        return this.sexo;
    }

    /**
     * Método instanciador de la propiedad "sexo"
     *
     * @param pSexo El sexo de la persona {"H">Hombre | "M">Mujer}
     * @return
     */
    protected void setSexo(char pSexo) {
        this.sexo=pSexo;
    }

    /**
     * Método accesor de la propiedad "correoElectronico"
     *
     * @param
     * @return El String con el contenido de la propiedad
     */
    protected String getCorreoElectronico() {
        return this.correoElectronico;
    }

    /**
     * Método instanciador de la propiedad "correoElectronico"
     *
     * @param pCorreoElectronico Correo electrónico de contacto de la persona
     * @return
     */
    protected void setCorreoElectrónico(String pCorreoElectronico) {
        this.correoElectronico=pCorreoElectronico;
    }

    /**
     * Método accesor de la propiedad "telefono"
     *
     * @param
     * @return El int con el contenido de la propiedad
     */
    protected int getTelefono() {
        return this.telefono;
    }

    /**
     * Método instanciador de la propiedad "telefono"
     *
     * @param pTelefono El teléfono de contacto de la persona
     * @return
     */
    protected void setTelefono(int pTelefono) {
        this.telefono=pTelefono;
    }

    /**
     * Método accesor de la propiedad "fechaNacimiento"
     * @param
     * @return El String con la fecha de nacimiento de la persona
     */
    protected String getFechaNacimiento() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(this.fechaNacimiento);
    }

    /**
     * Método instanciador de la propiedad "fechaNacimiento"
     * @param  pFechaNacimiento de nacimiento a asignar
     * @return
     */
    protected void setFechaNacimiento(String pFechaNacimiento) throws ParseException  {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            this.fechaNacimiento=formatoFecha.parse(pFechaNacimiento);
        } catch (ParseException excepcion) {
            System.out.println("La fecha de nacimiento '"+pFechaNacimiento+"' no cumple con el formato 'dd/mm/aaaa'");
        }
    }
}
