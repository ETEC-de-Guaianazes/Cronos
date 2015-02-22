package frontEnd;

import Banco.*;
import Validacoes.Validacao;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Comum {

    private Conexao con = new Conexao();
    private Statement meustate;
    private ResultSet resultset;
    private Validacao vld = new Validacao();
    public int indiceTabelaNota;

    //Contrutor vazio
    public Comum() {
    }//Fim construtor

    //Trata String - Esse método transforma uma string em caracteres maiusculos
    public void getParaMaiuscula(JTextField txt) {
        txt.setText(vld.semAcento(txt.getText().toUpperCase()));
    }//Fim getParaMaiuscula

    //Trata String - Esse método transforma uma string em caracteres minusculos
    public void getParaMinuscula(JTextField txt) {
        txt.setText(vld.semAcento(txt.getText().toLowerCase()));
    }//Fim getParaMinuscula

    // Esse método cria e insere um modelo de tabela com dados
    // advindos de um banco de dados, através da instrução passada
    public void criarTabela(String sql, JTable tabela) {
        try {
            con.Conecta();
            meustate = Conexao.con.createStatement();
            resultset = meustate.executeQuery(sql);
            ResultSetMetaData md = resultset.getMetaData();
            String[] colunas = new String[md.getColumnCount()];
            String[] data = new String[colunas.length];
            for (int i = 0; i < colunas.length; i++) {
                colunas[i] = md.getColumnName(i + 1);
            }
            // proíbe edição de celulas
            final DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {

                @Override
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }
            };
            while (resultset.next()) {
                for (int i = 0; i < colunas.length; i++) {
                    data[i] = resultset.getString(i + 1);
                }
                modelo.addRow(data);
            }
            tabela.setModel(modelo);
            tabela.setCellSelectionEnabled(false);
            tabela.setAutoResizeMode(0);
            tabela.setColumnSelectionAllowed(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setForeground(Color.BLACK);
            tabela.setAutoCreateRowSorter(true);
            tabela.setShowHorizontalLines(true);
            tabela.setShowVerticalLines(true);
            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela.setRowSelectionAllowed(true);
            tabela.setIntercellSpacing(new Dimension(1, 1));
            tabela.setAutoCreateColumnsFromModel(true);
            tabela.setShowGrid(true);
            tabela.setOpaque(false);
            tabela.setDefaultRenderer(Object.class, new CellRenderer());
            tabela.getTableHeader().setFont(new java.awt.Font("sansserif", 1, 12));
            System.out.println("Tabela atualizada.");
            con.Fecha();
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar dados na Tabela");
            erro.printStackTrace();
        }
    }//Fim criarTabela()

    public void criarTabelaFuncionario(String sql, JTable tabela) {
        try {
            con.Conecta();
            meustate = Conexao.con.createStatement();
            resultset = meustate.executeQuery(sql);
            ResultSetMetaData md = resultset.getMetaData();
            String[] colunas = new String[md.getColumnCount()];
            String[] data = new String[colunas.length];
            for (int i = 0; i < colunas.length; i++) {
                colunas[i] = md.getColumnName(i + 1);
            }
            // proíbe edição de celulas
            final DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {

                @Override
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }
            };
            while (resultset.next()) {
                for (int i = 0; i < colunas.length; i++) {                    
                        data[i] = resultset.getString(i + 1);                    
                }
                modelo.addRow(data);
            }
            tabela.setModel(modelo);
            tabela.setCellSelectionEnabled(false);
            tabela.setAutoResizeMode(0);
            tabela.setColumnSelectionAllowed(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setForeground(Color.BLACK);
            tabela.setAutoCreateRowSorter(true);
            tabela.setShowHorizontalLines(true);
            tabela.setShowVerticalLines(true);
            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela.setRowSelectionAllowed(true);
            tabela.setIntercellSpacing(new Dimension(1, 1));
            tabela.setAutoCreateColumnsFromModel(true);
            tabela.setShowGrid(true);
            tabela.setOpaque(false);            
            tabela.getTableHeader().setFont(new java.awt.Font("sansserif", 1, 12));
            System.out.println("Tabela atualizada.");
            con.Fecha();
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar dados na Tabela de funcionário");
            erro.printStackTrace();
        }
    }//Fim criarTabelaFuncionario()

    // Esse método cria e insere um modelo de tabela com dados
    // advindos de um banco de dados, através da instrução passada
    public void criarTabelaProduto(String sql, JTable tabela) {
        try {
            con.Conecta();
            meustate = Conexao.con.createStatement();
            resultset = meustate.executeQuery(sql);
            ResultSetMetaData md = resultset.getMetaData();
            String[] colunas = new String[md.getColumnCount()];
            String[] data = new String[colunas.length];
            for (int i = 0; i < colunas.length; i++) {
                colunas[i] = md.getColumnName(i + 1);
            }
            // proíbe edição de celulas
            final DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {

                @Override
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }
            };
            while (resultset.next()) {
                for (int i = 0; i < colunas.length; i++) {
                    if (i == 3 || i == 4) {
                        double unitarioNumero = Double.parseDouble(resultset.getString(i + 1));
                        String valorUnitario = String.format("%.2f", unitarioNumero);
                        data[i] = valorUnitario;
                    } else {
                        data[i] = resultset.getString(i + 1);
                    }
                }
                modelo.addRow(data);
            }
            tabela.setModel(modelo);
            tabela.setCellSelectionEnabled(false);
            tabela.setAutoResizeMode(0);
            tabela.setColumnSelectionAllowed(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setForeground(Color.BLACK);
            tabela.setAutoCreateRowSorter(true);
            tabela.setShowHorizontalLines(true);
            tabela.setShowVerticalLines(true);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela.setRowSelectionAllowed(true);
            tabela.setIntercellSpacing(new Dimension(1, 1));
            tabela.setAutoCreateColumnsFromModel(true);
            tabela.setShowGrid(true);
            tabela.setOpaque(false);
            tabela.setDefaultRenderer(Object.class, new CellRenderer());
            tabela.getTableHeader().setFont(new java.awt.Font("sansserif", 1, 12));
            System.out.println("Tabela atualizada.");
            con.Fecha();
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar dados na Tabela");
            erro.printStackTrace();
        }
    }//Fim criarTabelaProduto()

    // Esse método cria e insere um modelo de tabela com dados
    // advindos de um banco de dados, através da instrução passada
    public void criarTabelaProdutoVenda(String sql, JTable tabela) {
        try {
            con.Conecta();
            meustate = Conexao.con.createStatement();
            resultset = meustate.executeQuery(sql);
            ResultSetMetaData md = resultset.getMetaData();
            String[] colunas = new String[md.getColumnCount()];
            String[] data = new String[colunas.length];
            for (int i = 0; i < colunas.length; i++) {
                colunas[i] = md.getColumnName(i + 1);
            }
            // proíbe edição de celulas
            final DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {

                @Override
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }
            };
            while (resultset.next()) {
                for (int i = 0; i < colunas.length; i++) {
                    if (i == 3) {
                        double unitarioNumero = Double.parseDouble(resultset.getString(i + 1));
                        String valorUnitario = String.format("%.2f", unitarioNumero);
                        data[i] = valorUnitario;
                    } else {
                        data[i] = resultset.getString(i + 1);
                    }
                }
                modelo.addRow(data);
            }
            tabela.setModel(modelo);
            tabela.setCellSelectionEnabled(false);
            tabela.setAutoResizeMode(0);
            tabela.setColumnSelectionAllowed(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setForeground(Color.BLACK);
            tabela.setAutoCreateRowSorter(true);
            tabela.setShowHorizontalLines(true);
            tabela.setShowVerticalLines(true);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela.setRowSelectionAllowed(true);
            tabela.setIntercellSpacing(new Dimension(1, 1));
            tabela.setAutoCreateColumnsFromModel(true);
            tabela.setShowGrid(true);
            tabela.setOpaque(false);
            tabela.setDefaultRenderer(Object.class, new CellRenderer());
            tabela.getTableHeader().setFont(new java.awt.Font("sansserif", 1, 12));
            System.out.println("Tabela atualizada.");
            con.Fecha();
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar dados na Tabela");
            erro.printStackTrace();
        }
    }//Fim criarTabelaProdutoVenda()

    // Esse método cria e insere um modelo de tabela com dados
    // advindos de um banco de dados, através da instrução passada
    public void criarTabelaServico(String sql, JTable tabela) {
        try {
            con.Conecta();
            meustate = Conexao.con.createStatement();
            resultset = meustate.executeQuery(sql);
            ResultSetMetaData md = resultset.getMetaData();
            String[] colunas = new String[md.getColumnCount()];
            String[] data = new String[colunas.length];
            for (int i = 0; i < colunas.length; i++) {
                colunas[i] = md.getColumnName(i + 1);
            }
            // proíbe edição de celulas
            final DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {

                @Override
                public boolean isCellEditable(int rowIndex, int vColIndex) {
                    return false;
                }
            };
            while (resultset.next()) {
                for (int i = 0; i < colunas.length; i++) {
                    if (i == 2) {
                        double unitarioNumero = Double.parseDouble(resultset.getString(i + 1));
                        String valorUnitario = String.format("%.2f", unitarioNumero);
                        data[i] = valorUnitario;
                    } else {
                        data[i] = resultset.getString(i + 1);
                    }
                }
                modelo.addRow(data);
            }
            tabela.setModel(modelo);
            tabela.setCellSelectionEnabled(false);
            tabela.setAutoResizeMode(0);
            tabela.setColumnSelectionAllowed(false);
            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setForeground(Color.BLACK);            
            tabela.setAutoCreateRowSorter(true);
            tabela.setShowHorizontalLines(true);
            tabela.setShowVerticalLines(true);
            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabela.setRowSelectionAllowed(true);
            tabela.setIntercellSpacing(new Dimension(1, 1));
            tabela.setAutoCreateColumnsFromModel(true);
            tabela.setShowGrid(true);
            tabela.setOpaque(false);
            tabela.setDefaultRenderer(Object.class, new CellRenderer());
            tabela.getTableHeader().setFont(new java.awt.Font("sansserif", 1, 12));
            System.out.println("Tabela atualizada.");
            con.Fecha();
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar dados na Tabela");
            erro.printStackTrace();
        }
    }//Fim criarTabelaServico()

    // Este método pega o índice correspondente em ComboBox
    // de uma UF passada como String
    public int indexEstado(String i) {
        int index = 0;
        if (i.equals("AC") == true) {
            index = 0;
        } else if (i.equals("AL") == true) {
            index = 1;
        } else if (i.equals("AP") == true) {
            index = 2;
        } else if (i.equals("AM") == true) {
            index = 3;
        } else if (i.equals("BA") == true) {
            index = 4;
        } else if (i.equals("CE") == true) {
            index = 5;
        } else if (i.equals("DF") == true) {
            index = 6;
        } else if (i.equals("ES") == true) {
            index = 7;
        } else if (i.equals("GO") == true) {
            index = 8;
        } else if (i.equals("MA") == true) {
            index = 9;
        } else if (i.equals("MT") == true) {
            index = 10;
        } else if (i.equals("MS") == true) {
            index = 11;
        } else if (i.equals("MG") == true) {
            index = 12;
        } else if (i.equals("PA") == true) {
            index = 13;
        } else if (i.equals("PB") == true) {
            index = 14;
        } else if (i.equals("PR") == true) {
            index = 15;
        } else if (i.equals("PE") == true) {
            index = 16;
        } else if (i.equals("PI") == true) {
            index = 17;
        } else if (i.equals("RJ") == true) {
            index = 18;
        } else if (i.equals("RN") == true) {
            index = 19;
        } else if (i.equals("RS") == true) {
            index = 20;
        } else if (i.equals("RO") == true) {
            index = 21;
        } else if (i.equals("RR") == true) {
            index = 22;
        } else if (i.equals("SC") == true) {
            index = 23;
        } else if (i.equals("SP") == true) {
            index = 24;
        } else if (i.equals("SE") == true) {
            index = 25;
        } else if (i.equals("TO") == true) {
            index = 26;
        } else {
            System.out.println("Tenso, nenhum estado...");
        }
        return index;
    }

    //Este método formata um campo de texto formatado para os valores inseridos via
    //parâmetro. Ex: setFormataNumero("###.###.###-##", txtCpf, "0123456789",'_');
    public void setFormataNumero(String maskFormat, JFormattedTextField jFormatedText, String validCar, char holderCharacter) {
        try {
            MaskFormatter mf = new MaskFormatter(maskFormat);
            mf.setValidCharacters(validCar);
            mf.setPlaceholderCharacter(holderCharacter);
            mf.install(jFormatedText);
        } catch (ParseException pe) {
            System.out.println("Erro na conversão dos dados no campo!" + pe);
        }
    }//Fim setFormataNumero

//----------- Navegação de dados -----------------------------------------------
    //Move seleção para o primeiro registro da tabela.
    public void Primeiro(JTable tabela) {
        tabela.getSelectionModel().setSelectionInterval(0, 0);
    }//Fim primeiro

    //Move seleção a uma linha anterior a corrente
    public void Anterior(JTable tabela) {
        if (tabela.getSelectedRow() >= 0 && tabela.getSelectedRow() < tabela.getRowCount()) {
            tabela.getSelectionModel().setSelectionInterval((tabela.getSelectedRow() - 1), (tabela.getSelectedRow() - 1));
        } else {
            tabela.getSelectionModel().setSelectionInterval((tabela.getRowCount() - 1), (tabela.getRowCount() - 1));
        }
    }//Fim Anterior

    //Move seleção a uma linha posterior a corrente
    public void Proximo(JTable tabela) {
        if (tabela.getSelectedRow() >= 0 && tabela.getSelectedRow() < (tabela.getRowCount() - 1)) {
            tabela.getSelectionModel().setSelectionInterval((tabela.getSelectedRow() + 1), (tabela.getSelectedRow() + 1));
        } else {
            tabela.getSelectionModel().setSelectionInterval((tabela.getRowCount() - 1), (tabela.getRowCount() - 1));
        }
    }//Fim Proximo

    //Move seleção para o ultimo registro da tabela.
    public void Ultimo(JTable tabela) {
        tabela.getSelectionModel().setSelectionInterval((tabela.getRowCount() - 1), (tabela.getRowCount() - 1));
    }//Fim Ultimo

//----------- Fim Navegação ----------------------------------------------------

    /* Esse método formata uma String para uma objeto sql.Date, pronto para
    ser inserido em um banco de dados ou JCalendar */
    public static java.sql.Date formataData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }//Fim formataData()

//------------ Classe privada CellRenderer -------------------------------------
    private class CellRenderer extends DefaultTableCellRenderer {

        public CellRenderer() {
            super();
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if ((row % 2) == 0) {
                super.setBackground(new Color(182, 190, 197));
            } else {
                super.setBackground(Color.WHITE);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }//Fim getTableCellRendererComponent()
        }//Fim classe CellRenderer
}//Fim da classe comum

