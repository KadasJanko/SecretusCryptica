package main;

import function.Function;

public class DataHolder {
    
    private String input;
    private String output;
    
    private Function[] functionList;
    private int selection;
    
    // Constructor
    public DataHolder() {
        
        this.input = "";
        this.output = "";
        this.functionList = new Function[0];
        this.selection = 0;
    }
    
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
        // set selection to lastly added function
        this.selection = this.functionList.length - 1;
    }
    
    public void removeFunction() {
        // if functionList is empty, do nothing
        if (this.functionList.length == 0) return;
        // create new array one shorter than original
        Function[] newFunctionList = new Function[functionList.length - 1];
        // iterate through new array
        for (int i = 0; i < newFunctionList.length; i++) {
            // if selection is less than counter, assign same value index
            if (i < selection) newFunctionList[i] = functionList[i];
            // else assign index one member above
            else newFunctionList[i] = functionList[i + 1];
        }
        // assign new array to original one
        this.functionList = newFunctionList;
        // decrease selection index if not less than 0
        if (this.selection > -1) this.selection--;
    }
    
    public void selectUp() {
        // if index is zero or less, do nothing
        if (selection < 1) return;
        // decrease selection (move asterisk one place up)
        selection--;
    }
    
    public void selectDown() {
        // if index is more or equal to length of array -1, do nothing
        if (selection >= (functionList.length - 1)) return;
        // increase selection (move asterisk one place down)
        selection++;
    }
    
    public void moveUp() {
        // if length of function array is less than 2, do nothing
        if (this.functionList.length < 2) return;        
        // if index is zero or less, do nothing
        if (selection < 1) return;
        // do the swapping stuff
        // temporary variable
        Function tempFunction = this.functionList[selection - 1];
        // first swap step
        this.functionList[selection - 1] = this.functionList[selection];
        // second swap step
        this.functionList[selection] = tempFunction;
        // decrease selection index (move asterisk one place up)
        this.selection--;
    }
    
    public void moveDown() {
        // if length of function array is less than 2, do nothing
        if (this.functionList.length < 2) return;
        // if index is more or equal to functionList lenght, do nothing
        if (selection >= (functionList.length - 1)) return;
        // do the swapping stuff
        // temporary variable
        Function tempFunction = this.functionList[selection + 1];
        // first swap step
        this.functionList[selection + 1] = this.functionList[selection];
        // second swap step
        this.functionList[selection] = tempFunction;
        // increase selection index (move asterisk one place down)
        this.selection++;
    }
    
    /**
     * Does the processing of input through array of functions
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
        for (int i = 0; i < functionList.length; i++) {
            // if selection on current position, write asterisk...
            if (i == selection) functionListString += "* ";
            // otherways write only space
            else functionListString += "  ";
            functionListString += functionList[i].getName() + "\n";
        }
        return functionListString;
    }
}