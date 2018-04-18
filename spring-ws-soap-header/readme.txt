*******A detailed step-by-step tutorial on how to set and get a SOAP header using Spring-WS and Spring Boot.

		https://www.codenotfound.com/spring-ws/spring-ws-soap-header-example.html
		
Important Steps to remember:

1.	Running the below Maven command will generate the JAXB object for the added SOAP header under the specified directory mentioned in the pom.xml file.
	
	mvn generate-sources
	
	
	
2. Run the Spring boot application using below maven command.

	mvn spring-boot:run
	
3. Verify the WSDL location at "http://localhost:8090/ws/ticketAgentBean.wsdl"

4. SOAP Request for endpoint http://localhost:8090/ws/ticketAgent

	<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:tic="http://example.org/TicketAgent.xsd">
   <soapenv:Header>
      <tic:listFlightsSoapHeaders>
         <clientId>abc123</clientId>
      </tic:listFlightsSoapHeaders>
   </soapenv:Header>
   <soapenv:Body>
      <tic:listFlightsRequest>
         <travelDate>20180515</travelDate>
         <startCity>NewYork</startCity>
         <endCity>Newark</endCity>
      </tic:listFlightsRequest>
   </soapenv:Body>
</soapenv:Envelope>


Note:

	1. logback is not working. Need to fix.
	2. Unit Test case is also not working.	

	