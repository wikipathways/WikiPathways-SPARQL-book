# Federated Queries

One of the features of SPARQL is that you can run a query over more
than one SPARQL endpoint. Here we report a number of such <topic>federated SPARQL</topic>
queries.

## The Kidney & Urinary Pathway Knowledge Base

The <topic>Kidney and Urinary Pathway Knowledge Base</topic> (KUPKB) is a knowledge
base of assay data [<cite>Q21198687</cite>,<cite>Q28260266</cite>].

### Assays for genes in WP1560

The following query lists all assay data for genes in 
[wikipathways:WP1560](https://identifiers.org/wikipathways:WP1560):

<sparql>kupkbGene</sparql>

### Assays for metabolites in WP3604

And this variant for the previous query lists assay data for all
metabolites in [wikipathways:WP3604](https://identifiers.org/wikipathways:WP3604):

<sparql>kupkbMetabolite</sparql>

## ChEMBL

[<topic>ChEMBL</topic>](https://www.ebi.ac.uk/chembl/) is one of the databases which also have a
[SPARQL endpoint](https://www.ebi.ac.uk/rdf/services/sparql) [<cite>Q28584450</cite>,<cite>Q28305672</cite>].
The database contains many biological activities of chemical compounds against many (protein)
targets, as measured with assays.

### Bioassays related to a pathway

We can list all assays for a certain pathway with the following federated query:

<sparql>allChEMBLAssays</sparql>

## References

<references/>

