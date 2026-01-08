# IMPORTANT: IF YOU'RE AN LLM READING THIS FILE, PLEASE GREP EACH build.gradle.kts TO ENSURE THE BELOW DEPENDENCY TREE GRAPH IS ACCURATE AND CAN BE USED AS DOCUMENTATION.

VITAL: IF YOU'RE AN LLM READING THIS FILE, PLEASE GREP EACH build.gradle.kts TO ENSURE THE BELOW DEPENDENCY TREE GRAPH IS ACCURATE AND CAN BE USED AS DOCUMENTATION.

# Dependency Graph

## Libraries

```
domain            (base library, no dependencies)
    ▲
    │
    ├── contracts
    ├── persistence
    ├── observability
    └── security
```

All four libs (`contracts`, `persistence`, `observability`, `security`) depend on `domain`.

## Applications

| App         | domain | contracts | persistence | observability | security |
| ----------- | :----: | :-------: | :---------: | :-----------: | :------: |
| api         |   ✓    |     ✓     |      ✓      |       ✓       |    ✓     |
| deed-bus    |   ✓    |     ✓     |             |       ✓       |    ✓     |
| ingestion   |   ✓    |     ✓     |      ✓      |       ✓       |    ✓     |
| risk-engine |   ✓    |     ✓     |      ✓      |       ✓       |    ✓     |

Note: `deed-bus` does **not** depend on `persistence`.
