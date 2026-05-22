        startupProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8081
          failureThreshold: 25
          periodSeconds: 3
        livenessProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8081
          failureThreshold: 3
          periodSeconds: 10
        readinessProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8081
          failureThreshold: 2
          periodSeconds: 5














          http://10.97.111.127:8082/actuator/health/liveness"