/**
 * Clase Trabajador - Esta clase heredada de Persona contiene la especialización
 * de propiedades y métodos propios de un actor modelado del sistema
 *
 * @author: Juan Pedro Cerro Martínez
 * @version 01/01/2024
 */

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Trabajador extends Persona
{
    // Propiedades de la clase
    private Departamento departamento;
    private float salario;
    private Date fechaAlta;
    private boolean esResponsable;
    private String numeroSS;

    /**
     * Método constructor sobrecargado de la clase
     *
     * @param pNombreCompleto Nombre de la persona
     * @param pSexo El sexo de la persona {"H" - Hombre | "M" - Mujer}
     * @param pFechaNacimiento Fecha de nacimiento de la persona en formato "dd/mm/aaaa"
     * @param pTelefono Teléfono de contacto de la persona
     * @param pCorreoElectronico Correo electrónico de contacto de la persona
     */
    public Trabajador(String pNombreCompleto, char pSexo, String pFechaNacimiento, int pTelefono, String pCorreoElectronico) throws ParseException  {
        super(pNombreCompleto, pSexo, pFechaNacimiento, pTelefono, pCorreoElectronico);
    }


    /**
     * Método constructor específico de la clase
     *
     * @param pNombreCompleto Nombre del trabajador
     * @param pSexo El sexo del trabajador {"H" - Hombre | "M" - Mujer}
     * @param pFechaNacimiento Fecha de nacimiento del trabajador en formato "dd/mm/aaaa"
     * @param pTelefono Teléfono de contacto del trabajador
     * @param pCorreoElectronico Correo electrónico de contacto del trabajador
     * @param pDepartamento Departamento asociado al trabajador
     * @param pSalario Salario que percibe el trabajador
     * @param pFechaAlta Fecha de nacimiento del trabajador en formato "dd/mm/aaaa"
     * @param pEsResponsable Lógico que indica si el trabajador es el responsable de su departamento o no
     * @param pNumeroSS Número de la SS del trabajador
     */
    public Trabajador(String pNombreCompleto, char pSexo, String pFechaNacimiento, int pTelefono, String pCorreoElectronico, Departamento pDepartamento, float pSalario, String pFechaAlta, boolean pEsResponsable, String pNumeroSS) throws ParseException  {
        super(pNombreCompleto, pSexo, pFechaNacimiento, pTelefono, pCorreoElectronico);
        try {

            this.departamento=pDepartamento;
            this.salario=pSalario;
            this.esResponsable=pEsResponsable;
            this.numeroSS=new String(pNumeroSS);

            Date fecha=new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            fecha=formatoFecha.parse(pFechaAlta);
            this.fechaAlta=fecha;
        } catch (ParseException excepcion) {
            System.out.println("La fecha de alta '"+pFechaAlta+"' no cumple con el formato 'dd/mm/aaaa'");
        }
    }

    /**
     * Método accesor de la propiedad "departamento"
     *
     * @param
     * @return El Departamento con el contenido de la propiedad
     */
    public Departamento getDepartamento() {
        return this.departamento;
    }

    /**
     * Método instanciador de la propiedad "departamento"
     *
     * @param pDepartamento Departamento del trabajador
     * @return
     */
    public void setDepartamento(Departamento pDepartamento) {
        this.departamento=pDepartamento;
    }

    /**
     * Método accesor de la propiedad "salario"
     *
     * @param
     * @return El float con el contenido de la propiedad
     */
    public float getSalario() {
        return this.salario;
    }

    /**
     * Método instanciador de la propiedad "salario"
     *
     * @param pSalario El salario del trabajador
     * @return
     */
    public void setSalario(float pSalario) {
        this.salario=pSalario;
    }

    /**
     * Método accesor de la propiedad "numeroSS"
     *
     * @param
     * @return El String con el contenido de la propiedad
     */
    public String getNumeroSS() {
        return this.numeroSS;
    }

    /**
     * Método instanciador de la propiedad "numeroSS"
     *
     * @param pNumeroSS Número de la SS del trabajador
     * @return
     */
    public void setNumeroSS(String pNumeroSS) {
        this.numeroSS=pNumeroSS;
    }

    /**
     * Método accesor de la propiedad "responsable"
     *
     * @param
     * @return El boolean con el contenido de la propiedad
     */
    public boolean esResponsable() {
        return this.esResponsable;
    }

    /**
     * Método instanciador de la propiedad "responsable"
     *
     * @param pResponsabilidad El valor lógico indicando si el trabajador es el responsable del Departamento o no
     * @return
     */
    public void setResponsabilidad(boolean pResponsabilidad) {
        this.esResponsable=pResponsabilidad;
    }

    /**
     * Método accesor de la propiedad "fechaAlta"
     * @param
     * @return El String con la fecha de alta en la organización del trabajador
     */
    public String getFechaAlta() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(this.fechaAlta);
    }

    /**
     * Método instanciador de la propiedad "fechaAlta"
     * @param pFechaAlta de alta en la organización del trabajador
     * @return
     */
    public void setFechaAlta(String pFechaAlta) throws ParseException  {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            this.fechaAlta=formatoFecha.parse(pFechaAlta);
        } catch (ParseException excepcion) {
            System.out.println("La fecha de alta '"+pFechaAlta+"' no cumple con el formato 'dd/mm/aaaa'");
        }
    }
}
