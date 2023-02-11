import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.html.ImageView;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Loginpage extends JFrame implements ActionListener{
   private static final int PLAIN_TEXT = 0;
   JButton sinup,clear,login;
   JTextField cardtext;
   JPasswordField pin;
   Loginpage(){
    setTitle("ATOMATIC TELLER MACHINE");
    setLayout(null);
    getContentPane().setBackground(Color.CYAN);
    setBounds(200,200,800,500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ImageIcon logo=new ImageIcon(ClassLoader.getSystemResource("bankImge.png"));
    Image i=logo.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
    ImageIcon logo2=new ImageIcon(i);
    JLabel img=new JLabel(logo2);
    img.setBounds(130,30,80,80);
    add(img);
    JLabel welcome=new JLabel("WELCOME TO ATM");
    welcome.setFont(new Font("arial",Font.BOLD,50));
    welcome.setBounds(230,30,500,100);  
    add(welcome);
    JLabel card=new JLabel("Card Number");
    card.setBounds(150,150,200,30);
    card.setFont(new Font("Osward",Font.BOLD,30));
    add(card);
    JLabel pass=new JLabel("PIN");
    pass.setBounds(150,200,180,30);
    pass.setFont(new Font("Osward",Font.BOLD,30));
    add(pass);
    cardtext=new JTextField();
    cardtext.setBounds(380,150,200,30);
    add(cardtext);
    pin=new JPasswordField();
    pin.setBounds(380,200,200,30);
    add(pin);
    login=new JButton("login");
    login.setBounds(380,250,100,30);
    login.setBackground(Color.RED);
    login.setForeground(Color.BLACK);
    login.addActionListener(this);
    add(login);
    clear=new JButton("clear");
    clear.setBounds(480,250,100,30);
    clear.setBackground(Color.RED);
    clear.setForeground(Color.BLACK);
    clear.addActionListener(this);
    add(clear);
    setVisible(true);
    sinup=new JButton("signup");
    sinup.setBounds(380,290,200,30);
    sinup.setBackground(Color.RED);
    sinup.setForeground(Color.BLACK);
    add(sinup);
    sinup.addActionListener(this);
    setVisible(true);
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==clear){
         cardtext.setText("");
         pin.setText("");
      }else if(e.getSource()==login){
         conec c=new conec();
         String Card___Numbe=cardtext.getText();
         String Pin___Number=pin.getText();
         String query="select * from login where Card_Number1='"+Card___Numbe+"' and Pin_Number1 = '"+Pin___Number+"'";
         try {
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
               setVisible(false);
               new Transaction(Card___Numbe).setVisible(true);
            }else{
               JOptionPane.showMessageDialog(null,"Incorect Account_Number or PIN", "Messege",PLAIN_TEXT);
            }
         } catch (Exception Ae) {
            // TODO: handle exception
            System.out.println(Ae);
         }

      }else if(e.getSource()==sinup){
         setVisible(false);
         new Signupform().setVisible(true);
      }
      
   }
   public static void main(String[] args) {
    new Loginpage();
   }
   
}
