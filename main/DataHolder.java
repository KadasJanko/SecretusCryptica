package main;

public class DataHolder {
    
    private String input;
    private String output;
    
    // Constructor
    public DataHolder() {
        
        this.input = "";
        this.output = "";
    }
    
    // GET and SET section
    
    public String getInput() { return this.input; }
    public void setInput(String input) { this.input = input; }
    public String getOutput() { return this.output; }
    
    /**
     * For now only set input directly to output.
     */
    public void process() {
        this.output = input;
    }
}