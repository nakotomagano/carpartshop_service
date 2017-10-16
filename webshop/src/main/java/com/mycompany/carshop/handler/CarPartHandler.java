package com.mycompany.carshop.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import com.mycompany.carshop.utils.Constants;

/**
 * Handles SOAP messages. Needed for client authentication.
 * @author Veljko Matovic
 * Oct 15, 2017
 */
public class CarPartHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outBoundProperty  = (Boolean)
                context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        //if incomming message, check headers for username and password:
        if (!outBoundProperty) {
            SOAPMessage soapMsg = context.getMessage();
            //get detail from request headers
            Map httpHeaders = (Map) context.get(MessageContext.HTTP_REQUEST_HEADERS);
            List userList = (List) httpHeaders.get("Username");
            List passList = (List) httpHeaders.get("Password");

            String username = "";
            String password = "";

            if (userList != null) {
                //get username
                username = userList.get(0).toString();
            }

            if (passList != null) {
                //get password
                password = passList.get(0).toString();
            }

            //Should validate username and password with database
            if (!username.equals(Constants.CLIENT_USERNAME) || !password.equals(Constants.CLIENT_PASSWORD)) {
                generateErrorMessageAndThrowException(soapMsg, "Authentication fail.");
            }
            return true;
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("Server : handleFault() Begin");
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Server : close() Begin");

    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders() Begin");
        return null;
    }

    private void generateErrorMessageAndThrowException(SOAPMessage msg, String reason) {
        try {
            SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
            SOAPFault soapFault = soapBody.addFault();
            soapFault.setFaultString(reason);
            throw new SOAPFaultException(soapFault);
        } catch (SOAPException e) {
            System.err.println(e);
        }
    }
}
