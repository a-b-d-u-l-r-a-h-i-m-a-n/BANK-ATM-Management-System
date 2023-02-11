import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String Card___Numbe;
    Withdrawl(String Card___Numbe){
        this.Card___Numbe = Card___Numbe;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,10,800,800);
        setTitle("Withdrawl");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm2image.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);
        
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        l1.setBounds(250,160,500,20);
        l3.add(l1);
        
        l2.setBounds(250,190,400,20);
        l3.add(l2);
        
        t1.setBounds(250,230,330,30);
        l3.add(t1);
        
        b1.setBounds(450,350,150,35);
        l3.add(b1);
        
        b2.setBounds(450,403,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
       
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    conec c1 = new conec();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where Account_Number = '"+Card___Numbe+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("Type_").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("Transtion_Amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("Transtion_Amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+Card___Numbe+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Loginpage().setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transaction(Card___Numbe).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

}