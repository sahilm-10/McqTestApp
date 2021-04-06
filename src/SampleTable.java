import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
public class SampleTable extends JFrame implements ActionListener {
	 JPanel f,jp; 
	 JTable jt;
	 JScrollPane sp;
	 JButton jbtn;

			
	 Container container;
		CardLayout cardl;
		
	    SampleTable(){   

	    f=new JPanel();    
//	    String data[][]={ {"101","Amit","670000"},    
//	                          {"102","Jai","780000"},    
//	                          {"101","Sachin","700000"}};    
//	    String column[]={"ID","NAME","SALARY"};         
//	    JTable jt=new JTable(data,column);
//	    jp = new JPanel();
	    jbtn = new JButton("Home");
	    jbtn.setBounds(7,10,10,1); 
//	    jp.add(jbtn);
//	    jp.setLayout(null);
//	    jp.setVisible(true);
	    jbtn.addActionListener(this);
	    
	    JPanel log = new JPanel();
        log.add(jbtn);
        log.setLayout(new GridLayout(0,2));
       
	    
	    jt=new JTable();    
    	jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt);    
	    
	    JPanel dummy = new JPanel();
	    dummy.add(log);
	    

	    f.add(sp);          
	    f.setSize(300,400);
	    f.add(dummy,BorderLayout.SOUTH);
	    f.setVisible(true);
	    
	    cardl = new CardLayout();
	    f.setLayout(new GridLayout(2,7));
	    container = getContentPane();
//	    container.add(jp);
    	container.add(f);
//    	container.add(jbtn);
    	validate();

	    }
    	 public  void readAll() {
    		 Connection con = null;
    		 try {
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:Scores.db");
	    		System.out.println("connected");
			} catch (ClassNotFoundException|SQLException  e1) {
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
    		 	
     			PreparedStatement ps = null;
    			ResultSet rs = null;
    	    	
		try {
    				String sql = "SELECT * FROM details ORDER BY totalscore DESC";
    				ps =con.prepareStatement(sql);
    				rs = ps.executeQuery();
    				
    				System.out.println("ALL Details\n");
    				DefaultTableModel dtm =(DefaultTableModel)jt.getModel();
    				String column[]= {"Name","Correct","Wrong","Unattempted","Total Marks"};
    				dtm.setColumnIdentifiers(column);
					
					
    				while(rs.next()) {
    					
    					String name = rs.getString("name");
    					int correct = rs.getInt(2);
    					int wrong = rs.getInt(3);
    					int unattempted = rs.getInt(4);
    					double total_score = rs.getDouble("totalscore");
    					 
    					String data[]= {name,correct +"",wrong +"",unattempted +"", total_score +""};
    					System.out.println(data);
    					dtm.addRow(data);
    					
    					System.out.println("First Name:" +name);
    					System.out.println("Correct:" +correct);
    					System.out.println("wrong" +wrong);
    					System.out.println("Unattempted:" +unattempted);
    					System.out.println("Total Marks:" +total_score+"\n\n");
    					
    					
    				}
    			}catch(SQLException e) {
    				System.out.println(e.toString());
    					
    			}finally {
    				try {
    					rs.close();
    					ps.close();
    					con.close();
    				}catch(SQLException e) {
    					System.out.println(e.toString());
    				}
    				
    			}
				
    		   }
    		   
    	  
	    public static void main(String[] args) {
			SampleTable obj =new SampleTable();
			obj.setVisible(true);
			obj.setSize(500,500);
			obj.readAll();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbtn) {
				System.out.println("clicked");
				this.setVisible(false);
	        	this.dispose();
				OnlineMcq obj = new OnlineMcq();
		        obj.setVisible(true); 
		        
			}
		}
}

