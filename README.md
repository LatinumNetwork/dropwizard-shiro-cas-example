# Dropwizard - Shiro - CAS - Gradle Example
Wanted to put together a quick example that showed how to get Dropwizard working using Gradle, CAS, and Shiro. Spent some time digging around and couldn't find a concise example so here it is.

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
`http://localhost:8085/api/permissions/subject`
Will show you the principal
to force a login you go to any url off of your base that isn't `/api/permissions/` or `/error.html`

# Edits
inside build.gradle you should modify `casUrl` to point to your CAS instance.