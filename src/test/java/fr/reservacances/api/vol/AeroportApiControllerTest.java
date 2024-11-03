package fr.reservacances.api.vol;

import fr.reservacances.model.localisation.Pays;
import fr.reservacances.model.localisation.Ville;
import fr.reservacances.model.vol.Aeroport;
import fr.reservacances.repository.localisation.VilleRepository;
import fr.reservacances.repository.vol.AeroportRepository;
import fr.reservacances.request.vol.CreateOrUpdateAeroportRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AeroportApiControllerTest {

    @MockBean
    private AeroportRepository aeroportRepository;

    @MockBean
    private VilleRepository villeRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "VOL_MANAGER")
    public void testCreateAeroport() throws Exception {
        Pays pays = new Pays();
        pays.setId("1");
        pays.setNom("France");

        Ville ville = new Ville();
        ville.setId("1");
        ville.setNom("Paris");
        ville.setPays(pays);

        Aeroport aeroport = new Aeroport();
        aeroport.setVille(ville);
        aeroport.setNom("Charles de Gaulle");
        aeroport.setId("1");

        Mockito.when(villeRepository.findById(Mockito.anyString())).thenReturn(Optional.of(ville));
        Mockito.when(aeroportRepository.save(Mockito.any())).thenReturn(aeroport);

        CreateOrUpdateAeroportRequest request = new CreateOrUpdateAeroportRequest();
        request.setNom("Charles de Gaulle");
        request.setVille_id("1");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/vol/aeroport")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format("{\"nom\":\"%s\", \"ville_id\":\"%s\"}", request.getNom(), request.getVille_id())))
                .andExpect(status().isCreated())
                .andReturn();

        String response = result.getResponse().getContentAsString();

        assertTrue(response.contains(String.format("\"nom\":\"%s\"", request.getNom())));
        assertTrue(response.contains(String.format("\"ville\":\"%s\"", ville.getNom())));
        assertTrue(response.contains(String.format("\"villeId\":\"%s\"", ville.getId())));
    }


    @Test
    @WithMockUser
    public void testGetAeroports_emptyDatabase() throws Exception {
        Mockito.when(aeroportRepository.findAll()).thenReturn(List.of());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/vol/aeroport")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertEquals("[]", response);
    }

    @Test
    @WithMockUser
    public void testGetAeroports_withOneRecordInDatabase() throws Exception {
        Pays pays = new Pays();
        pays.setId("1");
        pays.setNom("France");

        Ville ville = new Ville();
        ville.setId("1");
        ville.setNom("Paris");
        ville.setPays(pays);

        Aeroport aeroport = new Aeroport();
        aeroport.setVille(ville);
        aeroport.setNom("Charles de Gaulle");
        aeroport.setId("1");

        Mockito.when(aeroportRepository.findAll()).thenReturn(List.of(aeroport));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/vol/aeroport")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();

        assertTrue(response.contains(String.format("\"nom\":\"%s\"", aeroport.getNom())));
        assertTrue(response.contains(String.format("\"ville\":\"%s\"", ville.getNom())));
        assertTrue(response.contains(String.format("\"villeId\":\"%s\"", ville.getId())));
    }

}
