module com.gllm.pwllstemfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gllm.pwllstemfx to javafx.fxml;
    exports com.gllm.pwllstemfx;
}