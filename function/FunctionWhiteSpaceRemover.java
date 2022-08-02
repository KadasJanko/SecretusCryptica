package function;

public class FunctionWhiteSpaceRemover extends Function {
    
    // default Constructor
    public FunctionWhiteSpaceRemover() {
        super();
        this.name = "Remove extra white spaces";
    }
    
    // custom Constructor
    public FunctionWhiteSpaceRemover(String input) {
        super(input);
        this.name = "Remove extra white spaces";
    }
    
    /**
     * Removes redundant white spaces and white space on last position.
     */
    @Override
    public void process() {
        // if input is empty, set output to empty string and do nothing
        if (this.input.length() < 1) {
            this.output = "";
            return;
        }
        // set output to first character
        this.output = "" + this.input.charAt(0);
        //iterate through input from second position
        for (int i = 1; i < this.input.length(); i++) {
            // if last position is whitespace terminate loop (do not assign)
            if ((i == (this.input.length() - 1)) && this.input.charAt(i) == ' ')
                break;
            // if this and previous character is whitespace, skip this iteration
            if (this.input.charAt(i) == ' ' && this.input.charAt(i - 1) == ' ')
                continue;
            // assign character to output
            this.output += this.input.charAt(i);
        }
    }
}