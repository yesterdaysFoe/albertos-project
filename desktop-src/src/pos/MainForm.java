/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import classes.Customer;
import classes.Orders;
import classes.ProductVariations;
import classes.Products;
import classes.Sell;
import classes.TextAreaRenderer;
import classes.TransactionVo;
import config.Config;
import controllers.TransactionsJpaController;
import controllers.Wp1PostmetaJpaController;
import controllers.Wp1PostsJpaController;
import controllers.Wp1TermRelationshipsJpaController;
import controllers.exceptions.NonexistentEntityException;
import entities.Transactions;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.observablecollections.ObservableCollections;
import utils.CalendarUtil;
import utils.MyUtil;
import utils.PrintUtil;
import utils.SearchTable;
import utils.TransactionUtil;

/**
 *
 * @author David Daniel Kurtz <daviddanielkurtz@gmail.com>
 */
public class MainForm extends javax.swing.JFrame {

    private static MainForm instance;
    private String currentAction;
    private List<Orders> orders;
    private List<Products> products;
    private List<Sell> sells;
    private List<Sell> tempSells;
    private List<TransactionVo> transactionVos;
    private List<Customer> customers;
    private Orders currentOrder;
    private List<ProductVariations> pvList;
    private Sell selectedSell;

    {
        orders = ObservableCollections.observableList(new ArrayList<Orders>());
        products = ObservableCollections.observableList(new ArrayList<Products>());
        sells = ObservableCollections.observableList(new ArrayList<Sell>());
        tempSells = ObservableCollections.observableList(new ArrayList<Sell>());
        transactionVos = ObservableCollections.observableList(new ArrayList<TransactionVo>());
        customers = ObservableCollections.observableList(new ArrayList<Customer>());
        pvList = ObservableCollections.observableList(new ArrayList<ProductVariations>());;
    }

    private MainForm() {
        initComponents();
        initTable();
    }

    public static MainForm getInstance() {
        if (instance == null) {
            synchronized (MainForm.class) {
                if (instance == null) {
                    instance = new MainForm();
                }
            }
        }
        return instance;
    }

    public List<Sell> getTempSells() {
        return tempSells;
    }

    public void setTempSells(List<Sell> tempSells) {
        this.tempSells = tempSells;
    }

    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    public static void setLookAndFeel() {
        try {
            Properties props = new Properties();
            props.put("logoString", "");
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Red", "INSERT YOUR LICENSE KEY HERE", "");
//            AcrylLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        } //</editor-fold>
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="SettersAndGetters">
    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Sell> getSells() {
        return sells;
    }

    public void setSells(List<Sell> sells) {
        this.sells = sells;
    }

    public Orders getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Orders currentOrder) {
        this.currentOrder = currentOrder;
    }

    public List<TransactionVo> getTransactionVos() {
        return transactionVos;
    }

    public void setTransactionVos(List<TransactionVo> transactionVos) {
        this.transactionVos = transactionVos;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jDialog1 = new javax.swing.JDialog(this, true);
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinField1 = new com.toedter.components.JSpinField();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog(this, true);
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jDialog3 = new javax.swing.JDialog(this, true);
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jDialog4 = new javax.swing.JDialog(this, true);
        jButton26 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton15 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        jDialog1.setBounds(new java.awt.Rectangle(0, 0, 400, 280));
        jDialog1.setResizable(false);

        jLabel6.setText("Product Name:");

        jLabel7.setText("Qty:");

        jLabel8.setText("@Price:");

        jSpinField1.setMaximum(500);
        jSpinField1.setMinimum(1);
        jSpinField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSpinField1PropertyChange(evt);
            }
        });

        jLabel9.setText("Total Price:");

        jButton5.setMnemonic('x');
        jButton5.setText("Cancel [Alt + x]");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setMnemonic('s');
        jButton6.setText("Done [Alt+s]");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusGained(evt);
            }
        });
        jFormattedTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextField1PropertyChange(evt);
            }
        });
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
        });

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane5.setViewportView(jTextArea1);

        jLabel15.setText("Comments:");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(2);
        jTextArea2.setWrapStyleWord(true);
        jScrollPane8.setViewportView(jTextArea2);

        jLabel16.setText("Size:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8 inches", "12 inches", "16 inches" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${pvList}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(10, 10, 10))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinField1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16))))
                        .addGap(18, 18, 18)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jDialog2.setBounds(new java.awt.Rectangle(0, 0, 320, 280));
        jDialog2.setResizable(false);

        jLabel10.setText("Sold to:");

        jTextField7.setEditable(false);

        jLabel11.setText("Total Amount:");

        jLabel12.setText("Cash Tendered:");

        jLabel13.setText("Change:");

        jButton7.setMnemonic('x');
        jButton7.setText("Cancel [Alt + x]");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setMnemonic('c');
        jButton8.setText("Continue [Alt + C]");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField4FocusGained(evt);
            }
        });
        jFormattedTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField4KeyReleased(evt);
            }
        });

        jFormattedTextField6.setEditable(false);
        jFormattedTextField6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField6.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jFormattedTextField5.setEditable(false);
        jFormattedTextField5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField5.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(13, 13, 13)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7)
                            .addGroup(jDialog2Layout.createSequentialGroup()
                                .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 51, Short.MAX_VALUE))))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jFormattedTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        jDialog3.setBounds(new java.awt.Rectangle(0, 0, 500, 400));

        jButton22.setMnemonic('x');
        jButton22.setText("Cancel");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setMnemonic('s');
        jButton23.setText("Use Selected");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${customers}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable6);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${completeName}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${address}"));
        columnBinding.setColumnName("Address");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactNo}"));
        columnBinding.setColumnName("Contact No.");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane7.setViewportView(jTable6);

        jLabel22.setText("Search");

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(jButton23))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11)))
                .addContainerGap())
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jButton23))
                .addContainerGap())
        );

        jDialog4.setBounds(new java.awt.Rectangle(0, 0, 500, 400));

        jButton26.setMnemonic('s');
        jButton26.setText("Ok");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setText("The following cannot be procces because the remaing qty. is zero!");

        jTable8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable8.setRowHeight(25);
        jTable8.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${tempSells}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable8);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qty}"));
        columnBinding.setColumnName("Qty.");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${product}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(classes.Products.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceStr}"));
        columnBinding.setColumnName("@Price");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalPrice}"));
        columnBinding.setColumnName("Total Price");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${remainingQty}"));
        columnBinding.setColumnName("Remaining Qty");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable8MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTable8);
        if (jTable8.getColumnModel().getColumnCount() > 0) {
            jTable8.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialog4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                .addComponent(jButton26)
                .addContainerGap())
            .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialog4Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addGap(51, 51, 51)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 245, 137));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(723, 50));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 924, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(470, 503));

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable4.setRowHeight(25);
        jTable4.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${sells}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable4);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qty}"));
        columnBinding.setColumnName("Qty");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${product.realName}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceStr}"));
        columnBinding.setColumnName("@Price");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalPrice}"));
        columnBinding.setColumnName("Total Price");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMaxWidth(80);
            jTable4.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jButton4.setText("Remove");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        jPanel9.setBackground(new java.awt.Color(255, 245, 137));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Now Serving", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel5.setText("Email:");

        jLabel4.setText("Contact No.:");

        jLabel3.setText("Address:");

        jLabel2.setText("Name:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField2, jTextField3, jTextField4, jTextField5});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jFormattedTextField3.setEditable(false);
        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField3.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jFormattedTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton3.setMnemonic('1');
        jButton3.setText("Pay [Alt+ 1]");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setText("Reset");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Browse Previous Customer");
        jButton10.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel25.setText("Invoice No:");

        jTextField12.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(9, 9, 9)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, jButton4, jButton9});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton9))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(jPanel8, java.awt.BorderLayout.WEST);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.BorderLayout());

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${products}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("ID");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productName}"));
        columnBinding.setColumnName("Product Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${productDetails}"));
        columnBinding.setColumnName("Product Details");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Category");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${priceStr}"));
        columnBinding.setColumnName("Price");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable3.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        jPanel10.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel11.setOpaque(false);
        jPanel11.setPreferredSize(new java.awt.Dimension(304, 50));

        jLabel14.setText("Search:");

        jButton18.setText("Refresh");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton18)
                .addGap(101, 101, 101)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18))
                .addContainerGap())
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel10, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("     Sell     ", jPanel6);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${orders}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Order No.");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${customer.completeDetails}"));
        columnBinding.setColumnName("Name | Address | Contact No. | Email");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalOrderStr}"));
        columnBinding.setColumnName("Order Total Amount");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderDate}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderStatus}"));
        columnBinding.setColumnName("Order Status");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(723, 70));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Process Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Change Order Status"));
        jPanel18.setOpaque(false);

        jButton19.setText("On-Hold");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Processing");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Cancelled");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton19)
                .addGap(4, 4, 4)
                .addComponent(jButton20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton19, jButton20, jButton21});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel13.setOpaque(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(304, 50));

        jLabel17.setText("Search:");

        jButton17.setText("Refresh");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17)
                .addGap(501, 501, 501)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Orders", jPanel2);

        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.BorderLayout());

        jTable5.getTableHeader().setReorderingAllowed(false);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${transactionVos}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable5);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${invoiceStr}"));
        columnBinding.setColumnName("Invoice No.");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateStr}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${customerName}"));
        columnBinding.setColumnName("Customer Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${totalPriceStr}"));
        columnBinding.setColumnName("Total Price");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane6.setViewportView(jTable5);

        jPanel15.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jPanel16.setOpaque(false);
        jPanel16.setPreferredSize(new java.awt.Dimension(723, 70));

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton12.setText("Void");
        jButton12.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton13.setText("Print");
        jButton13.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton14.setText("View Details");
        jButton14.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Total:");

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12)
                        .addComponent(jButton14)
                        .addComponent(jLabel23)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton12, jButton13, jButton14});

        jPanel15.add(jPanel16, java.awt.BorderLayout.SOUTH);

        jPanel17.setOpaque(false);
        jPanel17.setPreferredSize(new java.awt.Dimension(304, 50));

        jLabel19.setText("From:");

        jLabel20.setText("To:");

        jButton15.setText("Filter");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel21.setText("Search:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addContainerGap())
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDateChooser1, jDateChooser2});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDateChooser1, jDateChooser2});

        jPanel15.add(jPanel17, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("Transactions", jPanel15);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jPanel14.setBackground(new java.awt.Color(255, 245, 137));
        jPanel14.setPreferredSize(new java.awt.Dimension(304, 200));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(255, 245, 137));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/521269_3648959376786_1193816598_n.jpg"))); // NOI18N
        jLabel18.setToolTipText("");
        jPanel14.add(jLabel18, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel14, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTable1.getSelectedRowCount() == 1) {
            reset();
            int r = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());

            setCurrentOrder(getOrders().get(r));
            setCustomer(getOrders().get(r).getCustomer());

            getSells().clear();
            getSells().addAll(new Wp1PostsJpaController(Config.getInstance()).findSells(Integer.parseInt(getOrders().get(r).getId())));
            prepareSells();

            if (!getTempSells().isEmpty()) {
                jDialog4.setLocationRelativeTo(this);
                jDialog4.setVisible(true);
            }
            if (getSells().isEmpty()) {
                reset();
            }

            jTabbedPane1.setSelectedIndex(0);
            total();
        } else {
            MyUtil.showErrorMessage(this, "please select one");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!jTextField2.getText().equals("")) {
            if (sells.isEmpty()) {
                MyUtil.showErrorMessage(this, "No Item(s) to pay.");
            } else {
                jTextField7.setText(jTextField2.getText());
                jFormattedTextField6.setValue(jFormattedTextField3.getValue());
                jFormattedTextField4.setValue(0);
                jFormattedTextField5.setValue(0);

                jDialog2.setLocationRelativeTo(this);
                jDialog2.setVisible(true);
            }
        } else {
            MyUtil.showErrorMessage(this, "Customer Name should not be empty.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        if (evt.getClickCount() == 2) {
            currentAction = MyUtil.ADD;
            showPriceFields(true, "Add");
            int r = jTable3.convertRowIndexToModel(jTable3.getSelectedRow());
            populateProductInfoFields(getProducts().get(r).getProductName(), 1, Double.parseDouble(getProducts().get(r).getPrice()), Double.parseDouble(getProducts().get(r).getPrice()));
            initProductVariation(getProducts().get(r));
            showDialog1();
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (currentAction.equals(MyUtil.EDIT)) {
            getSells().remove(getSelectedSell());

            Sell s = getSelectedSell();
            prepareSell(s);

            String adss = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : null;
            s.getProduct().setAddText((adss.isEmpty() ? "" : "\nSIZE: " + adss));
            getSells().add(s);
        } else {
            Sell s = new Sell();
            prepareSell(s);

            Products p = new Products();
            int r = jTable3.convertRowIndexToModel(jTable3.getSelectedRow());
            final Products selectedProduct = getProducts().get(r);
            p.setId(selectedProduct.getId());
            p.setCategory(selectedProduct.getCategory());
            p.setPrice(selectedProduct.getPrice());
            p.setProductDetails(selectedProduct.getProductDetails());
            String adss = jComboBox1.getSelectedItem() != null ? jComboBox1.getSelectedItem().toString() : null;
            p.setAddText((adss == null || adss.isEmpty() ? "" : "\nSIZE: " + adss));
            p.setProductName(selectedProduct.getProductName());
            p.setSku(p.getSku());
            s.setProduct(p);

            getSells().add(s);
        }

        total();
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        if (evt.getClickCount() == 2) {
            currentAction = MyUtil.EDIT;
            showPriceFields(true, "Edit");
            int r = jTable4.convertRowIndexToModel(jTable4.getSelectedRow());
            setSelectedSell(getSells().get(r));

            populateProductInfoFields(getSells().get(r).getProduct().getProductName(), getSells().get(r).getQty(), Double.parseDouble(getSells().get(r).getPrice()), Double.parseDouble(getSells().get(r).getPrice()));
            initProductVariation(getSells().get(r).getProduct());
            jComboBox1.setSelectedItem(findSelectedVariation(r));
            showDialog1();
        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        closeDialog1();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        closeDialog2();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (Double.parseDouble(jFormattedTextField4.getValue().toString()) >= Double.parseDouble(jFormattedTextField6.getValue().toString())) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to continue? ", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                processAction();

                jDialog2.setVisible(false);
                if (Double.parseDouble(jFormattedTextField5.getValue().toString()) > 0) {
                    MyUtil.showInfoMessage(this, "Please issue change " + jFormattedTextField5.getText() + " to " + jTextField2.getText());
                }


                int confirm1 = JOptionPane.showConfirmDialog(this, "Print Invoice? ", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm1 == 0) {
                    PrintUtil print = new PrintUtil();
                    Map param = new HashMap<>();
                    param.put("invoicNo", jTextField12.getText());
                    param.put("vat", MyUtil.decimalFormat.format((Double.parseDouble(jFormattedTextField3.getText().replaceAll(",", "")) * 0.12)));
                    param.put("total", jTextField3.getText());
                    print.Printing(jTable4.getModel(), "reports/invoice.jrxml", "Invoice", param, null);
                }
                MyUtil.showSuccessMessage(this, "Transaction has been saved succesfully.");
                reset();
            }
        } else {
            MyUtil.showErrorMessage(this, "insufficient amount tender.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTable4.getSelectedRowCount() == 1) {
            int r = jTable4.convertRowIndexToModel(jTable4.getSelectedRow());
            getSells().remove(getSells().get(r));
            total();
        } else {
            MyUtil.showErrorMessage(this, "Please select first.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jFormattedTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField4FocusGained
        jFormattedTextField4.selectAll();
    }//GEN-LAST:event_jFormattedTextField4FocusGained

    private void jFormattedTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField4KeyReleased
        if (!jFormattedTextField4.getText().equals("")) {
            jFormattedTextField5.setValue(Double.parseDouble(jFormattedTextField4.getText().replaceAll(",", "")) - Double.parseDouble(jFormattedTextField3.getValue().toString()));
        }
    }//GEN-LAST:event_jFormattedTextField4KeyReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "All fields will be clear.\nAre you sure you want to reset input?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            reset();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jSpinField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinField1PropertyChange
        if (jDialog1.isVisible()) {
            jFormattedTextField2.setValue(jSpinField1.getValue() * Double.parseDouble(jFormattedTextField1.getValue().toString()));
        }
    }//GEN-LAST:event_jSpinField1PropertyChange

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased
    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jFormattedTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextField1PropertyChange
        if (jFormattedTextField1.getValue() != null) {
            jFormattedTextField2.setValue(jSpinField1.getValue() * Double.parseDouble(jFormattedTextField1.getValue().toString()));
        }
    }//GEN-LAST:event_jFormattedTextField1PropertyChange

    private void jFormattedTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusGained
        jFormattedTextField1.selectAll();
    }//GEN-LAST:event_jFormattedTextField1FocusGained

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (jTable5.getSelectedRowCount() == 1) {
            int r = jTable5.convertRowIndexToModel(jTable5.getSelectedRow());
            int confirm = JOptionPane.showConfirmDialog(this, "Void Transaction means that this transaction is a mistake or should not be a here.\n\nAre you sure you want to void selected transaction?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                TransactionsJpaController controller = new TransactionsJpaController(Config.getInstance());
                voidParrentTransaction(r, controller);
                MyUtil.showSuccessMessage(this, "Action has been successfully performed.");
            }
        } else {
            MyUtil.showErrorMessage(this, "Please select one.");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        PrintUtil print = new PrintUtil();
        Map param = new HashMap<>();
        param.put("total", jTextField6.getText());
        print.Printing(jTable5.getModel(), "reports/transactions.jrxml", "Transactions", param, null);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (jTable5.getSelectedRowCount() == 1) {
            int r = jTable5.convertRowIndexToModel(jTable5.getSelectedRow());

            TransactionsJpaController controller = new TransactionsJpaController(Config.getInstance());
            TransactionDetailsDialog.getInstance().populateFileds(controller.findEntity(getTransactionVos().get(r).getId()), controller.findTransactionByParrent(getTransactionVos().get(r).getId()));

            TransactionDetailsDialog.getInstance().setLocationRelativeTo(this);
            TransactionDetailsDialog.getInstance().setVisible(true);
        } else {
            MyUtil.showErrorMessage(this, "Please select one.");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (jDateChooser1.getDate() != null && jDateChooser2.getDate() != null
                && (jDateChooser1.getDate().equals(jDateChooser2.getDate()) || jDateChooser1.getDate().before(jDateChooser2.getDate()))) {
            TransactionsJpaController transactionsJpaController = new TransactionsJpaController(Config.getInstance());
            List<Object[]> objects = transactionsJpaController.findParrentTransactionByDate(CalendarUtil.setTimeToZero(jDateChooser1.getDate()).getTime(), CalendarUtil.setTimeToEndTime(jDateChooser2.getDate()).getTime());
            getTransactionVos().clear();
            getTransactionVos().addAll(TransactionUtil.convertToTransactionVo(objects));
            totalTransactions();
        } else {
            MyUtil.showErrorMessage(this, "Invalid dates.");
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        checkOrder();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        changeOrderStatus("on-hold");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        changeOrderStatus("processing");
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        changeOrderStatus("cancelled");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        hideJdialog3();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if (jTable6.getSelectedRowCount() == 1) {
            int r = jTable6.convertRowIndexToModel(jTable6.getSelectedRow());
            setCustomer(getCustomers().get(r));
            hideJdialog3();
        } else {
            MyUtil.showErrorMessage(jDialog3, "Please select one.");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        initCustomers();
        jDialog3.setLocationRelativeTo(this);
        jDialog3.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        initProducts();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        jDialog4.setVisible(false);
        jDialog4.dispose();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTable8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable8MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (Config.getInstance().isOpen()) {
            Config.getInstance().close();
        }
        Config.resetInstance();
    }//GEN-LAST:event_formWindowClosing

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jDialog1.isVisible()) {
            jFormattedTextField1.setValue(Double.parseDouble(findVariationPrice().toString()));
            jFormattedTextField2.setValue(jSpinField1.getValue() * Double.parseDouble(jFormattedTextField1.getValue().toString()));
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private Task task;

    public void initProducts() {
        init = "initProducts";
        task = new Task();
        task.execute();
    }

    private void initOrders() {
        init = "initOrders";
        task = new Task();
        task.execute();
    }

    private void total() {
        double total = 0;
        for (Sell s : getSells()) {
            total += Double.parseDouble(s.getTotalPrice().replaceAll(",", ""));
        }
        jFormattedTextField3.setValue(total);
    }

    private void closeDialog1() {
        jDialog1.setVisible(false);
        jDialog1.dispose();
    }

    private void initTable() {
        new SearchTable().activate(jTable3, jTextField1, 0, 1, 2, 3, 4, 5, 6);
        new SearchTable().activate(jTable5, jTextField10, 0, 1, 2, 3, 4, 5, 6);
        new SearchTable().activate(jTable6, jTextField11, 0, 1, 2, 3, 4, 5, 6);

        jTable4.getColumnModel().getColumn(1).setCellRenderer(new TextAreaRenderer());
    }

    private Products findProduct(String tempProductId) {
        if (getProducts().isEmpty()) {
            initProducts();
        }
        for (Products p : getProducts()) {
            if (Integer.parseInt(p.getId()) == Integer.parseInt(tempProductId)) {
                return p;
            }
        }
        return null;
    }

    private void setCustomer(Customer customer) {
        jTextField2.setText(customer.getCompleteName());
        jTextField3.setText(customer.getAddress());
        jTextField4.setText(customer.getContactNo());
        jTextField5.setText(customer.getEmail());
    }

    public void reset() {
        TransactionsJpaController controller = new TransactionsJpaController(Config.getInstance());
        jTextField12.setText(controller.findLastId());
        setCurrentOrder(null);
        getSells().clear();
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jFormattedTextField3.setText(null);
    }

    private void populateProductInfoFields(String productName, int qty, double price, double totalPrice) {
        jTextArea2.setText(productName);
        jSpinField1.setValue(qty);
        jFormattedTextField1.setValue(price);
        jFormattedTextField2.setValue(totalPrice);
    }

    private void showPriceFields(boolean show, String dialogTitle) {
        jDialog1.setTitle(dialogTitle);
        jLabel9.setVisible(show);
        jLabel8.setVisible(show);
        jFormattedTextField1.setVisible(show);
        jFormattedTextField2.setVisible(show);

        jScrollPane5.setVisible(!show);
        jLabel15.setVisible(!show);

    }

    private void showDialog1() {
        jComboBox1.setVisible(true);
        jLabel16.setVisible(true);
        System.out.println(getPvList().isEmpty());
        if (getPvList().isEmpty()) {
            jComboBox1.setVisible(false);
            jLabel16.setVisible(false);
        }
        jDialog1.setLocationRelativeTo(this);
        jDialog1.setVisible(true);

    }

    private void prepareTransactionPrice(Transactions transactions, int qty, String price, String totalPrice, String amountTender) {
        transactions.setQty(qty);
        transactions.setPrice(Double.parseDouble(price.replaceAll(",", "")));
        transactions.setTotalPrice(Double.parseDouble(totalPrice.replaceAll(",", "")));
        transactions.setAmountTender(amountTender);
    }

    private void prepareTransactionProduct(Transactions transactions, Long productId, String productName, String productDetails) throws NumberFormatException {
        transactions.setDate(new Date());

        transactions.setCustomerName(jTextField2.getText());
        transactions.setCustomerAddress(jTextField3.getText());
        transactions.setCustomerContactNumber(jTextField4.getText());
        transactions.setCustomerEmail(jTextField5.getText());

        transactions.setProductId(productId);
        transactions.setProductName(productName);
        transactions.setProductDetails(productDetails);
    }

    private void createChildTransaction(Transactions parrentTransaction, TransactionsJpaController transactionsJpaController, Sell s) throws NumberFormatException {
        Transactions childTransaction = new Transactions();
        try {
            childTransaction.setInvoice(MyUtil.df.parse(jTextField12.getText()).intValue());
        } catch (ParseException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        childTransaction.setParrentTransaction(parrentTransaction);
        prepareTransactionPrice(childTransaction, s.getQty(), s.getPrice(), s.getTotalPrice(), jFormattedTextField4.getText());
        prepareTransactionProduct(childTransaction, Long.parseLong(s.getProduct().getId()), s.getProduct().getProductName() + s.getProduct().getAddText(), s.getProduct().getProductDetails());
        transactionsJpaController.create(childTransaction);
    }

    private Transactions creatParrentTransaction() {
        Transactions parrentTransaction = new Transactions();
        parrentTransaction.setActive(true);
        prepareTransactionPrice(parrentTransaction, 0, "0", "0", "");
        prepareTransactionProduct(parrentTransaction, null, "", "");
        return parrentTransaction;
    }

    private void processAction() {
        Wp1PostmetaJpaController postsJpaController = new Wp1PostmetaJpaController(Config.getInstance());
        TransactionsJpaController transactionsJpaController = new TransactionsJpaController(Config.getInstance());

        Transactions parrentTransaction = creatParrentTransaction();
        try {
            parrentTransaction.setInvoice(MyUtil.df.parse(jTextField12.getText()).intValue());
        } catch (ParseException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        parrentTransaction.setOrderId(getCurrentOrder() == null ? null : getCurrentOrder().getId());
        transactionsJpaController.create(parrentTransaction);
        for (Sell s : getSells()) {
//            postsJpaController.updateStocks(Integer.parseInt(s.getProduct().getId()), s.getQty(), MyUtil.SALES, jTextArea1.getText());
            createChildTransaction(parrentTransaction, transactionsJpaController, s);
        }

        if (getCurrentOrder() != null) {
            Wp1TermRelationshipsJpaController controller = new Wp1TermRelationshipsJpaController(Config.getInstance());
            controller.updateStatus(Long.parseLong(getCurrentOrder().getId()), "completed");
        }
    }

    private void changeOrderStatus(String orderStatus) throws NumberFormatException, HeadlessException {
        if (jTable1.getSelectedRowCount() == 1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to change this order status to " + orderStatus + "?", "confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                int r = jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
                Wp1TermRelationshipsJpaController controller = new Wp1TermRelationshipsJpaController(Config.getInstance());
                controller.updateStatus(Long.parseLong(getOrders().get(r).getId()), orderStatus);
            }
            MyUtil.showSuccessMessage(this, "Successfully updated order status");
        } else {
            MyUtil.showErrorMessage(this, "Please select one.");
        }
    }

    private void hideJdialog3() {
        jDialog3.setVisible(true);
        jDialog3.dispose();
    }

    private void initCustomers() {
        init = "initCustomers";
        task = new Task();
        task.execute();
    }

    private void voidParrentTransaction(int r, TransactionsJpaController controller) {

        Transactions transaction = controller.findEntity(getTransactionVos().get(r).getId());
        transaction.setActive(false);
        try {
            controller.edit(transaction);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void totalTransactions() {
        double totalD = 0;
        for (TransactionVo tVo : getTransactionVos()) {
            totalD += tVo.getTotalPrice();
        }
        jTextField6.setText(MyUtil.decimalFormat.format(totalD));
    }

    private void closeDialog2() {
        jDialog2.setVisible(false);
        jDialog2.dispose();
    }

    private void closeAndClearTableSelection() {
        closeDialog1();
        jTable3.clearSelection();
        jTable4.clearSelection();
        jTextArea1.setText(null);
    }
    private String init;

    private void prepareSells() throws NumberFormatException, HeadlessException {
        for (Sell s : getSells()) {
            final Products product = findProduct(s.getTempProductId());
            Wp1PostsJpaController controller = new Wp1PostsJpaController(Config.getInstance());
            if (s.getVariationID() != null) {
                String adss = controller.findVariationName(Long.parseLong(s.getVariationID())).toString() == null ? "" : controller.findVariationName(Long.parseLong(s.getVariationID())).toString();
                product.setAddText((adss == null || adss.isEmpty() ? "" : "\nSIZE: " + adss));
            }

            s.setPrice(controller.variationPrice(Long.parseLong(s.getVariationID())).toString());
            s.setProduct(product);
        }
    }

    private Object findVariationPrice() {
        int r = jTable3.convertRowIndexToModel(jTable3.getSelectedRow());
        Wp1PostsJpaController controller = new Wp1PostsJpaController(Config.getInstance());
        Object o = controller.variationPrice(Long.parseLong(((ProductVariations) jComboBox1.getSelectedItem()).getId()));
        return o;
    }

    private void initProductVariation(Products p) throws NumberFormatException {
        Wp1PostsJpaController controller = new Wp1PostsJpaController(Config.getInstance());
        getPvList().clear();
        getPvList().addAll(controller.findProductVariations(Long.parseLong(p.getId())));
    }

    private ProductVariations findSelectedVariation(int r) {
        for (ProductVariations pv : getPvList()) {
            if (pv.getId().equals(getSells().get(r).getVariationID())) {
                return pv;
            }
        }
        return null;
    }

    private void prepareSell(Sell s) {
        s.setPrice(jFormattedTextField1.getValue().toString());
        s.setTotalPrice(jFormattedTextField2.getValue().toString());
        s.setQty(jSpinField1.getValue());
        final ProductVariations pv = (ProductVariations) jComboBox1.getSelectedItem();
        if (pv != null) {
            s.setVariationID(pv.getId());
        }

    }

    class Task extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            switch (init) {
                case "initProducts":
                    getProducts().clear();
                    getProducts().addAll(new Wp1PostsJpaController(Config.getInstance()).findProducts());
                    return null;
                case "initOrders":
                    getOrders().clear();
                    getOrders().addAll(new Wp1PostsJpaController(Config.getInstance()).findOrders());
                    return null;
                case "initCustomers":
                    getCustomers().clear();
                    List<Customer> cs = TransactionUtil.convertCustomer(new TransactionsJpaController(Config.getInstance()).findPreviousCustomer());
                    getCustomers().addAll(cs);
                    return null;
            }
            return null;
        }

        @Override
        protected void done() {
            setCursor(Cursor.getDefaultCursor());
            super.done();
        }
    }

    public List<ProductVariations> getPvList() {
        return pvList;
    }

    public void setPvList(List<ProductVariations> pvList) {
        this.pvList = pvList;
    }

    public Sell getSelectedSell() {
        return selectedSell;
    }

    public void setSelectedSell(Sell selectedSell) {
        this.selectedSell = selectedSell;
    }
    private OrderAlert alert;

    public void checkOrder() {
        if (alert != null) {
            alert.cancel(true);
        }

        alert = new OrderAlert();
        alert.execute();
    }

    class OrderAlert extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            int oldsize = 0;
            while (true) {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                getOrders().clear();
                getOrders().addAll(new Wp1PostsJpaController(Config.getInstance()).findOrders());
                if (hasNewOrder(oldsize)) {
                    MyUtil.playAudio();
//                    MyUtil.playSound("doorbell.wav");
                    MyUtil.showInfoMessage(MainForm.getInstance(), "There are new orders.");
                    MyUtil.stopAudio();
                }
                oldsize = getOrders().size();
                setCursor(Cursor.getDefaultCursor());
                Thread.sleep(30000);
            }
        }

        private boolean hasNewOrder(int oldsize) {
            if (getOrders().size() > oldsize && oldsize > 0) {
                return true;
            }
            return false;
        }

        @Override
        protected void done() {
            setCursor(Cursor.getDefaultCursor());
            super.done();
        }
    }
}
