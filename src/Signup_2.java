import javax.swing.JFrame;
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

public class Signup_2 extends JFrame implements ActionListener{
    JComboBox relitext,categetext,incometext,edutext,ocupationtext;
    String Religion[]={"select religion","Hindu","Muslim","Christian"};
    String categery[]={"select categery","General","OBC","SC","ST","EWS"};
    String[] inx={"select income","less than 100000","100000-500000","500000-1000000","above 1000000"};
    String[] educat={"select Education","Post-Graduation","Graduation","Intermediate/equlas","10th class","no eduction"};
    String[] Ocuupation={"select Occupation","Farmer","Gov Empolyee","Account","private Employee"};
    JTextField panc,adc;
    JRadioButton ysr,nsr,yea,nea;
    String foe;
    JButton next1;

    
    Signup_2(String foe){
        this.foe=foe;
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,100,550,550);
        setTitle("Page 2 : Additional Details");
        getContentPane().setBackground(Color.CYAN);
        JLabel page2=new JLabel("Page 2 : Additional Details");
        page2.setBounds(170,50,200,30);
        page2.setFont(new Font("arial",Font.BOLD,15));
        add(page2);
        JLabel reli=new JLabel("Religion:");
        reli.setBounds(80,105,100,30);
        reli.setFont(new Font("arial",Font.BOLD,13));
        add(reli);
        JLabel catege=new JLabel("Category:");
        catege.setBounds(80,135,100,30);
        catege.setFont(new Font("arial",Font.BOLD,13));
        add(catege);
        JLabel income=new JLabel("Income:");
        income.setBounds(80,165,100,30);
        income.setFont(new Font("arial",Font.BOLD,13));
        add(income);
        JLabel edu=new JLabel("Educational");
        edu.setBounds(80,195,100,30);
        edu.setFont(new Font("arial",Font.BOLD,13));
        add(edu);
        JLabel qulification=new JLabel("Qualification:");
        qulification.setBounds(80,220,100,20);
        qulification.setFont(new Font("arial",Font.BOLD,13));
        add(qulification);
        JLabel ocupation=new JLabel("Occupation:");
        ocupation.setBounds(80,255,100,13);
        ocupation.setFont(new Font("arial",Font.BOLD,13));
        add(ocupation);
        JLabel pan=new JLabel("PAN Card:");
        pan.setBounds(80,295,100,13);
        pan.setFont(new Font("arial",Font.BOLD,13));
        add(pan);
        JLabel adhar=new JLabel("Adhar Card:");
        adhar.setBounds(80,325,100,13);
        adhar.setFont(new Font("arial",Font.BOLD,13));
        add(adhar);
        JLabel srcitizen_1=new JLabel("Senior Citizen:");
        srcitizen_1.setBounds(80,355,100,13);
        srcitizen_1.setFont(new Font("arial",Font.BOLD,13));
        add(srcitizen_1);
        JLabel exist_Account=new JLabel("Existing Account:");
        exist_Account.setBounds(80,385,130,13);
        exist_Account.setFont(new Font("arial",Font.BOLD,13));
        add(exist_Account);
        relitext=new JComboBox<>(Religion);
        relitext.setBounds(230,105,250,20);
        relitext.setFont(new Font("arial",Font.BOLD,10));
        add(relitext);
        categetext=new JComboBox<>(categery);
        categetext.setBounds(230,135,250,20);
        categetext.setFont(new Font("arial",Font.BOLD,10));
        add(categetext);
        incometext=new JComboBox<>(inx);
        incometext.setBounds(230,165,250,20);
        incometext.setFont(new Font("arial",Font.BOLD,10));
        add(incometext);
        edutext=new JComboBox<>(educat);
        edutext.setBounds(230,220,250,20);
        edutext.setFont(new Font("arial",Font.BOLD,10));
        add(edutext);
        ocupationtext=new JComboBox<>(Ocuupation);
        ocupationtext.setBounds(230,255,250,20);
        ocupationtext.setFont(new Font("arial",Font.BOLD,10));
        add(ocupationtext);
        panc=new JTextField();
        panc.setBounds(230,295,250,20);
        panc.setFont(new Font("arial",Font.BOLD,10));
        add(panc);
        adc=new JTextField();
        adc.setBounds(230,325,250,20);
        adc.setFont(new Font("arial",Font.BOLD,10));
        add(adc);
        ysr=new JRadioButton("Yes");
        ysr.setBounds(230,355,125,20);
        ysr.setFont(new Font("arial",Font.BOLD,10));
        ysr.setBackground(Color.CYAN);
        add(ysr);
        nsr=new JRadioButton("No");
        nsr.setBounds(350,355,125,20);
        nsr.setFont(new Font("arial",Font.BOLD,10));
        add(nsr);
        nsr.setBackground(Color.CYAN);
        ButtonGroup nsrysr=new ButtonGroup();
        nsrysr.add(nsr);
        nsrysr.add(ysr);
        yea=new JRadioButton("Yes");
        yea.setBounds(230,385,125,20);
        yea.setFont(new Font("arial",Font.BOLD,10));
        yea.setBackground(Color.CYAN);
        add(yea);
        nea=new JRadioButton("No");
        nea.setBounds(350,385,125,20);
        nea.setFont(new Font("arial",Font.BOLD,10));
        add(nea);
        nea.setBackground(Color.CYAN);
        ButtonGroup neaysr=new ButtonGroup();
        neaysr.add(nea);
        neaysr.add(yea);
        next1=new JButton("Next");
        next1.setBounds(400,470,80,30);
        next1.setBackground(Color.BLUE);
        next1.setForeground(Color.WHITE);
        add(next1);
        next1.addActionListener(this);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String reliz__1=(String) relitext.getSelectedItem();
        String cate__1=(String) categetext.getSelectedItem();
        String edu_1=(String) edutext.getSelectedItem();
        String Incom__1=(String) incometext.getSelectedItem();
        String ocu__1=(String) ocupationtext.getSelectedItem();
        String pan__1=panc.getText();
        String ad__1=adc.getText();
        String sr__1=null;
        if(nsr.isSelected()){
            sr__1="No";
        }else if(ysr.isSelected()){
            sr__1="Yes";
        }
        String ea__1=null;
        if(nea.isSelected()){
            ea__1="No";
        }else if(yea.isSelected()){
            ea__1="Yes";
        }
        try{
            conec c=new conec();
            String query="insert into signup_2 values('"+foe+"','"+reliz__1+"','"+cate__1+"','"+Incom__1+"','"+edu_1+"','"+ocu__1+"','"+pan__1+"','"+ad__1+"','"+sr__1+"','"+ea__1+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new Signup3(foe).setVisible(true);
            //signup 3 class connect
        }catch(Exception eq){
            System.out.println(eq);
        }
        
    }
}
