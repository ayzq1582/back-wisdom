package com.zhy.wisdom.demo.webService.provider.config;

import com.zhy.wisdom.demo.webService.provider.service.imp.CatServiceImp;
import com.zhy.wisdom.demo.webService.provider.service.imp.TestServiceImp;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author zhy
 * @version 1.0
 * @date 2021/10/18
 */
@Configuration
public class CxfConfig {
    @Bean
    public ServletRegistrationBean disServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/webService/*");
        return servletRegistrationBean;
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new TestServiceImp());
        endpoint.publish("/TestService");
        return endpoint;
    }
    @Bean
    public Endpoint endpoint2() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new CatServiceImp());
        endpoint.publish("/CatService");
        return endpoint;
    }

}
