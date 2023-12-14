This project is made to learn and practice microservices

It contains 5 services:

-> Discovery service: Created using Eureka Server

-> API Gateway service: Created using Spring Cloud Gateway

-> Config service: Created using Spring Cloud Config Server

-> Song service: A simple API that manage songs

-> Album service: A simple API that manage albums and communicate with song service using OpenFeign

This project use also Zipkin and Micrometer for the distributed tracing system feature, and Resilience4j for circuit breaking feature
