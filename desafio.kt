enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

open class Usuario (val nome: String){

    companion object{
        val inscritos = mutableListOf<Usuario>()
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    override fun toString(): String {
        return "Usuario: $nome"
    }

}


data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel){

    val duremhoras = duracao / 60
    override fun toString(): String {
        return "$nome: $duremhoras horas, $nivel"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>)


fun main() {

    val fundamentosko = ConteudoEducacional("Fundamentos" ,70, nivel = Nivel.BASICO)
    val orientacaoocomk = ConteudoEducacional("Orientação a Objetos com kotlin", nivel = Nivel.INTERMEDIARIO)
    val fundcomJav = ConteudoEducacional("Fundamentos da linguagem Java", 120, Nivel.BASICO)
    val orientJav = ConteudoEducacional("Orientação a Objetos com Java", 150, Nivel.DIFICIL)

    val kotlinform = Formacao(
        "Kotlin",
        conteudos = listOf(fundamentosko, orientacaoocomk)
    )
    val javaform = Formacao(
        "Java", conteudos = listOf(fundcomJav,orientJav)
    )

  val usuario1 = Usuario("João")
    usuario1.matricular(usuario1)

  val usuario2 = Usuario("Carla")
      usuario2.matricular(usuario2)

    Usuario.inscritos.forEach{
        println(it)
    }
    println(kotlinform)
    println(javaform)
    
}