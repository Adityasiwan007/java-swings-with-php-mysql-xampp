package finalproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;       
import javax.swing.JTextField;


class Waste1 extends JFrame 

{
    String user,password;
    Connection con;
    void connectDb() throws ClassNotFoundException
             {
                 try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/digitised", "root", "");
                System.out.print("Connected");                 
                }
                
                 catch(Exception e)
            
                    {
                System.out.println("Error");            
                e.printStackTrace();
                 }
            }
    
    Waste1()
    {
        try {
            connectDb();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Waste1.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame jf=new JFrame();
        JTextField textfield1=new JTextField();
        textfield1.setBounds(150,180,200,30);
        
        JLabel jl=new JLabel("DIGITISED SHOPPING SYSTEM");
        jl.setBounds(48,-50, 400, 300);
        jl.setFont(new java.awt.Font("Tahoma",1,25));
        jl.setForeground(new java.awt.Color(0,0,204));
        JPasswordField textfield2=new JPasswordField();
        textfield2.setBounds(150,270,200,30);
        
        JButton b1=new JButton("login");
        b1.setBounds(95,400,100,50);
        JButton b2=new JButton("Register");
        b2.setBounds(310,400,100,50);
        
        JLabel jl1=new JLabel("USER-ID :");
        jl1.setBounds(90,153,80,80);
        
        JLabel jl2=new JLabel("PASSWORD :");
        jl2.setBounds(70,245,80,80);
        
         b1.addActionListener(new ActionListener()
         {
                public void actionPerformed(ActionEvent e)
                {
                    try {
                        user=textfield1.getText();
                        password=textfield2.getText();
                        
                        String query = "SELECT * FROM `login` WHERE `username` = '"+ user +"' AND `password` = '"+ password +"'";
                        PreparedStatement fetchUserInfo = con.prepareStatement(query);
                        ResultSet rs = fetchUserInfo.executeQuery(query);
                        if(rs.next())
                        {
                            shipping ship=new shipping();
                            jf.dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "No User Found");
                            System.out.println("No User Found");
                            
                           // jf.dispose();
                            
                        }                        
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Waste1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
               
         });
         b2.addActionListener(new ActionListener()
         {
                public void actionPerformed(ActionEvent e)
                {
                    newuser obj=new newuser ();
                    jf.dispose();
                }
         });
        jf.add(jl2);
        jf.add(jl1);
        jf.add(b2);
        jf.add(b1);
        
        jf.add(jl);
        jf.add(textfield2);
        jf.add(textfield1);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setSize(500,500);
        pack();
        jf.setVisible(true);
        
        

    }
}

public class Finalproject {

    public static void main(String[] args) {
        Waste1 obj=new Waste1();
    }
    
}