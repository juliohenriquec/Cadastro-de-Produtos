package br.juliohenrique.cadastro_de_produtos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProductCatalog extends Application {

    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField priceField;
    @FXML
    private Button addButton;
    @FXML
    private ListView<Product> productListView;

    private ObservableList<Product> productList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro_produtos.fxml"));
        AnchorPane root = loader.load();

        // Inicializando os campos e a ListView
        nameField = (TextField) root.lookup("#nameField");
        descriptionField = (TextField) root.lookup("#descriptionField");
        priceField = (TextField) root.lookup("#priceField");
        productListView = (ListView<Product>) root.lookup("#productListView");

        // Inicializando a lista de produtos
        productList = FXCollections.observableArrayList();
        productListView.setItems(productList);

        // Botão para adicionar produtos
        addButton = (Button) root.lookup("#addButton");
        addButton.setOnAction(event -> addProduct());

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Cadastro de Produtos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void initialize() {
        // A lista de produtos já está inicializada no start()
    }

    private void addProduct() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        double price;

        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            showAlert("Preço inválido!");
            return;
        }

        Product product = new Product(name, description, price);
        productList.add(product); // Adiciona o produto à lista
        clearFields(); // Limpa os campos
    }

    private void clearFields() {
        nameField.clear();
        descriptionField.clear();
        priceField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }
}
