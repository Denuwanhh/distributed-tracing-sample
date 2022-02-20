# # Distributed-Tracing-Sample

In this implementation contain two services in the hypothetical scenario on the reservation domain. Booking-service work as a backend-for-frontend service and user request hits directly to the booking-service when booking request raises two inter-services communication happens from booking-service to host-management-service and verify the availability of host and make booking calls.

## Prerequisites
 - Java 1.8+
 - Maven 2+

## Build and Run
 ### 1.Run booking-service
 Go to /booking-service directory and run.

    mvn clean install
    java -jar target/booking-service-0.0.1-SNAPSHOT.jar

### 2.Run host-management-service
Go to /host-management-service directory and run.

    mvn clean install
    java -jar target/host-management-service-0.0.1-SNAPSHOT.jar

### 3.Spin up Zipkin instance 
You can spin up the Zipkin instance using three options: using Java, Docker, or running from source. In this demo, I prefer to fetch the latest release as a self-contained executable jar.

    curl -sSL https://zipkin.io/quickstart.sh | bash -s  
    java -jar zipkin.jar

## Tracing the Request
Once spin up all three services. You can run the POST request and see how request trace via Zipkin visualization tool.

### 1.Execute POST booking request

    curl -X POST \  
    [http://localhost:8080/booking](http://localhost:8080/booking) \  
    -H ‘content-type: application/json’ \  
    -d ‘{  
    “bookingID” : 1,  
    “bookingDate” : “2022–02–19T00:00:00.000Z”,  
    “host” : {  
    “hostID” : 10  
    }  
    }’

### 2.Access to Zipkin instane
End Point : `http://localhost:9411/`
