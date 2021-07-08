/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import LTM.YEUCAUKETNOI;
import java.io.IOException;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HaiYen
 */
public class Thread2  extends Thread{
YEUCAUKETNOI client;
DatagramSocket socket;
    public Thread2(YEUCAUKETNOI client) {
        this.client = client;
        //this.socket = socket;
    }

    @Override
    public void run() {
      
            try {
                client.ReceiveData();
            } catch (IOException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
            client.CHECK=true;
        
    }
    
}
