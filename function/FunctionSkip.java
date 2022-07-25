package function;

public class FunctionSkip extends Function {
    
    private int count;
    
    // default Constructor
    public FunctionSkip() {
        super();
        this.count = 2;
        this.name = "Skip every " + count + " characters";
    }
    
    // custom Constructor partial
    public FunctionSkip(String input) {
        super(input);
        this.count = 2;
        this.name = "Skip every " + count + " characters";
    }
    
    // custom Constructor full
    public FunctionSkip(String input, int count) {
        super(input);
        this.count = count;
        this.name = "Skip every " + count + " characters";
    }
    
    public int getCount() { return this.count; }
    public void setCount(int count) {
        // set only if given count is 2 or more
        if (this.count > 1) this.count = count;
    }
    
    /**
     * Assign every 'count'th character from input to output.
     */
    @Override
    public void process() {
        // reset output to empty string
        this.output = "";
        // store input into char array
        char[] inputArray = this.input.toCharArray();
        // iterate through input array
        for (int i = 0; i < inputArray.length; i++) {
            // if character should not be skipped, write it into output
            if ((i + 1) % count == 0) this.output += inputArray[i];
        }
    }
}