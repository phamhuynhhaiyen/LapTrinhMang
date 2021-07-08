package GUI;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HaiYen
 */
public class SERVER extends javax.swing.JFrame {

    static DatagramSocket serversocket;
    public static Map<DatagramPacket, Integer> listPK;
    boolean check = false;
    static int port;
    static DatagramPacket packet;

    public SERVER() {
        initComponents();
        listPK = new HashMap<DatagramPacket, Integer>();
        listSinhVien = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnRun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtShow = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Port");

        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        txtShow.setColumns(20);
        txtShow.setRows(5);
        jScrollPane1.setViewportView(txtShow);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRun)
                .addContainerGap(353, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static ArrayList<SinhVien> listSinhVien;

    private void execute(String sms) throws IOException {
        if (sms.equalsIgnoreCase("KetNOI")) {
            sendData("Okey", serversocket, packet);
        } else {
            String[] arr = sms.split("/");
            if (arr.length == 2) {
                int check1 = 0;
                for (SinhVien sinhVien : listSinhVien) {
                    if ((sinhVien.ID).equals(arr[1])) {
                        sendData("false/", serversocket, packet);
                        check1++;
                    } else {

                    }
                }
                if (check1 == 0) {
                    listSinhVien.add(new SinhVien(arr[0], arr[1]));
                    //String maphong="MP0"+new Random().nextInt(2);
                    String maphong = "MP0123";
                    sendData("true/" + maphong, serversocket, packet);
                }
            } else {
                for (DatagramPacket item : listPK.keySet()) {
                    sendData(sms, serversocket, item);

                }
            }
        }

    }

    //send data
    private void sendData(String value, DatagramSocket server, DatagramPacket clinet) throws IOException {

        byte[] b = value.getBytes();
        DatagramPacket send = new DatagramPacket(b, b.length, clinet.getAddress(), clinet.getPort());
        server.send(send);
    }

    public String ReceiveData(DatagramSocket server) throws IOException {
        byte msg[] = new byte[256];
        packet = new DatagramPacket(msg, msg.length);
        server.receive(packet);
        String receive = (new String(packet.getData(), 0, packet.getLength())).trim();
        return receive;
    }

    //Kiem tra trung lap packet
    private void checkDuplicate() {
        for (DatagramPacket item : listPK.keySet()) {
            if ((item.getAddress().equals(packet.getAddress()) && item.getPort() == packet.getPort())) {
                listPK.replace(item, 0);
                return;
            }
        }
        listPK.put(packet, 0);

    }

    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            try {
                String a = "";
                while ((a = ReceiveData(serversocket)) != null) {
                    checkDuplicate();
                    txtShow.append(a + "\n");
                    execute(a);
                }
            } catch (Exception ex) {
            }
        }
    }

    public void ListenThread() {
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }
    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        try {
            port = Integer.parseInt(txtPort.getText());
            serversocket = new DatagramSocket(port);
            check = true;
            JOptionPane.showMessageDialog(this, "Server is running at port: " + port);
            ListenThread();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnRunActionPerformed

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
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SERVER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SERVER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextArea txtShow;
    // End of variables declaration//GEN-END:variables

}
