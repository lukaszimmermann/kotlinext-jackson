package kotlinext.jacksonmodule.internal

import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.databind.node.MissingNode
import com.fasterxml.jackson.databind.node.JsonNodeType
import com.fasterxml.jackson.databind.util.RawValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlinext.jacksonmodule.emptyArrayNode
import kotlinext.jacksonmodule.emptyObjectNode
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

class EmptyObjectNodeTests {

    private fun assertUnsupportedOperation(func: (ObjectNode) -> Unit) {
        assertFailsWith<UnsupportedOperationException> { func(emptyObjectNode()) }
    }

    private fun <T> assertEqualsForEmptyObjectNode(elem: T, func: (ObjectNode) -> T) {
        // emptyArrayNode returns the expected value
        assertEquals(elem, func(emptyObjectNode()))

        // An equal value is returned from a regular Array Node
        assertEquals(elem, func(jacksonObjectMapper().createObjectNode()))
    }

    private fun <T> assertNullForEmptyObjectNode(func: (ObjectNode) -> T) {
        assertEqualsForEmptyObjectNode(null, func)
    }

    private fun assertFalseForEmptyObjectNode(func: (ObjectNode) -> Boolean) {
        assertEqualsForEmptyObjectNode(false, func)
    }

    private fun assertTrueForEmptyObjectNode(func: (ObjectNode) -> Boolean) {
        assertEqualsForEmptyObjectNode(true, func)
    }

    @Test
    fun `same instance`() {
        assertSame(emptyArrayNode(), emptyArrayNode())
    }

    /*
     *  Unsupported Operation Exception
     */
    //////////////
    // put
    /////////////
    @Test
    fun test_put_BigDecimal() {
        assertUnsupportedOperation { it.put("foo", BigDecimal.ONE) }
    }

    @Test
    fun test_put_BigInteger() {
        assertUnsupportedOperation { it.put("foo", BigInteger.ONE) }
    }

    @Test
    fun test_put_Boolean() {
        assertUnsupportedOperation { it.put("foo", false) }
    }

    @Test
    fun test_put_Long() {
        assertUnsupportedOperation { it.put("foo", 1L) }
    }

    @Test
    fun test_put_Short() {
        assertUnsupportedOperation { it.put("foo", 1.toShort()) }
    }

    @Test
    fun test_put_Float() {
        assertUnsupportedOperation { it.put("foo", 1.0f) }
    }

    @Test
    fun test_put_ByteArray() {
        assertUnsupportedOperation { it.put("foo", ByteArray(1)) }
    }

    @Test
    fun test_put_Double() {
        assertUnsupportedOperation { it.put("foo", 1.0) }
    }

    @Test
    fun test_put_Int() {
        assertUnsupportedOperation { it.put("foo", 1) }
    }

    @Test
    fun test_put_String() {
        assertUnsupportedOperation { it.put("foo", "bar") }
    }

    @Test
    fun test_put_JsonNode() {
        assertUnsupportedOperation { it.put("foo", TextNode("bar")) }
    }

    @Test
    fun test_putAll_Object() {
        assertUnsupportedOperation { it.putAll(jacksonObjectMapper().createObjectNode()) }
    }

    @Test
    fun test_putAll_Map_1() {
        assertUnsupportedOperation { it.putAll(emptyMap()) }
    }

    @Test
    fun test_putAll_Map_2() {
        assertUnsupportedOperation { it.putAll(mapOf("foo" to TextNode("bar"))) }
    }

    @Test
    fun test_putNull() {
        assertUnsupportedOperation { it.putNull("foo") }
    }

    @Test
    fun test_putArray() {
        assertUnsupportedOperation { it.putArray("foo") }
    }

    @Test
    fun test_putObject() {
        assertUnsupportedOperation { it.putObject("foo") }
    }

    @Test
    fun test_putRawValue() {
        assertUnsupportedOperation { it.putRawValue("foo", RawValue("bar")) }
    }

    @Test
    fun test_putPOJO() {
        assertUnsupportedOperation { it.putPOJO("foo", Object()) }
    }

    // r...
    @Test
    fun test_remove_String() {
        assertUnsupportedOperation { it.remove("foo") }
    }

    @Test
    fun test_remove_String_Collection_1() {
        assertUnsupportedOperation { it.remove(emptyList()) }
    }

    @Test
    fun test_remove_String_Collection_2() {
        assertUnsupportedOperation { it.remove(listOf("foo")) }
    }

    @Test
    fun test_remove_String_Collection_3() {
        assertUnsupportedOperation { it.remove(listOf("foo", "bar")) }
    }

    @Test
    fun test_removeAll() {
        assertUnsupportedOperation { it.removeAll() }
    }

    @Test
    fun test_replace() {
        assertUnsupportedOperation { it.replace("foo", TextNode("bar")) }
    }

    @Test
    fun test_retain_String_Collection_1() {
        assertUnsupportedOperation { it.retain(emptyList()) }
    }

    @Test
    fun test_retain_String_Collection_2() {
        assertUnsupportedOperation { it.retain(listOf("foo")) }
    }

    @Test
    fun test_retain_String_Collection_3() {
        assertUnsupportedOperation { it.retain(listOf("foo", "bar")) }
    }

    @Test
    fun test_retain_vararg_1() {
        assertUnsupportedOperation { it.retain() }
    }

    @Test
    fun test_retain_vararg_2() {
        assertUnsupportedOperation { it.retain("foo") }
    }

    @Test
    fun test_retain_vararg_3() {
        assertUnsupportedOperation { it.retain("foo", "bar") }
    }

    // set...
    @Test
    fun test_set() {
        assertUnsupportedOperation { it.set("foo", TextNode("bar")) }
    }

    @Test
    fun test_setAll_Map_1() {
        assertUnsupportedOperation { it.setAll(emptyMap()) }
    }

    @Test
    fun test_setAll_Map_2() {
        assertUnsupportedOperation { it.setAll(mapOf("foo" to TextNode("bar"))) }
    }

    @Test
    fun test_setAll_Map_3() {
        assertUnsupportedOperation { it.setAll(mapOf("foo" to TextNode("bar"))) }
    }

    @Test
    fun test_setAll_Object() {
        assertUnsupportedOperation { it.setAll(jacksonObjectMapper().createObjectNode()) }
    }

    // with....
    @Test
    fun test_with() {
        assertUnsupportedOperation { it.with("foo") }
    }

    @Test
    fun test_withArray() {
        assertUnsupportedOperation { it.withArray("foo") }
    }

    @Test
    fun test_without_String() {
        assertUnsupportedOperation { it.without("foo") }
    }

    @Test
    fun test_without_StringCollection_1() {
        assertUnsupportedOperation { it.without(emptyList()) }
    }

    @Test
    fun test_without_StringCollection_2() {
        assertUnsupportedOperation { it.without(listOf("foo")) }
    }

    @Test
    fun test_without_StringCollection_3() {
        assertUnsupportedOperation { it.without(listOf("foo", "bar")) }
    }

    /*
     * Accessors
     */
    @Test
    fun test_asBoolean() {
        assertFalseForEmptyObjectNode { it.asBoolean() }
    }

    @Test
    fun test_asBoolean_defaultValue_1() {
        assertFalseForEmptyObjectNode { it.asBoolean(false) }
    }

    @Test
    fun test_asBoolean_defaultValue_2() {
        assertTrueForEmptyObjectNode { it.asBoolean(true) }
    }

    @Test
    fun test_asDouble() {
        assertEqualsForEmptyObjectNode(0.0) { it.asDouble() }
    }

    @Test
    fun test_asDouble_defaultValue() {
        assertEqualsForEmptyObjectNode(42.0) { it.asDouble(42.0) }
    }

    @Test
    fun test_asInt() {
        assertEqualsForEmptyObjectNode(0) { it.asInt() }
    }

    @Test
    fun test_asInt_defaultValue() {
        assertEqualsForEmptyObjectNode(42) { it.asInt(42) }
    }

    @Test
    fun test_asLong() {
        assertEqualsForEmptyObjectNode(0L) { it.asLong() }
    }

    @Test
    fun test_asLong_defaultValue() {
        assertEqualsForEmptyObjectNode(42L) { it.asLong(42L) }
    }

    @Test
    fun test_asText() {
        assertEqualsForEmptyObjectNode("") { it.asText() }
    }

    @Test
    fun test_asText_defaultValue() {
        assertEqualsForEmptyObjectNode("") { it.asText("foo") }
    }

    @Test
    fun test_asToken() {
        assertEqualsForEmptyObjectNode(JsonToken.START_OBJECT) { it.asToken() }
    }

    @Test
    fun test_bigIntegerValue() {
        assertEqualsForEmptyObjectNode(BigInteger.ZERO) { it.bigIntegerValue() }
    }

    @Test
    fun test_binaryValue() {
        assertNullForEmptyObjectNode { it.binaryValue() }
    }

    @Test
    fun test_booleanValue() {
        assertFalseForEmptyObjectNode { it.booleanValue() }
    }

    @Test
    fun test_canConvertToInt() {
        assertFalseForEmptyObjectNode { it.canConvertToInt() }
    }

    @Test
    fun test_canConvertToLong() {
        assertFalseForEmptyObjectNode { it.canConvertToLong() }
    }

    @Test
    fun test_decimalValue() {
        assertEqualsForEmptyObjectNode(BigDecimal.ZERO) { it.decimalValue() }
    }

    @Test
    fun test_doubleValue() {
        assertEqualsForEmptyObjectNode(0.0) { it.doubleValue() }
    }

    @Test
    fun test_elements() {
        assertFalseForEmptyObjectNode { it.elements().hasNext() }
    }

    @Test
    fun test_fieldNames() {
        assertFalseForEmptyObjectNode { it.fieldNames().hasNext() }
    }

    @Test
    fun test_fields() {
        assertFalseForEmptyObjectNode { it.fields().hasNext() }
    }

    @Test
    fun test_findParent() {
        assertNullForEmptyObjectNode { it.findParent("foo") }
    }

    @Test
    fun test_findParents_1() {
        assertEqualsForEmptyObjectNode(emptyList()) { it.findParents("foo") }
    }

    @Test
    fun test_findParents_2() {
        assertEqualsForEmptyObjectNode(listOf(TextNode("foo"))) {
            it.findParents("foo", listOf(TextNode("foo")))
        }
    }

    @Test
    fun test_findParents_3() {
        assertEqualsForEmptyObjectNode(listOf(TextNode("foo"), TextNode("bar"))) {
            it.findParents("foo", listOf(TextNode("foo"), TextNode("bar")))
        }
    }

    @Test
    fun test_findValue() {
        assertNullForEmptyObjectNode { it.findValue("foo") }
    }

    @Test
    fun test_findValues_1() {
        assertEqualsForEmptyObjectNode(emptyList()) {
            it.findValues("foo")
        }
    }

    @Test
    fun test_findValues_2() {
        assertEqualsForEmptyObjectNode(emptyList()) {
            it.findValues("foo", emptyList())
        }
    }

    @Test
    fun test_findValues_3() {
        assertEqualsForEmptyObjectNode(listOf(TextNode("foo"))) {
            it.findValues("foo", listOf(TextNode("foo")))
        }
    }

    @Test
    fun test_findValues_4() {
        assertEqualsForEmptyObjectNode(listOf(TextNode("foo"), TextNode("bar"))) {
            it.findValues("foo", listOf(TextNode("foo"), TextNode("bar")))
        }
    }

    @Test
    fun test_floatValue() {
        assertEqualsForEmptyObjectNode(0.0f) { it.floatValue() }
    }

    @Test
    fun test_get_String() {
        assertNullForEmptyObjectNode { it.get("foo") }
    }

    @Test
    fun test_get_int() {
        assertNullForEmptyObjectNode { it.get(42) }
    }

    @Test
    fun test_getNodeType() {
        assertEqualsForEmptyObjectNode(JsonNodeType.OBJECT) { it.nodeType }
    }

    @Test
    fun test_has_String() {
        assertFalseForEmptyObjectNode { it.has("foo") }
    }

    @Test
    fun test_has_Index() {
        assertFalseForEmptyObjectNode { it.has(42) }
    }

    @Test
    fun test_hasNonNull_String() {
        assertFalseForEmptyObjectNode { it.hasNonNull("foo") }
    }

    @Test
    fun test_hasNonNull_Index() {
        assertFalseForEmptyObjectNode { it.hasNonNull(42) }
    }

    @Test
    fun test_intValue() {
        assertEqualsForEmptyObjectNode(0) { it.intValue() }
    }

    @Test
    fun test_isArray() {
        assertFalseForEmptyObjectNode { it.isArray }
    }

    @Test
    fun test_isBigDecimal() {
        assertFalseForEmptyObjectNode { it.isBigDecimal }
    }

    @Test
    fun test_isBigInteger() {
        assertFalseForEmptyObjectNode { it.isBigInteger }
    }

    @Test
    fun test_isDouble() {
        assertFalseForEmptyObjectNode { it.isDouble }
    }

    @Test
    fun test_isEmpty() {
        assertTrueForEmptyObjectNode { it.isEmpty(null) }
    }

    @Test
    fun test_isFloat() {
        assertFalseForEmptyObjectNode { it.isFloat }
    }

    @Test
    fun test_isFloatingPointNumber() {
        assertFalseForEmptyObjectNode { it.isFloatingPointNumber }
    }

    @Test
    fun test_isInt() {
        assertFalseForEmptyObjectNode { it.isInt }
    }

    @Test
    fun test_isIntegral() {
        assertFalseForEmptyObjectNode { it.isIntegralNumber }
    }

    @Test
    fun test_isLong() {
        assertFalseForEmptyObjectNode { it.isLong }
    }

    @Test
    fun test_isMissingNode() {
        assertFalseForEmptyObjectNode { it.isMissingNode }
    }

    @Test
    fun test_isShort() {
        assertFalseForEmptyObjectNode { it.isShort }
    }

    @Test
    fun test_longValue() {
        assertEqualsForEmptyObjectNode(0L) { it.longValue() }
    }

    @Test
    fun test_numberType() {
        assertNullForEmptyObjectNode { it.numberType() }
    }

    @Test
    fun test_numberValue() {
        assertNullForEmptyObjectNode { it.numberValue() }
    }

    @Test
    fun test_path_String() {
        assertEqualsForEmptyObjectNode(MissingNode.getInstance()) { it.path("foo") }
    }

    @Test
    fun test_path_Index() {
        assertEqualsForEmptyObjectNode(MissingNode.getInstance()) { it.path(42) }
    }

    @Test
    fun test_shortValue() {
        assertEqualsForEmptyObjectNode(0) { it.shortValue() }
    }

    @Test
    fun test_size() {
        assertEqualsForEmptyObjectNode(0) { it.size() }
    }

    @Test
    fun test_textValue() {
        assertNullForEmptyObjectNode { it.textValue() }
    }

    @Test
    fun test_toString() {
        assertEqualsForEmptyObjectNode("{}") { it.toString() }
    }

    @Test
    fun test_hashCode() {
        assertEqualsForEmptyObjectNode(0) { it.hashCode() }
    }

    /*
     * Deep Copy
     */
    @Test
    fun test_deepCopy() {
        emptyObjectNode().let { original ->
            assertSame(original.deepCopy(), original)
        }
    }
}