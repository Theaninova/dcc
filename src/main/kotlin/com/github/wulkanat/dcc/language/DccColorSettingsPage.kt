package com.github.wulkanat.dcc.language

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class DccColorSettingsPage : ColorSettingsPage {
    companion object {
        private val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Key", DccSyntaxHighlighter.KEY),
                AttributesDescriptor("Separator", DccSyntaxHighlighter.SEPARATOR),
                AttributesDescriptor("Value", DccSyntaxHighlighter.VALUE),
                AttributesDescriptor("Bad Value", DccSyntaxHighlighter.BAD_CHARACTER),
        )
    }

    override fun getIcon() = DccIcons.FILE
    override fun getHighlighter() = DccSyntaxHighlighter()
    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null
    override fun getAttributeDescriptors() = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getDisplayName() = "DynamicC"

    override fun getDemoText() = """
        # You are reading the ".properties" entry.
        ! The exclamation mark can also mark text as comments.
        website = https://en.wikipedia.org/
        language = English
        # The backslash below tells the application to continue reading
        # the value onto the next line.
        message = Welcome to \
                  Wikipedia!
        # Add spaces to the key
        key\ with\ spaces = This is the value that could be looked up with the key "key with spaces".
        # Unicode
        tab : \u0009
    """.trimIndent()
}