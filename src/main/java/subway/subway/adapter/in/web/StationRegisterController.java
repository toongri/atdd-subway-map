package subway.subway.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import subway.subway.adapter.in.web.mapper.StationRegisterMapper;
import subway.subway.application.in.StationRegisterUsecase;
import subway.subway.application.query.StationResponse;

import java.net.URI;

@RestController
public class StationRegisterController {

    private final StationRegisterUsecase stationRegisterUsecase;
    private final StationRegisterMapper mapper;

    public StationRegisterController(StationRegisterUsecase stationRegisterUsecase, StationRegisterMapper mapper) {
        this.stationRegisterUsecase = stationRegisterUsecase;
        this.mapper = mapper;
    }

    @PostMapping("/stations")
    public ResponseEntity<StationResponse> createStation(@RequestBody Request stationRegisterRequest) {
        StationRegisterUsecase.Command command = mapper.mapFrom(stationRegisterRequest);
        StationResponse station = stationRegisterUsecase.saveStation(command);
        return ResponseEntity.created(URI.create("/stations/" + station.getId())).body(station);
    }

    public static class Request {
        private String name;
        public String getName() {
            return name;
        }
    }
}
