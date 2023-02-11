import javax.swing.JButton;
import javax.swing.JFrame;
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
import com.toedter.calendar.JDateChooser;

public class Signupform extends JFrame implements ActionListener,FocusListener{
    private static final int PLAIN_MESSAGE = 0;
    JTextField ptext,ftext,etext,pintext,Stext,Ctext,Atext;
    JProgressBar bar;
    JRadioButton male,female;
    String[] ty={"select status","Married","Single","Diversed","Living"};
    JComboBox satus;
    JDateChooser dtchooser;
    JButton next;
    long run;
    Random ran=new Random();
    Signupform(){
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,100,550,550);
        setTitle("APLICTION FORM");
        getContentPane().setBackground(Color.CYAN);
        bar=new JProgressBar(0,100);
        bar.setBounds(80,420,400,30);
        add(bar);
        bar.setStringPainted(true);
        bar.setValue(0);
        long run=Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel form=new JLabel("APLPLICTION FOR NO  "+run);
        form.setBounds(140,40,400,30);
        form.setFont(new Font("arial",Font.BOLD,20));
        add(form);
        JLabel page=new JLabel("Page 1: Personal Details");
        page.setBounds(170,75,200,30);
        page.setFont(new Font("arial",Font.BOLD,15));
        add(page);
        ptext=new JTextField();
        ptext.setBounds(230,105,250,20);
        ptext.setFont(new Font("arial",Font.BOLD,10));
        add(ptext); 
        JLabel name=new JLabel("Name:");
        name.setBounds(80,105,100,30);
        name.setFont(new Font("arial",Font.BOLD,13));
        add(name);
        JLabel fname=new JLabel("Father's Name:");
        fname.setBounds(80,135,100,30);
        fname.setFont(new Font("arial",Font.BOLD,13));
        add(fname);
        ftext=new JTextField();
        ftext.setBounds(230,135,250,20);
        ftext.setFont(new Font("arial",Font.BOLD,10));
        add(ftext);
        JLabel Date=new JLabel("Date of Birth:");
        Date.setBounds(80,165,100,30);
        Date.setFont(new Font("arial",Font.BOLD,13));
        add(Date);
        dtchooser=new JDateChooser();
        dtchooser.setBounds(230,165,250,20);
        dtchooser.setForeground(Color.BLACK);
        add(dtchooser);
        JLabel Gender=new JLabel("Gender:");
        Gender.setBounds(80,195,100,30);
        Gender.setFont(new Font("arial",Font.BOLD,13));
        add(Gender);
        male=new JRadioButton("Male");
        male.setBounds(230,195,100,20);
        male.setFont(new Font("arial",Font.BOLD,10));
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(330,195,100,20);
        female.setFont(new Font("arial",Font.BOLD,10));
        add(female);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        JLabel Email=new JLabel("Email Address:");
        Email.setBounds(80,225,100,30);
        Email.setFont(new Font("arial",Font.BOLD,13));
        add(Email);
        etext=new JTextField();
        etext.setBounds(230,225,250,20);
        etext.setFont(new Font("arial",Font.BOLD,10));
        add(etext);
        JLabel marrege=new JLabel("Marital Status:");
        marrege.setBounds(80,255,100,30);
        marrege.setFont(new Font("arial",Font.BOLD,13));
        add(marrege);
        satus=new JComboBox<>(ty);
        satus.setBounds(230,255,250,20);
        satus.setFont(new Font("arial",Font.BOLD,10));
        add(satus);
        JLabel adress=new JLabel("Address:");
        adress.setBounds(80,285,100,30);
        adress.setFont(new Font("arial",Font.BOLD,13));
        add(adress);
        Atext=new JTextField();
        Atext.setBounds(230,285,250,20);
        Atext.setFont(new Font("arial",Font.BOLD,10));
        add(Atext);
        JLabel city=new JLabel("City:");
        city.setBounds(80,305,100,40);
        city.setFont(new Font("arial",Font.BOLD,13));
        add(city);
        Ctext=new JTextField();
        Ctext.setBounds(230,315,250,20);
        Ctext.setFont(new Font("arial",Font.BOLD,10));
        add(Ctext);
        JLabel State=new JLabel("State:");
        State.setBounds(80,335,100,30);
        State.setFont(new Font("arial",Font.BOLD,13));
        add(State);
        Stext=new JTextField();
        Stext.setBounds(230,340,250,20);
        Stext.setFont(new Font("arial",Font.BOLD,10));
        add(Stext);
        JLabel code=new JLabel("Pin Code:");
        code.setBounds(80,365,100,30);
        code.setFont(new Font("arial",Font.BOLD,13));
        add(code);
        pintext=new JTextField();
        pintext.setBounds(230,370,250,20);
        pintext.setFont(new Font("arial",Font.BOLD,10));
        add(pintext);
        next=new JButton("Next");
        next.setBounds(400,470,80,30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        add(next);
        next.addActionListener(this);
        ptext.addFocusListener(this);
        ftext.addFocusListener(this);
        Atext.addFocusListener(this);
        Ctext.addFocusListener(this);
        Stext.addFocusListener(this);
        pintext.addFocusListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String foe=""+run;
        String ns=ptext.getText();
        String fs=ftext.getText();
        String dob=((JTextField)dtchooser.getDateEditor().getUiComponent()).getText();
        String gen=null;
        if(male.isSelected()){
            gen="Male";
        }else if(female.isSelected()){
            gen="Female";
        }
        String mar=null;
        if(satus.getSelectedIndex()==1){
            mar="Married";
        }else if(satus.getSelectedIndex()==2){
            mar="Single";
        }else if(satus.getSelectedIndex()==3){
            mar="Diversed";
        }else if(satus.getSelectedIndex()==4){
            mar="Living";
        }
        String mail=etext.getText();
        String adre=Atext.getText();
        String cite=Ctext.getText();
        String sta=Stext.getText();
        String pinca=pintext.getText();

        try{
            boolean fill=true;
            while(fill){
            if(ns.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required", "name", PLAIN_MESSAGE);
                fill=false;
            }else if(fs.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "dob is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(gen==null){
                JOptionPane.showMessageDialog(null, "Gender is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(mail.equals("")){
                JOptionPane.showMessageDialog(null, "Email is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(mar==null){
                JOptionPane.showMessageDialog(null, "Marital Status is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(adre.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(cite.equals("")){
                JOptionPane.showMessageDialog(null, "City is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(sta.equals("")){
                JOptionPane.showMessageDialog(null, "State is Required", "name", PLAIN_MESSAGE);
                fill=false;
            } else if(pinca.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Code is Required", "name", PLAIN_MESSAGE);
                fill=false;
            }else{
                conec c=new conec();
                String query="insert into signup values('"+foe+"','"+ns+"','"+fs+"','"+dob+"','"+gen+"','"+mail+"','"+mar+"','"+adre+"','"+cite+"','"+sta+"','"+pinca+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup_2(foe).setVisible(true);
                fill=false;
            } 
        }
        }catch(Exception ex){
            System.out.println(ex);
        }


    }
    int n=0;
    public void focusGained(FocusEvent e) {
        if(e.getSource()==ptext){
            n+=10;
            bar.setValue(n);
        }else if(e.getSource()==ftext){
            n+=10;
            bar.setValue(n);
        }else if(e.getSource()==etext){
            n+=10;
            bar.setValue(n);
        }else if(e.getSource()==Atext){
            n+=10;
            bar.setValue(n);
        }else if(e.getSource()==Ctext){
            n+=10;
            bar.setValue(n);
        }else if(e.getSource()==Stext){
            n+=10;
            bar.setValue(n);
        }else if(e.getSource()==pintext){
            
            bar.setValue(100);
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource()==ptext){
            if(ptext.getText().equals("")){
                n-=10;
                bar.setValue(n);
            }
        }else if(e.getSource()==ftext){
            if(ftext.getText().equals("")){
                n-=10;
                bar.setValue(n);
            }
        }else if(e.getSource()==etext){
            if(etext.getText().equals("")){
                n-=10;
                bar.setValue(n);
            }
        }else if(e.getSource()==Atext){
            if(Atext.getText().equals("")){
                n-=10;
                bar.setValue(n);
            }
        }else if(e.getSource()==Ctext){
            if(Ctext.getText().equals("")){
                n-=10;
                bar.setValue(n);
            }
        }else if(e.getSource()==Stext){
            if(Stext.getText().equals("")){
                n-=10;
                bar.setValue(n);
            }
        }
        
    }
    
    
}
