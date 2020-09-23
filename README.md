# dcc

![Build](https://github.com/wulkanat/dcc/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Example of the language

```
// var and val are new variables
var a: int32 = 10
var b: int16 = 0

// strings have types (zero terminated, length, etc)
val c: String<zt> = "Hey ya!"zt

// vars are reassignable
b, a = a, b

// default parameters are possible
fun foo(a: float16 = 4): float16 {
    return a
}

val x: float16 = foo()

x = foo(60)

val y: int16 = null

// heap vals are variables on the heap as opposed to stack variables
// heap vals can be nullable
heap val z: int16? = null
// new keyword allocates memory
heap val zz: int16 = new int16(10)

// address<type> is the same as pointer type, can be retreived through addressOf(variable) from heap or stack variables
fun bar(a: heap float16): address<float16> {
  return addressOf(a)
}

val adr: address<float16> = bar(zz)
// deallocate heap variable
delete zz

// named parameter access
fun baz(a: int32, b: int32): int32 { return a + b }
baz(a = 10, b = 20)

var a = 10

```

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/publishing_plugin.html) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
This Fancy IntelliJ Platform Plugin is going to be your implementation of the brilliant ideas that you have.

This specific section is a source for the [plugin.xml](/src/main/resources/META-INF/plugin.xml) file which will be extracted by the [Gradle](/build.gradle.kts) during the build process.

To keep everything working, do not remove `<!-- ... -->` sections. 
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "dcc"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/wulkanat/dcc/releases/latest) and install it manually using
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
