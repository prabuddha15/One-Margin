//package com.home.springws.client;
//
//import java.math.BigInteger;
//import java.util.List;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.Marshaller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.ws.WebServiceMessage;
//import org.springframework.ws.client.core.WebServiceMessageCallback;
//import org.springframework.ws.client.core.WebServiceTemplate;
//import org.springframework.ws.soap.SoapHeader;
//import org.springframework.ws.soap.SoapMessage;
//
//import com.home.springws.autogen.ListFlightsSoapHeaders;
//import com.home.springws.autogen.ObjectFactory;
//import com.home.springws.autogen.TFlightsResponse;
//import com.home.springws.autogen.TListFlights;
//
//@Component
//public class TicketAgentConsumer {
//
//	private static final Logger LOGGER = LoggerFactory
//			.getLogger(TicketAgentConsumer.class);
//
//	@Autowired
//	private WebServiceTemplate webServiceTemplate;
//
//	@SuppressWarnings("unchecked")
//	public List<BigInteger> listFlights() {
//		ObjectFactory factory = new ObjectFactory();
//		TListFlights tListFlights = factory.createTListFlights();
//
//		JAXBElement<TListFlights> request = factory
//				.createListFlightsRequest(tListFlights);
//
//		JAXBElement<TFlightsResponse> response = (JAXBElement<TFlightsResponse>) webServiceTemplate
//				.marshalSendAndReceive(request,
//						new WebServiceMessageCallback() {
//
//							@Override
//							public void doWithMessage(WebServiceMessage message) {
//								try {
//									// get the header from the SOAP message
//									SoapHeader soapHeader = ((SoapMessage) message)
//											.getSoapHeader();
//
//									// create the header element
//									ObjectFactory factory = new ObjectFactory();
//									ListFlightsSoapHeaders listFlightsSoapHeaders = factory
//											.createListFlightsSoapHeaders();
//									listFlightsSoapHeaders
//											.setClientId("abc123");
//
//									JAXBElement<ListFlightsSoapHeaders> headers = factory
//											.createListFlightsSoapHeaders(listFlightsSoapHeaders);
//
//									// create a marshaller
//									JAXBContext context = JAXBContext
//											.newInstance(ListFlightsSoapHeaders.class);
//									Marshaller marshaller = context
//											.createMarshaller();
//
//									// marshal the headers into the specified
//									// result
//									marshaller.marshal(headers,
//											soapHeader.getResult());
//								} catch (Exception e) {
//									LOGGER.error(
//											"error during marshalling of the SOAP headers",
//											e);
//								}
//							}
//						});
//
//		return response.getValue().getFlightNumber();
//	}
//
//}
