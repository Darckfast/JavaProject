package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Victor, Kevin and Gabriel
 */
public class Pedido {
    private int numero;
    private String dataEmissaoPedido;
    private String dataPgto;
    private boolean status;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itenspedido;

    public Pedido(int numero, String dataEmissaoPedido) {
        this.numero = numero;
        this.dataEmissaoPedido = dataEmissaoPedido;
    }

    public String getDataPgto() {
        return dataPgto;
    }

    public void setDataPgto(String dataPgto) {
        this.dataPgto = dataPgto;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public String getDataEmissaoPedido() {
        return dataEmissaoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public void addItensPedido(ItemPedido i){
        itenspedido.add(i);
        i.setPedido(this);
    }

    public void setItenspedido(ArrayList<ItemPedido> itenspedido) {
        this.itenspedido = itenspedido;
    }

    public ArrayList<ItemPedido> getItenspedido() {
        return itenspedido;
    }
    
    
}
