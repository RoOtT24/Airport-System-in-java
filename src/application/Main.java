package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class Main extends Application {
	static ArrayList<Trip> arr = new ArrayList<>();
	static ArrayList<Passenger> arr2 = new ArrayList<>();
	Scene scene, scene2, scene3, scene4, scene5;

	@Override
	public void start(Stage primaryStage) {
		try {
			//////////////////////////////////////////////////////////////////////////////////////////////////
			Group root = new Group();

			Button b1 = new Button("New Trip");
			b1.setLayoutX(690);
			b1.setLayoutY(40);
			b1.setPrefSize(200, 100);

			b1.setFont(Font.font("New Trip", FontPosture.ITALIC, 25));
			b1.setTextFill(Color.DARKCYAN);

			Button b2 = new Button("New Passenger");
			b2.setLayoutX(690);
			b2.setLayoutY(150);
			b2.setPrefSize(200, 100);

			b2.setFont(Font.font("New Passenger", FontPosture.ITALIC, 25));
			b2.setTextFill(Color.DARKCYAN);

			Button b3 = new Button("Reserve");
			b3.setLayoutX(690);
			b3.setLayoutY(260);
			b3.setPrefSize(200, 100);

			b3.setFont(Font.font("Reserve", FontPosture.ITALIC, 25));
			b3.setTextFill(Color.DARKCYAN);

			Button b4 = new Button("Search");
			b4.setLayoutX(690);
			b4.setLayoutY(370);
			b4.setPrefSize(200, 100);

			b4.setFont(Font.font("Search", FontPosture.ITALIC, 25));
			b4.setTextFill(Color.DARKCYAN);
			
			Label lResult = new Label();
			lResult.setLayoutX(100) ;
			lResult.setLayoutY(100) ;
			lResult.setFont(Font.font(null ,FontPosture.ITALIC, 25));

			root.getChildren().addAll(b1, b2, b3, b4,lResult);
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////

			Group root2 = new Group();

			scene2 = new Scene(root2, 900, 400);
			scene2.setFill(Color.ALICEBLUE);

			b1.setOnAction(e -> primaryStage.setScene(scene2));

			Label l_1 = new Label("Trip Number:");
			l_1.setLayoutX(20);
			l_1.setLayoutY(50);
			l_1.setFont(Font.font("Trip Number:", FontPosture.REGULAR, 25));

			TextField txt1 = new TextField();
			txt1.setLayoutX(190);
			txt1.setLayoutY(58);
			txt1.setPrefSize(160, 20);

			Button b = new Button("Back");
			b.setLayoutX(840);
			b.setLayoutY(5);
			b.setPrefSize(50, 50);
			b.setOnAction(e -> primaryStage.setScene(scene));
			b.setTextFill(Color.BLUE);

			Label l_2 = new Label("From:");
			l_2.setLayoutX(80);
			l_2.setLayoutY(150);
			l_2.setFont(Font.font("From:", FontPosture.REGULAR, 25));

			TextField txt2 = new TextField();
			txt2.setLayoutX(190);
			txt2.setLayoutY(158);
			txt2.setPrefSize(160, 20);

			Label l_3 = new Label("To:");
			l_3.setLayoutX(80);
			l_3.setLayoutY(240);
			l_3.setFont(Font.font("To:", FontPosture.REGULAR, 25));

			TextField txt3 = new TextField();
			txt3.setLayoutX(190);
			txt3.setLayoutY(249);
			txt3.setPrefSize(160, 20);

			Label l_4 = new Label("Trip Date:");
			l_4.setLayoutX(60);
			l_4.setLayoutY(330);
			l_4.setFont(Font.font("Trip Date:", FontPosture.REGULAR, 25));

			TextField txt4 = new TextField();
			txt4.setLayoutX(190);
			txt4.setLayoutY(340);
			txt4.setPrefSize(160, 20);

			Button AddT = new Button("Add");
			AddT.setLayoutX(840);
			AddT.setLayoutY(340);
			AddT.setPrefSize(50, 50);
			AddT.setTextFill(Color.BLACK);

			AddT.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (AddT.isArmed()) {
						String[] str = txt4.getText().trim().split("/");
						//System.out.println(str[0]+ "    " );
						@SuppressWarnings("deprecation")
						Date d = new Date(Integer.parseInt(str[2]), Integer.parseInt(str[1]), Integer.parseInt(str[0]));
						arr.add(new Trip(txt1.getText().trim(), txt2.getText().trim(), txt3.getText().trim(), d));
						//System.out.println(arr.get(arr.size() - 1));
						lResult.setText("New Trip is Added") ;
						primaryStage.setScene(scene);
					}
				}
			});

			root2.getChildren().addAll(l_1, txt1, b, l_2, txt2, l_3, txt3, l_4, txt4, AddT);
			/////////////////////////////////////////////////////////////////////////////////////////////////

			Group root3 = new Group();

			scene3 = new Scene(root3, 900, 400);
			scene3.setFill(Color.ALICEBLUE);

			b2.setOnAction(e -> primaryStage.setScene(scene3));

			Button AddP = new Button("Add");
			AddP.setLayoutX(840);
			AddP.setLayoutY(340);
			AddP.setPrefSize(50, 50);
			AddP.setTextFill(Color.BLACK);

			Button bB = new Button("Back");
			bB.setLayoutX(840);
			bB.setLayoutY(5);
			bB.setPrefSize(50, 50);
			bB.setTextFill(Color.BLUE);

			bB.setOnAction(e -> primaryStage.setScene(scene));

			Label L1 = new Label("Passenger Name:");
			L1.setLayoutX(20);
			L1.setLayoutY(50);
			L1.setFont(Font.font("Passenger Name:", FontPosture.REGULAR, 25));

			TextField Txt1 = new TextField();
			Txt1.setLayoutX(240);
			Txt1.setLayoutY(58);
			Txt1.setPrefSize(160, 20);

			Label L2 = new Label("passport:");
			L2.setLayoutX(20);
			L2.setLayoutY(170);
			L2.setFont(Font.font("passport:", FontPosture.REGULAR, 25));

			TextField Txt2 = new TextField();
			Txt2.setLayoutX(240);
			Txt2.setLayoutY(178);
			Txt2.setPrefSize(160, 20);

			Label L3 = new Label("seatPref:");
			L3.setLayoutX(20);
			L3.setLayoutY(290);
			L3.setFont(Font.font("seatPref:", FontPosture.REGULAR, 25));

			TextField Txt3 = new TextField();
			Txt3.setLayoutX(240);
			Txt3.setLayoutY(298);
			Txt3.setPrefSize(160, 20);

			AddP.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (AddP.isArmed()) {
						arr2.add(new Passenger(Txt1.getText().trim(), Integer.parseInt(Txt2.getText().trim()),
								Integer.parseInt(Txt3.getText().trim())));
						//System.out.println(arr2.get(arr2.size()-1));
						lResult.setText("new Passenger is aadded" );
						primaryStage.setScene(scene) ;

					}
				}
			});

			root3.getChildren().addAll(AddP, bB, L1, Txt1, L2, Txt2, L3, Txt3);
			///////////////////////////////////////////////////////////////////////////////////////

			Group root4 = new Group();

			scene4 = new Scene(root4, 900, 400);
			scene4.setFill(Color.ALICEBLUE);

			b3.setOnAction(e -> primaryStage.setScene(scene4));

			Button bR = new Button("Back");
			bR.setLayoutX(840);
			bR.setLayoutY(5);
			bR.setPrefSize(50, 50);

			bR.setOnAction(e -> primaryStage.setScene(scene));
			bR.setTextFill(Color.BLUE);

			Button AddR = new Button("Add");
			AddR.setLayoutX(840);
			AddR.setLayoutY(340);
			AddR.setPrefSize(50, 50);
			AddR.setTextFill(Color.BLACK);

			Label LR1 = new Label("The Passenger ID:");
			LR1.setLayoutX(20);
			LR1.setLayoutY(50);
			LR1.setFont(Font.font("The Passenger ID:", FontPosture.REGULAR, 25));

			TextField TxtR = new TextField();
			TxtR.setLayoutX(240);
			TxtR.setLayoutY(55);
			TxtR.setPrefSize(160, 20);

			Label LR2 = new Label("seat Number:");
			LR2.setLayoutX(20);
			LR2.setLayoutY(250);
			LR2.setFont(Font.font("seat number:", FontPosture.REGULAR, 25));

			TextField TxtR2 = new TextField();
			TxtR2.setLayoutX(240);
			TxtR2.setLayoutY(256);
			TxtR2.setPrefSize(160, 20);

			Label LR3 = new Label("Trip Number:");
			LR3.setLayoutX(20);
			LR3.setLayoutY(150);
			LR3.setFont(Font.font("Trip Number:", FontPosture.REGULAR, 25));

			TextField TxtR3 = new TextField();
			TxtR3.setLayoutX(240);
			TxtR3.setLayoutY(156);
			TxtR3.setPrefSize(160, 20);

			AddR.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Passenger x = new Passenger();
					if (AddR.isArmed()) {
						for (int L = 0; L < arr2.size(); L++) {
							if (Integer.parseInt(TxtR.getText().trim()) == arr2.get(L).getPassport()) {
								x = arr2.get(L);
								break ;
							}}
System.out.println(x);
							for (int i = 0; i < arr.size(); i++) {
								if (TxtR3.getText().trim().equalsIgnoreCase(arr.get(i).getTripNum().trim())) {
									if (arr.get(i).isSeatEmpty(TxtR2.getText().trim())) {
										arr.get(i).getSeat(TxtR2.getText().trim()).setPassenger(x);
										lResult.setText(x.getName()+" was added to seat "+TxtR2.getText().trim()+" in the flight number "+TxtR3.getText().trim());
										lResult.setFont(Font.font(20));
										primaryStage.setScene(scene) ;
										break ;
									}
								}
							}
						
					}
				}
			});

			root4.getChildren().addAll(bR, AddR, LR1, TxtR, LR2, TxtR2, LR3, TxtR3);
			/////////////////////////////////////////////////////////////////////////////////////////////////

			Group root5 = new Group();

			scene5 = new Scene(root5, 900, 400);
			scene5.setFill(Color.ALICEBLUE);

			b4.setOnAction(e -> primaryStage.setScene(scene5));

			Label l3 = new Label();
			l3.setLayoutX(100);
			l3.setLayoutY(170);
		//	l3.setFont(Font.font("", FontPosture.REGULAR, 30));

			Label l2 = new Label("Trip Number:");
			l2.setLayoutX(20);
			l2.setLayoutY(90);
			l2.setFont(Font.font("Trip Number:", FontPosture.REGULAR, 25));

			TextField TXT2 = new TextField();
			TXT2.setLayoutX(240);
			TXT2.setLayoutY(98);
			TXT2.setPrefSize(160, 20);

			Label l4 = new Label("Seat Number:");
			l4.setLayoutX(20);
			l4.setLayoutY(290);
			l4.setFont(Font.font("Seat Number:", FontPosture.REGULAR, 25));

			TextField TXT4 = new TextField();
			TXT4.setLayoutX(240);
			TXT4.setLayoutY(298);
			TXT4.setPrefSize(160, 20);

			Button bS = new Button("Back");
			bS.setLayoutX(840);
			bS.setLayoutY(5);
			bS.setPrefSize(50, 50);

			bS.setOnAction(e -> primaryStage.setScene(scene));
			bS.setTextFill(Color.BLUE);

			Button AddS = new Button("Search");
			AddS.setLayoutX(810);
			AddS.setLayoutY(340);
			AddS.setPrefSize(80, 50);
			AddS.setTextFill(Color.BLACK);

			AddS.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (AddS.isArmed()) {

						for (int i = 0; i < arr.size(); i++) 
							if (TXT2.getText().trim().equalsIgnoreCase(arr.get(i).getTripNum().trim()) && arr.get(i).getSeat(TXT4.getText().trim()).getPassenger() != null) {
								l3.setText(arr.get(i).getSeat(TXT4.getText().trim()).getPassenger().toString());
							}
					}
							}
			});

			root5.getChildren().addAll(l2, TXT2, l3, bS, AddS, l4, TXT4);
			//////////////////////////////////////////////////////////////////////////////////////////////

			Image image = new Image("file:zero.jpg");
			ImageView iv = new ImageView();
			iv.setImage(image);
			root.getChildren().addAll(iv);
			iv.setFitHeight(600);
			iv.setFitWidth(685);

			scene = new Scene(root, 900, 500);
			scene.setFill(Color.ALICEBLUE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Project_0");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
		File f = new File("trips.txt");
		Scanner input = new Scanner(f);
		while (input.hasNextLine()) {

			String[] str = input.nextLine().trim().split("/");

			String[] strD = str[3].trim().split("-");

			@SuppressWarnings("deprecation")
			Date d = new Date(Integer.parseInt(strD[2]) - 1900, Integer.parseInt(strD[1]) - 1,
					Integer.parseInt(strD[0]));

			try {
				arr.add(new Trip(str[0], str[1], str[2], d));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		input.close();

		File f2 = new File("passengers.txt");
		input = new Scanner(f2);
		while (input.hasNextLine()) {

			String[] str2 = input.nextLine().trim().split("/");

			int seatPref = 2;
			if (str2[3].charAt(0) == 'A' || str2[3].charAt(0) == 'F')
				seatPref = 0;
			else if (str2[3].charAt(0) == 'C' || str2[3].charAt(0) == 'D')
				seatPref = 1;

			arr2.add(new Passenger(str2[1], Integer.parseInt(str2[2]), seatPref));

			for (int i = 0; i < arr.size(); i++) {
				if (str2[0].equalsIgnoreCase(arr.get(i).getTripNum())) {
					arr.get(i).reserveSeat(str2[3], arr2.get((arr2.size() - 1)) );
//					System.out.println(arr2.get(arr2.size() -1));
				//	System.out.println(arr2.get((arr2.size() - 1)));
				}

			}

		}
		input.close();
		launch(args);

		
		FileWriter fw = new FileWriter("print.txt");
		for (int i = 0; i < arr.size(); i++) {					
			//fw.write("----------------------------------------------------------------------\n");
			fw.write(arr.get(i).getTripNum()+"\n") ;
			//Arrays.sort(arr.get(i).getSeat());
			for(int j = 1 ; j < arr.get(i).getSeat().length ; ++j)
				for(int k = 0 ; k < arr.get(i).getSeat()[j].length; ++k) {
					
			fw.write(arr.get(i).getSeat()[j][k].getPassenger()!= null ? arr.get(i).getSeat()[j][k].toString()+"\n" : "");
			}
			fw.write("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
}
		fw.flush();
		fw.close();


	}
}