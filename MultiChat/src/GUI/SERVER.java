package GUI;

import static GUI.CLIENT.ID;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    ArrayList<Phong> phongs;

    public SERVER() {
        initComponents();
        listPK = new HashMap<DatagramPacket, Integer>();
        listSinhVien = new ArrayList<>();
        phongs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Phong phong = new Phong();
            phong.ID = TaoMaPhong();
            SinhVien sinhVien = new SinhVien("Admin", "Admin");
            phong.getSinhVien().add(sinhVien);
            phong.SoNguoi = 0;
            phongs.add(phong);

        }
         TaoPhong();
    }

    void TaoPhong() {
        DefaultTableModel modell = new DefaultTableModel();
        jTable1.setModel(modell);
        modell.addColumn("Mã Phòng");
        modell.addColumn("Số người");
        for (int i = 0; i < phongs.size(); i++) {

            modell.addRow(new Object[]{phongs.get(i).ID, phongs.get(i).SoNguoi});

        }
        for (DatagramPacket item : listPK.keySet()) {
            String CHUOI = "Admin/Admin/Đã tạo phòng/Tao";
            for (int i = 0; i < phongs.size(); i++) {
                CHUOI += "/" + phongs.get(i).ID + "/" + phongs.get(i).SoNguoi;
            }
            try {
                sendData(CHUOI, serversocket, item);
            } catch (IOException ex) {
                Logger.getLogger(SERVER.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Port");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 19, -1, -1));
        jPanel1.add(txtPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 16, 135, -1));

        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        jPanel1.add(btnRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 15, -1, -1));

        txtShow.setColumns(20);
        txtShow.setRows(5);
        jScrollPane1.setViewportView(txtShow);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, 406, 334));

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
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Thêm Phòng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addContainerGap(244, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 47, 450, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static ArrayList<SinhVien> listSinhVien;

    private boolean execute(String sms) throws IOException {
        if (sms.equalsIgnoreCase("KetNOI")) {
            sendData("Okey", serversocket, packet);
        } else {
            String CHUOI = "";
            String[] arr = sms.split("/");
            if (arr.length == 2) {
                int check1 = 0;

                // kiem tra sinh vien  co ton tai hay khong
                for (SinhVien sinhVien : listSinhVien) {
                    if ((sinhVien.ID).equals(arr[1])) {
                        sendData("false/", serversocket, packet);
                        check1++;
                    } else {

                    }
                }

                for (int i = 0; i < phongs.size(); i++) {
                    CHUOI += phongs.get(i).ID + "/" + phongs.get(i).SoNguoi + "/";

                }
                //neu ton tai gui danh sach phong cho client
                if (check1 == 0) {
                    listSinhVien.add(new SinhVien(arr[0], arr[1]));
                    //String maphong="MP0"+new Random().nextInt(2);
                    sendData("true/" + CHUOI, serversocket, packet);
                }

            } else {

                if (arr[2].equalsIgnoreCase("Đã rời khỏi phòng")) {
                    XoaSinhVien(arr);
                    for (int i = 0; i < phongs.size(); i++) {
                        sms += "/" + phongs.get(i).ID + "/" + phongs.get(i).SoNguoi;

                    }

                    //  for (DatagramPacket item : listPK.keySet()) {
                    sendData(sms, serversocket, packet);
                    //  }

                } else {
                    if (arr[2].equalsIgnoreCase("đã vào phòng")) {
                        //Sinh vien vao phong phai cap nhat so luong trong phong do
                        CapNhatLaiPhog(arr);

                    } else if (arr[2].equalsIgnoreCase("Đã tạo phòng")) {
                        //Clinet yeu cau tao phong
                        ThemPhong(arr);

                        for (int i = 0; i < phongs.size(); i++) {
                            sms += "/" + phongs.get(i).ID + "/" + phongs.get(i).SoNguoi;

                        }

                        for (DatagramPacket item : listPK.keySet()) {

                            sendData(sms, serversocket, item);
                        }
                        //  TaoPhong();
                        return true;

                    }
                    // xoa phong không co nguoi  

                }
                for (DatagramPacket item : listPK.keySet()) {

                    sendData(sms, serversocket, item);
                }
            }

        }

        return true;

    }

    //send data
    private void sendData(String value, DatagramSocket server, DatagramPacket clinet) throws IOException {
        // System.out.println(value);

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

    private String TaoMaPhong() {
        Random R = new Random();
        String maphong = "";
        while (true) {
            int cout = 0;
            maphong = "MP" + R.nextInt(phongs.size() + 1) + "";
            for (int i = 0; i < phongs.size(); i++) {
                if (phongs.get(i).ID.equalsIgnoreCase(maphong)) {
                    cout++;
                }

            }
            if (cout == 0) {
                break;
            }
        }

        return maphong;
    }

    private void XoaSinhVien(String[] arr) throws IOException {
        for (int i = 0; i < phongs.size(); i++) {
            if (phongs.get(i).getID().equalsIgnoreCase(arr[3])) {
                for (int j = 0; j < phongs.get(i).getSinhVien().size(); j++) {
                    if (phongs.get(i).getSinhVien().get(j).ID.equalsIgnoreCase(arr[0])) {
                        phongs.get(i).getSinhVien().remove(j);
                        phongs.get(i).SoNguoi--;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < phongs.size(); i++) {
            if (phongs.get(i).getSinhVien().size() == 0) {
                sendData(phongs.get(i).ID, serversocket, packet);
                phongs.remove(i);

                break;

            }
        }

        TaoPhong();
    }

    private void CapNhatLaiPhog(String[] arr) {
        for (int i = 0; i < phongs.size(); i++) {
            if (phongs.get(i).ID.equalsIgnoreCase(arr[3])) {
                SinhVien sinhVien = new SinhVien(arr[1], arr[0]);
                phongs.get(i).SoNguoi++;
                phongs.get(i).getSinhVien().add(sinhVien);
            }
        }
        TaoPhong();
    }

    private void ThemPhong(String[] arr) {

        Phong phong = new Phong();
        phong.ID = TaoMaPhong();
        //    sendData(phong.ID, serversocket, packet);
        SinhVien sinhVien = new SinhVien(arr[1], arr[0]);
        phong.getSinhVien().add(sinhVien);
        phong.SoNguoi = 1;
        phongs.add(phong);

        TaoPhong();
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
            TaoPhong();
            ListenThread();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            int i = jTable1.getSelectedRow();
            if (i > -1) {
                for (DatagramPacket item : listPK.keySet()) {
                    sendData(phongs.get(i).getID(), serversocket, item);
                }
                phongs.remove(i);
                TaoPhong();
            } else {
                JOptionPane.showMessageDialog(this, "Chọn phòng để xóa");
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Phong phong = new Phong();
        phong.ID = TaoMaPhong();
        phong.getSinhVien().add(new SinhVien("Admin", "Admin"));
        phong.SoNguoi = 0;
        phongs.add(phong);
        String CHUOI = "Admin/Admin/Đã tạo phòng/Tao";

        TaoPhong();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextArea txtShow;
    // End of variables declaration//GEN-END:variables

}
