package com.home.springws.endpoint;

import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import com.home.springws.autogen.ListFlightsSoapHeaders;
import com.home.springws.autogen.ObjectFactory;
import com.home.springws.autogen.TFlightsResponse;
import com.home.springws.autogen.TListFlights;

@Endpoint
public class TicketAgentWSEndpoint {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TicketAgentWSEndpoint.class);

	@SuppressWarnings("unchecked")
	@PayloadRoot(namespace = "http://example.org/TicketAgent.xsd", localPart = "listFlightsRequest")
	@ResponsePayload
	public JAXBElement<TFlightsResponse> listFlights(
			@RequestPayload JAXBElement<TListFlights> request,
			@SoapHeader(value = "{http://example.org/TicketAgent.xsd}listFlightsSoapHeaders") SoapHeaderElement soapHeaderElement) {
		String clientId = "unknown";

		try {
			// create an unmarshaller
			JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// unmarshal the header from the specified source
			JAXBElement<ListFlightsSoapHeaders> headers = (JAXBElement<ListFlightsSoapHeaders>) unmarshaller
					.unmarshal(soapHeaderElement.getSource());

			// get the header values
			ListFlightsSoapHeaders requestSoapHeaders = headers.getValue();
			clientId = requestSoapHeaders.getClientId();
			LOGGER.info("Client ID value suplied in the header field", clientId);
			System.out.println("Client ID value suplied in the header field :: "+clientId);
		} catch (Exception e) {
			LOGGER.error("error during unmarshalling of the SOAP headers", e);
		}

		ObjectFactory factory = new ObjectFactory();
		TFlightsResponse tFlightsResponse = factory.createTFlightsResponse();
		tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(101));

		// add an extra flightNumber in the case of a clientId == abc123
		if ("abc123".equals(clientId)) {
			LOGGER.info("clientId == abc123");
			tFlightsResponse.getFlightNumber().add(BigInteger.valueOf(202));
		}

		return factory.createListFlightsResponse(tFlightsResponse);
	}

}
