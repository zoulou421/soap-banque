package com.isi.soap_banque.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "banque")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema banqueSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BanquePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://isi.com/banque"); // Adaptez selon votre XSD
        wsdl11Definition.setSchema(banqueSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema banqueSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/banque.xsd"));
    }

    // ============= TRANSACTION (client, solde, transfer, payment) =============
    @Bean(name = "transaction")
    public DefaultWsdl11Definition transactionWsdl(XsdSchema transactionSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("TransactionPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://www.esmt.com/banque");
        wsdl.setSchema(transactionSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema transactionSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/transaction.xsd"));
    }
}