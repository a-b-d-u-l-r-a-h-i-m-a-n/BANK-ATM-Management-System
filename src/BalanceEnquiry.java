import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String Card___Numbe;

    BalanceEnquiry(String Card___Numbe) {
        this.Card___Numbe = Card___Numbe;
        setLocation(0, 0);
        setSize(800, 800);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm2image.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 800, 800);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(210, 190, 400, 35);
        l3.add(l1);

        b1.setBounds(450, 300, 150, 35);
        l3.add(b1);
        int balance = 0;
        try{
            conec c1 = new conec();
            ResultSet rs = c1.s.executeQuery("select * from bank where Account_Number = '"+Card___Numbe+"'");
            while (rs.next()) {
                if (rs.getString("Type_").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Transtion_Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Transtion_Amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);

       
        setUndecorated(true);
       
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(Card___Numbe).setVisible(true);
    }

   /* public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }*/
}
