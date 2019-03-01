package kotlinext.jacksonmodule.internal

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.JsonNodeType
import com.fasterxml.jackson.databind.node.MissingNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.databind.util.RawValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinext.jacksonmodule.emptyArrayNode
import java.math.BigDecimal
import java.math.BigInteger
import java.util.Collections
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

class EmptyArrayNodeTests {

    private fun assertUnsupportedOperation(func: ArrayNode.() -> Unit) {
        assertFailsWith<UnsupportedOperationException> { func(emptyArrayNode()) }
    }

    private fun <T> assertEqualsForEmptyArrayNode(elem: T, func: ArrayNode.() -> T) {
        // emptyArrayNode returns the expected value
        assertEquals(elem, func(emptyArrayNode()))

        // An equal value is returned from a regular Array Node
        assertEquals(elem, func(jacksonObjectMapper().createArrayNode()))
    }

    private fun <T> assertNullForEmptyArrayNode(func: (ArrayNode).() -> T) {
        assertEqualsForEmptyArrayNode(null, func)
    }

    private fun assertFalseForEmptyArrayNode(func: (ArrayNode).() -> Boolean) {
        assertEqualsForEmptyArrayNode(false, func)
    }

    private fun assertTrueForEmptyArrayNode(func: (ArrayNode).() -> Boolean) {
        assertEqualsForEmptyArrayNode(true, func)
    }

    @Test
    fun `same instance`() {
        assertSame(emptyArrayNode(), emptyArrayNode())
    }

    @Test
    fun addBigDecimal() {
        assertUnsupportedOperation { add(BigDecimal.ONE) }
    }

    @Test
    fun addBigBoolean() {
        assertUnsupportedOperation { add(true) }
    }

    @Test
    fun addBigInteger() {
        assertUnsupportedOperation { add(BigInteger.ONE) }
    }

    @Test
    fun addByteArray() {
        assertUnsupportedOperation { add(ByteArray(1)) }
    }

    @Test
    fun addDouble() {
        assertUnsupportedOperation { add(1.0) }
    }

    @Test
    fun addFloat() {
        assertUnsupportedOperation { add(1.0f) }
    }

    @Test
    fun addInt() {
        assertUnsupportedOperation { add(1) }
    }

    @Test
    fun addLong() {
        assertUnsupportedOperation { add(1L) }
    }

    @Test
    fun addString() {
        assertUnsupportedOperation { add("foo") }
    }

    @Test
    fun addJsonNode() {
        assertUnsupportedOperation { add(TextNode("foo")) }
    }

    @Test
    fun addAllCollection() {
        assertUnsupportedOperation { addAll(listOf(TextNode("foo"), TextNode("bar"))) }
    }

    @Test
    fun addAllArrayNode() {
        assertUnsupportedOperation { addAll(kotlinext.jacksonmodule.arrayNode("foo", "bar")) }
    }

    @Test
    fun addArray() {
        assertUnsupportedOperation { addArray() }
    }

    @Test
    fun addNull() {
        assertUnsupportedOperation { addNull() }
    }

    @Test
    fun addObject() {
        assertUnsupportedOperation { addObject() }
    }

    @Test
    fun addPOJO2() {
        assertUnsupportedOperation { addPOJO(null) }
    }

    @Test
    fun addPOJO3() {
        assertUnsupportedOperation { addPOJO(RawValue("foo")) }
    }

    @Test
    fun set() {
        assertUnsupportedOperation { set(42, TextNode("foo")) }
    }

    @Test
    fun withArray1() {
        assertUnsupportedOperation { withArray("foo") }
    }

    @Test
    fun with() {
        assertUnsupportedOperation { with("foo") }
    }

    @Test
    fun removeAll() {
        assertUnsupportedOperation { removeAll() }
    }

    @Test
    fun remove() {
        assertUnsupportedOperation { remove(42) }
    }

    @Test
    fun insertPOJO() {
        assertUnsupportedOperation { insertPOJO(42, Object()) }
    }

    @Test
    fun insertObject() {
        assertUnsupportedOperation { insertObject(42) }
    }

    @Test
    fun insertNull() {
        assertUnsupportedOperation { insertNull(42) }
    }

    @Test
    fun insertArray() {
        assertUnsupportedOperation { insertArray(42) }
    }

    @Test
    fun insertLong() {
        assertUnsupportedOperation { insert(42, 1L) }
    }

    @Test
    fun insertJsonNode() {
        assertUnsupportedOperation { insert(42, TextNode("foo")) }
    }

    @Test
    fun insertBigDecimal() {
        assertUnsupportedOperation { insert(42, BigDecimal.ONE) }
    }

    @Test
    fun insertBigInteger() {
        assertUnsupportedOperation { insert(42, BigInteger.ONE) }
    }

    @Test
    fun insertBoolean() {
        assertUnsupportedOperation { insert(42, true) }
    }

    @Test
    fun insertByteArray() {
        assertUnsupportedOperation { insert(42, ByteArray(1)) }
    }

    @Test
    fun insertDouble() {
        assertUnsupportedOperation { insert(42, 1.0) }
    }

    @Test
    fun insertFloat() {
        assertUnsupportedOperation { insert(42, 1.0f) }
    }

    @Test
    fun insertInt() {
        assertUnsupportedOperation { insert(42, 1) }
    }

    @Test
    fun insertString() {
        assertUnsupportedOperation { insert(42, "foo") }
    }

    @Test
    fun fields() {
        assertEqualsForEmptyArrayNode(Collections.emptyIterator()) { fieldNames() }
    }

    @Test
    fun fieldNames() {
        assertEqualsForEmptyArrayNode(Collections.emptyIterator()) { fieldNames() }
    }

    @Test
    fun elements() {
        assertFalseForEmptyArrayNode { elements().hasNext() }
    }

    @Test
    fun deepCopy() {
        emptyArrayNode().let { original ->
            assertSame(original, original.deepCopy())
        }
    }

    @Test
    fun testToString() {
        assertEqualsForEmptyArrayNode("[]") { toString() }
    }

    @Test
    fun shortValue() {
        assertEqualsForEmptyArrayNode(0.toShort()) { shortValue() }
    }

    @Test
    fun size() {
        assertEqualsForEmptyArrayNode(0) { size() }
    }

    @Test
    fun textValue() {
        assertNullForEmptyArrayNode { textValue() }
    }

    @Test
    fun longValue() {
        assertEqualsForEmptyArrayNode(0L) { longValue() }
    }

    @Test
    fun isMissingNode() {
        assertFalseForEmptyArrayNode { isMissingNode }
    }

    @Test
    fun numberValue() {
        assertNullForEmptyArrayNode { numberValue() }
    }

    @Test
    fun isIntegralNumber() {
        assertFalseForEmptyArrayNode { isIntegralNumber }
    }

    @Test
    fun isShort() {
        assertFalseForEmptyArrayNode { isShort }
    }

    @Test
    fun isObject() {
        assertFalseForEmptyArrayNode { isObject }
    }

    @Test
    fun isLong() {
        assertFalseForEmptyArrayNode { isLong }
    }

    @Test
    fun isInt() {
        assertFalseForEmptyArrayNode { isInt }
    }

    @Test
    fun isFloat() {
        assertFalseForEmptyArrayNode { isFloat }
    }

    @Test
    fun isDouble() {
        assertFalseForEmptyArrayNode { isDouble }
    }

    @Test
    fun isBigInteger() {
        assertFalseForEmptyArrayNode { isBigInteger }
    }

    @Test
    fun isArray() {
        assertTrueForEmptyArrayNode { isArray }
    }

    @Test
    fun isBigDecimal() {
        assertFalseForEmptyArrayNode { isBigDecimal }
    }

    @Test
    fun asBoolean() {
        assertFalseForEmptyArrayNode { asBoolean() }
    }

    @Test
    fun asBooleanWithDefaultTrue() {
        assertTrueForEmptyArrayNode { asBoolean(true) }
    }

    @Test
    fun asBooleanWithDefaultFalse() {
        assertFalseForEmptyArrayNode { asBoolean(false) }
    }

    @Test
    fun asDouble() {
        assertEqualsForEmptyArrayNode(0.0) { asDouble() }
    }

    @Test
    fun isFloatingPointNumber() {
        assertFalseForEmptyArrayNode { isFloatingPointNumber }
    }

    @Test
    fun intValue() {
        assertEqualsForEmptyArrayNode(0) { intValue() }
    }

    @Test
    fun asLong() {
        assertEqualsForEmptyArrayNode(0L) { asLong() }
    }

    @Test
    fun isEmpty() {
        assertTrueForEmptyArrayNode { isEmpty(null) }
    }

    @Test
    fun binaryValue() {
        assertNullForEmptyArrayNode { binaryValue() }
    }

    @Test
    fun numberType() {
        assertNullForEmptyArrayNode { numberType() }
    }

    @Test
    fun asInt() {
        assertEqualsForEmptyArrayNode(0) { asInt() }
    }

    @Test
    fun hasNonNullIndex() {
        assertFalseForEmptyArrayNode { hasNonNull(42) }
    }

    @Test
    fun hasNonNullFieldName() {
        assertFalseForEmptyArrayNode { hasNonNull("foo") }
    }

    @Test
    fun has() {
        assertFalseForEmptyArrayNode { has(42) }
    }

    @Test
    fun asText() {
        assertEqualsForEmptyArrayNode("") { asText() }
    }

    @Test
    fun asTextWithDefault() {
        assertEqualsForEmptyArrayNode("") { asText("foo") }
    }

    @Test
    fun getNodeType() {
        assertEqualsForEmptyArrayNode(JsonNodeType.ARRAY) { nodeType }
    }

    @Test
    fun doubleValue() {
        assertEqualsForEmptyArrayNode(0.0) { doubleValue() }
    }

    @Test
    fun floatValue() {
        assertEqualsForEmptyArrayNode(0.0f) { floatValue() }
    }

    @Test
    fun booleanValue() {
        assertFalseForEmptyArrayNode { booleanValue() }
    }

    @Test
    fun asLongWithDefault() {
        assertEqualsForEmptyArrayNode(42L) { asLong(42L) }
    }

    @Test
    fun getFieldName() {
        assertNullForEmptyArrayNode { get("foo") }
    }

    @Test
    fun getIndex() {
        assertNullForEmptyArrayNode { get(42) }
    }

    @Test
    fun decimalValue() {
        assertEqualsForEmptyArrayNode(BigDecimal.ZERO) { decimalValue() }
    }

    @Test
    fun asToken() {
        assertEqualsForEmptyArrayNode(JsonToken.START_ARRAY) { asToken() }
    }

    @Test
    fun bigIntegerValue() {
        assertEqualsForEmptyArrayNode(BigInteger.ZERO) { bigIntegerValue() }
    }

    @Test
    fun canConvertToInt() {
        assertFalseForEmptyArrayNode { canConvertToInt() }
    }

    @Test
    fun canConvertToLong() {
        assertFalseForEmptyArrayNode { canConvertToLong() }
    }

    @Test
    fun testHashCode() {
        assertEqualsForEmptyArrayNode(1) { hashCode() }
    }

    @Test
    fun findParentFieldName() {
        assertNullForEmptyArrayNode { findParent("foo") }
    }

    @Test
    fun findParentsFieldName() {
        assertEqualsForEmptyArrayNode(emptyList()) { findParents("foo") }
    }

    @Test
    fun findParentsFoundSoFar1() {
        assertEqualsForEmptyArrayNode(emptyList()) { findParents("foo", emptyList()) }
    }

    @Test
    fun findParentsFoundSoFar2() {
        assertEqualsForEmptyArrayNode(listOf(TextNode("foo"))) {
            findParents("foo", listOf(TextNode("foo")))
        }
    }

    @Test
    fun path() {
        assertEqualsForEmptyArrayNode(MissingNode.getInstance()) { path(42) }
    }

    @Test
    fun pathFieldName() {
        assertEqualsForEmptyArrayNode(MissingNode.getInstance()) { path("foo") }
    }

    @Test
    fun findValueFieldName() {
        assertNullForEmptyArrayNode { findValue("foo") }
    }

    @Test
    fun findValuesFoundSoFar1() {
        assertEqualsForEmptyArrayNode(emptyList()) { findValues("foo", emptyList()) }
    }

    @Test
    fun findValuesFoundSoFar2() {
        assertEqualsForEmptyArrayNode(listOf(TextNode("foo"))) {
            findValues("foo", listOf(TextNode("foo")))
        }
    }

    @Test
    fun findValuesAsText1() {
        assertEqualsForEmptyArrayNode(emptyList()) {
            findValuesAsText("foo", emptyList())
        }
    }

    @Test
    fun findValuesAsText2() {
        assertEqualsForEmptyArrayNode(listOf("foo")) {
            findValuesAsText("foo", listOf("foo"))
        }
    }
}
