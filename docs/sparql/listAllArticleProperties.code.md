# listAllArticleProperties.rq
**Code examples:** [curl](#curl)
### SPARQL
```sparql
PREFIX wp:      <http://vocabularies.wikipathways.org/wp#>
PREFIX dcterms: <http://purl.org/dc/terms/>

SELECT DISTINCT ?predicate WHERE {
  ?pubmed a wp:PublicationReference ;
          ?predicate [] .
}
```
[Execute](http://sparql.wikipathways.org/?query=PREFIX+wp%3A++++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0APREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0A%0ASELECT+DISTINCT+%3Fpredicate+WHERE+%7B%0A++%3Fpubmed+a+wp%3APublicationReference+%3B%0A++++++++++%3Fpredicate+%5B%5D+.%0A%7D%0A) [Edit](http://sparql.wikipathways.org/?qtxt=PREFIX+wp%3A++++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0APREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0A%0ASELECT+DISTINCT+%3Fpredicate+WHERE+%7B%0A++%3Fpubmed+a+wp%3APublicationReference+%3B%0A++++++++++%3Fpredicate+%5B%5D+.%0A%7D%0A)


### Output
<table>
  <tr>
    <td><b>predicate</b></td>
  </tr>
  <tr>
    <td>http://www.w3.org/1999/02/22-rdf-syntax-ns#type</td>
  </tr>
  <tr>
    <td>dcterms:isPartOf</td>
  </tr>
  <tr>
    <td>http://vocabularies.wikipathways.org/gpml#database</td>
  </tr>
  <tr>
    <td>http://vocabularies.wikipathways.org/gpml#id</td>
  </tr>
  <tr>
    <td>http://xmlns.com/foaf/0.1/page</td>
  </tr>
</table>
## Code examples
### curl
```shell
curl -o listAllArticleProperties.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/listAllArticleProperties.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@listAllArticleProperties.rq
```
