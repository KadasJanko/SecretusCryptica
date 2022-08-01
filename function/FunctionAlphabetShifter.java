package function;

public class FunctionAlphabetShifter extends Function {
    
    private int count;
    private boolean backwards;
    
    private final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    // default Constructor
    public FunctionAlphabetShifter() {
        super();
        this.count = 1;
        this.backwards = false;
        this.name = "Shift by " + this.count + " forwards";
    }
    
    // custom Constructor partial 1
    public FunctionAlphabetShifter(String input) {
        super(input);
        this.count = 1;
        this.backwards = false;
        this.name = "Shift by " + this.count + " forwards";
    }
    
    // custom Constructor partial 2
    public FunctionAlphabetShifter(String input, int count) {
        super(input);
        this.count = count;
        this.backwards = false;
        this.name = "Shift by " + this.count + " forwards";
    }
    
    // custom Constructor full
    public FunctionAlphabetShifter(String input, int count, boolean backwards) {
        super(input);
        this.count = count;
        this.backwards = backwards;
        this.name = "Shift by " + this.count;
        this.name += this.backwards ? " backwards" : " forwards";
    }
    
    public int getCount() { return this.count; }
    public void setCount(int count) {
        if (count < 0) {
            this.count = 0;
            return;
        }
        if (count > 26) {
            // subtract the length of alphabet needed amount of times
            while (count > 26) {
                count -= 26;
            }
            return;
        }
        this.count = count;
    }
    public boolean getBackwards() { return this.backwards; }
    public void setBackwards(boolean backwards) { this.backwards = backwards; }
    
    /**
     * Do the alphabet shifting.
     */
    @Override
    public void process() {
        // reset output to empty string
        this.output = "";
        // store input into array of characters
        char[] inputArray = this.input.toCharArray();
        // iterate through input array
        for (char ch : inputArray) {
            // first loop terminator
            boolean isLower = false;
            // iterate through lower case alphabet set
            for (int i = 0; i < this.lowerCase.length(); i++) {
                // if match found in alphabet set
                if (ch == this.lowerCase.charAt(i)) {
                    // switch terminator
                    isLower = true;
                    // if backwards mode is false
                    if (this.backwards == false) {
                        // if index overflow
                        if ((i + this.count) >= this.lowerCase.length()) {
                            // decrease position for assignation by length of alphabet set
                            this.output += this.lowerCase.charAt(i + this.count - this.lowerCase.length());
                        }
                        // if not index overflow
                        else {
                            this.output += this.lowerCase.charAt(i + this.count);
                        }
                    }
                    // if backwards mode is true
                    if (this.backwards == true) {
                        // if index underflow
                        if ((i - this.count) < 0) {
                            // increase position for assignation by length of alphabet set
                            this.output += this.lowerCase.charAt(i - this.count + this.lowerCase.length());
                        }
                        // if not index underflow
                        else {
                            this.output += this.lowerCase.charAt(i - this.count);
                        }
                    }
                    break;
                }
            }
            // check terminator
            if (isLower) continue;
            // second loop terminator
            boolean isUpper = false;
            // iterate through upper case alphabet set
            for (int i = 0; i < this.upperCase.length(); i++) {
                // if match found in alphabet set
                if (ch == this.upperCase.charAt(i)) {
                    // switch terminator
                    isUpper = true;
                    // if backwards mode is false
                    if (this.backwards == false) {
                        // if index overflow
                        if ((i + this.count) >= this.upperCase.length()) {
                            // decrease position for assignation by length of alphabet set
                            this.output += this.upperCase.charAt(i + this.count - this.upperCase.length());
                        }
                        // if not index overflow
                        else {
                            this.output += this.upperCase.charAt(i + this.count);
                        }
                    }
                    // if backwards mode is true
                    if (this.backwards == true) {
                        // if index underflow
                        if ((i - this.count) < 0) {
                            // increase position for assignation by length of alphabet set
                            this.output += this.upperCase.charAt(i - this.count + this.upperCase.length());
                        }
                        // if not index underflow
                        else {
                            this.output += this.upperCase.charAt(i - this.count);
                        }
                    }
                    break;
                }
            }
            // check terminator
            if (isUpper) continue;
            // if not alphabet character, do not change it, only assign it
            this.output += ch;
        }
    }
}