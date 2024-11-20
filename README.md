# Backend Setup

## File Structure

```plaintext
backend/                                            # Root of the backend service  
├── src/                                            # Source code  
    └── main/java/com/playground/backend/core       # Core Components of the application
    └── main/java/com/playground/backend/inbound    # Incomming traffic e.g. controllers
    └── main/java/com/playground/backend/outbound   # Outgoing traffic e.g. databases
├── build.gradle.kts                                # Gradle build configuration  
└── docker/                                         # Docker configuration files  
    └── docker-compose.yaml                         # Docker Compose for PostgreSQL setup
└── docker/                                         # Docker configuration files  
```

## Local development

```
docker-compose -f docker/docker-compose.yaml up -d 
```

Start application via IntelliJ

