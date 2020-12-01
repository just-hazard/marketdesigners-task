package just.hazard.marketdesignerstask.dto;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Commute {

    private int count = 0;

    private List<LocalTime> attendance = new ArrayList<>();

    private List<LocalTime> leaveWork = new ArrayList<>();

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    public void setCount() {
        this.count += 1;
    }
}
