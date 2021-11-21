package model;
import java.util.Random;

public class Operation {
        private int leftoperand;
        private int rightoperand;
        private OperandSymbols operandsymbol;
        private int result;

        public Operation(OperandSymbols operationsymbol) {
            Random random = new Random();
            this.leftoperand = random.nextInt(10);
            this.rightoperand = random.nextInt(10);
            this.operandsymbol = operationsymbol;
            this.result=calculate(leftoperand, rightoperand, operationsymbol);


        }


    public int calculate(int leftoperand, int rightoperand, OperandSymbols operandsymbol) {
            int returnvalue = 0;
            switch (operandsymbol) {
                case SUM:
                    returnvalue = leftoperand + rightoperand;
                    break;
                case SUBTRACTION:
                    returnvalue = leftoperand - rightoperand;
                    break;
                case MULTIPLY:
                    returnvalue = leftoperand * rightoperand;
                    break;
                case ALLOPERATION:
                    Random rand = new Random();
                    int random = rand.nextInt(3);
                    OperandSymbols tempsymbol = OperandSymbols.values()[random];
                    System.out.println(tempsymbol);
                    returnvalue = calculate(leftoperand, rightoperand, tempsymbol);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operandsymbol);
            }
            return returnvalue;
        }
        public int getResult() {
            return result;
        }
}
