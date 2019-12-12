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

## Statistics

The give some idea of the content of the SPARQL endpoint, this section gives some overall
statistics.

### Number of pathways per species

We can list the number of pathways for each species available in WikiPathways
with this query:

<sparql>pathwayCountBySpecies</sparql>

It shows us that there is a strong bias towards human pathways:

<out>pathwayCountBySpecies</out>


### Number of metabolites per species

Counting metabolites is tricky, as metabolites that are biologically the same (e.g. different
charge startes) can have different identifiers. A further complications is that not all metabolites
in WikiPathways always have stereochemistry defined, for example because it is biologically
obvious, as for amino acids. But we can count the number of Wikidata identifiers
to get a reasonable estimate:

<sparql>metaboliteCountBySpecies</sparql>

This tells us:

<out>metaboliteCountBySpecies</out>


## References

<references/>

