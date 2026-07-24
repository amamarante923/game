---
name: tdd
description: Desenvolvimento guiado por testes (Test-Driven Development) em Kotlin/Android
---

# Objetivo

Implementar funcionalidades seguindo rigorosamente o ciclo TDD com JUnit5 + MockK:

1. Red
2. Green
3. Refactor

Nunca implementar código de produção antes de existir um teste falhando.

# Ferramentas

- **JUnit5** (`junit-jupiter`) — framework de testes unitários
- **MockK** — mocking idiomático para Kotlin (suporta `suspend fun`, `object`, `companion`)
- **Turbine** — testa `Flow` de forma simples e determinística
- **kotlinx-coroutines-test** — `runTest`, `TestCoroutineScheduler`, `UnconfinedTestDispatcher`
- **Compose UI Test** — testes instrumentados de UI com `ComposeTestRule`

# Processo

## Fase 1 - Red

Antes de modificar qualquer código:

- Escreva um ou mais testes que descrevam o comportamento desejado.
- Execute `./gradlew test` (unitários) ou `./gradlew connectedAndroidTest` (instrumentados).
- Confirme que falham pelo motivo esperado (não por erro de compilação).
- Documente a falha.

Checklist:

- [ ] Teste criado
- [ ] Teste executado (`./gradlew test`)
- [ ] Falha confirmada pelo motivo correto

## Fase 2 - Green

Implemente a menor quantidade possível de código para:

- Fazer o teste passar.
- Evitar otimizações prematuras.
- Evitar abstrações desnecessárias.

Checklist:

- [ ] Teste original passou
- [ ] Nenhum comportamento adicional foi implementado

## Fase 3 - Refactor

Após todos os testes passarem:

- Melhorar legibilidade (nomes, extension functions, `when` como expressão).
- Remover duplicações.
- Aplicar padrões Kotlin quando fizer sentido (`sealed class`, `data class`).
- Garantir que todos os testes continuem passando.

Checklist:

- [ ] Refatoração concluída
- [ ] `./gradlew test` executado novamente
- [ ] Todos os testes passaram

# Regras

## Proibido

- Escrever funcionalidade sem teste.
- Criar múltiplas funcionalidades em um único ciclo.
- Refatorar enquanto existem testes falhando.
- Ignorar testes quebrados.
- Usar `Thread.sleep` em testes; usar `runTest` + `advanceTimeBy` de coroutines-test.

## Obrigatório

- Executar testes frequentemente (`./gradlew test`).
- Trabalhar em pequenas iterações.
- Lógica de jogo na camada `domain` — testável em JVM puro, sem Android SDK.
- Explicar em qual fase do TDD está.
- Encerrar cada tarefa informando:
  - Testes criados
  - Testes executados
  - Resultado final

# Estrutura de Resposta

Sempre responder usando:

## Fase Atual

Red | Green | Refactor

## Plano

Descrição da ação atual.

## Execução

Passos realizados.

## Resultado

Estado dos testes e da implementação.

# Critérios de Qualidade

- Cobertura mínima de 80% na camada `domain`
- Testes devem ser rápidos (< 1 s cada) e determinísticos
- Sem dependências do Android SDK em testes unitários
- Mocks criados com MockK (`mockk<T>()`, `coEvery`, `coVerify`)
- Flows testados com `turbine` (`flow.test { ... }`)


O agente deve buscar:

- Alta cobertura dos comportamentos críticos.
- Testes independentes.
- Testes determinísticos.
- Nomes descritivos.
- Código simples.

# Estratégia

Ao receber uma solicitação de implementação:

1. Identificar requisitos.
2. Criar teste mínimo.
3. Executar teste.
4. Implementar solução mínima.
5. Executar testes.
6. Refatorar.
7. Executar testes novamente.
8. Finalizar.

Se o usuário pedir para pular testes, explique os riscos e solicite confirmação explícita antes de prosseguir.