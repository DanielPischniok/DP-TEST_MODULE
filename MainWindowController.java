package de.studium.db.projekt.Datenbankprojekt.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import de.studium.db.projekt.Datenbankprojekt.fk.DateAxis;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class MainWindowController implements Initializable{
	
	@FXML
	private AnchorPane rightContent;
	
	@FXML
	private SplitPane splitPane;
	
	@FXML
	private LineChart<Date, Number> lineChart;

	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<XYChart.Series<Date, Number>> series = FXCollections.observableArrayList();
		 
		ObservableList<XYChart.Data<Date, Number>> series1Data = FXCollections.observableArrayList();
		series1Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 8, 53, 23).getTime(), 1));
		series1Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 10, 43, 23).getTime(), 1));
		
		ObservableList<XYChart.Data<Date, Number>> series4Data = FXCollections.observableArrayList();
		series4Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 11, 53, 23).getTime(), 1));
		series4Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 12, 43, 23).getTime(), 1));
		
		ObservableList<XYChart.Data<Date, Number>> series5Data = FXCollections.observableArrayList();
		series5Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 13, 53, 23).getTime(), 1));
		series5Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 14, 43, 23).getTime(), 1));
		 
		ObservableList<XYChart.Data<Date, Number>> series2Data = FXCollections.observableArrayList();
		series2Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 13, 53, 23).getTime(), 3));
		series2Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 15, 53, 23).getTime(), 3));
		
		ObservableList<XYChart.Data<Date, Number>> series3Data = FXCollections.observableArrayList();
		series3Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 17, 53, 23).getTime(), 1));
		series3Data.add(new XYChart.Data<Date, Number>(new GregorianCalendar(2016, 1, 2, 18, 53, 23).getTime(), 1));
		
		
		XYChart.Series<Date, Number> serie = new XYChart.Series<>("Ping", series1Data);
//		serie.chartProperty().get().setStyle("-fx-stroke-width: 30px; -fx-effect: null;");
//		serie.nodeProperty().get().setStyle("-fx-stroke-width: 30px; -fx-effect: null;"); 
		series.add(serie);
		series.add(new XYChart.Series<>("Check", series2Data));
		series.add(new XYChart.Series<>("Ping", series3Data));
		series.add(new XYChart.Series<>("Ping", series4Data));
		series.add(new XYChart.Series<>("Ping", series5Data));
		 
		NumberAxis numberAxis = new NumberAxis(1, 4, 2);
		numberAxis.setAutoRanging(true);
		numberAxis.setVisible(false);
		DateAxis dateAxis = new DateAxis();
		System.out.println("Linechart");
		lineChart = new LineChart<>(dateAxis, numberAxis, series);
		lineChart.setMaxHeight(250);
		lineChart.setMinWidth(500);
		lineChart.setStyle("-fx-stroke-width: 10px; -fx-effect: null;");
		rightContent.getChildren().clear();
		rightContent.getChildren().add(lineChart);
		}
	
	public void closeApplication(){
		Platform.exit();
		System.exit(0);
	}
	
	public void loadBezirkeView() throws IOException{
		String fxmlFile = "/fxml/Bezirke.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        splitPane.getItems().set(1, rootNode);
	}
	
	public void loadBehoerdeView() throws IOException{
		String fxmlFile = "/fxml/Behoerden.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        splitPane.getItems().set(1, rootNode);
	}
	
	public void loadPersonenView() throws IOException{
		String fxmlFile = "/fxml/Personen.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        splitPane.getItems().set(1, rootNode);
	}

}
