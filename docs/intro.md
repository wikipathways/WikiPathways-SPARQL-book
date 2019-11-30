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

Which gives as output:

<table>
  <tr>
    <td><b>dataset</b></td>
    <td><b>title</b></td>
    <td><b>date</b></td>
    <td><b>license</b></td>
  </tr>
  <tr>
    <td>http://data.wikipathways.org/20191110/rdf/</td>
    <td>WikiPathways RDF 20191110</td>
    <td>2019-11-10T10:49:50.340Z</td>
    <td>http://creativecommons.org/publicdomain/zero/1.0/</td>
  </tr>
</table>
