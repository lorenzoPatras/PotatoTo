package potatoto;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import model.CountdownTimer;
import view.TimerPreferences;

public class Underlayer extends AnchorPane {

  private MenuBar menuBar;
  private Menu menuLogOut;
  private Menu menuReport;
  private Menu menuTask;
  private Menu menuPref;
  
  private MenuItem logOutItem;
  private MenuItem timerItem;
  private MenuItem graphicReportItem;
  private MenuItem textReportItem;
  private MenuItem detailedTaskItem;
  private MenuItem timerPanelItem;
  private MenuItem preferencesItem;
  
  private ScreenManager screenManager;
  private CountdownTimer timer;

  public Underlayer(ScreenManager screenManager, CountdownTimer timer) {
    this.screenManager = screenManager;
    this.timer = timer;
    menuBar = new MenuBar();
   
    menuLogOut = new Menu("log out");
    menuReport = new Menu("report");
    menuTask = new Menu("potato");
    menuPref = new Menu("preferences");
    
    logOutItem = new MenuItem("log out");
    timerItem = new MenuItem("timer session");
    graphicReportItem = new MenuItem("graphic report");
    textReportItem = new MenuItem("text report");
    detailedTaskItem = new MenuItem("detailed task list");
    timerPanelItem = new MenuItem("potato");
    preferencesItem = new MenuItem("customize outlook");
    
    
    menuBar.getMenus().addAll(menuTask, menuReport, menuPref, menuLogOut);
    menuBar.setVisible(false);
    menuBar.setPrefWidth(300);
    
    menuLogOut.getItems().add(logOutItem);
    menuPref.getItems().addAll(timerItem, preferencesItem);
    menuReport.getItems().addAll(graphicReportItem, textReportItem);
    menuTask.getItems().addAll(timerPanelItem, detailedTaskItem);
    
    getChildren().add(screenManager);
    getChildren().add(menuBar);
    
    setMenuHandlers();
  }
  
  public MenuBar getMenuBar() {
    return menuBar;
  }
  
  private void setMenuHandlers() {
    logOutItem.setOnAction((ActionEvent t) -> {
      screenManager.setScreen(PotatoTo.loginID);
    });
    
    timerItem.setOnAction((ActionEvent t) -> {
      
      TimerPreferences timerPreferences = new TimerPreferences(timer);
      timerPreferences.setLayoutX(50);
      timerPreferences.setLayoutY(175);
      
      timerPreferences.toFront();
      
      getChildren().add(timerPreferences);
    });
    
    detailedTaskItem.setOnAction((ActionEvent t) -> {
      screenManager.setScreen(PotatoTo.taskID);
      
    });
    
    timerPanelItem.setOnAction((ActionEvent t) -> {
      screenManager.setScreen(PotatoTo.mainID);
    });
    
  }

}
