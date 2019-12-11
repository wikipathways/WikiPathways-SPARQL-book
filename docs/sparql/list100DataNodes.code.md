# list100DataNodes.rq
**Code examples:** [curl](#curl)
### SPARQL
```sparql
PREFIX dc:      <http://purl.org/dc/elements/1.1/> 
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>

SELECT DISTINCT ?node ?label
WHERE {
 ?node a wp:DataNode ;
     rdfs:label ?label .
} LIMIT 100
```
[Execute](http://sparql.wikipathways.org/?query=PREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E+PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%3Fnode+%3FlabelWHERE+%7B+%3Fnode+a+wp%3ADataNode+%3B+++++rdfs%3Alabel+%3Flabel+.%7D+LIMIT+100)
### Output
<table>
  <tr>
    <td><b>node</b></td>
    <td><b>label</b></td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP100</td>
    <td>Glutathione  metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1018</td>
    <td>Apoptosis pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1043</td>
    <td>Calcium signaling pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP106</td>
    <td>Alanine and aspartate metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP106</td>
    <td>Alanine and  aspartate metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP106</td>
    <td>Aspartate  metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP107</td>
    <td>mRNA translation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP107</td>
    <td>Protein Translation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1083</td>
    <td>Cell cycle pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP110</td>
    <td>mRNA translation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP111</td>
    <td>Electron Transport Chain</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP111</td>
    <td>Oxidative Phosphorylation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP111</td>
    <td>mtDNA synthesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP111</td>
    <td>Electron Transport  Chain</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP111</td>
    <td>Electron Transport  Chain PW</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1156</td>
    <td>Inflammatory Response</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1254</td>
    <td>Apoptosis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1254</td>
    <td>Apoptosis Pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1254</td>
    <td>Growth Arrest or Apoptosis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1256</td>
    <td>Inflammasome activation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1269</td>
    <td>Fatty acid metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1269</td>
    <td>Degradation of Fatty Acids Containing an Even Number of Carbons</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1270</td>
    <td>Chondrocyte differentiation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1271</td>
    <td>Toll-like receptor signaling</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1273</td>
    <td>Folate  biosynthesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1273</td>
    <td>Riboflavin  metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP129</td>
    <td>Matrix metalloproteinases</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1290</td>
    <td>Apoptosis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1339</td>
    <td>Electron Transport Chain</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP134</td>
    <td>Pentose Phosphate Pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP134</td>
    <td>Pentose  phosphate  pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1356</td>
    <td>Gluconeogenesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1403</td>
    <td>AMPK activation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1403</td>
    <td>AMPK Pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1422</td>
    <td>Sphingolipid metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1425</td>
    <td>BMP Pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP143</td>
    <td>FA oxidation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP143</td>
    <td>Fatty Acid Oxidation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP143</td>
    <td>Degradation of Fatty Acids</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP143</td>
    <td>Fatty Acid beta-oxidation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP143</td>
    <td>Fatty acid metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP143</td>
    <td>Fatty Acid Beta Oxidation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP143</td>
    <td>fatty acid beta-oxidation spiral</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP146</td>
    <td>Nucleotide Biosynthesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1471</td>
    <td>mTOR Signaling Pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP150</td>
    <td>DNA Replication</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1530</td>
    <td>DNA damage response</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1531</td>
    <td>Vit. D pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1539</td>
    <td>Angiogenesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1539</td>
    <td>D. Angiogenesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP157</td>
    <td>Gluconeogenesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP157</td>
    <td>Glycolysis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP157</td>
    <td>glycolysis & gluconeogenesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP157</td>
    <td>Glycolysis / Gluconeogenesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1591</td>
    <td>Heart development</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1604</td>
    <td>morphine metabolism</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP170</td>
    <td>Steroid Hormone Signaling</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1742</td>
    <td>p53 signaling pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP176</td>
    <td>Folate Cycle</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1775</td>
    <td>Cell Cycle Checkpoint Activation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1788</td>
    <td>Bile acid & xenobiotics transport</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1788</td>
    <td>Bile acid detoxification</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1788</td>
    <td>Bile acid neosynthesis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1788</td>
    <td>bile acid conjugation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>Cell Cycle</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>mitotic cell cycle</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>Cell cycle</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>G2/M Progression</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>Growth Control/Homeostasis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>Growth/Proliferation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>Cell proliferation and apoptosis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP179</td>
    <td>Cell cycle  progression</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1797</td>
    <td>circadian rhythm</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1820</td>
    <td>Gap junction trafficking and regulation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1820</td>
    <td>Gap junction</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1822</td>
    <td>Transcription factors</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1823</td>
    <td>GP1b-IX-V activation signalling</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Proteasome</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Ub-mediated proteolysis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Proteosome degradation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Proteasomal Degradation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>26S Proteasome Degradation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Proteasome degradation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Ubiquitin-Mediated Proteolysis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>26S Proteasome  Degradation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Ubiquitin-Mediated  Proteolysis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Proteasome  degradation pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Ubiquitin-mediated proteasome degradation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP183</td>
    <td>Ubiquitin-mediated  proteolysis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1859</td>
    <td>G2/M Checkpoint Arrest</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1859</td>
    <td>G2/M Transition</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1859</td>
    <td>G2/M transition of mitotic cell cycle</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1870</td>
    <td>Neurotransmitter clearance</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1878</td>
    <td>Lipid peroxidation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1878</td>
    <td>peroxisomal beta-oxidation</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1896</td>
    <td>Induction of Apoptosis</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP19</td>
    <td>TCA cycle</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1909</td>
    <td>Signal transduction</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1910</td>
    <td>EGFR Pathway</td>
  </tr>
  <tr>
    <td>http://identifiers.org/wikipathways/WP1910</td>
    <td>EGFR pathway</td>
  </tr>
</table>
## Code examples
### curl
```shell
curl -o list100DataNodes.rq https://raw.githubusercontent.com/wikipathways/WikiPathways-SPARQL-book/master/sparql/list100DataNodes.rq
curl -H "Accept: text/tab-separated-values" -G http://sparql.wikipathways.org/ --data-urlencode query@list100DataNodes.rq
```
