# Resolução de Bugs — Kotlin/Android

1. **Reproduzir** — criar um teste unitário (JUnit5 + MockK) ou instrumentado que reproduza o bug de forma determinística
2. **Isolar a causa** — usar o debugger do Android Studio, Logcat filtrado por tag, ou `println` temporário em testes JVM
3. **Corrigir** — aplicar a menor mudança possível; preferir `val`, evitar mutabilidade desnecessária
4. **Validar** — executar `./gradlew test` (unitários) e `./gradlew connectedAndroidTest` (instrumentados)
5. **Verificar regressões** — garantir que toda a suíte de testes continua verde antes de commitar

## Dicas específicas para jogos hiper casuais

- Bugs de física/colisão: isolar a lógica na camada `domain` e testar com valores de borda
- Bugs de UI/Compose: usar `ComposeTestRule` para inspecionar o estado da árvore de composição
- Vazamentos de memória: verificar com Android Studio Memory Profiler; atenção a lambdas capturando `Context`
- ANR / jank: nunca executar lógica de jogo na main thread; usar `Dispatchers.Default` para cálculos pesados
- Crashes em produção: integrar Firebase Crashlytics e analisar stack traces com símbolos de debug

