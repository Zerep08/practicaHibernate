/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; //Se crea un objeto de la clase SessionFactory para crear las sesiones
    private static final ThreadLocal localSession; //Se crea un objeto de la clase ThreadLocal para manejar las sesiones como hilos paralelos
    
    static {
        try {
           Configuration config = new Configuration(); //Se crea una nueva configuracion
            config.configure("hibernate.cfg.xml"); //Le pasamos nuestro archivo de configuracion hibernate
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(). //Creamos un builder que contextualiza al session factory
            applySettings(config.getProperties()); //Aplicamos las propiedades declaradas en nuestro archivo de configuracion
            sessionFactory = config.buildSessionFactory(builder.build()); //Construimos una nueva sesion con las configuraciones que previamente aplicamos
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        localSession = new ThreadLocal(); //la sesion local la creamos como un nuevo hilo.
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory; // Este metodo retorna la sesion actual
    }
    
     public static Session getLocalSession() {
        Session session = (Session) localSession.get(); //Obtenemos una sesion local y la asignamos a la session.
        if (session == null) {
            session = sessionFactory.openSession(); //Si la sesion no se ha creado creamos una nueva
            localSession.set(session);              //le asignamos la nueva sesion creada a un hilo para que haga sus patranias
            System.out.println("\nsesion iniciada");
        }
        return session;
    }
     
     public static void closeLocalSession() {
        Session session = (Session) localSession.get(); //Obtenmos la session actual
        if (session != null) session.close();   //Si la sesion actual no es nula , la cerramos
        localSession.set(null);                 //Matamos el hilo
        System.out.println("sesion cerrada\n");
    }
}
