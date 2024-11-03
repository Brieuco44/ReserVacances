package fr.reservacances.api.vol;

import fr.reservacances.TestUtil;
import fr.reservacances.annotation.WithMockUserId;
import fr.reservacances.repository.vol.VolRepository;
import fr.reservacances.request.vol.CreateOrUpdateReservationVolRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ReservationVolIntegrationTest {

    private static final String ENDPOINT = "/api/vol/reservationvol";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";

    private static final String RESERVATION_VOL_ID = "c6b2c7bb-3046-4b4f-9087-9a76a77e7e4f";
    private static final int NB_ENFANTS = 2;
    private static final int NB_ADULTES = 2;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private VolRepository volRepository;

    // UPDATE
    @Test
    @WithMockUserId
    void shouldCreated() throws Exception {
        // given
        CreateOrUpdateReservationVolRequest request = CreateOrUpdateReservationVolRequest.builder()
                .volId(RESERVATION_VOL_ID)
                .nbEnfant(NB_ENFANTS)
                .nbAdulte(NB_ADULTES)
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

    // CREATE
    @Test
    void shouldCreateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateReservationVolRequest request = CreateOrUpdateReservationVolRequest.builder()
                .volId(RESERVATION_VOL_ID)
                .nbEnfant(NB_ENFANTS)
                .nbAdulte(NB_ADULTES)
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
    void volIdExist() {
        this.volRepository.findById(RESERVATION_VOL_ID);
        Mockito.verify(this.volRepository).findById(RESERVATION_VOL_ID);
    }



    // UPDATE
    @Test
    void shouldUpdateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateReservationVolRequest request = CreateOrUpdateReservationVolRequest.builder()
                .volId(RESERVATION_VOL_ID)
                .nbEnfant(NB_ENFANTS)
                .nbAdulte(NB_ADULTES)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, RESERVATION_VOL_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}
