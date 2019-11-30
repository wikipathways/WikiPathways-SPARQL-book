# Federated Queries

One of the features of SPARQL is that you can run a query over more
than one SPARQL endpoint. Here we report a number of such SPARQL
queries.

## The Kidney & Urinary Pathway Knowledge Base

The Kidney & Urinary Pathway Knowledge Base (KUPKB) is a knowledge
base of assay data [<a href="#citeref1">1</a>,<a href="#citeref2">2</a>].
The following query lists all assay data for genew in WP1560:

**SPARQL** [sparql/kupkbGene.rq](sparql/kupkbGene.code.html)
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

## References

1. <a name="citeref1"></a>Jupp S, Klein J, Schanstra J, Stevens R. Developing a kidney and urinary pathway knowledge base. J Biomed Semantics. 2011;2 Suppl 2(Suppl 2):S7.  doi:[10.1186/2041-1480-2-S2-S7](https://doi.org/10.1186/2041-1480-2-S2-S7) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1186/2041-1480-2-S2-S7))
2. <a name="citeref2"></a>Klein J, Jupp S, Moulos P, Fernandez M, Buffin-Meyer B, Casemayou A, et al. The KUPKB: a novel Web application to access multiomics data on kidney disease. FASEB J. 2012 May;26(5):2145–53.  doi:[10.1096/FJ.11-194381](https://doi.org/10.1096/FJ.11-194381) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1096/FJ.11-194381))


