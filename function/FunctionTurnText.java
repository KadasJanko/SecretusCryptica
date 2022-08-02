package function;

public class FunctionTurnText extends Function {
    
    private boolean backwards;
    private int count;
    
    // default Constructor
    public FunctionTurnText() {
        super();
        this.backwards = false;
        this.count = 1;
        this.name = "turn text forwards 1 times";
    }
    
    // custom Constructor partial 1
    public FunctionTurnText(String input) {
        super(input);
        this.backwards = false;
        this.count = 1;
        this.name = "turn text forwards 1 times";
    }
    
    // custom Constructor partial 2
    public FunctionTurnText(String input, boolean backwards) {
        super(input);
        this.backwards = backwards;
        this.count = 1;
        this.name = "turn text " + (this.backwards ? "backwards" : "forwards");
        this.name += " 1 times";
    }
    
    // custom Constructor full
    public FunctionTurnText(String input, boolean backwards, int count) {
        super(input);
        this.backwards = backwards;
        this.count = count;
        this.name = "turn text " + (this.backwards ? "backwards" : "forwards");
        this.name += " " + count + " times";
    }
    
    public boolean getBackwards() { return this.backwards; }
    public void setBackwards(boolean backwards) {
        this.backwards = backwards;
        this.name = "turn text " + (this.backwards ? "backwards" : "forwards");
        this.name += " " + count + " times";
    }
    public int getCount() { return this.count; }
    public void setCount(int count) {
        // if count is less than 0, do nothing
        if (this.count < 0) return;
        this.count = count;
        this.name = "turn text " + (this.backwards ? "backwards" : "forwards");
        this.name += " " + count + " times";
    }
    
    /**
     * Takes character from one end and puts it into another end.
     * Which end depends from value of 'backwards' boolean.
     */
    @Override
    public void process() {
        // reset output to empty string
        this.output = "";
        // if input is empty or null, do nothing
        if (this.input == null || this.input.length() < 1) return;
        // if input exactly one character long, set it directly to output
        if (this.input.length() == 1) {
            this.output = this.input;
            return;
        }
        for (int i = 0; i < this.count; i++) {
            // if backwards is false, put first letter into last position
            if (this.backwards == false) {
                this.output = this.input.substring(1) + this.input.charAt(0);
            }
            // if backwards is true, put last letter into first position
            if (this.backwards == true) {
                this.output += this.input.charAt(this.input.length() - 1);
                this.output += this.input.substring(0, this.input.length() - 2);
            }
        }
    }
}