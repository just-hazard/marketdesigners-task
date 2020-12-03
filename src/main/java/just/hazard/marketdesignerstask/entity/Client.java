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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    private String name;    // 이름

    private String contact; // 연락처

    private LocalDateTime createdDate;  // 등록일

    @Enumerated(EnumType.STRING)
    private Whether termsAndConditions; // 이용약관동의여부

    @Enumerated(EnumType.STRING)
    private Whether requestAQuote;  // 견적요청을 위한 개인정보 제3자 제공동의여부

    @Enumerated(EnumType.STRING)
    private Whether marketingInformation;   // 마케팅 정보수신 동의여부

    @OneToMany(mappedBy = "client")
    private List<ClientFeedbackLog> clientFeedbackLogs = new ArrayList<>();

}
