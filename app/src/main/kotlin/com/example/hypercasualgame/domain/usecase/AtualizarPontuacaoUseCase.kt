package com.example.hypercasualgame.domain.usecase

import com.example.hypercasualgame.domain.model.EstadoJogo

/** Incrementa a pontuação e avança de fase a cada 100 pontos. */
class AtualizarPontuacaoUseCase {
    operator fun invoke(estado: EstadoJogo, pontos: Int): EstadoJogo {
        val novaPontuacao = estado.pontuacao + pontos
        val novaFase = (novaPontuacao / 100) + 1
        return estado.copy(pontuacao = novaPontuacao, fase = novaFase)
    }
}
