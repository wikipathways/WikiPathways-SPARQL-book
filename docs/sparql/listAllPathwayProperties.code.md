# listAllPathwayProperties.rq
**Code examples:** [curl](#curl)
### SPARQL
```sparql
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>

SELECT DISTINCT ?predicate
WHERE {
 ?pw a wp:Pathway ;
     ?predicate [] .
}
```
[Execute](http://sparql.wikipathways.org/sparql?query=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0A%0ASELECT+DISTINCT+%3Fpredicate%0AWHERE+%7B%0A+%3Fpw+a+wp%3APathway+%3B%0A+++++%3Fpredicate+%5B%5D+.%0A%7D%0A) or [Edit](http://sparql.wikipathways.org/sparql?qtxt=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0A%0ASELECT+DISTINCT+%3Fpredicate%0AWHERE+%7B%0A+%3Fpw+a+wp%3APathway+%3B%0A+++++%3Fpredicate+%5B%5D+.%0A%7D%0A)


### Output
<table>
  <tr>
    <td><b>predicate</b></td>
  </tr>
  <tr>
    <td>http://www.w3.org/1999/02/22-rdf-syntax-ns#type</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/terms/description</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/elements/1.1/identifier</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/elements/1.1/source</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/elements/1.1/title</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/terms/identifier</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/terms/references</td>
  </tr>
  <tr>
    <td>wp:cellTypeOntologyTag</td>
  </tr>
  <tr>
    <td>wp:diseaseOntologyTag</td>
  </tr>
  <tr>
    <td>wp:isAbout</td>
  </tr>
  <tr>
    <td>wp:ontologyTag</td>
  </tr>
  <tr>
    <td>wp:organism</td>
  </tr>
  <tr>
    <td>wp:organismName</td>
  </tr>
  <tr>
    <td>wp:pathwayOntologyTag</td>
  </tr>
  <tr>
    <td>http://xmlns.com/foaf/0.1/page</td>
  </tr>
</table>
## Code examples
### curl
```shell
curl -o listAllPathwayProperties.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/listAllPathwayProperties.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@listAllPathwayProperties.rq
```
