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
public class DerbyUser {
    private static final String url="jdbc:derby://localhost:1527/Account;create=true";
    private String UserName;
    private String Password;
    Connection connection;
    private Statement statement;
    private boolean isConnected=false;
    private boolean isStateCreated=false;
    public DerbyUser(String un,String pswd){UserName=un;Password=pswd;}
    public boolean Connect(){
        if(!isConnected)
            try {
                connection=DriverManager.getConnection(url,"Test","123");
            } catch (SQLException ex) {
                Logger.getLogger(DerbyUser.class.getName()).log(Level.SEVERE, "Connection Failed", ex);
                isConnected=false;
                return false;
            } 
        return true;
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
            this.Insert("Test.Account","UserID","Username","Password",String.valueOf(ID),Quote(UserName,0),Quote(Password,0));
            
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
        public Statement getStatement(){
            return statement;
        }
}