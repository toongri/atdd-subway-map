package subway.subway.application.out;

import subway.subway.application.query.SubwayLineResponse;
import subway.subway.domain.SubwayLine;

import java.util.Optional;

public interface SubwayLineDetailQueryPort {
    SubwayLineResponse findOne(SubwayLine.Id id);
}