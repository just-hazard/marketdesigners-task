package just.hazard.marketdesignerstask.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MoveCompanyControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("이사업체 통합테스트")
    void getMoveCompany() throws Exception {
        mockMvc.perform(get("/company")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*").isNotEmpty())
                .andExpect(jsonPath("$.[0].businessName").value("업체명"))
                .andExpect(jsonPath("$.[0].contact").value("010-0000-0**0"))
                .andExpect(jsonPath("$.[0].sigudong").value("서울 송파구 방이동"))
                .andExpect(jsonPath("$.[0].matchable").value("TRUE"));
    }
}