package application;

import java.sql.Connection; import java.sql.ResultSet; import java.sql.Statement; import java.util.Scanner; import com.ipl.*;

import javafx.application.Application; import javafx.event.ActionEvent; import javafx.event.EventHandler; import javafx.geometry.Insets; import javafx.geometry.Pos;
import javafx.stage.Stage; import javafx.scene.Scene;
import javafx.scene.chart.BarChart; import javafx.scene.chart.CategoryAxis; import javafx.scene.chart.NumberAxis; import javafx.scene.chart.XYChart; import javafx.scene.control.Button; import javafx.scene.control.Label; import javafx.scene.control.TextField; import javafx.scene.image.Image; import javafx.scene.image.ImageView; import javafx.scene.layout.BorderPane; import javafx.scene.layout.GridPane; import javafx.scene.layout.StackPane; import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application { @Override
 
public void start(Stage primaryStage) { try {
primaryStage.setTitle("IPL data");

GridPane grid = new GridPane(); grid.setAlignment(Pos.CENTER); grid.setHgap(10); grid.setVgap(10);
grid.setPadding(new Insets(25, 25, 25, 25)); Scene scene = new Scene(grid,1200,700);

scene.getStylesheets().add(getClass().getResource("application.css").toExternalFor m());
primaryStage.setScene(scene);

String s= "https://pbs.twimg.com/profile_images/1304292122686713857/lrp_AtSy_400x400.jp g";

20));
 
ImageView i = new ImageView(s); i.setFitHeight(100); i.setFitWidth(100);
grid.add(i, 2,3);
Label scenetitle = new Label("IPL database"); scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,

grid.add(scenetitle, 0, 0, 2, 1);

Label name = new Label("enter team name: "); grid.add(name, 0, 1);
TextField nametxt = new TextField(); grid.add(nametxt, 1, 1);
Label matches = new Label("enter matches: "); grid.add(matches, 0, 2);
TextField matchestxt = new TextField(); grid.add(matchestxt, 1, 2);
Label wins = new Label("Enter wins: "); grid.add(wins, 0, 3);
TextField winstxt = new TextField(); grid.add(winstxt, 1, 3);
Label losses = new Label("Enter Losses: "); grid.add(losses, 0, 4);
TextField losstxt = new TextField(); grid.add(losstxt, 1, 4);
Button btn1 = new Button("Submit");
 
btn1.setStyle("-fx-background-color: #00FF00; "); grid.add(btn1, 0, 5);
Label delID = new Label("Enter Name to delete"); grid.add(delID,0,10);
TextField Deltxt = new TextField(); grid.add(Deltxt, 1,10);
Button btn2 = new Button("Delete"); btn2.setStyle("-fx-background-color: #FF0000; "); grid.add(btn2, 0,11);
Button btn3 = new Button("Show matches"); btn3.setStyle("-fx-background-color: #008080; ");
grid.add(btn3, 0, 20);
Button btn4 = new Button("Show wins"); btn4.setStyle("-fx-background-color: #008080; ");
grid.add(btn4, 1, 20);
Button btn5 = new Button("Show Losses"); btn5.setStyle("-fx-background-color: #008080; ");
grid.add(btn5, 2, 20); primaryStage.show();

btn1.setOnAction(e -> { Team t = new
Team(nametxt.getText(),Integer.parseInt(matchestxt.getText()),Integer.parseInt(winst xt.getText()),Integer.parseInt(losstxt.getText()));
boolean answer = TeamDao.insertTeamToDB(t); if(answer) {
System.out.println("Team added!");
 
}
else {

}
 
System.out.println("Team not added!");
 
System.out.println(t);
});

btn2.setOnAction(e -> {
String c = Deltxt.getText();
boolean f =TeamDao.deleteTeam(c); if(f) {

});
 
}
else {

}
 
System.out.println("deleted!");

System.out.println("wrong!");
 
btn3.setOnAction(e ->{
CategoryAxis xaxis= new CategoryAxis(); NumberAxis yaxis = new NumberAxis(0,15,1); xaxis.setLabel("Teams"); yaxis.setLabel("Matches");

BarChart<String,Integer> bar = new BarChart(xaxis,yaxis); bar.setTitle("Matches");

XYChart.Series<>();
 
XYChart.Series<String,Integer> series = new

try {
Connection con = CP.createC(); String q = "select*from ipldata";

Statement stmt = con.createStatement(); ResultSet set = stmt.executeQuery(q);

while(set.next()) {
int id = set.getInt(1);
String tname = set.getString(2); int tmatches = set.getInt(3);
 
XYChart.Data(tname,tmatches));
}
 
series.getData().add(new
 
bar.getData().add(series);

grid.add(bar, 0, 22);
}
catch(Exception ee) {
ee.printStackTrace();
}
});

btn4.setOnAction(e ->{
CategoryAxis xaxis= new CategoryAxis(); NumberAxis yaxis = new NumberAxis(0,15,1); xaxis.setLabel("Teams"); yaxis.setLabel("Wins");

BarChart<String,Integer> bar = new BarChart(xaxis,yaxis);
 
bar.setTitle("Wins");

XYChart.Series<>();
 
XYChart.Series<String,Integer> series = new

try {
Connection con = CP.createC(); String q = "select*from ipldata";

Statement stmt = con.createStatement(); ResultSet set = stmt.executeQuery(q);

while(set.next()) {
int id = set.getInt(1);
String tname = set.getString(2); int twins = set.getInt(4);
 
XYChart.Data(tname,twins));
}
 
series.getData().add(new
 
bar.getData().add(series);

grid.add(bar, 1, 22);
}
catch(Exception ee) {
ee.printStackTrace();
}
});

btn5.setOnAction(e ->{
CategoryAxis xaxis= new CategoryAxis(); NumberAxis yaxis = new NumberAxis(0,15,1); xaxis.setLabel("Teams"); yaxis.setLabel("Losses");

BarChart<String,Integer> bar = new BarChart(xaxis,yaxis); bar.setTitle("Losses");

XYChart.Series<>();
 
XYChart.Series<String,Integer> series = new

try {
Connection con = CP.createC(); String q = "select*from ipldata";
 
Statement stmt = con.createStatement(); ResultSet set = stmt.executeQuery(q);

while(set.next()) {
int id = set.getInt(1);
String tname = set.getString(2); int tlosses = set.getInt(5);

series.getData().add(new
XYChart.Data(tname,tlosses));
}

bar.getData().add(series);

grid.add(bar, 2, 22);
}
catch(Exception ee) {
ee.printStackTrace();
}
});

} catch(Exception e) {
e.printStackTrace();
}
}

public static void main(String[] args) { launch(args);
}
}
