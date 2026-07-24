package com.example.hypercasualgame.domain.model

/**
 * Representa o estado atual de uma partida do jogo.
 * Imutável por design — toda atualização gera uma nova instância.
 */
data class EstadoJogo(
    val pontuacao: Int = 0,
    val vidas: Int = 3,
    val fase: Int = 1,
    val emAndamento: Boolean = false,
)
