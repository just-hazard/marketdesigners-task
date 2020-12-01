package just.hazard.marketdesignerstask.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Collections;

public class OfficePersonnelCheckTest {

    @Test
    @DisplayName("통합 테스트")
    void integrationTest() throws IOException {
        // given
        OfficePersonnelCheck officePersonnelCheck = new OfficePersonnelCheck();
        officePersonnelCheck.getCommuteData();
        // when
        officePersonnelCheck.commutersCheck(LocalTime.of(14,0,0));
        // then
        Assertions.assertEquals(15, officePersonnelCheck.getCommute().getCount());
    }

    @Test
    @DisplayName("해당 시간에 포함 되는지 체크")
    void timeCompare() {
        // given
        OfficePersonnelCheck officePersonnelCheck = new OfficePersonnelCheck();
        // when
        officePersonnelCheck.getCommute().setAttendance(Collections.singletonList(LocalTime.of(10, 0, 0)));
        officePersonnelCheck.getCommute().setLeaveWork(Collections.singletonList(LocalTime.of(12, 0, 0)));
        officePersonnelCheck.commutersCheck(LocalTime.of(13,0,0));
        // then
        Assertions.assertNotEquals(1, officePersonnelCheck.getCommute().getCount());
        Assertions.assertEquals(0, officePersonnelCheck.getCommute().getCount());
    }

    @Test
    @DisplayName("파일 읽기 테스트")
    void fileRead() throws IOException {
        // given
        OfficePersonnelCheck officePersonnelCheck = new OfficePersonnelCheck();
        // when
        officePersonnelCheck.getCommuteData();
        // then
        Assertions.assertNotNull(officePersonnelCheck.getCommute().getAttendance());
        Assertions.assertNotNull(officePersonnelCheck.getCommute().getLeaveWork());
        Assertions.assertEquals(50, officePersonnelCheck.getCommute().getLeaveWork().size());
        Assertions.assertEquals(50, officePersonnelCheck.getCommute().getAttendance().size());
        Assertions.assertEquals(LocalTime.of(10,30,58), officePersonnelCheck.getCommute().getAttendance().get(0));
        Assertions.assertEquals(LocalTime.of(13,28,15), officePersonnelCheck.getCommute().getLeaveWork().get(0));

    }
}
