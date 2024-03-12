package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setName("memberA");
            member.setHomeAddress(new Address("city", "street", "zipcode"));
            member.setWorkPeriod(new Period());

            em.persist(member);

            tx.commit();
        }catch (Exception e){
            System.out.println("e=" + e.getMessage());
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
