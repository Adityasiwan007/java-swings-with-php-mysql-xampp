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
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class payment  {
    String b_name,c_type,a_status,t_no,o_id,d1,d2,d3,d4,d5;
    Connection con;
    payment()
    {
        try {
            connectDb();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame jf=new JFrame();
        JLabel jl=new JLabel("Welcome To Online payment");
        jl.setBounds(130,40,400,100);
        jl.setFont(new java.awt.Font("Tahoma",1,25));
        jl.setForeground(new java.awt.Color(21,21,190));
         try{
    Class.forName("java.sql.Driver");
    try (Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/digitised", "root", "")) {
        Statement st=conn.createStatement();
        String query="Select * from information";
        ResultSet rs=st.executeQuery(query);
        while(rs.next())
        {
             d1=rs.getString("Order_ID");
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
        JTextField tf1=new JTextField();//b_name
        tf1.setBounds(120,170,150,20);
        JTextField tf3=new JTextField();//c_type
        tf3.setBounds(130,260,150,20);
        //JTextField tf4=new JTextField();//a_status
        //tf4.setBounds(380,210,150,20);
        String status[]={"Successful","Pending","Unsuccessful"};
        JComboBox jb3=new JComboBox(status);
         jb3.setBounds(380,182,150,20);
          String card[]={"Visa","Master-card","Mestro","Net-Banking","Rupay","Debit-Card","Credit-Card"};
        JComboBox jb4=new JComboBox(card);
         jb4.setBounds(148,353,150,20);
        JTextField tf5=new JTextField();//t_no
        tf5.setBounds(380,277,150,20);
        //JTextField tf2=new JTextField();//c_type
        //tf2.setBounds(130,350,150,20);
        JLabel jl1=new JLabel("Bank: ");
        jl1.setBounds(80,168,150,20);
         JLabel jl2=new JLabel("Card Type: ");
        jl2.setBounds(80,350,150,20);
         JLabel jl3=new JLabel("Order ID: "+d1);
        jl3.setBounds(80,258,150,20);
         JLabel jl4=new JLabel("accnt. status: ");
        jl4.setBounds(415,157,150,20);
         JLabel jl5=new JLabel("trans. no: ");
        jl5.setBounds(419,258,150,20);
        JLabel jl6=new JLabel("Amount: "+d3);
        jl6.setBounds(380,350,150,20);
        JButton jb=new JButton("Pay");
        jb.setBounds(225,402,100,50);
         
         jb.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 
                 try {                                         
                     b_name=tf1.getText();
                    o_id=tf3.getText();
                     c_type=jb4.getSelectedItem().toString();
                    //a_status=tf4.getText();
                    a_status=jb3.getSelectedItem().toString();
                    t_no=tf5.getText();
                     
                     PreparedStatement p = con.prepareStatement("INSERT INTO payu (`Bank_Name`, `Card_Type`,`Account_Status`,`Transition_No`,`Order_ID1`,`Amount`) VALUES (? ,? ,? ,? ,?,?)");
                                          
                     p.setString(1,b_name);
                     p.setString(2,c_type);
                     p.setString(3,a_status);
                     p.setString(4,t_no);
                     p.setString(5,d1);
                     p.setString(6,d3);
                                      
                    
                    p.executeUpdate();
                     if(p==null)
                     {
                         System.out.print("Null");
                         
                     }
                     else
                     {
                        System.out.print("Inserted");
                        jf.dispose();
                     }
                    Waste1 o=new Waste1();// to go back into 1st page ///
                     
                 } catch (SQLException ex) {
                     Logger.getLogger(Finalproject.class.getName()).log(Level.SEVERE, null, ex);
                     //Logger.getLogger(payu.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  
                 JOptionPane.showMessageDialog(null, "Test Message","Title",JOptionPane.ERROR_MESSAGE);
                 
             }
         });
        jf.add(jb);
        jf.add(jl);
        jf.add(tf1);
        //jf.add(tf2);
        //jf.add(tf3);
        jf.add(jb3);
        jf.add(jb4);
        jf.add(tf5);
        jf.add(jl1);
        jf.add(jl2);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
        jf.add(jl6);
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