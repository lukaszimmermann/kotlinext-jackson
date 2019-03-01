package kotlinext.jacksonmodule.internal

import com.fasterxml.jackson.core.JsonPointer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.MissingNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.util.RawValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Collections

internal object EmptyArrayNode : ArrayNode(jacksonObjectMapper().nodeFactory) {

    private fun unsupported(): Nothing = throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    /*
     *    Unsupported Operation Exception
     */
    override fun _add(node: JsonNode?) = unsupported()
    override fun add(v: BigDecimal?) = unsupported()
    override fun add(v: Boolean?) = unsupported()
    override fun add(v: BigInteger?) = unsupported()
    override fun add(v: ByteArray?) = unsupported()
    override fun add(v: Double?) = unsupported()
    override fun add(v: Float?) = unsupported()
    override fun add(v: Int?) = unsupported()
    override fun add(v: Long?) = unsupported()
    override fun add(v: String?) = unsupported()
    override fun add(value: JsonNode?) = unsupported()

    override fun addAll(nodes: MutableCollection<out JsonNode>?) =
        unsupported()
    override fun addAll(other: ArrayNode?) = unsupported()
    override fun addArray() = unsupported()
    override fun addNull() = unsupported()
    override fun addObject() = unsupported()
    override fun addPOJO(value: Any?) = unsupported()
    override fun addRawValue(raw: RawValue?) = unsupported()

    override fun _insert(index: Int, node: JsonNode?) = unsupported()
    override fun insert(index: Int, value: Long?) = unsupported()
    override fun insert(index: Int, value: JsonNode?) = unsupported()
    override fun insert(index: Int, v: BigDecimal?) = unsupported()
    override fun insert(index: Int, v: BigInteger?) = unsupported()
    override fun insert(index: Int, v: Boolean?) = unsupported()
    override fun insert(index: Int, v: ByteArray?) = unsupported()
    override fun insert(index: Int, v: Double?) = unsupported()
    override fun insert(index: Int, v: Float?) = unsupported()
    override fun insert(index: Int, v: Int?) = unsupported()
    override fun insert(index: Int, v: String?) = unsupported()

    override fun insertPOJO(index: Int, value: Any?) = unsupported()
    override fun insertObject(index: Int) = unsupported()
    override fun insertNull(index: Int) = unsupported()
    override fun insertArray(index: Int) = unsupported()

    override fun remove(index: Int) = unsupported()
    override fun removeAll() = unsupported()

    override fun set(index: Int, value: JsonNode?) = unsupported()

    override fun with(propertyName: String?) = unsupported()
    override fun withArray(propertyName: String?) = unsupported()

    /*
     * Accessors
     */
    override fun elements(): Iterator<JsonNode> = Collections.emptyIterator()

    override fun _at(ptr: JsonPointer?): JsonNode? = null
    override fun size(): Int = 0
    override fun asBoolean(): Boolean = false
    override fun isEmpty(serializers: SerializerProvider?): Boolean = true

    override fun hasNonNull(index: Int): Boolean = false
    override fun hasNonNull(fieldName: String?): Boolean = false

    override fun asInt(defaultValue: Int): Int = 0
    override fun has(index: Int): Boolean = false
    override fun has(fieldName: String?): Boolean = false

    override fun get(index: Int): JsonNode? = null
    override fun get(fieldName: String?): JsonNode? = null

    override fun findParent(fieldName: String?): ObjectNode? = null
    override fun findParents(fieldName: String?, foundSoFar: List<JsonNode>?): List<JsonNode>? = foundSoFar

    override fun path(index: Int): JsonNode = MissingNode.getInstance()
    override fun path(fieldName: String?): JsonNode = MissingNode.getInstance()

    override fun findValue(fieldName: String?): JsonNode? = null
    override fun findValues(fieldName: String?, foundSoFar: MutableList<JsonNode>?): List<JsonNode>? = foundSoFar
    override fun findValuesAsText(fieldName: String?, foundSoFar: MutableList<String>?): List<String>? = foundSoFar

    /*
     * Equals and hash code
     */
    override fun equals(other: Any?): Boolean = (other is ArrayNode) && other.size() == 0
    override fun hashCode(): Int = 1

    /*
     * To String
     */
    override fun toString(): String = "[]"

    /*
     * Deep Copy
     */
    override fun deepCopy(): ArrayNode = this
}
