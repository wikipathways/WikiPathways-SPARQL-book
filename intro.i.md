<section label="intro" level="#">Introduction</section>

WikiPathways is a biological pathway database and describes the interactions between
biochemical entities in biological processes [<cite>Q21092742</cite>,<cite>Q28090976</cite>,<cite>Q24082733</cite>,<cite>Q42896569</cite>].
It can be downloaded and used in various formats, one of which is the Resource
Description Framework (RDF) [<cite>Q26261238</cite>].

The WikiPathways SPARQL <topic>endpoint</topic> can be found at [http://sparql.wikipathways.org/](http://sparql.wikipathways.org/).
SPARQL allows you to query much of the content of the the WikiPathways data in
a machine readable way, which has been used, for example, in the Open&nbsp;PHACTS project
[<cite>Q27061937</cite>,<cite>Q54404976</cite>].

This book discusses how SPARQL can be used to extract information, using numerous example
queries, like the following to get metadata about the data loaded into the SPARQL endpoint.

## Metadata queries

The following query provides some information about what is currently loaded
in the public SPARQL endpoint at [http://sparql.wikipathways.org](http://sparql.wikipathways.org):

<sparql>metadata</sparql>

Which gives as output:

<out>metadata</out>

## WikiPathways RDF Data Model

The WikiPathways RDF content consists of two parts, the GPMLRDF which contains a direct
RDF representation of the original <topic>GPML</topic> in which the WikiPathways are stored, and the
WPRDF, which contains the interpretable biology stored in those pathways.

This section describes both bits of RDF, because not all information in the GPML
can be biologically interpreted and there are use case of the GPML at this moment too.

### Pathways

Of course, central to a <topic>pathway</topic> database are the pathways. Pathways in the WPRDF
are of type `wp:Pathway`:

<sparql>listAllPathways</sparql>

Resources of this type have the following RDF predicates:

<sparql>listAllPathwayProperties</sparql>

### Articles

Similarly, we can list all <topic>PubMed</topic> identifiers with the pathways they occur in:

<sparql>listAllPubMedIDs</sparql>

Articles in the WPRDF are of type `wp:PublicationReference` and have the following predicates:

<sparql>listAllArticleProperties</sparql>

### Genes, proteins, and metabolites

Pathways contains biological entities, genes, proteins, metabolite, complexes, and more.
Even pathways themselves can be entities in pathways. All entities are represented in the
data model as `wp:DataNode`s. Because there are so many, we will here list only 100 data nodes:

<sparql>list100DataNodes</sparql>

DataNodes have the following predicates:

<sparql>listAllDataNodePredicates</sparql>

## References

<references/>

