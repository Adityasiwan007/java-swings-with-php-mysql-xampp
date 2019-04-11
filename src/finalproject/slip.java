package finalproject;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class slip  {
    String name,mail,contact,id,pass,d1,d2,d3,d4,d5;
    
    Connection conn = null;
   Statement stmt = null;;
    slip() throws SQLException
    {
        
        try {
            connectDb();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(slip.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame jf=new JFrame();
        JLabel jl=new JLabel("Details of Ordered Item");
        jl.setBounds(130,40,400,100);
        
        jl.setFont(new java.awt.Font("Tahoma",1,25));
        jl.setForeground(new java.awt.Color(21,21,190));
        //stmt = conn.createStatement();
        System.out.println("Enetred");
        //String sql = "SELECT Name,Contact,Mail FROM login";
     /* ResultSet rs = stmt.executeQuery(sql);
      
      while(rs.next()){
         //Retrieve by column name
       
         String Name = rs.getString("Name");
         String Contact = rs.getString("Contact");
         String Mail = rs.getString("Mail");
         //Display values
         System.out.print("Name: " + Name);
         System.out.print("Contact: " + Contact);
         System.out.print("Mail: " + Mail);
         
      }*/
      //rs.close();
      try{
    Class.forName("java.sql.Driver");
    try (Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/digitised", "root", "")) {
        Statement st=conn.createStatement();
        String query="Select * from information";
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
             d1=rs.getString("Name");
            d2=rs.getString("Mail");
            d3=rs.getString("Amount");
            d4=rs.getString("Item");
            d5=rs.getString("Quantity");
            /*String d3=rs.getString("dressclr");
            String d4=rs.getString("homecourt");
            String d5=rs.getString("won");
            String d6=rs.getString("lost");*/
           // System.out.println(d1+d2);
            
        }
        System.out.println(d1+d2);
        rs.close();
        st.close();
        
    }
}catch(Exception e)
{
    //JOptionPane.showMessageDialog(this,"Error in connectivity");
}
        JLabel jl1=new JLabel("Name: "+d1);
        jl1.setBounds(83,168,150,20);
         JLabel jl2=new JLabel("Total Amount: "+d3);
        jl2.setBounds(215,375,150,20);
         JLabel jl3=new JLabel("Product Name: "+d4 );
        jl3.setBounds(83,190,900,200);
         JLabel jl4=new JLabel("Mail: "+d2);
         jl4.setBounds(380,168,150,20);
         JLabel jl5=new JLabel("Quantity: "+d5);
         jl5.setBounds(380,280,150,20);
        JButton jb=new JButton("Payment");
        jb.setBounds(225,402,100,50);
         
         jb.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 
                                                        
                    
                         
                    
                        {
                             System.out.println("Inserted");
                            jf.dispose();
                         
                            payment o=new payment ();// to go back into 1st page
                         //o.setVisible(true);
                        } 
                        //Finalproject o=new Finalproject();// to go back into 1st page
                     }             
                                     
                     
                     
                     
                  
                 
                  
                 
                 
             
             
            
         });
        jf.add(jb);
        jf.add(jl);
        
        jf.add(jl1);
        jf.add(jl2);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
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
                Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/digitised", "root", "");
                System.out.print("Connected");                 
            }
            catch(Exception e)
            
            {
                 System.out.println("Error");            
                e.printStackTrace();
            }
         }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}