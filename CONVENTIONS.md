# Project Conventions

## Naming — Controller, Service, Util

Every LeetCode problem is treated as its own independent feature.
Each problem gets its own Controller, Service, and Util class named after the **problem**, not the data structure it belongs to.

### Rule

```
{ProblemName}Controller   →  TwoSumController
{ProblemName}Service      →  TwoSumService
{ProblemName}Solver       →  TwoSumSolver       (lives in util/)
{ProblemName}Request      →  TwoSumRequest      (lives in model/request/{topic}/)
```

### Why not `ArraysController`?

A controller named `ArraysController` implies it owns the concept of "Arrays".
That leads to bloated controllers with 10+ unrelated methods crammed into one class.

A controller named `TwoSumController` owns exactly one problem — one endpoint.
Adding a new problem never touches an existing file.

This is the same principle used in real production APIs:
`PaymentController` not `FinanceController`, `UserRegistrationController` not `UserController`.

### Example — adding a new problem (Best Time to Buy and Sell Stock)

| File | Path |
|---|---|
| `BestTimeToBuyAndSellStockController.java` | `controller/` |
| `BestTimeToBuyAndSellStockService.java` | `service/` |
| `BestTimeToBuyAndSellStockSolver.java` | `util/arrays/` |
| `BestTimeToBuyAndSellStockRequest.java` | `model/request/arrays/` |

---

## Where the DSA topic lives

The topic (Arrays, Strings, DP, etc.) is **not** part of the URL.
It is documented in the Swagger `@Operation` description and the `@Tag` on the controller.

```java
// Good
@Tag(name = "Two Sum", description = "LC #1 — Arrays")
@PostMapping("/api/v1/two-sum")

// Bad — topic in URL
@PostMapping("/api/v1/arrays/two-sum")
```

In Swagger UI, `@Tag` groups endpoints visually. The `@Operation` description carries the topic label.

---

## File location for the Util (solver) class

Solver classes live under `util/{topic}/` — the **only** place where the topic appears as a folder name.
The class itself is still named after the problem (`TwoSumSolver`), not the topic.
The subfolder exists purely so 40 solver files don't pile into a single flat directory.

```
util/
├── arrays/
│   └── TwoSumSolver.java
├── strings/
│   └── (your string problem solvers)
├── linkedlist/
├── trees/
└── dp/
```

---

## One problem = one endpoint

Each problem maps to exactly **one** `@PostMapping`. No shared endpoints, no query-param switching between problems.

```
POST /api/v1/two-sum
POST /api/v1/best-time-to-buy-and-sell-stock
POST /api/v1/valid-palindrome
```
