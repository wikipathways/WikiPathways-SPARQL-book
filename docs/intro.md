# Introduction

WikiPathways is a biological pathway database and describes the interactions between
biochemical entities in biological processes [<a href="#citeref1">1</a>,<a href="#citeref2">2</a>,<a href="#citeref3">3</a>,<a href="#citeref4">4</a>].
It can be downloaded and used in various formats, one of which is the Resource
Description Framework (RDF) [<a href="#citeref5">5</a>].

The WikiPathways SPARQL <a name="tp1">endpoint</a> can be found at [http://sparql.wikipathways.org/](http://sparql.wikipathways.org/).
SPARQL allows you to query much of the content of the the WikiPathways data in
a machine readable way, which has been used, for example, in the Open&nbsp;PHACTS project
[<a href="#citeref6">6</a>,<a href="#citeref7">7</a>].

This book discusses how SPARQL can be used to extract information, using numerous example
queries, like the following to get metadata about the data loaded into the SPARQL endpoint.

## Metadata queries

The following query provides some information about what is currently loaded
in the public SPARQL endpoint at [http://sparql.wikipathways.org](http://sparql.wikipathways.org):

**SPARQL** [sparql/metadata.rq](sparql/metadata.code.html) ([run](http://sparql.wikipathways.org/?query=PREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3EPREFIX+void%3A++++%3Chttp%3A%2F%2Frdfs.org%2Fns%2Fvoid%23%3EPREFIX+pav%3A+++++%3Chttp%3A%2F%2Fpurl.org%2Fpav%2F%3Eselect+distinct+%3Fdataset+%28str%28%3FtitleLit%29+as+%3Ftitle%29+%3Fdate+%3Flicense+where+%7B++%3Fdataset+a+void%3ADataset+%3B++++dcterms%3Atitle+%3FtitleLit+%3B++++dcterms%3Alicense+%3Flicense+%3B++++pav%3AcreatedOn+%3Fdate+.%7D))
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

## WikiPathways RDF Data Model

The WikiPathways RDF content consists of two parts, the GPMLRDF which contains a direct
RDF representation of the original GPML in which the WikiPathways are stored, and the
WPRDF, which contains the interpretable biology stored in those pathways.

This section describes both bits of RDF, because not all information in the GPML
can be biologically interpreted and there are use case of the GPML at this moment too.

## References

1. <a name="citeref1"></a>Pico AR, Kelder T, van Iersel MP, Hanspers K, Conklin BR, Evelo CT. WikiPathways: pathway editing for the people. PLoS Biol. 2008 Jul 22;6(7):e184.  doi:[10.1371/JOURNAL.PBIO.0060184](https://doi.org/10.1371/JOURNAL.PBIO.0060184) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1371/JOURNAL.PBIO.0060184))
2. <a name="citeref2"></a>Kelder T, van Iersel MP, Hanspers K, Summer-Kutmon M, Conklin BR, Evelo CT, et al. WikiPathways: building research communities on biological pathways. NAR. 2012 Jan;40(Database issue):D1301-7.  doi:[10.1093/NAR/GKR1074](https://doi.org/10.1093/NAR/GKR1074) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1093/NAR/GKR1074))
3. <a name="citeref3"></a>Summer-Kutmon M, Riutta A, Nunes N, Hanspers K, Willighagen E, Bohler A, et al. WikiPathways: capturing the full diversity of pathway knowledge. NAR. 2016 Jan 4;44(D1):D488-94.  doi:[10.1093/NAR/GKV1024](https://doi.org/10.1093/NAR/GKV1024) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1093/NAR/GKV1024))
4. <a name="citeref4"></a>Slenter DN, Slenter DN, Kutmon M, Hanspers K, Hanspers K, Riutta A, et al. WikiPathways: a multifaceted pathway database bridging metabolomics to other omics research. NAR. 2018 Jan 4;46(D1):D661–D667.  doi:[10.1093/NAR/GKX1064](https://doi.org/10.1093/NAR/GKX1064) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1093/NAR/GKX1064))
5. <a name="citeref5"></a>Waagmeester A, Summer-Kutmon M, Riutta A, Miller R, Willighagen E, Evelo CT, et al. Using the Semantic Web for Rapid Integration of WikiPathways with Other Biological Online Data Resources. PLoS Comput Biol. 2016 Jun;12(6):e1004989.  doi:[10.1371/JOURNAL.PCBI.1004989](https://doi.org/10.1371/JOURNAL.PCBI.1004989) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1371/JOURNAL.PCBI.1004989))
6. <a name="citeref6"></a>Williams AJ, Harland L, Groth P, Pettifer S, Chichester C, Willighagen E, et al. Open PHACTS: semantic interoperability for drug discovery. DDT [Internet]. 2012 Nov;17(21–22):1188–98. Available from: http://www.openphacts.org/documents/registered/publications/Williams_Harland_Groth_et%20al_Open%20PHACTS_Semantic%20interoperability%20for%20drug%20discovery_Drug%20Discovery%20Today_06%20June%202012.pdf doi:[10.1016/J.DRUDIS.2012.05.016](https://doi.org/10.1016/J.DRUDIS.2012.05.016) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.1016/J.DRUDIS.2012.05.016))
7. <a name="citeref7"></a>Miller RA, Woollard P, Willighagen EL, Digles D, Kutmon M, Loizou A, et al. Explicit interaction information from WikiPathways in RDF facilitates drug discovery in the Open PHACTS Discovery Platform. Vol. 7, F1000Research. 2018. p. 75.  doi:[10.12688/F1000RESEARCH.13197.1](https://doi.org/10.12688/F1000RESEARCH.13197.1) ([Scholia](https://tools.wmflabs.org/scholia/doi/10.12688/F1000RESEARCH.13197.1))


