package com.ipl; public class Team {
private int teamID; private String teamName; private int teamMatches; private int teamWin; private int teamLoss;
public Team(int teamID, String teamName, int teamMatches, int teamWin, int teamLoss) {
super();
this.teamID = teamID; this.teamName = teamName; this.teamMatches = teamMatches; this.teamWin = teamWin; this.teamLoss = teamLoss;
}
public Team(String teamName, int teamMatches, int teamWin, int teamLoss) { super();
this.teamName = teamName; this.teamMatches = teamMatches;
 
this.teamWin = teamWin; this.teamLoss = teamLoss;
}
public Team() {
super();
// TODO Auto-generated constructor stub
}
public int getTeamID() { return teamID;
}
public void setTeamID(int teamID) { this.teamID = teamID;
}
public String getTeamName() { return teamName;
}
public void setTeamName(String teamName) { this.teamName = teamName;
}
public int getTeamMatches() { return teamMatches;
}
public void setTeamMatches(int teamMatches) { this.teamMatches = teamMatches;
}
public int getTeamWin() { return teamWin;
}
public void setTeamWin(int teamWin) { this.teamWin = teamWin;
}
public int getTeamLoss() { return teamLoss;
}
public void setTeamLoss(int teamLoss) { this.teamLoss = teamLoss;
}
@Override
public String toString() {
return "Team [teamID=" + teamID + ", teamName=" + teamName + ", teamMatches=" + teamMatches + ", teamWin="
+ teamWin + ", teamLoss=" + teamLoss + "]";
}
}