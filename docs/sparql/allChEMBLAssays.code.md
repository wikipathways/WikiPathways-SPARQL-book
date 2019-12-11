# allChEMBLAssays.rq
**Code examples:** [curl](#curl)
### SPARQL
```sparql
PREFIX chembl: <http://rdf.ebi.ac.uk/terms/chembl#>

SELECT ?pathway ?chembluniprot ?assay WHERE {
  {
    SELECT DISTINCT
      ?pathway
      iri(
        bif:concat("http://purl.uniprot.org/uniprot/",
        bif:regexp_substr('http://identifiers.org/uniprot/(.*)',?uniprot, 1))
      ) as ?chembluniprot
    WHERE {
      VALUES ?type { wp:Protein wp:GeneProduct }
      ?s a ?type ;
         wp:bdbUniprot ?uniprot ;
         dcterms:isPartOf ?pathway .
      ?pathway a wp:Pathway .
    } LIMIT 50
  }
  SERVICE <http://www.ebi.ac.uk/rdf/services/chembl/sparql>  {
    ?assay a chembl:Assay ; chembl:hasTarget/chembl:hasTargetComponent/chembl:targetCmptXref ?chembluniprot .
  }
}
```
[Execute](http://sparql.wikipathways.org/?query=PREFIX+chembl%3A+%3Chttp%3A%2F%2Frdf.ebi.ac.uk%2Fterms%2Fchembl%23%3ESELECT+%3Fpathway+%3Fchembluniprot+%3Fassay+WHERE+%7B++%7B++++SELECT+DISTINCT++++++%3Fpathway++++++iri%28++++++++bif%3Aconcat%28%22http%3A%2F%2Fpurl.uniprot.org%2Funiprot%2F%22%2C++++++++bif%3Aregexp_substr%28%27http%3A%2F%2Fidentifiers.org%2Funiprot%2F%28.*%29%27%2C%3Funiprot%2C+1%29%29++++++%29+as+%3Fchembluniprot++++WHERE+%7B++++++VALUES+%3Ftype+%7B+wp%3AProtein+wp%3AGeneProduct+%7D++++++%3Fs+a+%3Ftype+%3B+++++++++wp%3AbdbUniprot+%3Funiprot+%3B+++++++++dcterms%3AisPartOf+%3Fpathway+.++++++%3Fpathway+a+wp%3APathway+.++++%7D+LIMIT+50++%7D++SERVICE+%3Chttp%3A%2F%2Fwww.ebi.ac.uk%2Frdf%2Fservices%2Fchembl%2Fsparql%3E++%7B++++%3Fassay+a+chembl%3AAssay+%3B+chembl%3AhasTarget%2Fchembl%3AhasTargetComponent%2Fchembl%3AtargetCmptXref+%3Fchembluniprot+.++%7D%7D)
### Output
<table>
  <tr>
    <td><b>pathway</b></td>
    <td><b>chembluniprot</b></td>
    <td><b>assay</b></td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL1014320</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106513</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106515</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106518</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106519</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106521</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3875643</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100_r107114</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3875645</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL1014320</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106513</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106515</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106518</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106519</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3106521</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3875643</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP167_r106700</td>
    <td>http://purl.uniprot.org/uniprot/P19440</td>
    <td>http://rdf.ebi.ac.uk/resource/chembl/assay/CHEMBL3875645</td>
  </tr>
</table>
## Code examples
### curl
```shell
curl -o allChEMBLAssays.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/allChEMBLAssays.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@allChEMBLAssays.rq
```
