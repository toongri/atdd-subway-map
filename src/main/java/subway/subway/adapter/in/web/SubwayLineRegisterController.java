package subway.subway.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import subway.subway.application.in.SubwayLineRegisterUsecase;
import subway.subway.application.in.command.StationRegisterCommand;
import subway.subway.application.in.command.SubwayLineRegisterCommand;
import subway.subway.application.query.StationResponse;
import subway.subway.application.query.SubwayLineResponse;
import subway.subway.domain.Kilometer;
import subway.subway.domain.Station;

import java.math.BigDecimal;
import java.net.URI;

@RestController
public class SubwayLineRegisterController {

    private final SubwayLineRegisterUsecase subwayLineRegisterUsecase;

    public SubwayLineRegisterController(SubwayLineRegisterUsecase subwayLineRegisterUsecase) {
        this.subwayLineRegisterUsecase = subwayLineRegisterUsecase;
    }

    @PostMapping("/subway-lines")
    public ResponseEntity<SubwayLineResponse> createStation(@RequestBody SubwayLineRegisterController.Request request) {
        SubwayLineRegisterCommand command = request.mapFrom();
        SubwayLineResponse subwayLineResponse = subwayLineRegisterUsecase.registerSubwayLine(command);
        return ResponseEntity.ok().body(subwayLineResponse);
    }


    static class Request {
        private String name;
        private String color;
        private Long upStationId;
        private Long downStationId;
        private int distance;

        public Request(String name, String color, Long upStationId, Long downStationId, int distance) {
            this.name = name;
            this.color = color;
            this.upStationId = upStationId;
            this.downStationId = downStationId;
            this.distance = distance;
        }

        SubwayLineRegisterCommand mapFrom() {
            return new SubwayLineRegisterCommand(
                    name,
                    color,
                    new Station.Id(upStationId),
                    new Station.Id(downStationId),
                    Kilometer.of(BigDecimal.valueOf(distance)));
        }
    }
}
