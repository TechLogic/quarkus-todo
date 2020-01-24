package de.techlogic

import org.eclipse.microprofile.health.HealthCheck
import org.eclipse.microprofile.health.HealthCheckResponse
import org.eclipse.microprofile.health.Liveness
import javax.enterprise.context.ApplicationScoped

@Liveness
@ApplicationScoped
class HealthChecks : HealthCheck {
    override fun call() = HealthCheckResponse.up("Running")
    

}