/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.BufferedWriter;
import static Bai2.DES.decrypt;
import static Bai2.DES.encrypt;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Administrator
 */
public class DES3 extends javax.swing.JFrame {

    /**
     * Creates new form DES3
     */
    public DES3() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnencrypt = new javax.swing.JButton();
        btnghifile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btndecrypt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtkhoa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmahoa = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtvanban = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnencrypt.setText("Mã Hóa");
        btnencrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnencryptActionPerformed(evt);
            }
        });

        btnghifile.setText("Ghi File");
        btnghifile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnghifileActionPerformed(evt);
            }
        });

        jLabel1.setText("3DES");

        jLabel2.setText("InputKey");

        jLabel3.setText("PlainText");

        btndecrypt.setText("Giải Mã");
        btndecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndecryptActionPerformed(evt);
            }
        });

        jLabel4.setText("CipherText");

        txtmahoa.setColumns(20);
        txtmahoa.setRows(5);
        jScrollPane1.setViewportView(txtmahoa);

        txtvanban.setColumns(20);
        txtvanban.setRows(5);
        jScrollPane2.setViewportView(txtvanban);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnencrypt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnghifile))
                    .addComponent(txtkhoa)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btndecrypt)
                        .addGap(77, 77, 77)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnencrypt)
                    .addComponent(btnghifile))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btndecrypt)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec myKeySpec;
    private SecretKeyFactory mySecretKeyFactory;
    private Cipher cipher;
    byte[] keyAsBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;
    
    public String encrypt(String unencryptedString){
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plaintext = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plaintext);
            BASE64Encoder base64encoder = new BASE64Encoder();
            encryptedString = base64encoder.encode(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
    public String decrypt(String encryptedString){
        String decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            BASE64Decoder base64decoder = new BASE64Decoder();
            byte[] encryptedText = base64decoder.decodeBuffer(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            String a = new String(plainText);
            System.out.println("chuoi plaintext: " + a);
            decryptedText = a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
    private void btnencryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnencryptActionPerformed
         try {
            myEncryptionKey = txtkhoa.getText();
            myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
            keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
            myKeySpec = new DESedeKeySpec(keyAsBytes);
            mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key = mySecretKeyFactory.generateSecret(myKeySpec);
            System.out.println("Khoa ma hoa k: " + " " + key);
            
            String plainText = txtvanban.getText();
            String encrypted = encrypt(plainText);
            System.out.println("Encrypted Value: " + encrypted);
            txtmahoa.setText(encrypted);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnencryptActionPerformed

    private void btnghifileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnghifileActionPerformed
        try {
            BufferedWriter bw = null;
            String fileName = "D:\\Des.txt";
            String s = txtvanban.getText();
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(s);
            bw.close();
            JOptionPane.showMessageDialog(null, "Đã Ghi File");
            
        } catch (IOException ex) {
            Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null,ex);
        }
    }//GEN-LAST:event_btnghifileActionPerformed

    private void btndecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndecryptActionPerformed
        FileInputStream fis2 = null;
        try {
//            String key = txtkhoa.getText();
//            String fileName = "D:\\Des.txt";
//            fis2= new FileInputStream("D:\\EnDes.txt");
//            FileOutputStream fos2 = new FileOutputStream("D:\\DeDes.txt");
//            decrypt(key, fis2, fos2);
//            BufferedReader br = null;
//
//            br = new BufferedReader(new FileReader(fileName));
//            StringBuffer sb = new StringBuffer();
//            JOptionPane.showMessageDialog(null, "Đã Giải Mã");
//            char[] ca = new char[5];
//            while(br.ready()){
//                int len = br.read(ca);
//                sb.append(ca, 0, len);
//            }
//            br.close();
//            // xuat chuoi
//            System.out.println("Dữ Liệu Là: " + " " + sb);
//            String chuoi = sb.toString();
//
//            txtvanban.setText(chuoi);
              String CipherText = txtmahoa.getText();
              String decrypt = decrypt(CipherText);
             txtvanban.setText(decrypt);
        } catch (Throwable ex) {
            Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
        }
//        }finally{
//            try {
//                fis2.close();
//            }catch (IOException ex) {
//                Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_btndecryptActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DES3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DES3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DES3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DES3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DES3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndecrypt;
    private javax.swing.JButton btnencrypt;
    private javax.swing.JButton btnghifile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtkhoa;
    private javax.swing.JTextArea txtmahoa;
    private javax.swing.JTextArea txtvanban;
    // End of variables declaration//GEN-END:variables
}
