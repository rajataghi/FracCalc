import java.util.Scanner;


public class FractionCalculator {

    public static boolean checkValidOperation(String userOperation){

        String[] validOperations = {"+","-","/","*","=","q","Q"};
        for (int i=0; i<validOperations.length;i++){
            //System.out.println(validOperations[i]);
            if(validOperations[i].equals(userOperation))
                return true;
        }
        System.out.println("Invalid Input. Not able to validate input");
        return false;
    }
    public static String getOperation(){
        Scanner input = new Scanner(System.in);
        String userOperation;
        do {
            System.out.println("Please enter an operation (+, -, /, *, =, q, or Q)");
            userOperation = input.nextLine();

            } while (!checkValidOperation(userOperation));
    return userOperation;
    }

    private static boolean isNumber(String s) {
        if(s==null){
            System.out.println("Either numerator or denominator is null.");
            return false;
        }

        try {
            int x = Integer.parseInt(s);
        } catch (NumberFormatException nfe)
        {
            System.out.println("Numerator or Denominator is not a number");
            return false;
        }
        return true;
    }


    public static boolean validFraction(String userFraction){
        //boolean negFlag = false;

         {
            String delims = "[/]";
            String[] tokens = userFraction.split(delims);
            //if(tokens[0].equals("-"))
            //  negFlag = true;

            for (int i = 0; i < tokens.length; i++) {

                if (isNumber(tokens[i])) {
                    int temp = Integer.parseInt(tokens[i]);
                    if (i > 0 && temp == 0) {
                        System.out.println("Invalid fraction. Denominator cannot be 0.");
                        return false;
                    }
                } else {
                    System.out.println("Either numerator of denominator is not a number");
                    return false;
                }
            }
        }
    return true;
    }

    public static Fraction getFraction(){
        Scanner input = new Scanner(System.in);
        String userFraction;
        do {
            System.out.println("Please enter (a/b) or (a) where a and b are integers and b is not zero:");
            userFraction = input.nextLine();

        }while(!validFraction(userFraction));

        if(userFraction.contains("/")) {
            String[] tokens = userFraction.split("/");
            int numerator = Integer.parseInt(tokens[0]);
            int denominator = Integer.parseInt(tokens[1]);
            return new Fraction(numerator, denominator);
        }
        else
        {   //System.out.println("I reached here to create my own denom");
            return new Fraction(Integer.parseInt(userFraction));
        }
    }




    public static void main(String[] args){
        System.out.println("Welcome to fraction calculator");

        boolean quit = false;
        do{
            String ops = getOperation();

            if (ops.equals("Q") || ops.equals("q")) {
                System.out.println("Thank you for using calculator. Bye!");
                System.exit(0);
            }

            Fraction frac1 = getFraction();
            Fraction frac2 = getFraction();
            Fraction result = new Fraction();
            boolean equalResult = false;

            if(ops.equals("+"))
                result = frac1.add(frac2);
            else if(ops.equals("-"))
                result = frac1.subtract(frac2);
            else if(ops.equals("/"))
                result = frac1.divide(frac2);
            else if(ops.equals("*"))
                result = frac1.multiply(frac2);
            else if (ops.equals("=")){
                equalResult = frac1.equals(frac2);
                System.out.println("Equality Result: " + equalResult);
                continue;
            }
            else
                System.out.println("Unable to identify operation");

            result.toLowestTerms();
            System.out.println(frac1.toString());
            System.out.println(frac2.toString());
            String output =  result.toString();
           System.out.println(output);
        }while(!quit);

    }
}
