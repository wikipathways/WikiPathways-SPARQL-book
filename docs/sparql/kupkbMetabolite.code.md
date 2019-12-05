# kupkbMetabolite.rq
**Source code:**
```sparql
PREFIX wp: <http://vocabularies.wikipathways.org/wp#>
PREFIX dcterms: <http://purl.org/dc/terms/>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
PREFIX kupkb: <http://www.kupkb.org/data/kupkb/>
PREFIX kupo: <http://www.kupkb.org/data/kupo/>
PREFIX obo: <http://purl.org/obo/owl/>
PREFIX bio2rdf: <http://bio2rdf.org/ns/bio2rdf:>

SELECT DISTINCT ?geneProduct ?label ?species ?metid ?symbol ?expression ?sample ?factor ?experiment WHERE {
  ?pathway dcterms:identifier "WP3604"^^xsd:string ;
           wp:organismName ?species .
  ?geneProduct a wp:Metabolite ;
      rdfs:label ?label ;
      dcterms:isPartOf ?pathway ;
      wp:bdbHmdb ?hmdbID .
  BIND (iri(concat("http://bio2rdf.org/hmdb:HMDB",SUBSTR(str(?hmdbID),35))) AS ?metid)
  SERVICE <http://sparql.kupkb.org/sparql> {
    {?metid bio2rdf:symbol ?symbol}
    UNION
    {?metid rdfs:label ?symbol}
    
    ?listmember kupkb:hasDatabaseRef ?metid ;
                kupkb:hasExpression ?expressionURI .  
    ?expressionURI rdfs:label ?expression .
    ?compoundList kupkb:hasMember ?listmember .    
    ?analysis kupkb:produces ?compoundList ;
              kupkb:annotatedWith ?annotation ;
              kupkb:analysisOf  ?experiment  .
    ?annotation kupkb:hasAnnotationRole kupo:KUPO_0300008 ;
                kupkb:bioMaterial ?analyteBioMaterial . 
    ?analyteBioMaterial rdfs:label ?sample . 
    OPTIONAL {
      ?annotation kupkb:hasDisease ?analyteDiseaseURI . 
      ?analyteDiseaseURI rdfs:label ?factor .
    } 
  }
}

```
**Output:**
<table>
  <tr>
  </tr>
</table>
[Execute](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3EPREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3EPREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3EPREFIX+rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3EPREFIX+owl%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3EPREFIX+xsd%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3EPREFIX+kupkb%3A+%3Chttp%3A%2F%2Fwww.kupkb.org%2Fdata%2Fkupkb%2F%3EPREFIX+kupo%3A+%3Chttp%3A%2F%2Fwww.kupkb.org%2Fdata%2Fkupo%2F%3EPREFIX+obo%3A+%3Chttp%3A%2F%2Fpurl.org%2Fobo%2Fowl%2F%3EPREFIX+bio2rdf%3A+%3Chttp%3A%2F%2Fbio2rdf.org%2Fns%2Fbio2rdf%3A%3ESELECT+DISTINCT+%3FgeneProduct+%3Flabel+%3Fspecies+%3Fmetid+%3Fsymbol+%3Fexpression+%3Fsample+%3Ffactor+%3Fexperiment+WHERE+%7B++%3Fpathway+dcterms%3Aidentifier+%22WP3604%22%5E%5Exsd%3Astring+%3B+++++++++++wp%3AorganismName+%3Fspecies+.++%3FgeneProduct+a+wp%3AMetabolite+%3B++++++rdfs%3Alabel+%3Flabel+%3B++++++dcterms%3AisPartOf+%3Fpathway+%3B++++++wp%3AbdbHmdb+%3FhmdbID+.++BIND+%28iri%28concat%28%22http%3A%2F%2Fbio2rdf.org%2Fhmdb%3AHMDB%22%2CSUBSTR%28str%28%3FhmdbID%29%2C35%29%29%29+AS+%3Fmetid%29++SERVICE+%3Chttp%3A%2F%2Fsparql.kupkb.org%2Fsparql%3E+%7B++++%7B%3Fmetid+bio2rdf%3Asymbol+%3Fsymbol%7D++++UNION++++%7B%3Fmetid+rdfs%3Alabel+%3Fsymbol%7D++++++++%3Flistmember+kupkb%3AhasDatabaseRef+%3Fmetid+%3B++++++++++++++++kupkb%3AhasExpression+%3FexpressionURI+.++++++%3FexpressionURI+rdfs%3Alabel+%3Fexpression+.++++%3FcompoundList+kupkb%3AhasMember+%3Flistmember+.++++++++%3Fanalysis+kupkb%3Aproduces+%3FcompoundList+%3B++++++++++++++kupkb%3AannotatedWith+%3Fannotation+%3B++++++++++++++kupkb%3AanalysisOf++%3Fexperiment++.++++%3Fannotation+kupkb%3AhasAnnotationRole+kupo%3AKUPO_0300008+%3B++++++++++++++++kupkb%3AbioMaterial+%3FanalyteBioMaterial+.+++++%3FanalyteBioMaterial+rdfs%3Alabel+%3Fsample+.+++++OPTIONAL+%7B++++++%3Fannotation+kupkb%3AhasDisease+%3FanalyteDiseaseURI+.+++++++%3FanalyteDiseaseURI+rdfs%3Alabel+%3Ffactor+.++++%7D+++%7D%7D)
