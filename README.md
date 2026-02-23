# multi-threading

Practice examples as a part of the Udemy course:  
[Java Multithreading, Concurrency & Performance Optimization](https://www.udemy.com/course/java-multithreading-concurrency-performance-optimization)

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/) and Docker Compose

That's it! No local Java or Maven installation needed.

## Quick Start

```bash
# Clone the repo
git clone https://github.com/vishnu-r-1995/multi-threading.git
cd multi-threading

# Run the verification example
docker compose run --rm dev com.example.threading.HelloThreads
```

## Usage

### Development mode (recommended)

Uses Maven to compile and run on the fly — ideal for iterating on examples:

```bash
docker compose run --rm dev com.example.threading.HelloThreads
```

### Production build

Builds a Docker image with compiled classes, then runs a specific class:

```bash
docker compose build app
docker compose run --rm app com.example.threading.HelloThreads
```

## Project Structure

```
multi-threading/
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── threading/
                        └── HelloThreads.java   # Starter example
```

## Adding New Examples

Create a new Java file with a `main` method under `src/main/java/com/example/threading/`:

```java
package com.example.threading;

public class MyExample {
    public static void main(String[] args) {
        // Your code here
    }
}
```

Then run it:

```bash
docker compose run --rm dev com.example.threading.MyExample
```

## Tech Stack

| Tool   | Version | Purpose              |
|--------|---------|----------------------|
| Java   | 21 LTS  | Language runtime     |
| Maven  | 3.9     | Build & dependencies |
| Docker | Latest  | Portable environment |