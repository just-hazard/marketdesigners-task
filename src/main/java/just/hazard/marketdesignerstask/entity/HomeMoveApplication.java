package just.hazard.marketdesignerstask.entity;

import just.hazard.marketdesignerstask.enums.Whether;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeMoveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_move_application_id")
    private Long id;

    private String name;    // 이름

    private String contact; // 연락처

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "si", column = @Column(name = "departure_si")),
            @AttributeOverride(name = "gu", column = @Column(name = "departure_gu")),
            @AttributeOverride(name = "dong", column = @Column(name = "departure_dong")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "departure_detailAddress")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "departure_zipCode"))
    })
    private Address departureAddress;   // 츨발 주소정보

    private int numberOfDepartures; // 출발지 층수

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "si", column = @Column(name = "arrive_si")),
            @AttributeOverride(name = "gu", column = @Column(name = "arrive_gu")),
            @AttributeOverride(name = "dong", column = @Column(name = "arrive_dong")),
            @AttributeOverride(name = "detailAddress", column = @Column(name = "arrive_detailAddress")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "arrive_zipCode"))
    })
    private Address arriveAddress;  // 도착지 주소정보

    private int numberOfDestinations;   // 도착지 층수

    private LocalDate moveDate; // 이사일자

    @Enumerated(EnumType.STRING)
    private Whether archiveMove;    // 보관이사

    @Enumerated(EnumType.STRING)
    private Whether termsAndConditions; // 이용약관동의여부

    @Enumerated(EnumType.STRING)
    private Whether requestAQuote;  // 견적요청을 위한 개인정보 제3자 제공동의여부

    @Enumerated(EnumType.STRING)
    private Whether marketingInformation;   // 마케팅 정보수신 동의여부


}
