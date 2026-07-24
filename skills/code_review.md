# Code Review — Kotlin/Android

## Checklist geral

- [ ] **Bugs** — lógica incorreta, condições de corrida, NPE evitável
- [ ] **Segurança** — sem segredos em código, sem logs de dados sensíveis, uso correto de `BuildConfig`
- [ ] **Performance** — sem alocações desnecessárias no game loop, sem operações bloqueantes na main thread
- [ ] **Complexidade** — funções pequenas e coesas; complexidade ciclomática baixa; `when` em vez de if-else encadeado
- [ ] **Legibilidade** — nomes descritivos em português, uso de extension functions quando apropriado

## Checklist Kotlin

- [ ] Preferir `val` a `var`; justificar todo uso de `var`
- [ ] Usar `data class` para entidades imutáveis de domínio
- [ ] Usar `sealed class` / `sealed interface` para modelar estados e eventos
- [ ] Evitar `!!` (non-null assertion); tratar nulabilidade com `?.`, `?:` ou `requireNotNull`
- [ ] Coroutines: verificar escopo correto (`viewModelScope`, `lifecycleScope`); sem `GlobalScope`
- [ ] Flow: usar `StateFlow` para estado de UI; `SharedFlow` para eventos únicos
- [ ] Sem `Thread.sleep` ou operações bloqueantes; usar `delay` de Coroutines

## Checklist Android / Jogo

- [ ] Lógica de jogo na camada `domain`, sem imports do Android SDK
- [ ] ViewModel não referencia `View` nem `Context` diretamente
- [ ] Recursos liberados em `onPause`/`onStop` para evitar vazamentos
- [ ] Animações e game loop usando `withFrameNanos` ou `Canvas` em thread dedicada
- [ ] Testes unitários cobrindo casos de borda da lógica de jogo

