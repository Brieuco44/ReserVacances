package fr.reservacances.api.voiture;

import java.time.LocalDateTime;

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
import fr.reservacances.annotation.WithMockUserId;
import fr.reservacances.request.voiture.CreateOrUpdateReservationVoitureRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservationVoitureApiControllerIntegrationTest {

        private static final String ENDPOINT = "/api/reservation/voiture";
        private static final String ENDPOINT_ALL = ENDPOINT + "/all";
        private static final String ENDPOINT_ID = ENDPOINT + "/{id}";

        private static final String VOITURE_ID = "a1d38d1f-4e72-4f5f-9a71-161c5b209e99";
        private static final String RESERVATION_ID = "b2e15e7b-bf91-4118-9fc0-9b6d1c8fcadb";

        @Autowired
        private MockMvc mockMvc;

        // GET
        @Test
        void shouldFindAllStatusForbidden() throws Exception {
                // given

                // when
                ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_ALL));

                // then
                result
                                .andExpect(MockMvcResultMatchers.status().isForbidden());
        }

        @Test
        @WithMockUser(roles = "CAR_MANAGER")
        void shouldFindAllStatusOk() throws Exception {
                // given

                // when
                ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_ALL));

                // then
                result
                                .andExpect(MockMvcResultMatchers.status().isOk());
        }

        // // // CREATE
        @Test
        void shouldCreateStatusForbidden() throws Exception {
                // given
                CreateOrUpdateReservationVoitureRequest request = CreateOrUpdateReservationVoitureRequest.builder()
                                .dateDebut(LocalDateTime.parse("2024-12-20T00:00:00"))
                                .dateFin(LocalDateTime.parse("2024-12-30T23:59:59"))
                                .voitureId(VOITURE_ID)
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
        @WithMockUserId
        void shouldCreateStatusCreated() throws Exception {
                // given
                CreateOrUpdateReservationVoitureRequest request = CreateOrUpdateReservationVoitureRequest.builder()
                                .dateDebut(LocalDateTime.of(2024, 10, 10, 1, 1, 1))
                                .dateFin(LocalDateTime.of(2024, 10, 20, 1, 1, 1))
                                .voitureId(VOITURE_ID)
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

        // UPDATE
        @Test
        void shouldUpdateStatusForbidden() throws Exception {
                // given
                CreateOrUpdateReservationVoitureRequest request = CreateOrUpdateReservationVoitureRequest.builder()
                                .dateDebut(LocalDateTime.parse("2024-12-15T00:00:00"))
                                .dateFin(LocalDateTime.parse("2024-12-15T00:00:00"))
                                .voitureId(VOITURE_ID)
                                .build();

                // when
                ResultActions result = this.mockMvc.perform(
                                MockMvcRequestBuilders
                                                .put(ENDPOINT_ID, RESERVATION_ID)
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(TestUtil.json(request)));

                // then
                result.andExpect(MockMvcResultMatchers.status().isForbidden());
        }

        // DELETE
        @Test
        void shouldDeleteByIdStatusForbidden() throws Exception {
                // given

                // when
                ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_ID, RESERVATION_ID));

                // then
                result.andExpect(MockMvcResultMatchers.status().isForbidden());
        }

        @Test
        @WithMockUserId
        void shouldDeleteByIdStatusOk() throws Exception {
                // given

                // when
                ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_ID, RESERVATION_ID));

                // then
                result.andExpect(MockMvcResultMatchers.status().isOk());
        }
}
