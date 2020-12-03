package just.hazard.marketdesignerstask.dto;

import just.hazard.marketdesignerstask.util.PhoneNumberMasking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

    private String name;

    private String contact;

    public String getContact() {
        return PhoneNumberMasking.masking(contact);
    }
}
