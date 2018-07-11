package net.atos.server;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

//import org.apache.cxf.interceptor.InInterceptors;
import org.jboss.ws.api.annotation.EndpointConfig;

@WebService(name="echo",
            endpointInterface="net.atos.server.DummyService",
            targetNamespace = "http://net.atos",
            wsdlLocation = "WEB-INF/cxf-test.wsdl",
            serviceName = "dummyService",
            portName = "dummyPort"
            )
@EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
@HandlerChain(file="handlers.xml")
public class DummyServiceImpl implements DummyService {
	
  @Resource(name = "wsContext")
  WebServiceContext ctx;

  public String echo(String message) {
    return message;
  }

  public String reverse(String message) {
	return new StringBuilder(message).reverse().toString();
  }

}