package net.tsolval.dndbe.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
@AutoConfigureMockMvc
class CharacterControllerTest {

    @Autowired
    MockMvc mvc

    @Test
    void testListCharacters() {
        def response = mvc.perform(get('/characters').accept(APPLICATION_JSON)).andReturn().response
        assert response.status == OK.value()
        assert response.contentAsString ==~ /.*Characters List.*/
    }
}
