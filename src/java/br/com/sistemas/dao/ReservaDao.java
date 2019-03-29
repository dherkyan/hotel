package br.com.sistemas.dao;

import br.com.sistemas.model.Pessoa;
import br.com.sistemas.model.Reserva;
import br.com.sistemas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservaDao {

    private Session sessao;
    private Transaction trans;
    private List<Reserva> list;

//Metodo salvar
    public void addReserva(Reserva r) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Pessoa pessoa = (Pessoa) sessao.load(Pessoa.class, new Integer(1));

            Reserva reserva = new Reserva();
            reserva.setDataChegada(r.getDataChegada());
            reserva.setDataReserva(r.getDataReserva());
            reserva.setTempoEstadia(r.getTempoEstadia());
            reserva.setPessoa(pessoa);

            sessao.save(reserva);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    //metodo listar reserva no get da lista
    public List<Reserva> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Reserva.class);
        this.list = cri.list();
        return list;
    }

}
