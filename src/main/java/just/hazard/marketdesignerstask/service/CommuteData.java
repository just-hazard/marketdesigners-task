package just.hazard.marketdesignerstask.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class CommuteData {

    private final String commuteDataUrl = "https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6534cd3e-9ae5-42e6-85fa-b5244232e5f5/time_data.txt?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20201128%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20201128T081144Z&X-Amz-Expires=86400&X-Amz-Signature=310205046d3bf4aaa18c7fc50491acc1829f1bf6509c87e5cbdc2c171d6507ed&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22time_data.txt%22";

    List<LocalTime> attendance = new ArrayList<>();
    List<LocalTime> leaveWork = new ArrayList<>();

    public void getCommuteData() {
        URI url = URI.create(commuteDataUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        Stream<String> stream = Objects.requireNonNull(responseEntity.getBody()).lines();
        stream.forEach(s ->
        {
            split(s.split(" ",2));
        });

        attendance.forEach(System.out::println);
    }

    private void split(String[] args){
        attendance.add(stringParse(args[0]));
        leaveWork.add(stringParse(args[1]));
    }

    private LocalTime stringParse(String a){
        LocalTime localTime = LocalTime.parse(a);
        String time = localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        return LocalTime.parse(time);
    }
}
