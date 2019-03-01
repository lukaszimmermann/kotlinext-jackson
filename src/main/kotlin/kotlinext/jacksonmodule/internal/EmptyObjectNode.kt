package kotlinext.jacksonmodule.internal

import com.fasterxml.jackson.core.JsonPointer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.MissingNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.util.RawValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Collections

internal object EmptyObjectNode : ObjectNode(jacksonObjectMapper().nodeFactory) {

    private fun unsupported(): Nothing = throw UnsupportedOperationException("Empty Object Node cannot be mutated")

    /*
     *  Unsupported Operation Exception for mutators
     */
    // put
    override fun _put(fieldName: String?, value: JsonNode?) =
        unsupported()

    override fun put(fieldName: String?, v: BigDecimal?) =
        unsupported()
    override fun put(fieldName: String?, v: BigInteger?) =
        unsupported()
    override fun put(fieldName: String?, v: Boolean?) = unsupported()
    override fun put(fieldName: String?, v: Long?) = unsupported()
    override fun put(fieldName: String?, v: Short?) = unsupported()
    override fun put(fieldName: String?, v: Float?) = unsupported()
    override fun put(fieldName: String?, v: ByteArray?) = unsupported()
    override fun put(fieldName: String?, v: Double?) = unsupported()
    override fun put(fieldName: String?, v: Int?) = unsupported()
    override fun put(fieldName: String?, v: String?) = unsupported()
    override fun put(fieldName: String?, v: JsonNode?) = unsupported()

    override fun putAll(other: ObjectNode?) = unsupported()
    override fun putAll(properties: MutableMap<String, out JsonNode>?) =
        unsupported()

    override fun putNull(fieldName: String?) = unsupported()
    override fun putArray(fieldName: String?) = unsupported()
    override fun putObject(fieldName: String?) = unsupported()
    override fun putRawValue(fieldName: String?, raw: RawValue?) =
        unsupported()
    override fun putPOJO(fieldName: String?, pojo: Any?) =
        unsupported()

    // r..
    override fun remove(fieldName: String?) = unsupported()

    override fun remove(fieldNames: MutableCollection<String>?) =
        unsupported()
    override fun removeAll() = unsupported()

    override fun replace(fieldName: String?, value: JsonNode?) =
        unsupported()

    override fun retain(vararg fieldNames: String?) = unsupported()
    override fun retain(fieldNames: MutableCollection<String>?) =
        unsupported()

    // set
    override fun set(fieldName: String?, value: JsonNode?) =
        unsupported()

    override fun setAll(properties: MutableMap<String, out JsonNode>?) =
        unsupported()
    override fun setAll(other: ObjectNode?) = unsupported()

    override fun with(propertyName: String?) = unsupported()
    override fun withArray(propertyName: String?) = unsupported()
    override fun without(fieldName: String?) = unsupported()
    override fun without(fieldNames: MutableCollection<String>?) =
        unsupported()

    /*
     * Accessors
     */
    override fun _at(ptr: JsonPointer?) = null

    override fun asBoolean(): Boolean = false
    override fun asDouble(): Double = 0.0
    override fun asInt(): Int = 0
    override fun asLong(): Long = 0L

    override fun elements(): Iterator<JsonNode> = Collections.emptyIterator()

    override fun fieldNames(): Iterator<String> = Collections.emptyIterator()
    override fun fields(): Iterator<Map.Entry<String, JsonNode>> = Collections.emptyIterator()
    override fun findParent(fieldName: String?): ObjectNode? = null
    override fun findParents(fieldName: String?, foundSoFar: List<JsonNode>?): List<JsonNode>? = foundSoFar
    override fun findValue(fieldName: String?): JsonNode? = null
    override fun findValues(fieldName: String?, foundSoFar: List<JsonNode>?): List<JsonNode>? = foundSoFar

    override fun get(fieldName: String?): JsonNode? = null
    override fun get(index: Int): JsonNode? = null

    override fun has(fieldName: String?): Boolean = false
    override fun has(index: Int): Boolean = false
    override fun hasNonNull(fieldName: String?): Boolean = false
    override fun hasNonNull(index: Int): Boolean = false

    override fun path(fieldName: String?): JsonNode = MissingNode.getInstance()
    override fun path(index: Int): JsonNode = MissingNode.getInstance()

    override fun size(): Int = 0

    /*
     * Equals and Hash Code
     */
    override fun equals(other: Any?): Boolean = (other is ObjectNode) && other.size() == 0
    override fun hashCode(): Int = 0

    /*
     * To String
     */
    override fun toString(): String = "{}"

    /*
     * Deep Copy
     */
    override fun deepCopy(): ObjectNode = this
}
