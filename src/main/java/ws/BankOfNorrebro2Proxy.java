package ws;

public class BankOfNorrebro2Proxy implements ws.BankOfNorrebro2 {
  private String _endpoint = null;
  private ws.BankOfNorrebro2 bankOfNorrebro2 = null;
  
  public BankOfNorrebro2Proxy() {
    _initBankOfNorrebro2Proxy();
  }
  
  public BankOfNorrebro2Proxy(String endpoint) {
    _endpoint = endpoint;
    _initBankOfNorrebro2Proxy();
  }
  
  private void _initBankOfNorrebro2Proxy() {
    try {
      bankOfNorrebro2 = (new ws.BankOfNorrebro2ServiceLocator()).getBankOfNorrebro2Port();
      if (bankOfNorrebro2 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankOfNorrebro2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankOfNorrebro2)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankOfNorrebro2 != null)
      ((javax.xml.rpc.Stub)bankOfNorrebro2)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.BankOfNorrebro2 getBankOfNorrebro2() {
    if (bankOfNorrebro2 == null)
      _initBankOfNorrebro2Proxy();
    return bankOfNorrebro2;
  }
  
  public ws.InterestRateResponse getRate(java.lang.String ssn, java.lang.Integer creditScore, java.lang.Double loanAmount, java.lang.String loanDuration) throws java.rmi.RemoteException{
    if (bankOfNorrebro2 == null)
      _initBankOfNorrebro2Proxy();
    return bankOfNorrebro2.getRate(ssn, creditScore, loanAmount, loanDuration);
  }
  
  
}