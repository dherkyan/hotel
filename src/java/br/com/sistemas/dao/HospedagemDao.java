package br.com.sistemas.dao;

import br.com.sistemas.model.Hospedagem;
import br.com.sistemas.model.Reserva;
import br.com.sistemas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HospedagemDao {

    private Session sessao;
    private Transaction trans;
    private List<Hospedagem> list;

//Metodo salvar
    public void addHospedagem(Hospedagem h) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Reserva reserva = (Reserva) sessao.load(Reserva.class, new Integer(1));
                        
            Hospedagem hospedagem = new Hospedagem();
            hospedagem.setDataEntrada(h.getDataEntrada());
            hospedagem.setDataSaida(h.getDataSaida());
            hospedagem.setValor(h.getValor());
            hospedagem.setObs(h.getObs());
            hospedagem.setReserva(reserva);
                        
            sessao.save(hospedagem);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    //metodo listar reserva no get da lista
    public List<Hospedagem> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Hospedagem.class);
        this.list = cri.list();
        return list;
    }
}
