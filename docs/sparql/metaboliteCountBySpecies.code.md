# metaboliteCountBySpecies.rq
**Code examples:** [curl](#curl)### SPARQL```sparqlPREFIX gpml:    <http://vocabularies.wikipathways.org/gpml#>
PREFIX dcterms: <http://purl.org/dc/terms/>
PREFIX dc:      <http://purl.org/dc/elements/1.1/>
PREFIX rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> 

select (count(distinct ?wikidata) as ?count) (str(?label) as ?species) where {
  ?metabolite a wp:Metabolite ;
    wp:bdbWikidata ?wikidata ;
    dcterms:isPartOf ?pw .
  ?pw wp:organismName ?label .
} GROUP BY ?label ORDER BY DESC(?count)
```[Execute](http://sparql.wikipathways.org/?query=PREFIX+gpml%3A++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fgpml%23%3E%0APREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0APREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX+rdf%3A+++++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+%0A%0Aselect+%28count%28distinct+%3Fwikidata%29+as+%3Fcount%29+%28str%28%3Flabel%29+as+%3Fspecies%29+where+%7B%0A++%3Fmetabolite+a+wp%3AMetabolite+%3B%0A++++wp%3AbdbWikidata+%3Fwikidata+%3B%0A++++dcterms%3AisPartOf+%3Fpw+.%0A++%3Fpw+wp%3AorganismName+%3Flabel+.%0A%7D+GROUP+BY+%3Flabel+ORDER+BY+DESC%28%3Fcount%29%0A) [Edit](http://sparql.wikipathways.org/?qtxt=PREFIX+gpml%3A++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fgpml%23%3E%0APREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0APREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX+rdf%3A+++++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E+%0A%0Aselect+%28count%28distinct+%3Fwikidata%29+as+%3Fcount%29+%28str%28%3Flabel%29+as+%3Fspecies%29+where+%7B%0A++%3Fmetabolite+a+wp%3AMetabolite+%3B%0A++++wp%3AbdbWikidata+%3Fwikidata+%3B%0A++++dcterms%3AisPartOf+%3Fpw+.%0A++%3Fpw+wp%3AorganismName+%3Flabel+.%0A%7D+GROUP+BY+%3Flabel+ORDER+BY+DESC%28%3Fcount%29%0A)

### Output<table>
  <tr>
    <td><b>count</b></td>
    <td><b>species</b></td>
  </tr>
  <tr>
    <td>2890</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>843</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>840</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>489</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>439</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>338</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>169</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>125</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>104</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>97</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>81</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>75</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>69</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>65</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>63</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>58</td>
    <td>Zea mays</td>
  </tr>
  <tr>
    <td>49</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>39</td>
    <td>Solanum lycopersicum</td>
  </tr>
  <tr>
    <td>31</td>
    <td>Populus trichocarpa</td>
  </tr>
  <tr>
    <td>20</td>
    <td>Equus caballus</td>
  </tr>
  <tr>
    <td>13</td>
    <td>Plasmodium falciparum</td>
  </tr>
  <tr>
    <td>11</td>
    <td>Gibberella zeae</td>
  </tr>
  <tr>
    <td>8</td>
    <td>Bacillus subtilis</td>
  </tr>
</table>
## Code examples### curl```shellcurl -o metaboliteCountBySpecies.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/metaboliteCountBySpecies.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@metaboliteCountBySpecies.rq
```