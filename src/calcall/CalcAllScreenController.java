/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcall;

import br.com.ifrn.ed.calculator.stack.MyStack;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * FXML Controller class Controlador do arquivo FXML, aqui são definidas todas
 * as ações da interface.
 *
 * @author savio
 */
public class CalcAllScreenController implements Initializable {

    String expressao = "";
    MyStack<String> myStack;
    @FXML
    private Font FONT;
    @FXML
    private Text output;
    @FXML
    private Text outputInfixa;
    @FXML
    private Text outputPosfixa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Ajustar tamanho do resultado exibido no display caso ultrapasse 14
     * caracteres
     */
    public void ajustText() {
        if (output.getText().length() >= 14 || outputInfixa.getText().length() >= 14
                || outputPosfixa.getText().length() >= 14) {
            output.setFont(Font.font("DejaVu Serif Condensed Bold", 11));
            outputInfixa.setFont(Font.font("DejaVu Serif Condensed Bold", 11));
            outputPosfixa.setFont(Font.font("DejaVu Serif Condensed Bold", 11));
        } else {
            output.setFont(Font.font("DejaVu Serif Condensed Bold", 26));
            outputPosfixa.setFont(Font.font("DejaVu Serif Condensed Bold", 26));
            outputInfixa.setFont(Font.font("DejaVu Serif Condensed Bold", 26));
        }
    }

    //Setar novos elementos no display
    public void setDisplay() {
        output.setText(expressao);
    }

    //Fatorial
    public static int fatorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return fatorial(num - 1) * num;
        }
    }

    @FXML
    private void button7(ActionEvent event) {
        expressao += "7";
        setDisplay();
        ajustText();

    }

    @FXML
    private void button8(ActionEvent event) {
        expressao += "8";
        setDisplay();
        ajustText();
    }

    @FXML
    private void button9(ActionEvent event) {
        expressao += "9";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonClear(ActionEvent event) {
        output.setText("");
        expressao = "";
    }

    @FXML
    private void button4(ActionEvent event) {
        expressao += "4";
        setDisplay();
        ajustText();
    }

    @FXML
    private void button5(ActionEvent event) {
        expressao += "5";
        setDisplay();
        ajustText();
    }

    @FXML
    private void button6(ActionEvent event) {
        expressao += "6";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonClearPause(ActionEvent event) {
        expressao = output.getText();
        if (expressao.length() > 0) {
            expressao = expressao.substring(0, expressao.length() - 1);
            setDisplay();
        }
        ajustText();
    }

    @FXML
    private void button1(ActionEvent event) {
        expressao += "1";
        setDisplay();
        ajustText();
    }

    @FXML
    private void button2(ActionEvent event) {
        expressao += "2";
        setDisplay();
        ajustText();
    }

    @FXML
    private void button3(ActionEvent event) {
        expressao += "3";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonMult(ActionEvent event) {
        expressao += "*";
        setDisplay();
        ajustText();
    }

    @FXML
    private void button0(ActionEvent event) {
        expressao += "0";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonPorc(ActionEvent event) {
        expressao += "%";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonSub(ActionEvent event) {
        expressao += "-";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonFat(ActionEvent event) {
        try {
            output.setText(fatorial(Integer.parseInt(expressao)) + "");
        } catch (Throwable e) {
            output.setText("Operação inválida!");
        }
    }

    @FXML
    private void buttonDiv(ActionEvent event) {
        expressao += "/";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonSom(ActionEvent event) {
        expressao += "+";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonResul(ActionEvent event) {
        myStack = Calculator.createStack(expressao);
        String posfixa = myStack.toString();
        try {
            double resul = Calculator.calculePosfix(myStack);
            output.setText(String.valueOf(resul));
            outputInfixa.setText(expressao);
            outputPosfixa.setText(posfixa);
            ajustText();
        } catch (Throwable e) {
            output.setText("Operação inválida!");
        }
    }

    @FXML
    private void buttonParLeft(ActionEvent event) {
        expressao += "(";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonParRight(ActionEvent event) {
        expressao += ")";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonExp(ActionEvent event) {
        expressao += "^";
        setDisplay();
        ajustText();
    }

    @FXML
    private void buttonPonto(ActionEvent event) {
        expressao += ".";
        setDisplay();
        ajustText();
    }

}
