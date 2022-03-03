package edu.ithaca.dturnbull.bank;

public class ClosedAccountException extends Exception{
    private static final long serialVersionUID = 1L;

    public ClosedAccountException(String s) {
        super(s);
    }

}