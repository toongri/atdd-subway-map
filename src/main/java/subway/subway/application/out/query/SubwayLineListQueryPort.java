package subway.subway.application.out.query;

import subway.subway.application.query.SubwayLineResponse;

import java.util.List;

public interface SubwayLineListQueryPort {

    List<SubwayLineResponse> findAll();


}
