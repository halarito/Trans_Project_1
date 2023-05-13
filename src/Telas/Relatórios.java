/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.sql.*;

import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Arlindo Halar
 */



public class Relatórios extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Relatórios
     */
    public Relatórios() {
        initComponents();

        conexao = Modulo.conector();

        preencherSaida();
        preencherEntrada();

        data();
        presencaActual();
        //setDia();
        
        //System.out.println(dia+"/"+mes+"/"+ano);
        
        System.out.println(jSpinner1.getValue().toString());
            System.out.println(mes_);
            System.out.println(jSpinner3.getValue().toString());
    }

    String viagem;
    String mes_;
    
    String ano;
    String mes;
    String dia;
    
    
    
    String data;

    void presencaActual(){
        
        String v = "select c.id_func, f.nome from conoff c inner join funcionario f on f.id = c.id_func where descricao = ?";
        
        try {
            pst = conexao.prepareStatement(v);
            pst.setString(1, "on");
            rs = pst.executeQuery();
            
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            /*if(rs.next()){
                jTable3.setModel(DbUtils.resultSetToTableModel(rs));
            }*/
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }
    
    void setDia(){
        jSpinner1.setValue(Integer.parseInt(dia));
    }
    
    void data(){
        
        Date dataSistema = new Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        SimpleDateFormat mes_act = new SimpleDateFormat("MM");
        SimpleDateFormat ano_act = new SimpleDateFormat("yyyy");
        SimpleDateFormat dia_act = new SimpleDateFormat("dd");
        
        jLabel5.setText(formato.format(dataSistema));

        ano = ano_act.format(dataSistema);
        mes = mes_act.format(dataSistema);
        dia = dia_act.format(dataSistema);
        data = dia+"/"+mes+"/"+ano;
        
        
        Timer timer = new Timer(1000, new hora());
        timer.start();
       
        
    }
    
    void preencherEntrada() {

        viagem = "ida";

        if (jSpinner2.getValue() == "Janeiro") {
            mes_ = "01";
        } else if (jSpinner2.getValue() == "Fevereiro") {
            mes_ = "02";
        } else if (jSpinner2.getValue() == "Março") {
            mes_ = "03";
        } else if (jSpinner2.getValue() == "Abril") {
            mes_ = "04";
        } else if (jSpinner2.getValue() == "Maio") {
            mes_ = "05";
        } else if (jSpinner2.getValue() == "Junho") {
            mes_ = "06";
        } else if (jSpinner2.getValue() == "Julho") {
            mes_ = "07";
        } else if (jSpinner2.getValue() == "Agosto") {
            mes_ = "08";
        } else if (jSpinner2.getValue() == "Setembro") {
            mes_ = "09";
        } else if (jSpinner2.getValue() == "Outubro") {
            mes_ = "10";
        } else if (jSpinner2.getValue() == "Novembro") {
            mes_ = "11";
        } else if (jSpinner2.getValue() == "Dezembro") {
            mes_ = "12";
        }

        String sql = "Select c.id, c.viagem, c.id_func, f.nome, c.id_carro, c.data from controle c inner join funcionario f on c.id_func = f.id where viagem = ? and c.data = ? order by c.id";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, viagem);
            pst.setString(2, jSpinner1.getValue().toString() + "/" + mes_ + "/" + jSpinner3.getValue().toString());
            /*pst.setString(2, jSpinner1.getValue().toString());
            pst.setString(3, mes_);
            pst.setString(4, jSpinner1.getValue().toString());*/

            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void preencherSaida() {

        viagem = "volta";

        if (jSpinner2.getValue() == "Janeiro") {
            mes_ = "01";
        } else if (jSpinner2.getValue() == "Fevereiro") {
            mes_ = "02";
        } else if (jSpinner2.getValue() == "Março") {
            mes_ = "03";
        } else if (jSpinner2.getValue() == "Abril") {
            mes_ = "04";
        } else if (jSpinner2.getValue() == "Maio") {
            mes_ = "05";
        } else if (jSpinner2.getValue() == "Junho") {
            mes_ = "06";
        } else if (jSpinner2.getValue() == "Julho") {
            mes_ = "07";
        } else if (jSpinner2.getValue() == "Agosto") {
            mes_ = "08";
        } else if (jSpinner2.getValue() == "Setembro") {
            mes_ = "09";
        } else if (jSpinner2.getValue() == "Outubro") {
            mes_ = "10";
        } else if (jSpinner2.getValue() == "Novembro") {
            mes_ = "11";
        } else if (jSpinner2.getValue() == "Dezembro") {
            mes_ = "12";
        }

        String sql = "Select c.id, c.viagem, c.id_func, f.nome, c.id_carro, c.data from controle c inner join funcionario f on c.id_func = f.id where viagem = ? and c.data = ? order by c.id";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, viagem);
            pst.setString(2, jSpinner1.getValue().toString() + "/" + mes_ + "/" + jSpinner3.getValue().toString());

            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void preencherEntradaF() {

        viagem = "ida";

        if (jSpinner2.getValue() == "Janeiro") {
            mes_ = "01";
        } else if (jSpinner2.getValue() == "Fevereiro") {
            mes_ = "02";
        } else if (jSpinner2.getValue() == "Março") {
            mes_ = "03";
        } else if (jSpinner2.getValue() == "Abril") {
            mes_ = "04";
        } else if (jSpinner2.getValue() == "Maio") {
            mes_ = "05";
        } else if (jSpinner2.getValue() == "Junho") {
            mes_ = "06";
        } else if (jSpinner2.getValue() == "Julho") {
            mes_ = "07";
        } else if (jSpinner2.getValue() == "Agosto") {
            mes_ = "08";
        } else if (jSpinner2.getValue() == "Setembro") {
            mes_ = "09";
        } else if (jSpinner2.getValue() == "Outubro") {
            mes_ = "10";
        } else if (jSpinner2.getValue() == "Novembro") {
            mes_ = "11";
        } else if (jSpinner2.getValue() == "Dezembro") {
            mes_ = "12";
        }

        String sql = "Select c.id, c.viagem, c.id_func, f.nome, c.id_carro, c.data from controle c inner join funcionario f on c.id_func = f.id where viagem = ? and c.id_func = ? and c.mes = ? order by c.id";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, viagem);
            pst.setString(2, jSpinner5.getValue().toString());
            pst.setString(3, mes_);
            

            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void preencherSaidaF() {

        viagem = "volta";

        if (jSpinner2.getValue() == "Janeiro") {
            mes_ = "01";
        } else if (jSpinner2.getValue() == "Fevereiro") {
            mes_ = "02";
        } else if (jSpinner2.getValue() == "Março") {
            mes_ = "03";
        } else if (jSpinner2.getValue() == "Abril") {
            mes_ = "04";
        } else if (jSpinner2.getValue() == "Maio") {
            mes_ = "05";
        } else if (jSpinner2.getValue() == "Junho") {
            mes_ = "06";
        } else if (jSpinner2.getValue() == "Julho") {
            mes_ = "07";
        } else if (jSpinner2.getValue() == "Agosto") {
            mes_ = "08";
        } else if (jSpinner2.getValue() == "Setembro") {
            mes_ = "09";
        } else if (jSpinner2.getValue() == "Outubro") {
            mes_ = "10";
        } else if (jSpinner2.getValue() == "Novembro") {
            mes_ = "11";
        } else if (jSpinner2.getValue() == "Dezembro") {
            mes_ = "12";
        }

        String sql = "Select c.id, c.viagem, c.id_func, f.nome, c.id_carro, c.data from controle c inner join funcionario f on c.id_func = f.id where viagem = ? and c.id_func = ? and c.mes = ? order by c.id";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, viagem);
            pst.setString(2, jSpinner5.getValue().toString());
            pst.setString(3, mes_);

            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void preencherEntradaT() { //Preenchimento da tabela Entrada com comboio como filtro

        viagem = "ida";

        if (jSpinner2.getValue() == "Janeiro") {
            mes_ = "01";
        } else if (jSpinner2.getValue() == "Fevereiro") {
            mes_ = "02";
        } else if (jSpinner2.getValue() == "Março") {
            mes_ = "03";
        } else if (jSpinner2.getValue() == "Abril") {
            mes_ = "04";
        } else if (jSpinner2.getValue() == "Maio") {
            mes_ = "05";
        } else if (jSpinner2.getValue() == "Junho") {
            mes_ = "06";
        } else if (jSpinner2.getValue() == "Julho") {
            mes_ = "07";
        } else if (jSpinner2.getValue() == "Agosto") {
            mes_ = "08";
        } else if (jSpinner2.getValue() == "Setembro") {
            mes_ = "09";
        } else if (jSpinner2.getValue() == "Outubro") {
            mes_ = "10";
        } else if (jSpinner2.getValue() == "Novembro") {
            mes_ = "11";
        } else if (jSpinner2.getValue() == "Dezembro") {
            mes_ = "12";
        }

        String sql = "Select c.id, c.viagem, c.id_func, f.nome, c.id_carro, c.data from controle c inner join funcionario f on c.id_func = f.id where viagem = ? and c.data = ? and c.id_carro = ? order by c.id";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, viagem);
            pst.setString(2, jSpinner1.getValue().toString() + "/" + mes_ + "/" + jSpinner3.getValue().toString());
            pst.setString(3, jSpinner4.getValue().toString());

            rs = pst.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void preencherSaidaT() {

        viagem = "volta";

        if (jSpinner2.getValue() == "Janeiro") {
            mes_ = "01";
        } else if (jSpinner2.getValue() == "Fevereiro") {
            mes_ = "02";
        } else if (jSpinner2.getValue() == "Março") {
            mes_ = "03";
        } else if (jSpinner2.getValue() == "Abril") {
            mes_ = "04";
        } else if (jSpinner2.getValue() == "Maio") {
            mes_ = "05";
        } else if (jSpinner2.getValue() == "Junho") {
            mes_ = "06";
        } else if (jSpinner2.getValue() == "Julho") {
            mes_ = "07";
        } else if (jSpinner2.getValue() == "Agosto") {
            mes_ = "08";
        } else if (jSpinner2.getValue() == "Setembro") {
            mes_ = "09";
        } else if (jSpinner2.getValue() == "Outubro") {
            mes_ = "10";
        } else if (jSpinner2.getValue() == "Novembro") {
            mes_ = "11";
        } else if (jSpinner2.getValue() == "Dezembro") {
            mes_ = "12";
        }

        String sql = "Select c.id, c.viagem, c.id_func, f.nome, c.id_carro, c.data from controle c inner join funcionario f on c.id_func = f.id where viagem = ? and c.data = ? and c.id_carro = ? order by c.id";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, viagem);
            pst.setString(2, jSpinner1.getValue().toString() + "/" + mes_ + "/" + jSpinner3.getValue().toString());
            pst.setString(3, jSpinner4.getValue().toString());
            rs = pst.executeQuery();

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
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

        MainPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSpinner6 = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSpinner7 = new javax.swing.JSpinner();
        jButton6 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jButton7 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Relatório - TransProject");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTRADAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SAIDAS");

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Dia:");

        jSpinner1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerListModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mês:");

        jSpinner2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinner2.setModel(new javax.swing.SpinnerListModel(new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ano:");

        jSpinner3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinner3.setModel(new javax.swing.SpinnerListModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("P");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cod. do Comboio:");

        jSpinner4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinner4.setModel(new javax.swing.SpinnerListModel(new String[] {"TP001", "TP002", "TP003", "TP004", "TP005", "TP006", "TP007", "TP008", "TP009", "TP010"}));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("P");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Funcionário:");

        jSpinner5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinner5.setModel(new javax.swing.SpinnerListModel(new String[] {"1", "2", "3", "4", "5"}));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("P");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("ACT");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(37, 37, 37)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton4)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jLabel10, jLabel4, jLabel7, jLabel8, jLabel9, jSeparator2, jSeparator3, jSeparator4, jSpinner1, jSpinner2, jSpinner3, jSpinner4, jSpinner5});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel4, jPanel5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("ENTRADAS E SAIDAS", jPanel1);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Cod. do Comboio:");

        jSpinner6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Pesquisar");

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Funcionário:");

        jSpinner7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Pesquisar");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setText("Pesquisar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(42, 42, 42)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addComponent(jSpinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton7)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jSpinner7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSpinner6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Funcionários em transporte");

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator7)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("SITUAÇÃO ACTUAL", jPanel2);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        preencherEntrada();
        preencherSaida();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        preencherEntradaT();
        preencherSaidaT();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        preencherEntrada();
        preencherSaida();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        preencherEntrada();
        preencherSaida();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        // TODO add your handling code here:
        preencherEntrada();
        preencherSaida();
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
        // TODO add your handling code here:
        preencherEntrada();
        preencherSaida();
    }//GEN-LAST:event_jSpinner3StateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        preencherEntradaF();
        preencherSaidaF();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        presencaActual();
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Relatórios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatórios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatórios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatórios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatórios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();

            jLabel6.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }

    }

}
