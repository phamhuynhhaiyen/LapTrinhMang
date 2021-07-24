package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HaiYen
 */
public class CLIENT extends javax.swing.JFrame {

    ArrayList<Phong> list = new ArrayList<>();

    public CLIENT(int port, InetAddress ip, DatagramSocket client, String ten, String ma, String[] maph) {
        initComponents();
        listSinhVien = new ArrayList<SinhVien>();
        clientsocket = client;
        this.port = port;
        diachi = ip;
        name = ten;
        ID = ma;
        for (int i = 1; i < maph.length-1; i=i+2) {
          Phong phong=new Phong();
          phong.ID=maph[i];
          phong.SoNguoi=Integer.parseInt(maph[i+1]);
            
            list.add(phong);
        }
        lbID.setText(ID);
        lbName.setText(ten);
        TaoPhong();
        jTabbedPane1.setSelectedIndex(0);
        //  
        System.out.println("" + name);
        ListenThread();
        
    }

    void TaoPhong() {        
        DefaultTableModel modell = new DefaultTableModel();
        jTable1.setModel(modell);
        modell.addColumn("Mã Phòng");
           modell.addColumn("Số lượng");
        int cout = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ID.equalsIgnoreCase(maphong)) {
                cout++;
            }
            
            modell.addRow(new Object[]{list.get(i).ID,list.get(i).SoNguoi});
            
        }
        if (cout == 0) {
            jTabbedPane1.setSelectedIndex(0);
            maphong = "";
        }

//     jPanel3.removeAll();
//        GridLayout layout = new GridLayout(0, 5);
//       // layout/.setHgap(10);
//       // layout.setVgap(10);
//        jPanel3.setLayout(layout);
//        
//        for (int i = 0; i < list.size(); i++) {
//              JButton btn = new JButton("Phòng"+list.get(i));
//          btn.setName(list.get(i));
//        // add action
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                try {
//                 
//                    maphong=btn.getName();
//                Gui( ID + "/"+name + "/đã vào phòng/"+btn.getName());
//                jTabbedPane1.setSelectedIndex(1);
//             txtMessage.setEnabled(true);
//            txtShow.setEnabled(true);
//            btnSend.setEnabled(true);
//                   txtMessage.setText("");
//                   jLabel1.setText("Mã phong : "+maphong);
//              txtShow.setText("");
//            } catch (IOException ex) {
//                Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
//            }
//         //  ListenThread();
//            }
//        });
//         jPanel3.add(btn);
//      }      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNhapMa = new javax.swing.JButton();
        lbID = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtShow = new javax.swing.JTextArea();
        txtMessage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(592, 400));

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel4.setText("Tên:");

        jLabel5.setText("Mã sinh viên:");

        btnNhapMa.setText("Tạo phòng");
        btnNhapMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMaActionPerformed(evt);
            }
        });

        lbID.setText("jLabel1");

        lbName.setText("jLabel2");

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Mã phòng:");

        txtMaPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaPhongKeyPressed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbName)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNhapMa))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapMa)
                    .addComponent(jLabel5)
                    .addComponent(lbID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbName))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        txtShow.setColumns(20);
        txtShow.setRows(5);
        txtShow.setEnabled(false);
        jScrollPane1.setViewportView(txtShow);

        txtMessage.setEnabled(false);

        jLabel3.setText("Message:");

        btnSend.setText("Send");
        btnSend.setEnabled(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jButton1.setText("Thoat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend)
                    .addComponent(jButton1))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
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
    Thread IncomingReader;

    public void ListenThread() {
        jLabel1.setText("Mã phong : " + maphong);
        IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
    }
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        String sms = txtMessage.getText();
        try {
            Gui(ID + "/" + name + "/" + sms + "/" + maphong);
            txtShow.append("Tôi: " + sms + " \n");
            txtMessage.setText("");
        } catch (IOException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnNhapMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMaActionPerformed
        try {
            //String maPhong = txtMaPhong.getText();
//        if(txtMaPhong.getText().equalsIgnoreCase(maphong)){
//            txtMessage.setEnabled(true);
//            txtMessage.setText("");
//              txtShow.setText("");
//            txtShow.setEnabled(true);
//            btnSend.setEnabled(true);
//            try {
//                Gui( ID + "/"+name + "/đã vào phòng \n /"+maphong);
//            } catch (IOException ex) {
//                Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            ListenThread();
//        }else{
//            JOptionPane.showMessageDialog(this, "Bạn nhập sai! Mời nhập lại");
//        }

            Gui(ID + "/" + name + "/Đã tạo phòng/Tao");
            jTabbedPane1.setSelectedIndex(1);
            txtMessage.setEnabled(true);
            txtShow.setEnabled(true);
            btnSend.setEnabled(true);
            txtMessage.setText("");
            txtShow.setText("");
//     String[] arr=ReceiveData().split("/");
//     list=new ArrayList<>();
//                     for (int i = 4; i < arr.length; i++) {
//                         System.out.println(arr[i]);
//                        list.add(arr[i]);
//                            //TaoPhong();
//                      } 
//                     TaoPhong();
//               maphong=arr[arr.length-1];
//                     
//       jLabel1.setText("Mã phong : "+maphong);
//           System.out.println(""+maphong);
//        ListenThread();
//      
        } catch (IOException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnNhapMaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            
            Gui(ID + "/" + name + "/Đã rời khỏi phòng/" + maphong);
//            for (int i = 0; i < list.size(); i++) {
//               if(list.get(i).ID.equalsIgnoreCase(maphong))
//               {
//               list.get(i).SoNguoi--;
//               break;
//               }
//            }
//            
        //    TaoPhong();
            maphong = "";
            jTabbedPane1.setSelectedIndex(0);
            
        } catch (IOException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        maphong = list.get(jTable1.getSelectedRow()).ID;
        try {
            
            Gui(ID + "/" + name + "/đã vào phòng/" + maphong);
            jTabbedPane1.setSelectedIndex(1);
            txtMessage.setEnabled(true);
            txtShow.setEnabled(true);
            btnSend.setEnabled(true);
            txtMessage.setText("");
            jLabel1.setText("Mã phong : " + maphong);
            txtShow.setText("");
        } catch (IOException ex) {
            Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtMaPhongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaPhongKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //JOptionPane.showMessageDialog(this, "hi");
            
            maphong = txtMaPhong.getText();
            try {
                boolean dung = false;
                for (Phong item : list) {
                    //System.out.println(item);
                    if (maphong.equalsIgnoreCase(item.ID)) {
                        dung = true;
                    }
                }
                if (dung == true) {
                    Gui(ID + "/" + name + "/đã vào phòng/" + maphong);
                    jTabbedPane1.setSelectedIndex(1);
                    txtMessage.setEnabled(true);
                    txtShow.setEnabled(true);
                    btnSend.setEnabled(true);
                    txtMessage.setText("");
                    jLabel1.setText("Mã phòng: " + maphong);
                    txtShow.setText("");
                    txtMaPhong.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Phòng không tồn tại");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_txtMaPhongKeyPressed
    
    String maphong;

    public class IncomingReader implements Runnable {
        
        @Override
        public void run() {
            try {
                String a;
                
                while ((a = ReceiveData()) != null) {
                    int cout = 0;
                    
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).ID.equalsIgnoreCase(a)) {
                            list.remove(i);
                            
                            cout++;
                            TaoPhong();                            
                            System.out.println("XOA" + a);
                            break;
                        }
                        
                    }
                    System.out.println("//" + a);
                    String[] arr = a.split("/");                    
                    if (arr.length > 4) {
                        //   String[] arr=ReceiveData().split("/");
                        System.out.println("" + a);
                        list = new ArrayList<>();
                        for (int i = 4; i < arr.length-1; i=i+2) {
                            Phong phong=new Phong();
          phong.ID=arr[i];
          phong.SoNguoi=Integer.parseInt(arr[i+1]);
            
            list.add(phong);
                          
                            //
                        }
                     
                        if ((arr[0].equalsIgnoreCase(ID))) {
                            maphong = arr[arr.length - 2];
                            jLabel1.setText(maphong);
                        }
   TaoPhong();
                        // if(arr[4].e)
                        // TaoPhong();
                    }
                    try {
                        
                        if ((!arr[0].equalsIgnoreCase(ID)) && arr[3].equalsIgnoreCase(maphong)) {
                            
                            txtShow.append(arr[1] + ": " + arr[2] + "\n");
                            //kiem tra phong con tai hay khong neu khong thi phai roi phong
                        }                        
                    } catch (Exception e) {
                    }
                    
                }
            } catch (Exception ex) {
                System.out.println("sssss" + ex.getMessage());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapMa;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbName;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextArea txtShow;
    // End of variables declaration//GEN-END:variables

}
