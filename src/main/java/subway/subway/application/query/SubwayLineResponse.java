package subway.subway.application.query;

import subway.subway.domain.Station;
import subway.subway.domain.SubwayLine;

import java.util.List;

public class SubwayLineResponse {
    private final Long id;
    private final String name;
    private final String color;

    private final List<SubwayLineResponse.StationResponse> stations;

    public SubwayLineResponse(SubwayLine.Id id, String name, String color, List<StationResponse> stations) {
        this.id = id.getValue();
        this.name = name;
        this.color = color;
        this.stations = stations;
    }

    public SubwayLineResponse(Long id, String name, String color, List<StationResponse> stations) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public static class StationResponse {
        private final Long id;
        private final String name;

        public StationResponse(Station.Id id, String name) {
            this.id = id.getValue();
            this.name = name;
        }

        public StationResponse(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}