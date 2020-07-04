package ie.benjamin.AirlineSeatPlannerAzureFunction;

import ie.benjamin.AirlineSeatPlannerAzureFunction.model.input.PlaneModel;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class AirlineSeatPlannerHandler extends AzureSpringBootRequestHandler<PlaneModel, Object> {

    @FunctionName("AirlineSeatPlanner")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<PlaneModel>> request,
            ExecutionContext context) {

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(request.getBody().get(), context))
                .header("Content-Type", "application/json")
                .build();
    }
}
