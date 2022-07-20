package function;

public class Function {
    
    protected String input;
    protected String output;
    
    // default Constructor
    public Function() {
        this.input = "";
        this.output = "";
    }
    
    // custom Constructor
    public Function(String input) {
        this.input = input;
        this.output = "";
    }
    
    public String getInput() { return this.input; }
    public void setInput(String input) { this.input = input; }
    public String getOutput() { return this.output; }
    
    public void process() {
        // Every descendant will override this method with functional stuff...
    }
}