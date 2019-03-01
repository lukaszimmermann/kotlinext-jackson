package kotlinext.jacksonmodule

import com.fasterxml.jackson.databind.node.TextNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlin.test.Test
import kotlin.test.assertEquals

class ExtensionTests {

    private fun createObjectNode() = jacksonObjectMapper().createObjectNode()
    private fun createArrayNode() = jacksonObjectMapper().createArrayNode()

    /*
     * Object Node
     */
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

    @Test
    fun `object node equal 6`() {
        assertEquals(
            expected = createObjectNode().apply {
                set("key1", null)
                set("key2", createObjectNode().apply {
                    set("key3", TextNode("value3"))
                })
            },
            actual = objectNode {
                "key1" mapsTo null
                "key2" mapsTo objectNode {
                    "key3" mapsTo "value3"
                }
            }
        )
    }

    /*
     * Array Node
     */
    @Test
    fun `array node equal 1`() {
        assertEquals(
            expected = createArrayNode().apply {
                add("foo")
                add("bar")
            },
            actual = arrayNode(TextNode("foo"), TextNode("bar")))
    }

    @Test
    fun `array node equal 2`() {
        assertEquals(
            expected = createArrayNode().apply {
                add("foo")
                add("bar")
            },
            actual = arrayNode("foo", "bar"))
    }

    /*
    * Object Node with nested array node
    */
    @Test
    fun `object node with array node 1`() {
        assertEquals(
            expected = createObjectNode().apply {
                set("key", createArrayNode().add("foo").add("bar"))
            },
            actual = objectNode {
                "key" mapsTo arrayNode("foo", "bar")
            })
    }

    @Test
    fun `object node with array node 2`() {
        assertEquals(
            expected = createObjectNode().apply {
                set("key", createArrayNode())
            },
            actual = objectNode {
                "key" mapsTo emptyArrayNode()
            })
    }

    @Test
    fun `empty Object`() {
        assertEquals(
            expected = createObjectNode(),
            actual = emptyObjectNode())
    }

    @Test
    fun `empty Array`() {
        assertEquals(
            expected = createArrayNode(),
            actual = emptyArrayNode())
    }
}
