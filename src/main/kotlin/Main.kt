import kotlinx.ast.common.AstSource
import kotlinx.ast.grammar.kotlin.target.antlr.kotlin.KotlinGrammarAntlrKotlinParser

fun main() {
    val name = "file.kt"
    val content = ::main::class.java.classLoader.getResource(name)!!.readText()
    val ast = AstSource.String("file:/${name}", content)
    println(ast.parse())
}

fun AstSource.parse() = KotlinGrammarAntlrKotlinParser.parseKotlinFile(this)

