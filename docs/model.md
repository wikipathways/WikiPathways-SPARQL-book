# WikiPathways RDF Data Model

The WikiPathways RDF content consists of two parts, the GPMLRDF which contains a direct
RDF representation of the original <a name="tp1">GPML</a> in which the WikiPathways are stored, and the
WPRDF, which contains the interpretable biology stored in those pathways.

This section describes both bits of RDF, because not all information in the GPML
can be biologically interpreted and there are use case of the GPML at this moment too.

## Pathways

Of course, central to a <a name="tp2">pathway</a> database are the pathways. Pathways in the WPRDF
are of type `wp:Pathway`:

**SPARQL** [sparql/listAllPathways.rq](sparql/listAllPathways.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E+PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%28str%28%3Ftitle%29+as+%3Fpathway%29+%28str%28%3Flabel%29+as+%3Forganism%29WHERE+%7B+%3Fpw+a+wp%3APathway+%3B+++++dc%3Atitle+%3Ftitle+%3B+++++wp%3AorganismName+%3Flabel+.%7D))
```sparql
PREFIX dc:      <http://purl.org/dc/elements/1.1/> 
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>
SELECT DISTINCT (str(?title) as ?pathway) (str(?label) as ?organism)
WHERE {
 ?pw a wp:Pathway ;
     dc:title ?title ;
     wp:organismName ?label .
}
```

Resources of this type have the following RDF predicates:

**SPARQL** [sparql/listAllPathwayProperties.rq](sparql/listAllPathwayProperties.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%3FpredicateWHERE+%7B+%3Fpw+a+wp%3APathway+%3B+++++%3Fpredicate+%5B%5D+.%7D))
```sparql
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>
SELECT DISTINCT ?predicate
WHERE {
 ?pw a wp:Pathway ;
     ?predicate [] .
}
```

## Articles

Similarly, we can list all <a name="tp3">PubMed</a> identifiers with the pathways they occur in:

**SPARQL** [sparql/listAllPubMedIDs.rq](sparql/listAllPubMedIDs.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+wp%3A++++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3EPREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3ESELECT+DISTINCT+%3Fpathway+%3Fpubmed+WHERE+%7B++%3Fpubmed+a+++++++wp%3APublicationReference+%3B++++++++++dcterms%3AisPartOf+%3Fpathway%7D+ORDER+BY+%3Fpathway+LIMIT+500))
```sparql
PREFIX wp:      <http://vocabularies.wikipathways.org/wp#>
PREFIX dcterms: <http://purl.org/dc/terms/>
SELECT DISTINCT ?pathway ?pubmed WHERE {
  ?pubmed a       wp:PublicationReference ;
          dcterms:isPartOf ?pathway
} ORDER BY ?pathway LIMIT 500
```

Articles in the WPRDF are of type `wp:PublicationReference` and have the following predicates:

**SPARQL** [sparql/listAllArticleProperties.rq](sparql/listAllArticleProperties.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+wp%3A++++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3EPREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3ESELECT+DISTINCT+%3Fpredicate+WHERE+%7B++%3Fpubmed+a+wp%3APublicationReference+%3B++++++++++%3Fpredicate+%5B%5D+.%7D))
```sparql
PREFIX wp:      <http://vocabularies.wikipathways.org/wp#>
PREFIX dcterms: <http://purl.org/dc/terms/>
SELECT DISTINCT ?predicate WHERE {
  ?pubmed a wp:PublicationReference ;
          ?predicate [] .
}
```

## Genes, proteins, and metabolites

Pathways contains biological entities, genes, proteins, metabolite, complexes, and more.
Even pathways themselves can be entities in pathways. All entities are represented in the
data model as `wp:DataNode`s. Because there are so many, we will here list only 100 data nodes:

**SPARQL** [sparql/list100DataNodes.rq](sparql/list100DataNodes.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E+PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%3Fnode+%3FlabelWHERE+%7B+%3Fnode+a+wp%3ADataNode+%3B+++++rdfs%3Alabel+%3Flabel+.%7D+LIMIT+100))
```sparql
PREFIX dc:      <http://purl.org/dc/elements/1.1/> 
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>
SELECT DISTINCT ?node ?label
WHERE {
 ?node a wp:DataNode ;
     rdfs:label ?label .
} LIMIT 100
```

DataNodes have the following predicates:

**SPARQL** [sparql/listAllDataNodePredicates.rq](sparql/listAllDataNodePredicates.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%3FpredicateWHERE+%7B+%3Fpw+a+wp%3ADataNode+%3B+++++%3Fpredicate+%5B%5D+.%7D))
```sparql
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>
SELECT DISTINCT ?predicate
WHERE {
 ?pw a wp:DataNode ;
     ?predicate [] .
}
```

### Metabolites

Metabolites are typed a `wp:Metabolite`, a subclass of `wp:DataNode`. They do have all
predicates that data nodes have. If we just look at metabolites, this subset of data nodes
has these predicates:

**SPARQL** [sparql/listAllMetabolitePredicates.rq](sparql/listAllMetabolitePredicates.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%3FpredicateWHERE+%7B+%3Fpw+a+wp%3AMetabolite+%3B+++++%3Fpredicate+%5B%5D+.%7D))
```sparql
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>
SELECT DISTINCT ?predicate
WHERE {
 ?pw a wp:Metabolite ;
     ?predicate [] .
}
```

## References



