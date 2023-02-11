import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String Card___Numbe;

    FastCash(String Card___Numbe) {
        this.Card___Numbe = Card___Numbe;
        this.Card___Numbe = Card___Numbe;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,10,800,800);
        setTitle("Deposite");
        ImageIcon atmim=new ImageIcon(ClassLoader.getSystemResource("atm2image.jpg"));
        Image i1=atmim.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon im=new ImageIcon(i1);
        JLabel l3 = new JLabel(im);
        l3.setBounds(0, 0, 800, 800);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(280, 160, 500, 35);
        l3.add(l1);

        b1.setBounds(200, 210, 150, 35);
        l3.add(b1);

        b2.setBounds(420, 210, 150, 35);
        l3.add(b2);

        b3.setBounds(200, 260, 150, 35);
        l3.add(b3);

        b4.setBounds(420, 260, 150, 35);
        l3.add(b4);

        b5.setBounds(200, 310, 150, 35);
        l3.add(b5);

        b6.setBounds(420, 310, 150, 35);
        l3.add(b6);

        b7.setBounds(420, 350, 150, 35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            conec c = new conec();
            ResultSet rs = c.s.executeQuery("select * from bank where Account_Number = '"+Card___Numbe+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("Type_").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Transtion_Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Transtion_Amount"));
                }
            } 
            String num = "17";
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }
            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Loginpage().setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+Card___Numbe+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Loginpage().setVisible(true);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

    }

   
}