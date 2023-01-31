package com.joys.meumestremandou.data

import com.joys.meumestremandou.infra.OrderConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    val all = OrderConstants.FILTER.ALL
    val random = OrderConstants.FILTER.RANDOM
    val colors = OrderConstants.FILTER.COLORS
    val musics = OrderConstants.FILTER.MUSIC

    private val mListPhrase = listOf(

        Phrase("Responda um charada", random),
        Phrase("Pular igual um sapo", random),
        Phrase("Imitar o som de um pato", random),
        Phrase("Imitar o som de um sapo", random),
        Phrase("Dê 5 pulinhos", random),
        Phrase("Imite um bebê", random),
        Phrase("Imite um porquinho", random),
        Phrase("Imite um gato", random),
        Phrase("Abrace um amigo", random),
        Phrase("Imite um cachorro", random),
        Phrase("Imite uma galinha", random),
        Phrase("Andar como um canguru", random),
        Phrase("Ficar em câmera lenta até a próxima rodada ", random),
        Phrase("Diga sua comida favorita", random),
        Phrase("Ande ao redor da sala como um pinguim", random),
        Phrase("Rode o bambolê", random),
        Phrase("Imitar um macaco", random),
        Phrase("Pular de um pé só", random),
        Phrase("Andar de costas", random),
        Phrase("Faça 5 polichinelos", random),
        Phrase("Conte uma piada", random),
        Phrase("Marche como um soldado", random),
        Phrase("Imite o som de uma abelha", random),
        Phrase("Conte uma história", random),
        Phrase("Finja que está montado em um cavalo", random),
        Phrase("Faça uma mimica e deixe a turma adivinhar", random),
        Phrase("Jogue pedra, papel e tesoura com um colega", random),

        Phrase("Encontre um objeto vermelho", colors),
        Phrase("Encontre um objeto laranja", colors),
        Phrase("Encontre um ojeto amarelo", colors),
        Phrase("Encontre um objeto verde", colors),
        Phrase("Encontre um objeto azul", colors),
        Phrase("Encontre um objeto roxo", colors),
        Phrase("Encontre um objeto rosa", colors),
        Phrase("Encontre um objeto marrom", colors),
        Phrase("Encontre um objeto preto", colors),
        Phrase("Desenhe um objeto e deixe a turma advinhar qual é", colors),
        Phrase("Jogue o jogo da forca com a turma", colors),
        Phrase("Jogue o jogo da velha com um colega", colors),

        Phrase("Cante e dance a música do pintinho amarelinho", musics),
        Phrase("Cante sua música favorita", musics),
        Phrase("Cante a música da barata", musics),
        Phrase("Bata palmas no ritmo de alguma música", musics),
        Phrase("Cante uma música infantil", musics),
        Phrase("Faça uma roda com os colegas e cante Ciranda cirandinha", musics),
        Phrase("Cante uma música da Galinha pintadinha", musics),
        Phrase("Dance forró com a vassoura", musics),
        Phrase("Escolha um colega para cantar uma música com você", musics),
        Phrase("Fale um trava-língua", musics),
        Phrase("Cante uma música no Karaokê", musics),
        Phrase("Escolha 4 colegas para brincar da dança da laranja", musics),
        Phrase("Escolha 4 colegas para brincar da dança das cadeiras", musics),
        Phrase("Cante a música 'Eu vi um sapo'", musics),
        Phrase("Cante uma cantiga de roda", musics),
        Phrase("Cante uma música para 2 colegas brincarem de estátua", musics)
        )

    fun getPhrase(value: Int): String{

        val filtered = mListPhrase.filter { it.categoryId == value || value == all }
        return filtered[Random.nextInt(filtered.size)].description
    }
}