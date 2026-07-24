package com.example.hypercasualgame.domain.usecase

import com.example.hypercasualgame.domain.model.EstadoJogo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AtualizarPontuacaoUseCaseTest {

    private val useCase = AtualizarPontuacaoUseCase()

    @Test
    fun `deve incrementar pontuacao corretamente`() {
        val estado = EstadoJogo(pontuacao = 50)
        val resultado = useCase(estado, pontos = 30)
        assertEquals(80, resultado.pontuacao)
    }

    @Test
    fun `deve avancar de fase ao atingir 100 pontos`() {
        val estado = EstadoJogo(pontuacao = 90)
        val resultado = useCase(estado, pontos = 10)
        assertEquals(2, resultado.fase)
    }

    @Test
    fun `nao deve alterar vidas ao atualizar pontuacao`() {
        val estado = EstadoJogo(vidas = 3)
        val resultado = useCase(estado, pontos = 10)
        assertEquals(3, resultado.vidas)
    }
}
