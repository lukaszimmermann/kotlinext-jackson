package kotlinext.jacksonmodule

import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionTests {

    private fun createObjectNode() = jacksonObjectMapper().createObjectNode()

    @Test
    fun `object node equal 0`() {
        assertEquals(
            expected = createObjectNode(),
            actual = objectNode()
        )
    }

    @Test
    fun `object node equal 1`() {
        assertEquals(
            expected = createObjectNode(),
            actual = objectNode {}
        )
    }

    @Test
    fun `object node equal 2`() {
        assertEquals(
            expected = createObjectNode().set("foo", TextNode("bar")),
            actual = objectNode { "foo" mapsTo "bar" }
        )
    }

    @Test
    fun `object node equal 3`() {
        assertEquals(
            expected = createObjectNode().apply {
                set("key1", TextNode("value1"))
                set("key2", TextNode("value2"))
            },
            actual = objectNode {
                "key1" mapsTo "value1"
                "key2" mapsTo "value2"
            }
        )
    }

    @Test
    fun `object node equal 4`() {
        assertEquals(
            expected = createObjectNode().set("foo", null),
            actual = objectNode {
                "foo" mapsTo null
            }
        )
    }

    @Test
    fun `object node equal 5`() {
        assertEquals(
            expected = createObjectNode().apply {
                set("key1", null)
                set("key2", TextNode("value2"))
            },
            actual = objectNode {
                "key2" mapsTo "value2"
                "key1" mapsTo null
            }
        )
    }
}
