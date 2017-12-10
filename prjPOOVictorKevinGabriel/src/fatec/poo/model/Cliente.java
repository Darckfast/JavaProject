package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Victor, Kevin and Gabriel
 */
public class Cliente extends Pessoa {
    private double limiteCred;
    private double limiteDisp;
    private double limiteCredAntigo;
    private ArrayList<Pedido> pedidos;
    
    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteCred = limiteCred;
        this.limiteDisp = limiteCred;
        pedidos = new ArrayList<>();
        
    }

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }
    
    public void addPedido(Pedido p){
        pedidos.add(p);
        p.setCliente(this);
    }

    public double getLimiteCredAntigo() {
        return limiteCredAntigo;
    }

    public void setLimiteCredAntigo(double limiteCredAntigo) {
        this.limiteCredAntigo = limiteCredAntigo;
    }

    
}
