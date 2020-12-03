package just.hazard.marketdesignerstask.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Vehicle {

    private Integer one;    // 1톤
    private Integer twoPointFive;   // 2.5톤
    private Integer five;   // 5톤
    private Integer other;  // 기타

}
