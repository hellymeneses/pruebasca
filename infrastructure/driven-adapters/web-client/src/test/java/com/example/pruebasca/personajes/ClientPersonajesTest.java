package com.example.pruebasca.personajes;

import com.example.pruebasca.personajes.transformer.PersonajeTransformer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.io.File;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ClientPersonajesTest {
    public static MockWebServer mockBackEnd;
    static ObjectMapper mapper;
    static ResultResponse responseMock;
    ClientPersonajes clientPersonCharacter;
    @Mock
    PersonajeTransformer transformer;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
        mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        responseMock = mapper.readValue(new File("src/test/resources/json/responseRickMortyPersons.json"), ResultResponse.class);

    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s",
                mockBackEnd.getPort());
        clientPersonCharacter = new ClientPersonajes(WebClient.builder().build(), transformer);
        ReflectionTestUtils.setField(clientPersonCharacter, "urlService", baseUrl, String.class);
    }

    @Test
    void consultarListadoPersonajes() throws JsonProcessingException, InterruptedException {
        Mockito.when(transformer.toEntity(any())).thenReturn(responseMock.getResults().get(0), responseMock.getResults().get(1));
        mockBackEnd.enqueue(new MockResponse()
                .setResponseCode(200)
                          .setBody(mapper.writeValueAsString(responseMock))
                .addHeader("Content-Type", "application/json"));

        Flux<Personaje> personajesFlux = clientPersonCharacter.consultarListadoPersonajes();

        StepVerifier.create(personajesFlux)
                .expectNextMatches(personaje -> personaje.getName()
                        .equals("Rick Sanchez"))
                .expectNextMatches(personaje -> personaje.getName()
                        .equals("Morty Smith"))
                .thenCancel()

                .verify();
        RecordedRequest recordedRequest = mockBackEnd.takeRequest();
        Assertions.assertEquals("GET", recordedRequest.getMethod());

        /*
        *  Employee mockEmployee = new Employee(100, "Adam", "Sandler",
      32, Role.LEAD_ENGINEER);
    mockBackEnd.enqueue(new MockResponse()
      .setBody(objectMapper.writeValueAsString(mockEmployee))
      .addHeader("Content-Type", "application/json"));

    Mono<Employee> employeeMono = employeeService.getEmployeeById(100);

    StepVerifier.create(employeeMono)
      .expectNextMatches(employee -> employee.getRole()
        .equals(Role.LEAD_ENGINEER))
      .verifyComplete();
        * */
    }
}