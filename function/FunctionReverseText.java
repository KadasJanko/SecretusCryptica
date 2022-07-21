package function;

public class FunctionReverseText extends Function {
    
    // default Constructor
    public FunctionReverseText() {
        super();
        this.name = "Reverse text";
    }
    
    // custom Constructor
    public FunctionReverseText(String input) {
        super(input);
        this.name = "Reverse text";
    }
    
    /**
     * Reverses whole input text from back to front.
     */
    @Override
    public void process() {
        // reset outpur to empty string
        this.output = "";
        // store input into array of characters
        char[] inputArray = this.input.toCharArray();
        // iterate through array backwards
        for (int i = inputArray.length - 1; i >= 0; i--) {
            // append current character to output string
            this.output += inputArray[i];
        }
    }
}