# Introduction

## Metadata queries

**SPARQL** [sparql/metadata.rq](sparql/metadata.code.html)
```sparql
PREFIX dcterms: <http://purl.org/dc/terms/>
PREFIX void:    <http://rdfs.org/ns/void#>
PREFIX pav:     <http://purl.org/pav/>
select distinct ?dataset (str(?titleLit) as ?title) ?date ?license where {
  ?dataset a void:Dataset ;
    dcterms:title ?titleLit ;
    dcterms:license ?license ;
    pav:createdOn ?date .
}
```
Output:
|----|----|----|----|
| dataset | title | date | license |
|----|----|----|----|
| http://data.wikipathways.org/20191110/rdf/ | WikiPathways RDF 20191110 | 2019-11-10T10:49:50.340Z | http://creativecommons.org/publicdomain/zero/1.0/  |
|----|----|----|----|

Which gives as output:

|----|----|----|----|
| dataset | title | date | license |
|----|----|----|----|
| http://data.wikipathways.org/20191110/rdf/ | WikiPathways RDF 20191110 | 2019-11-10T10:49:50.340Z | http://creativecommons.org/publicdomain/zero/1.0/  |
|----|----|----|----|
