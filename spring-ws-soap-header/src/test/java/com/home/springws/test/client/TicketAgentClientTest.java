//package com.home.springws.test.client;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.ws.test.client.RequestMatchers.payload;
//import static org.springframework.ws.test.client.RequestMatchers.soapHeader;
//import static org.springframework.ws.test.client.ResponseCreators.withPayload;
//
//import java.math.BigInteger;
//import java.util.List;
//
//import javax.xml.namespace.QName;
//import javax.xml.transform.Source;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.ws.client.core.WebServiceTemplate;
//import org.springframework.ws.test.client.MockWebServiceServer;
//import org.springframework.xml.transform.StringSource;
//
//import com.home.springws.client.TicketAgentConsumer;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TicketAgentClientTest {
//
//	@Autowired
//	private TicketAgentConsumer ticketAgentClient;
//
//	@Autowired
//	private WebServiceTemplate webServiceTemplate;
//
//	private MockWebServiceServer mockWebServiceServer;
//
//	@Before
//	public void createServer() {
//		mockWebServiceServer = MockWebServiceServer
//				.createServer(webServiceTemplate);
//	}
//
//	@Test
//	public void testListFlights() {
//		Source requestPayload = new StringSource(
//				"<ns3:listFlightsRequest xmlns:ns3=\"http://example.org/TicketAgent.xsd\">"
//						+ "</ns3:listFlightsRequest>");
//
//		Source responsePayload = new StringSource(
//				"<v1:listFlightsResponse xmlns:v1=\"http://example.org/TicketAgent.xsd\">"
//						+ "<flightNumber>101</flightNumber>"
//						+ "</v1:listFlightsResponse>");
//
//		// check if the SOAP Header is present using the soapHeader matcher
//		mockWebServiceServer
//				.expect(soapHeader(new QName(
//						"http://example.org/TicketAgent.xsd",
//						"listFlightsSoapHeaders")))
//				.andExpect(payload(requestPayload))
//				.andRespond(withPayload(responsePayload));
//
//		List<BigInteger> flights = ticketAgentClient.listFlights();
//		assertThat(flights.get(0)).isEqualTo(BigInteger.valueOf(101));
//
//		mockWebServiceServer.verify();
//	}
//
//}
