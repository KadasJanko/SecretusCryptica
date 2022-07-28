package function;

public class FunctionReverseWords extends Function {
    
    private char wordSeparator;
    private FunctionSplitter splitter;
    private FunctionReverseText reverser;
    private FunctionJoiner joiner;
    
    // default Constructor
    public FunctionReverseWords() {
        super();
        this.name = "Reverse words";
        this.wordSeparator = ' ';
        this.splitter = new FunctionSplitter();
        this.reverser = new FunctionReverseText();
        this.joiner = new FunctionJoiner();
    }
    
    // custom Constructor partial
    public FunctionReverseWords(String input) {
        super(input);
        this.name = "Reverse words";
        this.wordSeparator = ' ';
        this.splitter = new FunctionSplitter();
        this.reverser = new FunctionReverseText();
        this.joiner = new FunctionJoiner();
    }
    
    // custom Constructor full
    public FunctionReverseWords(String input, char wordSeparator) {
        super(input);
        this.name = "Reverse words";
        this.wordSeparator = wordSeparator;
        this.splitter = new FunctionSplitter();
        this.reverser = new FunctionReverseText();
        this.joiner = new FunctionJoiner();
    }
    
    public char getWordSeparator() { return this.wordSeparator; }
    public void setWordSeparator(char wordSeparator) { this.wordSeparator = wordSeparator; }
    
    /**
     * Turns words backwards.
     * This function uses FunctionSeparator, FunctionReverseText and
     * FunctionJoiner instances.
     */
    @Override
    public void process() {
        // if input is empty, do nothing
        if (this.input.equals("")) return;
        // if input is shorter than 2 characters, put input into output
        if (this.input.length() < 2) {
            this.output = this.input;
            return; // do nothing else
        }
        // put input into separator
        this.splitter.setInput(this.input);
        // process given data
        this.splitter.process();
        // store result of processing into array of strings
        String[] wordArray = this.splitter.getOutputArray();
        // iterate through word array
        for (int i = 0; i < wordArray.length; i++) {
            // give current word into reverser instance
            this.reverser.setInput(wordArray[i]);
            // process given data
            this.reverser.process();
            // store result of processing back into array
            wordArray[i] = this.reverser.getOutput();
        }
        // give processed array to joiner instance
        this.joiner.setInputArray(wordArray);
        // process given array into single string
        this.joiner.process();
        // store this string into output
        this.output = this.joiner.getOutput();
    }
}