package GUI;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author HaiYen
 */
public class CLIENT extends javax.swing.JFrame {

    public CLIENT(int port, InetAddress ip,DatagramSocket clinet) {
        initComponents();
        listSinhVien = new ArrayList<SinhVien>();
        clientsocket =clinet;
        this.port=port;
        diachi=ip;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnConnect = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtShow = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        btnNhapMa = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        jLabel3.setText("Message:");

        txtMessage.setEnabled(false);

        btnSend.setText("Send");
        btnSend.setEnabled(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtShow.setColumns(20);
        txtShow.setRows(5);
        txtShow.setEnabled(false);
        jScrollPane1.setViewportView(txtShow);

        jLabel4.setText("Tên");

        txtName.setText("Yen");

        txtID.setText("1");

        jLabel5.setText("Mã sinh viên");

        btnNhapMa.setText("Mã phòng");
        btnNhapMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSend))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnConnect))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(btnNhapMa))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNhapMa))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    static int port;
    static InetAddress diachi;
    static DatagramPacket packet;
    static DatagramSocket clientsocket;
    static boolean CHECK = false;
    static String name;
    static String ID;
    public static ArrayList<SinhVien> listSinhVien;

    private static void Gui(String mang) throws IOException {
        byte[] mangb = mang.getBytes();
        packet = new DatagramPacket(mangb, mangb.length, diachi, port);
        clientsocket.send(packet);
    }

    public String ReceiveData() throws IOException {
        byte msg[] = new byte[1024];
        packet = new DatagramPacket(msg, msg.length);
        clientsocket.receive(packet);
        String receive = (new String(packet.getData(), 0, packet.getLength())).trim();
        return receive;
    }

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        try {           
           //clientsocket = new DatagramSocket();
            name = txtName.getText();
            ID = txtID.getText();
            Gui(name+"/"+ID);
              String[] arr=ReceiveData().split("/");
             // JOptionPane.showMessageDialog(rootPane, "s"+arr[0]);
                   if(arr[0].equalsIgnoreCase("true")){
                       maphong=arr[1];
                       JOptionPane.showMessageDialog(rootPane, "Mã phòng của bàn là"+arr[1]);
                   }
                   else if(arr[0].equalsIgnoreCase("false")) {
                      
                   JOptionPane.showMessageDialog(rootPane, "Mã Sinh vien nay đã được đằng kí");
                   }
           //Gui(ID);
           // ReceiveData();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Không thể kết nối, mời bạn nhập lại!");
        }
    }//GEN-LAST:event_btnConnectActionPerformed
    public void ListenThread() {
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String sms = txtMessage.getText();
        try {
            Gui( ID + "/"+name + "/" + sms + " \n /" +maphong);
            txtShow.append("tôi :"+sms + " \n");

        } catch (IOException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnNhapMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMaActionPerformed
        //String maPhong = txtMaPhong.getText();
        if(txtMaPhong.getText().equalsIgnoreCase(maphong)){
            txtMessage.setEnabled(true);
            txtShow.setEnabled(true);
            btnSend.setEnabled(true);
            try {
                Gui( ID + "/"+name + "/đã vào phòng \n /"+maphong);
            } catch (IOException ex) {
                Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            }
            ListenThread();
        }else{
            JOptionPane.showMessageDialog(this, "Bạn nhập sai! Mời nhập lại");
        }
        
    }//GEN-LAST:event_btnNhapMaActionPerformed

   
String maphong;
    public class IncomingReader implements Runnable {

        @Override
        public void run() {
            try {
                String a;
                while ((a = ReceiveData()) != null) {
                   String[] arr=a.split("/");
                    System.out.println(""+arr[0]);
                  if((!arr[0].equalsIgnoreCase(ID)) && arr[3].equalsIgnoreCase(maphong)){
                    txtShow.append(arr[1]+": "+arr[2]+ "\n");
                  }                  
                }
            } catch (Exception ex) {
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnNhapMa;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtShow;
    // End of variables declaration//GEN-END:variables

}
