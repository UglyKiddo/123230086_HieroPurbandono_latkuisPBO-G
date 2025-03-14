/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener{
   
   JTextField inputNama, inputNIM, inputTugas, inputQuiz;
   JRadioButton kelasPraktikum, kelasTeori;
   JComboBox<String> mataKuliah;
   JButton submit, logout;
   
   JButton tombolLogout = new JButton("LOGOUT");
   
   HomePage(String username){
       setVisible(true);
       setSize(720,480);
       setTitle("Halaman Input Nilai");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setLayout(null);
       
       
        JLabel labelNama = new JLabel("Nama Mahasiswa:");
        labelNama.setBounds(20, 20, 120, 20);
        add(labelNama);
       
       inputNama = new JTextField();
        inputNama.setBounds(150, 20, 200, 20);
        add(inputNama);
        
        JLabel labelNIM = new JLabel("NIM Mahasiswa:");
        labelNIM.setBounds(20, 50, 120, 20);
        add(labelNIM);
        
        inputNIM = new JTextField();
        inputNIM.setBounds(150, 50, 200, 20);
        add(inputNIM);
        
        JLabel labelTugas = new JLabel("Nilai Tugas:");
        labelTugas.setBounds(20, 80, 120, 20);
        add(labelTugas);
        
        inputTugas = new JTextField();
        inputTugas.setBounds(150, 80, 200, 20);
        add(inputTugas);
        
        JLabel labelQuiz = new JLabel("Nilai Quiz:");
        labelQuiz.setBounds(20, 110, 120, 20);
        add(labelQuiz);
        
        inputQuiz = new JTextField();
        inputQuiz.setBounds(150, 110, 200, 20);
        add(inputQuiz);
        
        JLabel labelKelas = new JLabel("Tipe Kelas:");
        labelKelas.setBounds(20, 140, 120, 20);
        add(labelKelas);
        
        kelasPraktikum = new JRadioButton("Kelas Praktikum");
        kelasPraktikum.setBounds(150, 140, 120, 20);
        add(kelasPraktikum);
        
        kelasTeori = new JRadioButton("Kelas Teori", true);
        kelasTeori.setBounds(270, 140, 100, 20);
        add(kelasTeori);
        
        ButtonGroup groupKelas = new ButtonGroup();
        groupKelas.add(kelasPraktikum);
        groupKelas.add(kelasTeori);
        
        JLabel labelMataKuliah = new JLabel("Mata Kuliah:");
        labelMataKuliah.setBounds(20, 170, 120, 20);
        add(labelMataKuliah);
        
        String[] mataKuliahList = {"PBO", "SCPK", "OPK"};
        mataKuliah = new JComboBox<>(mataKuliahList);
        mataKuliah.setBounds(150, 170, 200, 20);
        add(mataKuliah);
        
        submit = new JButton("Submit");
        submit.setBounds(150, 200, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        logout = new JButton("Logout");
        logout.setBounds(150, 240, 100, 30);
        logout.addActionListener(this);
        add(logout);
        
        setVisible(true);
    }
   
    
 @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
String nama = inputNama.getText();
            String nim = inputNIM.getText();
            double nilaiTugas = Double.parseDouble(inputTugas.getText());
            double nilaiQuiz = Double.parseDouble(inputQuiz.getText());
            String mataKuliahTerpilih = (String) mataKuliah.getSelectedItem();
            String tipeKelas = kelasTeori.isSelected() ? "Teori" : "Praktikum";
            
            double totalNilai;
            if (kelasTeori.isSelected()) {
                totalNilai = (0.3 * nilaiTugas) + (0.7 * nilaiQuiz);
            } else {
                totalNilai = (0.7 * nilaiTugas) + (0.3 * nilaiQuiz);
            }
            
            String hasil = totalNilai > 85 ? "PASS" : "NOT PASS";
            
            JOptionPane.showMessageDialog(this, "Nama: " + nama + "\n" +
                                                "NIM: " + nim + "\n" +
                                                "Mata Kuliah: " + mataKuliahTerpilih + "\n" +
                                                "Tipe Kelas: " + tipeKelas + "\n" +
                                                "Total Nilai: " + totalNilai + "\n" +
                                                "Hasil: " + hasil);        
        }
           else if (e.getSource() == logout) {
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Anda telah logout!");
                 new LoginPage();
            dispose();
        }
    }
}
}

