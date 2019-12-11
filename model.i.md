# WikiPathways RDF Data Model

The WikiPathways RDF content consists of two parts, the GPMLRDF which contains a direct
RDF representation of the original <topic>GPML</topic> in which the WikiPathways are stored, and the
WPRDF, which contains the interpretable biology stored in those pathways.

This section describes both bits of RDF, because not all information in the GPML
can be biologically interpreted and there are use case of the GPML at this moment too.

## Pathways

Of course, central to a <topic>pathway</topic> database are the pathways. Pathways in the WPRDF
are of type `wp:Pathway`:

<sparql>listAllPathways</sparql>

Resources of this type have the following RDF predicates:

<sparql>listAllPathwayProperties</sparql>

## Articles

Similarly, we can list all <topic>PubMed</topic> identifiers with the pathways they occur in:

<sparql>listAllPubMedIDs</sparql>

Articles in the WPRDF are of type `wp:PublicationReference` and have the following predicates:

<sparql>listAllArticleProperties</sparql>

## Genes, proteins, and metabolites

Pathways contains biological entities, genes, proteins, metabolite, complexes, and more.
Even pathways themselves can be entities in pathways. All entities are represented in the
data model as `wp:DataNode`s. Because there are so many, we will here list only 100 data nodes:

<sparql>list100DataNodes</sparql>

DataNodes have the following predicates:

<sparql>listAllDataNodePredicates</sparql>

### Metabolites

Metabolites are typed a `wp:Metabolite`, a subclass of `wp:DataNode`. They do have all
predicates that data nodes have. If we just look at metabolites, this subset of data nodes
has these predicates:

<sparql>listAllMetabolitePredicates</sparql>

## References

<references/>

