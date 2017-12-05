package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Victor, Kevin and Gabriel
 */
public class Vendedor extends Pessoa{
    private double salarioBase;
    private double comissao;
    private ArrayList<Pedido> pedidos;

    public Vendedor(String cpf, String nome, double salarioBase) {
        super(cpf, nome);
        this.salarioBase = salarioBase;
        pedidos = new ArrayList<>();
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getComissao() {
        return comissao * 100;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao / 100;
    }
    public void addPedido (Pedido p){
        pedidos.add(p);
        p.setVendedor(this);
    }
    
}
