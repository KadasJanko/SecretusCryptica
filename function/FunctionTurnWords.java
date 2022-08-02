package function;

public class FunctionTurnWords extends Function {
    
    private boolean backwards;
    private int count;
    private char wordSeparator;
    private FunctionSplitter splitter;
    private FunctionTurnText turnText;
    private FunctionJoiner joiner;
    
    // default constructor
    public FunctionTurnWords() {
        super();
        this.backwards = false;
        this.count = 1;
        this.wordSeparator = ' ';
        this.name = "Turn words ";
        this.name += (backwards ? "backwards" : "forwards");
        this.name += " " + count + " times, separator \'" + this.wordSeparator + "\'";
        this.splitter = new FunctionSplitter();
        this.turnText = new FunctionTurnText();
        this.joiner = new FunctionJoiner();
    }
    
    // custom constructor partial
    public FunctionTurnWords(String input) {
        super(input);
        this.backwards = false;
        this.count = 1;
        this.wordSeparator = ' ';
        this.name = "Turn words ";
        this.name += (backwards ? "backwards" : "forwards");
        this.name += " " + count + " times, separator \'" + this.wordSeparator + "\'";
        this.splitter = new FunctionSplitter();
        this.turnText = new FunctionTurnText();
        this.joiner = new FunctionJoiner();
    }
    
    // custom constructor full
    public FunctionTurnWords(String input, boolean backwards, int count, char wordSeparator) {
        super(input);
        this.backwards = backwards;
        this.count = count;
        this.wordSeparator = wordSeparator;
        this.name = "Turn words ";
        this.name += (backwards ? "backwards" : "forwards");
        this.name += " " + count + " times, separator \'" + this.wordSeparator + "\'";
        this.splitter = new FunctionSplitter();
        this.turnText = new FunctionTurnText();
        this.joiner = new FunctionJoiner();
    }
    
    public boolean getBackwards() { return this.backwards; }
    public void setBackwards(boolean backwards) {
        this.backwards = backwards;
        this.name = "turn text " + (this.backwards ? "backwards" : "forwards");
        this.name += " " + count + " times, separator \'" + this.wordSeparator + "\'";
    }
    public int getCount() { return this.count; }
    public void setCount(int count) {
        // if count is less than 0, do nothing
        if (this.count < 0) return;
        this.count = count;
        this.name = "turn text " + (this.backwards ? "backwards" : "forwards");
        this.name += " " + count + " times, separator \'" + this.wordSeparator + "\'";
    }
    public char getWordSeparator() { return this.wordSeparator; }
    public void setWordSeparator(char wordSeparator) {
        this.wordSeparator = wordSeparator;
        this.name = "turn text " + (this.backwards ? "backwards" : "forwards");
        this.name += " " + count + " times, separator \'" + this.wordSeparator + "\'";
    }
    
    /**
     * Turns both ends of words by set direction.
     * This function uses FunctionSplitter, FunctionTurnText and
     * FunctionJoiner instances.
     */
    @Override
    public void process() {
        // if input empty or null, reset output to empty string, do nothing else
        if (this.input == null || this.input.length() < 1) {
            this.output = "";
            return;
        }
        // reset output to empty string
        this.output = "";
        // setup instance of splitter
        this.splitter.setInput(this.input);
        this.splitter.setSplitChar(this.wordSeparator);
        // process data and store it into string array
        this.splitter.process();
        String[] wordArray = this.splitter.getOutputArray();
        // setup instance of turnText instance
        this.turnText.setBackwards(this.backwards);
        this.turnText.setCount(this.count);
        // iterate through string array
        for (int i = 0; i < wordArray.length; i++) {
            // setup turnText input from current position in array
            this.turnText.setInput(wordArray[i]);
            // invoke processing of data
            this.turnText.process();
            // store result into current position in array of words
            wordArray[i] = this.turnText.getOutput();
        }
        // setup instance of joiner
        this.joiner.setInputArray(wordArray);
        this.joiner.setJoinChar(this.wordSeparator);
        // proces data and store it into output
        this.joiner.process();
        this.output = this.joiner.getOutput();
    }
}