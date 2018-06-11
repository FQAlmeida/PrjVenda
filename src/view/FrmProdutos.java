package view;

import dao.DaoProduto;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import models.Produto;
import view.Util;
import view.Util.Operacao;

/**
 * @author Cauê Ribeiro, Renan Casagrande — 3º TIN última atualização:
 * 09/04/2018
 */
public class FrmProdutos extends javax.swing.JFrame {

    Util util = new Util();
    Operacao oper; //objeto para usar o Enum
    NumberFormatter mfPreco;
    ArrayList<DaoProduto> pro = new ArrayList<>();

    int session = 0;
    boolean teste = false; // true: executa autofillParaTeste() e autocompleta a tabela com 4 produtos

    /**
     * Creates new form FrmProdutos
     */
    public FrmProdutos() {
        initComponents();
        this.setLocationRelativeTo(null); // centraliza o JFrame na tela
        try {// (se o num for positivo; se o num for negativo)
            // # : caso o usuário não digite um número, não ira aparecer nada 
            // 0:  caso o usuário não digite um número, irá aparecer zero
            DecimalFormat df = new DecimalFormat("R$ #,###,##0.00;-R$ #,###,##0.00");
            mfPreco = new NumberFormatter(df);
            mfPreco.setValueClass(Double.class);
            DefaultFormatterFactory dffPreco = new DefaultFormatterFactory(mfPreco);
            txtPreco.setFormatterFactory(dffPreco);
            util.habilitarComponentes(false, pnlCampos);
            btnGravar.setEnabled(false);
            btnCancelar.setEnabled(false);
            //autofillParaTeste(false); //autocompleta a tabela com 4 produtos. Mudar para false na apresentação.
            DaoProduto prod = new DaoProduto();
            pro.addAll(prod.Pesquisar());
            atualizaTabela(pro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na"
                    + "aplicação do NumberFormatter: " + ex.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        pnlBotoes = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlCampos = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        spnQuantidade = new javax.swing.JSpinner();
        txtPreco = new javax.swing.JFormattedTextField();
        chkPreencher = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Formúlario de Produtos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProdutos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblProdutosFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);
        tblProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProdutos.getAccessibleContext().setAccessibleName("");

        btnIncluir.setMnemonic('i');
        btnIncluir.setText("Incluir");
        btnIncluir.setMaximumSize(new java.awt.Dimension(31, 23));
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnAlterar.setMnemonic('a');
        btnAlterar.setText("Editar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setMnemonic('e');
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setMnemonic('p');
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnGravar.setMnemonic('g');
        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnPesquisar)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblCodigo.setText("Código");

        txtCodigo.setPreferredSize(new java.awt.Dimension(99, 24));

        lblDescricao.setText("Descrição");

        lblQuantidade.setText("Quantidade");

        lblPreco.setText("Preço");

        spnQuantidade.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        spnQuantidade.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPreco)
                    .addComponent(lblCodigo)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao)
                            .addComponent(lblQuantidade))
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCamposLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCamposLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPreco)
                                    .addComponent(spnQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(spnQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chkPreencher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chkPreencher.setMnemonic('r');
        chkPreencher.setText("Adicionar alguns produtos");
        chkPreencher.setName("chkPreencher"); // NOI18N
        chkPreencher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPreencherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(chkPreencher)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkPreencher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// * * * * ActionPerformed dos 6 botões INÍCIO * * * *
    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        util.limparCampos(rootPane);
        util.limparCampos(pnlCampos);
        util.habilitarComponentes(true, pnlCampos);
        util.habilitarBotoes(false, pnlBotoes);
        oper = Operacao.GRAVAR;
        spnQuantidade.setValue(1);
        txtPreco.setValue(0.00);
        txtDescricao.requestFocus();
        txtCodigo.setEnabled(false);
        if (tblProdutos.getRowCount() == 0) {
            txtCodigo.setText("1");
        } else {
            txtCodigo.setText(String.valueOf(Integer.parseInt(tblProdutos.getValueAt(tblProdutos.getRowCount() - 1, 0).toString()) + 1));
        }

    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        util.limparCampos(pnlCampos);
        util.habilitarComponentes(false, pnlCampos);
        util.habilitarBotoes(true, pnlBotoes);
        btnPesquisar.setText("Pesquisar");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtDescricao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite uma descrição para o produto.");
            return;
        }
        try {
            DaoProduto produtoTemp = new DaoProduto();
            produtoTemp.setCodProd(Integer.valueOf(txtCodigo.getText()));
            produtoTemp.setDescricao(txtDescricao.getText());
            produtoTemp.setQuantidade((Integer) spnQuantidade.getValue());
            produtoTemp.setPrecoUnit((Double) txtPreco.getValue());
            if (oper == Operacao.GRAVAR) {
                produtoTemp.Incluir();
            } else if (oper == Operacao.EDITAR) {
                produtoTemp.Alterar();
            }
            pro.addAll(produtoTemp.Pesquisar());
            btnCancelarActionPerformed(null);
            atualizaTabela(pro);
            btnIncluir.requestFocus();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Clique em Incluir para preencher os dados do produto.");
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(null, "Digite um preço válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao Gravar: \n"
                    + e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        util.limparCampos(pnlCampos);
        util.habilitarComponentes(true, pnlCampos);
        util.habilitarBotoes(false, pnlBotoes);
        txtCodigo.setEnabled(false);
        txtDescricao.requestFocus();
        oper = Operacao.EDITAR;
        try {
            //Verifica se tem produtos no grid
            if (tblProdutos.getRowCount() > 0) {
                //linha selecionada no JTable
                int posLinha = tblProdutos.getSelectedRow();
                //Verificando se a linha foi selecionada, caso 'true' pega os
                //dados da respectiva da respectiva linha e envia para os campos
                if (posLinha >= 0) {
                    txtCodigo.setText(tblProdutos.getValueAt(posLinha, 0).toString());
                    txtDescricao.setText(tblProdutos.getValueAt(posLinha, 1).toString());
                    spnQuantidade.setValue(Integer.valueOf(tblProdutos.getValueAt(posLinha, 2).toString()));
                    txtPreco.setValue(mfPreco.stringToValue(tblProdutos.getValueAt(posLinha, 3).toString()));
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um produto para alterar!",
                            "Erro:", JOptionPane.ERROR_MESSAGE);
                    btnCancelarActionPerformed(null);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não há produtos cadastrados ainda!",
                        "Erro:", JOptionPane.ERROR_MESSAGE);
                btnCancelarActionPerformed(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocoreu um erro ao Editar: " + e.getMessage(),
                    "Erro:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int posLinha = tblProdutos.getSelectedRow();
        oper = Operacao.EXCLUIR;
        try {
            if (tblProdutos.getRowCount() > 0 && posLinha >= 0) {
                txtCodigo.setText(tblProdutos.getValueAt(posLinha, 0).toString());
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.", "Erro!", JOptionPane.ERROR_MESSAGE);
                btnCancelarActionPerformed(null);
                return;
            }
//            for (DaoProduto produto : pro) {
//                if (Integer.parseInt(txtCodigo.getText()) == produto.getCodProd()) {
            Object[] op = {"Sim", "Não"};
            DaoProduto prod = new DaoProduto();
            prod.setCodProd(Integer.parseInt(txtCodigo.getText()));
            for (DaoProduto prods : pro) {
                if (prods.getCodProd() == prod.getCodProd()) {
                    prod = prods;
                    break;
                }
            }
            if (!teste) {
                if (JOptionPane.showOptionDialog(this, "Deseja mesmo excluir " + prod.getDescricao() + "?", "Aviso!", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, op, op[1]) == JOptionPane.YES_OPTION) {
                    prod.Excluir();
                }
            } else {
                prod.Excluir();
            }
//                }
//            }
            btnCancelarActionPerformed(null);
            // quando session = 0, o usuário não está excluindo vindo de uma pesquisa.
            // evita que a mensagem "Não foram encontrados produtos" do método atualizaTabela apareça.
            // quando session = 1, o usuário está excluindo um produto vindo da pesquisa.
            if (tblProdutos.getRowCount() == 1 && session != 1) {
                util.limparTable(tblProdutos);
            } else {
                atualizaTabela(pro);
                session = 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar excluir." + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
            btnCancelarActionPerformed(null);
            try {
                atualizaTabela(pro);
            } catch (SQLException ex) {
                Logger.getLogger(FrmProdutos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        switch (btnPesquisar.getText()) {
            case "Pesquisar":
                util.limparCampos(pnlCampos);
                txtCodigo.setEnabled(true);
                util.habilitarBotoes(false, pnlBotoes);
                btnGravar.setEnabled(false);
                btnPesquisar.setEnabled(true);
                btnPesquisar.setText("OK");
                break;
            case "Atualizar":
                btnPesquisar.setText("Pesquisar");
                btnCancelarActionPerformed(null);
                break;
            default:
                if (txtCodigo.getText().equals("")) {
            try {
                atualizaTabela(pro);
            } catch (SQLException ex) {
                Logger.getLogger(FrmProdutos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrmProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
                    //btnPesquisar.setText("Pesquisar");
                    btnCancelarActionPerformed(null);
                } else {
                    util.limparTable(tblProdutos);
                    if (pro.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Não há produtos registrados", "Atenção:", JOptionPane.WARNING_MESSAGE);
                    } else {
                        DefaultTableModel dadosProdutos = (DefaultTableModel) tblProdutos.getModel();
                        String Linha[] = new String[]{"", "", "", ""};
                        try {
                            int posicao = -1;
                            for (DaoProduto produto : pro) {
                                if (produto.getCodProd() == Integer.parseInt(txtCodigo.getText())) {
                                    posicao++;
                                    dadosProdutos.addRow(Linha);
                                    dadosProdutos.setValueAt(produto.getCodProd(), posicao, 0);
                                    dadosProdutos.setValueAt(produto.getDescricao(), posicao, 1);
                                    dadosProdutos.setValueAt(produto.getQuantidade(), posicao, 2);
                                    dadosProdutos.setValueAt(mfPreco.valueToString(produto.getPrecoUnit()), posicao, 3);
                                }
                            }
                            if (posicao == -1) {
                                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro.\nA tabela será atualizada.");
                                atualizaTabela(pro);
                                btnCancelarActionPerformed(null);
                                return;
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
                        }
                        util.limparCampos(pnlCampos);
                        util.habilitarBotoes(true, pnlBotoes);
                        btnCancelarActionPerformed(null);
                        btnIncluir.setEnabled(false);
                        btnAlterar.setEnabled(false);
                        btnExcluir.setEnabled(false);
                        btnPesquisar.setText("Atualizar");
                        session = 1;
                    }
                }
                break;
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed
// ——————— ActionPerformed dos 6 botões FIM ———————

// * * * * Eventos INÍCIO * * * *    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Object[] options = {"Sim", "Não"};
        if (teste) {
            dispose();
        } else {
            if (JOptionPane.showOptionDialog(this, "Deseja mesmo sair?", "Aviso!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * CheckBox que preenche 4 produtos atráves do método autofillParaTeste()
     */
    private void chkPreencherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPreencherActionPerformed
        //if (chkPreencher.isSelected())
        autofillParaTeste(true);
        chkPreencher.setEnabled(false);
    }//GEN-LAST:event_chkPreencherActionPerformed
    /**
     * Quando um produto na tabela é selecionado, os botões de incluir e alterar
     * são habilitados Isto é para que durante uma busca o usuário não inclua
     * nada antes de atualizar a tabela.
     */
    private void tblProdutosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblProdutosFocusGained
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_tblProdutosFocusGained
// ——————— EVENTOS FIM ———————

// * * * * Métodos INÍCIO * * * *     
    /**
     * Método de autocompletar o preenchimento de 4 produtos para facilitar fase
     * de testes. Ele é iniciado quando a checkBox chkPreencher é clicada.
     */
    private void autofillParaTeste(boolean teste) {
        if (teste) {
            int counter = 1;
            while (counter < 5) {
                btnIncluirActionPerformed(null);
                switch (counter) {
                    case 1:
                        txtDescricao.setText("Matryoshka púrpura");
                        spnQuantidade.setValue(102);
                        txtPreco.setValue(9.99);
                        btnGravarActionPerformed(null);
                        counter++;
                        break;
                    case 2:
                        txtDescricao.setText("Conta platina de LoL");
                        spnQuantidade.setValue(1);
                        txtPreco.setValue(0.25);
                        counter++;
                        btnGravarActionPerformed(null);
                        break;
                    case 3:
                        txtDescricao.setText("Hoverboard");
                        spnQuantidade.setValue(1);
                        txtPreco.setValue(80000.00);
                        btnGravarActionPerformed(null);
                        counter++;
                        break;
                    case 4:
                        txtDescricao.setText("Lava Lamp");
                        spnQuantidade.setValue(44);
                        txtPreco.setValue(20.00);
                        btnGravarActionPerformed(null);
                        counter++;
                        break;
                }
            }
        }
    }

    private void atualizaTabela(ArrayList<DaoProduto> produtos) throws SQLException, ClassNotFoundException {
        //Objeto para formatar Datas
        util.limparTable(tblProdutos);
        pro.clear();
        pro.addAll(new DaoProduto().Pesquisar());
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foram encontrados produtos.",
                    "Atenção!", JOptionPane.WARNING_MESSAGE);
        } else {
            //Modelo de Tabela para popular tblClientes(JTable)
            DefaultTableModel dadosProdutos = (DefaultTableModel) tblProdutos.getModel();
            //Linha em branco para incluir na tabela e criar espaço para inserir dados
            String Linha[] = new String[]{"", "", ""};
            try {
                //Criado como referencia para posição da linha
                int posicao = -1;
                for (Produto produto : pro) {
                    posicao++;
                    //incluindo linha em branco
                    dadosProdutos.addRow(Linha);
                    //preenchendo a linha em branco, celula a celula
                    dadosProdutos.setValueAt(produto.getCodProd(), posicao, 0);
                    dadosProdutos.setValueAt(produto.getDescricao(), posicao, 1);
                    dadosProdutos.setValueAt(produto.getQuantidade(), posicao, 2);
                    dadosProdutos.setValueAt(mfPreco.valueToString(produto.getPrecoUnit()), posicao, 3);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + e.getMessage(),
                        "Erro:", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
// ——————— Métodos FIM —————————

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
            java.util.logging.Logger.getLogger(FrmProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProdutos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JCheckBox chkPreencher;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JSpinner spnQuantidade;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}