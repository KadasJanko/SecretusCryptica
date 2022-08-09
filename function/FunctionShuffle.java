package function;

import java.util.Random;

public class FunctionShuffle extends Function {
    
    // default Constructor
    public FunctionShuffle() {
        super();
        this.name = "shuffle";
    }
    
    // custom Constructor
    public FunctionShuffle(String input) {
        super(input);
        this.name = "shuffle";
    }
    
    /**
     * Shuffles whole input text randomly.
     */
    @Override
    public void process() {
        // reset output into empty string
        this.output = "";
        // if input is empty or null, do nothing
        if (this.input.length() < 1) return;
        // create instance of random generator
        Random generator = new Random();
        // store input into character array
        char[] inputArray = this.input.toCharArray();
        // variable for storing character
        char temp;
        // variable for storing randomly generated position
        int position;
        // iterate through inputArray
        for (int i = 0; i < inputArray.length; i++) {
            // generate new position
            position = generator.nextInt(inputArray.length);
            // store character from generated position into temporary variable
            temp = inputArray[position];
            // store character from current position into generated position
            inputArray[position] = inputArray[i];
            // store stored character into current position
            inputArray[i] = temp;
        }
        // store inputArray to output
        for (char ch : inputArray) {
            this.output += ch;
        }
    }
}