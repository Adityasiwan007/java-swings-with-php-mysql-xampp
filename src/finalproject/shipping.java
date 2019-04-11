package finalproject;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class shipping  {
    public String name,location,contact,item1,mail;
    public int amount,quantity;
    Connection con;
    shipping()
    {
        try {
        connectDb();
            
        JFrame f=new JFrame();
        JButton b=new JButton("CONTINUE");
        b.setBounds(400,615,100,40);
        JLabel jl=new JLabel("***Digitised_Shoping_System***");
        jl.setBounds(250,0,500,150);
        jl.setFont(new java.awt.Font("Tahoma",1,25));
        jl.setForeground(new java.awt.Color(0,0,204));
        JLabel j2=new JLabel("INSTRUCTION TO FOLLOW :");
        j2.setBounds(70,70,500,150);
         j2.setFont(new java.awt.Font("Tahoma",1,15));
        j2.setForeground(new java.awt.Color(153,255,0));
        
        JLabel jt1=new JLabel("*  Please Fill all Required Information.");
        jt1.setBounds(90,108,500,150);
        jt1.setForeground(new java.awt.Color(255,0,0));
        
        JLabel jt2=new JLabel("*  Order Will Be Shipped Whithin 15 Days.");
        jt2.setBounds(90,130,500,150);
         jt2.setForeground(new java.awt.Color(255,0,0));
        
        JLabel jt3=new JLabel("*  Payment Mode is Cash On Delivery(ONLY).");
        jt3.setBounds(90,150,500,150);
         jt3.setForeground(new java.awt.Color(255,0,0));
        
        JLabel jt4=new JLabel("*  HELPLINE : 044-356210");
        jt4.setBounds(90,170,500,150);
         jt4.setForeground(new java.awt.Color(255,0,0));
        
        JTextField tf1=new JTextField();//for name
        tf1.setBounds(160,300,200,35);
        JTextField tf2=new JTextField();//for contact no
        tf2.setBounds(600,300,200,35);
        JTextField tf3=new JTextField();//for address
        tf3.setBounds(160,400,200,35);
        JTextField tf4=new JTextField();//mail id
        tf4.setBounds(600,400,200,35);
        JTextField tf5=new JTextField();//quantity
        tf5.setBounds(160,500,200,35);
        //JTextField tf6=new JTextField();//total amount to pay on calculation
        //tf6.setBounds(340,620,150,35);
        
        //jlABEL for textfield
         JLabel jl1=new JLabel("NAME :");
         jl1.setBounds(85,65,100,500);
         JLabel jl2=new JLabel("CONTACT NO. :");
         jl2.setBounds(500,65,100,500);
         JLabel jl3=new JLabel("LOCATION :");
         jl3.setBounds(85,162,100,500);
         JLabel jl4=new JLabel("QUANTITY :");
         jl4.setBounds(85,265,100,500);
         JLabel jl5=new JLabel("MAIL-ID :");
         jl5.setBounds(500,162,100,500);
         //JLabel jl6=new JLabel("TOTAL AMOUNT TO PAY :");
         //jl6.setBounds(210,385,100,500);
         
        //to create combo-box for item
        String item[]={"dekstop[Rs 35000]","pen-drive[Rs 800]","mouse[Rs 1000]","keyboard[Rs 500]","laptop(Rs hp-i5[50000])"};
        JComboBox jb=new JComboBox(item);
         jb.setBounds(600,500,200,35);
         
         b.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 
                 try {                                         
                     name=tf1.getText();
                     contact=tf2.getText();
                     location=tf3.getText();
                     mail=tf4.getText();
                     item1=jb.getSelectedItem().toString();
                     
                     quantity=Integer.parseInt(tf5.getText());
                     if (item1.equals("pen-drive[Rs 800]"))
                     {
                         amount=quantity*800;
                     } 
                     if (item1.equals("dekstop[Rs 35000]"))
                     {
                          amount=quantity*35000;
                         
                     }
                      
                       if (item1.equals("mouse[Rs 1000]"))
                     {
                         amount=quantity*1000;
                     } 
                       if (item1.equals("keyboard[Rs 500]"))
                     {
                         amount=quantity*500;
                     } 
                      if (item1.equals("pen-drive[Rs 800]"))
                     {
                         amount=quantity*800;
                     } 
                       if (item1.equals("laptop(Rs hp-i5[50000])"))
                     {
                          amount=quantity*50000;
                     } 
                     //String test=""+amount;
                     //tf6.setText(test);
                     PreparedStatement p = con.prepareStatement("INSERT INTO information (`Name`, `Contact`, `Address`,`Mail`,Quantity,`Item`,Amount) VALUES (? ,? ,? ,? ,? , ?, ?)");
                                          
                     p.setString(1,name);
                     p.setString(2,contact);
                     p.setString(3, location);
                     p.setString(4, mail);
                     p.setInt(5,quantity);
                     p.setString(6,item1);
                     p.setInt(7,amount);
                     System.out.println(name+contact);                     
                    
                     p.executeUpdate();
                     
                     // check for insertion
                     
                     if(p==null)
                     {
                         System.out.println("Null");
                         
                     }
                     else
                     {
                         System.out.println("Inserted");
                         f.dispose();
                         slip obj=new slip (); 
                       
                     }
                     
                     //payment obj=new payment (); 
                 } catch (SQLException ex) {
                     Logger.getLogger(Finalproject.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 //JOptionPane.showMessageDialog(null, "Test Message","Title",JOptionPane.ERROR_MESSAGE);
             }
           //payment obj=new payment ();  

            private void setVisible(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
         });
       f.setBackground(Color.YELLOW);
       f.add(jt1);
       f.add(jt2);
       f.add(jt3);
       f.add(jt4);
         f.add(jl1);
         f.add(jl2);
         f.add(jl3);
         f.add(jl4);
         f.add(jl5);
         //f.add(jl6);
        
        f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);//f.add(tf6);
        
        f.add(jb);
        f.add(jl);
        f.add(j2);
        f.add(b);
        f.setSize(900,700);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
           
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Finalproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
}

//New Sub Class for list

 /*class payslip extends shipping {

    private static void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String name,location,contact,item1,mail;
    public int amount,quantity;
    Connection con;
    payslip()
    {
        try {
        connectDb();
            
        JFrame f=new JFrame();
        JButton b=new JButton("CONTINUE");
        b.setBounds(400,615,100,40);
        JLabel jl=new JLabel("***Digitised_Shoping_System***");
        jl.setBounds(250,0,500,150);
        jl.setFont(new java.awt.Font("Tahoma",1,25));
        jl.setForeground(new java.awt.Color(0,0,204));
       
        JLabel jt1=new JLabel("*  Total Amount To Pay.");
        jt1.setBounds(90,108,500,150);
        jt1.setForeground(new java.awt.Color(255,0,0));
        
        //JLabel jt2=new JLabel("*  Order Will Be Shipped Whithin 15 Days.");
        //jt2.setBounds(90,130,500,150);
         //jt2.setForeground(new java.awt.Color(255,0,0));
        
        //JLabel jt3=new JLabel("*  Payment Mode is Cash On Delivery(ONLY).");
        //jt3.setBounds(90,150,500,150);
         //jt3.setForeground(new java.awt.Color(255,0,0));
        
        //JLabel jt4=new JLabel("*  HELPLINE : 044-356210");
        //jt4.setBounds(90,170,500,150);
         //jt4.setForeground(new java.awt.Color(255,0,0));
        
       
       
        //jlABEL for textfield
         JLabel jl1=new JLabel("NAME : "+name);
         jl1.setBounds(85,65,100,500);
         JLabel jl2=new JLabel("CONTACT NO. : "+contact);
         jl2.setBounds(500,65,100,500);
         JLabel jl3=new JLabel("LOCATION :"+location);
         jl3.setBounds(85,162,100,500);
         JLabel jl4=new JLabel("QUANTITY :"+quantity);
         jl4.setBounds(85,265,100,500);
         JLabel jl5=new JLabel("MAIL :"+mail);
         jl5.setBounds(500,162,100,500);
         JLabel jl6=new JLabel("TOTAL AMOUNT TO PAY :"+amount);
         //jl6.setBounds(210,385,100,500);
         
        //to create combo-box for item
        
         b.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 payslip.dispose();
                 payment obj=new payment ();
             }
         });
       f.setBackground(Color.YELLOW);
       f.add(jt1);
       
         f.add(jl1);
         f.add(jl2);
         f.add(jl3);
         f.add(jl4);
         f.add(jl5);
         //f.add(jl6);
        
        //f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);//f.add(tf6);
        
       // f.add(jb);
        f.add(jl);
       // f.add(j2);
        f.add(b);
        f.setSize(900,700);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
           
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Finalproject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
}*/