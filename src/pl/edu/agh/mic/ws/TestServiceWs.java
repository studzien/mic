package pl.edu.agh.mic.ws;

import javax.jws.WebService;

@WebService(targetNamespace = "http://superbiz.org/wsdl")
public interface TestServiceWs {

    public int sum(int add1, int add2);

    public int multiply(int mul1, int mul2);
}