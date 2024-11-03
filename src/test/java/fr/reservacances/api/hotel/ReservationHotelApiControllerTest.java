package fr.reservacances.api.hotel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import fr.reservacances.TestUtil;
import fr.reservacances.annotation.WithMockUserId;
import fr.reservacances.request.hotel.CreateOrUpdateReservationHotelRequest;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:/hotel.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class ReservationHotelApiControllerTest {
    private static final String ENDPOINT = "/api/reservation-hotel";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";

    private static final String RESERVATION_ID_RECHERCHE = "r1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f";
    private static final String RESERVATION_ID_DELETE = "r1a2b3c4-5d6e-7f8g-9h0i-1j2k3l4m5n6o";
    private static final String RESERVATION_ID_UPDATE = "r1y2z3a4-5b6c-7d8e-9f0g-1h2i3j4k5l6m";
    private static final String CHAMBRE_ID = "c1d2e3f4-5a6b-7c8d-9e0f-1a2b3c4d5e6f";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindAllReservationHotelStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    void shouldFindReservationHotelByIdStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc
                .perform(MockMvcRequestBuilders.get(ENDPOINT_ID, RESERVATION_ID_RECHERCHE));

        // then
        result
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(RESERVATION_ID_RECHERCHE));
    }

    @Test
    @WithMockUserId
    void shouldCreateStatusCreated() throws Exception {
        // given
        CreateOrUpdateReservationHotelRequest request = CreateOrUpdateReservationHotelRequest.builder()
                .chambreId(CHAMBRE_ID)
                .dateDebut(LocalDateTime.parse("2022-11-01T00:00:00"))
                .dateFin(LocalDateTime.parse("2022-11-10T00:00:00"))
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
    @WithMockUserId
    void shouldCreateStatusConflict() throws Exception {

        // given
        CreateOrUpdateReservationHotelRequest request2 = CreateOrUpdateReservationHotelRequest.builder()
                .chambreId(CHAMBRE_ID)
                .dateDebut(LocalDateTime.parse("2024-10-01T00:00:00"))
                .dateFin(LocalDateTime.parse("2024-12-04T00:00:00"))
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request2)));

        // then
        result.andExpect(MockMvcResultMatchers.content()
                .string("La chambre est déjà réservée pour la période sélectionnée."));
    }

    @Test
    @WithMockUserId
    void shouldUpdateStatusOk() throws Exception {
        // given
        CreateOrUpdateReservationHotelRequest request = CreateOrUpdateReservationHotelRequest.builder()
                .chambreId(CHAMBRE_ID)
                .dateDebut(LocalDateTime.parse("2022-11-01T00:00:00"))
                .dateFin(LocalDateTime.parse("2022-11-10T00:00:00"))
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, RESERVATION_ID_UPDATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUserId
    void shouldUpdateStatusConflict() throws Exception {
        // given
        CreateOrUpdateReservationHotelRequest request = CreateOrUpdateReservationHotelRequest.builder()
                .chambreId(CHAMBRE_ID)
                .dateDebut(LocalDateTime.parse("2024-10-01T00:00:00"))
                .dateFin(LocalDateTime.parse("2024-12-04T00:00:00"))
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, RESERVATION_ID_UPDATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.content()
                .string("La chambre est déjà réservée pour la période sélectionnée."));
    }

    @Test
    @WithMockUserId
    void shouldDeleteStatusOk() throws Exception {
        // when
        ResultActions result = this.mockMvc
                .perform(MockMvcRequestBuilders.delete(ENDPOINT_ID, RESERVATION_ID_DELETE));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
