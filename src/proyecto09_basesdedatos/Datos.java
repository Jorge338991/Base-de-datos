package proyecto09_basesdedatos;

import javax.swing.table.DefaultTableModel;
import configuracion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Datos extends javax.swing.JFrame {
    

    //ATRIBUTOS
    DefaultTableModel modeloTablaMascotas;
    Connection conexionEstablecida;
    Statement enviarSQL;
    ResultSet resultado;
    public static int id;
    
    
    //METODOS
    //CONSTRUCTOR
    public Datos() {
        initComponents();
    }
    
    public Datos(String titulo, boolean visible) {
        initComponents();
        this.setTitle(titulo);
        this.setVisible(visible);
        llenarTabla();
        apagarPanel();
        
    }

    //GETTERS AND SETTERS
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Datos.id = id;
    }
    
 
    //OUTROS METODOS
    
    
    private void llenarTabla(){
        
        DefaultTableModel modeloTablaMascotas;
        modeloTablaMascotas = (DefaultTableModel) jTableMascotas.getModel();  
        modeloTablaMascotas.setRowCount(0);
        
        
        try{
            conexion conexionBD = new conexion();
            conexionEstablecida = conexionBD.getMiconexion();
            enviarSQL = conexionEstablecida.createStatement();
            String consulta = "select * from mascota";
            resultado = enviarSQL.executeQuery(consulta);
            
            Object[] datos = new Object[5];
            while(resultado.next()){
                
                //O primeiro exemplo e o de David
                datos[0]= String.valueOf(resultado.getInt("id"));
                datos[1]=resultado.getString("nome");
                datos[2]=resultado.getString("tipo");
                datos[3]=resultado.getString("raza");
                datos[4]=String.valueOf(resultado.getInt("numpatas"));
                
                
                modeloTablaMascotas.addRow(datos);
                //
                //Este e o de Luís, pero funcionan os dous
                /*
                datos[0]=resultado.getString(1);
                datos[1]=resultado.getString(2);
                datos[2]=resultado.getString(3);
                datos[3]=resultado.getString(4);
                datos[4]=resultado.getString(5);              
                modeloTablaMascotas.addRow(datos);
                */
            }
            
            conexionEstablecida.close();
              
        }catch(SQLException erro){
            
            JOptionPane.showMessageDialog(this, "Se ha producido un error de tipo SQL.\n "+erro);
            
        }
    
    
    }
    
    //////////////////////////////////////
    
    public void apagarPanel(){
        jPanelMascota.setVisible(false);
        jPanelMascota.setEnabled(false);
    
    }
    
    public void encenderPanel(String titulo){
        jLabelTitulo.setText(titulo);
        jPanelMascota.setVisible(true);
        jPanelMascota.setEnabled(true);
    
    }

    //////////////////////////////////////
    
    public void apagarBotons(){
        jButtonAgregar.setVisible(false);
        jButtonAgregar.setEnabled(false);
        
        jButtonEditar.setVisible(false);
        jButtonEditar.setEnabled(false);
        
        jButtonEliminar.setVisible(false);
        jButtonEliminar.setEnabled(false);
    }
    
        public void encenderBotons(){
        jButtonAgregar.setVisible(true);
        jButtonAgregar.setEnabled(true);
        
        jButtonEditar.setVisible(true);
        jButtonEditar.setEnabled(true);
        
        jButtonEliminar.setVisible(true);
        jButtonEliminar.setEnabled(true);
    }
    
    //////////////////////////////////////
    public void vaciarCampos(){
        
        JTextField[] campos = {jTextFieldNome, jTextFieldTipo, jTextFieldRaza, jTextFieldPatas};
        
        for (JTextField campo : campos) {
            campo.setText("");
        }
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMascotas = new javax.swing.JTable();
        jPanelMascota = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldRaza = new javax.swing.JTextField();
        jTextFieldPatas = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setText("LISTADO DE MASCOTAS");

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jTableMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Tipo", "Raza", "Patas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMascotas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );

        jPanelMascota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTextField2.setEditable(false);
        jTextField2.setText("Nome:");

        jTextField3.setEditable(false);
        jTextField3.setText("Tipo:");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setEditable(false);
        jTextField4.setText("Patas:");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setText("Raza");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelMascotaLayout = new javax.swing.GroupLayout(jPanelMascota);
        jPanelMascota.setLayout(jPanelMascotaLayout);
        jPanelMascotaLayout.setHorizontalGroup(
            jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMascotaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPatas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMascotaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMascotaLayout.createSequentialGroup()
                        .addComponent(jButtonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)))
                .addGap(32, 32, 32))
        );
        jPanelMascotaLayout.setVerticalGroup(
            jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMascotaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jPanelMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregar)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonEliminar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        /*PASOS
        1. Estando cuberto o que ten que estar, recuperamos os datos do formulario.
        2. Pedir a confirmación de que realmente se quere agregar.
        3. Se di que sí: 
            a) Crear conexión á BD
            b) Crear o String consulta
            c) Executar a consulta --> executeUpdate(consulta);
            d) Informar o usuario de que a inserción se realizou correctamente.
            e) Limpiamos o formulario. 
            f) Cerrar a conexión.
            g) Actualizar a táboa no noso programa para que reflexe os cambios.
        
        String consulta =   "INSERT INTO MASCOTA(nome,tipo,raza,numpatas) VALUES 
                            ('Tobi','Perro','Pekinés',4)";
        
        */
        setId(-1);
        encenderPanel("Novo animal");
        vaciarCampos();
        apagarBotons();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        int resposta=1;
        
        
        
        resposta = JOptionPane.showConfirmDialog(this, "Esta seguro que desexa continuar", "Añadir animal", JOptionPane.YES_NO_OPTION);
        
        if(resposta == 0){//aceptou 
            
            boolean editar=false;//significa que é novo
            if(getId() > -1 )editar=true;
            
            
            int id_final = getId();
            String nome     = jTextFieldNome.getText();
            String tipo     = jTextFieldTipo.getText();
            String raza     = jTextFieldRaza.getText();
            String patas_1    = jTextFieldPatas.getText();
            int patas_2       = Integer.parseInt(patas_1);



            if(editar==false){



                try{
                    int resultado_engadir;
                    conexion conexionBD = new conexion();
                    conexionEstablecida = conexionBD.getMiconexion();
                    enviarSQL = conexionEstablecida.createStatement();
                    String consulta = "INSERT INTO MASCOTA(nome,tipo,raza,numpatas) VALUES ('"+nome+"','"+tipo+"','"+raza+"','"+patas_2+"')";
                    resultado_engadir = enviarSQL.executeUpdate(consulta);
                    if(resultado_engadir==1){
                        JOptionPane.showMessageDialog(this, "Añadeuse correctamente.");
                        vaciarCampos();
                        apagarPanel();
                        encenderBotons();
                    }

                }
                catch(SQLException erro){

                JOptionPane.showMessageDialog(this, "Se ha producido un error de tipo SQL.\n "+erro);

                }

            }else{
                    System.out.println(getId());
                    System.out.println("estamos editando");
                try{
                    int resultado_editar;
                    conexion conexionBD = new conexion();
                    conexionEstablecida = conexionBD.getMiconexion();
                    enviarSQL = conexionEstablecida.createStatement();
                    String consulta = "update mascota set nome='"+nome+"',tipo='"+tipo+"',raza='"+raza+"',numpatas="+patas_2+" where id="+id_final+"";
                    System.out.println(consulta);
                    resultado_editar = enviarSQL.executeUpdate(consulta);
                    if(resultado_editar==1){
                        JOptionPane.showMessageDialog(this, "Editouse correctamente.");
                        vaciarCampos();
                        apagarPanel();
                        encenderBotons();
                    }

                }
                catch(SQLException erro){

                JOptionPane.showMessageDialog(this, "Se ha producido un error de tipo SQL.\n "+erro);

                }

            }

        }
        
        vaciarCampos();
        apagarPanel();
        llenarTabla();
        
        
        
        
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        vaciarCampos();
        apagarPanel();
        llenarTabla();
        encenderBotons();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int filaSeleccionada = jTableMascotas.getSelectedRow();
        
        if(filaSeleccionada > -1){
        
            int resposta = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desexa eliminar este rexistro?", "Eliminar animal", JOptionPane.YES_NO_OPTION);
            //System.out.println(resposta+"  "+filaSeleccionada);
            Object id = jTableMascotas.getValueAt(filaSeleccionada, 0);
            System.out.println(id);
            
            
            if(resposta == 0){
                try{
                    
                    conexion conexionBD = new conexion();
                    conexionEstablecida = conexionBD.getMiconexion();
                    enviarSQL = conexionEstablecida.createStatement();
                    String consulta = "DELETE FROM mascota WHERE mascota.id="+id;
                    int resultado_eliminar = enviarSQL.executeUpdate(consulta);
                    if(resultado_eliminar==1){
                        JOptionPane.showMessageDialog(this, "Eliminouse correctamente.");
                        apagarPanel();
                        llenarTabla();
                    }

                }
                catch(SQLException erro){

                JOptionPane.showMessageDialog(this, "Se ha producido un error de tipo SQL.\n "+erro);

                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Primeiro ten que seleccinadr un rexistro para poder eliminalo.");
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int fila_seleccianda = jTableMascotas.getSelectedRow();
        if(fila_seleccianda > -1 ){
            encenderPanel("Editando animal");
            apagarBotons();
            
            String id =(String) jTableMascotas.getValueAt(fila_seleccianda, 0);
            int id_1 = Integer.parseInt(id);
            String nome = (String) jTableMascotas.getValueAt(fila_seleccianda, 1);
            String tipo = (String) jTableMascotas.getValueAt(fila_seleccianda, 2);
            String raza = (String) jTableMascotas.getValueAt(fila_seleccianda, 3);
            String n_patas =(String)  jTableMascotas.getValueAt(fila_seleccianda, 4);
            
            System.out.println(id);
            
            jTextFieldNome.setText(nome);
            jTextFieldTipo.setText(tipo);
            jTextFieldRaza.setText(raza);
            jTextFieldPatas.setText(""+n_patas);
            
            setId(id_1);
            System.out.println(getId());
            
            
        }else{
            JOptionPane.showMessageDialog(this, "Para editar unha mascota primeiro ten que seleccionar unha da lista.");
        }

        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMascota;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMascotas;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPatas;
    private javax.swing.JTextField jTextFieldRaza;
    private javax.swing.JTextField jTextFieldTipo;
    // End of variables declaration//GEN-END:variables
}
