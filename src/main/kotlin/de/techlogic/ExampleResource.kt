package de.techlogic

import org.eclipse.microprofile.metrics.MetricUnits
import org.eclipse.microprofile.metrics.annotation.Counted
import org.eclipse.microprofile.metrics.annotation.Timed
import java.util.concurrent.TimeUnit
import javax.enterprise.context.RequestScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
@RequestScoped
class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name="performedHelloWorld", description = "How many time did somebody greet")
    @Timed(name= "checksHelloWorld",description = "How long does a greeting take",unit = MetricUnits.MILLISECONDS)
    fun hello(): HelloWorld {
        return HelloWorld()
    }

}