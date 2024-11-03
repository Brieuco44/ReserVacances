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
import fr.reservacances.request.hotel.CreateOrUpdateChambreRequest;


@SpringBootTest
@AutoConfigureMockMvc
public class ChambreApiControllerTest {

    private static final String ENDPOINT = "/api/chambre";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";
    private static final String ENDPOINT_HOTEL = "/api/chambre/hotel/{id}";
    
    private static final String CHAMBRE_ID = "c1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f";
    private static final String HOTEL_ID = "h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f";

    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindAllChambreStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));
        
        // then
        result
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(29)));

    }

    @Test
    void shouldFindChambreByIdStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_ID, CHAMBRE_ID));
        
        // then
        result
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("c1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.numero").value("101"));
    }

    @Test
    void shouldFindChambreByHotelStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_HOTEL, "h1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f"));
        
        // then
        result.andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(11)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("c1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f"))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].numero").value("101"));

    }

    @Test
    @WithMockUser(roles = "HOTEL_MANAGER")
    void shouldCreateStatusCreated() throws Exception {
        // given
        CreateOrUpdateChambreRequest request = CreateOrUpdateChambreRequest.builder()
                .numero("101")
                .prix(42)
                .hotelId(HOTEL_ID)
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
        CreateOrUpdateChambreRequest request = CreateOrUpdateChambreRequest.builder()
                .numero("101")
                .hotelId(HOTEL_ID)
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
        CreateOrUpdateChambreRequest request = CreateOrUpdateChambreRequest.builder()
                .numero("101")
                .prix(42)
                .hotelId(HOTEL_ID)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, CHAMBRE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateStatusRefused() throws Exception {
        // given
        CreateOrUpdateChambreRequest request = CreateOrUpdateChambreRequest.builder()
                .numero("101")
                .hotelId(HOTEL_ID)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, CHAMBRE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "HOTEL_MANAGER")
    void shouldDeleteStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_ID, CHAMBRE_ID));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteStatusRefused() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_ID, CHAMBRE_ID));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

}