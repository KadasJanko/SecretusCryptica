package function;

public class Function {
    
    protected String input;
    protected String output;
    
    protected String name;
    
    // default Constructor
    public Function() {
        this.input = "";
        this.output = "";
        this.name = "";
    }
    
    // custom Constructor
    public Function(String input) {
        this.input = input;
        this.output = "";
        this.name = "";
    }
    
    public String getInput() { return this.input; }
    public void setInput(String input) { this.input = input; }
    public String getOutput() { return this.output; }
    public String getName() { return this.name; }
    
    public void process() {
        // Every descendant will override this method with functional stuff...
    }
}