package br.com.sistemas.controller;

import br.com.sistemas.dao.PessoaDao;
import br.com.sistemas.dao.ReservaDao;
import br.com.sistemas.model.Pessoa;
import br.com.sistemas.model.Reserva;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@SessionScoped
public class NovaReservaBean implements Serializable {

    private Pessoa pessoaSelecionada = new Pessoa();
    private List<Pessoa> pessoas;
    private Reserva reserva = new Reserva();
    private final ReservaDao reservaDao = new ReservaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private List<Reserva> listaReserva;
    private String pesquisa = "";

    public NovaReservaBean() {
        pessoas = new ArrayList();
    }

    //metodo salvar
    public String adicionarReserva() {
        reserva.setPessoa(pessoaSelecionada);
        reservaDao.addReserva(reserva);

        reserva = new Reserva();
        pessoaSelecionada = new Pessoa();
        return "listar_reserva";
    }

    //metodo listar todos
    public List listarReserva() {
        listaReserva = reservaDao.getList();
        return this.listaReserva;
    }

    public void pesquisarPessoa() {
        if (this.pesquisa == null || this.pesquisa.length() < 3) {
            FacesMessage aviso = new FacesMessage("Aviso", "Digite pelo menos 3 caracteres");
            FacesContext.getCurrentInstance().addMessage(null, aviso);
            return;
        }
        this.pessoaSelecionada = null;
        this.pessoaSelecionada = new Pessoa();
        pessoas = pessoaDao.pesquisarPorNome(pesquisa);
    }

    public void onRowSelect(SelectEvent event) {
        // pessoa selecionada
        this.pessoaSelecionada = (Pessoa) event.getObject();
    }

    public void onRowUnselect(UnselectEvent event) {
    }

    //get e setts
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoaSelecionada() {
        return pessoaSelecionada;
    }

    public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
        this.pessoaSelecionada = pessoaSelecionada;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

}
