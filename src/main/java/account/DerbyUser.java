/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author w1505
 */
//0 will be return if success
//1 means the dublicate problem
//2 As a public code of connection failure.
//3 tells issues inside
public class DerbyUser {
    //make embedded
    private static final String url="jdbc:derby:Account_Ebd; create=true";
    //private static final String url="jdbc:derby://localhost:1527/Account;create=true";
    //private static final String DerbyUserName="Test";
    //private static final String DerbyUserPassword="123";
    private String UserName;
    private String Password;
    Connection connection;
    private Statement statement;
    private boolean isConnected=false;
    private boolean isStateCreated=false;
    
    public DerbyUser(String un,String pswd){UserName=un;Password=pswd;}
    //Only the register need to input these actually, so the below one is still ok.
    public DerbyUser(){}
    public void Recheck() throws SQLException{
        ResultSet rs;
        if(Connect()&&StatementCreate()){
            //Select password from account where userid=...
            rs=statement.executeQuery("Select password,username,progress,level from account where userid="+String.valueOf(User.UserID));
            rs.next();
            this.Password=rs.getString(1);
            this.UserName=rs.getString(2);
            User.UserName=this.UserName;
            User.Password=this.Password;
            User.Progress=rs.getInt(3);
            User.Level=rs.getInt(4);
        }
    }
    public boolean Connect(){
        if(!isConnected)
            try {
                try {
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DerbyUser.class.getName()).log(Level.SEVERE, "Can not find the embeddedDriver, please check the integrity", ex);
                    }
                    //connection=DriverManager.getConnection(url,DerbyUserName,DerbyUserPassword);
                connection=DriverManager.getConnection("jdbc:derby:Account_Ebd");
                } catch (SQLException ex) {
                    Logger.getLogger(DerbyUser.class.getName()).log(Level.SEVERE, "Connection Failed", ex);
                    isConnected=false;
                    return false;
                } 
            /*
            catch (ClassNotFoundException ex) {
            Logger.getLogger(DerbyUser.class.getName()).log(Level.SEVERE, "Driver not found", ex);
        } */
        return true;
    }
    public void Disconnect(){
            try {
                connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DerbyUser.class.getName()).log(Level.SEVERE, "Failed to disconnect, please check the current state", ex);
        }
    }
    public boolean StatementCreate(){
        try {
            if(connection.isValid(500)){
                isConnected=true;
                if(!isStateCreated)
                    statement=connection.createStatement();
                    isStateCreated=true;
                }
            } catch (SQLException ex) {
            isConnected=false;
            Logger.getLogger(DerbyUser.class.getName()).log(Level.SEVERE, "Connection Failed", ex);
            return false;
        }
    return true;
    }
        
    private void Insert(String... s) throws Exception{
        String st="";
        /*if(s.length/2==(s.length/2)*2)
            throw new Exception("Wrong Input");
        else*/
        if(isStateCreated){
            st="INSERT INTO ";
            int i=0;
            for(String element:s){
                st+=element;
                if(i==0)
                    st+="(";
                else
                    if(i!=s.length/2&&i<s.length-1)
                        st+=",";
                else
                    if(i==s.length/2)
                        st+=")VALUES (";
                i++;
            }
            st+=")";
            statement.executeUpdate(st);
        }
        else
            throw new Exception("State Failed"+",Code:"+st+",isStateCreated="+isStateCreated);
    }
    //Register with this at a quick speed.
    public int Register() throws SQLException{
        ResultSet rs;
        if(Connect()&&StatementCreate()){
                rs = statement.executeQuery("select count(username) from account where username='"+UserName+"'");
                rs.next();
                if(rs.getInt(1)!=0)
                    return 1;
            }
        else
            return 2;
            rs=statement.executeQuery("Select count(*) from ACCOUNT");
            rs.next();
            //Create ID
            int ID=10001+rs.getInt(1);
        try {
            this.Insert("Account","UserID","Username","Password",String.valueOf(ID),Quote(UserName,0),Quote(Password,0));
        } catch (Exception ex) {
            Logger.getLogger(DerbyUser.class.getName()).log(Level.SEVERE, "Error occurs while adding", ex);
            return 3;}
            return 0;
         }
        public String Quote(String n,int m){
        switch(m){
            case 0:return "'"+n+"'";
            default:return "\""+n+"\"";
        }
    }
        public int UpdateData(String TableName,String Column,String Content) throws SQLException{
            ResultSet rs;
            if(Connect()&&StatementCreate()){
                //Update Account set password='123456' where userid=123
                statement.executeUpdate("Update "+TableName+" set "+Column+"='"+Content+"' where userid="+User.UserID);
            }else
                return 2;
                return 0;
        }
        public int UpdateData(String TableName,String Column,int Content) throws SQLException{
            ResultSet rs;
            if(Connect()&&StatementCreate()){
                //Update Account set password='123456' where userid=123
                statement.executeUpdate("Update "+TableName+" set "+Column+"="+String.valueOf(Content)+" where userid="+User.UserID);
            }else
                return 2;
                return 0;
        }
        public int UpdateData(int progress, int level) throws SQLException{
            if(Connect()&&StatementCreate()){
                //Update Account set password='123456' where userid=123
                statement.executeUpdate("Update Account set progress="+String.valueOf(progress)+",level="+String.valueOf(level)+" where userid="+String.valueOf(User.UserID));
            }else
                return 2;
                return 0;
        }
        public Statement getStatement(){
            return statement;
        }
}