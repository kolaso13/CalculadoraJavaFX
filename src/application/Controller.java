package application;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
    private TextField textfield;

    @FXML
    private Button suma;

    @FXML
    private Button multiplicacion;

    @FXML
    private Button C;

    @FXML
    private Button siete;

    @FXML
    private Button punto;

    @FXML
    private Button ocho;

    @FXML
    private Button nueve;

    @FXML
    private Button seis;

    @FXML
    private Button dos;

    @FXML
    private Button del;

    @FXML
    private Button cuatro;

    @FXML
    private Button cinco;

    @FXML
    private Button zero;

    @FXML
    private Button division;

    @FXML
    private Button uno;

    @FXML
    private Button tres;

    @FXML
    private Button igual;

    @FXML
    private Button resta;

    private Boolean operationOn = true;

    @FXML
    void anyadirValor(ActionEvent event) {
    	textfield.setText(textfield.getText() + ((Button)event.getSource()).getText());
    	operationOn = true;
    }

    @FXML
    void anyadirOperador(ActionEvent event) {
    	if(operationOn){
    		textfield.setText(textfield.getText() + ((Button)event.getSource()).getText());
    		operationOn = false;
    	}
    }

	public void limpiarTextfield(){
		textfield.setText("");
		operationOn = true;
	}

	public void eliminarValor(){
		if(textfield.getText().length() != 0){
			textfield.setText(textfield.getText().substring(0, textfield.getText().length()-1));
		}
	}

	public void completarOperacion(){
		 String operationS = textfield.getText();

		 int tam = operationS.length();
		    String A[] = new String[100];

		    //Array para almacenar operadores.
		    String operaciones[] = new String[100];
		    int pos = 0;
		    double sum = 0;
		    String aux = "";

		    //inicializa primer operador.
		    operaciones[0] = "+";
		    int index_operacion = 1;
		    for(int i = 0; i<tam ; i++)
		    {
		        if(operationS.charAt(i) == '+' || operationS.charAt(i) == '-' || operationS.charAt(i) == '*' || operationS.charAt(i) == '/')
		        {
		            A[pos] = aux;
		            operaciones[index_operacion] = String.valueOf(operationS.charAt(i));
		            pos++;
		            index_operacion++;
		            aux = "";
		        }
		        else
		        {
		            aux = aux + operationS.charAt(i);
		        }
		    }
		    A[pos] = aux;

		    pos++;

		    for(int i = 0; i<pos ; i++)
		    {
		        //Determina la operación a realizar.
		        if(operaciones[i].equals("+")){
		         sum=sum+Double.parseDouble(A[i]);
		        }else if (operaciones[i].equals("-")){
		            sum=sum-Double.parseDouble(A[i]);
		        }else if (operaciones[i].equals("*")){
		            sum=sum*Double.parseDouble(A[i]);
		        }else if (operaciones[i].equals("/")){
		            sum=sum/Double.parseDouble(A[i]);
		        }

		    }
		    textfield.setText(String.valueOf(sum));
	}

}
