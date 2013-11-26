package pl.edu.agh.mic.ws;

import javax.jws.WebService;

@WebService(
        portName = "TestPort",
        serviceName = "TestService",
        targetNamespace = "http://superbiz.org/wsdl",
        endpointInterface = "org.superbiz.calculator.ws.CalculatorWs")
public class TestService implements TestServiceWs {

    public int sum(int add1, int add2) {
        return add1 + add2;
    }

    public int multiply(int mul1, int mul2) {
        return mul1 * mul2;
    }
}