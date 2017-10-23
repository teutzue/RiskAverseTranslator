package client;


import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import ws.BankOfNorrebro2;
import ws.BankOfNorrebro2Service;
import ws.BankOfNorrebro2ServiceLocator;
import ws.InterestRateResponse;

public class BankContact {


    public InterestRateResponse getResponse(String ssn, Integer creditScore, Double loanAmount, String loanDuration) {


        try {
            BankOfNorrebro2ServiceLocator bns = new BankOfNorrebro2ServiceLocator();
            System.out.println(ssn + loanDuration + loanAmount + "-------------------");

            BankOfNorrebro2 port = bns.getBankOfNorrebro2Port();
            return port.getRate(ssn, creditScore, loanAmount, loanDuration);

        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
