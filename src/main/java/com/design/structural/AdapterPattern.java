package com.design.structural;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdapterPattern {
    public static void main(String args[]) {
        CreditCard targetInterface = new BankCustomer();
        targetInterface.giveBankDetails();
        System.out.print(targetInterface.getCreditCard());
    }
}

    interface CreditCard { //This is the target interface to be used by client
        public void giveBankDetails();
        public String getCreditCard();
    }// End of the CreditCard interface.

    class BankDetails{ //adaptee class which will be adapted by adapter
        private String bankName;
        private String accHolderName;
        private long accNumber;

        public String getBankName() {
            return bankName;
        }
        public void setBankName(String bankName) {
            this.bankName = bankName;
        }
        public String getAccHolderName() {
            return accHolderName;
        }
        public void setAccHolderName(String accHolderName) {
            this.accHolderName = accHolderName;
        }
        public long getAccNumber() {
            return accNumber;
        }
        public void setAccNumber(long accNumber) {
            this.accNumber = accNumber;
        }
    }// End of the BankDetails class.


    class BankCustomer extends BankDetails implements CreditCard {
        public void giveBankDetails(){  //This is the adapter class which uses adpatee class and interface
            try{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Enter the account holder name :");
                String customername=br.readLine();
                System.out.print("\n");

                System.out.print("Enter the account number:");
                long accno=Long.parseLong(br.readLine());
                System.out.print("\n");

                System.out.print("Enter the bank name :");
                String bankname=br.readLine();

                setAccHolderName(customername);
                setAccNumber(accno);
                setBankName(bankname);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        @Override
        public String getCreditCard() {
            long accno=getAccNumber();
            String accholdername=getAccHolderName();
            String bname=getBankName();

            return ("The Account number "+accno+" of "+accholdername+" in "+bname+
                    "bank is valid and authenticated for issuing the credit card");
        }
    }//End of the BankCustomer class.

