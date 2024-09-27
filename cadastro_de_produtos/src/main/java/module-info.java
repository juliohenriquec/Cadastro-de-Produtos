module br.juliohenrique.cadastro_de_produtos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens br.juliohenrique.cadastro_de_produtos to javafx.fxml;
    exports br.juliohenrique.cadastro_de_produtos;
}