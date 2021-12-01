public class RPNCalculator {
    // 1A: Set up the stack
    private int[] list = new int[10];
    private int size = 0;

    // push to the stack
    public void push(int s) {
        list[size] = s;
        size++;

        if (size >= list.length) {
            int[] newList = new int[list.length * 2];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
    }

    // pop the item from the stack
    public int pop() {
        if (size == 0) {
            int intNull = Integer.parseInt(null);
            return intNull;

        } else {
            size--;
            return list[size];
        }
    }

    // sets size to 0
    public boolean isEmpty() {
        return size == 0;
    }

    // return the size of the stack
    public int length() {
        return size;
    }

    // 1A: Set up the stack
    // clear the stack
    public void clear() {
        clear();
        isEmpty();
    }

    // 1B: Evaluate expressions
    public int evaluate(String expr) throws RPNException {
        try {
            // for each token in the given expression, split it at each space
            for (String token : expr.split("\\s+")) {
                // if the token is a number, push it to the stack
                try {
                    Integer.parseInt(token);
                    int token2 = Integer.parseInt(token);
                    push(token2);

                    // if the token is not a number, pop the top 2 items off of the stack and run the switch case
                } catch (Exception e) {
                    int y = pop();
                    int x = pop();

                    String operator = "+-*/";
                    int index = operator.indexOf(token);

                    switch (index) {
                        case 0:
                            // if the operator is +
                            System.out.print(" Number added\n");
                            push(x + y);
                            break;
                        case 1:
                            // if the operator is -
                            System.out.print(" Number subtracted\n");
                            push(x - y);
                            break;
                        case 2:
                            // if the operator is *
                            System.out.print(" Number multiplied\n");
                            push(x * y);
                            break;
                        case 3:
                            // if the operator is /
                            System.out.print(" Number divided\n");
                            push(x / y);
                            break;
                        default:
                            //error handling
                            // if the token is not an operator, throw an RPNException
                            throw new RPNException();

                    }
                }
            }
            //error handling
            //if the input is valid, throw an RPNExpression
        } catch (RPNException e) {
            System.out.println("Invalid input");
        }
        // pop the final answer off the stack and return it
        // the expression is invalid if evaluating it causes a pop on an empty stack or if the stack contains more than one item at the end of the computation
        int result = 0;
        if (list == null || size > 2){
            throw new RPNException();
        }
        else if (size < 2) {
            result = pop();
        }
        return result;
    }

    // 1B: Evaluate expressions
    public static void main(String[] args) throws RPNException {
        // create a new RPN calculator
        RPNCalculator calc = new RPNCalculator();
        System.out.println();
        System.out.println(
                "//===================================================================================================\\\\\n" +
                        "// xxxx                                       RPN CALCULATOR                                     xxxx \\\\\n" +
                        "//====================================================================================================\\\\");
        String input = "31 16 - 2 *";
        System.out.println(" Processes\n ---");
        // evaluate the inputted expression and print it
        int result = calc.evaluate(input);
        System.out.println(" ----------------------\n Question\n ---\n " + input + "\n ----------------------\n Answer\n ---\n " + result + "\n ----------------------");
    }

    // 1A: Set up the stack
    public class RPNException extends Throwable {
        // the RPNException class
    }

}
