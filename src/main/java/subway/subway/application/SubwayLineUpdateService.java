package subway.subway.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import subway.subway.application.in.SubwayLineUpdateUsecase;
import subway.subway.application.out.SubwayLineLoadPort;
import subway.subway.application.out.SubwayLineUpdatePort;
import subway.subway.domain.SubwayLine;

@Service
@Transactional
public class SubwayLineUpdateService implements SubwayLineUpdateUsecase {

    private final SubwayLineLoadPort subwayLineLoadPort;
    private final SubwayLineUpdatePort subwayLineUpdatePort;

    public SubwayLineUpdateService(SubwayLineLoadPort subwayLineLoadPort, SubwayLineUpdatePort subwayLineUpdatePort) {
        this.subwayLineLoadPort = subwayLineLoadPort;
        this.subwayLineUpdatePort = subwayLineUpdatePort;
    }

    @Override
    public void updateSubwayLine(Command command) {
        SubwayLine subwayLine = subwayLineLoadPort.findOne(command.getId());
        subwayLine.update(command.getName(), command.getColor());
        subwayLineUpdatePort.update(subwayLine);
    }
}
