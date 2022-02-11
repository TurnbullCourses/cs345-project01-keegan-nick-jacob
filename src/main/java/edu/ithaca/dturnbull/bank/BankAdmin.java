package edu.ithaca.dturnbull.bank;
public class BankAdmin {

    //Init vars
    public String status;
    public String email;

    //Method will Open a Closed Account
    public void openAccount(String email){
        this.status = "open";    
    }

    //Method will Freeze a Open Account
    public void freezeAccount(String email){
        this.status = "closed";
    }
    
    //Method will getStatus
    public String getStatus(){
        return status;
    }
    
}

