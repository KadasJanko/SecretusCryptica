package function;

public class FunctionReplace extends Function {
    
    private String replaceWhat;
    private String replaceWith;
    
    // default Constructor
    public FunctionReplace() {
        super();
        this.replaceWhat = " ";
        this.replaceWith = "x";
        this.name = "replace \'" + this.replaceWhat + "\' by \'" + this.replaceWith + "\'";
    }
    
    // custom Constructor partial
    public FunctionReplace(String input) {
        super(input);
        this.replaceWhat = " ";
        this.replaceWith = "x";
        this.name = "replace \'" + this.replaceWhat + "\' by \'" + this.replaceWith + "\'";
    }
    
    // custom Constructor full
    public FunctionReplace(String input, String replaceWhat, String replaceWith) {
        super(input);
        this.replaceWhat = replaceWhat;
        this.replaceWith = replaceWith;
        this.name = "replace \'" + this.replaceWhat + "\' by \'" + this.replaceWith + "\'";
    }
    
    public String getReplaceWhat() { return this.replaceWhat; }
    public void setReplaceWhat(String replaceWhat) {
        this.replaceWhat = replaceWhat;
        this.name = "replace \'" + this.replaceWhat + "\' by \'" + this.replaceWith + "\'";
    }
    public String getReplaceWith() { return this.replaceWith; }
    public void setReplaceWith(String replaceWith) {
        this.replaceWith = replaceWith;
        this.name = "replace \'" + this.replaceWhat + "\' by \'" + this.replaceWith + "\'";
    }
    
    /**
     * Finds particular string and replaces it with defined string.
     */
    @Override
    public void process() {
        // reset output to empty string
        this.output = "";
        // if input is empty or null, do nothing
        if (this.input == null || this.input.length() < 1) return;
        // if input shorter than replaceWhat or replaceWith string, do nothing
        if (this.input.length() < this.replaceWhat.length()) return;
        if (this.input.length() < this.replaceWith.length()) return;
        // calculate searchable area
        // variable for ending index of search
        int ending = this.input.length() - this.replaceWhat.length();
        // iterate through input in scope
        for (int i = 0; i <= ending; i++) {
            // if match found... 
            if (this.input.substring(i, (i + this.replaceWhat.length())).equals(this.replaceWhat)) {
                // ... store replaced text into output
                this.output += this.replaceWith;
                // move counter by length of replaced string
                i += this.replaceWhat.length() - 1;
            }
            else {
                this.output += this.input.charAt(i);
            }
        }
    }
}