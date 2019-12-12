# Federated Queries

One of the features of SPARQL is that you can run a query over more
than one SPARQL endpoint. Here we report a number of such <a name="tp1">federated SPARQL</a>
queries.

## ChEMBL

[<a name="tp2">ChEMBL</a>](https://www.ebi.ac.uk/chembl/) is one of the databases which also have a
[SPARQL endpoint](https://www.ebi.ac.uk/rdf/services/sparql) [<a href="#citeref1">1</a>,<a href="#citeref2">2</a>].
The database contains many biological activities of chemical compounds against many (protein)
targets, as measured with assays.

### Bioassays related to a pathway

We can list all <a name="tp3">assays</a> for a certain pathway with the following federated query:

**SPARQL** [sparql/allChEMBLAssays.rq](sparql/allChEMBLAssays.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+chembl%3A+%3Chttp%3A%2F%2Frdf.ebi.ac.uk%2Fterms%2Fchembl%23%3E%0A%0ASELECT+%3Fpathway+%3Fchembluniprot+%3Fassay+WHERE+%7B%0A++%7B%0A++++SELECT+DISTINCT%0A++++++%3Fpathway%0A++++++iri%28%0A++++++++bif%3Aconcat%28%22http%3A%2F%2Fpurl.uniprot.org%2Funiprot%2F%22%2C%0A++++++++bif%3Aregexp_substr%28%27http%3A%2F%2Fidentifiers.org%2Funiprot%2F%28.*%29%27%2C%3Funiprot%2C+1%29%29%0A++++++%29+as+%3Fchembluniprot%0A++++WHERE+%7B%0A++++++VALUES+%3Ftype+%7B+wp%3AProtein+wp%3AGeneProduct+%7D%0A++++++%3Fs+a+%3Ftype+%3B%0A+++++++++wp%3AbdbUniprot+%3Funiprot+%3B%0A+++++++++dcterms%3AisPartOf+%3Fpathway+.%0A++++++%3Fpathway+a+wp%3APathway+.%0A++++%7D+LIMIT+50%0A++%7D%0A++SERVICE+%3Chttp%3A%2F%2Fwww.ebi.ac.uk%2Frdf%2Fservices%2Fchembl%2Fsparql%3E++%7B%0A++++%3Fassay+a+chembl%3AAssay+%3B+chembl%3AhasTarget%2Fchembl%3AhasTargetComponent%2Fchembl%3AtargetCmptXref+%3Fchembluniprot+.%0A++%7D%0A%7D%0A), [edit](http://sparql.wikipathways.org/?qtxt=PREFIX+chembl%3A+%3Chttp%3A%2F%2Frdf.ebi.ac.uk%2Fterms%2Fchembl%23%3E%0A%0ASELECT+%3Fpathway+%3Fchembluniprot+%3Fassay+WHERE+%7B%0A++%7B%0A++++SELECT+DISTINCT%0A++++++%3Fpathway%0A++++++iri%28%0A++++++++bif%3Aconcat%28%22http%3A%2F%2Fpurl.uniprot.org%2Funiprot%2F%22%2C%0A++++++++bif%3Aregexp_substr%28%27http%3A%2F%2Fidentifiers.org%2Funiprot%2F%28.*%29%27%2C%3Funiprot%2C+1%29%29%0A++++++%29+as+%3Fchembluniprot%0A++++WHERE+%7B%0A++++++VALUES+%3Ftype+%7B+wp%3AProtein+wp%3AGeneProduct+%7D%0A++++++%3Fs+a+%3Ftype+%3B%0A+++++++++wp%3AbdbUniprot+%3Funiprot+%3B%0A+++++++++dcterms%3AisPartOf+%3Fpathway+.%0A++++++%3Fpathway+a+wp%3APathway+.%0A++++%7D+LIMIT+50%0A++%7D%0A++SERVICE+%3Chttp%3A%2F%2Fwww.ebi.ac.uk%2Frdf%2Fservices%2Fchembl%2Fsparql%3E++%7B%0A++++%3Fassay+a+chembl%3AAssay+%3B+chembl%3AhasTarget%2Fchembl%3AhasTargetComponent%2Fchembl%3AtargetCmptXref+%3Fchembluniprot+.%0A++%7D%0A%7D%0A))

```sparqlPREFIX chembl: <http://rdf.ebi.ac.uk/terms/chembl#>
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

## References

1. <a name="citeref1"></a>Gaulton A, Hersey A, Nowotka M, Bento AP, Chambers J, Mendez D, et al. The ChEMBL database in 2017. NAR. 2017 Jan 4;45(D1):D945–54.  doi:[10.1093/NAR/GKW1074](https://doi.org/10.1093/NAR/GKW1074) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1093/NAR/GKW1074))
2. <a name="citeref2"></a>Jupp S, Malone J, Bolleman J, Brandizi M, Brandizi M, Davies M, et al. The EBI RDF platform: linked open data for the life sciences. Bioinformatics. 2014 May 1;30(9):1338–9.  doi:[10.1093/BIOINFORMATICS/BTT765](https://doi.org/10.1093/BIOINFORMATICS/BTT765) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1093/BIOINFORMATICS/BTT765))


