<link href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet">
# metadata.rq
### SPARQL
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
[Execute](http://sparql.wikipathways.org/?query=PREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3EPREFIX+void%3A++++%3Chttp%3A%2F%2Frdfs.org%2Fns%2Fvoid%23%3EPREFIX+pav%3A+++++%3Chttp%3A%2F%2Fpurl.org%2Fpav%2F%3Eselect+distinct+%3Fdataset+%28str%28%3FtitleLit%29+as+%3Ftitle%29+%3Fdate+%3Flicense+where+%7B++%3Fdataset+a+void%3ADataset+%3B++++dcterms%3Atitle+%3FtitleLit+%3B++++dcterms%3Alicense+%3Flicense+%3B++++pav%3AcreatedOn+%3Fdate+.%7D)
### Output
<table>
  <thead>
    <tr>
      <th>dataset</th>
      <th>title</th>
      <th>date</th>
      <th>license</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>http://data.wikipathways.org/20191110/rdf/</td>
      <td>WikiPathways RDF 20191110</td>
      <td>2019-11-10T10:49:50.340Z</td>
      <td>http://creativecommons.org/publicdomain/zero/1.0/</td>
    </tr>
  </tbody>
</table>

  <script src="https://code.jquery.com/jquery-1.12.1.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
    $('tbody').sortable();
  </script>
  
## Code examples
### curl
```shell
curl -o metadata.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/metadata.rq
curl -H "Accept: " -G http://sparql.wikipathways.org/ --data-urlencode query@metadata.rq
```
