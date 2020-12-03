package just.hazard.marketdesignerstask.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HomeMoveControllerTest extends BaseControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("가정이사 신청접수 리스트 통합테스트")
    void getHomeMoveApplication() throws Exception {
        mockMvc.perform(get("/homemove")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*").isNotEmpty())
                .andExpect(jsonPath("$.total_data_count").value(2))
                .andExpect(jsonPath("$.homeMoveList[0].name").value("홍길동"))
                .andExpect(jsonPath("$.homeMoveList[0].contact").value("010-4938-2**8"))
                .andExpect(jsonPath("$.homeMoveList[0].sigudongDeparture").value("서울 송파구 방이동"))
                .andExpect(jsonPath("$.homeMoveList[0].sigudongArrive").value("경북 김천시 율곡동"))
                .andExpect(jsonPath("$.homeMoveList[0].moveDate").value("2019-02-06"))
                .andExpect(jsonPath("$.homeMoveList[0].archiveMove").value("TRUE"));
    }
}