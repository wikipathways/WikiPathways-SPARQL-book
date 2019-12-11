# kupkbGene.rq
**Code examples:** [curl](#curl)
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

SELECT DISTINCT ?geneProduct ?geneid ?genesymbol ?expression ?sample ?factor ?species ?experiment WHERE {
  ?pathway dcterms:identifier "WP1560"^^xsd:string ;
           wp:organismName ?species .
  ?geneProduct a wp:GeneProduct ;
      rdfs:label ?label ;
      dcterms:isPartOf ?pathway ;
      wp:bdbEntrezGene ?ncbiID .
  BIND (iri(concat("http://bio2rdf.org/geneid:",SUBSTR(str(?ncbiID),33))) AS ?geneid)
  SERVICE <http://sparql.kupkb.org/sparql> {
    {?geneid bio2rdf:symbol ?genesymbol}
    UNION
    {?geneid rdfs:label ?genesymbol}
    
    {?listmember kupkb:hasDatabaseRef ?geneid} 
    UNION              
    { ?geneid <http://bio2rdf.org/ns/uniprot:xProtein> ?uniprot .  
      ?listmember kupkb:hasDatabaseRef ?uniprot .
    }
    ?listmember kupkb:hasExpression ?expressionURI .  
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
[Execute](http://sparql.wikipathways.org/?query=PREFIX+wp%3A+%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3EPREFIX+dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3EPREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3EPREFIX+rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3EPREFIX+owl%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3EPREFIX+xsd%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3EPREFIX+kupkb%3A+%3Chttp%3A%2F%2Fwww.kupkb.org%2Fdata%2Fkupkb%2F%3EPREFIX+kupo%3A+%3Chttp%3A%2F%2Fwww.kupkb.org%2Fdata%2Fkupo%2F%3EPREFIX+obo%3A+%3Chttp%3A%2F%2Fpurl.org%2Fobo%2Fowl%2F%3EPREFIX+bio2rdf%3A+%3Chttp%3A%2F%2Fbio2rdf.org%2Fns%2Fbio2rdf%3A%3ESELECT+DISTINCT+%3FgeneProduct+%3Fgeneid+%3Fgenesymbol+%3Fexpression+%3Fsample+%3Ffactor+%3Fspecies+%3Fexperiment+WHERE+%7B++%3Fpathway+dcterms%3Aidentifier+%22WP1560%22%5E%5Exsd%3Astring+%3B+++++++++++wp%3AorganismName+%3Fspecies+.++%3FgeneProduct+a+wp%3AGeneProduct+%3B++++++rdfs%3Alabel+%3Flabel+%3B++++++dcterms%3AisPartOf+%3Fpathway+%3B++++++wp%3AbdbEntrezGene+%3FncbiID+.++BIND+%28iri%28concat%28%22http%3A%2F%2Fbio2rdf.org%2Fgeneid%3A%22%2CSUBSTR%28str%28%3FncbiID%29%2C33%29%29%29+AS+%3Fgeneid%29++SERVICE+%3Chttp%3A%2F%2Fsparql.kupkb.org%2Fsparql%3E+%7B++++%7B%3Fgeneid+bio2rdf%3Asymbol+%3Fgenesymbol%7D++++UNION++++%7B%3Fgeneid+rdfs%3Alabel+%3Fgenesymbol%7D++++++++%7B%3Flistmember+kupkb%3AhasDatabaseRef+%3Fgeneid%7D+++++UNION++++++++++++++++++%7B+%3Fgeneid+%3Chttp%3A%2F%2Fbio2rdf.org%2Fns%2Funiprot%3AxProtein%3E+%3Funiprot+.++++++++%3Flistmember+kupkb%3AhasDatabaseRef+%3Funiprot+.++++%7D++++%3Flistmember+kupkb%3AhasExpression+%3FexpressionURI+.++++++%3FexpressionURI+rdfs%3Alabel+%3Fexpression+.++++%3FcompoundList+kupkb%3AhasMember+%3Flistmember+.++++++++%3Fanalysis+kupkb%3Aproduces+%3FcompoundList+%3B++++++++++++++kupkb%3AannotatedWith+%3Fannotation+%3B++++++++++++++kupkb%3AanalysisOf++%3Fexperiment++.++++%3Fannotation+kupkb%3AhasAnnotationRole+kupo%3AKUPO_0300008+%3B++++++++++++++++kupkb%3AbioMaterial+%3FanalyteBioMaterial+.+++++%3FanalyteBioMaterial+rdfs%3Alabel+%3Fsample+.+++++OPTIONAL+%7B++++++%3Fannotation+kupkb%3AhasDisease+%3FanalyteDiseaseURI+.+++++++%3FanalyteDiseaseURI+rdfs%3Alabel+%3Ffactor+.++++%7D+++%7D%7D)
### Output
<table>
  <tr>
    <td><b>geneProduct</b></td>
    <td><b>geneid</b></td>
    <td><b>genesymbol</b></td>
    <td><b>expression</b></td>
    <td><b>sample</b></td>
    <td><b>factor</b></td>
    <td><b>species</b></td>
    <td><b>experiment</b></td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Down</td>
    <td>kidney collecting duct epithelial cell</td>
    <td>Vasopressine in vitro model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/khositseth_yu_collectingductvasopressinprotein_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107589</td>
    <td>http://bio2rdf.org/geneid:107589</td>
    <td>Mylk</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/107951</td>
    <td>http://bio2rdf.org/geneid:107951</td>
    <td>Cdk9</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/108058</td>
    <td>http://bio2rdf.org/geneid:108058</td>
    <td>Camk2d</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/110157</td>
    <td>http://bio2rdf.org/geneid:110157</td>
    <td>Raf1</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11606</td>
    <td>http://bio2rdf.org/geneid:11606</td>
    <td>Agt</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11651</td>
    <td>http://bio2rdf.org/geneid:11651</td>
    <td>Akt1</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11652</td>
    <td>http://bio2rdf.org/geneid:11652</td>
    <td>Akt2</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/11848</td>
    <td>http://bio2rdf.org/geneid:11848</td>
    <td>Rhoa</td>
    <td>Present</td>
    <td>glomerulus</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/s_tryggvason_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12313</td>
    <td>http://bio2rdf.org/geneid:12313</td>
    <td>Calm1</td>
    <td>Present</td>
    <td>glomerulus</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/s_tryggvason_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12572</td>
    <td>http://bio2rdf.org/geneid:12572</td>
    <td>Cdk7</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12675</td>
    <td>http://bio2rdf.org/geneid:12675</td>
    <td>Chuk</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12700</td>
    <td>http://bio2rdf.org/geneid:12700</td>
    <td>Cish</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Sub-total nephrectomy model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/schanstra_bachvarov_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>endothelial layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>endothelial layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>renal cortical nerves</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>renal cortical vasculature</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>renal cortical lymphatics</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>pelvis</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>kidney calyx</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>kidney capsule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>kidney medulla</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>afferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>efferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>glomerular capillary</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>extraglomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>glomerular parietal epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>glomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>glomerular visceral epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>renal cortex interstitium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>renal cortex tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13542</td>
    <td>http://bio2rdf.org/geneid:13542</td>
    <td>Dvl1</td>
    <td>Absent</td>
    <td>renal nerve</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13645</td>
    <td>http://bio2rdf.org/geneid:13645</td>
    <td>Egf</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>endothelial layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>endothelial layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>renal cortical nerves</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>renal cortical vasculature</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>renal cortical lymphatics</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>pelvis</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>kidney calyx</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>kidney capsule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>kidney medulla</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>afferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>efferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>glomerular capillary</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>extraglomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>glomerular parietal epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>glomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>glomerular visceral epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>renal cortex interstitium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>renal cortex tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Absent</td>
    <td>renal nerve</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14173</td>
    <td>http://bio2rdf.org/geneid:14173</td>
    <td>Fgf2</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Sub-total nephrectomy model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/schanstra_bachvarov_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14183</td>
    <td>http://bio2rdf.org/geneid:14183</td>
    <td>Fgfr2</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14362</td>
    <td>http://bio2rdf.org/geneid:14362</td>
    <td>Fzd1</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/14463</td>
    <td>http://bio2rdf.org/geneid:14463</td>
    <td>Gata4</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/15184</td>
    <td>http://bio2rdf.org/geneid:15184</td>
    <td>Hdac5</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Up</td>
    <td>glomerular cell</td>
    <td>Lupus nephritis model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/kae_teramoto_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16000</td>
    <td>http://bio2rdf.org/geneid:16000</td>
    <td>Igf1</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Sub-total nephrectomy model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/schanstra_bachvarov_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16001</td>
    <td>http://bio2rdf.org/geneid:16001</td>
    <td>Igf1r</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16150</td>
    <td>http://bio2rdf.org/geneid:16150</td>
    <td>Ikbkb</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16151</td>
    <td>http://bio2rdf.org/geneid:16151</td>
    <td>Ikbkg</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16195</td>
    <td>http://bio2rdf.org/geneid:16195</td>
    <td>Il6st</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Weak</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16878</td>
    <td>http://bio2rdf.org/geneid:16878</td>
    <td>Lif</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16973</td>
    <td>http://bio2rdf.org/geneid:16973</td>
    <td>Lrp5</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/16974</td>
    <td>http://bio2rdf.org/geneid:16974</td>
    <td>Lrp6</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/17876</td>
    <td>http://bio2rdf.org/geneid:17876</td>
    <td>Myef2</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Weak</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18033</td>
    <td>http://bio2rdf.org/geneid:18033</td>
    <td>Nfkb1</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18607</td>
    <td>http://bio2rdf.org/geneid:18607</td>
    <td>Pdpk1</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18706</td>
    <td>http://bio2rdf.org/geneid:18706</td>
    <td>Pik3ca</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18707</td>
    <td>http://bio2rdf.org/geneid:18707</td>
    <td>Pik3cd</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18708</td>
    <td>http://bio2rdf.org/geneid:18708</td>
    <td>Pik3r1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18709</td>
    <td>http://bio2rdf.org/geneid:18709</td>
    <td>Pik3r2</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18710</td>
    <td>http://bio2rdf.org/geneid:18710</td>
    <td>Pik3r3</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Up</td>
    <td>glomerular cell</td>
    <td>Lupus nephritis model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/kae_teramoto_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18751</td>
    <td>http://bio2rdf.org/geneid:18751</td>
    <td>Prkcb</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Sub-total nephrectomy model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/schanstra_bachvarov_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18780</td>
    <td>http://bio2rdf.org/geneid:18780</td>
    <td>Pla2g2a</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18796</td>
    <td>http://bio2rdf.org/geneid:18796</td>
    <td>Plcb2</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19055</td>
    <td>http://bio2rdf.org/geneid:19055</td>
    <td>Ppp3ca</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19056</td>
    <td>http://bio2rdf.org/geneid:19056</td>
    <td>Ppp3cb</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19353</td>
    <td>http://bio2rdf.org/geneid:19353</td>
    <td>Rac1</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19877</td>
    <td>http://bio2rdf.org/geneid:19877</td>
    <td>Rock1</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19878</td>
    <td>http://bio2rdf.org/geneid:19878</td>
    <td>Rock2</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Up</td>
    <td>glomerular cell</td>
    <td>Lupus nephritis model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/kae_teramoto_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/20848</td>
    <td>http://bio2rdf.org/geneid:20848</td>
    <td>Stat3</td>
    <td>Up</td>
    <td>macrophage</td>
    <td>Lupus nephritis model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/ramalingam_bethunaickan_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/208727</td>
    <td>http://bio2rdf.org/geneid:208727</td>
    <td>Hdac4</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21803</td>
    <td>http://bio2rdf.org/geneid:21803</td>
    <td>Tgfb1</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/21926</td>
    <td>http://bio2rdf.org/geneid:21926</td>
    <td>Tnf</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/224045</td>
    <td>http://bio2rdf.org/geneid:224045</td>
    <td>Eif2b5</td>
    <td>Unmodified</td>
    <td>kidney collecting duct epithelial cell</td>
    <td>Vasopressine in vitro model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/rinschen_knepper_mousecollectingductvasopressinephosphoprot_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>endothelial layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>endothelial layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>renal cortical nerves</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>renal cortical vasculature</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>renal cortical lymphatics</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>pelvis</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>kidney calyx</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>kidney capsule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>kidney medulla</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>afferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>efferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>glomerular capillary</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>extraglomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>glomerular parietal epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>glomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>glomerular visceral epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>renal cortex interstitium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>renal cortex tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22416</td>
    <td>http://bio2rdf.org/geneid:22416</td>
    <td>Wnt3a</td>
    <td>Absent</td>
    <td>renal nerve</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Weak</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/22418</td>
    <td>http://bio2rdf.org/geneid:22418</td>
    <td>Wnt5a</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/225724</td>
    <td>http://bio2rdf.org/geneid:225724</td>
    <td>Mapk4</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23938</td>
    <td>http://bio2rdf.org/geneid:23938</td>
    <td>Map2k5</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/23939</td>
    <td>http://bio2rdf.org/geneid:23939</td>
    <td>Mapk7</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26395</td>
    <td>http://bio2rdf.org/geneid:26395</td>
    <td>Map2k1</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Unmodified</td>
    <td>kidney collecting duct epithelial cell</td>
    <td>Vasopressine in vitro model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/rinschen_knepper_mousecollectingductvasopressinephosphoprot_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>endothelial layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>endothelial layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>renal cortical nerves</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>renal cortical vasculature</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal artery</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>smooth muscle layer of renal vein</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>renal cortical lymphatics</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>pelvis</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>kidney calyx</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>kidney capsule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>kidney medulla</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>afferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>efferent arteriole</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>glomerular capillary</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>extraglomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>glomerular parietal epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>glomerular mesangium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>glomerular visceral epithelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>renal cortex interstitium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>renal cortex tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Weak</td>
    <td>proximal straight tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Absent</td>
    <td>renal nerve</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/euregene_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26396</td>
    <td>http://bio2rdf.org/geneid:26396</td>
    <td>Map2k2</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26397</td>
    <td>http://bio2rdf.org/geneid:26397</td>
    <td>Map2k3</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26398</td>
    <td>http://bio2rdf.org/geneid:26398</td>
    <td>Map2k4</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26399</td>
    <td>http://bio2rdf.org/geneid:26399</td>
    <td>Map2k6</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Sub-total nephrectomy model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/schanstra_bachvarov_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26400</td>
    <td>http://bio2rdf.org/geneid:26400</td>
    <td>Map2k7</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26413</td>
    <td>http://bio2rdf.org/geneid:26413</td>
    <td>Mapk1</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26416</td>
    <td>http://bio2rdf.org/geneid:26416</td>
    <td>Mapk14</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26417</td>
    <td>http://bio2rdf.org/geneid:26417</td>
    <td>Mapk3</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/26419</td>
    <td>http://bio2rdf.org/geneid:26419</td>
    <td>Mapk8</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/30955</td>
    <td>http://bio2rdf.org/geneid:30955</td>
    <td>Pik3cg</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/53859</td>
    <td>http://bio2rdf.org/geneid:53859</td>
    <td>Map3k14</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56233</td>
    <td>http://bio2rdf.org/geneid:56233</td>
    <td>Hdac7</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Up</td>
    <td>macrophage</td>
    <td>Lupus nephritis model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/ramalingam_bethunaickan_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56489</td>
    <td>http://bio2rdf.org/geneid:56489</td>
    <td>Ikbke</td>
    <td>Up</td>
    <td>glomerulus</td>
    <td>LPS induced model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/ying_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56637</td>
    <td>http://bio2rdf.org/geneid:56637</td>
    <td>Gsk3b</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Down</td>
    <td>glomerulus</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/makino_suga_glomdiabetmouse5w_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Up</td>
    <td>glomerulus</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/makino_suga_glomdiabetmouse7w_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/56717</td>
    <td>http://bio2rdf.org/geneid:56717</td>
    <td>Mtor</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Sub-total nephrectomy model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/schanstra_bachvarov_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/57265</td>
    <td>http://bio2rdf.org/geneid:57265</td>
    <td>Fzd2</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/66513</td>
    <td>http://bio2rdf.org/geneid:66513</td>
    <td>Tab1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Weak</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/74769</td>
    <td>http://bio2rdf.org/geneid:74769</td>
    <td>Pik3cb</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/79221</td>
    <td>http://bio2rdf.org/geneid:79221</td>
    <td>Hdac9</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13019</td>
    <td>http://bio2rdf.org/geneid:13019</td>
    <td>Ctf1</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Weak</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/13614</td>
    <td>http://bio2rdf.org/geneid:13614</td>
    <td>Edn1</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/18158</td>
    <td>http://bio2rdf.org/geneid:18158</td>
    <td>Nppb</td>
    <td>Down</td>
    <td>kidney</td>
    <td>Sub-total nephrectomy model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/schanstra_bachvarov_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Medium</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Weak</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Medium</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/19091</td>
    <td>http://bio2rdf.org/geneid:19091</td>
    <td>Prkg1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Weak</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/211323</td>
    <td>http://bio2rdf.org/geneid:211323</td>
    <td>Nrg1</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/213435</td>
    <td>http://bio2rdf.org/geneid:213435</td>
    <td>Mylk3</td>
    <td>Down</td>
    <td>glomerulus</td>
    <td>LPS induced model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/ying_sun_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Weak</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Weak</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Weak</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd1_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd2_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3.5_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/230899</td>
    <td>http://bio2rdf.org/geneid:230899</td>
    <td>Nppa</td>
    <td>Unmodified</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/chen_li_adpkd3_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Weak</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Unmodified</td>
    <td>glomerulus</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/makino_suga_glomdiabetmouse5w_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Down</td>
    <td>glomerulus</td>
    <td>db/db model of diabetic nephropathy</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/makino_suga_glomdiabetmouse7w_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/54720</td>
    <td>http://bio2rdf.org/geneid:54720</td>
    <td>Rcan1</td>
    <td>Up</td>
    <td>macrophage</td>
    <td>Lupus nephritis model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/ramalingam_bethunaickan_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Absent</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Absent</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Absent</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Absent</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Absent</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/73181</td>
    <td>http://bio2rdf.org/geneid:73181</td>
    <td>Nfatc4</td>
    <td>Medium</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>bladder smooth muscle cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11161_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>urinary bladder detrussor smooth muscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_detrusor_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>urinary bladder urothelium</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse11221_urothelium_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>renin secreting cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17138_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>renal corpuscle</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17141_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Medium</td>
    <td>podocyte</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse17142_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>kidney medulla cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20004_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>glomerular mesangial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse20687_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>kidney cortex cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22464_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>glomerular capillary endothelial cell</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse22561_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse4816_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_adult_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>urinary bladder</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6466_neonatal_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse6963_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>ureter</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/gse7887_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_nonphospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>kidney</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/huttlin_mouse_phospho_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Up</td>
    <td>kidney collecting duct epithelial cell</td>
    <td>Vasopressine in vitro model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/rinschen_knepper_mousecollectingductvasopressinephosphoprot_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Up</td>
    <td>kidney</td>
    <td>Polycystic kidney disease model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/han_chen_mousepkdprot_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>renal cortex collecting duct</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mouseccdmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Strong</td>
    <td>distal convoluted tubule</td>
    <td></td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/pradervand_firsov_mousedctmrna_assay</td>
  </tr>
  <tr>
    <td>http://identifiers.org/ncbigene/12387</td>
    <td>http://bio2rdf.org/geneid:12387</td>
    <td>Ctnnb1</td>
    <td>Down</td>
    <td>glomerulus</td>
    <td>LPS induced model</td>
    <td>Mus musculus</td>
    <td>kupkb:experiment/ying_sun_assay</td>
  </tr>
</table>
## Code examples
### curl
```shell
curl -o kupkbGene.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/kupkbGene.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@kupkbGene.rq
```
