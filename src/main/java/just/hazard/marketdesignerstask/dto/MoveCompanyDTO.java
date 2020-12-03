package just.hazard.marketdesignerstask.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import just.hazard.marketdesignerstask.util.PhoneNumberMasking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoveCompanyDTO {

    private String businessName;    // 업체명

    private String contact; // 연락처

    private String sigudong; // 주소

    private String matchable;   // 매칭가능여부

    @JsonIgnore
    private String si;
    @JsonIgnore
    private String gu;
    @JsonIgnore
    private String dong;

    public String getSigudong() {
        return si +" "+gu+" "+dong;
    }

    public String getContact() {
        return PhoneNumberMasking.masking(contact);
    }

}
