/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener{
   JLabel labelGreeting = new JLabel();
   JLabel keterangan = new JLabel();
   
   JButton tombolAnak = new JButton("DVD Anak");
   JButton tombolDewasa = new JButton("DVD Dewasa");
   JButton tombolLansia = new JButton("DVD Lansia");
   
   JButton tombolLogout = new JButton("LOGOUT");
   
   HomePage(String username){
       setVisible(true);
       setSize(720,480);
       setTitle("Dashboard Pembelian");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setLayout(null);
       
       add(labelGreeting);
       labelGreeting.setBounds(20, 20, 440, 30);
       labelGreeting.setText("Selamat Datang User " + username);
       
       add(keterangan);
       keterangan.setBounds(20, 50, 440, 30);
       keterangan.setText("silahkan pilih menu untuk membeli DVD ");
       
       add(tombolAnak);
       tombolAnak.setBounds(20, 80, 200, 50);
       tombolAnak.addActionListener((ActionListener) this);
       
       add(tombolDewasa);
       tombolDewasa.setBounds(260, 80, 200, 50);
       tombolDewasa.addActionListener((ActionListener) this);
       
       add(tombolLansia);
       tombolLansia.setBounds(500, 80, 200, 50);
       tombolLansia.addActionListener((ActionListener) this);
       
       add(tombolLogout);
       tombolLogout.setBounds(20,150, 680, 30);
       tombolLogout.addActionListener((ActionListener) this);
   }
   
    
 @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolAnak) {
            new PembayaranPage("DVD Anak");
            dispose();
        } else if (e.getSource() == tombolDewasa) {
            new PembayaranPage("DVD Dewasa");
            dispose();
        } else if (e.getSource() == tombolLansia) {
            new PembayaranPage("DVD Lansia");
            dispose();
        } else if (e.getSource() == tombolLogout) {
            JOptionPane.showMessageDialog(this, "Anda telah logout!");
            new LoginPage();
            dispose();
        }
    }
}

