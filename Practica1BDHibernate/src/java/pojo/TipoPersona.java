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
import javax.persistence.Table;

/**
 *  #Pray4Tanque
 * @author RigoBono
 */
@Entity //Es el row de la tabla que definimos abajo
@Table(name="TipoPersona", catalog="generationHibernate") //Indicamos el nombre de la tabla y el nombre del esquema al que pertenece esa tabla
public class TipoPersona {
    
    @Id @GeneratedValue //Definimos la clave primaria y que sea autoincrementable
    @Column(name="idTipoPersona") //Indicamos el nombre de la columna y la variable con la cual obtendremos y modificaremos los datos 
    private int idTipoPersona;
    
     @Column(name="TipoPersonacol")
    private String TipoPersona;
     
     public TipoPersona(){
         
     }
     

    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
     
     
     
     
    
}
