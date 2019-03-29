package br.com.sistemas.controller;

import br.com.sistemas.dao.ApartamentoDao;
import br.com.sistemas.model.Apartamento;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ApartamentoBean implements Serializable{

    private Apartamento apartamento = new Apartamento();
    private final ApartamentoDao apartamentoDao = new ApartamentoDao();        
    private List<Apartamento> listaApartamento;

    public ApartamentoBean() {
    }

    //metodo salvar
    public String adicionarApartamento() {
        apartamentoDao.addApartamento(apartamento);        

        apartamento = new Apartamento();        
        return "listar_apartamento";
    }    

    //metodo remover Apartamento
    public String removerApartamento(Apartamento p) {
        this.apartamento = p;
        apartamentoDao.removeApartamento(this.apartamento);        

        apartamento = new Apartamento();        
        return "listar_apartamento";
    }

    //metodo listar todos
    public List listarApartamento() {
        listaApartamento = apartamentoDao.getList();        
        return this.listaApartamento;
    }

    //metodo carregar o Apartamento para editar
    public String carregarApartamento(Apartamento p) {
        this.apartamento = p;
        return "apartamento";
    }

    //metodo para atualizar Apartamento
    public String atualizarApartamento() {
        apartamentoDao.updateApartamento(apartamento);
                
        apartamento = new Apartamento();
        return "listar_apartamento";
    }

    
    //get e setts
    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }
}
