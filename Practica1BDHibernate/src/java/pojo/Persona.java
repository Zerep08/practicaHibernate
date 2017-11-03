/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */

//POJO Plan Old Java Object

@Entity //Es el row de la tabla que definimos abajo
@Table(name="Persona",catalog="generationHibernate") //Indicamos el nombre de la tabla y el nombre del esquema al que pertenece esa tabla
public class Persona {
    
    @Id @GeneratedValue //Definimos la clave primaria y que sea autoincrementable
    @Column(name="idPersona") //Indicamos el nombre de la columna y la variable con la cual obtendremos y modificaremos los datos 
    private int idPersona;
    
    @Column(name="Nombre",nullable=true) //nullable sirve para indicar si el campo sera nulo o no, en este caso indicamos que si puede ser nulo
    private String Nombre;
    
    @Column(name="Paterno")
    private String Paterno;
    
     @Column(name="Materno")
    private String Materno;
     
     @Column(name="Telefono")
    private String Telefono;
    
     @ManyToOne
     @JoinColumn(name="idTipoPersona")
    private TipoPersona tipoPersona;

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
