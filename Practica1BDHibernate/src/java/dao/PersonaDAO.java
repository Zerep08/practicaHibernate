/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class PersonaDAO {
   
    Session session; //Creamos un objeto de la clase session para guardar la sesion del usuario
    
    public PersonaDAO(){
        session=HibernateUtil.getLocalSession(); //Con este metodo obtenemos la sesion local
    }
    
    public  Persona getPersonaById(int id){
        return (Persona)session.load(Persona.class, id); //Hacemos una consulta para obtener las filas de la tabla persona por ID
    }
    
    public List<Persona>  getPersonaByName(String nombre){
        List<Persona> listaDePersonas=(List<Persona>) //Se crea una lista de personas para guardar los nombres de la tabla Persona filtrados por nombre
                session.createCriteria(Persona.class) //Creamos un criterio para la consulta
                .add(Restrictions.eq("Nombre", nombre)); //En este caso el criterio es filtrar cuando la cadena coincida exactamente con lo que hay en la tabla
        return listaDePersonas; //Retornamos la lista con los resultados
    }
    
    public boolean updateById(int id,Persona persona){
        Persona personaAModificar=getPersonaById(id); //Se crea un objeto de la clase Persona y le asignamos la persona que encontremos mediante el ID que mandemos
        try{
            Transaction transaccion=session.beginTransaction(); //Iniciamos una transaccion
            personaAModificar.setNombre(persona.getNombre()); //mediante un set modificamos el nombre
            session.update(personaAModificar); //Actualizamos un valor en la tabla
            transaccion.commit(); //Finalizar la transaccion
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
        Persona personaDeTanque=new Persona();
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona); //Cargamos la tabla tipo persona por ID
        personaDeTanque.setNombre(nombre); //Cambiamos los valores de cada columna en la clase persona mediante un set.
        personaDeTanque.setMaterno(materno);
        personaDeTanque.setPaterno(paterno);
        personaDeTanque.setTelefono(telefono);
        personaDeTanque.setTipoPersona(tipoDeTanque); //Le asignamos el id a la llave foranea
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(personaDeTanque); //Guardamos una nueva entrada en la tabla.
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return true;
    }
    
}
