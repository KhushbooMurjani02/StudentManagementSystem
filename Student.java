/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Divya Khiani
 */
public class Student extends Applet implements ActionListener 
{

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    
    Label lname, lgender, lemail,lstate,lmobile,lsuccess,lfailure,lseatno,lpincode,lhandicap,lcollege,ldept;
    TextField tname,temail,tcollege,tstate,tmobile,tseatno,tpincode;
    Choice dept;
    Checkbox m,f;
    CheckboxGroup cg,ph;
    Checkbox yes,no;
    Button b1;
    public void init() 
    {
        // TODO start asynchronous download of heavy resources
         this.setBackground(Color.cyan);
        this.setSize(800,800);
        lname = new Label("NAME:");
        lgender = new Label("GENDER");
        lemail = new Label("Email id:");
        lstate = new Label("State");
        lmobile = new Label("Mobile Number");
        lseatno = new Label("Seat No.");
        lpincode = new Label("Pin Code");
        lhandicap = new Label("Physically Handicap");
        lcollege = new Label("College");
        ldept = new Label("Dept");
        lsuccess=new Label("Record entered successfully");
        lfailure=new Label("Record is not entered");
        tname=new TextField();
        cg= new CheckboxGroup();
        m=new Checkbox("M",cg,false);
        f=new Checkbox("F",cg,false);
        temail=new TextField();
        tstate=new TextField();
        tmobile=new TextField(); 
        tseatno=new TextField(); 
        tpincode=new TextField();
        ph= new CheckboxGroup();
        yes=new Checkbox("Yes",ph,false);
        no=new Checkbox("No",ph,false);
        tcollege= new TextField();
        dept=new Choice();
        dept.addItem("COMS");
        dept.addItem("IT");
        dept.addItem("EXTC");
        dept.addItem("INSTRU");
        dept.addItem("MECHANICAL");
        dept.addItem("CIVIL");
        b1=new Button("SUBMIT"); 
       
        
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
        lsuccess.setBounds(80,490,200,50);
        lfailure.setBounds(80,490,200,50);
        
        
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
        add(lsuccess);
        add(lfailure);
        lsuccess.setVisible(false);
        lfailure.setVisible(false);
        
        b1.addActionListener(this);
  
        
    }

    // TODO overwrite start(), stop() and destroy() methods
    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==b1)
        {
            try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/divya;create=true;user=divya;password=happy");    
            String query ="insert into EXAMDATA values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st =con.prepareStatement(query);
            st.setString(1, tname.getText());
            st.setString(2, cg.getSelectedCheckbox().getLabel());
            st.setString(3, temail.getText());
            st.setString(4, tstate.getText());
            st.setString(5, tmobile.getText());
            st.setString(6, tseatno.getText());
            st.setString(7, tpincode.getText());
            st.setString(8, ph.getSelectedCheckbox().getLabel());
            st.setString(9, tcollege.getText());
            st.setString(10, dept.getSelectedItem());
            st.execute();
            con.close();
            lsuccess.setVisible(true);
            
        }
       catch (SQLException e)
        {
            System.out.println(e);
            lfailure.setVisible(true);
            lsuccess.setVisible(false);
        }
            catch (ClassNotFoundException ex)
            {
            System.out.println(ex);
             lfailure.setVisible(true);
              lsuccess.setVisible(false);
        }   
            catch (InstantiationException ex)
            {   
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                 lfailure.setVisible(true);
                  lsuccess.setVisible(false);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                 lfailure.setVisible(true);
                  lsuccess.setVisible(false);
            }   
        }
       
        
        
        
        
    }
}


