module com.winter {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
	requires transitive javafx.graphics;
	requires transitive javafx.base;

    opens com.winter to javafx.fxml;
    exports com.winter;
}
