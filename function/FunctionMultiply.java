package function;

public class FunctionMultiply extends Function {
    
    private int count;
    
    // default Constructor
    public FunctionMultiply() {
        super();
        this.count = 2;
        this.name = "Multiply text " + count + " times"; 
    }
    
    // custom Constructor partial
    public FunctionMultiply(String input) {
        super(input);
        this.count = 2;
        this.name = "Multiply text " + count + " times"; 
    }
    
    // custom Constructor full
    public FunctionMultiply(String input, int count) {
        super(input);
        this.count = count;
        this.name = "Multiply text " + count + " times"; 
    }
    
    public int getCount() { return this.count; }
    public void setCount(int count) {
        // operate only if given count is 2 or more
        if (count > 1) this.count = count;
    }
    
    /**
     * Repeats every letter 'count' times.
     */
    @Override
    public void process() {
        // reset output to empty string
        this.output = "";
        // store input into char array
        char[] inputArray = this.input.toCharArray();
        //iterate through input array
        for(char ch : inputArray) {
            // assign character given amount of times through loop
            for (int i = 0; i < count; i++) {
                this.output += ch;
            }
        }
    }
}