# Kotlin Hypercasual Game Template 🎮

Um modelo de projeto Android em Kotlin pensado para **desenvolvimento assistido por IA** de jogos hiper casuais — seja com agentes, copilotos ou ferramentas como o Antigravity/Gemini.

## Sobre este template

Este repositório fornece uma estrutura sólida para iniciar jogos hiper casuais Android com boas práticas desde o primeiro commit. Ele é especialmente adequado para fluxos de trabalho em que uma IA participa ativamente do desenvolvimento, pois já vem configurado com:

- **Kotlin idiomático** — uso de `data class`, `sealed class`, extension functions e Coroutines em todo o código.
- **Clean Architecture** — separação clara entre camadas `domain`, `data` e `presentation`.
- **Testes automatizados** — módulo `tests/` pronto para uso com JUnit5 + MockK; lógica de jogo testável em JVM puro.
- **Documentação** — pasta `docs/` destinada a arquivos `.md` que descrevem funcionalidades e decisões de projeto.
- **Regras para agentes** — arquivo `AGENTS.md` com diretrizes que orientam o comportamento de IAs ao contribuir com o projeto.
- **Gradle Version Catalogs** — dependências centralizadas em `libs.versions.toml`.

## Estrutura do projeto

```
.
├── AGENTS.md                    # Regras e diretrizes para agentes de IA
├── README.md                    # Este arquivo
├── build.gradle.kts             # Build raiz do projeto
├── settings.gradle.kts          # Configuração de módulos Gradle
├── gradle/
│   └── libs.versions.toml       # Catálogo de versões (Version Catalog)
├── app/
│   ├── build.gradle.kts         # Build do módulo principal
│   └── src/
│       ├── main/
│       │   ├── kotlin/          # Código-fonte Kotlin
│       │   │   ├── domain/      # Entidades, casos de uso, interfaces
│       │   │   ├── data/        # Repositórios, fontes de dados
│       │   │   └── presentation/# ViewModels, UI (Compose/View)
│       │   └── res/             # Recursos Android
│       └── test/
│           └── kotlin/          # Testes unitários (JVM puro)
├── docs/                        # Documentação de funcionalidades
└── skills/                      # Skills/diretrizes para agentes de IA
```

## Como usar

### 1. Clone ou crie um repositório a partir deste template

```bash
git clone <url-deste-repositorio> meu-jogo
cd meu-jogo
```

### 2. Abra no Android Studio

Abra o projeto no **Android Studio Hedgehog** (ou superior) e aguarde a sincronização do Gradle.

### 3. Execute os testes

```bash
./gradlew test
```

### 4. Build de debug

```bash
./gradlew assembleDebug
```

## Convenções

- Todo código novo deve ser **Kotlin idiomático** (preferir `val`, usar `data class`, evitar `null` desnecessário).
- Novas funcionalidades devem ter **testes unitários** e **documentação** em `docs/`.
- Lógica de jogo deve ficar na camada `domain`, sem dependências do Android SDK.
- Siga as diretrizes do arquivo [`AGENTS.md`](./AGENTS.md) ao trabalhar com agentes de IA.

## Tecnologias principais

| Camada | Tecnologia |
|---|---|
| Linguagem | Kotlin 2.x |
| UI | Jetpack Compose |
| Async | Coroutines + Flow |
| DI | Hilt |
| Testes unitários | JUnit5 + MockK |
| Testes instrumentados | Espresso / Compose UI Test |
| Build | Gradle (Kotlin DSL) |
