package br.com.sistemas.dao;

import br.com.sistemas.model.Pessoa;
import br.com.sistemas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PessoaDao {

    private Session sessao;
    private Transaction trans;
    private List<Pessoa> list;

    //Metodo salvar
    public void addPessoa(Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(p.getNome());
            pessoa.setCpf(p.getCpf());
            pessoa.setTelefone(p.getTelefone());
            pessoa.setEmail(p.getEmail());

            sessao.save(pessoa);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }

    //metodo remover
    public void removePessoa(Pessoa p) {
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
    public void updatePessoa(Pessoa p) {
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
    public List<Pessoa> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();

        Criteria cri = sessao.createCriteria(Pessoa.class);
        this.list = cri.list();
        return list;
    }

}
