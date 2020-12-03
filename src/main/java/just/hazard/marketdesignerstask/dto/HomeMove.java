package just.hazard.marketdesignerstask.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import just.hazard.marketdesignerstask.util.PhoneNumberMasking;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HomeMove {

    private String name;    // 이름

    private String contact; // 연락처

    private String sigudongDeparture;    // 출발지

    private String sigudongArrive;   // 도착지

    private LocalDate moveDate; // 이사일자

    private String archiveMove; // 보관이사

    @JsonIgnore
    private String departure_si;
    @JsonIgnore
    private String departure_gu;
    @JsonIgnore
    private String departure_dong;

    @JsonIgnore
    private String arrive_si;
    @JsonIgnore
    private String arrive_gu;
    @JsonIgnore
    private String arrive_dong;

    public String getSigudongDeparture() {
        return departure_si+" "+departure_gu+" "+departure_dong;
    }

    public String getSigudongArrive() {
        return arrive_si+" "+arrive_gu+" "+arrive_dong;
    }

    public String getContact() {
        return PhoneNumberMasking.masking(contact);
    }
}
