package subway.subway.application.in;

import subway.subway.domain.SubwayLine;

public interface SubwayLineCloseUsecase {

    void closeSubwayLine(SubwayLineCloseUsecase.Command command);

    class Command {
        private final SubwayLine.Id id;

        public Command(SubwayLine.Id id) {
            this.id = id;
        }

        public SubwayLine.Id getId() {
            return id;
        }
    }
}
