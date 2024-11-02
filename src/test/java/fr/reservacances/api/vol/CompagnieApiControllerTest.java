package fr.reservacances.api.vol;

import fr.reservacances.TestUtil;
import fr.reservacances.request.vol.CreateOrUpdateCompagnieRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:/vol.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class CompagnieApiControllerTest {

    private static final String ENDPOINT = "/api/vol/compagnie";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";

    private static final String COMPAGNIE_ID = "a26cb918-3d9c-49c8-9c79-3cde3eab0b6f";

    @Autowired
    private MockMvc mockMvc;

    // Helper method to build request objects
    private CreateOrUpdateCompagnieRequest buildRequest(String compagniName){
        CreateOrUpdateCompagnieRequest request = new CreateOrUpdateCompagnieRequest();
        request.setNom(compagniName);
        return request;
    }

    // GET All
    @Test
    @DirtiesContext
    void shouldFindAllStatusOk() throws Exception {
        // Act
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").isNotEmpty());
    }

    // CREATE Tests
    @Test
    void shouldCreateStatusForbidden() throws Exception {
        // Arrange
        CreateOrUpdateCompagnieRequest request = buildRequest("Ma compagnie");

        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "VOL_MANAGER")
    void shouldCreateStatusCreated() throws Exception {
        // Arrange
        CreateOrUpdateCompagnieRequest request = buildRequest("Ma compagnie");
        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    // UPDATE Tests
    @Test
    void shouldUpdateStatusForbidden() throws Exception {
        // Arrange
        CreateOrUpdateCompagnieRequest request = buildRequest("Ma compagnie");
        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, COMPAGNIE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "VOL_MANAGER")
    void shouldUpdateStatusOk() throws Exception {
        // Arrange
        CreateOrUpdateCompagnieRequest request = buildRequest("Ma compagnie");
        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, COMPAGNIE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
