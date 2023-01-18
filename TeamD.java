package com.ipl;

import java.sql.Connection;
import java.sql.PreparedStatement; import java.sql.ResultSet;
import java.sql.Statement; public class TeamDao {
public static boolean insertTeamToDB(Team st){ boolean f = false;
try {
Connection con = CP.createC();
String q = "insert into ipldata(teamName,teamMatches,teamWin,teamLoss ) values(?,?,?,?)";
PreparedStatement pstmt = con.prepareStatement(q); pstmt.setString(1, st.getTeamName());
pstmt.setInt(2, st.getTeamMatches());
pstmt.setInt(3, st.getTeamWin()); pstmt.setInt(4, st.getTeamLoss());


pstmt.executeUpdate(); f=true;
}
catch(Exception e) {
e.printStackTrace();
}
return f;
}
public static boolean deleteTeam(String teamName) { boolean f = false;
try {
Connection con = CP.createC();
String q = "delete from ipldata where teamName=?"; PreparedStatement pstmt = con.prepareStatement(q);
 
pstmt.setString(1, teamName);

pstmt.executeUpdate(); f=true;
}
catch(Exception e) {
e.printStackTrace();
}
return f;

}
public static void showWins() {

 
try {
 

Connection con = CP.createC(); String q = "select*from ipldata";

Statement stmt = con.createStatement(); ResultSet set = stmt.executeQuery(q);

while(set.next()) {
int id = set.getInt(1);
String name = set.getString(2); int matches = set.getInt(3);
int wins = set.getInt(4); int losses = set.getInt(5);
 

System.out.println(id); System.out.println(name); System.out.println("matches: "+matches); System.out.println("wins: "+wins); System.out.println("losses: "+losses); System.out.println("+++++++++++++");
}
}
catch(Exception e) {
e.printStackTrace();
}

}
}
