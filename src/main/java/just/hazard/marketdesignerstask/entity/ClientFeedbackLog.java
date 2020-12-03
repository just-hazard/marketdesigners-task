package just.hazard.marketdesignerstask.entity;

import just.hazard.marketdesignerstask.enums.MoveType;
import just.hazard.marketdesignerstask.enums.Satisfaction;
import just.hazard.marketdesignerstask.enums.Whether;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientFeedbackLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinet_feedback_log_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;  // 고객정보

    @ManyToOne
    @JoinColumn(name = "move_company_id")
    private MoveCompany moveCompany;    // 업체정보

    @Enumerated(EnumType.STRING)
    private MoveType moveType;  // 이사 종류

    @Enumerated(EnumType.STRING)
    private Whether informationPublic;  // 정보공개동의여부

    @Enumerated(EnumType.STRING)
    private Satisfaction expertise; // 전문성 만족도

    @Enumerated(EnumType.STRING)
    private Satisfaction price; // 가격 만족도

    @Enumerated(EnumType.STRING)
    private Satisfaction friendly;  // 친절 만족도

    @Enumerated(EnumType.STRING)
    private Whether revisit;    // 재방문의사

    private int contractPrice;  // 계약 가격

    private LocalDateTime moveDate; // 이사일

    private LocalDateTime feedbackDate; // 피드백 작성일

    private String feedbackContent; // 피드백 내용
}
