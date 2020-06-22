/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Divya Khiani
 */
public class NewApplet extends Applet implements ActionListener
{

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
     private final Button bTeacher = new Button("Teacher");
    private final Button bStudent = new Button("Student");
    
    
     @Override
    public void init()
    {
        
        // TODO start asynchronous download of heavy resources
        this.setLayout(null);
        this.resize(800,800);
        bTeacher.setBounds(250,250,100,100);
        bStudent.setBounds(350,250,100,100);
        add(bTeacher);
        add(bStudent);
        bTeacher.addActionListener( this);
        bStudent.addActionListener(this);
        
    }

    // TODO overwrite start(), stop() and destroy() methods
     @Override
     public void actionPerformed(ActionEvent ae) 
     {

        bTeacher.setVisible(false);
        bStudent.setVisible(false);
        if(ae.getSource()==bTeacher)
        {
            teacherForm();
            
        }
        else if (ae.getSource()==bStudent)
        {
            studentForm();
            
        }
        
    }
     void studentForm()
    {
        Student s1= new Student();
        s1.setBounds(0,0,800,800);
        s1.init();
        add(s1);
    }
     void teacherForm()
     {
         
         Teacher t1 = new Teacher();
         t1.setBounds(0,0,800,800);
         t1.init();
         add(t1);
     }
}

