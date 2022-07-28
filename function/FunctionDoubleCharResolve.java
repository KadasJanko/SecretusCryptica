package function;

public class FunctionDoubleCharResolve extends Function {
    
    private char replaceChar;
    
    // default Constructor
    public FunctionDoubleCharResolve() {
        super();
        this.replaceChar = 'x';
        this.name = "Resolve double char. by \'" + this.replaceChar + "\'";
    }
    
    // custom Constructor partial
    public FunctionDoubleCharResolve(String input) {
        super(input);
        this.replaceChar = 'x';
        this.name = "Resolve double char. by \'" + this.replaceChar + "\'";
    }
    
    // custom Constructor full
    public FunctionDoubleCharResolve(String input, char replaceChar) {
        super(input);
        this.replaceChar = replaceChar;
        this.name = "Resolve double char. by \'" + this.replaceChar + "\'";
    }
    
    public char getReplaceChar() { return this.replaceChar; }
    public void setReplaceChar(char replaceChar) { this.replaceChar = replaceChar; }
    
    /**
     * Resolves double character appearance by replacing second character 
     * by defined character.
     */
    @Override
    public void process() {
        // if length of input is less than 2, do nothing
        if (this.input.length() < 2) return;
        // set output to first character of input
        this.output = "" + this.input.charAt(0);
        // iterate through input from second position
        for (int i = 1; i < this.input.length(); i++) {
            // if this character is same as character before...
            if (this.input.charAt(i) == this.input.charAt(i - 1))
                // ... append 'replace' character to output
                this.output += this.replaceChar;
            // else append current character
            else this.output += this.input.charAt(i);
        }
    }
}