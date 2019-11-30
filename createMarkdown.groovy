// Copyright (c) 2018-2019  Egon Willighagen <egon.willighagen@gmail.com>
//
// GPL v3

input = args[0]

lines = new File(input).readLines()
lines.each { String line ->
  if (line.startsWith("<sparql>")) {
    def instruction = new XmlSlurper().parseText(line)
    def srcLines = new File("sparql/${instruction.text()}.verbatim.md").readLines()
    srcLines.each { String srcLine -> println srcLine }
  } else if (line.startsWith("<out>")) {
    def instruction = new XmlSlurper().parseText(line)
    def srcLines = new File("sparql/${instruction.text()}.out").readLines()
    srcLines.each { String srcLine -> println srcLine }
  } else {
    while (line.contains(".i.md")) {
      line = line.replace(".i.md", ".md")
    }
    println line
  }
}
