module SGRN {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
	requires sqlite.jdbc;

	opens main;
}