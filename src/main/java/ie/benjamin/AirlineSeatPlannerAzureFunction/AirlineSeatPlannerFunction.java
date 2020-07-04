package ie.benjamin.AirlineSeatPlannerAzureFunction;

import ie.benjamin.AirlineSeatPlannerAzureFunction.model.input.PlaneModel;
import ie.benjamin.AirlineSeatPlannerAzureFunction.model.output.ResultsModel;
import ie.benjamin.AirlineSeatPlannerAzureFunction.planner.MonteCarloSeatPlanner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.function.Function;

@Slf4j
@SpringBootApplication
public class AirlineSeatPlannerFunction {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AirlineSeatPlannerFunction.class, args);
    }

    private static Object applyResultsModel(PlaneModel planeModel) {
        ResultsModel resultsModel = new MonteCarloSeatPlanner(planeModel).resolve();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(resultsModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }

    @Bean
    public Function<PlaneModel, Object> AirlineSeatPlanner() {
        return AirlineSeatPlannerFunction::applyResultsModel;
    }
}
