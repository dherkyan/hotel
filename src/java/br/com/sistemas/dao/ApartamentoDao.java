package br.com.sistemas.dao;

import br.com.sistemas.model.Apartamento;
import br.com.sistemas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ApartamentoDao {

    private Session sessao;
    private Transaction trans;
    private List<Apartamento> list;

    //Metodo salvar
    public void addApartamento(Apartamento p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Apartamento apartamento = new Apartamento();
            apartamento.setNumero(p.getNumero());
            apartamento.setAndar(p.getAndar());
            apartamento.setTipo(p.getTipo());

            sessao.save(apartamento);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    //metodo remover
    public void removeApartamento(Apartamento p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(p);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    //metodo update
    public void updateApartamento(Apartamento p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.update(p);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    //get da lista
    public List<Apartamento> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Apartamento.class);
        this.list = cri.list();
        return list;
    }
}
