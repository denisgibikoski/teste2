package com.compasso.testecompasso.testecompasso;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import com.compasso.testecompasso.testecompasso.model.Cliente;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestecompassoApplicationTests {

    @Autowired
    private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testeCadastraCidade() throws Exception {

        String uri = "/cidade";

		Cidade cidade = new Cidade();
		cidade.setNome("Xanxere");
		cidade.setUf("SC");

        String inputJson = this.mapToJson(cidade);


        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Cidade retorno = this.mapFromJson(content, Cidade.class);
        assertTrue(retorno.getId() > 0);

	}

    @Test
    void testeCadastraCliente() throws Exception {

        String uri = "/clinte";

        Cidade cidade = new Cidade();
        cidade.setId(Long.valueOf("1"));

        Cliente clinte = new Cliente();
        clinte.setNome("Jessica");
        clinte.setSobrenome("Zonta");
        clinte.setIdade(32);
        clinte.setNascimento(LocalDate.parse("1998-01-20"));
        clinte.setSexo("F");
        clinte.setCidade(cidade);

        String inputJson = this.mapToJson(clinte);

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Cliente retorno = this.mapFromJson(content, Cliente.class);
        assertTrue(retorno.getId() > 0);

    }

    @Test
    void testeConsultarCidadePeloNome() throws Exception {

        String uri = "/cidade/nome/";


        String inputJson = "{\n " +
                            " \"nome\": \"Xanxere\"\n" +
                            "}";

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Cidade retorno = this.mapFromJson(content, Cidade.class);
        assertTrue(retorno.getId() > 0);

    }

    @Test
    void testeConsultarCidadePeloEstado() throws Exception {

        String uri = "/cidade/estado/";

        String inputJson = "{\n" +
                "    \"uf\":\"SC\"\n" +
                "}";

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Cidade[] retorno = this.mapFromJson(content, Cidade[].class);
        assertTrue(retorno.length > 0);

    }

    @Test
    void testeConsultarClientePeloNome() throws Exception {
        String uri = "/cliente/nome/Sophia";

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri) ).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
       // Cliente retorno = this.mapFromJson(content, Cliente.class);
      //assertTrue( retorno instanceof  Cliente );
    }

    @Test
    void testeConsultarClientePeloId() throws Exception {

        String uri = "/cliente/3";

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri) ).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

    }

    @Test
    void testeRemoverCliente() throws Exception {
        String uri = "/cliente/3";

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.delete(uri) ).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

    }

    @Test
    void testeAlterarNomeCliente() throws Exception {
        String uri = "/cliente/3";

        String inputJson = "{\n" +
                           "    \"nome\" : \"Sophia\"\n" +
                           "}";

        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Cliente retorno = this.mapFromJson(content, Cliente.class);
        assertTrue(retorno.getId() > 0);

    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

}
