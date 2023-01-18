package com.ipl;

import java.sql.Connection; import java.sql.DriverManager;

public class CP {

static Connection con;
 
public static Connection createC() {

try { Class.forName("com.mysql.jdbc.Driver"); String user = "root";
String password = "Password@21";
String url = "jdbc:mysql://localhost:3306/ipl";

con = DriverManager.getConnection(url,user,password);

}
catch(Exception e){
e.printStackTrace();
}

return con;
}
}


