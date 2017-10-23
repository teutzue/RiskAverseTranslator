/**
 * BankOfNorrebro2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface BankOfNorrebro2 extends java.rmi.Remote {
    public ws.InterestRateResponse getRate(java.lang.String ssn, java.lang.Integer creditScore, java.lang.Double loanAmount, java.lang.String loanDuration) throws java.rmi.RemoteException;
}
