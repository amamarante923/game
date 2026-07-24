# Regras Gerais

- Sempre usar Kotlin idiomático: preferir `val` a `var`, usar `data class`, `sealed class` e `object` quando apropriado
- Sempre criar testes para novas funcionalidades (JUnit5 + MockK)
- Nunca remover testes existentes sem justificativa
- Preferir composição a herança; usar interfaces e delegação Kotlin
- Priorizar legibilidade; aproveitar extension functions e lambdas com receptor
- Sempre documentar features novas em arquivos .md na pasta docs/
- Responder em português a não ser que o usuário diga o contrário
- Usar nomes de variáveis e funções em português
- Seguir as diretrizes oficiais do Android (Material Design 3, Jetpack)
- Usar Coroutines + Flow para operações assíncronas; nunca bloquear a thread principal
- Toda lógica de jogo deve ser independente do Android SDK (testável em JVM puro)

## Arquitetura

- Seguir Clean Architecture com camadas: `domain`, `data`, `presentation`
- Usar ViewModel + StateFlow para gerenciamento de estado na UI
- Separar lógica de jogo (game loop, física, pontuação) da camada de apresentação
- Preferir injeção de dependência via Hilt

## Dependências

- Evitar dependências externas desnecessárias
- Gerenciar dependências via Gradle Version Catalogs (`libs.versions.toml`)
- Nunca adicionar dependências sem atualizar o catálogo de versões
- Manter `minSdk` e `targetSdk` atualizados conforme política do Google Play

## Segurança

- Nunca executar comandos destrutivos sem confirmação
- Nunca apagar diretórios inteiros sem validação
- Nunca expor segredos, API keys ou tokens em código ou no controle de versão
- Usar `BuildConfig` ou variáveis de ambiente para configurações sensíveis
- Nunca fazer log de dados sensíveis do usuário
