package function;

public class FunctionSplitter extends Function {
    
    private char splitChar;
    private String[] outputArray;
    
    // default Constructor
    public FunctionSplitter() {
        super();
        this.splitChar = ' ';
        this.name = null;
        this.outputArray = new String[0];
    }
    
    // custom Constructor partial
    public FunctionSplitter(String input) {
        super(input);
        this.splitChar = ' ';
        this.name = null;
        this.outputArray = new String[0];
    }
    
    // custom Constructor full
    public FunctionSplitter(String input, char splitChar) {
        super(input);
        this.splitChar = splitChar;
        this.name = null;
        this.outputArray = new String[0];
    }
    
    public char getSplitChar() { return this.splitChar; }
    public void setSplitChar(char splitChar) { this.splitChar = splitChar; }
    public String[] getOutputArray() { return this.outputArray; }
    
    /**
     * Splits input into array of strings by split character.
     */
    @Override
    public void process() {
        // if input length is less than 1, do nothing
        if (this.input.length() < 1) return;
        // reset output array at first
        this.outputArray = new String[0]; // not effective, but safe
        // scan count of split characters
        // store input into array of characters
        char[] inputArray = this.input.toCharArray();
        // count storage variable
        int splitCharCount = 0;
        // iterate through input
        for (char ch : inputArray) {
            // if match found in current position, increment counter
            if (ch == splitChar) splitCharCount++;
        }
        // if no split character found, set output array directly
        if (splitCharCount == 0) {
            this.outputArray = new String[] { this.input };
            return; // do nothing more
        }
        // allocate new array one longer than count of split characters
        this.outputArray = new String[splitCharCount + 1];
        // set every field to empty string
        for (int i = 0; i < this.outputArray.length; i++) {
            this.outputArray[i] = "";
        }
        // variable for position incrementing
        int position = 0;
        // iterate through input string
        for (int i = 0; i < this.input.length(); i++) {
            // if current character is split char, move position for outputArray
            if (this.input.charAt(i) == splitChar) position++;
            // else assign current character to current position of out.arr.
            else this.outputArray[position] += this.input.charAt(i);
        }
    }
}