# listAllDataNodePredicates.rq
**Code examples:** [curl](#curl)
### SPARQL
```sparql
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>

SELECT DISTINCT ?predicate
WHERE {
 ?pw a wp:DataNode ;
     ?predicate [] .
}
```
[Execute](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0A%0ASELECT+DISTINCT+%3Fpredicate%0AWHERE+%7B%0A+%3Fpw+a+wp%3ADataNode+%3B%0A+++++%3Fpredicate+%5B%5D+.%0A%7D%0A) [Edit](http://sparql.wikipathways.org/?qtxt=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0A%0ASELECT+DISTINCT+%3Fpredicate%0AWHERE+%7B%0A+%3Fpw+a+wp%3ADataNode+%3B%0A+++++%3Fpredicate+%5B%5D+.%0A%7D%0A)


### Output
<table>
  <tr>
    <td><b>predicate</b></td>
  </tr>
  <tr>
    <td>http://www.w3.org/1999/02/22-rdf-syntax-ns#type</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/elements/1.1/creator</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/elements/1.1/identifier</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/terms/isPartOf</td>
  </tr>
  <tr>
    <td>wp:bdbWikidata</td>
  </tr>
  <tr>
    <td>http://www.w3.org/2000/01/rdf-schema#label</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/terms/bibliographicCitation</td>
  </tr>
  <tr>
    <td>http://purl.org/pav/hasVersion</td>
  </tr>
  <tr>
    <td>wp:bdbEnsembl</td>
  </tr>
  <tr>
    <td>wp:bdbEntrezGene</td>
  </tr>
  <tr>
    <td>wp:bdbHgncSymbol</td>
  </tr>
  <tr>
    <td>wp:bdbHmdb</td>
  </tr>
  <tr>
    <td>wp:bdbLipidMaps</td>
  </tr>
  <tr>
    <td>wp:bdbUniprot</td>
  </tr>
  <tr>
    <td>wp:isAbout</td>
  </tr>
  <tr>
    <td>wp:participants</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/elements/1.1/source</td>
  </tr>
  <tr>
    <td>http://purl.org/dc/terms/identifier</td>
  </tr>
  <tr>
    <td>wp:bdbChEBI</td>
  </tr>
  <tr>
    <td>wp:bdbChemspider</td>
  </tr>
  <tr>
    <td>wp:bdbKeggCompound</td>
  </tr>
  <tr>
    <td>wp:bdbPubChem</td>
  </tr>
  <tr>
    <td>wp:bdbReactome</td>
  </tr>
</table>
## Code examples
### curl
```shell
curl -o listAllDataNodePredicates.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/listAllDataNodePredicates.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@listAllDataNodePredicates.rq
```
