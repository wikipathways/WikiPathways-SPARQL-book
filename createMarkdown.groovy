// Copyright (c) 2018-2019  Egon Willighagen <egon.willighagen@gmail.com>
//
// GPL v3

input = args[0]

bibliography = new HashMap<String,String>();
def bibLines = new File("references.dat").readLines()
bibLines.each { String line ->
  splitString = '=1. '; fields = []
  fields[0] = line.substring(0,line.indexOf(splitString))
  fields[1] = line.substring(line.indexOf(splitString)+splitString.length())
  bibliography.put(fields[0], fields[1])
}

references = new HashMap<String,String>();
bibList = "";
refCounter = 0;

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
  } else if (line.startsWith("<toc>")) {
    def instruction = new XmlSlurper().parseText(line)
    def srcLines = new File("${instruction.text()}").readLines()
    srcLines.each { String srcLine -> println srcLine.replaceAll(".i.md", ".md") }
  } else if (line.contains("<references/>")) {
    println bibList
  } else {
    while (line.contains(".i.md")) {
      line = line.replace(".i.md", ".md")
    }
    while (line.contains("<cite>")) {
      citeStart = line.indexOf("<cite>")
      citeEnd = line.indexOf("</cite>")
      cites = line.substring(citeStart+6, citeEnd)
      if (cites.isEmpty()) cites = "?"
      replacement = ""
      if (!references.containsKey(cites)) {
        refCounter++
        references.put(cites, "" + refCounter)
        bibList += "${refCounter}. <a name=\"citeref${refCounter}\"></a>"
        if (bibliography.get(cites) != null) {
          bibList += bibliography.get(cites) + "\n"
        } else {
          bibList += "Missing\n"
        }
        replacement = "<a href=\"#citeref${refCounter}\">${refCounter}</a>"
      } else {
        existingCounter = Integer.valueOf(references.get(cites))
        replacement = "<a href=\"#citeref${existingCounter}\">${existingCounter}</a>"
      }
      line = line.substring(0, citeStart) + replacement + line.substring(citeEnd+7)
    }
    println line
  }
}
