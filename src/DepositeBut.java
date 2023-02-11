import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.html.ImageView;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class DepositeBut extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String Card___Numbe;
    DepositeBut(String Card___Numbe){
        this.Card___Numbe = Card___Numbe;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,10,800,800);
        setTitle("Deposite");
        ImageIcon atmim=new ImageIcon(ClassLoader.getSystemResource("atm2image.jpg"));
        Image i1=atmim.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon im=new ImageIcon(i1);
        JLabel l3=new JLabel(im);
        l3.setBounds(0,0,800,800);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("BACK");
        
        
        
        l1.setBounds(200,190,500,35);
        l3.add(l1);
        
        t1.setBounds(210,240,350,25);
        l3.add(t1);
        
        b1.setBounds(480,358,150,35);
        l3.add(b1);
        
        b2.setBounds(480,400,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    conec c1 = new conec();
                    c1.s.executeUpdate("insert into bank values('"+Card___Numbe+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Credited Successfully");
                    setVisible(false);
                    new Loginpage().setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Loginpage().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
   
}
