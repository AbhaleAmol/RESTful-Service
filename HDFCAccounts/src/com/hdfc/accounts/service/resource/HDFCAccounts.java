package com.hdfc.accounts.service.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hdfc.accounts.service.dto.Account;
import com.hdfc.accounts.service.dto.AccountDetails;
import com.hdfc.accounts.service.dto.OpenAccountReceipt;

@Path("/accounts")
public class HDFCAccounts {
	
	public static Map<String, AccountDetails> hdfcAccountsMap;
	
	public HDFCAccounts() {
		System.out.println("Created HDFCAccount...");
		hdfcAccountsMap = new ConcurrentHashMap<>();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput createAccount(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		
		AccountDetails accountDetails = null;
		OpenAccountReceipt openAccountReceipt = null;
		
		accountDetails = accountDetailsCustomUnmarshaller(inputStream);	
		
		openAccountReceipt = new OpenAccountReceipt();
		openAccountReceipt.setAccountNumber(UUID.randomUUID().toString());
		openAccountReceipt.setAccountHolderName(accountDetails.getAccountHolderName());
		openAccountReceipt.setAccountType(accountDetails.getAccountType());
		openAccountReceipt.setAccountStatus("Account has been created successfully!");
		
		if(hdfcAccountsMap.containsKey(openAccountReceipt.getAccountNumber()) == false) {
			hdfcAccountsMap.put(openAccountReceipt.getAccountNumber(), accountDetails);
		}
	
		return new OpenAccountStreamingOutput(openAccountReceipt);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getAccountDetails(@QueryParam("account-number") String accountNumber) {
		
		AccountDetails accountDetails = null;
		
		if(hdfcAccountsMap.containsKey(accountNumber) == true) {
			accountDetails = hdfcAccountsMap.get(accountNumber);
		}
		
		return new AccountDetailsStramingOutput(accountNumber, accountDetails);
	}
	
	private AccountDetails accountDetailsCustomUnmarshaller(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
		
		AccountDetails accountDetails = null;
		accountDetails = new AccountDetails();
		
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(inputStream);
		
		Node rootNode = document.getFirstChild();
		NodeList subNodes = rootNode.getChildNodes();
		for (int k = 0; k < subNodes.getLength(); k++) {
			String nodeName = subNodes.item(k).getNodeName();
			String nodeValue = subNodes.item(k).getTextContent();
			
			if("account-holder-name".equals(nodeName)) {
				accountDetails.setAccountHolderName(nodeValue);
			} else if("account-type".equals(nodeName)) {
				accountDetails.setAccountType(nodeValue);
			} else if("email-id".equals(nodeName)) {
				accountDetails.setEmailID(nodeValue);
			} else if("mobile-number".equals(nodeName)) {
				accountDetails.setMobileNumber(nodeValue);
			} else if("cheque-facility".equals(nodeName)) {
				accountDetails.setChequeFacility(Boolean.getBoolean(nodeValue));
			} else if("net-banking-facility".equals(nodeName)) {
				accountDetails.setNetBankingFacility(Boolean.getBoolean(nodeValue));
			}
		}
		
		return accountDetails;	
	}
	
	private final class OpenAccountStreamingOutput implements StreamingOutput {

		private OpenAccountReceipt openAccountReceipt;
		
		public OpenAccountStreamingOutput(OpenAccountReceipt openAccountReceipt) {
			this.openAccountReceipt = openAccountReceipt;
		}

		@Override
		public void write(OutputStream outputStream) throws IOException, WebApplicationException {
			StringBuffer outputStringBuffer = null;
			outputStringBuffer = new StringBuffer();
			outputStringBuffer.append("<open-account-receipt><account-number>").append(openAccountReceipt.getAccountNumber()).append("</account-number><account-holder-name>").append(openAccountReceipt.getAccountHolderName()).append("</account-holder-name><account-type>").append(openAccountReceipt.getAccountType()).append("</account-type>").append("<account-status>").append(openAccountReceipt.getAccountStatus()).append("</account-status>");
			outputStream.write(outputStringBuffer.toString().getBytes());
			outputStream.close();
		}
	}
	
	private final class AccountDetailsStramingOutput implements StreamingOutput {

		private AccountDetails accountDetails;
		private String accountNumber;
		
		public AccountDetailsStramingOutput(String accountNumber, AccountDetails accountDetails) {
			this.accountNumber = accountNumber;
			this.accountDetails = accountDetails;
		}

		@Override
		public void write(OutputStream outputStream) throws IOException, WebApplicationException {
			StringBuffer outputStringBuffer = null;
			outputStringBuffer = new StringBuffer();
			outputStringBuffer.append("<open-account-receipt><account-number>").append(accountNumber).append("</account-number><account-holder-name>").append(accountDetails.getAccountHolderName()).append("</account-holder-name><account-type>").append(accountDetails.getAccountType()).append("</account-type>").append("<email-id>").append(accountDetails.getEmailID()).append("</email-id>").append("<mobile-number>").append(accountDetails.getMobileNumber()).append("</mobile-number>");
			outputStream.write(outputStringBuffer.toString().getBytes());
			outputStream.close();
		}
	}
}
