# listAllMetabolitePredicates.rq
**Code examples:** [curl](#curl)
### SPARQL
```sparql
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>

SELECT DISTINCT ?predicate
WHERE {
 ?pw a wp:Metabolite ;
     ?predicate [] .
}
```
[Execute](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%3FpredicateWHERE+%7B+%3Fpw+a+wp%3AMetabolite+%3B+++++%3Fpredicate+%5B%5D+.%7D)
### Output
<table>
  <tr>
    <td><b>predicate</b></td>
  </tr>
  <tr>
    <td>http://www.w3.org/1999/02/22-rdf-syntax-ns#type</td>
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
    <td>wp:bdbHmdb</td>
  </tr>
  <tr>
    <td>wp:bdbLipidMaps</td>
  </tr>
  <tr>
    <td>wp:isAbout</td>
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
curl -o listAllMetabolitePredicates.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/listAllMetabolitePredicates.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@listAllMetabolitePredicates.rq
```