package just.hazard.marketdesignerstask.controller;

import just.hazard.marketdesignerstask.entity.Address;
import just.hazard.marketdesignerstask.entity.Client;
import just.hazard.marketdesignerstask.entity.ClientFeedbackLog;
import just.hazard.marketdesignerstask.entity.MoveCompany;
import just.hazard.marketdesignerstask.enums.Whether;
import just.hazard.marketdesignerstask.repositories.ClientFeedbackLogRepository;
import just.hazard.marketdesignerstask.repositories.ClientRepository;
import just.hazard.marketdesignerstask.repositories.MoveCompanyRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class ClientFeedbackLogTest {

    @Autowired
    private ClientFeedbackLogRepository feedbackLogRepository;
    @Autowired
    private MoveCompanyRepository moveCompanyRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EntityManager entityManager;


    @BeforeEach
    void setUp() {

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

        ClientFeedbackLog clientFeedbackLog = ClientFeedbackLog.builder()
                .client(client)
                .moveCompany(moveCompany)
                .build();

        ClientFeedbackLog clientFeedbackLog1 = ClientFeedbackLog.builder()
                .client(client1)
                .moveCompany(moveCompany1)
                .build();

        feedbackLogRepository.saveAll(Arrays.asList(clientFeedbackLog,clientFeedbackLog1));
    }

    @AfterEach
    void tearDown() {
        feedbackLogRepository.deleteAll();
        entityManager.createNativeQuery("ALTER TABLE client_feedback_log auto_increment = 1").executeUpdate();

        moveCompanyRepository.deleteAll();
        entityManager.createNativeQuery("alter table move_company auto_increment = 1").executeUpdate();

        clientRepository.deleteAll();
        entityManager.createNativeQuery("alter table client auto_increment = 1").executeUpdate();

    }

    @Test
    @DisplayName("연관관계 매핑 데이터 등록 확인")
    void createDataVerify() {
        // given
        Long id = 2L;
        // when
        Optional<ClientFeedbackLog> clientFeedbackLog = feedbackLogRepository.findById(id);
        // then
        Assertions.assertEquals("아자르",clientFeedbackLog.get().getClient().getName());
        Assertions.assertEquals(2L,clientFeedbackLog.get().getClient().getId());
        Assertions.assertEquals("업체명1",clientFeedbackLog.get().getMoveCompany().getBusinessName());
        Assertions.assertEquals(2L,clientFeedbackLog.get().getMoveCompany().getId());
        Assertions.assertEquals(2L,clientFeedbackLog.get().getId());
    }

    @Test
    @DisplayName("데이터 업데이트 테스트")
    void updateDataVerify() {
        // given
        MoveCompany moveCompany1 = MoveCompany.builder()
                .businessName("업체명2")
                .contact("010-0000-0000")
                .address(Address.builder().si("경북").gu("김천시").dong("율곡동").build())
                .matchable(Whether.FALSE)
                .build();

        Client client1 = Client.builder()
                .name("아자르2")
                .contact("010-1234-5678")
                .build();

        ClientFeedbackLog clientFeedbackLog = ClientFeedbackLog.builder()
                .id(2L)
                .client(client1)
                .moveCompany(moveCompany1)
                .build();
        // when
        moveCompanyRepository.save(moveCompany1);
        clientRepository.save(client1);
        feedbackLogRepository.save(clientFeedbackLog);
        ClientFeedbackLog result = feedbackLogRepository.getOne(2L);
        // then
        Assertions.assertEquals("업체명2",result.getMoveCompany().getBusinessName());
        Assertions.assertEquals("아자르2",result.getClient().getName());
    }
}
