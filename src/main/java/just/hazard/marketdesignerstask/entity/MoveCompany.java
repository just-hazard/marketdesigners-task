package just.hazard.marketdesignerstask.entity;

import just.hazard.marketdesignerstask.enums.Whether;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoveCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "move_company_id")
    private Long id;

    private String businessName;    // 업체명

    private String Ceo; // 대표이사

    private String contact; // 연락처

    @Embedded
    private Address address;    // 주소정보

    private String businessNumber;  // 사업자번호

    private LocalDateTime businessDate; // 사업자등록일자

    private int numberOfEmployees;  // 직원수

    @Embedded
    private Vehicle vehicle = new Vehicle();    // 차량수

    @Enumerated(EnumType.STRING)
    private Whether matchable;  // 매칭가능여부

    @OneToMany(mappedBy = "moveCompany")
    private List<ClientFeedbackLog> clientFeedbackLogs = new ArrayList<>();

}
