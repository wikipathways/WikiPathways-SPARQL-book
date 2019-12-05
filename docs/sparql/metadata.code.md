# metadata.rq
**Source code:**
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
**Output:**
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
[Execute](http://sparql.wikipathways.org/?query=PREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3EPREFIX+void%3A++++%3Chttp%3A%2F%2Frdfs.org%2Fns%2Fvoid%23%3EPREFIX+pav%3A+++++%3Chttp%3A%2F%2Fpurl.org%2Fpav%2F%3Eselect+distinct+%3Fdataset+%28str%28%3FtitleLit%29+as+%3Ftitle%29+%3Fdate+%3Flicense+where+%7B++%3Fdataset+a+void%3ADataset+%3B++++dcterms%3Atitle+%3FtitleLit+%3B++++dcterms%3Alicense+%3Flicense+%3B++++pav%3AcreatedOn+%3Fdate+.%7D)
