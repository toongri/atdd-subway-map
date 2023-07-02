package subway;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 지하철역 조회 인수 테스트를 합니다.
 */
public class ReadStationAcceptanceTest extends StationAcceptanceTest {


    /**
     * Given 2개의 지하철역을 생성하고<br>
     * When 지하철역 목록을 조회하면<br>
     * Then 2개의 지하철역을 응답 받는다<br>
     */
    @DisplayName("지하철역 목록을 조회한다.")
    @Test
    void getStations() {
        //given
        지하철역_생성("강남역");
        지하철역_생성("역삼역");
        //when
        ExtractableResponse<Response> response = 지하철역_목록_조회();

        //then
        List<String> names = response.jsonPath().getList("name", String.class);
        Assertions.assertThat(names).containsExactly("강남역", "역삼역");
    }
}