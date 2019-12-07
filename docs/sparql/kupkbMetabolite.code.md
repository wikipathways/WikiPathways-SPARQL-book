# kupkbMetabolite.rq
### SPARQL
```sparql
PREFIX wp: <http://vocabularies.wikipathways.org/wp#>
PREFIX dcterms: <http://purl.org/dc/terms/>
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
PREFIX kupkb: <http://www.kupkb.org/data/kupkb/>
PREFIX kupo: <http://www.kupkb.org/data/kupo/>
PREFIX obo: <http://purl.org/obo/owl/>
PREFIX bio2rdf: <http://bio2rdf.org/ns/bio2rdf:>

SELECT DISTINCT ?geneProduct ?label ?species ?metid ?symbol ?expression ?sample ?factor ?experiment WHERE {
  ?pathway dcterms:identifier "WP3604"^^xsd:string ;
           wp:organismName ?species .
  ?geneProduct a wp:Metabolite ;
      rdfs:label ?label ;
      dcterms:isPartOf ?pathway ;
      wp:bdbHmdb ?hmdbID .
  BIND (iri(concat("http://bio2rdf.org/hmdb:HMDB",SUBSTR(str(?hmdbID),35))) AS ?metid)
  SERVICE <http://sparql.kupkb.org/sparql> {
    {?metid bio2rdf:symbol ?symbol}
    UNION
    {?metid rdfs:label ?symbol}
    
    ?listmember kupkb:hasDatabaseRef ?metid ;
                kupkb:hasExpression ?expressionURI .  
    ?expressionURI rdfs:label ?expression .
    ?compoundList kupkb:hasMember ?listmember .    
    ?analysis kupkb:produces ?compoundList ;
              kupkb:annotatedWith ?annotation ;
              kupkb:analysisOf  ?experiment  .
    ?annotation kupkb:hasAnnotationRole kupo:KUPO_0300008 ;
                kupkb:bioMaterial ?analyteBioMaterial . 
    ?analyteBioMaterial rdfs:label ?sample . 
    OPTIONAL {
      ?annotation kupkb:hasDisease ?analyteDiseaseURI . 
      ?analyteDiseaseURI rdfs:label ?factor .
    } 
  }
}

```
[Execute](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3EPREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3EPREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3EPREFIX+rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3EPREFIX+owl%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3EPREFIX+xsd%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3EPREFIX+kupkb%3A+%3Chttp%3A%2F%2Fwww.kupkb.org%2Fdata%2Fkupkb%2F%3EPREFIX+kupo%3A+%3Chttp%3A%2F%2Fwww.kupkb.org%2Fdata%2Fkupo%2F%3EPREFIX+obo%3A+%3Chttp%3A%2F%2Fpurl.org%2Fobo%2Fowl%2F%3EPREFIX+bio2rdf%3A+%3Chttp%3A%2F%2Fbio2rdf.org%2Fns%2Fbio2rdf%3A%3ESELECT+DISTINCT+%3FgeneProduct+%3Flabel+%3Fspecies+%3Fmetid+%3Fsymbol+%3Fexpression+%3Fsample+%3Ffactor+%3Fexperiment+WHERE+%7B++%3Fpathway+dcterms%3Aidentifier+%22WP3604%22%5E%5Exsd%3Astring+%3B+++++++++++wp%3AorganismName+%3Fspecies+.++%3FgeneProduct+a+wp%3AMetabolite+%3B++++++rdfs%3Alabel+%3Flabel+%3B++++++dcterms%3AisPartOf+%3Fpathway+%3B++++++wp%3AbdbHmdb+%3FhmdbID+.++BIND+%28iri%28concat%28%22http%3A%2F%2Fbio2rdf.org%2Fhmdb%3AHMDB%22%2CSUBSTR%28str%28%3FhmdbID%29%2C35%29%29%29+AS+%3Fmetid%29++SERVICE+%3Chttp%3A%2F%2Fsparql.kupkb.org%2Fsparql%3E+%7B++++%7B%3Fmetid+bio2rdf%3Asymbol+%3Fsymbol%7D++++UNION++++%7B%3Fmetid+rdfs%3Alabel+%3Fsymbol%7D++++++++%3Flistmember+kupkb%3AhasDatabaseRef+%3Fmetid+%3B++++++++++++++++kupkb%3AhasExpression+%3FexpressionURI+.++++++%3FexpressionURI+rdfs%3Alabel+%3Fexpression+.++++%3FcompoundList+kupkb%3AhasMember+%3Flistmember+.++++++++%3Fanalysis+kupkb%3Aproduces+%3FcompoundList+%3B++++++++++++++kupkb%3AannotatedWith+%3Fannotation+%3B++++++++++++++kupkb%3AanalysisOf++%3Fexperiment++.++++%3Fannotation+kupkb%3AhasAnnotationRole+kupo%3AKUPO_0300008+%3B++++++++++++++++kupkb%3AbioMaterial+%3FanalyteBioMaterial+.+++++%3FanalyteBioMaterial+rdfs%3Alabel+%3Fsample+.+++++OPTIONAL+%7B++++++%3Fannotation+kupkb%3AhasDisease+%3FanalyteDiseaseURI+.+++++++%3FanalyteDiseaseURI+rdfs%3Alabel+%3Ffactor+.++++%7D+++%7D%7D)
### Output
<table>
  <tr>
    <td><b>geneProduct</b></td>
    <td><b>label</b></td>
    <td><b>species</b></td>
    <td><b>metid</b></td>
    <td><b>symbol</b></td>
    <td><b>expression</b></td>
    <td><b>sample</b></td>
    <td><b>factor</b></td>
    <td><b>experiment</b></td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>Ascorbic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>Ascorbate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>VItamin C</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>AsA</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>Ascorbic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>Ascorbate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>VItamin C</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000044</td>
    <td>AsA</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00044</td>
    <td>Ascorbic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000073</td>
    <td>Dopamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00073</td>
    <td>Dopamine</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000210</td>
    <td>Pantothenic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00210</td>
    <td>Pantothenic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000210</td>
    <td>Pantothenic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00210</td>
    <td>Pantothenic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000133</td>
    <td>Guanosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00133</td>
    <td>Guanosine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000172</td>
    <td>L-Isoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00172</td>
    <td>L-Isoleucine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000211</td>
    <td>Myoinositol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00211</td>
    <td>Myoinositol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000211</td>
    <td>Myoinositol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00211</td>
    <td>Myoinositol</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000211</td>
    <td>Myoinositol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00211</td>
    <td>Myoinositol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_tissue_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000510</td>
    <td>Aminoadipic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00510</td>
    <td>Aminoadipic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000661</td>
    <td>Glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00661</td>
    <td>Glutaric acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000661</td>
    <td>Glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00661</td>
    <td>Glutaric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000661</td>
    <td>Glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00661</td>
    <td>Glutaric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000661</td>
    <td>Glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00661</td>
    <td>Glutaric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/taylor-pkd-mouse-metabo_26days_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000661</td>
    <td>Glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00661</td>
    <td>Glutaric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001514</td>
    <td>Glucosamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01514</td>
    <td>Glucosamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001514</td>
    <td>Glucosamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01514</td>
    <td>Glucosamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001514</td>
    <td>Glucosamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01514</td>
    <td>Glucosamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001514</td>
    <td>Glucosamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01514</td>
    <td>Glucosamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001514</td>
    <td>Glucosamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01514</td>
    <td>Glucosamine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001514</td>
    <td>Glucosamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01514</td>
    <td>Glucosamine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000014</td>
    <td>Deoxycytidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00014</td>
    <td>Deoxycytidine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000034</td>
    <td>Adenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00034</td>
    <td>Adenine</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000034</td>
    <td>Adenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00034</td>
    <td>Adenine</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000034</td>
    <td>Adenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00034</td>
    <td>Adenine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000034</td>
    <td>Adenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00034</td>
    <td>Adenine</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000043</td>
    <td>Betaine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00043</td>
    <td>Betaine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000045</td>
    <td>AMP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00045</td>
    <td>Adenosine monophosphate</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000045</td>
    <td>Adenosine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00045</td>
    <td>Adenosine monophosphate</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000050</td>
    <td>Adenosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00050</td>
    <td>Adenosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000050</td>
    <td>Adenosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00050</td>
    <td>Adenosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000050</td>
    <td>Adenosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00050</td>
    <td>Adenosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000050</td>
    <td>Adenosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00050</td>
    <td>Adenosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000050</td>
    <td>Adenosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00050</td>
    <td>Adenosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000050</td>
    <td>Adenosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00050</td>
    <td>Adenosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>Cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000067</td>
    <td>cholesterol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00067</td>
    <td>Cholesterol</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000089</td>
    <td>Cytidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00089</td>
    <td>Cytidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000089</td>
    <td>Cytidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00089</td>
    <td>Cytidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000089</td>
    <td>Cytidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00089</td>
    <td>Cytidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000089</td>
    <td>Cytidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00089</td>
    <td>Cytidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000089</td>
    <td>Cytidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00089</td>
    <td>Cytidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000089</td>
    <td>Cytidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00089</td>
    <td>Cytidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000092</td>
    <td>Dimethylglycine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00092</td>
    <td>Dimethylglycine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000092</td>
    <td>Dimethylglycine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00092</td>
    <td>Dimethylglycine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000092</td>
    <td>Dimethylglycine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00092</td>
    <td>Dimethylglycine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000097</td>
    <td>Choline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00097</td>
    <td>Choline</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>D-Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>Glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLU</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>GLUe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000122</td>
    <td>glucose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00122</td>
    <td>D-Glucose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000123</td>
    <td>Glycine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00123</td>
    <td>Glycine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000123</td>
    <td>glycine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00123</td>
    <td>Glycine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000123</td>
    <td>Glycine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00123</td>
    <td>Glycine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000123</td>
    <td>glycine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00123</td>
    <td>Glycine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000126</td>
    <td>Glycerol 3-phosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00126</td>
    <td>Glycerol 3-phosphate</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000126</td>
    <td>Glycerol-3-Phosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00126</td>
    <td>Glycerol 3-phosphate</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000126</td>
    <td>Glycerol-3-P</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00126</td>
    <td>Glycerol 3-phosphate</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000126</td>
    <td>L-glycerol-3-phosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00126</td>
    <td>Glycerol 3-phosphate</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000126</td>
    <td>Glycerol 3 phosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00126</td>
    <td>Glycerol 3-phosphate</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>Glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>Glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>Glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>Glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000131</td>
    <td>glycerol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00131</td>
    <td>Glycerol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000134</td>
    <td>Fumarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00134</td>
    <td>Fumaric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000134</td>
    <td>fumarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00134</td>
    <td>Fumaric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000134</td>
    <td>Fumaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00134</td>
    <td>Fumaric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>Glutamate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>glutamate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>L-Glutamic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>Glutamic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>L-Glutamic  acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>Glutamate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>glutamate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>L-Glutamic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>Glutamic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>L-Glutamic  acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>Glutamate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>glutamate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>L-Glutamic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>Glutamic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000148</td>
    <td>L-Glutamic  acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00148</td>
    <td>L-Glutamic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000157</td>
    <td>Hypoxanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00157</td>
    <td>Hypoxanthine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000158</td>
    <td>L-Tyrosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00158</td>
    <td>L-Tyrosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Up</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Up</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000159</td>
    <td>L-Phenylalanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00159</td>
    <td>L-Phenylalanine</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000161</td>
    <td>L-Alanine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00161</td>
    <td>L-Alanine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>L-Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>L-Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>L-Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>L-Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>L-Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000162</td>
    <td>Proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00162</td>
    <td>L-Proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000163</td>
    <td>D-Maltose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00163</td>
    <td>D-Maltose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000163</td>
    <td>Maltose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00163</td>
    <td>D-Maltose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000167</td>
    <td>L-Threonine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00167</td>
    <td>L-Threonine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000168</td>
    <td>L-Asparagine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00168</td>
    <td>L-Asparagine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>D-Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000169</td>
    <td>Mannose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00169</td>
    <td>D-Mannose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000177</td>
    <td>L-Histidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00177</td>
    <td>L-Histidine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000182</td>
    <td>L-Lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00182</td>
    <td>L-Lysine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000186</td>
    <td>Alpha-Lactose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00186</td>
    <td>Alpha-Lactose</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000186</td>
    <td>Alpha-Lactose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00186</td>
    <td>Alpha-Lactose</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000187</td>
    <td>L-Serine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00187</td>
    <td>L-Serine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>L-Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>L-Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/akiyoshi_hirayama_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>L-Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/akiyoshi_hirayama_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/akiyoshi_hirayama_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>L-Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000191</td>
    <td>Aspartic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00191</td>
    <td>L-Aspartic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-oxoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>alpha-ketoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>Oxoglutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-Oxo-glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-oxoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>alpha-ketoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>Oxoglutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-Oxo-glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-oxoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>alpha-ketoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>Oxoglutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-Oxo-glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-oxoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>alpha-ketoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>Oxoglutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-Oxo-glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-oxoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>alpha-ketoglutarate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>Oxoglutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000208</td>
    <td>2-Oxo-glutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00208</td>
    <td>Oxoglutaric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000214</td>
    <td>Ornithine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00214</td>
    <td>Ornithine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000214</td>
    <td>Ornithine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00214</td>
    <td>Ornithine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000214</td>
    <td>Ornithine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00214</td>
    <td>Ornithine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000214</td>
    <td>Ornithine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00214</td>
    <td>Ornithine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000214</td>
    <td>Ornithine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00214</td>
    <td>Ornithine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000226</td>
    <td>Orotic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00226</td>
    <td>Orotic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000226</td>
    <td>Orotate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00226</td>
    <td>Orotic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000226</td>
    <td>Orotic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00226</td>
    <td>Orotic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/taylor-pkd-mouse-metabo_45days_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000226</td>
    <td>Orotate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00226</td>
    <td>Orotic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/taylor-pkd-mouse-metabo_45days_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>Pyruvate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>PYR</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>Pyruvate from Glycolysis</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>Pyruvic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>Pyruvate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>PYR</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>Pyruvate from Glycolysis</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000243</td>
    <td>Pyruvic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00243</td>
    <td>Pyruvic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000252</td>
    <td>Sphingosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00252</td>
    <td>Sphingosine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_lc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_tissue_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_tissue_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_tissue_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>succinate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000254</td>
    <td>Succinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00254</td>
    <td>Succinic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000258</td>
    <td>Sucrose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00258</td>
    <td>Sucrose</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000259</td>
    <td>Serotonin</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00259</td>
    <td>Serotonin</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000259</td>
    <td>5-HT</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00259</td>
    <td>Serotonin</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000273</td>
    <td>Thymidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00273</td>
    <td>Thymidine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000289</td>
    <td>Uric Acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00289</td>
    <td>Uric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000289</td>
    <td>Uric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00289</td>
    <td>Uric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000289</td>
    <td>Uric Acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00289</td>
    <td>Uric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000289</td>
    <td>Uric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00289</td>
    <td>Uric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000292</td>
    <td>Xanthine monophosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00292</td>
    <td>Xanthine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000294</td>
    <td>Urea</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00294</td>
    <td>Urea</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000296</td>
    <td>Uridine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00296</td>
    <td>Uridine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000296</td>
    <td>Uridine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00296</td>
    <td>Uridine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000296</td>
    <td>Uridine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00296</td>
    <td>Uridine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000296</td>
    <td>Uridine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00296</td>
    <td>Uridine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000296</td>
    <td>Uridine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00296</td>
    <td>Uridine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000296</td>
    <td>Uridine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00296</td>
    <td>Uridine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000296</td>
    <td>Uridine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00296</td>
    <td>Uridine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000462</td>
    <td>Allantoin</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00462</td>
    <td>Allantoin</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000462</td>
    <td>Allantoin</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00462</td>
    <td>Allantoin</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000462</td>
    <td>Allantoin</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00462</td>
    <td>Allantoin</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000462</td>
    <td>Allantoin</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00462</td>
    <td>Allantoin</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000462</td>
    <td>Allantoin</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00462</td>
    <td>Allantoin</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000462</td>
    <td>Allantoin</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00462</td>
    <td>Allantoin</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000517</td>
    <td>L-Arginine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00517</td>
    <td>L-Arginine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>L-Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>L-Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>L-Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>L-Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000574</td>
    <td>L-Cysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00574</td>
    <td>L-Cysteine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000630</td>
    <td>Cytosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00630</td>
    <td>Cytosine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000630</td>
    <td>Cytosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00630</td>
    <td>Cytosine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000630</td>
    <td>Cytosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00630</td>
    <td>Cytosine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000641</td>
    <td>L-Glutamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00641</td>
    <td>L-Glutamine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000660</td>
    <td>D-Fructose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00660</td>
    <td>D-Fructose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000660</td>
    <td>Fructose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00660</td>
    <td>D-Fructose</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000660</td>
    <td>D-Fructose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00660</td>
    <td>D-Fructose</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000660</td>
    <td>Fructose</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00660</td>
    <td>D-Fructose</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000684</td>
    <td>L-Kynurenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00684</td>
    <td>L-Kynurenine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000684</td>
    <td>Kynurenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00684</td>
    <td>L-Kynurenine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000684</td>
    <td>L-Kynurenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00684</td>
    <td>L-Kynurenine</td>
    <td>Up</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/akiyoshi_hirayama_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000684</td>
    <td>Kynurenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00684</td>
    <td>L-Kynurenine</td>
    <td>Up</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/akiyoshi_hirayama_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000684</td>
    <td>L-Kynurenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00684</td>
    <td>L-Kynurenine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000684</td>
    <td>Kynurenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00684</td>
    <td>L-Kynurenine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/jie_zhang_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/jie_zhang_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000687</td>
    <td>L-Leucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00687</td>
    <td>L-Leucine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>L-Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000696</td>
    <td>Methionine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00696</td>
    <td>L-Methionine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000715</td>
    <td>Kynurenic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00715</td>
    <td>Kynurenic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000715</td>
    <td>Kynurenic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00715</td>
    <td>Kynurenic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000742</td>
    <td>Homocysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00742</td>
    <td>Homocysteine</td>
    <td>Up</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser10wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>L-Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000883</td>
    <td>Valine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00883</td>
    <td>L-Valine</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Up</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/akiyoshi_hirayama_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000904</td>
    <td>Citrulline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00904</td>
    <td>Citrulline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Down</td>
    <td>serum</td>
    <td>acute kidney failure</td>
    <td>kupkb:experiment/jinchun_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>Tryptophan</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>L-Tryptophan (TRP)</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000929</td>
    <td>TRP</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00929</td>
    <td>L-Tryptophan</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000939</td>
    <td>AdoHcy</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00939</td>
    <td>S-Adenosylhomocysteine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000939</td>
    <td>S-Adenosylhomocysteine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00939</td>
    <td>S-Adenosylhomocysteine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001257</td>
    <td>Spermidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01257</td>
    <td>Spermidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001257</td>
    <td>Spermidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01257</td>
    <td>Spermidine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001257</td>
    <td>Spermidine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01257</td>
    <td>Spermidine</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-methyl-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-MTHF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5,10-METHYL-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-methyl-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-MTHF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5,10-METHYL-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-methyl-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-MTHF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5,10-METHYL-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-methyl-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-MTHF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5,10-METHYL-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-methyl-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-MTHF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5,10-METHYL-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-methyl-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-MTHF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5,10-METHYL-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-methyl-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-MTHF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001396</td>
    <td>5,10-METHYL-THF</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01396</td>
    <td>5-Methyltetrahydrofolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001414</td>
    <td>Putrescine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01414</td>
    <td>Putrescine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001414</td>
    <td>Putrescine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01414</td>
    <td>Putrescine</td>
    <td>Down</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001414</td>
    <td>Putrescine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01414</td>
    <td>Putrescine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0003178</td>
    <td>Heme</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB03178</td>
    <td>Heme</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0006055</td>
    <td>4-Hydroxy-L-proline</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB06055</td>
    <td>4-Hydroxy-L-proline</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0011631</td>
    <td>L-3-Hydroxykynurenine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB11631</td>
    <td>L-3-Hydroxykynurenine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000036</td>
    <td>Taurocholic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00036</td>
    <td>Taurocholic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>Aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-Aconitic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>Aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-Aconitic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>Aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-Aconitic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>Aconitate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000072</td>
    <td>cis-Aconitic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00072</td>
    <td>cis-Aconitic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>serum</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_ser8wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_lc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_lc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_lc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>citrate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000094</td>
    <td>Citric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00094</td>
    <td>Citric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000138</td>
    <td>Glycocholic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00138</td>
    <td>Glycocholic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000138</td>
    <td>GCA</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00138</td>
    <td>Glycocholic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>Lactate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>LAC</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>LACe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>L-Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>Lactate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>LAC</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>LACe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>L-Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>Lactate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>LAC</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>LACe</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>L-Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000190</td>
    <td>Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00190</td>
    <td>L-Lactic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000232</td>
    <td>Quinolinic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00232</td>
    <td>Quinolinic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000232</td>
    <td>Quinolinic Acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00232</td>
    <td>Quinolinic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000251</td>
    <td>Taurine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00251</td>
    <td>Taurine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>urinary tract disease</td>
    <td>kupkb:experiment/ekaterina_nevedomskaya_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000251</td>
    <td>Taurine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00251</td>
    <td>Taurine</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_tissue_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000606</td>
    <td>D-2-Hydroxyglutaric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00606</td>
    <td>D-2-Hydroxyglutaric acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/taylor-pkd-mouse-metabo_45days_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000763</td>
    <td>OH-indoleacetate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00763</td>
    <td>5-Hydroxyindoleacetic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000763</td>
    <td>5HIAA</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00763</td>
    <td>5-Hydroxyindoleacetic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000763</td>
    <td>5-HIAA</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00763</td>
    <td>5-Hydroxyindoleacetic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000763</td>
    <td>5-Hydroxyindoleacetic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00763</td>
    <td>5-Hydroxyindoleacetic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000965</td>
    <td>Hypotaurine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00965</td>
    <td>Hypotaurine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0002917</td>
    <td>D-Xylitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB02917</td>
    <td>D-Xylitol</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000139</td>
    <td>Glyceric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00139</td>
    <td>Glyceric acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000139</td>
    <td>Glyceric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00139</td>
    <td>Glyceric acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000139</td>
    <td>Glyceric acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00139</td>
    <td>Glyceric acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>membranous glomerulonephritis</td>
    <td>kupkb:experiment/xianfu_gao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000195</td>
    <td>Inosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00195</td>
    <td>Inosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000195</td>
    <td>Inosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00195</td>
    <td>Inosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_genta_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000195</td>
    <td>Inosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00195</td>
    <td>Inosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_tobra_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000195</td>
    <td>Inosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00195</td>
    <td>Inosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000195</td>
    <td>Inosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00195</td>
    <td>Inosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000195</td>
    <td>Inosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00195</td>
    <td>Inosine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000195</td>
    <td>Inosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00195</td>
    <td>Inosine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Chronic renal failure model</td>
    <td>kupkb:experiment/ying_yong_zhao_ckd_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000197</td>
    <td>Indoleacetate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00197</td>
    <td>Indoleacetic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000197</td>
    <td>Indoleacetic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00197</td>
    <td>Indoleacetic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000197</td>
    <td>Indoleacetate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00197</td>
    <td>Indoleacetic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000197</td>
    <td>Indoleacetic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00197</td>
    <td>Indoleacetic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>D-Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_tissu_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>D-Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>D-Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis28k_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000247</td>
    <td>D-Sorbitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00247</td>
    <td>Sorbitol</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001123</td>
    <td>2-Aminobenzoic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01123</td>
    <td>2-Aminobenzoic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000026</td>
    <td>Ureidopropionic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00026</td>
    <td>Ureidopropionic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000101</td>
    <td>Deoxyadenosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00101</td>
    <td>Deoxyadenosine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000115</td>
    <td>Glycolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00115</td>
    <td>Glycolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000115</td>
    <td>Glycolate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00115</td>
    <td>Glycolic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000115</td>
    <td>Glycolic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00115</td>
    <td>Glycolic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>type 1 diabetic nephropathy</td>
    <td>kupkb:experiment/van_der_kloet_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000115</td>
    <td>Glycolate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00115</td>
    <td>Glycolic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>type 1 diabetic nephropathy</td>
    <td>kupkb:experiment/van_der_kloet_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000127</td>
    <td>D-Glucuronic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00127</td>
    <td>D-Glucuronic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000127</td>
    <td>D-Glucuronic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00127</td>
    <td>D-Glucuronic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000130</td>
    <td>Homogentisic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00130</td>
    <td>Homogentisic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000206</td>
    <td>N6-Acetyl-L-lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00206</td>
    <td>N6-Acetyl-L-lysine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000206</td>
    <td>N6-Acetyl-L-lysine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00206</td>
    <td>N6-Acetyl-L-lysine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_lc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000213</td>
    <td>Myo-inositol 1-phosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00213</td>
    <td>Myo-inositol 1-phosphate</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Cisplatin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_cis5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000213</td>
    <td>Myo-inositol 1-phosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00213</td>
    <td>Myo-inositol 1-phosphate</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen28u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000213</td>
    <td>Myo-inositol 1-phosphate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00213</td>
    <td>Myo-inositol 1-phosphate</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000291</td>
    <td>Vanillylmandelic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00291</td>
    <td>Vanillylmandelic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000299</td>
    <td>Xanthosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00299</td>
    <td>Xanthosine</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000490</td>
    <td>Etiocholanolone</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00490</td>
    <td>Etiocholanolone</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_lc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000625</td>
    <td>Gluconic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00625</td>
    <td>Gluconic acid</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000625</td>
    <td>Gluconic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00625</td>
    <td>Gluconic acid</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000625</td>
    <td>Gluconic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00625</td>
    <td>Gluconic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000625</td>
    <td>Gluconic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00625</td>
    <td>Gluconic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/kurt_boudonck_gen5u_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000625</td>
    <td>Gluconic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00625</td>
    <td>Gluconic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000625</td>
    <td>Gluconic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00625</td>
    <td>Gluconic acid</td>
    <td>Down</td>
    <td>urine</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/taylor-pkd-mouse-metabo_45days_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000625</td>
    <td>Gluconic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00625</td>
    <td>Gluconic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 1 diabetic nephropathy</td>
    <td>kupkb:experiment/van_der_kloet_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000691</td>
    <td>Malonic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00691</td>
    <td>Malonic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000691</td>
    <td>Malonic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00691</td>
    <td>Malonic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>end stage renal failure</td>
    <td>kupkb:experiment/eugene_rhee_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000695</td>
    <td>Ketoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00695</td>
    <td>Ketoleucine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000695</td>
    <td>Ketoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00695</td>
    <td>Ketoleucine</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000695</td>
    <td>Ketoleucine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00695</td>
    <td>Ketoleucine</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001209</td>
    <td>Allantoic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01209</td>
    <td>Allantoic acid</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001209</td>
    <td>Allantoic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01209</td>
    <td>Allantoic acid</td>
    <td>Up</td>
    <td>urine</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/taylor-pkd-mouse-metabo_45days_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001311</td>
    <td>D-Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01311</td>
    <td>D-Lactic acid</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_tissue_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001311</td>
    <td>D-Lactic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01311</td>
    <td>D-Lactic acid</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001851</td>
    <td>L-Arabitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01851</td>
    <td>L-Arabitol</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0001851</td>
    <td>L-Arabitol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB01851</td>
    <td>L-Arabitol</td>
    <td>Up</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0002329</td>
    <td>Oxalic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB02329</td>
    <td>Oxalic acid</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_gc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0002329</td>
    <td>Oxalic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB02329</td>
    <td>Oxalic acid</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy associated with uninephrectomy</td>
    <td>kupkb:experiment/tie_zhao_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000064</td>
    <td>Creatine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00064</td>
    <td>Creatine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Gentamicin-induced nephropathy model</td>
    <td>kupkb:experiment/max_sieber_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000064</td>
    <td>Creatine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00064</td>
    <td>Creatine</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_tissue_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000064</td>
    <td>Creatine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00064</td>
    <td>Creatine</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>Streptozotocin-induced rat model of diabetic nephropathy</td>
    <td>kupkb:experiment/zhao_lin_urine_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000128</td>
    <td>Guanidinoacetate</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00128</td>
    <td>Guanidoacetic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000128</td>
    <td>Guanidoacetic acid</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00128</td>
    <td>Guanidoacetic acid</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/toyahara_ckd_human_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000149</td>
    <td>Ethanolamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00149</td>
    <td>Ethanolamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/noudonck_nephrotox_urine_cispla_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000149</td>
    <td>Ethanolamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00149</td>
    <td>Ethanolamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_cispla_28_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000149</td>
    <td>Ethanolamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00149</td>
    <td>Ethanolamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_genta_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000149</td>
    <td>Ethanolamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00149</td>
    <td>Ethanolamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000149</td>
    <td>Ethanolamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00149</td>
    <td>Ethanolamine</td>
    <td>Up</td>
    <td>urine</td>
    <td>Nephrotoxic model</td>
    <td>kupkb:experiment/boudonck_nephrotox_urine_tobra_5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000149</td>
    <td>Ethanolamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00149</td>
    <td>Ethanolamine</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine12wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000149</td>
    <td>Ethanolamine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00149</td>
    <td>Ethanolamine</td>
    <td>Down</td>
    <td>bladder urine</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>kupkb:experiment/mengjie_lie_urine16wk_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000271</td>
    <td>Sarcosine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00271</td>
    <td>Sarcosine</td>
    <td>Up</td>
    <td>bladder urine</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/ng_d_p_gc_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0002005</td>
    <td>Methionine sulfoxide</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB02005</td>
    <td>Methionine sulfoxide</td>
    <td>Up</td>
    <td>plasma</td>
    <td>Polycystic kidney disease model</td>
    <td>kupkb:experiment/toyahara_apkd_rat_metabo_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000063</td>
    <td>Cortisol</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00063</td>
    <td>Cortisol</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0000269</td>
    <td>Sphinganine</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB00269</td>
    <td>Sphinganine</td>
    <td>Down</td>
    <td>serum</td>
    <td>type 2 diabetic nephropathy</td>
    <td>kupkb:experiment/jie_zhang_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/hmdb/HMDB0002802</td>
    <td>Cortisone</td>
    <td>Homo sapiens</td>
    <td>http://bio2rdf.org/hmdb:HMDB02802</td>
    <td>Cortisone</td>
    <td>Down</td>
    <td>plasma</td>
    <td>chronic kidney failure</td>
    <td>kupkb:experiment/vallabh_shah_assay</td>
  </tr>
</table>
## Code examples
### curl
```shell
curl -o kupkbMetabolite.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/kupkbMetabolite.rq
curl -H "Accept: " -G http://sparql.wikipathways.org/ --data-urlencode query@kupkbMetabolite.rq
```
