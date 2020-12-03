package just.hazard.marketdesignerstask.runner;

import just.hazard.marketdesignerstask.entity.*;
import just.hazard.marketdesignerstask.enums.Whether;
import just.hazard.marketdesignerstask.repositories.ClientFeedbackLogRepository;
import just.hazard.marketdesignerstask.repositories.ClientRepository;
import just.hazard.marketdesignerstask.repositories.HomeMoveRepository;
import just.hazard.marketdesignerstask.repositories.MoveCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    private final MoveCompanyRepository moveCompanyRepository;

    private final ClientRepository clientRepository;

    private final HomeMoveRepository homeMoveRepository;

    private final ClientFeedbackLogRepository clientFeedbackLogRepository;

    @Override
    public void run(ApplicationArguments args) {

        MoveCompany moveCompany = MoveCompany.builder()
                                    .businessName("업체명")
                                    .contact("010-0000-0000")
                                    .address(Address.builder().si("서울").gu("송파구").dong("방이동").build())
                                    .matchable(Whether.TRUE)
                                    .build();

        MoveCompany moveCompany1 = MoveCompany.builder()
                .businessName("업체명1")
                .contact("010-0000-0000")
                .address(Address.builder().si("경북").gu("김천시").dong("율곡동").build())
                .matchable(Whether.FALSE)
                .build();

        moveCompanyRepository.saveAll(Arrays.asList(moveCompany,moveCompany1));

        Client client = Client.builder()
                            .name("배진섭")
                            .contact("010-0000-0000")
                            .build();

        Client client1 = Client.builder()
                .name("아자르")
                .contact("010-1234-5678")
                .build();

        clientRepository.saveAll(Arrays.asList(client,client1));


        HomeMoveApplication homeMoveApplication = HomeMoveApplication.builder()
                .name("홍길동")
                .contact("010-4938-2228")
                .departureAddress(Address.builder().si("서울").gu("송파구").dong("방이동").build())
                .arriveAddress(Address.builder().si("경북").gu("김천시").dong("율곡동").build())
                .moveDate(LocalDate.of(2019,2,6))
                .archiveMove(Whether.TRUE)
                .build();

        HomeMoveApplication homeMoveApplication1 = HomeMoveApplication.builder()
                .name("길동")
                .contact("010-4938-2229")
                .departureAddress(Address.builder().si("서울").gu("송파구").dong("방이동1").build())
                .arriveAddress(Address.builder().si("경북").gu("김천시").dong("율곡동1").build())
                .moveDate(LocalDate.of(2019,2,7))
                .archiveMove(Whether.FALSE)
                .build();

        homeMoveRepository.saveAll(Arrays.asList(homeMoveApplication,homeMoveApplication1));

        ClientFeedbackLog clientFeedbackLog = ClientFeedbackLog.builder()
                .client(client)
                .moveCompany(moveCompany)
                .build();

        ClientFeedbackLog clientFeedbackLog1 = ClientFeedbackLog.builder()
                .client(client1)
                .moveCompany(moveCompany1)
                .build();

        clientFeedbackLogRepository.saveAll(Arrays.asList(clientFeedbackLog,clientFeedbackLog1));
    }
}
