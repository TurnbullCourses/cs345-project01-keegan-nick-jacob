package edu.ithaca.dturnbull.bank;

public class invalidAccountTypeException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public invalidAccountTypeException(String s) {
        super(s);
    }
}
