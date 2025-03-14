/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PembayaranPage extends JFrame implements ActionListener {
    JLabel labelDVD = new JLabel();
    JLabel labelHarga = new JLabel();
    JLabel labelJumlah = new JLabel("Jumlah: ");

    JSpinner spinnerJumlah = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

    JButton tombolBayar = new JButton("Bayar");
    JButton tombolKembali = new JButton("Kembali");

    JLabel labelTotal = new JLabel("Total Harga (Sebelum PPN): Rp 0");
    JLabel jumlahFinal = new JLabel("Total Jumlah Yang Dibeli: 0");
    JLabel labelPPN = new JLabel("PPN 11%: Rp 0");
    JLabel labelTotalFinal = new JLabel("Total Harga (Setelah PPN): Rp 0");

    private int hargaPerItem;

    PembayaranPage(String jenisDVD) {
        setSize(720, 480);
        setTitle("Halaman Pembayaran");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        add(labelDVD);
        labelDVD.setBounds(20, 20, 440, 30);
        labelDVD.setText("Anda memilih: " + jenisDVD);

        switch (jenisDVD) {
            case "DVD Anak":
                hargaPerItem = 27891;
                break;
            case "DVD Dewasa":
                hargaPerItem = 35396;
                break;
            case "DVD Lansia":
                hargaPerItem = 38550;
                break;
            default:
                hargaPerItem = 0;
        }

        add(labelHarga);
        labelHarga.setBounds(20, 60, 440, 30);
        labelHarga.setText("Harga DVD: Rp " + hargaPerItem + "/pcs");

        add(labelJumlah);
        labelJumlah.setBounds(20, 100, 100, 30);

        add(spinnerJumlah);
        spinnerJumlah.setBounds(100, 100, 200, 30);
        spinnerJumlah.addChangeListener(e -> updateTotal());

        add(tombolBayar);
        tombolBayar.setBounds(20, 150, 200, 50);
        tombolBayar.addActionListener(this);

        add(labelTotal);
        labelTotal.setBounds(20, 220, 440, 30);
        
        add(jumlahFinal);
        jumlahFinal.setBounds(20, 250, 440, 30);

        add(labelPPN);
        labelPPN.setBounds(20, 280, 440, 30);

        add(labelTotalFinal);
        labelTotalFinal.setBounds(20, 310, 440, 30);
        
        add(tombolKembali);
        tombolKembali.setBounds(20, 360, 200, 50);
        tombolKembali.addActionListener(this);

        updateTotal();

        setVisible(true);
    }

    private void updateTotal() {
        int jumlah = (int) spinnerJumlah.getValue();
        int totalHarga = jumlah * hargaPerItem;
        int ppn = (int) (totalHarga * 0.11);
        int totalSetelahPPN = totalHarga + ppn;

        labelTotal.setText("Total Harga (Sebelum PPN): Rp " + totalHarga);
        jumlahFinal.setText("Jumlah : " + jumlah + "pcs");
        labelPPN.setText("PPN 11%: Rp " + ppn);
        labelTotalFinal.setText("Total Harga (Setelah PPN): Rp " + totalSetelahPPN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolBayar) {
            JOptionPane.showMessageDialog(this, 
                "Pembayaran berhasil!\n" +
                labelTotal.getText() + "\n" +
                labelPPN.getText() + "\n" +
                labelTotalFinal.getText()
            );
            new HomePage("User");
            dispose();
        } else if (e.getSource() == tombolKembali) {
            new HomePage("User");
            dispose();
        }
    }
}

