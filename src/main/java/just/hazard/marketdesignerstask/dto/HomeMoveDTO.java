package just.hazard.marketdesignerstask.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HomeMoveDTO {

    private long total_data_count;

    private List<HomeMove> homeMoveList = new ArrayList<>();
}
