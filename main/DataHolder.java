package main;

import function.Function;

public class DataHolder {
    
    private String input;
    private String output;
    
    private Function[] functionList;
    
    // Constructor
    public DataHolder() {
        
        this.input = "";
        this.output = "";
        this.functionList = new Function[0];
    }
    
    // GET and SET section
    
    public String getInput() { return this.input; }
    public void setInput(String input) { this.input = input; }
    public String getOutput() { return this.output; }
    
    public void addFunction(Function function) {
        // create new Function srray one field longer than original
        Function[] newFunctionList = new Function[this.functionList.length + 1];
        // iterate through original array
        for (int i = 0; i < functionList.length; i++) {
            // copy current position function to new array
            newFunctionList[i] = functionList[i];
        }
        // copy function given to method into last index of new array
        newFunctionList[newFunctionList.length - 1] = function;
        // assign new array to original refference
        this.functionList = newFunctionList;
    }
    
    /**
     * For now only set input directly to output.
     */
    public void process() {
        // if functionList length is 0, set input directly to output.
        if (this.functionList.length == 0) {
            this.output = input;
            return;
        }
        // temporary string for storing results
        String tempString = this.input;
        // iterate through function list
        for (Function f : functionList) {
            // set input of current function from tempString
            f.setInput(tempString);
            f.process();
            // store result of current funtion to tempString
            tempString = f.getOutput();
        }
        // store result into output
        this.output = tempString;
    }
    
    /**
     * Returns formatted string with names of all functions.
     */
    public String getFunctionList() {
        
        // Variable for gathering all names into formatted string.
        String functionListString = "";
        // iterare through function list
        for (Function f: functionList) {
            functionListString += f.getName() + "\n";
        }
        return functionListString;
    }
}