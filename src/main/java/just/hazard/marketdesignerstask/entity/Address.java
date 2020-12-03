package just.hazard.marketdesignerstask.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {

    private String si;

    private String gu;

    private String dong;

    private String detailAddress;

    private String zipCode;
}
