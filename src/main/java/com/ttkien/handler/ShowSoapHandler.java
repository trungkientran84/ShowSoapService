package com.ttkien.handler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kimmy
 */
public class ShowSoapHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders() {
        return new HashSet<>();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outbound) {
            try {
                QName serviceOperation = (QName) context.get(MessageContext.WSDL_OPERATION);

                if ("createShow".equals(serviceOperation.getLocalPart())
                        || "updateShow".equals(serviceOperation.getLocalPart())) {
                    SOAPMessage message = context.getMessage();
                    
                    NodeList paramList = message.getSOAPBody().getFirstChild().getChildNodes();
                    for(int i =0; i< paramList.getLength(); i++){
                        Node item = paramList.item(i);
                        String value = item.getFirstChild().getTextContent();
                        if(value.toLowerCase().contains("disney")) {
                             SOAPFault fault = null;
                            fault = message.getSOAPBody().addFault();
                            fault.setFaultString("[disney] word is not allow in any field.");
                            throw new SOAPFaultException(fault);
                        }
                    }
                }

            } catch (SOAPException ex) {
                Logger.getLogger(ShowSoapHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }

}
