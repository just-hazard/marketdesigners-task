package just.hazard.marketdesignerstask.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ClientControllerTest extends BaseControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("고객정보 통합 테스트")
    void getClient() throws Exception {
        mockMvc.perform(get("/client")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*").isNotEmpty())
                .andExpect(jsonPath("$.[0].name").value("배진섭"))
                .andExpect(jsonPath("$.[0].contact").value("010-0000-0**0"));
    }
}