# Análise de Complexidade — Kotlin/Android

1. **Identificar o algoritmo** — mapear loops, recursões e chamadas de coleção (`map`, `filter`, `fold`)
2. **Calcular Big O temporal** — considerar operações de coleção Kotlin (ex.: `List.contains` é O(n); `Set.contains` é O(1))
3. **Calcular Big O espacial** — atenção a cópias de listas imutáveis e alocações dentro do game loop
4. **Propor melhorias** — substituir estruturas inadequadas; usar `Sequence` para pipelines lazy em vez de coleções intermediárias
5. **Manter complexidade ciclomática baixa** — extrair funções, usar `when`, evitar `if-else` aninhados

## Considerações específicas para jogos hiper casuais

- **Game loop (60 fps)**: cada frame tem ~16 ms; evitar alocações de objetos dentro do loop (causa GC jank)
- **Detecção de colisão**: preferir estruturas espaciais (quadtree, grid) para O(log n) em vez de O(n²)
- **Coleções**: usar `ArrayDeque` para filas de entidades; `IntArray`/`FloatArray` em vez de `List<Int>` para dados numéricos densos
- **Coroutines**: `Flow` com `conflate()` ou `collectLatest` para evitar backpressure em atualizações de estado de UI
- **Profiling**: usar Android Studio CPU Profiler e Memory Profiler antes de otimizar prematuramente

