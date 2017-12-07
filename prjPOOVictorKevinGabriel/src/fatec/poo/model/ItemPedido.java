package fatec.poo.model;

/**
 *
 * @author Victor, Kevin and Gabriel
 */
public class ItemPedido {
    private int numeroItem;
    private int qtdeVendida;
    private Produto produto;
    private Pedido pedido;

    public ItemPedido(int numeroItem, int qtdeVendida) {
        this.numeroItem = numeroItem;
        this.qtdeVendida = qtdeVendida;
//        produto.setQtdeDisponivel(produto.getQtdeDisponivel()- qtdeVendida);
//        pedido.getCliente().setLimiteDisp(pedido.getCliente().getLimiteDisp() - (produto.getPrecoUnit() * qtdeVendida));
//        
    }    
    
    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(int qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
}
