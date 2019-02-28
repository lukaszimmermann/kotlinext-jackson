package kotlinext.jacksonmodule

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.math.BigDecimal
import java.math.BigInteger
import javax.xml.soap.Text
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertSame

class EmptyArrayNodeTests {

    private fun assertUnsupportedOperation(func: () -> Unit) {
        assertFailsWith<UnsupportedOperationException> { func() }
    }

    @Test
    fun `empty array node returns identical instance`() {
        assertSame(emptyArrayNode(), emptyArrayNode())
    }

    @Test
    fun `test add big decimal`() {
        assertUnsupportedOperation { emptyArrayNode().add(BigDecimal.ONE) }
    }

    @Test
    fun `test add boolean`() {
        assertUnsupportedOperation { emptyArrayNode().add(true) }
    }

    @Test
    fun `test add big integer`() {
        assertUnsupportedOperation { emptyArrayNode().add(BigInteger.ONE) }
    }

    @Test
    fun `test add byte array`() {
        assertUnsupportedOperation { emptyArrayNode().add(ByteArray(1)) }
    }

    @Test
    fun `test add double`() {
        assertUnsupportedOperation { emptyArrayNode().add(0.0) }
    }

    @Test
    fun `test add float`() {
        assertUnsupportedOperation { emptyArrayNode().add(0.0f) }
    }

    @Test
    fun `test add int`() {
        assertUnsupportedOperation { emptyArrayNode().add(1) }
    }

    @Test
    fun `test add string 1`() {
        assertUnsupportedOperation { emptyArrayNode().add("foo") }
    }

    @Test
    fun `test add string 2`() {
        assertUnsupportedOperation { emptyArrayNode().add("") }
    }

    @Test
    fun `test add json node 1`() {
        assertUnsupportedOperation { emptyArrayNode().add(jacksonObjectMapper().createArrayNode()) }
    }

    @Test
    fun `test add json node 2`() {
        assertUnsupportedOperation { emptyArrayNode().add(jacksonObjectMapper().createObjectNode()) }
    }

    @Test
    fun `test add all collection`() {
        assertUnsupportedOperation { emptyArrayNode().addAll(listOf(TextNode("foo"), TextNode("bar"))) }
    }

    @Test
    fun `test add all array node`() {
        assertUnsupportedOperation { emptyArrayNode().addAll(arrayNode("foo", "bar"))   }
    }

    @Test
    fun `test addArray`() {
        assertUnsupportedOperation { emptyArrayNode().addArray() }
    }

    @Test
    fun `test addNull`() {
        assertUnsupportedOperation { emptyArrayNode().addNull() }
    }

    @Test
    fun `test addObject`() {
        assertUnsupportedOperation { emptyArrayNode().addObject() }
    }

    @Test
    fun `test addPojo 1`() {
        assertUnsupportedOperation { emptyArrayNode().addPOJO(null) }
    }

    @Test
    fun `test addPojo 2`() {
        assertUnsupportedOperation { emptyArrayNode().addPOJO(Object()) }
    }

    @Test
    fun `test add raw value`() {
        assertUnsupportedOperation { emptyArrayNode().addRawValue(null) }
    }

    @Test
    fun `test set`() {
        assertUnsupportedOperation { emptyArrayNode().set(0, TextNode("Foo")) }
    }

    @Test
    fun `test with array`() {
        assertUnsupportedOperation { emptyArrayNode().withArray("foo") }
    }

    @Test
    fun `test with`() {
        assertUnsupportedOperation { emptyArrayNode().with("foo") }
    }

    @Test
    fun `test remove all`() {
        assertUnsupportedOperation { emptyArrayNode().removeAll() }
    }

    @Test
    fun `test remove`() {
        assertUnsupportedOperation { emptyArrayNode().remove(42) }
    }

    @Test
    fun `insert POJO`() {
        assertUnsupportedOperation { emptyArrayNode().insertPOJO(42, Object()) }
    }

    @Test
    fun `insert Object`() {
        assertUnsupportedOperation { emptyArrayNode().insertObject(42) }
    }
}

