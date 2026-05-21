package geradorDeSenhas;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FrontGeradorDeSenhas extends Application {
    
    @Override
    public void start(Stage janela){

        Label titulo = new Label("GERADOR DE SENHAS");

        Label tamanhoDaSenha = new Label("TAMANHO DA SENHA:");

        TextField campoTamanho = new TextField();

        Label senhaGerada = new Label("SENHA GERADA:");

        TextField senhaGeradaField = new TextField();
        senhaGeradaField.setEditable(false);

        Button gerarSenha = new Button("GERAR SENHA");
        gerarSenha.setOnAction(e -> {
            int tamanho = Integer.parseInt(campoTamanho.getText());
            String senha = GeradorDeSenhas.gerarSenha(tamanho);
            senhaGeradaField.setText(senha);
        });
        
        VBox layout = new VBox(10, titulo, tamanhoDaSenha, campoTamanho, gerarSenha, senhaGerada, senhaGeradaField);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Scene cena = new Scene(layout, 400, 300);
        janela.setScene(cena);
        janela.setTitle("GERADOR DE SENHAS");
        janela.show();

        cena.getStylesheets().add("geradorDeSenhas/style.css");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
