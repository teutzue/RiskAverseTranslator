/**
 * BankOfNorrebro2ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class BankOfNorrebro2ServiceLocator extends org.apache.axis.client.Service implements ws.BankOfNorrebro2Service {

    public BankOfNorrebro2ServiceLocator() {
    }


    public BankOfNorrebro2ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankOfNorrebro2ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BankOfNorrebro2Port
    private java.lang.String BankOfNorrebro2Port_address = "http://localhost:8080/BankOfNorrebroOk/BankOfNorrebro2Service";

    public java.lang.String getBankOfNorrebro2PortAddress() {
        return BankOfNorrebro2Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BankOfNorrebro2PortWSDDServiceName = "BankOfNorrebro2Port";

    public java.lang.String getBankOfNorrebro2PortWSDDServiceName() {
        return BankOfNorrebro2PortWSDDServiceName;
    }

    public void setBankOfNorrebro2PortWSDDServiceName(java.lang.String name) {
        BankOfNorrebro2PortWSDDServiceName = name;
    }

    public ws.BankOfNorrebro2 getBankOfNorrebro2Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankOfNorrebro2Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankOfNorrebro2Port(endpoint);
    }

    public ws.BankOfNorrebro2 getBankOfNorrebro2Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.BankOfNorrebro2PortBindingStub _stub = new ws.BankOfNorrebro2PortBindingStub(portAddress, this);
            _stub.setPortName(getBankOfNorrebro2PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankOfNorrebro2PortEndpointAddress(java.lang.String address) {
        BankOfNorrebro2Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.BankOfNorrebro2.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.BankOfNorrebro2PortBindingStub _stub = new ws.BankOfNorrebro2PortBindingStub(new java.net.URL(BankOfNorrebro2Port_address), this);
                _stub.setPortName(getBankOfNorrebro2PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BankOfNorrebro2Port".equals(inputPortName)) {
            return getBankOfNorrebro2Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "BankOfNorrebro2Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "BankOfNorrebro2Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BankOfNorrebro2Port".equals(portName)) {
            setBankOfNorrebro2PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
