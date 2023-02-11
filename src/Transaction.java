import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.html.ImageView;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    JButton Deposite,CashWithdrawl,FastCash1,Mini_Statement,Pin_change,Balnace_Enquiry,Exit;
    String Cars;
    String Card___Numbe;
    Transaction(String Card___Numbe){
        this.Card___Numbe=Card___Numbe;
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,10,800,800);
        setTitle("Transaction");
        ImageIcon atmim=new ImageIcon(ClassLoader.getSystemResource("atm2image.jpg"));
        Image i1=atmim.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon im=new ImageIcon(i1);
        JLabel atmimg=new JLabel(im);
        atmimg.setBounds(0,0,800,800);
        add(atmimg);
        JLabel msg_t=new JLabel("plese select your Transaction");
        msg_t.setBounds(250,150,280,30);
        msg_t.setFont(new Font("arial",Font.BOLD,20));
        msg_t.setForeground(Color.RED);
        atmimg.add(msg_t);
        Deposite=new JButton("Deposite");
        Deposite.setBounds(180,190,160,30);
        Deposite.setFont(new Font("arial",Font.PLAIN,20));
        atmimg.add(Deposite);
        CashWithdrawl=new JButton("CashWith Drawl");
        CashWithdrawl.setBounds(390,190,250,30);
        CashWithdrawl.setFont(new Font("arial",Font.PLAIN,20));
        atmimg.add(CashWithdrawl);
        Pin_change=new JButton("PIN Change");
        Pin_change.setBounds(180,260,160,30);
        Pin_change.setFont(new Font("arial",Font.PLAIN,20));
        atmimg.add(Pin_change);
        Mini_Statement=new JButton("Mini Statement");
        Mini_Statement.setBounds(390,260,250,30);
        Mini_Statement.setFont(new Font("arial",Font.PLAIN,20));
        atmimg.add(Mini_Statement);
        FastCash1=new JButton("Fast Cash");
        FastCash1.setBounds(180,330,160,30);
        FastCash1.setFont(new Font("arial",Font.PLAIN,20));
        atmimg.add(FastCash1);
        Balnace_Enquiry=new JButton("Balance Enquiry");
        Balnace_Enquiry.setBounds(390,330,250,30);
        Balnace_Enquiry.setFont(new Font("arial",Font.PLAIN,20));
        atmimg.add(Balnace_Enquiry);
        Exit=new JButton("Exit");
        Exit.setBounds(390,400,250,30);
        Exit.setFont(new Font("arial",Font.PLAIN,20));
        Exit.addActionListener(this);
        Deposite.addActionListener(this);
        FastCash1.addActionListener(this);
        CashWithdrawl.addActionListener(this);
        Balnace_Enquiry.addActionListener(this);
        Mini_Statement.addActionListener(this);
        Pin_change.addActionListener(this);
        atmimg.add(Exit);
        setUndecorated(true);
        setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Exit){
            System.exit(0);
            //dispose();
        }
        if(ae.getSource()==Deposite){
            setVisible(false);
            new DepositeBut(Card___Numbe);
        }else if(ae.getSource()==FastCash1){
            setVisible(false);
            new FastCash(Card___Numbe).setVisible(true);
        }else if(ae.getSource()==CashWithdrawl){
            setVisible(false);
            new Withdrawl(Card___Numbe).setVisible(true);
        }else if(ae.getSource()==Balnace_Enquiry){
            setVisible(false);
            new BalanceEnquiry(Card___Numbe).setVisible(true);
        }else if(ae.getSource()==Mini_Statement){
            setVisible(false);
            new MiniStatement(Card___Numbe).setVisible(true);
        }
        else if(ae.getSource()==Pin_change){
            setVisible(false);
            new Pinchange(Card___Numbe).setVisible(true);
        }
        
    }
    
}
