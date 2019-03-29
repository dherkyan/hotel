package br.com.sistemas.controller;

import br.com.sistemas.dao.PessoaDao;
import br.com.sistemas.model.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PessoaBean implements Serializable{

    private Pessoa pessoa = new Pessoa();
    private final PessoaDao pessoaDao = new PessoaDao();
    private List<Pessoa> listaPessoa;

    public PessoaBean() {
    }

    //metodo salvar
    public String adicionarPessoa() {
        pessoaDao.addPessoa(pessoa);

        pessoa = new Pessoa();
        return "listar_pessoa";
    }

    //metodo remover pessoa
    public String removerPessoa(Pessoa p) {
        this.pessoa = p;
        pessoaDao.removePessoa(this.pessoa);

        pessoa = new Pessoa();
        return "listar_pessoa";
    }

    //metodo listar todos
    public List listarPessoa() {
        listaPessoa = pessoaDao.getList();
        return this.listaPessoa;
    }

    //metodo carregar a pessoa para editar
    public String carregarPessoa(Pessoa p) {
        this.pessoa = p;
        return "pessoa";
    }

    //metodo para atualizar
    public String atualizarPessoa() {
        pessoaDao.updatePessoa(pessoa);
        
        pessoa = new Pessoa();
        return "listar_pessoa";
    }

    //get e setts
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
