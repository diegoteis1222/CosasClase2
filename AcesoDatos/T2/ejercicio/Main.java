package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Iniciar la sesión (asegúrate de que lea tu hibernate.cfg.xml)
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class) // Registramos la clase
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // 2. Empezar transacción
            session.beginTransaction();

            // 3. Consulta HQL: "Dame todos los objetos de la clase Category"
            List<Category> lasCategorias = session.createQuery("from Category", Category.class).getResultList();

            // 4. Imprimir resultados
            System.out.println("\n--- LISTA DE CATEGORÍAS ---");
            for (Category c : lasCategorias) {
                System.out.println(c);
            }

            // 5. Commit
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}