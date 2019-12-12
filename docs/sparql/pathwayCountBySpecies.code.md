# pathwayCountBySpecies.rq
**Code examples:** [curl](#curl)### SPARQL```sparqlPREFIX dc:      <http://purl.org/dc/elements/1.1/> 
PREFIX wp: <http://vocabularies.wikipathways.org/wp#>

SELECT DISTINCT ?organism (str(?label) as ?name) (count(?pw) as ?pathwayCount)
WHERE {
    ?pw dc:title ?title ;
      wp:organism ?organism ;
      wp:organismName ?label .
}
ORDER BY DESC(?pathwayCount)
```[Execute](http://sparql.wikipathways.org/?query=PREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E+%0APREFIX+wp%3A+%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0A%0ASELECT+DISTINCT+%3Forganism+%28str%28%3Flabel%29+as+%3Fname%29+%28count%28%3Fpw%29+as+%3FpathwayCount%29%0AWHERE+%7B%0A++++%3Fpw+dc%3Atitle+%3Ftitle+%3B%0A++++++wp%3Aorganism+%3Forganism+%3B%0A++++++wp%3AorganismName+%3Flabel+.%0A%7D%0AORDER+BY+DESC%28%3FpathwayCount%29%0A) [Edit](http://sparql.wikipathways.org/?qtxt=PREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E+%0APREFIX+wp%3A+%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3E%0A%0ASELECT+DISTINCT+%3Forganism+%28str%28%3Flabel%29+as+%3Fname%29+%28count%28%3Fpw%29+as+%3FpathwayCount%29%0AWHERE+%7B%0A++++%3Fpw+dc%3Atitle+%3Ftitle+%3B%0A++++++wp%3Aorganism+%3Forganism+%3B%0A++++++wp%3AorganismName+%3Flabel+.%0A%7D%0AORDER+BY+DESC%28%3FpathwayCount%29%0A)

### Output<table>
  <tr>
    <td><b>organism</b></td>
    <td><b>name</b></td>
    <td><b>pathwayCount</b></td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_9606</td>
    <td>Homo sapiens</td>
    <td>1041</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_9913</td>
    <td>Bos taurus</td>
    <td>274</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_10090</td>
    <td>Mus musculus</td>
    <td>194</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_10116</td>
    <td>Rattus norvegicus</td>
    <td>155</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_4932</td>
    <td>Saccharomyces cerevisiae</td>
    <td>115</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_7955</td>
    <td>Danio rerio</td>
    <td>83</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_6239</td>
    <td>Caenorhabditis elegans</td>
    <td>61</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_9598</td>
    <td>Pan troglodytes</td>
    <td>46</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_9615</td>
    <td>Canis familiaris</td>
    <td>44</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_9031</td>
    <td>Gallus gallus</td>
    <td>40</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_3702</td>
    <td>Arabidopsis thaliana</td>
    <td>31</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_7227</td>
    <td>Drosophila melanogaster</td>
    <td>30</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_7165</td>
    <td>Anopheles gambiae</td>
    <td>14</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_1773</td>
    <td>Mycobacterium tuberculosis</td>
    <td>12</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_4530</td>
    <td>Oryza sativa</td>
    <td>11</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_562</td>
    <td>Escherichia coli</td>
    <td>9</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_9796</td>
    <td>Equus caballus</td>
    <td>5</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_3694</td>
    <td>Populus trichocarpa</td>
    <td>5</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_4081</td>
    <td>Solanum lycopersicum</td>
    <td>4</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_4577</td>
    <td>Zea mays</td>
    <td>4</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_1423</td>
    <td>Bacillus subtilis</td>
    <td>2</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_5518</td>
    <td>Gibberella zeae</td>
    <td>1</td>
  </tr>
  <tr>
    <td>http://purl.obolibrary.org/obo/NCBITaxon_5833</td>
    <td>Plasmodium falciparum</td>
    <td>1</td>
  </tr>
</table>
## Code examples### curl```shellcurl -o pathwayCountBySpecies.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/pathwayCountBySpecies.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@pathwayCountBySpecies.rq
```