package just.hazard.marketdesignerstask.service;

import just.hazard.marketdesignerstask.dto.Commute;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class OfficePersonnelCheck {

    Commute commute = new Commute();

    public void getCommuteData() throws IOException {

        ClassPathResource resource = new ClassPathResource("time_data.txt");
            Path path = Paths.get(resource.getURI());
            List<String> commutes = Files.readAllLines(path);
            commutes.forEach(s ->
            {
                try {
                    splitDataAdd(s.split(" ",2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
    }

    private void splitDataAdd(String[] array) throws ParseException {
        commute.getAttendance().add(dataParse(array[0]));
        commute.getLeaveWork().add(dataParse(array[1]));
    }

    private LocalTime dataParse(String commuteData) throws ParseException {
        Date date = commute.getSimpleDateFormat().parse(commuteData);
        String time = commute.getSimpleDateFormat().format(date);
        return LocalTime.parse(time);
    }

    public void commutersCheck(LocalTime inputTime) {
        int index = 0;
        for(LocalTime time : commute.getAttendance()) {
            if(time.isBefore(inputTime) && commute.getLeaveWork().get(index).isAfter(inputTime))
                commute.setCount();
            index++;
        }
        System.out.println("해당 시간에 있던 인원은 총 : " + commute.getCount());
    }

    public Commute getCommute() {
        return commute;
    }
}
