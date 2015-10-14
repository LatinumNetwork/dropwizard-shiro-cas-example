# stadalone-crosstab
dropwizard version of the crosstab tool

# Prereqs
1. Java 1.8
2. Gradle > 2.5
3. Git

# Building
From the root project folder
```
gradle clean enrichedJar -P<env>
```

<env> will be the environment we're building for.

# Environments
We support four environments to run crosstabs from
1. local: This is strictly for local deploys. It uses localhost:8085

# Eclipse Setup
From the root project folder
```
gradle cleanEclipse eclipse
```

# Running
```java -jar build/libs/dw-example-enriched.jar server build/resources/main/dw-example.yml```

# Viewing content
in browser go to 
`http://localhost:8085/index.html`

# API
All the API calls will be available at
`<serverUrl>/api/*`

as defined by the configuration you built