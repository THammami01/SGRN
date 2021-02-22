package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.models.DB;
import main.useful.Dialog;
import main.useful.Lang;

public class Main extends Application {
	public static Stage primaryStage;
	public static final String docsDir = "C:\\ISLAIB\\SGRN\\Documents\\";
	public static final String backupsDir = "C:\\ISLAIB\\SGRN\\BackUps\\";

	@Override
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage = primaryStage;
		if (!DB.connected)
			Dialog.informDBErrorAndQuit();

		Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));

		primaryStage.setTitle(Lang.getEquiv("SG des Relevés de Notes"));
		primaryStage.getIcons().add(new Image("icon.png"));
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.setMinWidth(700);
		primaryStage.setMinHeight(600);

		primaryStage.show();

		primaryStage.setOnCloseRequest(e -> {
			e.consume();

			if(!Dialog.confirm(Lang.getEquiv("Quitter"), Lang.getEquiv("Voulez-vous vraiment quitter ?")))
				return;

			DB.close();
			primaryStage.close();
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}