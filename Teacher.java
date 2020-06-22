/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Divya Khiani
 */
public class Teacher extends Applet implements ActionListener
{

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
     Label lname, lgender, lemail,lstate,lmobile,lseatno,lpincode,lhandicap,lcollege, ldept;
    TextField tname,temail,tstate,tmobile,tseatno,tpincode,tcollege;
    Checkbox m,f;
    CheckboxGroup cg;
    Checkbox yes,no;
    CheckboxGroup ph;
    Choice dept;
    Button b1;
    String sname=new String("");
    String sgender =new String("");
    String semail=new String("");
    String sstate=new String("");
    String smobile=new String("");
    String sseatno=new String(""); 
    String spincode=new String("");
    String shandicap=new String("");
    String scollege=new String("");
    String sdept=new String("");
    
    String sdbname=new String("");
    String scid= new String("");
    String steacher= new String("");
    String spassword = new String("");

    
     @Override
    public void init() 
    {
        // TODO start asynchronous download of heavy resources
        this.setBackground(Color.cyan);
        this.setSize(800,800);
        lname = new Label("Name:");
        lgender = new Label("Gender:");
        lemail = new Label("Email id:");
        lstate = new Label("State");
        lmobile = new Label("Mobile Number");
        lseatno = new Label("Seat No.");
        lpincode = new Label("Pin Code");
        lhandicap = new Label("Physically Handicap");
        lcollege = new Label("College");
        ldept = new Label("Dept");
        tname=new TextField();
        temail=new TextField();
        tstate=new TextField();
        tmobile=new TextField(); 
        tseatno=new TextField(); 
        tpincode=new TextField();
        ph= new CheckboxGroup();
        yes=new Checkbox("Yes",ph,false);
        no=new Checkbox("No",ph,false);
        tcollege= new TextField();
        cg=new CheckboxGroup();
        m=new Checkbox("M",cg,false);
        f=new Checkbox("F",cg,false);
        dept=new Choice();
        dept.addItem("COMS");
        dept.addItem("IT");
        dept.addItem("EXTC");
        dept.addItem("INSTRU");
        dept.addItem("MECHANICAL");
        dept.addItem("CIVIL");
        
        b1=new Button("OK");
        lname.setBounds(10, 10, 50, 25);
        tname.setBounds(80,10,200,25);
        lgender.setBounds(10,50,60,25);
        m.setBounds(90,50,50,25);
        f.setBounds(150,50,50,25);
        lemail.setBounds(10,90,50,25);
        temail.setBounds(80,90,200,25);
        lstate.setBounds(10,130,50,25);
        tstate.setBounds(80,130,200,25);
        lmobile.setBounds(10,170,100,25);
        tmobile.setBounds(130,170,200,25);
        lseatno.setBounds(10,220,50,25);
        tseatno.setBounds(80,220,200,25);
        lpincode.setBounds(10,260,60,25);
        tpincode.setBounds(80,260,200,25);
        lhandicap.setBounds(10,300,150,25);
        yes.setBounds(180,300,50,25);
        no.setBounds(250,300,50,25);       
        lcollege.setBounds(10,340,50,25);
        tcollege.setBounds(80,340,200,25);
        ldept.setBounds(10,380,50,25);
        dept.setBounds(80,380,200,25);
        b1.setBounds(80,450,50,25);
        
        
       
        add(lname);
        add(tname);
        add(lgender);
        add(m);
        add(f);
        add(lemail);
        add(temail);
         add(lstate);
        add(tstate); 
        add(lmobile);
        add(tmobile);
        add(lpincode);
        add(tpincode);
        add(lhandicap); 
        add(yes);
        add(no); 
        add(lseatno);
        add(tseatno);
        add(lcollege);
        add(tcollege);
        add(ldept);
        add(dept);
        add(b1);
        
        
        b1.addActionListener(this);
        
        
        lgender.setVisible(false);
        m.setVisible(false);
        f.setVisible(false);
        lemail.setVisible(false);
        temail.setVisible(false);
        tstate.setVisible(false);
        lstate.setVisible(false);
        lmobile.setVisible(false);  
        tmobile.setVisible(false);
        lseatno.setVisible(false);
        lpincode.setVisible(false);
        tpincode.setVisible(false);
        tseatno.setVisible(false);
        lhandicap.setVisible(false);
        yes.setVisible(false); 
        no.setVisible(false);
        lcollege.setVisible(false);
        tcollege.setVisible(false);
        ldept.setVisible(false);
        dept.setVisible(false);
        
    }


    

    // TODO overwrite start(), stop() and destroy() methods
     @Override
    public void actionPerformed(ActionEvent ae)
    {
        lgender.setVisible(true);
        m.setVisible(true);
        f.setVisible(true);
        lemail.setVisible(true);
        temail.setVisible(true);
         tstate.setVisible(true);
        lstate.setVisible(true);
        lmobile.setVisible(true);  
        tmobile.setVisible(true);
        lseatno.setVisible(true);
        lpincode.setVisible(true);
        tpincode.setVisible(true);
        tseatno.setVisible(true);
        lhandicap.setVisible(true);
        yes.setVisible(true); 
        no.setVisible(true);
        lcollege.setVisible(true);
        tcollege.setVisible(true);
        ldept.setVisible(true);
        dept.setVisible(true);
             sname=tname.getText();
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/divya;create=true;user=divya;password=happy");    
            Statement st=con.createStatement();
            String query="select * from EXAMDATA";
            ResultSet rs= st.executeQuery(query);
            while(rs.next())
            {
                sdbname=(rs.getString("NAME"));
                if(sname.equalsIgnoreCase(sdbname))
                {
                    if(("m".equals(rs.getString("GENDER")))||"M".equals(rs.getString("GENDER")))
                        cg.setSelectedCheckbox(m);
                    else
                        cg.setSelectedCheckbox(f);
                    
                    temail.setText(rs.getString("email_id"));
                     tstate.setText(rs.getString("State"));
                     tmobile.setText(rs.getString("Mobile_Number"));
                     tpincode.setText(rs.getString("Pin_Code"));
                     tseatno.setText(rs.getString("Seat_No"));
                     
                    if(("yes".equals(rs.getString("Physically_Handicap")))||"Yes".equals(rs.getString("Physically_Handicap")))
                        ph.setSelectedCheckbox(yes);
                    else
                        ph.setSelectedCheckbox(no);
                    tcollege.setText(rs.getString("college"));
                    
                    dept.select(rs.getString("dept"));
                    
            
                }
                
    
            }
    }
        catch (SQLException ex) 
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) 
        {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}