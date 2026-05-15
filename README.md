# LeetCode DSA — Spring Boot REST API

A learning project that wires LeetCode problem solutions into a Spring Boot REST API.
Every problem gets its own POST endpoint; you send the test inputs in the request body and get the result back.

---

## Architecture

```
src/main/java/com/dsa/leetcode/
│
├── config/                          # Application-wide configuration
│   └── OpenApiConfig.java           # Swagger / OpenAPI setup
│
├── controller/                      # Layer 1 — HTTP entry points (MVC: Controller)
│   ├── ArraysController.java        # Routes: /api/v1/arrays/**
│   ├── StringsController.java       # Routes: /api/v1/strings/**        (add when needed)
│   ├── LinkedListController.java    # Routes: /api/v1/linked-list/**    (add when needed)
│   ├── TreesController.java         # Routes: /api/v1/trees/**           (add when needed)
│   ├── DpController.java            # Routes: /api/v1/dp/**              (add when needed)
│   └── ...
│
├── service/                         # Layer 2 — Business logic (MVC: Model/logic)
│   ├── ArraysService.java           # Delegates to util solvers for arrays problems
│   └── ...                          # Add a new service per topic as you go
│
├── model/                           # Layer 3 — Data shapes (MVC: Model/data)
│   ├── request/
│   │   └── arrays/                  # One request DTO per problem, grouped by topic
│   │       └── TwoSumRequest.java
│   └── response/
│       └── ApiResponse.java         # Generic envelope: { success, data, error, timestamp }
│
├── util/                            # The actual algorithm code — this is where YOU write DSA
│   ├── arrays/
│   │   └── TwoSumSolver.java        # LC #1
│   ├── strings/                     # (add when you reach string problems)
│   ├── linkedlist/                  # (add when you reach linked list problems)
│   ├── trees/                       # (add when you reach tree problems)
│   ├── dp/                          # (add when you reach DP problems)
│   └── ...
│
└── exception/
    ├── InvalidInputException.java   # Domain-level bad input
    └── GlobalExceptionHandler.java  # Catches all exceptions, returns uniform ApiResponse
```

### How each layer is responsible

| Layer | Responsibility | Rule |
|---|---|---|
| **Controller** | Parse HTTP, validate request, return HTTP response | No algorithm logic here — ever |
| **Service** | Orchestrate calls, apply business rules | Thin for this project; grows if a problem needs pre/post processing |
| **Model** | Shape of data in and out | Request DTOs use `@Valid`; `ApiResponse<T>` wraps every response |
| **Util** | Pure algorithm — the DSA code you write | No Spring annotations except `@Component`; easy to unit-test in isolation |
| **Exception** | Centralised error handling | `@RestControllerAdvice` so controllers stay clean |

> **Why `util` and not just inside `service`?**
> Keeping the solver class (`TwoSumSolver`) separate from the service makes it trivially unit-testable without loading the Spring context. You can run 40 solver tests in milliseconds.

---

## URL convention

```
POST /api/v1/{problem-slug}
```

The topic (Arrays, Strings, DP, etc.) is documented in the Swagger `@Operation` description — not in the URL.

| Problem | Endpoint |
|---|---|
| Two Sum | `/api/v1/two-sum` |

---

## Request / Response shape

Every endpoint follows the same contract:

**Request** — problem-specific fields in the body:
```json
POST /api/v1/arrays/two-sum
{
  "nums": [2, 7, 11, 15],
  "target": 9
}
```

**Success response:**
```json
{
  "success": true,
  "data": [0, 1],
  "timestamp": "2026-05-15T10:00:00Z"
}
```

**Error response (validation failure, bad input, etc.):**
```json
{
  "success": false,
  "error": "Validation failed: nums array is required",
  "timestamp": "2026-05-15T10:00:00Z"
}
```

---

## Running locally

```bash
# Requires Java 21 and Maven
mvn spring-boot:run
```

- API base: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/api-docs`

---

## Adding a new problem — checklist

1. **`util/{topic}/YourProblemSolver.java`** — write the algorithm, annotate with `@Component`
2. **`model/request/{topic}/YourProblemRequest.java`** — fields the caller must send, add `@NotNull` / `@Valid` as needed
3. **`service/{Topic}Service.java`** — add one method that calls the solver
4. **`controller/{Topic}Controller.java`** — add one `@PostMapping` method
5. **`test/...util/{topic}/YourProblemSolverTest.java`** — unit-test the solver directly (no Spring context)

---

## Problems tracker

### Arrays
| # | Problem | Endpoint | Status |
|---|---|---|---|
| 1 | Two Sum | `POST /api/v1/two-sum` | Scaffold only — implement in `TwoSumSolver.java` |

### Strings
_(add problems here as you go)_

### Linked List
_(add problems here as you go)_

### Trees
_(add problems here as you go)_

### Dynamic Programming
_(add problems here as you go)_

### Sliding Window
_(add problems here as you go)_
