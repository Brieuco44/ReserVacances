package fr.reservacances.api.hotel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import fr.reservacances.TestUtil;
import fr.reservacances.request.hotel.CreateOrUpdateHotelRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class HotelApiControllerTest {

    private static final String ENDPOINT = "/api/hotel";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";
    private static final String ENDPOINT_VILLE = "/api/hotel/ville/{id}";

    private static final String HOTEL_ID = "h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindAllHotelStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(10)));

    }

    @Test
    void shouldFindHotelByIdStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_ID, HOTEL_ID));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Hôtel de Paris"));
    }

    @Test
    void shouldFindHotelByVilleStatusOk() throws Exception {
        // when
        ResultActions result =
        this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_VILLE, "Paris"));

        // then
        result.andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f"));

    }

    @Test
    @WithMockUser(roles = "HOTEL_MANAGER")
    void shouldCreateStatusCreated() throws Exception {
        // given
        CreateOrUpdateHotelRequest request = CreateOrUpdateHotelRequest.builder()
                .nom("Le Grand Hôtel")
                .villeId("Paris")
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldCreateStatusRefused() throws Exception {
        // given
        CreateOrUpdateHotelRequest request = CreateOrUpdateHotelRequest.builder()
                .nom("Le Grand Hôtel")
                .villeId("Paris")
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "HOTEL_MANAGER")
    void shouldUpdateStatusOk() throws Exception {
        // given
        CreateOrUpdateHotelRequest request = CreateOrUpdateHotelRequest.builder()
                .nom("Les Grands Hôtels")
                .villeId("Paris")
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, HOTEL_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateStatusRefused() throws Exception {
        // given
        CreateOrUpdateHotelRequest request = CreateOrUpdateHotelRequest.builder()
                .nom("Les Grands Hôtels")
                .villeId("Paris")
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, HOTEL_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "HOTEL_MANAGER")
    void shouldDeleteStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_ID, HOTEL_ID));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteStatusRefused() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_ID, HOTEL_ID));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}