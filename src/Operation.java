public class Operation {

    private double Result;
    private double Operand1, Operand2;
    private String Operation;

    public void addition(){
        Result = Operand1 + Operand2;
    }

    public void subtraction(){
        Result = Operand1 - Operand2;
    }

    public void multiplication(){
        Result = Operand1*Operand2;
    }

    public void division(){
        Result = Operand1/Operand2;
    }

    public void power(){
        Result = Math.pow(Operand1, Operand2);
    }

    public void squareRoot(){ Result = Math.sqrt(Operand1); }

    public void opposite(){ Result = 1/Operand1; }

    public void reset(){
        Operand1 = 0;
        Operand2 = 0;
        Operation ="";
        Result = 0;
    }

    public boolean isNumber(String text){
        try{
            double number = Double.parseDouble(text);
            return true;
        }catch(NumberFormatException e){
            Operand1 = 0;
            Operand2 = 0;
            System.out.println("Not a number!");
            return false;
        }
    }

    public void executeOperation(){

        switch(Operation) {
            case "+":   addition();
                        break;
            case "-":   subtraction();
                        break;
            case "*":   multiplication();
                        break;
            case "/":   division();
                        break;
            case "^":   power();
                        break;
            case "sqrt": squareRoot();
                        break;
            case "1/x": opposite();
                        break;
            default:    break;
        }
    }

    public void setOperand1(double operand1){ Operand1 = operand1; }

    public void setOperand2(double operand2){ Operand2 = operand2; }

    public void setOperation(String operation){ Operation = operation; }

    public void setResult(double result){ Result = result;}

    public double getOperand1(){ return Operand1; }

    public double getResult(){ return Result; }
}
