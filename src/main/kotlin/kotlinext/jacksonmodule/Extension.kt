package kotlinext.jacksonmodule

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.NullNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

/*
 * Object Node
 */
sealed class ObjectNodeBuilder {
    abstract infix fun String.mapsTo(value: String?)
    abstract infix fun String.mapsTo(value: JsonNode)

    abstract val mappings: Iterable<Pair<String, JsonNode>>
}

private class ObjectNodeBuilderImpl : ObjectNodeBuilder() {
    private val strings = HashMap<String, JsonNode>()
    override val mappings: Iterable<Pair<String, JsonNode>>
        get() = strings.asIterable().map { it.toPair() }

    override fun String.mapsTo(value: String?) {
        strings[this] = value?.let { TextNode(it) } ?: NullNode.instance
    }

    override fun String.mapsTo(value: JsonNode) {
        strings[this] = value
    }
}

fun objectNode(builderFun: (ObjectNodeBuilder.() -> Unit)? = null): ObjectNode {
    val builder = ObjectNodeBuilderImpl()
    builderFun?.invoke(builder)
    return jacksonObjectMapper().createObjectNode().apply {
        for ((key, value) in builder.mappings) {
            set(key, value)
        }
    }
}


private fun createArrayNode() = jacksonObjectMapper().createArrayNode()

private fun <T> arrayNodeFrom(elements: Array<T>, by: ArrayNode.(T) -> Unit): ArrayNode =
    createArrayNode().apply {
        elements.forEach { by(this, it) }
    }

fun arrayNode(vararg elements: JsonNode): ArrayNode = arrayNodeFrom(elements) { add(it) }
fun arrayNode(vararg elements: String): ArrayNode = arrayNodeFrom(elements) { add(it) }
fun emptyArrayNode(): ArrayNode = EmptyArrayNode
