package fr.reservacances.api.localisation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.reservacances.TestUtil;
import fr.reservacances.repository.localisation.PaysRepository;
import fr.reservacances.request.localisation.CreateOrUpdatePaysRequest;

@ExtendWith(MockitoExtension.class)
public class PaysApiControllerTest {

    private static final String ENDPOINT = "/api/pays";
    private static final String FRANCE = "France";

    @Mock
    private PaysRepository repository;

    @InjectMocks
    private PaysApiController ctrl;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.ctrl).build();
    }

    @Test
    void shouldCreatePays() throws Exception {
        // given
        CreateOrUpdatePaysRequest request = CreateOrUpdatePaysRequest
            .builder()
            .nom(FRANCE)
            .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isCreated());

        Mockito.verify(this.repository).save(Mockito.any());
    }

    // @Test
    // void shouldCreatePays() throws Exception {
    //     // given
    //     CreateOrUpdatePaysRequest request = CreateOrUpdatePaysRequest
    //         .builder()
    //         .nom(FRANCE)
    //         .build();

    //     // when
    //     ResultActions result = this.mockMvc.perform(
    //             MockMvcRequestBuilders
    //                     .post(ENDPOINT)
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(TestUtil.json(request)));

    //     // then
    //     result.andExpect(MockMvcResultMatchers.status().isCreated());

    //     Mockito.verify(this.repository).save(Mockito.any());
    // }
}
