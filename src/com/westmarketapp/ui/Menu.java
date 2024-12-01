package com.westmarketapp.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import westmarketapp.Producto;

public class Menu extends javax.swing.JFrame {
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private DefaultTableModel modeloTabla;
    private Map<Integer, String> categorias; // Relación entre código y nombre de categorías

    public Menu() {
        initComponents();
        configurarTabla();
        inicializarCategorias();
        configurarComboBox();
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{
            "Código Producto", "Descripción", "Precio", "Stock", "Código Categoría", "Nombre Categoría"}, 0);
        TablaRegistro.setModel(modeloTabla);
    }

    private void inicializarCategorias() {
        categorias = new HashMap<>();
        categorias.put(101, "Bebidas");
        categorias.put(102, "Lácteos");
        categorias.put(103, "Congelados");
        categorias.put(104, "Aseo");
    }

    private void configurarComboBox() {
        // Poblar el ComboBox con nombres de categorías
        jcomboCodigo.removeAllItems();
        for (Map.Entry<Integer, String> entry : categorias.entrySet()) {
            jcomboCodigo.addItem(entry.getValue()); // Agregamos solo el nombre de la categoría
        }

        // Sincronizar con el código de categoría
        jcomboCodigo.addActionListener(e -> {
            String categoriaSeleccionada = (String) jcomboCodigo.getSelectedItem();
            for (Map.Entry<Integer, String> entry : categorias.entrySet()) {
                if (entry.getValue().equals(categoriaSeleccionada)) {
                    txtcategoriaSeleccionada.setText(entry.getKey().toString()); // Mostrar código en el campo
                    break;
                }
            }
        });
    }
    //metodo registrar, en btn registro se llama a este metodo
    private void registrarProducto() {
        try {
            int codigop = Integer.parseInt(txtcodigop.getText().trim());
            String descripcion = txtdescripcion.getText().trim();
            int precio = Integer.parseInt(txtprecio.getText().trim());
            int stock = Integer.parseInt(txtstock.getText().trim());
            String categoria = (String) jcomboCodigo.getSelectedItem();

            // Validaciones
            if (String.valueOf(codigop).length() < 3) {
                JOptionPane.showMessageDialog(this, "El código debe tener al menos 3 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!descripcion.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                JOptionPane.showMessageDialog(this, "La descripción solo debe contener letras y espacios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (precio <= 0) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (stock < 0) {
                JOptionPane.showMessageDialog(this, "El stock no puede ser un número negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (categoria == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una categoría.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener código de categoría basado en el nombre seleccionado
            int codigo = 0;
            for (Map.Entry<Integer, String> entry : categorias.entrySet()) {
                if (entry.getValue().equals(categoria)) {
                    codigo = entry.getKey();
                    break;
                }
            }

    Producto producto = new Producto(codigop, descripcion, precio, stock, codigo, categoria);
    listaProductos.add(producto);

    modeloTabla.addRow(new Object[]{
        producto.getCodigop(),
        producto.getDescripcion(),
        producto.getPrecio(),
        producto.getStock(),
        producto.getCodigo(),
        producto.getCategoria()
    });

    JOptionPane.showMessageDialog(this, "Producto registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    limpiarCampos();
    } catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Verifica que los campos numéricos sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
     }

   }       
    
    
    
    
    private void limpiarCampos() {
        txtcodigop.setText("");
        txtdescripcion.setText("");
        txtprecio.setText("");
        txtstock.setText("");
        txtcategoriaSeleccionada.setText("");
        jcomboCodigo.setSelectedIndex(-1);
    }
   
   
   
   
   
   
   
   //*****************************************************************************************//
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tbprincipal = new javax.swing.JTabbedPane();
        pnlRegistro = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblingresecod = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtcodigop = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtstock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pnlcbox = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcomboCodigo = new javax.swing.JComboBox<>();
        txtcategoriaSeleccionada = new javax.swing.JTextField();
        pnlimprimir = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaImpresion = new javax.swing.JTextArea();
        btnimprimir = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        pnlEliminar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaRegistro = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblingresecod.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblingresecod.setText("Ingrese el codigo ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Precio");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Stock");

        btnRegistrar.setBackground(new java.awt.Color(0, 51, 102));
        btnRegistrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar ");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtcodigop.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtcodigop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigopActionPerformed(evt);
            }
        });

        txtdescripcion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });

        txtprecio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });

        txtstock.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("REGISTRO DE PRODUCTOS WEST MARKET");

        pnlcbox.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Selecciona un codigo");

        jcomboCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlcboxLayout = new javax.swing.GroupLayout(pnlcbox);
        pnlcbox.setLayout(pnlcboxLayout);
        pnlcboxLayout.setHorizontalGroup(
            pnlcboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcboxLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(pnlcboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcategoriaSeleccionada)
                    .addComponent(jcomboCodigo, 0, 172, Short.MAX_VALUE))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        pnlcboxLayout.setVerticalGroup(
            pnlcboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcboxLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jcomboCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcategoriaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlcboxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(25, 25, 25))
        );

        jLabel5.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addGap(33, 72, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRegistroLayout.createSequentialGroup()
                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlcbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRegistroLayout.createSequentialGroup()
                                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3))))
                                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(lblingresecod)))
                                .addGap(58, 58, 58)
                                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcodigop, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(txtdescripcion)
                                    .addComponent(txtprecio)
                                    .addComponent(txtstock))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(69, 69, 69))
        );
        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblingresecod)
                    .addComponent(txtcodigop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlcbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar)
                .addGap(97, 97, 97))
        );

        lblingresecod.getAccessibleContext().setAccessibleName("");
        jLabel2.getAccessibleContext().setAccessibleName("");
        jLabel3.getAccessibleContext().setAccessibleName("");
        jLabel4.getAccessibleContext().setAccessibleName("");

        tbprincipal.addTab("Registrar productos", pnlRegistro);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Listado de Productos Registrados");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 204));

        txaImpresion.setColumns(20);
        txaImpresion.setRows(5);
        jScrollPane2.setViewportView(txaImpresion);

        btnimprimir.setBackground(new java.awt.Color(204, 204, 255));
        btnimprimir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnimprimir.setText("Imprimir Listado");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnactualizar.setBackground(new java.awt.Color(204, 255, 153));
        btnactualizar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnactualizar.setText("Actualizar listado");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlimprimirLayout = new javax.swing.GroupLayout(pnlimprimir);
        pnlimprimir.setLayout(pnlimprimirLayout);
        pnlimprimirLayout.setHorizontalGroup(
            pnlimprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlimprimirLayout.createSequentialGroup()
                .addGroup(pnlimprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlimprimirLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlimprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlimprimirLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel7)
                            .addGap(59, 59, 59)
                            .addComponent(btnactualizar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnimprimir))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlimprimirLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlimprimirLayout.setVerticalGroup(
            pnlimprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlimprimirLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlimprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnactualizar)
                    .addComponent(btnimprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tbprincipal.addTab("Imprimir productos", pnlimprimir);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Para eliminar un producto, seleccione de la lista a continuación:");

        TablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane3.setViewportView(TablaRegistro);

        btnEliminar.setBackground(new java.awt.Color(255, 102, 102));
        btnEliminar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar producto");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEliminarLayout = new javax.swing.GroupLayout(pnlEliminar);
        pnlEliminar.setLayout(pnlEliminarLayout);
        pnlEliminarLayout.setHorizontalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(pnlEliminarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEliminarLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(49, 49, 49))
                    .addGroup(pnlEliminarLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 40, Short.MAX_VALUE))))
        );
        pnlEliminarLayout.setVerticalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEliminarLayout.createSequentialGroup()
                .addGroup(pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEliminarLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEliminarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbprincipal.addTab("Eliminar productos", pnlEliminar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbprincipal)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tbprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnsalir.setBackground(new java.awt.Color(153, 51, 0));
        btnsalir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

     registrarProducto();
   
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int filaSeleccionada = TablaRegistro.getSelectedRow();
        if (filaSeleccionada != -1) {
            int codigoProducto = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            listaProductos.removeIf(producto -> producto.getCodigo() == codigoProducto);
            modeloTabla.removeRow(filaSeleccionada);
            JOptionPane.showMessageDialog(this, "Producto eliminado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed

        // Acción al presionar Imprimir
        String datosParaImprimir = txaImpresion.getText();
        if (datosParaImprimir.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay datos para imprimir.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Imprimiendo datos:\n" + datosParaImprimir, "Impresión", JOptionPane.INFORMATION_MESSAGE);
        


    }//GEN-LAST:event_btnimprimirActionPerformed

    private void txtcodigopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigopActionPerformed

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed

          StringBuilder datos = new StringBuilder();
    
          datos.append("------ Listado de Productos --------\n");
    
    for (Producto producto : listaProductos) {
        datos.append("Código producto: ").append(producto.getCodigop()).append("\n");
        datos.append("Descripción: ").append(producto.getDescripcion()).append("\n");
        datos.append("Precio: ").append(producto.getPrecio()).append("\n");
        datos.append("Categoría: ").append(producto.getCategoria())
             .append(" (Cod: ").append(producto.getCodigo()).append(")\n");
        datos.append("Stock: ").append(producto.getStock()).append("\n");
        datos.append("------------------------------------\n");
    }
    
    txaImpresion.setText(datos.toString()); // Mostrar datos en el JTextArea
    btnimprimir.setEnabled(true); // Activar el botón Imprimir si estaba deshabilitado

    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
         JOptionPane.showMessageDialog(this, "Cerrando la aplicación.", "Salir", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

    }//GEN-LAST:event_btnsalirActionPerformed

    private void jcomboCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboCodigoActionPerformed
    
    }//GEN-LAST:event_jcomboCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaRegistro;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> jcomboCodigo;
    private javax.swing.JLabel lblingresecod;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JPanel pnlcbox;
    private javax.swing.JPanel pnlimprimir;
    private javax.swing.JTabbedPane tbprincipal;
    private javax.swing.JTextArea txaImpresion;
    private javax.swing.JTextField txtcategoriaSeleccionada;
    private javax.swing.JTextField txtcodigop;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables

    private static class Categoria {

        public Categoria() {
        }
    }

    
    

 
}
