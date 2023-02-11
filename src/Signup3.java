import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class Signup3 extends JFrame implements ActionListener {
    private static final int PLAIN_MESSAGE = 0;
    JRadioButton sv,fda,ca,rda;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton cancel3,submit3;
    String form;
    Signup3( String form){
        this.form=form;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,100,550,550);
        setTitle("Page 3");
        getContentPane().setBackground(Color.CYAN);
        JLabel page3=new JLabel("Page 3 : Account Details");
        page3.setBounds(170,50,200,30);
        page3.setFont(new Font("arial",Font.BOLD,15));
        add(page3);
        JLabel actype=new JLabel("Account Type :");
        actype.setBounds(80,80,100,30);
        actype.setFont(new Font("arial",Font.BOLD,13));
        add(actype);
        sv=new JRadioButton("Savings Account");
        sv.setBounds(100,110,135,20);
        sv.setFont(new Font("arial",Font.PLAIN,10));
        sv.setBackground(Color.CYAN);
        add(sv);
        ca=new JRadioButton("Current Account");
        ca.setBounds(265,110,135,20);
        ca.setFont(new Font("arial",Font.PLAIN,10));
        ca.setBackground(Color.CYAN);
        add(ca);
        fda=new JRadioButton("Fixed Deposite Account");
        fda.setBounds(100,130,155,20);
        fda.setFont(new Font("arial",Font.PLAIN,10));
        fda.setBackground(Color.CYAN);
        add(fda);
        rda=new JRadioButton("Reccuring Deposite Account");
        rda.setBounds(265,130,175,20);
        rda.setFont(new Font("arial",Font.PLAIN,10));
        rda.setBackground(Color.CYAN);
        add(rda);
        ButtonGroup svac=new ButtonGroup();
        svac.add(sv);
        svac.add(ca);
        svac.add(fda);
        svac.add(rda);
        JLabel card=new JLabel("Card Number :");
        card.setBounds(80,175,150,30);
        card.setFont(new Font("arial",Font.BOLD,13));
        add(card);
        JLabel cardnu=new JLabel("XXXX-XXXX-XXXX-1255");
        cardnu.setBounds(250,175,150,30);
        cardnu.setFont(new Font("arial",Font.BOLD,13));
        add(cardnu);
        JLabel pin3=new JLabel("Pin Number :");
        pin3.setBounds(80,205,150,30);
        pin3.setFont(new Font("arial",Font.BOLD,13));
        add(pin3);
        JLabel pin3nu=new JLabel("*********");
        pin3nu.setBounds(250,212,150,30);
        pin3nu.setFont(new Font("arial",Font.BOLD,33));
        add(pin3nu);
        JLabel services=new JLabel("Services Required ");
        services.setBounds(80,235,150,30);
        services.setFont(new Font("arial",Font.BOLD,13));
        add(services);
        c1=new JCheckBox("ATM CARD");
        c1.setBounds(100,265,155,20);
        c1.setFont(new Font("arial",Font.PLAIN,10));
        c1.setBackground(Color.CYAN);
        add(c1);
        c2=new JCheckBox("Internet Banking");
        c2.setBounds(265,265,155,20);
        c2.setFont(new Font("arial",Font.PLAIN,10));
        c2.setBackground(Color.CYAN);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(100,285,155,20);
        c3.setFont(new Font("arial",Font.PLAIN,10));
        c3.setBackground(Color.CYAN);
        add(c3);
        c4=new JCheckBox("EMAIL & SMS Aletrs");
        c4.setBounds(265,285,155,20);
        c4.setFont(new Font("arial",Font.PLAIN,10));
        c4.setBackground(Color.CYAN);
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBounds(100,305,155,20);
        c5.setFont(new Font("arial",Font.PLAIN,10));
        c5.setBackground(Color.CYAN);
        add(c5);
        c6=new JCheckBox("E-Statements");
        c6.setBounds(265,305,155,20);
        c6.setFont(new Font("arial",Font.PLAIN,10));
        c6.setBackground(Color.CYAN);
        add(c6);
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my Knowledge");
        c7.setBounds(50,390,500,30);
        c7.setFont(new Font("arial",Font.PLAIN,10));
        c7.setBackground(Color.CYAN);
        add(c7);
        cancel3=new JButton("Cancel");
        cancel3.setBounds(50,445,130,30);
        cancel3.setFont(new Font("arial",Font.PLAIN,20));
        cancel3.setBackground(Color.BLUE);
        add(cancel3);
        submit3=new JButton("Submit");
        submit3.setBounds(340,445,130,30);
        submit3.setFont(new Font("arial",Font.PLAIN,20));
        submit3.setBackground(Color.BLUE);
        add(submit3);
        cancel3.addActionListener(this);
        submit3.addActionListener(this);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit3){
            String accounttype=null;
            if(sv.isSelected()){
                accounttype="Savings Account";
            }else if(ca.isSelected()){
                accounttype="Current Account";
            }else if(fda.isSelected()){
                accounttype="Fixed Deposite Account";
            }else if(rda.isSelected()){
                accounttype="Reccuring Deposite Account";
            }
            Random x_ran=new Random();
            String cardn__3=""+(Math.abs((x_ran.nextLong() % 9000000L)+5663744900000000L));
            String pinn__3=""+(Math.abs(x_ran.nextLong()%9000L)+1000L);
            String Facility__3="";
            if(c1.isSelected()){
                Facility__3+=" ATM CARD";
            }else if(c2.isSelected()){
                Facility__3+=" Internet Banking";
            }else if(c3.isSelected()){
                Facility__3+=" Mobile Banking";
            }else if(c4.isSelected()){
                Facility__3+=" (EMAIL & SMS Alerts)";
            }else if(c5.isSelected()){
                Facility__3+=" Cheque_Book";
            }else if(c6.isSelected()){
                Facility__3+=" E-Statement";
            }
            
            try{
                if(accounttype==""){
                    JOptionPane.showMessageDialog(null, "select the Account Type", "hello", PLAIN_MESSAGE);
                    
                }else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "select the check Box Declaration", "hello", PLAIN_MESSAGE); 
                }
                else{
                conec c=new conec();
                String query="insert into signup_3 values('"+form+"','"+accounttype+"','"+cardn__3+"','"+pinn__3+"','"+Facility__3+"')";
                c.s.executeUpdate(query);
                String query2="insert into login values('"+form+"','"+cardn__3+"','"+pinn__3+"')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Crad Number: "+cardn__3+"\n Pin :" +pinn__3, "ATM Details", PLAIN_MESSAGE);
                setVisible(false);
                new Loginpage().setVisible(true);
                }
            }catch(Exception e3){
                System.out.println(e3);
            }
        }else if(e.getSource()==cancel3){
            dispose();
        }
        
    }
  
    
}
