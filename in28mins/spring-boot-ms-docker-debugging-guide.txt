Debugging Guide line :

https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#spring-cloud-config-server---steps-01-to-08

https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#step-01

https://github.com/in28minutes/spring-microservices-v3

https://github.com/in28minutes/spring-microservices-v2

Initial:
=======
http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange/from/USD/to/INR

http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10

http://localhost:8765/CURRENCY-CONVERSION/currency-conversion-feign/from/USD/to/INR/quantity/10

Lower Case:
==========
http://localhost:8765/currency-exchange/currency-exchange/from/USD/to/INR

http://localhost:8765/currency-conversion/currency-conversion/from/USD/to/INR/quantity/10

http://localhost:8765/currency-conversion/currency-conversion-feign/from/USD/to/INR/quantity/10

Custom Routes:
==============
http://localhost:8765/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10


-------------------------my own----------------
http://localhost:8000/currency-exchange/from/USD/to/INR

http://localhost:8000/h2-console

http://localhost:8888/limits-service/default

http://localhost:8080/limits

http://localhost:8100/currency-conversion-feign/from/EUR/to/INR/quantity/10

http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

Eureka
http://localhost:8761/

Api gateway
http://localhost:8765/

upper case :
============
http://localhost:8765/CURRENCY-EXCHNAGE-SERVICE/currency-exchange/from/USD/to/INR
http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-conversion/from/USD/to/INR/quantity/10
http://localhost:8765/CURRENCY-CONVERSION-SERVICE/currency-conversion-feign/from/USD/to/INR/quantity/10

lower case:
===========
http://localhost:8765/currency-exchnage-service/currency-exchange/from/USD/to/INR
http://localhost:8765/currency-conversion-service/currency-conversion/from/USD/to/INR/quantity/10
http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/USD/to/INR/quantity/10

Custom Routing:
==============
http://localhost:8765/currency-exchange/from/USD/to/INR
http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

images:
=======
'docker.io/ashu16/mmv2-currency-exchnage-service:0.0.1-SNAPSHOT'
'docker.io/ashu16/mmv2-api-gateway:0.0.1-SNAPSHOT'
'docker.io/ashu16/mmv2-naming-server:0.0.1-SNAPSHOT'
'docker.io/ashu16/mmv2-currency-conversion-service:0.0.1-SNAPSHOT'

 docker run -p 8000:8000 ashu16/mymmv2-currency-exchnage-service:0.0.1-SNAPSHOT
 docker run -p 8100:8100 ashu16/mymmv2-currency-conversion-service:0.0.1-SNAPSHOT
 docker run -p 8761:8761 ashu16/mymmv2-naming-server:0.0.1-SNAPSHOT
 docker run -p 8765:8765 ashu16/mymmv2-api-gateway:0.0.1-SNAPSHOT






