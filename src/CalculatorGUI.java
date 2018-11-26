import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAddition, btnSubtraction, btnDivide, btnMultiply, btnEquals, btnClear, btnOpposite, btnPoint, btnPower, btnRoot;
    String currentValue;
    Stage window;
    Scene scene;
    Operation operation;
    boolean alreadyHasComma;

    @Override
    public void start(Stage primaryStage) throws Exception {

        operation = new Operation();
        currentValue = "";
        alreadyHasComma = false;

        window = primaryStage;
        window.setTitle("Calculator");

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 15 ,10, 15));

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 5, 5, 5));
        grid.setVgap(8);
        grid.setHgap(8);

        TextField screen = new TextField();
        screen.setMaxWidth(290);
        screen.setMinHeight(100);
        screen.setFont(Font.font(20));

        borderPane.setTop(screen);

        //1st row
        btn1 = new Button("1");
        btn1.setOnAction(e -> {
            currentValue += "1";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn1, 0, 0);
        btn1.setMinSize(65,45);
        btn1.setFont(Font.font(20));

        btn2 = new Button("2");
        btn2.setOnAction(e -> {
            currentValue += "2";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn2, 1, 0);
        btn2.setMinSize(65,45);
        btn2.setFont(Font.font(20));

        btn3 = new Button("3");
        btn3.setOnAction(e ->{
            currentValue += "3";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn3, 2, 0);
        btn3.setMinSize(65,45);
        btn3.setFont(Font.font(20));

        btnClear = new Button("Cl");
        btnClear.setOnAction(e -> {
            currentValue = "";
            screen.setText("");
            operation.reset();
        });
        grid.setConstraints(btnClear, 3, 0);
        btnClear.setMinSize(65,45);
        btnClear.setFont(Font.font(20));

        //2nd row
        btn4 = new Button("4");
        btn4.setOnAction(e -> {
            currentValue += "4";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn4, 0, 1);
        btn4.setMinSize(65,45);
        btn4.setFont(Font.font(20));

        btn5 = new Button("5");
        btn5.setOnAction(e -> {
            currentValue +="5";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn5, 1, 1);
        btn5.setMinSize(65,45);
        btn5.setFont(Font.font(20));

        btn6 = new Button("6");
        btn6.setOnAction(e -> {
            currentValue +="6";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn6, 2, 1);
        btn6.setMinSize(65,45);
        btn6.setFont(Font.font(20));

        btnAddition = new Button("+");
        btnAddition.setOnAction(e -> {

            operation.setOperand1(Double.parseDouble(screen.getText()));
            operation.setOperation("+");
            currentValue = "";
            screen.setText(currentValue);
        });
        grid.setConstraints(btnAddition, 3, 1);
        btnAddition.setMinSize(65,45);
        btnAddition.setFont(Font.font(20));

        //3rd row
        btn7 = new Button("7");
        btn7.setOnAction(e -> {
            currentValue +="7";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn7, 0, 2);
        btn7.setMinSize(65,45);
        btn7.setFont(Font.font(20));

        btn8 = new Button("8");
        btn8.setOnAction(e -> {
            currentValue +="8";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn8, 1, 2);
        btn8.setMinSize(65,45);
        btn8.setFont(Font.font(20));

        btn9 = new Button("9");
        btn9.setOnAction(e -> {
            currentValue +="9";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn9, 2, 2);
        btn9.setMinSize(65,45);
        btn9.setFont(Font.font(20));

        btnSubtraction = new Button("-");
        btnSubtraction.setOnAction(e -> {
            operation.setOperand1(Double.parseDouble(screen.getText()));
            operation.setOperation("-");
            currentValue = "";
            screen.setText(currentValue);
        });
        grid.setConstraints(btnSubtraction, 3, 2);
        btnSubtraction.setMinSize(65,45);
        btnSubtraction.setFont(Font.font(20));

        //4th row
        btnDivide = new Button("/");
        btnDivide.setOnAction(e -> {
            operation.setOperand1( Double.parseDouble( screen.getText() ) );
            operation.setOperation("/");
            currentValue = "";
            screen.setText("");
        });
        grid.setConstraints(btnDivide, 0, 3);
        btnDivide.setMinSize(65,45);
        btnDivide.setFont(Font.font(20));

        btnMultiply = new Button("*");
        btnMultiply.setOnAction(e -> {
            operation.setOperand1( Double.parseDouble( screen.getText() ) );
            operation.setOperation("*");
            currentValue = "";
            screen.setText("");
        });
        grid.setConstraints(btnMultiply, 1, 3);
        btnMultiply.setMinSize(65,45);
        btnMultiply.setFont(Font.font(20));

        btn0 = new Button("0");
        btn0.setOnAction(e -> {
            currentValue +="0";
            screen.setText(currentValue);
        });
        grid.setConstraints(btn0, 2, 3);
        btn0.setMinSize(65,45);
        btn0.setFont(Font.font(20));

        btnEquals = new Button("=");
        btnEquals.setOnAction(e -> {
            operation.setOperand2( Double.parseDouble( screen.getText() ));
            operation.executeOperation();
            currentValue = String.valueOf(operation.getResult());
            screen.setText(currentValue);
            operation.reset();
        });
        grid.setConstraints(btnEquals, 3, 3);
        btnEquals.setMinSize(65,45);
        btnEquals.setFont(Font.font(20));

        //5th row
        btnPoint = new Button(".");
        btnPoint.setOnAction(e -> {
            for(char ch : currentValue.toCharArray()){
                if(ch == '.')
                    alreadyHasComma = true;
            }
            if(alreadyHasComma == false){

                alreadyHasComma = true;

                if(currentValue == "")
                    currentValue ="0.";
                else
                    currentValue += ".";
            }

            screen.setText(currentValue);
        });
        grid.setConstraints(btnPoint, 0, 4);
        btnPoint.setMinSize(65,45);
        btnPoint.setFont(Font.font(20));

        btnPower = new Button("^x");
        btnPower.setOnAction(e ->{
            operation.setOperand1(Double.parseDouble(screen.getText()));
            operation.setOperation("^");
            currentValue = "";
            screen.setText(currentValue);
        });
        grid.setConstraints(btnPower, 1, 4);
        btnPower.setMinSize(65,45);
        btnPower.setFont(Font.font(20));

        btnRoot = new Button("sqrt"); //U+221A
        btnRoot.setOnAction(e -> {
            operation.setOperand1(Double.parseDouble(screen.getText()));
            operation.setOperation("sqrt");
            operation.executeOperation();
            currentValue = String.valueOf(operation.getResult());
            screen.setText(currentValue);
            operation.reset();
        });
        grid.setConstraints(btnRoot, 2, 4);
        btnRoot.setMinSize(65,45);
        btnRoot.setFont(Font.font(20));

        btnOpposite = new Button("1/x");
        btnOpposite.setOnAction(e -> {
            operation.setOperand1(Double.parseDouble(screen.getText()));
            operation.setOperation("1/x");
            operation.executeOperation();
            currentValue = String.valueOf(operation.getResult());
            screen.setText(currentValue);
            operation.reset();
        });
        grid.setConstraints(btnOpposite, 3, 4);
        btnOpposite.setMinSize(65,45);
        btnOpposite.setFont(Font.font(20));

        grid.getChildren().addAll( btn1,      btn2,        btn3,    btnClear,
                                   btn4,      btn5,        btn6,    btnAddition,
                                   btn7,      btn8,        btn9,    btnSubtraction,
                                   btnDivide, btnMultiply, btn0,    btnOpposite,
                                   btnPoint,  btnPower,    btnRoot, btnEquals);
        borderPane.setCenter(grid);

        scene = new Scene(borderPane, 320, 400);
        window.setScene(scene);
        window.show();
    }


}
