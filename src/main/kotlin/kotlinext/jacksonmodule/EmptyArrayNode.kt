package kotlinext.jacksonmodule

import com.fasterxml.jackson.core.JsonPointer
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.JsonNodeType
import com.fasterxml.jackson.databind.node.MissingNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.util.RawValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.math.BigDecimal
import java.math.BigInteger

internal object EmptyArrayNode : ArrayNode(jacksonObjectMapper().nodeFactory) {

    private val MISSING_NODE = MissingNode.getInstance()

    override fun add(v: BigDecimal?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: Boolean) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: BigInteger?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: ByteArray?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: Double) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: Float) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: Int) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: Long) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(v: String?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun add(value: JsonNode?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun addAll(nodes: MutableCollection<out JsonNode>?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun _add(node: JsonNode?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun addAll(other: ArrayNode?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun addArray() = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun addNull() = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun addObject() = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun addPOJO(value: Any?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun addRawValue(raw: RawValue?) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun set(index: Int, value: JsonNode?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun withArray(propertyName: String?) = throw UnsupportedOperationException(
        "JsonNode not of type ObjectNode (but ${this.javaClass.name}), cannot call withArray() on it"
    )

    override fun with(propertyName: String?) = throw UnsupportedOperationException(
        "JsonNode not of type ObjectNode (but ${javaClass.name}), cannot call with() on it"
    )

    override fun removeAll() = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun remove(index: Int) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun insertPOJO(index: Int, value: Any?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insertObject(index: Int) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun insertNull(index: Int) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun insertArray(index: Int) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun insert(index: Int, value: Long?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, value: JsonNode?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, v: BigDecimal?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, v: BigInteger?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, v: Boolean) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, v: ByteArray?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, v: Double) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, v: Float) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun insert(index: Int, v: Int) = throw UnsupportedOperationException("Empty Array Node cannot be mutated")
    override fun insert(index: Int, v: String?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun _insert(index: Int, node: JsonNode?) =
        throw UnsupportedOperationException("Empty Array Node cannot be mutated")

    override fun fields() = emptyList<Map.Entry<String, JsonNode>>().iterator()
    override fun fieldNames() = emptyList<String>().iterator()
    override fun elements() = emptyList<JsonNode>().iterator()
    override fun deepCopy() = this
    override fun _at(ptr: JsonPointer?) = null
    override fun toString() = "[]"
    override fun shortValue() = 0.toShort()
    override fun size() = 0
    override fun textValue() = null
    override fun longValue() = 0L
    override fun isMissingNode() = false
    override fun numberValue() = null
    override fun isIntegralNumber() = false
    override fun isShort() = false
    override fun isObject() = false
    override fun isLong() = false
    override fun isInt() = false
    override fun isFloat() = false
    override fun isDouble() = false
    override fun isBigInteger() = false
    override fun isArray() = true
    override fun isBigDecimal() = false
    override fun asBoolean() = false
    override fun asBoolean(defaultValue: Boolean) = false
    override fun asDouble() = 0.0
    override fun isFloatingPointNumber() = false
    override fun intValue() = 0
    override fun asLong() = 0L
    override fun isEmpty(serializers: SerializerProvider?) = true
    override fun binaryValue() = null
    override fun numberType() = null
    override fun asInt() = 0
    override fun asDouble(defaultValue: Double) = 0.0
    override fun hasNonNull(index: Int) = false
    override fun hasNonNull(fieldName: String?) = false
    override fun asInt(defaultValue: Int) = 0
    override fun has(index: Int) = false
    override fun asText() = ""
    override fun has(fieldName: String?) = false
    override fun getNodeType() = JsonNodeType.ARRAY
    override fun doubleValue() = 0.0
    override fun floatValue() = 0.0f
    override fun booleanValue() = false
    override fun asLong(defaultValue: Long) = 0L
    override fun get(fieldName: String?) = null
    override fun get(index: Int) = null
    override fun decimalValue(): BigDecimal = BigDecimal.ZERO
    override fun asToken(): JsonToken = JsonToken.START_ARRAY
    override fun asText(defaultValue: String?) = ""
    override fun bigIntegerValue(): BigInteger = BigInteger.ZERO
    override fun canConvertToInt(): Boolean = false
    override fun canConvertToLong(): Boolean = false
    override fun hashCode(): Int = 1
    override fun findParent(fieldName: String?): ObjectNode? = null
    override fun findParents(fieldName: String?, foundSoFar: MutableList<JsonNode>?): List<JsonNode> = emptyList()
    override fun path(index: Int): JsonNode = MISSING_NODE
    override fun findValue(fieldName: String?): JsonNode? = null
    override fun findValues(fieldName: String?, foundSoFar: MutableList<JsonNode>?): List<JsonNode> = emptyList()
    override fun findValuesAsText(fieldName: String?, foundSoFar: MutableList<String>?): List<String> = emptyList()
    override fun path(fieldName: String?): JsonNode = MISSING_NODE
}
