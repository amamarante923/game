# Kotlin Clean Code

## Princípios gerais

- Funções pequenas e coesas — uma responsabilidade por função
- Nomes descritivos em português (variáveis, funções, classes)
- Evitar duplicação — extrair funções e extension functions reutilizáveis
- Resolver o problema com o mínimo de código necessário; sem over-engineering

## Idiomas Kotlin obrigatórios

- Preferir `val` a `var`; toda mutabilidade deve ser justificada
- Usar `data class` para entidades de domínio imutáveis
- Usar `sealed class` / `sealed interface` para estados e resultados (`Result<T>`, `UiState`)
- Usar `object` para singletons e companions sem estado
- Evitar `!!`; tratar nulabilidade com `?.`, `?:`, `let`, `run`, `requireNotNull`
- Usar `when` como expressão em vez de `if-else` encadeado
- Preferir extension functions a funções utilitárias estáticas
- Usar `apply`, `also`, `let`, `run`, `with` para inicialização e transformação de objetos

## Coroutines e Flow

- Usar `suspend fun` para operações assíncronas; nunca bloquear com `.get()` ou `runBlocking` em produção
- Expor estado de UI como `StateFlow<UiState>`; nunca como `LiveData` mutável público
- Usar `viewModelScope` no ViewModel; `lifecycleScope` em Fragment/Activity
- Cancelar coroutines corretamente; evitar `GlobalScope`

## Formatação

- Seguir o guia oficial de estilo Kotlin (ktlint / detekt)
- Indentação de 4 espaços
- Comprimento máximo de linha: 120 caracteres
- Sem imports com wildcard (`import com.example.*`)

