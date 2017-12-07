/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

import fatec.poo.control.Conexao;
import fatec.poo.control.DaoCliente;
import fatec.poo.control.DaoItemPedido;
import fatec.poo.control.DaoPedido;
import fatec.poo.control.DaoProduto;
import fatec.poo.control.DaoVendedor;
import fatec.poo.model.Cliente;
import fatec.poo.model.ItemPedido;
import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 0030481611024
 */
public class GUIEmitirPedido extends javax.swing.JFrame {

    /**
     * Creates new form GUIEmitirPedido
     */
    public GUIEmitirPedido() {
        initComponents();
        modTblProd = (DefaultTableModel)tblProduto.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPedido = new javax.swing.JPanel();
        lblNumPedido = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtNumPedido = new javax.swing.JTextField();
        txtDataPedido = new javax.swing.JFormattedTextField();
        btnConsultaPedido = new javax.swing.JButton();
        pnlDadosCli = new javax.swing.JPanel();
        lblCPFCli = new javax.swing.JLabel();
        txtCPFCliente = new javax.swing.JFormattedTextField();
        txtCliente = new javax.swing.JTextField();
        btnConsultaCliente = new javax.swing.JButton();
        pnlDadosVendedor = new javax.swing.JPanel();
        lblCPFVendedor = new javax.swing.JLabel();
        txtCPFVendedor = new javax.swing.JFormattedTextField();
        txtVendedor = new javax.swing.JTextField();
        btnConsultaVendedor = new javax.swing.JButton();
        pnlItens = new javax.swing.JPanel();
        lblCodProd = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblTotalPedido = new javax.swing.JLabel();
        lblTotalItens = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        txtQtdeVendida = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        txtTotalItens = new javax.swing.JTextField();
        btnAddProduto = new javax.swing.JButton();
        btnRemProduto = new javax.swing.JButton();
        btnConsultaProduto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        btnIncluirPedido = new javax.swing.JButton();
        btnAlterarPedido = new javax.swing.JButton();
        btnExcluirPedido = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emitir Pedido");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlPedido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pedido"));
        pnlPedido.setToolTipText("");

        lblNumPedido.setText("Número do Pedido");

        lblData.setText("Data do Pedido");

        txtNumPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumPedidoActionPerformed(evt);
            }
        });

        txtDataPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtDataPedido.setEnabled(false);

        btnConsultaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPedidoLayout = new javax.swing.GroupLayout(pnlPedido);
        pnlPedido.setLayout(pnlPedidoLayout);
        pnlPedidoLayout.setHorizontalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlPedidoLayout.setVerticalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData)
                    .addComponent(btnConsultaPedido)
                    .addComponent(txtNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumPedido))
                .addContainerGap())
        );

        pnlDadosCli.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Cliente"));
        pnlDadosCli.setEnabled(false);

        lblCPFCli.setText("CPF Cliente");
        lblCPFCli.setEnabled(false);

        try {
            txtCPFCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFCliente.setEnabled(false);

        txtCliente.setEditable(false);
        txtCliente.setEnabled(false);

        btnConsultaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultaCliente.setEnabled(false);
        btnConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosCliLayout = new javax.swing.GroupLayout(pnlDadosCli);
        pnlDadosCli.setLayout(pnlDadosCliLayout);
        pnlDadosCliLayout.setHorizontalGroup(
            pnlDadosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCPFCli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente)
                .addContainerGap())
        );
        pnlDadosCliLayout.setVerticalGroup(
            pnlDadosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaCliente)
                    .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPFCli))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDadosVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Vendedor"));
        pnlDadosVendedor.setEnabled(false);

        lblCPFVendedor.setText("CPF Vendedor");
        lblCPFVendedor.setEnabled(false);

        try {
            txtCPFVendedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFVendedor.setEnabled(false);

        txtVendedor.setEditable(false);
        txtVendedor.setEnabled(false);

        btnConsultaVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultaVendedor.setEnabled(false);
        btnConsultaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDadosVendedorLayout = new javax.swing.GroupLayout(pnlDadosVendedor);
        pnlDadosVendedor.setLayout(pnlDadosVendedorLayout);
        pnlDadosVendedorLayout.setHorizontalGroup(
            pnlDadosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCPFVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCPFVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultaVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVendedor)
                .addContainerGap())
        );
        pnlDadosVendedorLayout.setVerticalGroup(
            pnlDadosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaVendedor)
                    .addComponent(txtCPFVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPFVendedor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlItens.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Itens do Pedido"));
        pnlItens.setToolTipText("");
        pnlItens.setEnabled(false);

        lblCodProd.setText("Código Produto");
        lblCodProd.setEnabled(false);

        lblQuantidade.setText("Quantidade Vendida");
        lblQuantidade.setEnabled(false);

        lblTotalPedido.setText("Valor Total do Pedido");
        lblTotalPedido.setEnabled(false);

        lblTotalItens.setText("Quantidade de Itens do Pedido");
        lblTotalItens.setEnabled(false);

        txtCodProduto.setEnabled(false);

        txtProduto.setEditable(false);
        txtProduto.setEnabled(false);

        txtQtdeVendida.setEnabled(false);

        txtValorTotal.setEditable(false);
        txtValorTotal.setEnabled(false);

        txtTotalItens.setEditable(false);
        txtTotalItens.setEnabled(false);

        btnAddProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnAddProduto.setText("Adicionar Item");
        btnAddProduto.setEnabled(false);
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });

        btnRemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/rem.png"))); // NOI18N
        btnRemProduto.setText("Remover Item");
        btnRemProduto.setEnabled(false);
        btnRemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemProdutoActionPerformed(evt);
            }
        });

        btnConsultaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/pesq.png"))); // NOI18N
        btnConsultaProduto.setEnabled(false);
        btnConsultaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaProdutoActionPerformed(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Prec. Unit.", "Qtde. Vend.", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout pnlItensLayout = new javax.swing.GroupLayout(pnlItens);
        pnlItens.setLayout(pnlItensLayout);
        pnlItensLayout.setHorizontalGroup(
            pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItensLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemProduto)
                        .addGap(215, 215, 215))
                    .addGroup(pnlItensLayout.createSequentialGroup()
                        .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItensLayout.createSequentialGroup()
                                .addComponent(lblCodProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsultaProduto)
                                .addGap(18, 18, 18)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addComponent(lblQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtdeVendida, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItensLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlItensLayout.createSequentialGroup()
                                        .addComponent(lblTotalPedido)
                                        .addGap(6, 6, 6))
                                    .addComponent(lblTotalItens))
                                .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addComponent(jScrollPane2)))
        );

        pnlItensLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddProduto, btnRemProduto});

        pnlItensLayout.setVerticalGroup(
            pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCodProd)
                    .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultaProduto)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQtdeVendida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduto)
                    .addComponent(btnRemProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(pnlItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalItens))
                .addGap(22, 22, 22))
        );

        btnIncluirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/save.png"))); // NOI18N
        btnIncluirPedido.setText("Incluir");
        btnIncluirPedido.setEnabled(false);
        btnIncluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirPedidoActionPerformed(evt);
            }
        });

        btnAlterarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Alterar.png"))); // NOI18N
        btnAlterarPedido.setText("Alterar");
        btnAlterarPedido.setEnabled(false);
        btnAlterarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarPedidoActionPerformed(evt);
            }
        });

        btnExcluirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Eraser.png"))); // NOI18N
        btnExcluirPedido.setText("Excluir");
        btnExcluirPedido.setEnabled(false);
        btnExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPedidoActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDadosVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDadosCli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnIncluirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluirPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAlterarPedido, btnExcluirPedido, btnIncluirPedido, btnSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDadosCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(pnlDadosVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluirPedido)
                    .addComponent(btnAlterarPedido)
                    .addComponent(btnExcluirPedido)
                    .addComponent(btnSair))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnConsultaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaPedidoActionPerformed
        //COMPARAÇÃO PARA VER SE O PEDIDO DE NUMERO SETADO EXISTE
        //O PEDIDO PESQUISADO EXISTE:
        pedido = null;
        //System.out.println(pedido.getNumero() + pedido.getDataEmissaoPedido());
            
        if(daoPedido.consultar(Integer.valueOf(txtNumPedido.getText())) != null){
            pedido = daoPedido.consultar(Integer.valueOf(txtNumPedido.getText()));
            txtCPFCliente.setText(pedido.getCliente().getCpf());
            btnConsultaClienteActionPerformed(evt);
            txtCPFVendedor.setText(pedido.getVendedor().getCpf());
            btnConsultaVendedorActionPerformed(evt);
            //SETAR DATA
            btnExcluirPedido.setEnabled(true);
            btnAlterarPedido.setEnabled(true);
            setEnableItensPedido(true);
            
            int i, n = pedido.getItenspedido().size();
            for(i=0;i<n;i++){
                
                String Linha[] = {String.valueOf(pedido.getItenspedido().get(i).getProduto().getCodigo()),
                                 String.valueOf(pedido.getItenspedido().get(i).getProduto().getDescricao()),
                                 String.valueOf(pedido.getItenspedido().get(i).getProduto().getPrecoUnit()),
                                 String.valueOf(pedido.getItenspedido().get(i).getQtdeVendida()),
                                 String.valueOf(pedido.getItenspedido().get(i).getProduto().getPrecoUnit() * pedido.getItenspedido().get(i).getQtdeVendida())
                                };
                modTblProd.addRow(Linha);
            }
            calcTotais();
        }else{
            setEnableDadosClienteVendedor(true);
            setEnableItensPedido(true);
            btnIncluirPedido.setEnabled(true);
        }
    }//GEN-LAST:event_btnConsultaPedidoActionPerformed

    private void btnConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaClienteActionPerformed
        String cpf = (txtCPFCliente.getText().replace("-","").replace(".",""));
        if((daoCliente.consultar(cpf)) != null){
            cliente = daoCliente.consultar(cpf);
            txtCliente.setText(cliente.getNome());
        }else{
            JOptionPane.showMessageDialog(this,"Cliente não cadastrado!","Dado Inválido",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultaClienteActionPerformed

    private void btnConsultaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaVendedorActionPerformed
        String cpf = (txtCPFVendedor.getText().replace("-","").replace(".",""));
        if((daoVendedor.consultar(cpf)) != null){
            vendedor = daoVendedor.consultar(cpf);
            txtVendedor.setText(vendedor.getNome());
        }else{
            JOptionPane.showMessageDialog(this,"Vendedor não cadastrado!","Dado Inválido",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultaVendedorActionPerformed

    private void btnConsultaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaProdutoActionPerformed
        if((daoProduto.consultar(Integer.parseInt(txtCodProduto.getText()))) != null){
            produto = daoProduto.consultar(Integer.parseInt(txtCodProduto.getText()));
            txtProduto.setText(produto.getDescricao());
            btnAddProduto.setEnabled(true);
            btnRemProduto.setEnabled(true);
            txtProduto.setEnabled(true);
            txtQtdeVendida.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(this,"Produto não cadastrado!","Dado Inválido",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnConsultaProdutoActionPerformed

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed
        if(Integer.parseInt(txtQtdeVendida.getText()) <= produto.getQtdeDisponivel()){
            
             int n = modTblProd.getRowCount() + 1;
             String Linha[] = {String.valueOf(produto.getCodigo()),
                                 String.valueOf(produto.getDescricao()),
                                 String.valueOf(produto.getPrecoUnit()),
                                 String.valueOf(txtQtdeVendida.getText()),
                                 String.valueOf(Integer.parseInt(txtQtdeVendida.getText()) * produto.getPrecoUnit())
                                };
                modTblProd.addRow(Linha);
            produto.tiraEstoque(Integer.valueOf(txtQtdeVendida.getText()));
            
            calcTotais();
        }else{
            JOptionPane.showMessageDialog(this,"Quantidade não disponível em estoque!","Dado Inválido",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddProdutoActionPerformed

    private void btnRemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemProdutoActionPerformed
       if(tblProduto.getSelectedRow() != -1){
           modTblProd.removeRow(tblProduto.getSelectedRow());
           calcTotais();
           produto.poeEstoque(Integer.valueOf(txtQtdeVendida.getText()));
       }else{
            JOptionPane.showMessageDialog(this,"Seleciona uma linha cara!","Dado Inválido",JOptionPane.WARNING_MESSAGE);
           
       }
    }//GEN-LAST:event_btnRemProdutoActionPerformed

    private void btnIncluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIncluirPedidoActionPerformed

    private void btnAlterarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarPedidoActionPerformed

    private void btnExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirPedidoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        conexao.fecharConexao();
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        conexao = new Conexao("BD1611017","BD1611017");
        conexao.setDriver("oracle.jdbc.driver.OracleDriver");
        conexao.setConnectionString("jdbc:oracle:thin:@apolo:1521:xe");
        daoPedido = new DaoPedido(conexao.conectar());
        daoCliente = new DaoCliente(conexao.conectar());
        daoVendedor = new DaoVendedor(conexao.conectar());
        daoItemPedido = new DaoItemPedido(conexao.conectar());
        daoProduto = new DaoProduto(conexao.conectar());
    }//GEN-LAST:event_formWindowOpened

    private void txtNumPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIEmitirPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEmitirPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEmitirPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEmitirPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIEmitirPedido().setVisible(true);
            }
        });
    }
    
    private void calcTotais(){
        int qtdvendida = 0;
        double valortotal = 0;
        
        for(int i=0; i < modTblProd.getRowCount(); i++)
        {
            qtdvendida += Integer.parseInt((modTblProd.getValueAt(i, 3)+""));
            valortotal += Double.parseDouble((modTblProd.getValueAt(i, 4)+""));
        }
        
        txtTotalItens.setText(String.valueOf(qtdvendida));
        txtValorTotal.setText(String.valueOf(valortotal));
    }
    
    private void setEnableDadosClienteVendedor(boolean b){
        txtCPFCliente.setEnabled(b);
        btnConsultaCliente.setEnabled(b);
        txtCliente.setEnabled(b);
        pnlDadosCli.setEnabled(b);
        lblCPFCli.setEnabled(b);
        
        txtCPFVendedor.setEnabled(b);
        btnConsultaVendedor.setEnabled(b);
        txtVendedor.setEnabled(b);
        pnlDadosVendedor.setEnabled(b);
        lblCPFVendedor.setEnabled(b);
    }
    
    private void setEnableItensPedido(boolean b){
        pnlItens.setEnabled(b);
        lblCodProd.setEnabled(b);
        txtCodProduto.setEnabled(b);
        btnConsultaProduto.setEnabled(b);
//        txtProduto.setEnabled(b);
        lblQuantidade.setEnabled(b);
//        txtQtdeVendida.setEnabled(b);
        lblTotalItens.setEnabled(b);
        lblTotalPedido.setEnabled(b);
        txtTotalItens.setEnabled(b);
        txtValorTotal.setEnabled(b);        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnAlterarPedido;
    private javax.swing.JButton btnConsultaCliente;
    private javax.swing.JButton btnConsultaPedido;
    private javax.swing.JButton btnConsultaProduto;
    private javax.swing.JButton btnConsultaVendedor;
    private javax.swing.JButton btnExcluirPedido;
    private javax.swing.JButton btnIncluirPedido;
    private javax.swing.JButton btnRemProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCPFCli;
    private javax.swing.JLabel lblCPFVendedor;
    private javax.swing.JLabel lblCodProd;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblNumPedido;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotalItens;
    private javax.swing.JLabel lblTotalPedido;
    private javax.swing.JPanel pnlDadosCli;
    private javax.swing.JPanel pnlDadosVendedor;
    private javax.swing.JPanel pnlItens;
    private javax.swing.JPanel pnlPedido;
    private javax.swing.JTable tblProduto;
    private javax.swing.JFormattedTextField txtCPFCliente;
    private javax.swing.JFormattedTextField txtCPFVendedor;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JFormattedTextField txtDataPedido;
    private javax.swing.JTextField txtNumPedido;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtdeVendida;
    private javax.swing.JTextField txtTotalItens;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
    private Conexao conexao = null;
    private DaoCliente daoCliente = null;
    private DaoVendedor daoVendedor = null;
    private DaoProduto daoProduto = null;
    private DaoPedido daoPedido = null;
    private DaoItemPedido daoItemPedido = null;
    
    private Cliente cliente = null;
    private Vendedor vendedor = null;
    private Pedido pedido = null;
    private Produto produto = null;
    private ItemPedido itempedido = null;
    
    private DefaultTableModel modTblProd = null;
}
