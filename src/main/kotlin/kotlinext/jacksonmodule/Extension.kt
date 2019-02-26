package kotlinext.jacksonmodule

import com.fasterxml.jackson.databind.node.NullNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

sealed class ObjectNodeBuilder {
    abstract infix fun String.mapsTo(value: String?)
    abstract val stringMappings: Iterable<Pair<String, String?>>
}

private class ObjectNodeBuilderImpl : ObjectNodeBuilder() {
    private val strings = HashMap<String, String?>()
    override val stringMappings: Iterable<Pair<String, String?>>
        get() = strings.asIterable().map { it.toPair() }

    override fun String.mapsTo(value: String?) {
        strings[this] = value
    }
}

fun objectNode(builderFun: (ObjectNodeBuilder.() -> Unit)? = null): ObjectNode {
    val builder = ObjectNodeBuilderImpl()
    val nullNode = NullNode.instance
    builderFun?.invoke(builder)
    return jacksonObjectMapper().createObjectNode().apply {
        for ((key, value) in builder.stringMappings) {
            set(key, value?.let { TextNode(it) } ?: nullNode )
        }
    }
}
