/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static managementsystem.DataBase.statement;

public class DataBase {

    static final String DATABASE_URL = "jdbc:mysql://localhost/stone";
    static final String DATABASE_USER = "root";
    static final String DATABASE_PASS = "";
    static Connection connection = null; // manages connection
    static Statement statement = null; // query statement
    static ResultSet resultSet = null;
    private Object rollField;
    private Object brk;
    Connection condb;

    public DataBase() throws SQLException {
        getConnection();
    }

    void getConnection() {

        try {

            connection = (Connection) DriverManager.getConnection(DATABASE_URL,
                    DATABASE_USER, DATABASE_PASS);
            statement = (Statement) connection.createStatement();
            System.out.println("Connect Hoise...");
            //JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");

        } catch (SQLException e) {
            System.err.println("Connection Error");
            JOptionPane.showMessageDialog(null, "Open XAMPP Then Try Again");
            loginForm ob = new loginForm();
            ob.setVisible(true);

        }
    }

    public void Login(String password, String userName) {

        try {
            String sql = "select * from login where username = '" + userName + "' and password = '" + password + "'";
            resultSet = statement.executeQuery(sql);
            //this.dispose();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Connected Succesfully Boss!!!!!!");
                allInfo ob = new allInfo();
                // this.dispose(); 
                ob.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Rong Username And Password....!!!\n\t Try Again Boss....");
                loginForm ob = new loginForm();
                ob.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Connected Not Succesfully Boss!!!!!!");
            System.out.println("ERROR " + ex);
        }

    }

    /*
    
     void createSoldTable(String serial, String name, String address, String mobile, String date, String first1, String second2, String theird3, String fourth4, String fifth5) {
     try {
     String sql = "INSERT INTO soldtable(serial_id, name, address,mobile,date,no,productname,quntity,perunit,amount) VALUES ('" + serial +"','" + name+ "', '" +address + "', '" +mobile + "', '" + date+ "', '" +first1+ "', '" + second2 + "', '" + theird3+ "', '" +  fourth4 + "','" + fifth5+ "');";
     System.out.println("Stuff tabel a dukseeeeee!!!!!!!!!!!!!!!");
     statement.executeUpdate(sql);
     } catch (Exception e) {
     JOptionPane.showMessageDialog(null, "Srorry Sql Error....!");
     }
    
    
     }

    
     */
    void newTable(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String sT) {

        try {

            ///////////////INSERTING*********************?????
            //  String sql = "update stuff set firstName = '" + firstName + "', lastName = '" + lastName + "', designetion = '" + dgn + "',dateOfBirth = '" + birth+ "', sex = '" + sex + "', salary = '" + salary+ "', mobile = '" + mobile+ "', presentAddress = '" + presentAddress + "', permanentAddress = '" + permanetAddress + "', joinDate= '" + joinDate + "',email = '" + email + "' where stuffId= '" + stuffId + "'";
            //statement.execute(sql);
            String sql = "INSERT INTO soldproduct (no,productname,quntity,perunit,amount,ab) VALUES ('" + s + "','" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "');";

            statement.executeUpdate(sql);

            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

        } catch (SQLException ex) {
            System.out.println("Boss Someting Rong Hoga");
        }

    }

    void sold(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String sT) {

        try {
            /*
             String s5 = serialField.getText();
             String s6=nameField.getText();
             String s7=addressField.getText();
             String s8=mobileField.getText();
             String s9=dateField.getDateFormatString();
             String sT=totalField.getText();
                    
         
             */

            ///////////////INSERTING*********************?????
            //  String sql = "update stuff set firstName = '" + firstName + "', lastName = '" + lastName + "', designetion = '" + dgn + "',dateOfBirth = '" + birth+ "', sex = '" + sex + "', salary = '" + salary+ "', mobile = '" + mobile+ "', presentAddress = '" + presentAddress + "', permanentAddress = '" + permanetAddress + "', joinDate= '" + joinDate + "',email = '" + email + "' where stuffId= '" + stuffId + "'";
            //statement.execute(sql);
            String sql = "INSERT INTO sold (no,productname,quntity,perunit,amount,serial_id,name,address,mobile,date,total) VALUES ('" + s + "','" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "','" + s6 + "', '" + s7 + "', '" + s8 + "', '" + s9 + "', '" + sT + "');";

            statement.executeUpdate(sql);

            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

        } catch (SQLException ex) {
            System.out.println("Boss Someting Rong Hoga");
        }

    }

    void costProduct(String s, String s1, String s2, String s3, String s4, String s5) {

        try {

            //cost_product
            String sql = "INSERT INTO t (no,productname,quntity,perunit,amount,date) VALUES ('" + s + "','" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "');";

            statement.executeUpdate(sql);

            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

        } catch (SQLException ex) {
            System.out.println("Boss Someting Rong Hoga");
        }

    }

    void checkOutProduct(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String sT, String sD, String sZ) {

        try {
            String sql = "INSERT INTO soldout (no,productname,quntity,perunit,amount,serial_id,name,address,mobile,date,total,driver,zip_id) VALUES ('" + s + "','" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "','" + s6 + "', '" + s7 + "', '" + s8 + "', '" + s9 + "', '" + sT + "', '" + sD + "', '" + sZ + "');";

            statement.executeUpdate(sql);

            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void insertImployee(String id, String name, String father, String dg, String sex, String salary, String mobile, String address, String birthDate, String joinDate) {
        /*
        try {
        String sql = "INSERT INTO empl (employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate) VALUES " + "('" + id+"','" + name + "', '" +father + "', '" +dg + "', '"  +sex+ "', '" +   salary +"', '" +mobile+ "', '" +address + "', '" +birthDate + "', '" +   joinDate+ "');";
        statement.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Data Saved...");
        System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
        } catch (SQLException ex) {
        System.out.println("Boss Someting Rong..");
        }
         */ 

        double totalQ = 0;
        double totalR = 0;
        try {
              String sqla = "select * from employeetable where name  = '" +name + "' or employee_id = '" + id + "'";
            
            // username = '" + userName + "' and password = '" + password + "'";
          //  String sqla = "select * from employeetable where name = '" + name + "'";
            resultSet = statement.executeQuery(sqla);
            
            if (resultSet.next()) {
                
                JOptionPane.showMessageDialog(null, "Onno Nam ANd ID  Daw.....!");
                String r = "0";
                String s = "";
                
                /*
                try {
                    //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                    String sql3 = "update employee set name = '" + name + "', date = '" + joinDate + "', salary = '" + r + "',advance = '" + r + "', main_salary = '" + salary + "', podobi = '" + dg + "', remark = '" + s + "' where name= '" + name + "'";
                    
                    statement.executeUpdate(sql3);
                    System.out.println("Execue hoise");
                    JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");
                    
                } catch (SQLException ex) {
                    //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Something rong");
                    JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                }
                */
                
            } else {
                
                try {
                    
             //       JOptionPane.showMessageDialog(null, "Not Same");
                    String sql = "INSERT INTO employeetable (employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate) VALUES ('" + id + "','" + name + "', '" + father + "', '" + dg + "', '" + sex + "', '" + salary + "','" + mobile + "', '" + address + "', '" + birthDate + "', '" + joinDate + "');";
                    
                    statement.executeUpdate(sql);
                    
                    //cost_product
                    String r = "0";
                    String s = " Join Job ";
                    String sql2 = "INSERT INTO employee (name,date,salary,advance,main_salary,podobi,remark) VALUES ('" + name + "','" + joinDate + "', '" + r + "', '" + r + "', '" + salary + "', '" + dg + "', '" + s + "');";
                    
                    statement.executeUpdate(sql2);
                    
                    System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                    
                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hoga");
                }
             
        JOptionPane.showMessageDialog(null, "Data Saved.....!");   

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }
    }

    void searchStaff(String ID) {

        try {

            //String sql = "select * from empl where employee_id = '" + ID + "'";
            //stuffId, firstName, lastName,designetion,dateOfBirth,sex,salary,mobile,presentAddress,permanentAddress,joinDate,email
            String sql = "select * from employeetable where name = '" + ID + "'";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String a = resultSet.getString("id");
                String Nm = resultSet.getString("name");
                String fm = resultSet.getString("fathername");
                String dgn = resultSet.getString("designation");

                String sex = resultSet.getString("sex");
                String salary = resultSet.getString("salary");
                String mobile = resultSet.getString("mobile");

                String address = resultSet.getString("address");
                String birthDate = resultSet.getString("birthdate");
                String joinDate = resultSet.getString("joinDate");
                String x=resultSet.getString("employee_id");
                newEmployee st = new newEmployee();
                st.setVisible(true);
                   //  st.sexField.getEditor().setItem(sex);
       
                // String nM, String fN, String deg, String sex, String salary, String mobile, String address, String birthDate, String joinDate
                st.setEmployee(a, x, Nm, fm, dgn, sex, salary, mobile, address, birthDate, joinDate);
                /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                //        //st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm,motherNm,sex,classNm,year,section,birth,presentAddress,permanentAddress,addmitionDate,mobile,email);

            } else {
                JOptionPane.showMessageDialog(null, " Not Found This Items\n \tTry Another");
                System.out.println("No Data Found");
                //  teacherUpdatePage ob=new teacherUpdatePage();
                //   ob.setVisible(true);
                newEmployee st = new newEmployee();
                st.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);

        }
    }

    void updateImployee(String id, String name, String father, String dg, String sex, String salary, String mobile, String address, String birthDate, String joinDate) {
String x="0";
        try {
            //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
            String sql = "update employeetable set employee_id = '" + id + "',name = '" + name + "', fathername = '" + father + "',designation = '" + dg + "', sex = '" + sex + "', salary = '" + salary + "', mobile = '" + mobile + "', address = '" + address + "', birthdate = '" + birthDate + "', joinDate= '" + joinDate + "' where employee_id= '" + id + "'";
            //statement.execute(sql);
            //statement.executeQuery(sql);
            statement.executeUpdate(sql);
              String sqly = "update employee set name = '" + name + "',date = '" + name + "', salary = '" + x + "',advance= '" + x + "', main_salary = '" + salary + "', podobi = '" + dg+ "', remark = '" + x + "' where name= '" + name + "'";
            //statement.execute(sql);
            //statement.executeQuery(sql);
            statement.executeUpdate(sqly);
          
            System.out.println("Execue hoisexxxx");
            JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");
        } catch (SQLException ex) {
            //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something rong");
            JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
        }

    }

    void DeleteStuff(String id, String name) {

        try {

            //  String sql = "delete from empl where id = '" + id + "'";
            //  String sql = "delete from student where roll = '" + SearchRoll + "'";
            String sql = "delete from employeetable where id = '" + id + "'";
            System.out.println("Dukse ");
            statement.executeUpdate(sql);
            System.out.println("Exceute Hoise");
          //  String sqla = "delete from employee where name = '" + name + "'";
            System.out.println("Dukse ");
            //statement.executeUpdate(sqla);
            System.out.println("Exceute Hoise");
            JOptionPane.showMessageDialog(null, "Data deleted Succesfully!");
            newEmployee ob = new newEmployee();
            ob.setVisible(true);
        } catch (SQLException ex) {

            System.out.println("something rong");
            //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void patnerDetails(String s, String s1, String s2, String s3, String s4, String s5) {

        try {

            //cost_product
            String sql = "INSERT INTO partner (no,name,given,taken,date,remaintk) VALUES ('" + s + "','" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "');";

            statement.executeUpdate(sql);

            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

        } catch (SQLException ex) {
            System.out.println("Boss Someting Rong Hoga");
        }

    }

    /*
     try {
             
             
     //String sql = "select * from empl where employee_id = '" + ID + "'";
          
     //stuffId, firstName, lastName,designetion,dateOfBirth,sex,salary,mobile,presentAddress,permanentAddress,joinDate,email
     String sql = "select * from partner where name = '" + name + "'";
     resultSet = statement.executeQuery(sql);
     if (resultSet.next()) {
     String id=resultSet.getString("id");
     String a=resultSet.getString("no");
     String Nm = resultSet.getString("name");
     String gv = resultSet.getString("given");
     String tn = resultSet.getString("taken");
                
     String date = resultSet.getString("date");
                
           
     patnerPage st = new patnerPage();
     st.setVisible(true);
     // String nM, String fN, String deg, String sex, String salary, String mobile, String address, String birthDate, String joinDate
     st.setPartner(id,a, Nm, gv, tn, date);
     /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
     //        //st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm,motherNm,sex,classNm,year,section,birth,presentAddress,permanentAddress,addmitionDate,mobile,email);

     }
     else{
     JOptionPane.showMessageDialog(null, " Not Found This Items\n \tTry Another");
     System.out.println("No Data Found");
     //  teacherUpdatePage ob=new teacherUpdatePage();
     //   ob.setVisible(true);
     newEmployee st = new newEmployee();
     st.setVisible(true);
     }
            
     } catch (SQLException ex) {
     System.out.println("ERROR: " + ex);
            
     }
    
     }

     */

    void stockDetails(String name, String quntity, String perUnit, String date) {
        double totalQ = 0;
        double totalR = 0;
        try {
            String sql = "select * from stock where name = '" + name + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                JOptionPane.showMessageDialog(null, "SAme");

                System.out.println("x");

                String a = resultSet.getString("quntity");
                String b = resultSet.getString("remain");
                double tempQ = Double.parseDouble(a);
                double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(quntity);

                totalQ = tempQ + tempQ2;
                totalR = tempQ2 + tempD;
                String newQuntity = String.valueOf(totalQ);
                String newRemain = String.valueOf(totalR);
                System.out.println("SQL ER AGE");

                try {
                    //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                    String sql3 = "update stock set name = '" + name + "', quntity = '" + newQuntity + "', perunit = '" + perUnit + "',date = '" + date + "', remain = '" + newRemain + "' where name= '" + name + "'";

                    statement.executeUpdate(sql3);
                    System.out.println("Execue hoise");
                    JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

                } catch (SQLException ex) {
                    //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Something rong");
                    JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                }

            } else {

                try {

                    JOptionPane.showMessageDialog(null, "Not Same");

                    //cost_product
                    String r = quntity;
                    String sql2 = "INSERT INTO stock (name,quntity,perunit,date,remain) VALUES ('" + name + "','" + quntity + "', '" + perUnit + "', '" + date + "', '" + r + "');";

                    statement.executeUpdate(sql2);

                    System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hoga");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        JOptionPane.showMessageDialog(null, "Bare Not Same");

    }


    void ProductStock(String name, String amount, String date) {
        /**
         * **************************************************************************
         *///
        double totalQ = 0;
        double totalR = 0;
        String x="0";
        try {
            String sql = "select * from product_stock where p_name = '" + name + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                //   JOptionPane.showMessageDialog(null, "SAme");
                //
                System.out.println("SQL ER AGE");

                String sql2 = "INSERT INTO product_stock (p_name,poriman,date,sell) VALUES ('" + name + "','" + amount + "', '" + date +"', '" + x+ "');";

                statement.executeUpdate(sql2);

                System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

            } else {

                try {
                    String newQuntity = "0";

                    // JOptionPane.showMessageDialog(null, "Not Same");
                    String sql2 = "INSERT INTO product_stock(p_name,poriman,date,sell) VALUES ('" + name + "','" + amount + "', '" + date +  "', '" +x+ "');";

                    statement.executeUpdate(sql2);

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hogaxxx");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        //JOptionPane.showMessageDialog(null, "Bare Not Same");
        /**
         * *************?? Total Table??************************
         */
        try {
            String sqlx = "select * from total where p_name = '" + name + "'";
            resultSet = statement.executeQuery(sqlx);

            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");
                 String b = resultSet.getString("sell");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(amount);
                double tempQB = Double.parseDouble(b);
                    totalQ = tempQ + tempQ2;
              
            //    totalQ = tempQ + tempQ2-tempQB;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("SQL ER AGE");

                try {
                    //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                    String sqly = "update total set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date +  "',sell = '" + x + "' where p_name= '" + name + "'";

                    statement.executeUpdate(sqly);
                    System.out.println("Execue hoise");
                    //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

                } catch (SQLException ex) {
                    //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Something rong");
                    JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                }

            } else {

                try {

                    //JOptionPane.showMessageDialog(null, "Not Same");
                    String sqlz = "INSERT INTO total (p_name,poriman,date,sell) VALUES ('" + name + "','" + amount + "', '" + date +"', '" + x + "');";

                    statement.executeUpdate(sqlz);

                    System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                    // JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hoga");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");

    }

    void showAllProduct(String all) {

        String test = "0";
        if (all == test) {
            JOptionPane.showMessageDialog(null, "Sorry");
        } else {

            double totalG = 0;
            double totalT = 0;
            int no = 1;
            AMalBickriStock on = new AMalBickriStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
                String sql = "select * from total ";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {

                    String nam = resultSet.getString("p_name");

                    String am = resultSet.getString("poriman");
                    String date = resultSet.getString("date");

                    String SELL = resultSet.getString("sell");

                    double tempS = Double.parseDouble(SELL);
                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);

                    totalT = totalT + tempQ-tempS;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);

                    AMalBickriStock st = new AMalBickriStock();

                    Object rowData[] = {no, nam, am, date};
                    m.addRow(rowData);
                    no++;
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalField.setText(newQuntity);
                    on.xx.setText("All");
                }

            } catch (SQLException ex) {
                System.out.println("ERROR:  AtotalProductStock " + ex);
            }

        }

    }

    void showSelectProduct(String name) {

        String test = "0";
        if (name == test) {
            JOptionPane.showMessageDialog(null, "Sorry");
        } else {

            double totalG = 0;
            double totalT = 0;
            int no = 1;
            AMalBickriStock on = new AMalBickriStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
                String sql = "select * from product_stock where p_name = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String nam = resultSet.getString("p_name");

                    String am = resultSet.getString("poriman");
                    
                    double Tam = Double.parseDouble(am);
                    
                    
                    String date = resultSet.getString("date");

                    String SELL = resultSet.getString("sell");
                    
                    double tempQ = Double.parseDouble(am);
                    double tempS = Double.parseDouble(SELL);
                  //    double tempAM = Tam-tempS;
                    // double tempQ2 = Double.parseDouble(amount);
                    
                    totalT = totalT + tempQ-tempS;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                if(SELL.equals("0")){
                
                    AMalBickriStock st = new AMalBickriStock();

                    Object rowData[] = {no, nam, am, date, id};
                    m.addRow(rowData);
                    no++;
                }else{
                
                      String amT=String.valueOf(tempS+("( S )"));
                    AMalBickriStock st = new AMalBickriStock();

                    Object rowData[] = {no, nam, amT, date, id};
                    m.addRow(rowData);
                    no++;
                    
                    st.xx.setText("XX");
                
                }
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalField.setText(newQuntity);
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        }

    }

    void updateData(String id, String name, String amount, String date) {

        try {
            double totalQ = 0;

            String sql = "delete from product_stock where id = '" + id + "'";
            // String sql = "DELETE * FROM student " +
            //     //        "WHERE roll = "+SearchRoll+",";
            statement.executeUpdate(sql);

            String sqlx = "select * from total where p_name = '" + name + "'";
            resultSet = statement.executeQuery(sqlx);

            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");

                //    String b = resultSet.getString("remain");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(amount);

                totalQ = tempQ - tempQ2;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("SQL ER AGE");

                //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                String sqly = "update total set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date + "' where p_name= '" + name + "'";

                statement.executeUpdate(sqly);
                System.out.println("Execue hoise");
                //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");
                //*   >>>>****/

            }

            JOptionPane.showMessageDialog(null, "Data deleted Succesfully!");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void updateMainDate(String id, String name, String amount, String date) {

        try {
            double totalT = 0;
            
            double totalR = 0;

            String sqlx = "select * from product_stock where id = '" + id + "'";
            resultSet = statement.executeQuery(sqlx);

            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");
                double tempQ = Double.parseDouble(a);
                double am = Double.parseDouble(amount);
                if (tempQ > am) {
                    totalT = tempQ - am;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    DataBase ob = new DataBase();
                    ob.add(name, newQuntity, date,id,amount);

                } else if (tempQ < am) {
                    totalT = am - tempQ;
                    
                    totalR=totalR+totalT;
                    String newQuntity = String.valueOf(totalR);

                    DataBase ob = new DataBase();
                    ob.sub(name, newQuntity, date,id);
                } else {
              //   String sqlc= "update total set p_name = '" + name + "', poriman = '" + newAm + "',date = '" + date + "' where p_name= '" + name + "'";

                    // statement.executeUpdate(sqlc);
                    //   System.out.println("Execue hoise");
                    JOptionPane.showMessageDialog(null, "SORRRY....");

                }

                String sqly = "update product_stock set p_name = '" + name + "', poriman = '" + amount + "',date = '" + date + "' where id= '" + id + "'";

                statement.executeUpdate(sqly);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void add(String name, String newQuntity, String date,String amount,String id) {
        double totalQ = 0;
        try {
            
                String sqly = "update product_stock set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date + "' where id= '" + id + "'";

                statement.executeUpdate(sqly);
                System.out.println("UPPPPPP");

            String sqlx = "select * from total where p_name = '" + name + "'";
            resultSet = statement.executeQuery(sqlx);
            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");
                //    String b = resultSet.getString("remain");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(newQuntity);

                totalQ = tempQ - tempQ2;
                // totalR=tempQ2+tempD;
                String newAm = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("SQL ER AGE");

                //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                String sqlC = "update total set p_name = '" + name + "', poriman = '" + newAm + "',date = '" + date + "' where p_name= '" + name + "'";

                statement.executeUpdate(sqlC);
                System.out.println("Execue hoise");
                //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

            }else{
            JOptionPane.showMessageDialog(null, "SORRYYYYY");
            
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void sub(String name, String newQuntity, String date,String id) {
        double totalQ = 0;
        try {
            
            
                String sqlD = "update product_stock set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date + "' where id= '" + id + "'";

                statement.executeUpdate(sqlD);
                System.out.println("UPPPPPP");
                
            String sqlx = "select * from total where p_name = '" + name + "'";
            resultSet = statement.executeQuery(sqlx);
            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");
                //    String b = resultSet.getString("remain");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(newQuntity);

                totalQ = tempQ + tempQ2;
                // totalR=tempQ2+tempD;
                String newAm = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("SQL ER AGE");

                //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                String sqly = "update total set p_name = '" + name + "', poriman = '" + newAm + "',date = '" + date + "' where p_name= '" + name + "'";

                statement.executeUpdate(sqly);
                System.out.println("Execue hoise");
                //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void CustomerStock(String no, String name, String amount, String date, String x, String y) {
        String X = "0";
        try {
            String sql = "INSERT INTO customer (c_no,c_name,joma,date,poriman,dor,koroch,kibabot) VALUES ('" + no + "','" + name + "', '" + amount + "', '" + date + "', '" + y + "', '" + y + "', '" + y + "', '" + x + "');";

            statement.executeUpdate(sql);

            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

            String sqlx = "INSERT INTO sell (c_name,address,c_mobile,driver,d_mobile,gari_no,date,p_name,poriman,dor,serial_id,joma) VALUES ('" + name + "','" + X + "', '" + X + "','" + X + "', '" + X + "','" + X + "', '" + date + "','" + X + "', '" + X + "','" + X + "','" + X + "','" + amount + "');";

            System.out.println("xxx");
            statement.executeUpdate(sqlx);

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void CustomerAll(String name) {

        try {
            
            double totalG = 0;
            double totalT = 0;
            
            double totalK = 0;
            double totalR = 0;
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            
            try {
                System.out.println("Start");
                String sql = "select * from customer where c_name = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    ///      totalG = totalG + tempG;
                    String i = " ";
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGiven = String.valueOf(totalG);
                    String totalTaken = String.valueOf(totalT);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i, sId};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void CustomerAllByName(String name) {
        
        
        if(name.equals("")){
        

        try {
            
            
            double totalG = 0;
            double totalT = 0;
            double totalK = 0;
            double totalR = 0;
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            
            try {
                System.out.println("Start");
                String sql = "select * from customer ";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    ///      totalG = totalG + tempG;
                    String i = " ";
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGiven = String.valueOf(totalG);
                    String totalTaken = String.valueOf(totalT);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i, sId};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    // st.setData(total);
                    //on.totalGivenField.setText(totalGiven);
                    // on.totalTakenField.setText(totalTaken);
                    // on.totalRemainField.setText(totalRemainTk);
                    // on.totalField.setText(total);
                    // on.productName.setText(pN);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

            System.out.println("MMM");
            
        } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }else{
            
        try {
            
            double totalG = 0;
            double totalK = 0;
            double totalR = 0;
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            
            try {
                System.out.println("Start");
                String sql = "select * from customer where c_name = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    //String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    String i = " ";
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    // st.setData(total);
                    //on.totalGivenField.setText(totalGiven);
                    // on.totalTakenField.setText(totalTaken);
                    // on.totalRemainField.setText(totalRemainTk);
                    // on.totalField.setText(total);
                    // on.productName.setText(pN);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }
        } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    void CustomerAllByID(String name) {

        try {
            
            double totalG = 0;
            double totalK = 0;
            double totalR = 0;
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            
            try {
                System.out.println("Start");
                String sql = "select * from customer where c_no = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    //String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    String i = " ";
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    // st.setData(total);
                    //on.totalGivenField.setText(totalGiven);
                    // on.totalTakenField.setText(totalTaken);
                    // on.totalRemainField.setText(totalRemainTk);
                    // on.totalField.setText(total);
                    // on.productName.setText(pN);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void CustomerStockKoroch(String no, String name, String amount, String date, String x, String y) {

        String X = "0";
        String J = "-" + amount;

        try {

            String sql = "INSERT INTO customer (c_no,c_name,joma,date,poriman,dor,koroch,kibabot) VALUES ('" + no + "','" + name + "', '" + y + "', '" + date + "', '" + y + "', '" + y + "', '" + amount + "', '" + x + "');";

            statement.executeUpdate(sql);

            String sqlx = "INSERT INTO sell (c_name,address,c_mobile,driver,d_mobile,gari_no,date,p_name,poriman,dor,serial_id,joma) VALUES ('" + name + "','" + X + "', '" + X + "','" + X + "', '" + X + "','" + X + "', '" + date + "','" + X + "', '" + X + "','" + X + "','" + X + "','" + J + "');";

            System.out.println("xxx");
            statement.executeUpdate(sqlx);
            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ***************************************************Mal Bikri
     * Stock*****************************************************************************************
     */
    void BAllStock(String name, String amount, String date, String cusNm, String cusNo, String cusPhone, String driNm, String calan, String zip) {
    //  String sql = "INSERT INTO customer (c_no,c_name,joma,date,poriman,dor,koroch,kibabot) VALUES ('" + no + "','" + name + "', '" + amount + "', '" + date + "', '" + y + "', '" + y + "', '" + y + "', '" + x+ "');";

        //       statement.executeUpdate(sql);
        double totalQ = 0;
        double totalR = 0;
        try {
            String sql = "select * from mal_kinar_stock where p_name = '" + name + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                //   JOptionPane.showMessageDialog(null, "SAme");
                //
                System.out.println("SQL ER AGE");

                String sql2 = "INSERT INTO mal_kinar_stock (p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip) VALUES ('" + name + "','" + amount + "', '" + date + "','" + cusNm + "', '" + cusNo + "','" + cusPhone + "', '" + driNm + "','" + calan + "', '" + zip + "');";

                statement.executeUpdate(sql2);

                System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

            } else {

                try {
                    String newQuntity = "0";

                    // JOptionPane.showMessageDialog(null, "Not Same");
                    String sql2 = "INSERT INTO mal_kinar_stock (p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip) VALUES ('" + name + "','" + amount + "', '" + date + "','" + cusNm + "', '" + cusNo + "','" + cusPhone + "', '" + driNm + "','" + calan + "', '" + zip + "');";

                    statement.executeUpdate(sql2);

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hogaxxx");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        //JOptionPane.showMessageDialog(null, "Bare Not Same");
        /**
         * *************?? Total Table??************************
         */
        try {

            String sqlx = "select * from total_mal_kinar_stock where c_name = '" + cusNm + "'";
            resultSet = statement.executeQuery(sqlx);

            if (resultSet.next()) {
                String a = resultSet.getString("p_name");
                String sqlz = "select * from total_mal_kinar_stock where p_name = '" + name + "' And c_name= '" + cusNm + "'";
                resultSet = statement.executeQuery(sqlz);
                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "OIBO");
                    String p = resultSet.getString("poriman");
                    //    String b = resultSet.getString("remain");
                    double tempQ = Double.parseDouble(p);
                    //  double tempD = Double.parseDouble(b);
                    double tempQ2 = Double.parseDouble(amount);

                    totalQ = tempQ + tempQ2;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalQ);
                    //    String newRemain=String.valueOf(totalR);
                    System.out.println("SQL ER AGE");

                    try {

                        //JOptionPane.showMessageDialog(null, "Not Same");(String name, String amount, String date, String cusNm, String cusNo, String cusPhone, String driNm, String calan, String zip)
                        System.out.println("Execue hoiaefsgdfkvabvse");
                        String sqly = "update total_mal_kinar_stock set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date + "', c_name = '" + cusNm + "',c_no = '" + cusNo + "', c_phone = '" + cusPhone + "',calan_no = '" + calan + "', zip = '" + zip + "' where c_name= '" + cusNm + "' And p_name= '" + name + "'";

                        statement.executeUpdate(sqly);
                        System.out.println("Execue hoiseaaaaaaaaaaaaa");

                        //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");
                    } catch (SQLException ex) {
                        //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Something rong");
                        JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                    }
                    /* break;*/

                } else {

                    try {
                        System.out.println("Uporay o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                        String sqlxx = "INSERT INTO total_mal_kinar_stock (p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip) VALUES ('" + name + "','" + amount + "', '" + date + "','" + cusNm + "', '" + cusNo + "','" + cusPhone + "', '" + driNm + "','" + calan + "', '" + zip + "');";
                        System.out.println("Nichay    Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                        statement.executeUpdate(sqlxx);

                        System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                        // JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");

                    } catch (SQLException ex) {
                        System.out.println("Boss Someting Rong Hogadcvfxvx");
                    }

                }

                /*
                 //    JOptionPane.showMessageDialog(null,"SAme");
                 System.out.println("x");

                 String a = resultSet.getString("poriman");
                 //    String b = resultSet.getString("remain");
                 double tempQ = Double.parseDouble(a);
                 //  double tempD = Double.parseDouble(b);
                 double tempQ2 = Double.parseDouble(amount);

                 totalQ = tempQ + tempQ2;
                 // totalR=tempQ2+tempD;
                 String newQuntity = String.valueOf(totalQ);
                 //    String newRemain=String.valueOf(totalR);
                 System.out.println("SQL ER AGE");

                 try {
                 //JOptionPane.showMessageDialog(null, "Not Same");(String name, String amount, String date, String cusNm, String cusNo, String cusPhone, String driNm, String calan, String zip)
                  
                 String sqly = "update total_mal_kinar_stock set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date +"', c_name = '" + cusNm + "',c_no = '" + cusNo +"', c_phone = '" + cusPhone + "',calan_no = '" + calan +"', zip = '" +zip + "' where c_name= '" + cusNm + "'";

                 statement.executeUpdate(sqly);
                 System.out.println("Execue hoise");
                 //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

                 } catch (SQLException ex) {
                 //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                 System.out.println("Something rong");
                 JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                 }
                
                
                 */
            } else {
////LAST?????
                try {
                    System.out.println("Uporay o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                    String sql = "INSERT INTO total_mal_kinar_stock (p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip) VALUES ('" + name + "','" + amount + "', '" + date + "','" + cusNm + "', '" + cusNo + "','" + cusPhone + "', '" + driNm + "','" + calan + "', '" + zip + "');";
                    System.out.println("Nichay    Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                    statement.executeUpdate(sql);

                    System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                    // JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hogadcvfxvx");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");

    }

    void showSelectProductB(String name) {

        String test = "0";
        if (name == test) {
            JOptionPane.showMessageDialog(null, "Sorry");
        } else {

            double totalG = 0;
            double totalT = 0;
            int no = 1;
            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
                String sql = "select * from mal_kinar_stock where p_name = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                System.out.println("SQL er uporay");
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("SQL er nichay");
                while (resultSet.next()) {
                    //(p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip)
                    String id = resultSet.getString("id");
                    String p_nam = resultSet.getString("p_name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String c_nam = resultSet.getString("c_name");
                    String c_no = resultSet.getString("c_no");
                    String c_phone = resultSet.getString("c_phone");
                    String driver = resultSet.getString("driver");
                    String calanNo = resultSet.getString("calan_no");
                    String zip = resultSet.getString("zip");

                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);
                  
                    
                    totalT = totalT + tempQ;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    if(am!="0"){
                    
                        BtotalMalKinartStock st = new BtotalMalKinartStock();
                    System.out.println("Table  er uporay");
                    Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip, id};
                    m.addRow(rowData);
                
                    }
                    no++;
                    System.out.println("Table er nichay");
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalF.setText(newQuntity);
                    on.idL.setText(id);
                    on.f.setText(c_nam);
            
                 
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        }

    }

    void showAllProductB() {

        double totalG = 0;
        double totalT = 0;
        int no = 1;
        BtotalMalKinartStock on = new BtotalMalKinartStock();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

        try {
            String sql = "select * from total_mal_kinar_stock ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String p_nam = resultSet.getString("p_name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String c_nam = resultSet.getString("c_name");
                String c_no = resultSet.getString("c_no");
                String c_phone = resultSet.getString("c_phone");
                String driver = resultSet.getString("driver");
                String calanNo = resultSet.getString("calan_no");
                String zip = resultSet.getString("zip");

                double tempQ = Double.parseDouble(am);
                //  double tempD = Double.parseDouble(b);
                // double tempQ2 = Double.parseDouble(amount);

                totalT = totalT + tempQ;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);

                BtotalMalKinartStock st = new BtotalMalKinartStock();

                Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.totalF.setText(newQuntity);
                on.idL.setText(id);
                on.f.setText(" All Product ");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    }

    void updateDataB(String id, String name, String amount, String date, String cusNm, String cusNo, String cusPhone, String driNm, String calan, String zip) {

        try {
            double totalQ = 0;

            String sql = "delete from mal_kinar_stock where id = '" + id + "'";
            // String sql = "DELETE * FROM student " +
            //     //        "WHERE roll = "+SearchRoll+",";
            statement.executeUpdate(sql);

            String sqlx = "select * from total_mal_kinar_stock where c_name = '" + cusNm + "' And p_name= '" + name + "'";
            resultSet = statement.executeQuery(sqlx);
            System.out.println("AUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            if (resultSet.next()) {
                System.out.println("BUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");

                //    String b = resultSet.getString("remain");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(amount);

                totalQ = tempQ - tempQ2;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("XUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");

                //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                //  String sqly = "update total_mal_kinar_stock set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date + "' where p_name= '" + name + "'";
                if (tempQ == 0) {
                    JOptionPane.showConfirmDialog(null, "OOOOO");
                    String sqld = "delete from total_mal_kinar_stock where p_name= '" + name + "' And c_name= '" + cusNm + "'";
                    // String sql = "DELETE * FROM student " +
                    //     //        "WHERE roll = "+SearchRoll+",";
                    statement.executeUpdate(sqld);
                } else {
                    String sqly = "update total_mal_kinar_stock set p_name = '" + name + "', poriman = '" + newQuntity + "',date = '" + date + "', c_name = '" + cusNm + "',c_no = '" + cusNo + "', c_phone = '" + cusPhone + "',calan_no = '" + calan + "', zip = '" + zip + "' where c_name= '" + cusNm + "' And p_name= '" + name + "'";

                    statement.executeUpdate(sqly);
                    System.out.println("Execue hoise");
                }
                //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");
                //*   >>>>****/

            }

            JOptionPane.showMessageDialog(null, "Data deleted Succesfully!");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void updateDataBDeleteZero(String id, String name, String amount, String date, String cusNm, String cusNo, String cusPhone, String driNm, String calan, String zip) {

        try {

            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            JOptionPane.showConfirmDialog(null, "OOOOOkkkkk Delete");
            String sqld = "delete from total_mal_kinar_stock where p_name= '" + name + "' And c_name= '" + cusNm + "'";
            // String sql = "DELETE * FROM student " +
            //     //        "WHERE roll = "+SearchRoll+",";
            statement.executeUpdate(sqld);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void updateDataAZeroDelete(String id, String name, String amount, String date) {
        try {
            String sql = "delete from total where p_name = '" + name + "'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

void SearchFromToMalik(String fDate,String tDate) {

    
        //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK"+fDate+"  "+tDate);
            
             String sql = "select * from main_malik_stock where  date >=  '" +fDate + "' And date<='" + tDate+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }


    
    
    }

    void showAllProductD() {

        //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();

        try {
            String sql = "select * from main_malik_stock ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);

                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    }

    void showSelectMalikD(String name) {

        String test = "0";
        if (name == test) {
            JOptionPane.showMessageDialog(null, "Sorry");
        } else {

            double totalK = 0;
            double totalG = 0;
            double totalT = 0;
            int no = 1;
            DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
            try {
                String sql = "select * from main_malik_stock where name = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String nam = resultSet.getString("name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String koroch = resultSet.getString("koroch");
                    String kibabot = resultSet.getString("kibabot");

                    double tempG = Double.parseDouble(am);
                    double tempK = Double.parseDouble(koroch);
                    // double tempQ2 = Double.parseDouble(amount);
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalT = totalG - totalK;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    String newG = String.valueOf(totalG);
                    String newK = String.valueOf(totalK);

                    DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                    Object rowData[] = {dat, nam, am, koroch, kibabot};
                    m.addRow(rowData);
                    no++;
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.total.setText(newQuntity);
                    on.totalG.setText(newG);
                    on.totalK.setText(newK);

                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        }

    }

    void employeeStockAdvance(String nam, String am, String date, String R) {
        try {
            double totalQ = 0;
            double totalR = 0;
            double x = 0;
            String XX = "Joma";

            String sql = "select * from employee where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String mSalary = resultSet.getString("main_salary");
                String pod = resultSet.getString("podobi");
                JOptionPane.showMessageDialog(null, "SAme" + mSalary + " Pod" + pod);
                //

                System.out.println("xxx");
                String sqlz = "INSERT INTO employee (name,date,salary,advance,main_salary,podobi,remark) VALUES ('" + nam + "','" + date + "', '" + x + "','" + am + "', '" + mSalary + "','" + pod + "', '" + R + "');";

                // String sql2 = "INSERT INTO employee (name,date,salary,advance,main_salary,podobi,remark) VALUES ('" + nam + "','" + date + "', '" + x +  "','" + am + "', '" +"','" + mSalary + "', '" + pod + "', '" + R + "');";
                //   String sqlz = "INSERT INTO employee (name,date,salary,advance,main_salary,podobi,remark) VALUES ('" + nam+ "','" + date + "', '" + date+ "','" + am + "', '" + nam+ "','" + am + "', '" + date +  "', '" + date + "');";
                System.out.println("xxx");
                statement.executeUpdate(sqlz);

                System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

            } else {

                JOptionPane.showMessageDialog(null, "No Employee exis name");

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void employeeStockSalary(String nam, String am, String date, String R) {

        try {
            double totalQ = 0;
            double totalR = 0;
            double x = 0;
            String XX = "Joma";

            String sql = "select * from employee where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String mSalary = resultSet.getString("main_salary");
                String pod = resultSet.getString("podobi");
                JOptionPane.showMessageDialog(null, "SAme" + mSalary + " Pod" + pod);
                //

                System.out.println("xxx");
                String sqlz = "INSERT INTO employee (name,date,salary,advance,main_salary,podobi,remark) VALUES ('" + nam + "','" + date + "', '" + am + "','" + x + "', '" + mSalary + "','" + pod + "', '" + R + "');";

                // String sql2 = "INSERT INTO employee (name,date,salary,advance,main_salary,podobi,remark) VALUES ('" + nam + "','" + date + "', '" + x +  "','" + am + "', '" +"','" + mSalary + "', '" + pod + "', '" + R + "');";
                //   String sqlz = "INSERT INTO employee (name,date,salary,advance,main_salary,podobi,remark) VALUES ('" + nam+ "','" + date + "', '" + date+ "','" + am + "', '" + nam+ "','" + am + "', '" + date +  "', '" + date + "');";
                System.out.println("xxx");
                statement.executeUpdate(sqlz);

                System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

            } else {

                JOptionPane.showMessageDialog(null, "No Employee exis name");

            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void SearchEmployee(String name) {
        double totalK = 0;
        double bakiTk = 0;
        double bakiTkS = 0;
        double bakiTkA = 0;
        double totalTk = 0;

        double totalT = 0;
        int no = 1;
        AESalaryPage on = new AESalaryPage();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.emploeeTable.getModel();
        try {
            String sql = "select * from employee where name = '" + name + "'";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");

                String dat = resultSet.getString("date");
                String salary = resultSet.getString("salary");
                String advance = resultSet.getString("advance");
                String mSalary = resultSet.getString("main_salary");
                String podobi = resultSet.getString("podobi");
                String remark = resultSet.getString("remark");

                double tempMsalary = Double.parseDouble(mSalary);
                double tempA = Double.parseDouble(advance);
                double tempS = Double.parseDouble(salary);
                bakiTkS = bakiTkS + tempS;
                bakiTkA = bakiTkA + tempA;
                totalTk = tempS + tempA + totalTk;
                bakiTk = tempMsalary - totalTk;
                String totalS = String.valueOf(bakiTkS);
                String totalA = String.valueOf(bakiTkA);
                    // totalR=tempQ2+tempD;

                // String newG = String.valueOf(totalG);
                //  String newK = String.valueOf(totalK);
                AESalaryPage st = new AESalaryPage();

                Object rowData[] = {dat, salary, advance, remark};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.a.setText("Total Salary Nise =" + totalS);
                on.b.setText("Total Advance Nise = " + totalA);
                on.c.setText("Baki TK  =  " + bakiTk);
                on.d.setText("Main Salary Pay = " + mSalary);
                on.namL.setText("Name : "+nam);
                on.podobiL.setText("Podobi : "+podobi);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
                // on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }

    }

    void sellCashMemo(String cusNm, String cusAdd, String cusPn, String driver, String driPn, String gariNo, String date, String proNm, String amount, String dor, String serial, String joma) {
        double totalPrice = 0;
        double bakiTk = 0;
        double mainPrice = 0;
        double bakiTkA = 0;
        double totalTk = 0;
        double totalGiven = 0;
        String name1 = "Md Joynal Abeedin";
        String name2 = "Md Sobuj Miah";
        String sell = "Sell";

        double totalT = 0;
        int no = 0;
        cashMemo on = new cashMemo();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.cashTable.getModel();

        try {

            String sqlx = "INSERT INTO sell (c_name,address,c_mobile,driver,d_mobile,gari_no,date,p_name,poriman,dor,serial_id,joma) VALUES ('" + cusNm + "','" + cusAdd + "', '" + cusPn + "','" + driver + "', '" + driPn + "','" + gariNo + "', '" + date + "','" + proNm + "', '" + amount + "','" + dor + "','" + serial + "','" + joma + "');";

            System.out.println("xxx");
            statement.executeUpdate(sqlx);
            System.out.println("OK 1");
            String sql = "select * from sell where serial_id = '" + serial+ "'";
            //   String sql = "select * from sell where serial_id = '" + serial + "'";
            // (c_name,address,c_mobile,driver,d_mobile,gari_no,date,p_name,poriman,dor,serial_id,joma
            //st.setPartner(id,a, Nm, gv, tn, date);
            System.out.println("OK 2");
            resultSet = statement.executeQuery(sql);
            System.out.println("OK 3");
            while (resultSet.next()) {
                System.out.println("OK 4");
                String id = resultSet.getString("id");
                String cName = resultSet.getString("c_name");

                String cAdd = resultSet.getString("address");
                String cMobile = resultSet.getString("c_mobile");
                String driverNm = resultSet.getString("driver");
                String driverPn = resultSet.getString("d_mobile");
                String gari = resultSet.getString("gari_no");
                String cDate = resultSet.getString("date");
                String pName = resultSet.getString("p_name");
                String am = resultSet.getString("poriman");
                String price = resultSet.getString("dor");
                String serialId = resultSet.getString("serial_id");
                String given = resultSet.getString("joma");
                double tempAmount = Double.parseDouble(am);
                double tempPrice = Double.parseDouble(price);
                double tempGiven = Double.parseDouble(given);
                mainPrice = tempAmount * tempPrice;
                totalPrice = totalPrice + mainPrice;
                //  totalTk = tempS + tempA + totalTk;
                totalGiven = totalGiven + tempGiven;
                bakiTk = totalPrice - totalGiven;
                String totalS = String.valueOf(bakiTk);
                String totalGivenTk = String.valueOf(totalGiven);
                String total = String.valueOf(totalPrice);
                double temp = totalGiven / 2;
                String xx = String.valueOf(temp);
                String Price = String.valueOf(mainPrice);
                String Baki = String.valueOf(bakiTk);
                cashMemo st = new cashMemo();

                Object rowData[] = {pName, am, price, mainPrice};
                m.addRow(rowData);
                on.bakiL.setText("Baki Tk : " + Baki);
                on.totalTKL.setText("Total : " + total);
                on.cNameFL.setText("Name :      " + cName);
                on.cAddFL.setText("Address :   " + cAdd);
                on.cPhoneL.setText("Phone :  " + cMobile);
                on.driverFL.setText("Driver :     " + driverNm);
                on.dPhoneFL.setText("Driver Phone :   " + driverPn);
                on.gariFL.setText("Gari No :  " + gari);
                on.dateL.setText(cDate);
                on.idFL.setText(serialId);
                on.jomaHoiseL.setText("Goma Hoise : " + totalGivenTk);
                //bakiL.setText("Baki Tk : "+BakiTk);
                // no++;
                on.cNameF.setText(cusNm);

                on.cAddF.setText(cusAdd);
               // on.((JTextField) dateF.setDateEditor().setUiComponent()).setText("date");
                       
                on.cPhone.setText(cusPn);

                on.driverF.setText(driver);
                on.dPhoneF.setText(driPn);

                on.gariF.setText(gariNo);
                // on.((JTextField) dateF.getDateEditor().getUiComponent()).setText(date);
                // on.pNameField.setSelectedItem().toString(proNm);
                on.amountF.setText(amount);
     
                on.dorF.setText(dor);
                // on.SbakiF.setText();
                on.idF.setText(serial);
                on.setTextDate(cDate);    
  
                
                System.out.println(" AtotalProductStock OKKKKKKK");
                //  on.a.setText("Total Salary Nise =" + totalS);
                //    on.b.setText("Total Advance Nise = " + totalA);
                //  on.c.setText("Baki TK  = " + bakiTk);
                //   on.d.setText("Main Salary Pay = " + mSalary);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
                // on.totalK.setText(newK);
                /*
                 String total = String.valueOf(tempTotal);
                 totalTk = totalTk + Double.parseDouble(total);
                 Object rowData[] = { proNm, amount, dor, total};
                 bakiTk=totalTk-Double.parseDouble(joma);
                 String tk=String.valueOf(totalTk);
                 totalTKL.setText("Total : "+tk);
                 String BakiTk=String.valueOf(bakiTk);
                 model.addRow(rowData);
             
                 cNameFL.setText("Name :      "+cusNm);
                 cAddFL.setText( "Address :   "+cusAdd);
                 cPhoneL.setText("Phone :  "+cusPn);
                 driverFL.setText("Driver :     "+driver);
                 dPhoneFL.setText("Driver Phone :   "+driPn);
                 gariFL.setText("Gari No :  "+gariNo);
                 dateL.setText(date);
                 idFL.setText(serial);
                 bakiL.setText("Baki Tk : "+BakiTk);
                 */

            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }
        /**
         * ***************************************Malik**************************************
         */

    }

    void sellCashMemoSearch(String serial) {
        try {
            double totalPrice = 0;
            double bakiTk = 0;
            double mainPrice = 0;
            double bakiTkA = 0;
            double totalTk = 0;
            double totalGiven = 0;

            double totalT = 0;
            int no = 1;

            cashMemo on = new cashMemo();

            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.cashTable.getModel();
            String sqlx = "select * from sell where serial_id = '" + serial + "'";
            // (c_name,address,c_mobile,driver,d_mobile,gari_no,date,p_name,poriman,dor,serial_id,joma
            //st.setPartner(id,a, Nm, gv, tn, date);
            System.out.println("OK 2");
            resultSet = statement.executeQuery(sqlx);
            System.out.println("OK 3");
            while (resultSet.next()) {
                System.out.println("OK 4");
                String id = resultSet.getString("id");
                String cName = resultSet.getString("c_name");

                String cAdd = resultSet.getString("address");
                String cMobile = resultSet.getString("c_mobile");
                String driverNm = resultSet.getString("driver");
                String driverPn = resultSet.getString("d_mobile");
                String gari = resultSet.getString("gari_no");
                String cDate = resultSet.getString("date");
                String pName = resultSet.getString("p_name");
                String am = resultSet.getString("poriman");
                String price = resultSet.getString("dor");
                String serialId = resultSet.getString("serial_id");
                String given = resultSet.getString("joma");
                double tempAmount = Double.parseDouble(am);
                double tempPrice = Double.parseDouble(price);
                double tempGiven = Double.parseDouble(given);
                mainPrice = tempAmount * tempPrice;
                totalPrice = totalPrice + mainPrice;
                //  totalTk = tempS + tempA + totalTk;
                totalGiven = totalGiven + tempGiven;
                bakiTk = totalPrice - totalGiven;
                String totalS = String.valueOf(bakiTk);
                String totalGivenTk = String.valueOf(totalGiven);
                String total = String.valueOf(totalPrice);
                // totalR=tempQ2+tempD;

                String Price = String.valueOf(mainPrice);
                String Baki = String.valueOf(bakiTk);
                cashMemo st = new cashMemo();

                Object rowData[] = {pName, am, price, mainPrice};
                m.addRow(rowData);
                on.bakiL.setText("Baki Tk : " + Baki);
                on.totalTKL.setText("Total : " + total);
                on.cNameFL.setText("Name :      " + cName);
                on.cAddFL.setText("Address :   " + cAdd);
                on.cPhoneL.setText("Phone :  " + cMobile);
                on.driverFL.setText("Driver :     " + driverNm);
                on.dPhoneFL.setText("Driver Phone :   " + driverPn);
                on.gariFL.setText("Gari No :  " + gari);
                on.dateL.setText(cDate);
                on.idFL.setText(serialId);
                on.jomaHoiseL.setText("Goma Hoise : " + totalGivenTk);
                //bakiL.setText("Baki Tk : "+BakiTk);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.cNameF.setText(cName);
                
                on.cAddF.setText(cAdd);

                on.cPhone.setText(cMobile);

                on.driverF.setText(driverNm);
                on.dPhoneF.setText(driverPn);

                on.gariF.setText(gari);
                on.idF.setText(serial);
on.setTextDate(cDate);                

//  on.a.setText("Total Salary Nise =" + totalS);
                //    on.b.setText("Total Advance Nise = " + totalA);
                //  on.c.setText("Baki TK  = " + bakiTk);
                //   on.d.setText("Main Salary Pay = " + mSalary);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
                // on.totalK.setText(newK);
                /*
                 String total = String.valueOf(tempTotal);
                 totalTk = totalTk + Double.parseDouble(total);
                 Object rowData[] = { proNm, amount, dor, total};
                 bakiTk=totalTk-Double.parseDouble(joma);
                 String tk=String.valueOf(totalTk);
                 totalTKL.setText("Total : "+tk);
                 String BakiTk=String.valueOf(bakiTk);
                 model.addRow(rowData);
                
                 cNameFL.setText("Name :      "+cusNm);
                 cAddFL.setText( "Address :   "+cusAdd);
                 cPhoneL.setText("Phone :  "+cusPn);
                 driverFL.setText("Driver :     "+driver);
                 dPhoneFL.setText("Driver Phone :   "+driPn);
                 gariFL.setText("Gari No :  "+gariNo);
                 dateL.setText(date);
                 idFL.setText(serial);
                 bakiL.setText("Baki Tk : "+BakiTk);
                 */

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void CustomerStockKorochBySell(String no, String name, String amount, String date, String x, String y,String proNm,String joma) {
        String ab="0";
        String temp = joma;
        double tempAmount = Double.parseDouble(amount);
        double tempDor = Double.parseDouble(y);
        double tempAm = tempAmount * tempDor;
        String AM = String.valueOf(tempAm);
        try {
            System.out.println("Customer Stock Koroch");
            String sql = "select * from customer where  c_name = '" +name + "'";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                
                System.out.println("Customer Stok KOroch While er vitoray");
                String sqlx = "INSERT INTO customer (c_no,c_name,joma,date,poriman,dor,koroch,kibabot) VALUES ('" + no + "','" + name + "', '" + temp + "', '" + date + "', '" + amount + "', '" + y + "', '" + AM + "', '" + x + "');";
                
                statement.executeUpdate(sqlx);
                
                System.out.println("While Exicutexxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }

            
            
            
            /*
            
            
            
            
            System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
            */
        }catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
                String sqly = "select * from product_stock where  p_name = '" +proNm + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sqly);
                System.out.println("product_stock executeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
                while (resultSet.next()) {
                    System.out.println("Product Stock while er vitoray");
                    
                    String sqlz = "INSERT INTO product_stock (p_name,poriman,date,sell) VALUES ('" +proNm+ "','" + ab + "', '" + date + "','" + amount + "');";
                    
                    System.out.println("xxx");
                    System.out.println("Product Stock while er vitoray Executed");
                    
                    //  statement.executeUpdate(sqlx);
                    
                    statement.executeUpdate(sqlz);
                    System.out.println("Product Stock while er vitoray exe comple");
                    
                    
                    
                }
                
        } catch (Exception e) {
        }
    }

    void CustomerStockKorochBySellHitTotalProduct(String no, String name,String amount, String date, String x, String y, String proNm) {
        
        try {
            double totalQ =0;
            String ab="0";
            String sqlx = "select * from total where p_name = '" + proNm + "'";
            resultSet = statement.executeQuery(sqlx);

            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");
                   String newQuntityX="0";
                
                String a = resultSet.getString("poriman");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(amount);

                if(tempQ2<=tempQ){
                //    String b = resultSet.getString("remain");
                
                totalQ = tempQ - tempQ2;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("SQL ER AGE");
                
                
                try {
                    //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                    String sqly = "update total set p_name = '" + proNm + "', poriman = '" + newQuntity + "',date = '" + date +"',sell = '" + ab + "' where p_name= '" + proNm+ "'";

                    statement.executeUpdate(sqly);
                    System.out.println("Execue hoise");
                    //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

                } catch (SQLException ex) {
                    //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Something rong");
                    JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                }
                }else{
                
                try {
                    //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                    String sqly = "update total set p_name = '" + proNm + "', poriman = '" + newQuntityX + "',date = '" + date +"',sell = '" + ab + "' where p_name= '" + proNm+ "'";

                    statement.executeUpdate(sqly);
                    System.out.println("Execue hoise");
                    //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

                } catch (SQLException ex) {
                    //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Something rong");
                    JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                }
                
                }
                
                
                
                

            }
            
            /*
            
            String ab="0";
            double tempX=0;
            try {
            String sql= "select * from total where  p_name = '" +proNm + "'";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
            
        sellCashMemoHitMalikTotalTk    
            
            
            String p = resultSet.getString("poriman");
            double tempP = Double.parseDouble(p);
            double tempS = Double.parseDouble(amount);
            tempX = tempP-tempS;
            String newAM = String.valueOf(tempX);
            String sqlz = "update total set p_name = '" +name + "', poriman = '" + newAM + "',date = '" + date+ "',sell = '" + ab + "' where p_name= '" + name + "'";
            
            statement.executeUpdate(sqlz);
            
            
            
            }
            } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            */
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }




    void findMilerKoroch(String date) {

        long totalK = 0;
        long bakiTk = 0;
        long bakiTkS = 0;
        long bakiTkA = 0;
        long totalTk = 0;

        long totalT = 0;
        long no = 1;
        String x="%"+date+"%";
        
        dailyKoroch on = new dailyKoroch();
     
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.jTable1.getModel();
        try {
            String sql = "select * from daily_milar_koroch where  date like '" +x + "'";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String poriman = resultSet.getString("amount");
                String Tk = resultSet.getString("tk");
                String dat = resultSet.getString("date");

                String kibabot = resultSet.getString("kibabot");
                long tempA=Long.parseLong(poriman);
               // double tempMsalary = Double.parseDouble(mSalary);
               // long tempA = Double.parseDouble(poriman);
               long tempS = Long.parseLong(Tk);
                
                totalTk =  tempA * tempS;
                totalT =totalT +totalTk;
               // bakiTk = tempMsalary - totalTk;
                String totalS = String.valueOf(totalTk);
                String re="";
                    // totalR=tempQ2+tempD;

              String newX = String.valueOf("Total Koroch : "+totalT);
              
                //  String newK = String.valueOf(totalK);
                
              dailyKoroch st = new dailyKoroch();
                 
                Object rowData[] = {dat, nam, kibabot, poriman, totalS, re};
                m.addRow(rowData);
                no++;
                  
                System.out.println(" AtotalProductStock OKKKKKKK");
                // on.a.setText("Total Salary Nise =" + totalS);
                //on.b.setText("Total Advance Nise = " + totalA);
                // on.c.setText("Baki TK  =  " + bakiTk);
                // on.d.setText("Main Salary Pay = " + mSalary);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
               on.xx.setText(newX);
               
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }

    }
  void findMilerKorochFromTo(String fDate, String tDate) {
   
  if(tDate.equals("")){
 
      
        long totalK = 0;
        long bakiTk = 0;
        long bakiTkS = 0;
        long bakiTkA = 0;
        long totalTk = 0;

        long totalT = 0;
        long no = 1;
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        
        dailyKoroch on = new dailyKoroch();
     
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.jTable1.getModel();
        try {
            System.out.println("SQL er Uporay");
                String sql = "select * from daily_milar_koroch where  date like  '" +fDate+ "'";
          
        //    String sql = "select * from daily_milar_koroch where  date between  like  '" +fDate + "' And like'" + tDate + "'";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            System.out.println("SQL er Nise");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String poriman = resultSet.getString("amount");
                String Tk = resultSet.getString("tk");
                String dat = resultSet.getString("date");

                String kibabot = resultSet.getString("kibabot");
                long tempA=Long.parseLong(poriman);
               // double tempMsalary = Double.parseDouble(mSalary);
               // long tempA = Double.parseDouble(poriman);
               long tempS = Long.parseLong(Tk);
                
                totalTk =  tempA * tempS;
                totalT =totalT +totalTk;
               // bakiTk = tempMsalary - totalTk;
                String totalS = String.valueOf(totalTk);
                String re="";
                    // totalR=tempQ2+tempD;SearchFromToMalik

              String newX = String.valueOf("Total Koroch : "+totalT);
              
                //  String newK = String.valueOf(totalK);
                
              dailyKoroch st = new dailyKoroch();
                 
                Object rowData[] = {dat, nam, kibabot, poriman, totalS, re};
                m.addRow(rowData);
                no++;
                  
                System.out.println(" AtotalProductStock OKKKKKKK");
                // on.a.setText("Total Salary Nise =" + totalS);
                //on.b.setText("Total Advance Nise = " + totalA);
                // on.c.setText("Baki TK  =  " + bakiTk);
                // on.d.setText("Main Salary Pay = " + mSalary);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
               on.xx.setText(newX);
               
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }

      
      
      
  
  }else{
  
        long totalK = 0;
        long bakiTk = 0;
        long bakiTkS = 0;
        long bakiTkA = 0;
        long totalTk = 0;

        long totalT = 0;
        long no = 1;
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        
        dailyKoroch on = new dailyKoroch();
     
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.jTable1.getModel();
        try {
            System.out.println("SQL er Uporay");
                String sql = "select * from daily_milar_koroch where  date >=  '" +fDate + "' And date<='" + tDate + "'";
          
        //    String sql = "select * from daily_milar_koroch where  date between  like  '" +fDate + "' And like'" + tDate + "'";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            System.out.println("SQL er Nise");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String poriman = resultSet.getString("amount");
                String Tk = resultSet.getString("tk");
                String dat = resultSet.getString("date");

                String kibabot = resultSet.getString("kibabot");
                long tempA=Long.parseLong(poriman);
               // double tempMsalary = Double.parseDouble(mSalary);
               // long tempA = Double.parseDouble(poriman);
               long tempS = Long.parseLong(Tk);
                
                totalTk =  tempA * tempS;
                totalT =totalT +totalTk;
               // bakiTk = tempMsalary - totalTk;
                String totalS = String.valueOf(totalTk);
                String re="";
                    // totalR=tempQ2+tempD;SearchFromToMalik

              String newX = String.valueOf("Total Koroch : "+totalT);
              
                //  String newK = String.valueOf(totalK);
                
              dailyKoroch st = new dailyKoroch();
                 
                Object rowData[] = {dat, nam, kibabot, poriman, totalS, re};
                m.addRow(rowData);
                no++;
                  
                System.out.println(" AtotalProductStock OKKKKKKK");
                // on.a.setText("Total Salary Nise =" + totalS);
                //on.b.setText("Total Advance Nise = " + totalA);
                // on.c.setText("Baki TK  =  " + bakiTk);
                // on.d.setText("Main Salary Pay = " + mSalary);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
               on.xx.setText(newX);
               
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }

  
  
  
  }
  }
    void employeeStockAdvanceHitMalikTotalTk(String nam, String am, String date, String R) {
  
    
        try {
            String sql = "select * from employee where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String name1 = "Md Joynal Abeedin";
                String name2 = "Md Sobuj Miah";
                String salary = "Advance";
                String xx = "0";
                double x = 0;
                if (am.equals("") || am.equals("0.0")|| am.equals("")) {
                    System.out.println("OKKKKKK");
                    JOptionPane.showMessageDialog(null, "Tk Kome nai Maliker....");

                } else {

                  
                    String total = String.valueOf(am);
                    String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + nam + "','" + date + "', '" + xx + "', '" + total + "', '" + salary + "', '" + nam + "');";
                    System.out.println("total_tk_Advance");
                    statement.executeUpdate(sqlz);
                    }

            }else{
                JOptionPane.showMessageDialog(null,"E Nam Er Kuno Kormocari Nai......!\n\tTai Advance Dewa Jabe na");
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

    void employeeStockSalaryHitMalikTotalTk(String nam, String am, String date, String R) {

    
        try {
            String sql = "select * from employee where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                String name1 = "Md Joynal Abeedin";
                String name2 = "Md Sobuj Miah";
                String salary = "Salary";
                String xx = "0";
                double x = 0;
                if (am.equals("") || am.equals("0.0")|| am.equals("")) {
                    System.out.println("OKKKKKK");
                    JOptionPane.showMessageDialog(null, "Tk Kome nai Maliker....\n\tTai Salary Dewa Jabe Na...");

                } else {

                  
                    String total = String.valueOf(am);
                    String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + nam + "','" + date + "', '" + xx + "', '" + total + "', '" + salary + "', '" + nam + "');";
                    System.out.println("total_tk_Salary");
                    statement.executeUpdate(sqlz);
                    }

            }else{
                JOptionPane.showMessageDialog(null,"E Nam Er Kuno Kormocari Nai......!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    void CustomerStockJomaHitTotalTk(String no, String name, String amount, String date, String x, String y) {
        
        
        try {
            String sql = "select * from customer where c_name = '" + name + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                String name1 = "Md Joynal Abeedin";
                String name2 = "Md Sobuj Miah";
                String salary = "Joma";
                String xx = "0";
                double c = 0;
                if (amount.equals("") || amount.equals("0.0")|| amount.equals("")) {
                    System.out.println("OKKKKKK");
                    JOptionPane.showMessageDialog(null, "Tk Kome nai Maliker....\n\tTai Salary Dewa Jabe Na...");

                } else {

                  
                    String total = String.valueOf(amount);
                    String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + name + "','" + date + "', '" + amount + "', '" + xx + "', '" + salary + "', '" + name + "');";
                    System.out.println("total_tk_Salary");
                    statement.executeUpdate(sqlz);
                    }

            }else{
                JOptionPane.showMessageDialog(null,"E Nam Er Kuno Customer Nai......!\n\t Joma Hobe Na....!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
        
    }

    void CustomerStockKorochNewaHitTotalTk(String no, String name, String amount, String date, String x, String y) {
        
        try {
            String sql = "select * from customer where c_name = '" + name + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                String name1 = "Md Joynal Abeedin";
                String name2 = "Md Sobuj Miah";
                String salary = " Newa ";
                String xx = "0";
                double c = 0;
                if (amount.equals("") || amount.equals("0.0")|| amount.equals("")) {
                    System.out.println("OKKKKKK");
                    JOptionPane.showMessageDialog(null, "Tk Kome nai Maliker....\n\tTai Salary Dewa Jabe Na...");

                } else {

                  
                    String total = String.valueOf(amount);
                    String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + name + "','" + date + "', '" + xx + "', '" + amount + "', '" + salary + "', '" + name + "');";
                    System.out.println("total_tk_Salary");
                    statement.executeUpdate(sqlz);
                    }

            }else{
                JOptionPane.showMessageDialog(null,"E Nam Er Kuno Customer Nai......!\n\t Newa Jabe Na....!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }

   

    void sellCashMemoHitMalikTotalTk(String cusNm, String cusAdd, String cusPn, String driver, String driPn, String gariNo, String date, String proNm, String amount, String dor, String serial, String joma) {
      
    try {
            String sell = "Sell";
            String xx = "0";
            double x = 0;
            if (joma.equals("") || joma.equals("0.0")) {
                System.out.println("OKKKKKK");

            } else {

                int no = 0;
                String total = String.valueOf(joma);
                String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + cusNm + "','" + date + "', '" + total + "', '" + xx + "', '" + sell +  "', '" +serial + "');";
                System.out.println("INsert Total Tk");
                statement.executeUpdate(sqlz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

    void buyCashMemoHitMalikTotalTk(String cusNm, String cusAdd, String cusPn, String driver, String driPn, String gariNo, String date, String proNm, String amount, String dor, String serial, String joma) {
    
        try {
            String name1 = "Md Joynal Abeedin";
            String name2 = "Md Sobuj Miah";
            String buy = proNm + "(Buy)";
            String xx = "0";
            double x = 0;
            if (joma.equals("") || joma.equals("0.0")) {
                System.out.println("OKKKKKK");

            } else {

                int no = 0;
                String total = String.valueOf(joma);
                String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + cusNm + "','" + xx + "', '" + date + "', '" + total + "', '" + buy +  "', '" + serial + "');";
                System.out.println("Total_TK_BUy Add hoise...");
                statement.executeUpdate(sqlz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }


    void milerKoroch(String name, String amount, String tk, Date sqlD, String kibabot) {
     
       try {
            
            String sqlx = "INSERT INTO daily_milar_koroch (name,amount,tk,date,kibabot) VALUES ('" + name + "','" + amount + "', '" + tk + "','" + sqlD + "', '" + kibabot + "');";

            System.out.println("xxx");
            statement.executeUpdate(sqlx);
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

    void milerKorochHitMalikTotalTk(String name, String amount, String tk, Date sqlD, String kibabot) {
    
     System.out.println("OOO");
       try {
           
                String salary = "Miiler Koroch";
                String xx = "0";
                
             //   String am=String.valueOf(total);
                double x = 0;
                if (tk.equals("") || tk.equals("0.0")) {
                    System.out.println("OKKKKKK");

                } else {

                    double temp=Double.parseDouble(amount);
                  double tempTk=Double.parseDouble(tk);
                  double total=temp*tempTk;
                    String totalx = String.valueOf(total);
                    String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + name + "','" + sqlD + "', '" + xx + "', '" + totalx + "', '" + kibabot + "', '" + name + "');";
                    System.out.println("ERROR: 22");
                    statement.executeUpdate(sqlz);
                JOptionPane.showMessageDialog(null,"Saved...!");
                }

                
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    

    
    
    }

    void mainMalikStock(String nam, String am, Date sqlD) {
      /*
         try {
         String sql = "INSERT INTO main_malik_stock (name,poriman,joma,date,poriman,dor,koroch,kibabot) VALUES ('" + no + "','" + name + "', '" + amount + "', '" + date + "', '" + y + "', '" + y + "', '" + y + "', '" + x+ "');";
            
         statement.executeUpdate(sql);
            
         System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
         } catch (SQLException ex) {
         Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         */
        double totalQ = 0;
        double totalR = 0;
        double x = 0;
        String XX = "Joma";
        try {
            String sql = "select * from main_malik_stock where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                //   JOptionPane.showMessageDialog(null, "SAme");
                //
                System.out.println("SQL ER AGE");

                String sql2 = "INSERT INTO main_malik_stock (name,poriman,date,koroch,kibabot) VALUES ('" + nam + "','" + am + "', '" + sqlD + "','" + x + "', '" + XX + "');";

                statement.executeUpdate(sql2);

                System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

            } else {

                try {
                    String newQuntity = "0";

                    // JOptionPane.showMessageDialog(null, "Not Same");
                    String sql2 = "INSERT INTO main_malik_stock (name,poriman,date,koroch,kibabot) VALUES ('" + nam + "','" + am + "', '" + sqlD + "','" + x + "', '" + XX + "');";

                    statement.executeUpdate(sql2);

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hogaxxx");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        //JOptionPane.showMessageDialog(null, "Bare Not Same");
        /**
         * *************?? Total Table??************************
         */
        try {
            String sqlx = "select * from main_malik_stock_all where name = '" + nam + "'";
            resultSet = statement.executeQuery(sqlx);

            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");
                //    String b = resultSet.getString("remain");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(am);

                totalQ = tempQ + tempQ2;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("SQL ER AGE");

                try {
                    //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                    String sqly = "update main_malik_stock_all set name = '" + nam + "', poriman = '" + newQuntity + "',date = '" + sqlD+ "' where name= '" + nam + "'";

                    statement.executeUpdate(sqly);
                    System.out.println("Execue hoise");
                    //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

                } catch (SQLException ex) {
                    //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Something rong");
                    JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                }

            } else {

                try {

                    //JOptionPane.showMessageDialog(null, "Not Same");
                    String sqlz = "INSERT INTO main_malik_stock_all (name,poriman,date) VALUES ('" + nam + "','" + am + "', '" + sqlD + "');";

                    statement.executeUpdate(sqlz);

                    System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                    // JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hoga");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");
 }

    void mainMalikStockJomaHitTotalTk(String nam, String am, Date sqlD) {
    
    try {
            String sql = "select * from main_malik_stock where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                String name1 = "Md Joynal Abeedin";
                String name2 = "Md Sobuj Miah";
                String salary = " joma ";
                String xx = "0";
                double c = 0;
                if (am.equals("") || am.equals("0.0")|| am.equals("")) {
                    System.out.println("OKKKKKK");
                    JOptionPane.showMessageDialog(null, "Tk Kome nai Maliker....\n\tTai Salary Dewa Jabe Na...");

                } else {

                  
                    String total = String.valueOf(am);
                    String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + nam + "','" + sqlD+ "', '" + am + "', '" + xx + "', '" + salary + "', '" + nam + "');";
                    System.out.println("total_tk_Salary");
                    statement.executeUpdate(sqlz);
                    }

            }else{
                JOptionPane.showMessageDialog(null,"E Nam Er Kuno Malik Nai......!\n\t Newa Jabe Na....!");
            }
        } catch (Exception e) {
        }  
    
    
    
    }

    void mainMalikStockNewa(String nam, String am, Date sqlD) {
  
    
        double totalQ = 0;
        double totalR = 0;
        double x = 0;
        String XX = "Neya";
        try {
            String sql = "select * from main_malik_stock where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                //   JOptionPane.showMessageDialog(null, "SAme");
                //
                System.out.println("SQL ER AGE");

                String sql2 = "INSERT INTO main_malik_stock (name,poriman,date,koroch,kibabot) VALUES ('" + nam + "','" + x + "', '" + sqlD+ "','" + am + "', '" + XX + "');";

                statement.executeUpdate(sql2);

                System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");

            } else {

                try {
                    String newQuntity = "0";

                    // JOptionPane.showMessageDialog(null, "Not Same");
                    String sql2 = "INSERT INTO main_malik_stock (name,poriman,date,koroch,kibabot) VALUES ('" + nam + "','" + x + "', '" + sqlD + "','" + am + "', '" + XX + "');";

                    statement.executeUpdate(sql2);

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hogaxxx");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        //JOptionPane.showMessageDialog(null, "Bare Not Same");
        /**
         * *************?? Total Table??************************
         */
        try {
            String sqlx = "select * from main_malik_stock_all where name = '" + nam + "'";
            resultSet = statement.executeQuery(sqlx);

            if (resultSet.next()) {

                //    JOptionPane.showMessageDialog(null,"SAme");
                System.out.println("x");

                String a = resultSet.getString("poriman");
                //    String b = resultSet.getString("remain");
                double tempQ = Double.parseDouble(a);
                //  double tempD = Double.parseDouble(b);
                double tempQ2 = Double.parseDouble(am);

                totalQ = tempQ - tempQ2;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalQ);
                //    String newRemain=String.valueOf(totalR);
                System.out.println("SQL ER AGE");

                try {
                    //employee_id,name,fathername,designation,sex,salary,mobile,address,birthdate,joindate
                    String sqly = "update main_malik_stock_all set name = '" + nam + "', poriman = '" + newQuntity + "',date = '" + sqlD + "' where name= '" + nam + "'";

                    statement.executeUpdate(sqly);
                    System.out.println("Execue hoise");
                    //   JOptionPane.showMessageDialog(null, "Stuff Data Update Successfully Boss...!!");

                } catch (SQLException ex) {
                    //Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Something rong");
                    JOptionPane.showMessageDialog(null, "Don't Update This Item DataBase...!!");
                }

            } else {

                try {

                    //JOptionPane.showMessageDialog(null, "Not Same");
                    String sqlz = "INSERT INTO main_malik_stock_all (name,poriman,date) VALUES ('" + nam + "','" + am + "', '" +sqlD + "');";

                    statement.executeUpdate(sqlz);

                    System.out.println("Excute o Hoiseeeeeee!!!!!!!!!!!!!!!!!!");
                    // JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");

                } catch (SQLException ex) {
                    System.out.println("Boss Someting Rong Hoga");
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Catch");
        }

        JOptionPane.showMessageDialog(null, "Data Saved Sir.....!");
    
    
    
    }

    void mainMalikStockNewaHitTotalTk(String nam, String am, Date sqlD) {
  
    
        try {
            String sql = "select * from main_malik_stock where name = '" + nam + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {

                String name1 = "Md Joynal Abeedin";
                String name2 = "Md Sobuj Miah";
                String salary = " Newa ";
                String xx = "0";
                double c = 0;
                if (am.equals("") || am.equals("0.0")|| am.equals("")) {
                    System.out.println("OKKKKKK");
                    JOptionPane.showMessageDialog(null, "Tk Kome nai Maliker....\n\tTai Salary Dewa Jabe Na...");

                } else {

                  
                    String total = String.valueOf(am);
                    String sqlz = "INSERT INTO total_tk (name,date,joma,koroch,kibabot,knise) VALUES ('" + nam + "','" + sqlD + "', '" + xx + "', '" + am + "', '" + salary + "', '" + nam + "');";
                    System.out.println("total_tk_Salary");
                    statement.executeUpdate(sqlz);
                    }

            }else{
                JOptionPane.showMessageDialog(null,"E Nam Er Kuno Malik Nai......!\n\t Newa Jabe Na....!");
            }
        } catch (Exception e) {
        }
    
    
    
    }

    void SearchEmployeeByOneDateAndName(String name, String aD) {
        double totalK = 0;
        double bakiTk = 0;
        double bakiTkS = 0;
        double bakiTkA = 0;
        double totalTk = 0;

        double totalT = 0;
        int no = 1;
        
        String x="%"+aD+"%";
   
        AESalaryPage on = new AESalaryPage();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.emploeeTable.getModel();
        try {
            String sql = "select * from employee where name = '" + name + "' And date like'" + x + "'";
            // 
          //      String sql = "select * from daily_milar_koroch where  date >=  '" +fDate + "' And date<='" + tDate + "'";
          //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");

                String dat = resultSet.getString("date");
                String salary = resultSet.getString("salary");
                String advance = resultSet.getString("advance");
                String mSalary = resultSet.getString("main_salary");
                String podobi = resultSet.getString("podobi");
                String remark = resultSet.getString("remark");

                double tempMsalary = Double.parseDouble(mSalary);
                double tempA = Double.parseDouble(advance);
                double tempS = Double.parseDouble(salary);
                bakiTkS = bakiTkS + tempS;
                bakiTkA = bakiTkA + tempA;
                totalTk = tempS + tempA + totalTk;
                bakiTk = tempMsalary - totalTk;
                String totalS = String.valueOf(bakiTkS);
                String totalA = String.valueOf(bakiTkA);
                    // totalR=tempQ2+tempD;

                // String newG = String.valueOf(totalG);
                //  String newK = String.valueOf(totalK);
                AESalaryPage st = new AESalaryPage();

                Object rowData[] = {dat, salary, advance, remark};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.a.setText("Total Salary Nise = " + totalS);
                on.b.setText("Total Advance Nise = " + totalA);
                on.c.setText("Baki TK  =  " + bakiTk);
                on.d.setText("Main Salary Pay = " + mSalary);
                on.namL.setText("  Name :   "+nam);
                on.podobiL.setText("  Podobi :   "+podobi);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
                // on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }

    
    
    }

    void SearchEmployeeByTwoDateAndName(String name, String aD, String bD) {
    
        double totalK = 0;
        double bakiTk = 0;
        double bakiTkS = 0;
        double bakiTkA = 0;
        double totalTk = 0;

        double totalT = 0;
        int no = 1;
        
        String x="%"+aD+"%";
        String y="%"+bD+"%";
      
   
        AESalaryPage on = new AESalaryPage();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.emploeeTable.getModel();
        try {
            String sql = "select * from employee where name = '" + name + "' And date >=  '" +aD + "' And date<='" + bD + "'";
               
          //  String sql = "select * from employee where name = '" + name + "' And date like'" + x + "'";
            // 
          //      String sql = "select * from daily_milar_koroch where  date >=  '" +fDate + "' And date<='" + tDate + "'";
          //st.setPartner(id,a, Nm, gv, tn, date);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");

                String dat = resultSet.getString("date");
                String salary = resultSet.getString("salary");
                String advance = resultSet.getString("advance");
                String mSalary = resultSet.getString("main_salary");
                String podobi = resultSet.getString("podobi");
                String remark = resultSet.getString("remark");

                double tempMsalary = Double.parseDouble(mSalary);
                double tempA = Double.parseDouble(advance);
                double tempS = Double.parseDouble(salary);
                bakiTkS = bakiTkS + tempS;
                bakiTkA = bakiTkA + tempA;
                totalTk = tempS + tempA + totalTk;
                bakiTk = tempMsalary - totalTk;
                String totalS = String.valueOf(bakiTkS);
                String totalA = String.valueOf(bakiTkA);
                    // totalR=tempQ2+tempD;

                // String newG = String.valueOf(totalG);
                //  String newK = String.valueOf(totalK);
                AESalaryPage st = new AESalaryPage();

                Object rowData[] = {dat, salary, advance, remark};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.a.setText("Total Salary Nise =" + totalS);
                on.b.setText("Total Advance Nise = " + totalA);
                on.c.setText("Baki TK  =  " + bakiTk);
                on.d.setText("Main Salary Pay = " + mSalary);
                on.namL.setText("Name : "+nam);
                on.podobiL.setText("Podobi : "+podobi);
                // on.total.setText(newQuntity);
                // on.totalG.setText(newG);
                // on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);
        }

    
    
    
    //       
    }
///            String sql = "select * from customer where c_no = '" + name + "'";

    void SearchCustomerByOneDateAndName(String name, String aD) {
    
        if(name.equals("")){
        
        try {
            
            double totalG = 0;
            double totalK = 0;
            double totalR = 0;
            String x="%"+aD+"%";
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            
            try {
                System.out.println("OOOO");
                String sql = "select * from customer where  date like'" + x + "'";
                
                System.out.println("Start");
                //         String sql = "select * from customer where c_no = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("NISE Start");
                //
                while (resultSet.next()) {
                    System.out.println(" VITRAY Start");
                    //
                    //String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    String i = " ";
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    // st.setData(total);
                    //on.totalGivenField.setText(totalGiven);
                    // on.totalTakenField.setText(totalTaken);
                    // on.totalRemainField.setText(totalRemainTk);
                    // on.totalField.setText(total);
                    // on.productName.setText(pN);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

            
            
        } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
        
        }else{
        
        try {
            
            double totalG = 0;
            double totalK = 0;
            double totalR = 0;
            String x="%"+aD+"%";
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            
            try {
                System.out.println("OOOO");
                // String sql = "select * from customer where  date like'" + x + "'";
                
                String sql = "select * from customer where c_name = '" + name + "' And date like'" + x + "'";
                
                System.out.println("Start");
                //         String sql = "select * from customer where c_no = '" + name + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("NISE Start");
                //
                while (resultSet.next()) {
                    System.out.println(" VITRAY Start");
                    //
                    //String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    String i = " ";
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    // st.setData(total);
                    //on.totalGivenField.setText(totalGiven);
                    // on.totalTakenField.setText(totalTaken);
                    // on.totalRemainField.setText(totalRemainTk);
                    // on.totalField.setText(total);
                    // on.productName.setText(pN);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

            
            
        } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
        
        }
    
    
    
    }

    void SearchCustomerByTwoDateAndName(String name, String aD,String bD) {
    
    if(name.equals("")){
    
    
        try {
            
            
            double totalG = 0;
            double totalK = 0;
            double totalR = 0;
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            String x="%"+aD+"%";
            String y="%"+bD+"%";
            
            try {
                System.out.println("Start");
                
                
                String sql = "select * from customer where date >=  '" +aD + "' And date<='" + bD + "'";
                
                //    String sql = "select * from customer where c_name = '" + name + "' And date >=  '" +aD + "' And date<='" + bD + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    //String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    String i = " ";
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    // st.setData(total);
                    //on.totalGivenField.setText(totalGiven);
                    // on.totalTakenField.setText(totalTaken);
                    // on.totalRemainField.setText(totalRemainTk);
                    // on.totalField.setText(total);
                    // on.productName.setText(pN);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }else{
    
    
    
        try {
            
            
            
            double totalG = 0;
            double totalK = 0;
            double totalR = 0;
            
            CcustomerStock on = new CcustomerStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();
            String x="%"+aD+"%";
            String y="%"+bD+"%";
            
            try {
                System.out.println("Start");
                
                
                // String sql = "select * from customer where date >=  '" +aD + "' And date<='" + bD + "'";
                
                String sql = "select * from customer where c_name = '" + name + "' And date >=  '" +aD + "' And date<='" + bD + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    //String sId = resultSet.getString("id");
                    String a = resultSet.getString("c_no");
                    String b = resultSet.getString("c_name");
                    // String pN = b;
                    String c = resultSet.getString("joma");
                    double tempG = Double.parseDouble(c);
                    String d = resultSet.getString("date");
                    String e = resultSet.getString("poriman");
                    String f = resultSet.getString("dor");
                    String g = resultSet.getString("koroch");
                    double tempK = Double.parseDouble(g);
                    String h = resultSet.getString("kibabot");
                    /// double tempG = Double.parseDouble(c);
                    //  double tempT = Double.parseDouble(d);
                    totalG = totalG + tempG;
                    totalK = totalK + tempK;
                    totalR = totalG - totalK;
                    String i = " ";
                    ///   totalT = totalT + tempT;
                    //   double tempRemain = totalG - totalT;
                    ///    String totalRemainTk = String.valueOf(tempRemain);
                    String totalGoma = String.valueOf(totalG);
                    String totalKoroch = String.valueOf(totalK);
                    String totalRemain = String.valueOf(totalR);
                    //   String f = resultSet.getString("date");
                    //   g=g+et;
                    //  String total=String.valueOf(g);
                    
                    CcustomerStock st = new CcustomerStock();
                    
                    /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                    // st.findData(a,b,c,d,e,f);
                    Object rowData[] = {d, c, b, a, e, f, g, h, i};
                    m.addRow(rowData);
                    System.out.println("Query");
                    on.jomaField.setText(totalGoma);
                    on.korochField.setText(totalKoroch);
                    on.remainField.setText(totalRemain);
                    // st.setData(total);
                    //on.totalGivenField.setText(totalGiven);
                    // on.totalTakenField.setText(totalTaken);
                    // on.totalRemainField.setText(totalRemainTk);
                    // on.totalField.setText(total);
                    // on.productName.setText(pN);
                }
                
            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
    }

    void showSelectProductOneDate(String name, String aD) {

            String x="%"+aD+"%";
    
            String test = "0";
        if (name == test) {
            JOptionPane.showMessageDialog(null, "Sorry");
        } else {

            double totalG = 0;
            double totalT = 0;
            int no = 1;
            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
                String sql = "select * from mal_kinar_stock where p_name = '" + name + "' And date like'" + x + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                System.out.println("SQL er uporay");
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("SQL er nichay");
                while (resultSet.next()) {
                    //(p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip)
                    String id = resultSet.getString("id");
                    String p_nam = resultSet.getString("p_name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String c_nam = resultSet.getString("c_name");
                    String c_no = resultSet.getString("c_no");
                    String c_phone = resultSet.getString("c_phone");
                    String driver = resultSet.getString("driver");
                    String calanNo = resultSet.getString("calan_no");
                    String zip = resultSet.getString("zip");

                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);
                  
                    
                    totalT = totalT + tempQ;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    if(am!="0"){
                    
                        BtotalMalKinartStock st = new BtotalMalKinartStock();
                    System.out.println("Table  er uporay");
                    Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip, id};
                    m.addRow(rowData);
                
                    }
                    no++;
                    System.out.println("Table er nichay");
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalF.setText(newQuntity);
                    on.idL.setText(id);
                    on.f.setText(c_nam);
            
                 
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        }

    
    
    }

    void showSelectProductTwoDate(String name, String aD, String bD) {
    
      String x="%"+aD+"%";
        String y="%"+bD+"%";
      
    
            String test = "0";
        if (name == test) {
            JOptionPane.showMessageDialog(null, "Sorry");
        } else {

            double totalG = 0;
            double totalT = 0;
            int no = 1;
            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
                String sql = "select * from mal_kinar_stock where p_name = '" + name + "' And date >=  '" +aD + "' And date<='" + bD + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                System.out.println("SQL er uporay");
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("SQL er nichay");
                while (resultSet.next()) {
                    //(p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip)
                    String id = resultSet.getString("id");
                    String p_nam = resultSet.getString("p_name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String c_nam = resultSet.getString("c_name");
                    String c_no = resultSet.getString("c_no");
                    String c_phone = resultSet.getString("c_phone");
                    String driver = resultSet.getString("driver");
                    String calanNo = resultSet.getString("calan_no");
                    String zip = resultSet.getString("zip");

                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);
                  
                    
                    totalT = totalT + tempQ;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    if(am!="0"){
                    
                        BtotalMalKinartStock st = new BtotalMalKinartStock();
                    System.out.println("Table  er uporay");
                    Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip, id};
                    m.addRow(rowData);
                
                    }
                    no++;
                    System.out.println("Table er nichay");
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalF.setText(newQuntity);
                    on.idL.setText(id);
                    on.f.setText(c_nam);
            
                 
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        }

    }

    void showSelectProductOneDateALL(String name, String aD) {

                String x="%"+aD+"%";
    
            String test = "";
        if (name .equals("")) {
        
            double totalG = 0;
            double totalT = 0;
            int no = 1;
            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
           //     name = '" + name + "' And date like'" + x + "'";
                String sql = "select * from mal_kinar_stock where  date like'" + x + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                System.out.println("SQL er uporay");
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("SQL er nichay");
                while (resultSet.next()) {
                    //(p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip)
                    String id = resultSet.getString("id");
                    String p_nam = resultSet.getString("p_name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String c_nam = resultSet.getString("c_name");
                    String c_no = resultSet.getString("c_no");
                    String c_phone = resultSet.getString("c_phone");
                    String driver = resultSet.getString("driver");
                    String calanNo = resultSet.getString("calan_no");
                    String zip = resultSet.getString("zip");

                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);
                  
                    
                    totalT = totalT + tempQ;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    if(am!="0"){
                    
                        BtotalMalKinartStock st = new BtotalMalKinartStock();
                    System.out.println("Table  er uporay");
                    Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip, id};
                    m.addRow(rowData);
                
                    }
                    no++;
                    System.out.println("Table er nichay");
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalF.setText(newQuntity);
                    on.idL.setText(id);
                    on.f.setText(c_nam);
            
                 
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }   
        
        
        
        } else {

            double totalG = 0;
            double totalT = 0;
            int no = 1;
            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
           //     name = '" + name + "' And date like'" + x + "'";
                String sql = "select * from mal_kinar_stock where   p_name = '" + name + "' And date like'" + x + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                System.out.println("SQL er uporay");
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("SQL er nichay");
                while (resultSet.next()) {
                    //(p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip)
                    String id = resultSet.getString("id");
                    String p_nam = resultSet.getString("p_name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String c_nam = resultSet.getString("c_name");
                    String c_no = resultSet.getString("c_no");
                    String c_phone = resultSet.getString("c_phone");
                    String driver = resultSet.getString("driver");
                    String calanNo = resultSet.getString("calan_no");
                    String zip = resultSet.getString("zip");

                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);
                  
                    
                    totalT = totalT + tempQ;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    if(am!="0"){
                    
                        BtotalMalKinartStock st = new BtotalMalKinartStock();
                    System.out.println("Table  er uporay");
                    Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip, id};
                    m.addRow(rowData);
                
                    }
                    no++;
                    System.out.println("Table er nichay");
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalF.setText(newQuntity);
                    on.idL.setText(id);
                    on.f.setText(c_nam);
            
                 
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

        }

    
    
    }

    void showSelectProductTwoDateALL(String name, String aD, String bD) {
    
      String x="%"+aD+"%";
        String y="%"+bD+"%";
      
    
            String test = "";
        if (name.equals("")) {
            
            double totalG = 0;
            double totalT = 0;
            int no = 1;
            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
                String sql = "select * from mal_kinar_stock where  date >=  '" +aD + "' And date<='" + bD + "'";
                //  String sql = "select * from t where productname = '" + name + "'";
                System.out.println("SQL er uporay");
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("SQL er nichay");
                while (resultSet.next()) {
                    //(p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip)
                    String id = resultSet.getString("id");
                    String p_nam = resultSet.getString("p_name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String c_nam = resultSet.getString("c_name");
                    String c_no = resultSet.getString("c_no");
                    String c_phone = resultSet.getString("c_phone");
                    String driver = resultSet.getString("driver");
                    String calanNo = resultSet.getString("calan_no");
                    String zip = resultSet.getString("zip");

                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);
                  
                    
                    totalT = totalT + tempQ;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    if(am!="0"){
                    
                        BtotalMalKinartStock st = new BtotalMalKinartStock();
                    System.out.println("Table  er uporay");
                    Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip, id};
                    m.addRow(rowData);
                
                    }
                    no++;
                    System.out.println("Table er nichay");
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalF.setText(newQuntity);
                    on.idL.setText(id);
                    on.f.setText(c_nam);
            
                 
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

            
            
        } else {

            double totalG = 0;
            double totalT = 0;
            int no = 1;
            BtotalMalKinartStock on = new BtotalMalKinartStock();
            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.stockTable.getModel();

            try {
                String sql = "select * from mal_kinar_stock where  p_name = '" + name + "' And date >=  '" +aD + "' And date<='" + bD + "'";
                System.out.println("SQL er uporay");
                //st.setPartner(id,a, Nm, gv, tn, date);
                resultSet = statement.executeQuery(sql);
                System.out.println("SQL er nichay");
                while (resultSet.next()) {
                    //(p_name,poriman,date,c_name,c_no,c_phone,driver,calan_no,zip)
                    String id = resultSet.getString("id");
                    String p_nam = resultSet.getString("p_name");
                    String am = resultSet.getString("poriman");
                    String dat = resultSet.getString("date");
                    String c_nam = resultSet.getString("c_name");
                    String c_no = resultSet.getString("c_no");
                    String c_phone = resultSet.getString("c_phone");
                    String driver = resultSet.getString("driver");
                    String calanNo = resultSet.getString("calan_no");
                    String zip = resultSet.getString("zip");

                    double tempQ = Double.parseDouble(am);
                    //  double tempD = Double.parseDouble(b);
                    // double tempQ2 = Double.parseDouble(amount);
                  
                    
                    totalT = totalT + tempQ;
                    // totalR=tempQ2+tempD;
                    String newQuntity = String.valueOf(totalT);
                    if(am!="0"){
                    
                        BtotalMalKinartStock st = new BtotalMalKinartStock();
                    System.out.println("Table  er uporay");
                    Object rowData[] = {dat, p_nam, am, c_nam, c_no, c_phone, driver, calanNo, zip, id};
                    m.addRow(rowData);
                
                    }
                    no++;
                    System.out.println("Table er nichay");
                    System.out.println(" AtotalProductStock OKKKKKKK");
                    on.totalF.setText(newQuntity);
                    on.idL.setText(id);
                    on.f.setText(c_nam);
            
                 
                }

            } catch (SQLException ex) {
                System.out.println("ERROR: " + ex);
            }

    
    }

    
   

    }

    void SearchDataFromToTotal(String fDate, String tDate) {

if(tDate.equals("")){

            //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from total_tk where  date like  '" + x+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("joma");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");
                
                String kNise = resultSet.getString("knise");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot,kNise};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);
                on.jLabel1.setText("Mill's All Information");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }





}else{

            //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from total_tk where  date >=  '" +fDate + "' And date<='" + tDate+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("joma");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");
                
                String kNise = resultSet.getString("knise");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot,kNise};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);
                on.jLabel1.setText("Mill's All Information");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }





}    
    
    
    
    
    }

    void SearchDataALLTotal(String fDate, String tDate) {
            //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from total_tk";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("joma");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");
                
                String kNise = resultSet.getString("knise");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot,kNise};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);
                on.jLabel1.setText("Mill's All Information");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }



    
    
    }

    void SearchDataFromToTotalMalik(String fDate, String tDate, String name) {
    
    
     //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock where  name=  '" +name + "' And date >=  '" +fDate + "' And date<='" + tDate+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }


    
    
    
    }

    void SearchDataFromToTotal(String fDate, String tDate, String name) {

    
    
     //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String x="%"+fDate+"%";
   
        
        String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock where  date >=  '" +fDate + "' And date<='" + tDate+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }



    
    
    
    }

    void SearchFromToMalikOneDate(String fDate) {
   
    
        //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String x="%"+fDate+"%";
   
        
       // String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock where  date like  '" +fDate +  "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    
    
    }

    void showAllProductDSelectMalik(String x) {
        //x=name
    if(x.equals("")){
    
    
     //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
    //    String x="%"+fDate+"%";
   
        
      //  String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock ";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    
    
    }else{
    
    
     //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
    //    String x="%"+fDate+"%";
   
        
      //  String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock where  name='" + x+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    
    }
    
    
    }
    
    
    void ShowMalikDataFromOneDateAndName(String x, String y) {
    if(x.equals("")){
    
    
     //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String date="%"+y+"%";
   
        
   //     String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock where date like'" + date+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    
    
    
    }else{
    
    
     //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        String date="%"+y+"%";
   
        
   //     String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock where  name=  '" +x + "' And date like'" + date+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    
    
    }
    
    }
    
    
    
 void ShowMalikDataFromTwoDateAndName(String x, String y, String z) {
    
if(x.equals("")){
 
        //malikTable
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
        try {
            
          //  System.out.println("KKKK"+fDate+"  "+tDate);
            
             String sql = "select * from main_malik_stock where  date >=  '" +y + "' And date<='" + z+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }


       
    


}else{
        double totalK = 0;
        double totalG = 0;
        double totalT = 0;
        int no = 1;
        DAmalikerJomaKoroch on = new DAmalikerJomaKoroch();
        on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.malikTable.getModel();
        
     //   String x="%"+fDate+"%";
   
        
       // String y="%"+tDate+"%";
        try {
            
            System.out.println("KKKK");
            
             String sql = "select * from main_malik_stock where  name=  '" +x + "' And date >=  '" +y + "' And date<='" +z+ "'";
          
          // Strizxng sql = "select * from main_malik_stock where ";
            //  String sql = "select * from t where productname = '" + name + "'";
            //st.setPartner(id,a, Nm, gv, tn, date);
              
            System.out.println("KKKK11");
            
            resultSet = statement.executeQuery(sql);
            
            System.out.println("KKKK2222");
            
            while (resultSet.next()) {

            System.out.println("KKKK333");
            
                String id = resultSet.getString("id");
                String nam = resultSet.getString("name");
                String am = resultSet.getString("poriman");
                String dat = resultSet.getString("date");
                String koroch = resultSet.getString("koroch");
                String kibabot = resultSet.getString("kibabot");

                double tempG = Double.parseDouble(am);
                double tempK = Double.parseDouble(koroch);
                // double tempQ2 = Double.parseDouble(amount);
                totalG = totalG + tempG;
                totalK = totalK + tempK;
                totalT = totalG - totalK;
                // totalR=tempQ2+tempD;
                String newQuntity = String.valueOf(totalT);
                String newG = String.valueOf(totalG);
                String newK = String.valueOf(totalK);
                DAmalikerJomaKoroch st = new DAmalikerJomaKoroch();

                Object rowData[] = {dat, nam, am, koroch, kibabot};
                m.addRow(rowData);
                no++;
                System.out.println(" AtotalProductStock OKKKKKKK");
                on.total.setText(newQuntity);
                on.totalG.setText(newG);
                on.totalK.setText(newK);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR:  AtotalProductStock " + ex);
        }

    
    
    }  

}    

    void SearchEmployeeALL(String name, String aD, String bD) {
    AESalaryPage on=new AESalaryPage();
    on.setVisible(true);
        DefaultTableModel m = (DefaultTableModel) on.emploeeTable.getModel();

    
        
   //     JOptionPane.showMessageDialog(null,"oXk");
    
        if(bD.equals("")){
         try {
            
       String sql = "select * from employee where date like '" + aD + "'";
              
            // String sql = "select * from employeetable where  date >=  '" +aD + "' And date<='" +bD+ "'";
          
            //String sql = "select * from empl where employee_id = '" + ID + "'";
            //stuffId, firstName, lastName,designetion,dateOfBirth,sex,salary,mobile,presentAddress,permanentAddress,joinDate,email
            //String sql = "select * from employeetable where name = '" + ID + "'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String a = resultSet.getString("id");
                String Nm = resultSet.getString("name");
              //  String fm = resultSet.getString("fathername");
                String dgn = resultSet.getString("podobi");
                        String dt=resultSet.getString("date");
               // String sex = resultSet.getString("sex");
                String salary = resultSet.getString("salary");
              String Advance = resultSet.getString("advance");

                AESalaryPage st = new   AESalaryPage();
              //  st.setVisible(true);

            //    CcustomerStock st = new CcustomerStock();

                /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                // st.findData(a,b,c,d,e,f);
                Object rowData[] = {dt,salary,Advance,Nm};
                m.addRow(rowData);                
                /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                //        //st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm,motherNm,sex,classNm,year,section,birth,presentAddress,permanentAddress,addmitionDate,mobile,email);

            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);

        }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }else if(aD!="" && bD!=""){
   try {
            
             String sql = "select * from employee where  date >=  '" +aD + "' And date<='" + bD+ "'";
          
            // String sql = "select * from employeetable where  date >=  '" +aD + "' And date<='" +bD+ "'";
          
            //String sql = "select * from empl where employee_id = '" + ID + "'";
            //stuffId, firstName, lastName,designetion,dateOfBirth,sex,salary,mobile,presentAddress,permanentAddress,joinDate,email
            //String sql = "select * from employeetable where name = '" + ID + "'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String a = resultSet.getString("id");
                String Nm = resultSet.getString("name");
              //  String fm = resultSet.getString("fathername");
                String dgn = resultSet.getString("podobi");
                        String dt=resultSet.getString("date");
               // String sex = resultSet.getString("sex");
                String salary = resultSet.getString("salary");
              String Advance = resultSet.getString("advance");

                AESalaryPage st = new   AESalaryPage();
              //  st.setVisible(true);

            //    CcustomerStock st = new CcustomerStock();

                /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                // st.findData(a,b,c,d,e,f);
                Object rowData[] = {dt,salary,Advance,Nm};
                m.addRow(rowData);                
                /// st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm, motherNm, sex, classNm, year, section, birth, presentAddress, permanentAddress, addmitionDate, mobile, email);
                //        //st.searchInfo(SearchRoll, firstNm, lastNm, fatherNm,motherNm,sex,classNm,year,section,birth,presentAddress,permanentAddress,addmitionDate,mobile,email);

            }

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex);

        }
    
    }else{
    JOptionPane.showMessageDialog(null,"Xonnnnk2");
    
    }
    
    
    
    
    }

    void CusName() {
        try {
            System.out.println("OOO");
          //  String sqlz = "select * from customer"
                    
            String sql = "select * from customer ";
            System.out.println("PPPP");
            resultSet = statement.executeQuery(sql);
            System.out.println("PQQQQQQQQQQQ");

            while (resultSet.next()) {
                            System.out.println("SSSSSSSSSSSSSSPPPP");

            String Nm = resultSet.getString("c_name");
                
               System.out.println(Nm);
               CcustomerStock st = new  CcustomerStock();
            
            
               st.Arry.add(Nm);
               System.out.println("RESULT :  "+Nm);
              // st.setVisible(true);
          //  Object rowData[] = {Nm};
             //   st.add(Nm);                
                
            
            System.out.println("\n\t ADD ARRAY");
            }
            
             resultSet.close();
           statement.close();
            connection.close();
         CcustomerStock st = new  CcustomerStock();
            
            
             //  st.Arry.add(Nm);
               //System.out.println("RESULT :  "+Nm);
               st.setVisible(true);
          // 
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }

    void searcgMemeoID() {
                  //   cashMemo st = new cashMemo();
            cashMemo on = new cashMemo();

            on.setVisible(true);
            DefaultTableModel m = (DefaultTableModel) on.cashTable.getModel();
   
        try {
            String sql = "select * from memo_serial ";
            System.out.println("PPPP");
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                
            String Nm = resultSet.getString("serial_id");
            //    cashMemo st=new cashMemo();
                on.idF.setText(Nm);
                System.out.print("ID"+Nm);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    void changeMemoId(String sID) {
   
        try {
            String sql = "select * from memo_serial ";
            System.out.println("PPPP");
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                
            String Nm = resultSet.getString("serial_id");
        int x=Integer.parseInt(Nm);
        int y=x+1;
      String NewNm=String.valueOf(y);
            //    cashMemo st=new cashMemo();
               // on.idF.setText(Nm);
                System.out.print("ID"+Nm);
          //  String sql2="Insert INTO memo_serial (serial_id) VALUES ('" + NewNm + "');";
        //         String sql2 = "INSERT INTO main_malik_stock (name,poriman,date,koroch,kibabot) VALUES ('" + nam + "','" + x + "', '" + sqlD+ "','" + am + "', '" + XX + "');";
   String sql2 = "update memo_serial set serial_id = '" + NewNm +"' where serial_id= '" + sID + "'";

                statement.executeUpdate(sql2);

                    
                    }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }
    
    

}



