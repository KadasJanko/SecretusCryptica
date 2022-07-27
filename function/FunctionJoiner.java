package function;

public class FunctionJoiner extends Function {
    
    private char joinChar;
    private String[] inputArray;
    
    // default Constructor
    public FunctionJoiner() {
        super();
        this.joinChar = ' ';
        this.inputArray = new String[0];
    }
    
    // custom Constructor partial
    public FunctionJoiner(String[] inputArray) {
        super();
        this.joinChar = ' ';
        this.inputArray = inputArray;
    }
    
    // custom Constructor full
    public FunctionJoiner(String[] inputArray, char joinChar) {
        super();
        this.joinChar = joinChar;
        this.inputArray = inputArray;
    }
    
    public char getJoinChar() { return this.joinChar; }
    public void setJoinChar(char joinChar) { this.joinChar = joinChar; }
    public String[] getInputArray() { return this.inputArray; }
    public void setInputArray(String[] inputArray) { this.inputArray = inputArray; }
    
    /**
     * Transforms input array into single string joined by defined character.
     */
    @Override
    public void process() {
        // if input array is empty, do nothing
        if (this.inputArray.length < 1) return;
        // if input array length is exactly one, put it directly into output
        if (this.inputArray.length == 1) this.output = this.inputArray[0];
        // do joining stuff
        // set output to empty string
        this.output = "";
        // assign first member into output
        this.output += this.inputArray[0];
        // iterate trouhg input array from second member
        for (int i = 1; i < inputArray.length; i ++) {
            // firstly assign join character
            this.output += joinChar;
            // secondly next field from input array
            this.output += this.inputArray[i];
        }
    }
}