
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;

//this is a template for all the visualization GUI's
//change the class name with the algorithm

class selection extends JFrame implements ActionListener 
{     
    int n=15;           //no of array elements is i inside whole class  
    //declaration/definition of frame components
        
        //these are the JTextfield Components used for this project 
        JTextField sortname         =new JTextField("Selection Sort");           //top most name of sort jtf=JTextField
        JTextField arycount         =new JTextField("15");                   //jtf to get no of array elements
        JTextField aryelements[]    =new JTextField[15];                    //jtf(Array) to get array elements from user is editable 
        JTextField arymodify[]      =new JTextField[15];                    //jtf(Array) to sort the final array
        ///note if the program is more than 13 lines change bounds too before changing thus
        JTextField program[]        =new JTextField[13] ;                   //jtf for  program for highlight
        JTextField temp[]           =new JTextField[3];                     //  jtf for temporary variables
        JTextField statustag        =new JTextField("STATUS");              //  jtf for status tag above the current status --uneditable
        JTextField status           =new JTextField("waiting") ;             //jtf for displaying current status of the sort

        //these are the JLabel Components  used for this project 
        JLabel countlabel           =new JLabel("Enter No.of Array Elements:");     //for displaying before jtf
        JLabel enterlabel           =new JLabel("Enter Array elements below:");      //for displaying before jtf to enter array elments
        JLabel speedlabel           =new JLabel("Speed:");                          //To highlight slider of adjust speed of execution label
        JLabel index[]              =new JLabel[15];                                //for array index metioning while sorting
        JLabel templabel[]              =new JLabel[3];                                //for temporary variable metioning while sorting

        //these are the JButton Components for this project
        JButton validate            =new JButton("VALIDATE") ;                 //jbutton for validating the no of elements and modify the jframe on press
        JButton run                 =new JButton("RUN");                       //jbutton for executing the sort on the enterred elements

        //these are the JPanel Containers for this project    
        JPanel  head                =new JPanel();                              //panel for head 
        JPanel  operation           =new JPanel();                              //panel for operation 
        JPanel  getary              =new JPanel();                              //panel for array of jtfs in head panel
        JPanel  sortary             =new JPanel();                              //panel for array of jtfs in operation panel
        JPanel  programpanel        =new JPanel();                              //panel for program jtfs
        JPanel  indexpanel          =new JPanel();                              //panel for program index

        //these are jslider components for this  project
        JSlider speed               =new JSlider(100,1000,500);                 //to adjust speed in range 100 to 1000 with default value 500

        String prog[]={"  void SelectionSort(int A[],n)","   {","   for(int i=0;i<n-1;i++)"," {\tint min=A[i],flag=-1;","\tfor(int j=i+1;j<n;j++)","\t{\t  if(A[j]<min)","\t\t{   flag=j;min=A[j]; \t}","\t}","\tif(flag!=-1)","\t{\tint temp=A[j];","\t\tA[i]=A[flag];","\t\tA[flag]=temp;"," }\t }\t}"};
        public selection()
        {
                                                               //to set layout default null and set bounds individually
            setResizable(false);                                               //to fix the size of the frame/window default and prevent user from resizing
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                     //to close on exit
            setSize(830,1000);                                                  //to set the size of window 

            //adding layout to all 
            setLayout(null); 
            head.setLayout(null);
            operation.setLayout(null);
            getary.setLayout(new GridLayout(1,15));
            sortary.setLayout(new GridLayout(1,15));
            programpanel.setLayout(new GridLayout(13,1));
            indexpanel.setLayout(new GridLayout(1,15));



            //adding  head & operation panel          template  :     add();
            add(head);  add(operation);

            //adding compontents to all panel        template  :    head.add();         operation.add();
            head.add(sortname);head.add(countlabel);
            head.add(arycount);head.add(validate);
            head.add(enterlabel);            
            head.add(run);

            head.add(getary);
            for(int x=0;x<15;x++)       //loop for adding maximum no of array elements in inital case
            {
                aryelements[x]=new JTextField("");
                arymodify[x]=new JTextField("");
                index[x]=new JLabel(x+"");

                getary.add(aryelements[x]);
                sortary.add(arymodify[x]);
                
                indexpanel.add(index[x]);
                //setting uneditable fields
                
                arymodify[x].setEditable(false);
                //setting alignment
                index[x].setHorizontalAlignment(JTextField.CENTER);

                
                if(x<prog.length)
                {     program[x]=new JTextField(x+":"+prog[x]);
                      program[x].setEditable(false);
                      programpanel.add(program[x]);
                }
            }
            
           // adding temporary variables required for sorting
            operation.add(sortary);
            operation.add(programpanel);
            operation.add(indexpanel);


            temp[0]=new JTextField("");
            operation.add(temp[0]);
            templabel[0]=new JLabel("Min");
            operation.add(templabel[0]);

            temp[1]=new JTextField("");
            operation.add(temp[1]);
            templabel[1]=new JLabel("Flag");
            operation.add(templabel[1]);
              
            operation.add(statustag);
            operation.add(status);
            operation.add(speedlabel);
            operation.add(speed); 

            //setting fields as uneditable
            sortname.setEditable(false);
            statustag.setEditable(false);
            status.setEditable(false);
            temp[0].setEditable(false);
            temp[1].setEditable(false);

            //setting horizontal alignment
            sortname.setHorizontalAlignment(JTextField.CENTER);
            statustag.setHorizontalAlignment(JTextField.CENTER);
            status.setHorizontalAlignment(JTextField.CENTER);

            //operation.add();
            //fixing bounds for components          template:     .setBounds(, , ,);
            //components in the same line will have same y coordinate
            head.setBounds(0,0,800,200);operation.setBounds(0,205,800,750);
            sortname.setBounds(0,0 ,800 ,50);
            countlabel.setBounds(20,60 ,380 ,40);         arycount.setBounds(410, 60,250 ,40);          validate.setBounds(665, 60,135,40);
            enterlabel.setBounds(20,110 ,380 ,40);       
            getary.setBounds(20,160 ,600 ,40);            run.setBounds(630,160 ,100 ,40);

            sortary.setBounds(25,0 ,750,50);             
            indexpanel.setBounds(25,60,750,30);          
                                                         
                                                         

            programpanel.setBounds(20,100 ,600 ,550);     templabel[0].setBounds(680,100,75 ,30); 
                                                          temp[0].setBounds(680,135,75 ,30);
                                                          templabel[1].setBounds(680,170,75 ,30);
                                                          temp[1].setBounds(680,205,75 ,30); 
                                                          statustag.setBounds(650 ,300,150,50);
                                                          status.setBounds(650,355 ,150 ,100);
            speedlabel.setBounds(20,655,50,50);           speed.setBounds(130,655,550,50);        

            //adding color
            statustag.setForeground(Color.RED);


            //adding actionlistener to the template   :      .addActionListener(this);  
            run.addActionListener(this);
            validate.addActionListener(this);
            //speed.addActionListener(this);

            setVisible(true);                                                   //to make the JFrame visible to view--must be at the end
        }
       
        public void actionPerformed(ActionEvent aa)
        {
            n=Integer.parseInt(arycount.getText());
           
               if(aa.getSource()==validate)
               {
                getary.removeAll();
                sortary.removeAll();
                indexpanel.removeAll();
                status.setText("Waiting");
                temp[0].setText("");
                temp[1].setText("");
                temp[1].setForeground(Color.BLACK);
                for(int j=0;j<n;j++)
                {
                    getary.add(aryelements[j]);
                    sortary.add(arymodify[j]);
                    indexpanel.add(index[j]);
                    arymodify[j].setHorizontalAlignment(JTextField.CENTER);
                    index[j].setHorizontalAlignment(JTextField.CENTER);
                    arymodify[j].setEditable(false);
                }
                revalidate();
                repaint();
            }
           
               Long ti=Long.valueOf(1000);  
                Long speed=Long.valueOf(100);  

                 
            if(aa.getSource()==run)
            {
                
                for(int j=0;j<n;j++)
                {   
                   arymodify[j].setText(aryelements[j].getText()); 
                 } 
                   
                for(int j=0;j<n;j++)
                {
                        int min=Integer.parseInt(arymodify[j].getText());
                        int flag=-1;
                        temp[0].setText(""+min);
                        temp[1].setText("-1");
                        temp[1].setForeground(Color.BLACK);
                                revalidate();
                                repaint();
                                for(int k=j+1;k<n;k++)
                                {   
                                    int t=Integer.parseInt(arymodify[k].getText());
                                    if(t<min)
                                    {
                                        min=t;flag=k;
                                        temp[0].setText(""+min);
                                        temp[1].setText(""+k);
                                        temp[1].setForeground(Color.RED);
                                        revalidate();
                                        repaint();
                                    }


                                }
                                if(flag!=-1)
                                {
                                   String temp=arymodify[flag].getText();
                                   arymodify[flag].setText(arymodify[j].getText());
                                   arymodify[j].setText(temp);

                                }
                                
                                revalidate();
                                repaint();
                }
                
                status.setText("Sorted!");
            }
        

        }

        public static void main(String []args)
        {
            //creating one object by invoking a constructor

            new selection(); 
        }


}