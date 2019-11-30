# kupkbGene.rq
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

SELECT DISTINCT ?geneProduct ?geneid ?genesymbol ?expression ?sample ?factor ?species ?experiment WHERE {
  ?pathway dcterms:identifier "WP1560"^^xsd:string ;
           wp:organismName ?species .
  ?geneProduct a wp:GeneProduct ;
      rdfs:label ?label ;
      dcterms:isPartOf ?pathway ;
      wp:bdbEntrezGene ?ncbiID .
  BIND (iri(concat("http://bio2rdf.org/geneid:",SUBSTR(str(?ncbiID),33))) AS ?geneid)
  SERVICE <http://sparql.kupkb.org/sparql> {
    {?geneid bio2rdf:symbol ?genesymbol}
    UNION
    {?geneid rdfs:label ?genesymbol}
    
    {?listmember kupkb:hasDatabaseRef ?geneid} 
    UNION              
    { ?geneid <http://bio2rdf.org/ns/uniprot:xProtein> ?uniprot .  
      ?listmember kupkb:hasDatabaseRef ?uniprot .
    }
    ?listmember kupkb:hasExpression ?expressionURI .  
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
