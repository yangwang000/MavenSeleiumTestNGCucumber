# Notes about Selenium

## Locator strategies and encouraged practices:
(source: https://www.selenium.dev/documentation/webdriver/elements/locators/
https://www.selenium.dev/documentation/test_practices/encouraged/locators/)

**8 traditional location strategies:**
id attribute, css selector, class name, name attribute, link text, partial link text, tag name, xpath

In a word, ids are the best then the CSS selector.

### Css Selector Cheat Sheet
```
ID, Class, Attribute, Sub-String, Child, Sibling, Specific match, Chaining

#ID
Tag#ID

.ClassName
Tag.ClassName

[attribute='attribute_value']
Tag[attribute='attribute_value']

Sub-String prefix
[attribute^='attribute_prefix_value']

Sub-String suffix
[attribute$='attribute_suffix_value']

Sub-String sub-string
[attribute*='attribute_substring_value']

Direct child
div > a

Child or Sub-Child
div a

Next Sibling
element + sibling

Specific Match
Tag:nth-of-type(number)
Tag:nth-child(number)

Chaining
Tag[attribute1='attribute_value1'][attribute2='attribute_value2']
```

## Best Practice
Encouraged behaviors : https://www.selenium.dev/documentation/test_practices/encouraged/

Builder Pattern

Data Objects

WebDriverManager

Config Properties: can be used for global variables that are required to be initialized only once and shared across the framework.

Atomic Tests 

## Misc
**Verify webdriver binary on macos** : xattr -d com.apple.quarantine [name-of-executable]

**Execute tests:** 
mvn clean test -Dsurefire.suiteXmlFiles=testng_chrome.xml,testng_firefox.xml

mvn clean test (hardcode testng file path)

mvn clean test -DsuiteFile=testng_chrome.xml (define suiteFile property)

**Explicit Wait For Page To Load Strategies:**
1. Wait for the page title or for the URL to show up in the URL bar
2. Wait for slowest element to load
3. Wait for each UI element

# BDD
## 3 Practices
Discovery, Formulation, and Automation.https://cucumber.io/docs/bdd/

## Discovery workshop
https://cucumber.io/docs/bdd/discovery-workshop/

## Example Mapping
https://cucumber.io/docs/bdd/example-mapping/
