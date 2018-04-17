package Java_Arduino.ArduinoRX_multi;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class ArduinoGUI extends javax.swing.JFrame implements ActionListener{
    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    String msg;

    public ArduinoGUI() {
        initComponents();
        Calendar c = new GregorianCalendar();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int segu = c.get(Calendar.SECOND);
        int mint = c.get(Calendar.MINUTE);
        msg = hora+":"+mint+":"+segu;
        try {
            //Se inicia la comunicación con el Puerto Serie
            ino.arduinoTX("COM7", 9600);     
        } catch (ArduinoException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonHora = new javax.swing.JButton();
        BotonCaptura = new javax.swing.JButton();
        CapturaTexto = new javax.swing.JTextField();
        BotonTemp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonHora.setText("Obtener la Hora");
        BotonHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHoraActionPerformed(evt);
            }
        });

        BotonCaptura.setText("Enviar Texto");
        BotonCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturaActionPerformed(evt);
            }
        });

        BotonTemp.setText("Obtener temperatura");
        BotonTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTempActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CapturaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotonTemp)
                    .addComponent(BotonHora, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(BotonHora)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCaptura)
                    .addComponent(CapturaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BotonTemp)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHoraActionPerformed
        try {
            ino.sendData(msg);
            //System.out.println(msg);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonHoraActionPerformed

    private void BotonCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCapturaActionPerformed
        try {
            ino.sendData(CapturaTexto.getText());
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonCapturaActionPerformed

    private void BotonTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTempActionPerformed
        try {
          
            ino.sendData("2");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonTempActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArduinoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCaptura;
    private javax.swing.JButton BotonHora;
    private javax.swing.JButton BotonTemp;
    private javax.swing.JTextField CapturaTexto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}