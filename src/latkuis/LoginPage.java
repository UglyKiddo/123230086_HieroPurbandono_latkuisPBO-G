/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener{
    JLabel tulisan  = new JLabel("Login Page");
    JLabel usernameLabel = new JLabel("Username: ");
    JLabel passwordLabel = new JLabel("Password: ");
    
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordTextField = new JPasswordField();
    
    JButton tombolLogin = new JButton("Login");
    JButton tombolReset = new JButton("Reset");
    
    LoginPage(){
        setVisible(true);
        setSize(720, 480);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        add(tulisan);
        tulisan.setBounds(330,20,150,30);
        
        add(usernameLabel);
        usernameLabel.setBounds(220,50,440,20);
        
        add(usernameTextField);
        usernameTextField.setBounds(220, 70, 280,20);
        
        add(passwordLabel);
        passwordLabel.setBounds(220, 100, 440, 20);
        
        add(passwordTextField);
        passwordTextField.setBounds(220, 120, 280, 20);
        
        add(tombolLogin);
        tombolLogin.setBounds(220, 150, 100, 28);
        tombolLogin.addActionListener(this);
        
        add(tombolReset);
        tombolReset.setBounds(340, 150, 100,28);
        tombolReset.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
           if(e.getSource() == tombolLogin){
               String username = usernameTextField.getText();
               char[] passChar = passwordTextField.getPassword();
               String password = new String(passChar);
               
               if(username.equals("123230086") && password.equals("ifkelasg")){
                   System.out.println("sukses login");
                   JOptionPane.showMessageDialog(this, "Login Berhasil");
                   
                   new HomePage(username);
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(this, "Username atau Password Salah");
               }
           }else if(e.getSource() == tombolReset){
               usernameTextField.setText("");
               passwordTextField.setText("");
           }
       }catch(Exception eror){
       
       }
    }
}
