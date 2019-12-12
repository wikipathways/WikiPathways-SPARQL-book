# Federated Queries

One of the features of SPARQL is that you can run a query over more
than one SPARQL endpoint. Here we report a number of such <topic>federated SPARQL</topic>
queries.

## ChEMBL

[<topic>ChEMBL</topic>](https://www.ebi.ac.uk/chembl/) is one of the databases which also have a
[SPARQL endpoint](https://www.ebi.ac.uk/rdf/services/sparql) [<cite>Q28584450</cite>,<cite>Q28305672</cite>].
The database contains many biological activities of chemical compounds against many (protein)
targets, as measured with assays.

### Bioassays related to a pathway

We can list all <topic>assays</topic> for a certain pathway with the following federated query:

<sparql>allChEMBLAssays</sparql>

## References

<references/>

