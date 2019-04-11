

import com.mysql.jdbc.Connection;
//import finalproject.Finalproject;
//import finalproject.newuser;
//import finalproject.Waste1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class NewClass  {
    String name,mail,contact,id,pass;
    Connection con;
    NewClass()
    {
        try {
            connectDb();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame jf=new JFrame();
        JLabel jl=new JLabel("Generate your Account");
        jl.setBounds(130,40,400,100);
        jl.setFont(new java.awt.Font("Tahoma",1,25));
        jl.setForeground(new java.awt.Color(21,21,190));
        JTextField tf1=new JTextField();//name
        tf1.setBounds(130,170,150,20);
        JTextField tf2=new JTextField();//user name
        tf2.setBounds(130,260,150,20);
        JTextField tf4=new JTextField();//contact
        tf4.setBounds(380,210,150,20);
       // JTextField tf5=new JTextField();//password
       // tf5.setBounds(380,300,150,20);
        JTextField tf3=new JTextField();//email
        tf3.setBounds(130,350,150,20);
        JLabel jl1=new JLabel("Name: ");
        jl1.setBounds(80,168,150,20);
         JLabel jl2=new JLabel("dick size ");
        jl2.setBounds(80,350,150,20);
         JLabel jl3=new JLabel("adress ");
        jl3.setBounds(78,258,150,20);
         //JLabel jl4=new JLabel("User Name ");
       // jl4.setBounds(415,188,150,20);
         //JLabel jl5=new JLabel("Password ");
        //jl5.setBounds(419,280,150,20);
        JButton jb=new JButton("SUBMIT");
        jb.setBounds(225,402,100,50);
         
         jb.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 
                                                          
                     name=tf1.getText();
                   mail =tf3.getText();
                     contact=tf2.getText();
                    // id=tf4.getText();
                    //pass=tf5.getText();
                     
                         
                     {
                     try {
                         PreparedStatement p = null;
                         try {
                             p = con.prepareStatement("INSERT INTO login (`name`, `dicksize`,`adress`) VALUES (? ,? ,? )");
                         } catch (SQLException ex) {
                             Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         
                         p.setString(1,name);
                         p.setString(2,contact);
                         p.setString(3,mail);
                         // p.setString(4,id);
                         //p.setString(5,pass);
                         
                         p.executeUpdate();
                         
                         
                         if(p==null)
                         {
                             System.out.println("Null");
                             
                             
                         }
                         else
                         {
                             System.out.println("Inserted");
                             jf.dispose();
                             
                             //Waste1 o=new Waste1 ();// to go back into 1st page
                             //o.setVisible(true);
                         }
                         //Finalproject o=new Finalproject();// to go back into 1st page
                     } catch (SQLException ex) {
                         Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     }
                    
                     
                     {
                       JOptionPane.showMessageDialog(null, "please enter Correct number","Title",JOptionPane.ERROR_MESSAGE);  
                     }
                     
                     
                     
                     
                 } 
                 
                 
                  
                 
                 
             
             
            
         });
        jf.add(jb);
        jf.add(jl);
        jf.add(tf1);
        jf.add(tf2);
        jf.add(tf3);
        jf.add(tf4);
        //jf.add(tf5);
        jf.add(jl1);
        jf.add(jl2);
        jf.add(jl3);
        //jf.add(jl4);
        //jf.add(jl5);
        jf.setSize(600,500);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setBackground(Color.GRAY);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
           
             
        
    }
    public void connectDb() throws ClassNotFoundException
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/amit", "root", "");
                System.out.print("Connected");                 
            }
            catch(Exception e)
            
            {
                 System.out.println("Error");            
                e.printStackTrace();
            }
         }
    
}