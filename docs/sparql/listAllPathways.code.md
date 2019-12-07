# listAllPathways.rq
**Source code:**
```sparql
PREFIX dc:      <http://purl.org/dc/elements/1.1/> 
PREFIX wp:     <http://vocabularies.wikipathways.org/wp#>

SELECT DISTINCT (str(?title) as ?pathway) (str(?label) as ?organism)
WHERE {
 ?pw dc:title ?title ;
     wp:organismName ?label .
}
```
[Execute](http://sparql.wikipathways.org/?query=PREFIX+dc%3A++++++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E+PREFIX+wp%3A+++++%3Chttp%3A%2F%2Fvocabularies.wikipathways.org%2Fwp%23%3ESELECT+DISTINCT+%28str%28%3Ftitle%29+as+%3Fpathway%29+%28str%28%3Flabel%29+as+%3Forganism%29WHERE+%7B+%3Fpw+dc%3Atitle+%3Ftitle+%3B+++++wp%3AorganismName+%3Flabel+.%7D)
**Output:**
<table>
  <tr>
    <td><b>pathway</b></td>
    <td><b>organism</b></td>
  </tr>
  <tr>
    <td>Androgen receptor signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ganglio Sphingolipid Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gap junction trafficking and regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Generic Transcription Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of porphyrins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitotic G2-G2/M phases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Protein folding</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of DNA replication</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Respiratory electron transport, ATP synthesis by chemiosmotic coupling, and heat production by uncoupling proteins.</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Semaphorin interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Telomere Maintenance</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Opioid Signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Genes targeted by miRNAs in adipocytes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fatty Acid Omega Oxidation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>AGE/RAGE pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Histone Modifications</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>EBV LMP1 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Deadenylation-dependent mRNA decay</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Trafficking and processing of endosomal TLR</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>alpha-linolenic (omega3) and linoleic (omega6) acid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Collagen biosynthesis and modifying enzymes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by the B Cell Receptor (BCR)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Energy dependent regulation of mTOR by LKB1-AMPK</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fc epsilon receptor (FCERI) signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of Insulin-like Growth Factor (IGF) transport and uptake by Insulin-like Growth Factor Binding Proteins (IGFBPs)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Detoxification of Reactive Oxygen Species</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Extracellular vesicle-mediated signaling in recipient cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Constitutive Androstane Receptor Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>C-type lectin receptors (CLRs)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gene Silencing by RNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Simplified Interaction Map Between LOXL4 and Oxidative Stress Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mevalonate pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SCFA and skeletal muscle substrate metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleobase biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial calcium ion transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Macrophage markers</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of Tetrahydrocannabinol (THC)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Caloric restriction and aging</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Breast cancer pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional regulation by RUNX2</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tetrahydrobiopterin (BH4) synthesis, recycling, salvage and regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Platelet-mediated interactions with vascular and circulating cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tyrosine Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mechanoregulation and pathology of YAP/TAZ via Hippo and non-Hippo mechanisms</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pathways Regulating Hippo Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GPCRs, Class A Rhodopsin-like</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neural Crest Cell Migration during Development</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pathways of nucleic acid metabolism and innate immune sensing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cholesterol metabolism (includes both Bloch and Kandutsch-Russell pathways)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycogen Synthesis and Degradation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Catalytic cycle of mammalian Flavin-containing MonoOxygenases (FMOs)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TFs Regulate miRNAs related to cardiac hypertrophy</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eicosanoid Synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell junction organization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Circadian Clock</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Damage Reversal</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Effects of PIP2 hydrolysis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Integration of energy metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interferon gamma signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of water-soluble vitamins and cofactors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>tRNA Aminoacylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Integrated Cancer Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Iron metabolism in placenta</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Butyrate-induced histone acetylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Peptide GPCRs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Colchicine Metabolic Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gastric acid production</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Aripiprazole Metabolic Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Heroin metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DAP12 interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Blood Clotting Cascade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-2 family signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>YAP1- and WWTR1 (TAZ)-stimulated gene expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycerophospholipid biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MyD88:MAL(TIRAP) cascade initiated on plasma membrane</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mesodermal Commitment Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin D Receptor Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRNA targets in ECM and membrane receptors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hypoxia-mediated EMT and Stemness</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hedgehog 'on' state</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Macroautophagy</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Melanin biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oxidative Stress Induced Senescence</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of beta-cell development</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>tRNA modification in the nucleus and cytosol</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcription factor regulation in adipogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Photodynamic therapy-induced unfolded protein response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Caffeine and Theobromine metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of TP53 Expression and Degradation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by MST1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Intra-Golgi and retrograde Golgi-to-ER traffic</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation by HSP70</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Robo4 and VEGF Signaling Pathways Crosstalk</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GPR40 Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRNA regulation of p53 pathway in prostate cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Receptor-type tyrosine-protein phosphatases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Intracellular oxygen transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Clathrin-mediated endocytosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-4 and Interleukin-13 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Keratinization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phase II - Conjugation of compounds</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ketone body metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Triglyceride metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Endometrial cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phosphodiesterases in neuronal function</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ultraconserved region 339 modulation of tumor suppressor microRNAs in cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>FABP4 in ovarian cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolic pathway of LDL, HDL and TG, including diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulatory circuits of the STAT3 signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cancer immunotherapy by CTLA4 blockade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>22q11.2 Deletion Syndrome</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Energy Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Folate-Alcohol and Cancer Pathway Hypotheses</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Folate Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell Cycle Checkpoints</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eukaryotic Translation Initiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Formation of Fibrin Clot (Clotting Cascade)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of nitric oxide</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitotic G1-G1/S phases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurotransmitter uptake and metabolism In glial cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NTRK1 (TRKA)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Passive transport by Aquaporins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Response to elevated platelet cytosolic Ca2+</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Thyroxine (Thyroid Hormone) Production</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RANKL/RANK (Receptor activator of NFKB (ligand)) Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of Microtubule Cytoskeleton</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neural Crest Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling Pathways in Glioblastoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Corticotropin-releasing hormone signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycerophospholipid Biosynthetic Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitotic Prophase</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Type 1 Insulin-like Growth Factor 1 Receptor (IGF1R)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of non-coding RNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of Hypoxia-inducible Factor (HIF) by oxygen</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PI Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Host Interactions with Influenza Factors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional regulation of pluripotent stem cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cocaine metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Aryl Hydrocarbon Receptor Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nuclear Receptors Meta-Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Copper homeostasis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TET1,2,3 and TDG demethylate DNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>LGI-ADAM interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cellular response to heat stress</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Zinc homeostasis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NIK-->noncanonical NF-kB signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ROS, RNS production in phagocytes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>tRNA processing in the nucleus</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Composition of Lipid Particles</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tgif disruption of Shh signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cardiac conduction</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Retinoid metabolism and transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TLR4 Signaling and Tolerance</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of Apoptosis by Parathyroid Hormone-related Protein</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amino Acid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phytochemical activity on NRF2 transcriptional activation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RET signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Digestion</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MET in type 1 papillary renal cell carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oligodendrocyte Specification and differentiation(including remyelination), leading to Myelin Components for CNS</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MicroRNA network associated with chronic lymphocytic leukemia</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional Regulation by E2F6</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Retinoic Acid</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NTRK3 (TRKC)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Modified nucleosides derived from t-RNA as urinary cancer markers</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL-10 Anti-inflammatory Signaling Pathway </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cerebral Organic Acidurias, including diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Envelope proteins and their potential roles in EDMD physiopathology</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hippo-Merlin Signaling Dysregulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>FBXL10 enhancement of MAP/ERK signaling in diffuse large B-cell lymphoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Head and Neck Squamous Cell Carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ketogenesis and Ketolysis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Acetylcholine Synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TGF-beta Receptor Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oxidative phosphorylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Methylation Pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Translation Factors</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>mRNA processing</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation 1</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Influenza A virus infection</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nicotine Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Presynaptic depolarization and calcium channel opening</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Effects of Nitric Oxide</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Type III interferon signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Programmed Cell Death and Cell Engulfment</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Immune responses in the epidermis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Sulfide oxidation pathway</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Metastatic brain tumor</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glial Cell Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Male mating</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Wnt Signaling</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Oncostatin M Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nanoparticle triggered regulated necrosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RTK/Ras/MAPK -  LET-23, EGL-15 independent</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>T-Cell Receptor and Co-stimulatory Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Acetylcholine Synthesis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>PIP3 activates AKT signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>HIV Life Cycle</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Influenza Life Cycle</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NOTCH4</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by BMP</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cardiac Hypertrophic Response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sex determination</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>EV release from cardiac cells and their functional effects</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>mTOR signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA methylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases Activate ROCKs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Activated PKN1 stimulates transcription of AR (androgen receptor) regulated genes KLK2 and KLK3</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synthesis of wybutosine at G37 of tRNA(Phe)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glyoxylate metabolism and glycine degradation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TGF-beta Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hfe effect on hepcidin production</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ApoE and miR-146 in inflammation and atherosclerosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Microglia Pathogen Phagocytosis Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RNA interference and miRNA</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Pathways in clear cell renal cell carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleotide salvage</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Choline catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurexins and neuroligins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ras Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Purine metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NRF2-ARE regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ESR-mediated signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurodegeneration with brain iron accumulation (NBIA) subtypes pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Insulin Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Mitochondrial Unfolded-Protein Response (UPRmt)</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Aflatoxin B1 metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Fatty Acid Omega Oxidation</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Eicosanoid Synthesis</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>EGFR1 Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Nuclear receptors in lipid metabolism and toxicity</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Adipogenesis</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Cytokines and Inflammatory Response</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Ovarian Infertility Genes</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Kit Receptor Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Blood Clotting Cascade</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Osteoclast</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Androgen receptor signaling pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>FAS pathway and Stress induction of HSP regulation</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>mRNA Processing</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>NLR Proteins</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Statin Pathway PharmGKB</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Aflatoxin B1 metabolism</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Id Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Polyol pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Matrix Metalloproteinases</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Delta-Notch Signaling Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Nuclear Receptors</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Integrin-mediated cell adhesion</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Osteoblast</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Irinotecan Pathway</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation by HSP70</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Cell cycle</td>
    <td>Pan troglodytes</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>TGF Beta Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Glucuronidation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>EBV LMP1 signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Estrogen signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Hypothetical Network for Drug Addiction</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Arachidonate Epoxygenase   Epoxide Hydrolase</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Metapathway biotransformation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Type II interferon signaling (IFNG)</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Apoptosis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>NLR Proteins</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Mitochondrial Gene Expression</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Estrogen metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Polyol pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>SIDS Susceptibility Pathways</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Endochondral Ossification</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Oxidation by Cytochrome P450</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Endochondral Ossification</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Fatty Acid Omega Oxidation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Non-odorant GPCRs</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Odorant GPCRs</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Oxidative Damage</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Dopaminergic Neurogenesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>IL-5 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Regulation of Cardiac Hypertrophy by miR-208</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Glycolysis and Gluconeogenesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Iron Homeostasis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Glutathione metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation by HSP70</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Acetylcholine Synthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Kennedy pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>GPCRs, Class A Rhodopsin-like</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>The effect of Glucocorticoids on target gene expression</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Statin Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Ptf1a related regulatory pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Hypertrophy Model</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Neural Crest Differentiation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Alzheimers Disease</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Serotonin Receptor 2 and STAT3 Signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>SREBF and miR33 in cholesterol and lipid homeostasis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Striated Muscle Contraction</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Purine metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Chemokine signaling pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Peptide GPCRs</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Nuclear factor, erythroid-derived 2, like 2 signaling pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Osteoblast</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Spinal Cord Injury</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>TNF-alpha NF-kB Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Blood Clotting Cascade</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Relationship between glutathione and NADPH</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Primary Focal Segmental Glomerulosclerosis FSGS</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Focal Adhesion-PI3K-Akt-mTOR-signaling pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>White fat cell differentiation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>p53 signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Mecp2 and Associated Rett Syndrome</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>IL-7 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Translation Factors</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>mRNA processing</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Eicosanoid Synthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>GPCRs, Class C Metabotropic glutamate, pheromone</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Fatty Acid Omega Oxidation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Small Ligand GPCRs</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>TYROBP Causal Network</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Acetate mediated promotion of metabolic syndrome</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>EDA Signalling in Hair Follicle Development</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>BMP Signaling Pathway in Eyelid Development</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>IL-3 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>IL-1 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Myometrial Relaxation and Contraction Pathways</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Robo4 and VEGF Signaling Pathways Crosstalk</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>IL-6 signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>mir-193a and MVP in colon cancer metastasis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>miR-127 in mesendoderm differentiation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>GPCRs, Other</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Ethanol metabolism resulting in production of ROS by CYP2E1</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Nuclear receptors in lipid metabolism and toxicity</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Eicosanoid Lipid Synthesis Map</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Eicosanoid metabolism via Cyclo Oxygenases (COX)</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Eicosanoid metabolism via Lipo Oxygenases (LOX)</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Matrix Metalloproteinases</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Circulating monocytes and cardiac macrophages in diastolic dysfunction</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>GPCRs, Class B Secretin-like</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Irinotecan Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Alpha6-Beta4 Integrin Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Biosynthesis of Aldosterone and Cortisol</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Id Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Biogenic Amine Synthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Regulation of Actin Cytoskeleton</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway NetPath</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Steroid Biosynthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>FAS pathway and Stress induction of HSP regulation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Leptin Insulin Overlap</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Signal Transduction of S1P Receptor</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>ATM Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Insulin Signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Amino Acid metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Leptin and adiponectin</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway and Pluripotency</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Glutathione and one carbon metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Tryptophan metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Nucleotide Metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Toll Like Receptor signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Acetylcholine Synthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Selenium metabolism/Selenoproteins</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Eicosanoid Synthesis</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>IL-2 Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>EGFR1 Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Nuclear receptors in lipid metabolism and toxicity</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>IL-9 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Adipogenesis</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Cytokines and Inflammatory Response</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Biogenic Amine Synthesis</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Electron Transport Chain</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Kit Receptor Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Blood Clotting Cascade</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Tryptophan metabolism</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway and Pluripotency</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Androgen receptor signaling pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>FAS pathway and Stress induction of HSP regulation</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>mRNA Processing</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Mismatch repair</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Statin Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Id Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Polyol pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Matrix Metalloproteinases</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Delta-Notch Signaling Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Nuclear Receptors</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Integrin-mediated cell adhesion</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Irinotecan Pathway</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Cell cycle</td>
    <td>Canis familiaris</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>EBV LMP1 signaling</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>mRNA processing</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Mismatch repair</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Polyol pathway</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Non-homologous end joining</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Keap1-Nrf2</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Methylation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Oxidative phosphorylation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Amino acid conjugation of benzoic acid</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Mismatch repair</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Retinol metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>ErbB signaling pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Aflatoxin B1 metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Selenium Micronutrient Network</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Folic Acid Network</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Orphan GPCRs</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>MicroRNAs in Cardiomyocyte Hypertrophy</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>PluriNetWork</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>One carbon metabolism and related pathways</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Signaling of Hepatocyte Growth Factor Receptor</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Splicing factor NOVA regulated synaptic proteins</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Complement Activation, Classical Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Heart Development</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Nucleotide GPCRs</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Serotonin and anxiety-related events</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Serotonin and anxiety</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Cytokines and Inflammatory Response</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>DON mycotoxin biosynthesis</td>
    <td>Gibberella zeae</td>
  </tr>
  <tr>
    <td>Macrophage markers</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>PPAR signaling pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Fatty acid oxidation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>miRNAs and TFs in iPS Cell Generation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Alanine and aspartate metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Escherichia coli K-12 Peripherome</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>NAD biosynthesis I (from aspartate)</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>NAD salvage pathway I</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>NAD salvage pathway II</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>NAD salvage pathway III</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>MAPK Cascade</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Delta-Notch Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Ovarian Infertility Genes</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Gene regulatory network modelling somitogenesis </td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Acetaminophen synthesis</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>Mir302-367 Promoting Cardiomyocyte Proliferation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>miR-222 in Exercise-Induced Cardiac Growth</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Electron Transport Chain</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Histone modifications</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation and Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Gastric Cancer Network 1</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>ESC Pluripotency Pathways</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Septum site determination</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>Central Carbon Metabolism</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>ApoE and miR-146 in inflammation and atherosclerosis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Microglia Pathogen Phagocytosis Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Lung fibrosis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Parkinsons Disease Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>SK UDPglcnac</td>
    <td>Escherichia coli</td>
  </tr>
  <tr>
    <td>Novel Jun-Dmp1 Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td> Hfe effect on hepcidin production</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Factors and pathways affecting insulin-like growth factor (IGF1)-Akt signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Prostaglandin Synthesis and Regulation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Dysregulated miRNA Targeting in Insulin/PI3K-AKT Signaling</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Toll, IMD, JAK/STAT Pathways for Immune Response to Pathogens</td>
    <td>Anopheles gambiae</td>
  </tr>
  <tr>
    <td>Wnt Signaling in Kidney Disease</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Triacylglyceride Synthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Kit Receptor Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Oxidative Stress</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Distal Convoluted Tubule 1 (DCT1) Cell</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Sphingolipid Metabolism (general overview)</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Glycerolipids and Glycerophospholipids</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Cholesterol metabolism (includes both Bloch and Kandutsch-Russell pathways)</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Eicosanoid metabolism via Cytochrome P450 Mono-Oxygenases (CYP) pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Omega-3/Omega-6 FA synthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Omega-9 FA synthesis</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>PDGFR? and STMN1 cooperate to exacerbate the cytotoxic effects of vinblastine</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Adipogenesis genes</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Complement and Coagulation Cascades</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>IL-2 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Osteoclast</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Inflammatory Response Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Blood Clotting Cascade</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td> Lipids measured in liver metastasis from breast cancer</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Sphingolipid Metabolism (integrated pathway)</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>MAPK signaling pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Glucocorticoid & Mineralcorticoid Metabolism</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Nuclear Receptors</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Exercise-induced Circadian Regulation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>EGFR1 Signaling Pathway</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>miR-1 in cardiac development</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Integrin-mediated Cell Adhesion</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Focal Adhesion</td>
    <td>Mus musculus</td>
  </tr>
  <tr>
    <td>Electron Transport Chain</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Kit receptor signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Metapathway biotransformation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway and Pluripotency</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-7 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Type II interferon signaling (IFNG)</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>FAS pathway and Stress induction of HSP regulation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>mRNA Processing</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Steroid Biosynthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glycolysis and Gluconeogenesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Mismatch repair</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nucleotide GPCRs</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Signaling of Hepatocyte Growth Factor Receptor</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TGF Beta Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Oxidative Stress</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Estrogen metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Polyol Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-4 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Regulation of Actin Cytoskeleton</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Toll-like receptor signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>GPCRs, Class A Rhodopsin-like</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Irinotecan Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Signal Transduction of S1P Receptor</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation by HSP70</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Non-homologous End joining</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Mismatch Repair</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Homologous Recombination</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Biogenic Amine Synthesis</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>mRNA processing</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Glycolysis and Gluconeogenesis</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Beta Oxidation of Unsaturated Fatty Acids</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation 3</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Triacylglyceride Synthesis</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Growth Hormone (GH) Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IGF-1 Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Serotonin Receptor 2 and STAT3 Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Ovarian Infertility Genes</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Type II diabetes mellitus</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Folate-Alcohol and Cancer Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Physiological and Pathological Hypertrophy  of the Heart</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>AGE/RAGE pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>One carbon donor</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Constitutive Androstane Receptor Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>SREBF and miR33 in cholesterol and lipid homeostasis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Trans-sulfuration pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>NOD pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Sulindac Metabolic Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Diclofenac Metabolic Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Osteopontin Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Pathogenic Escherichia coli infection</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL1 and megakaryotyces in obesity</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>RNA interference</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Biogenic Amine Synthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>BMP Signalling and Regulation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Type III interferon signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Regulation of Microtubule Cytoskeleton</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nicotine Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Colchicine Metabolic Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Liver X Receptor Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Neurotransmitter Release Cycle</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Vitamin B12 Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Dopaminergic Neurogenesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glycerophospholipid Biosynthetic Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>PDGF Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cell Differentiation - Index</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Secretion of Hydrochloric Acid in Parietal Cells</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Ectoderm Differentiation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nucleotide Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Membrane Trafficking</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Influenza A virus infection</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Ganglio Sphingolipid Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Oxytocin signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Differentiation Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Synaptic Vesicle Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Exercise-induced Circadian Regulation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Senescence and Autophagy in Cancer</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TWEAK Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Serotonin Receptor 2 and ELK-SRF/GATA4 signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Amyotrophic lateral sclerosis (ALS)</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Integrated Cancer pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Endothelin Pathways</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Butyrate-induced histone acetylation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cardiac Hypertrophic Response</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Blood Clotting Cascade</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TOR Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Metastatic brain tumor</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Integrated Breast Cancer Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Alanine and aspartate metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Benzo(a)pyrene metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Corticotropin-releasing hormone</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Codeine and Morphine Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Serotonin Receptor 4/6/7 and NR3C Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Leptin signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Fluoropyrimidine Activity</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Globo Sphingolipid Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Equilibrium Signalling Pathway of Differentiated Cells</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Humoral Immune Response to Fungal and Bacterial Pathogens</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Toll, IMD, JAK/STAT Pathways for Immune Response to Pathogens</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>RIOK1 and RIOK2 in EGFR- and PI3K-mediated tumorigenesis</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation 1</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Beta Oxidation Meta</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Translation Factors</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Electron Transport Chain</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>Insulin Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Striated Muscle Contraction</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Fatty Acid Omega Oxidation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Small Ligand GPCRs</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-2 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-6 signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Complement Activation, Classical Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Drosophila melanogaster</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>EBV LMP1 signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>GPCRs, Other</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Oxidative phosphorylation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Alanine and aspartate metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by EGFR</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Insulin receptor</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Unfolded Protein Response (UPR)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Irinotecan Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Parkin-Ubiquitin Proteasomal System pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gastric Cancer Network 2</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>HIF1A and PPARG regulation of glycolysis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Trans-sulfuration and one carbon metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ATF6 (ATF6-alpha) activates chaperone genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Defensins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Prolactin receptor signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Extracellular matrix organization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitotic Metaphase and Anaphase</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleotide-binding domain, leucine rich repeat containing receptor (NLR) signaling pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Endoderm Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gene regulatory network modelling somitogenesis </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ectoderm Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Aflatoxin activation and detoxification</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Caspase activation via Dependence Receptors in the absence of ligand</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TCF dependent signaling in response to WNT</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TNF signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitophagy</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Methionine De Novo and Salvage Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Circadian rhythm related genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pathways Affected in Adenoid Cystic Carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell-type Dependent Selectivity of CCK2R Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of TP53 Activity through Association with Co-factors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Protein repair</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Smooth Muscle Contraction</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Factors and pathways affecting insulin-like growth factor (IGF1)-Akt signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Development and heterogeneity of the ILC family</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Angiopoietin Like Protein 8 Regulatory Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PDGFR-beta pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway and Pluripotency</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pyrimidine metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Intestinal absorption</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MTF1 activates gene expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pyrophosphate hydrolysis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleobase catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neutrophil degranulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-12 family signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Carboxyterminal post-translational modifications of tubulin</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oxidative Stress</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Butyrophilin (BTN) family interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Exercise-induced Circadian Regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Post-translational protein phosphorylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of RUNX1 Expression and Activity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Splicing factor NOVA regulated synaptic proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PI3K-Akt Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Somatroph axis (GH) and its relationship to dietary restriction and aging</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Disorders of the Krebs cycle</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Epithelial to mesenchymal transition in colorectal cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolic reprogramming in colon cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Extracellular vesicles in the crosstalk of cardiac cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRNAs involvement in the immune response in sepsis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nonalcoholic fatty liver disease</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G alpha (12/13) signalling events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>COPII-mediated vesicle transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by PTK6</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of immune response proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of SUMOylation proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Erythropoietin</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>OAS antiviral response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin D in inflammatory diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Inflammatory Response Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Overview of interferons-mediated signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cytosolic DNA-sensing pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Small cell lung cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Estrogen signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Arachidonate Epoxygenase / Epoxide Hydrolase</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Peptide GPCRs</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>GPCRs, Class B Secretin-like</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Osteoclast Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Amino acid conjugation of benzoic acid</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>MAPK Cascade</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TCR Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Triacylglyceride Synthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Androgen receptor signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Apoptosis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Phase I biotransformations, non P450</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>B Cell Receptor Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Selenium Metabolism and Selenoproteins</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-3 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>NLR Proteins</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Vitamin A and Carotenoid Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Inflammatory Response Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Statin Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>ErbB Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TGF beta Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TNF alpha Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>GPCRs, Class C Metabotropic glutamate, pheromone</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>ID signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Complement and Coagulation Cascades</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Matrix Metalloproteinases</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Endochondral Ossification</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nuclear Receptors</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Integrin-mediated Cell Adhesion</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Osteoblast Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Folate Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Oxidation by Cytochrome P450</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cell Cycle</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Growth Hormone Receptor (GHR) Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Gonadotropin-releasing hormone (GnRH) signaling </td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Iron metabolism in placenta</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Vascular smooth muscle contraction</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cori Cycle</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Monoamine Transport</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>DNA Damage Response</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Pilocytic astrocytoma</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Histone Modifications</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Apoptosis-related network due to altered Notch3 in ovarian cancer</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cardiac Progenitor Differentiation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Bladder Cancer</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>SIDS Susceptibility Pathways</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Regulation of toll-like receptor signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Mitochondrial Gene Expression</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Trans-sulfuration and one carbon metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Interactome of polycomb repressive complex 2 (PRC2) </td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Serotonin Transporter Activity</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Gastric cancer network 2</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>miRNA Biogenesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>BDNF signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glycine Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>DNA Damage Response (only ATM dependent)</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Peroxisomal beta-oxidation of tetracosanoyl-CoA</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TCA Cycle and Deficiency of Pyruvate Dehydrogenase complex (PDHc)</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Semaphorin interactions</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>RANKL/RANK Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>AMPK Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Dopamine metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>FSH signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Interleukin-11 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Extracellular vesicle-mediated signaling in recipient cells</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Vitamin D Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Estrogen Receptor Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Neurotransmitter Clearance In The Synaptic Cleft</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Quercetin and Nf-kB/ AP-1 Induced Cell Apoptosis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Deregulation of Rab and Rab Effector Genes in Bladder Cancer</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Gastric acid production</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Hematopoietic Stem Cell Differentiation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glucocorticoid & Mineralcorticoid Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL17 signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Structural Pathway of Interleukin 1 (IL-1)</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nicotine Activity on Dopaminergic Neurons</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nanoparticle-mediated activation of receptor signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Effects of Nitric Oxide</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Mesodermal Commitment Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Angiogenesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Spinal Cord Injury</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Felbamate Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>NRF2 pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TSLP Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>SREBP signalling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Arrhythmogenic Right Ventricular Cardiomyopathy</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Focal Adhesion</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Parkin-Ubiquitin Proteasomal System pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glial Cell Differentiation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Aryl Hydrocarbon Receptor Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Retinoblastoma Gene in Cancer</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glutathione metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Arylhydrocarbon receptor (AhR) signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Glucuronidation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Interferon type I signaling pathways</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Gene regulatory network modelling somitogenesis </td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Iron uptake and transport</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TFs Regulate miRNAs related to cardiac hypertrophy</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>ATM Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Differentiation of white and brown adipocyte   </td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Aryl Hydrocarbon Receptor</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Thyroid Stimulating Hormone (TSH) signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>NAD Biosynthesis II (from tryptophan)</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Sphingolipid Metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Primary Focal Segmental Glomerulosclerosis FSGS</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Sulfation Biotransformation Reaction</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Thyroxine (Thyroid Hormone) Production</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TP53 Network</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Endoderm Differentiation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>DDX1 as a regulatory component of the Drosha microprocessor</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Urea cycle and metabolism of amino groups</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Aflatoxin B1 metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Tryptophan metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TCA Cycle Nutrient Utilization and Invasiveness of Ovarian Cancer</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Drug Induction of Bile Acid Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Lidocaine metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nicotine Activity on Chromaffin Cells</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Selenium Micronutrient Network</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>PPAR Alpha Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Tamoxifen metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Signaling Pathways in Glioblastoma</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>RalA downstream regulated genes</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Farnesoid X Receptor  Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-1 signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Neural Crest Differentiation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Myometrial Relaxation and Contraction Pathways</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Oncostatin M Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Heart Development</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Catalytic cycle of mammalian FMOs</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>T-Cell Receptor and Co-stimulatory Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Translation Factors</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-5 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Eicosanoid Synthesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>IL-9 Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>EGF/EGFR Signaling Pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Non-homologous end joining</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway Netpath</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Nuclear Receptors in Lipid Metabolism and Toxicity</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Hypertrophy Model</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Alpha 6 Beta 4 signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Estrogen signaling pathway</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Adipogenesis</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Transcriptional activation by NRF2</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Methylation Pathways</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Arylamine metabolism</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Prostaglandin Synthesis and Regulation</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>Cytokines and Inflammatory Response</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Bos taurus</td>
  </tr>
  <tr>
    <td>UDP-Glucose Conversion</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Principle Pathways of Carbon Metabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Colanic Acid Building Blocks Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Homocysteine and Cysteine Interconversion</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis, Initial Steps</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Response Regulator Aspartate Phosphatase Interactions</td>
    <td>Bacillus subtilis</td>
  </tr>
  <tr>
    <td>Sucrose Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Aspartate Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Gluconeogenesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>UDP-N-Acetylgalactosamine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Tryptophan Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Fatty Acid Elongation, Unsaturated</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>NAD Salvage Pathway</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>m-cresol degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Isoleucine Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Leucine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>P-cymene Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>GPVI-mediated activation cascade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Kinesins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RNA Polymerase II Transcription</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signal amplification</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by PDGF</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by ROBO receptors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Superpathway of Glutamate Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>TCR signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phenylalanine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glutathione Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Isoleucine, Leucine, and Valine biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>De Novo Biosynthesis of Purine Nucleotides</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Pyruvate Dehydrogenase Pathway</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Serine and Glycine biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Cytoplasmic tRNA Synthetases</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Ribose and Deoxyribose Phosphate Metabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Aerobic Glycerol Catabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Deoxyribose phosphate metabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Deregulation of Rab and Rab Effector Genes in Bladder Cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Folate Biosynthesis</td>
    <td>Bacillus subtilis</td>
  </tr>
  <tr>
    <td>Isoleucine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glycolysis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Cysteine Biosynthesis from Homoserine</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Starch and Cellulose Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glucose-1-phosphate metabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glycine biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Structural Pathway of Interleukin 1 (IL-1)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitotic Prometaphase</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Triglyceride Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Cytosolic iron-sulfur cluster assembly</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial protein import</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional activity of SMAD2/SMAD3:SMAD4 heterotrimer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Arginine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Degradation of the extracellular matrix</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phenylalanine, Tyrosine, Tryptophan biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Carbon monoxide dehydrogenase pathway</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glucose Repression</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Nutrient control of ribosomal gene expression</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Upiquinone Q Prenylation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Polyamine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>TCA Cycle - Detailed</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Valine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Tryptophan Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Kit receptor signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleotide Metabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Allantoin Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Translation Factors</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Threonine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>RuMP cycle, containing "Oxidative Branch of the Pentose Phosphate Pathway" and formaldehyde assimilation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>TP53 Regulates Metabolic Genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases Activate WASPs and WAVEs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycine Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Protein Modifications</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Leucine Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Histidine, lysine, phenylalanine, tyrosine, proline and tryptophan catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Isoleucine and Valine biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Xylulose-monophosphate cycle</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Gut-Liver Indole Metabolism </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Turbo design of glycolysis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>De Novo Biosyn. of Pyrimidine Deoxyribonucleotides</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Sphingolipid Metabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Genes of Meiotic Recombination</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Lysosomal oligosaccharide catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Non-Oxidative Branch of the Pentose Pathway</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Fatty Acid Elongation, Saturated</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Regulation of TP53 Activity through Acetylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Riboflavin, FMN, and FAD Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Metabolism of vitamin K</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>rRNA modification in the nucleus and cytosol</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Toll-like Receptor Signaling related to MyD88</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ATM Signaling Network in Development and Disease </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serine-isocitrate lyase pathway</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glutathione-Glutaredoxin Redox Reaction</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>DNA IR-Double Strand Breaks (DSBs) and cellular response via ATM</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Trehalose Anabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Other interleukin signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RAB geranylgeranylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cristae formation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Galactose catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell Cycle and Cell Division</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Degradation pathway of sphingolipids, including diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>poly(glycerol phosphate) wall teichoic acid biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Superpathway of Histidine, Purine, and Pyrimidine</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Sulfate assimilation and copper detoxification</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Threonine and Methionine biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Type 2 papillary renal cell carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>MTHFR deficiency</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Asparagine degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Neovascularisation processes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ncRNAs involved in Wnt signaling in hepatocellular carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sulfur degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Biosynthesis of DHA-derived SPMs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Replication Pre-Initiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tryptophan Degradation Via Kynurenine</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Hippo-Yap signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neural Crest Cell Migration in Cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Panothenate and Coenzyme A Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Purine Fermentation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Methionine Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Phosphatidic Acid and Phospholipid Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glycogen Catabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>IL-2 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glutamate degradation III</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Histidine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glycolysis and Gluconeogenesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Lysine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Tyrosine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>De Novo NAD Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Lactose degradation and Galactose metabolism</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Arginine degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Octane oxidation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glutamate degradation I</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glycerol Teichoic Acid Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Phenylalanine Degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Anaerobic respiration</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Sulfate assimilation pathway II</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Interferon type I signaling pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Toluene degradation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Mitochondrial tRNA Synthetases</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway 2</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Arachidonate Epoxygenase / Epoxide Hydrolase</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Asparagine Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Trehalose Degradation, Low Osmolarity</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Lipases biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Serotonin Receptor 4/6/7 and NR3C Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glutamate biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Sulfur Amino Acid biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>NAD Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Fatty acid oxidation</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>De Novo Biosynthesis of Pyrimidine Ribonucleotides</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Salvage Pathways of Pyrimidine Ribonucleotides</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Glutamate degradation VIII</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>Phospholipid Biosynthesis</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
  <tr>
    <td>AMP-activated Protein Kinase (AMPK) Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin B12 Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Advanced glycosylation endproduct receptor signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Factors involved in megakaryocyte development and platelet production</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GP1b-IX-V activation signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interferon alpha/beta signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>L1CAM interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>mRNA Editing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurotransmitter clearance</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of Apoptosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Prolactin Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Drug Induction of Bile Acid Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nanomaterial induced apoptosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ATM Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Iron uptake and transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial iron-sulfur cluster biogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Activation of gene expression by SREBF (SREBP)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NOTCH2</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NOTCH3</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Insulin processing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by TGF-beta Receptor Complex</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>The citric acid (TCA) cycle and respiratory electron transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Activin</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cytosolic sensors of pathogen-associated DNA </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of lipid metabolism by Peroxisome proliferator-activated receptor alpha (PPARalpha)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Human Complement System</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mammary gland development pathway - Embryonic development (Stage 1 of 4)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Dopaminergic Neurogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pregnane X Receptor pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NLR Proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases activate PKNs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TNFR2 non-canonical NF-kB pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TRAIL  signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amyloid fiber formation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amino acid synthesis and interconversion (transamination)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NAD+ biosynthetic pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL-6 signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>LncRNA-mediated mechanisms of therapeutic resistance</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>tRNA modification in the mitochondrion</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Wax biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of RNA binding proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TP53 Regulates Transcription of Cell Cycle Genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metallothioneins bind metals</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PI3K-AKT-mTOR signaling pathway and therapeutic opportunities</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>T-Cell antigen Receptor (TCR) pathway during Staphylococcus aureus infection</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ESC Pluripotency Pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miR-222 in Exercise-Induced Cardiac Growth</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcription from mitochondrial promoters</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Formation of xylulose-5-phosphate</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycogen metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Plasmalogen biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional regulation by RUNX3</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of mitotic cell cycle</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RNA Polymerase III Transcription</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>LncRNA involvement in canonical Wnt signaling and colorectal cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin B12 Disorders</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Genotoxicity pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Wnt Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Inhibition of exosome biogenesis and secretion by Manumycin A in CRPC cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Thermogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ncRNAs involved in STAT3 signaling in hepatocellular carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Model for regulation of MSMP expression in cancer cells and its proangiogenic role in ovarian tumors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biosynthesis of EPA-derived SPMs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>p75 NTR receptor-mediated signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Activation of NMDA receptors and postsynaptic events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Activation of kainate receptors upon glutamate binding</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Role of Altered Glycolysation of MUC1 in Tumour Microenvironment</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Relationship between inflammation, COX-2 and EGFR</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Control of immune tolerance by vasoactive intestinal peptide</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biomarkers for urea cycle disorders</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tryptophan metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Steroid Biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Arylamine metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TCA Cycle (aka Krebs or citric acid cycle)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glutathione metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Angiogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Heart Development</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ABC-family proteins mediated transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Apoptotic execution phase</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Bile acid and bile salt metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Costimulation by the CD28 family</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eukaryotic Translation Elongation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Myogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DDX58/IFIH1-mediated induction of interferon-alpha/beta</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SRF and miRs in Smooth Muscle Differentiation and Proliferation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL-9 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Allograft Rejection</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gastric Cancer Network 1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Adipogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>B Cell Receptor Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Diclofenac Metabolic Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Apoptosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Potassium Channels</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MHC class II antigen presentation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Abacavir transport and metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SRP-dependent cotranslational protein targeting to membrane</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Erythrocytes take up carbon dioxide and release oxygen</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>WNT ligand biogenesis and trafficking</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MAP kinase activation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mammary gland development pathway - Pregnancy and lactation (Stage 3 of 4)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Bladder Cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PPAR Alpha Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Estrogen Receptor Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Differentiation of white and brown adipocyte   </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Myometrial Relaxation and Contraction Pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RAC1/PAK1/p38/MMP2 Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oncogene Induced Senescence</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>O-linked glycosylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hedgehog 'off' state</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Miscellaneous transport and binding events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by FGFR4</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Toll Like Receptor 3 (TLR3) Cascade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>BMAL1:CLOCK,NPAS2 activates circadian gene expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Caspase activation via Death Receptors in the presence of ligand</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Senescence-Associated Secretory Phenotype (SASP)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Evolocumab Mechanism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>XBP1(S) activates chaperone genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Branched-chain amino acid catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Damage/Telomere Stress Induced Senescence</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Endosomal Sorting Complex Required For Transport (ESCRT)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Photodynamic therapy-induced NFE2L2 (NRF2) survival signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hypothetical Craniofacial Development Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>tRNA processing in the mitochondrion</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-20 family signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>B-WICH complex positively regulates rRNA expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Canonical  and Non-canonical Notch signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL-4 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>H19 action Rb-E2F1 signaling and CDK-Beta-catenin activity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NO/cGMP/PKG mediated Neuroprotection</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fructose metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cellular hexose transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleotide Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Protein methylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Plasma lipoprotein assembly, remodeling, and clearance</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tryptophan catabolism leading to NAD+ production</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Statin Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TYSND1 cleaves peroxisomal proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synthesis of Lipoxins (LX)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NTRK2 (TRKB)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biosynthesis of DPA-derived SPMs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>COPI-mediated anterograde transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of transcription cofactors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Supression of HMGB1 mediated inflammation by THBD</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Molybdenum cofactor (Moco) biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell migration and invasion through p75NTR</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Major receptors targeted by epinephrine and norepinephrine</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glucuronidation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serotonin Receptor 2 and STAT3 Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Toll-like Receptor Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Integrin cell surface interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Integrin-mediated Cell Adhesion</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Peroxisomal beta-oxidation of tetracosanoyl-CoA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glucocorticoid and Mineralcorticoid Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amyotrophic lateral sclerosis (ALS)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signal Transduction of S1P Receptor</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nonsense-Mediated Decay (NMD)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Hippo</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NOTCH1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycosaminoglycan metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurotransmitter receptors and postsynaptic signal transmission</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>S Phase</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL1 and megakaryocytes in obesity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Liver X Receptor Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Selenium Metabolism and Selenoproteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nuclear Receptors in Lipid Metabolism and Toxicity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>EPH-Ephrin signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by FGFR1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases activate KTN1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synthesis, secretion, and deacylation of Ghrelin</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of polyamines</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Beta-catenin independent WNT signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MECP2 and Associated Rett Syndrome</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biochemical Pathways Part I</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Lung fibrosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NAD metabolism, sirtuins and aging</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Association Between Physico-Chemical Features and Toxicity Associated Pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Activation of anterior HOX genes in hindbrain development during early embryogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>One carbon metabolism and related pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serotonin and anxiety</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cargo recognition for clathrin-mediated endocytosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nicotinate metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Listeria monocytogenes entry into host cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by MET</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PI3K/AKT/mTOR - VitD3 Signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of Spingolipids in ER and Golgi apparatus</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pyrimidine metabolism and related diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin B6-dependent and responsive disorders</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>The effect of progerin on the involved genes in Hutchinson-Gilford Progeria Syndrome</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of RUNX2 expression and activity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G alpha (s) signalling events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Peroxisomal protein import</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glutamate binding, activation of AMPA receptors and synaptic plasticity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signal transduction through IL1R</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cysteine and methionine catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interactions between immune cells and microRNAs in tumor microenvironment</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of alpha-linolenic acid</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amino Acid Metabolism Pathway Excerpt (Histidine catabolism extension)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Mismatch Repair</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Senescence and Autophagy in Cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Type II interferon signaling (IFNG)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amino acid conjugation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Monoamine Transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serotonin Receptor 2 and ELK-SRF/GATA4 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Irinotecan Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Glucuronidation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Non-homologous end joining</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>EBV LMP1 signaling</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Estrogen signaling</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Keap1-Nrf2</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Hypothetical Network for Drug Addiction</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Methylation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Oxidative phosphorylation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Arachidonate Epoxygenase   Epoxide Hydrolase</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Metapathway biotransformation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Amino acid conjugation of benzoic acid</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway and Pluripotency</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Type II interferon signaling (IFNG)</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Apoptosis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Phase I biotransformations, non P450</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Selenium metabolism Selenoproteins</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>NLR Proteins</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Mismatch repair</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Retinol metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>ErbB signaling pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Aflatoxin B1 metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Mitochondrial Gene Expression</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Estrogen metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Polyol pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Toll-like receptor signaling pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Selenium Micronutrient Network </td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Folic Acid Network</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Signal Transduction of S1P Receptor</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Peptide GPCRs</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>IL-6 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Nuclear receptors in lipid metabolism and toxicity</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Myometrial Relaxation and Contraction Pathways</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Statin Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Nucleotide Metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Kit Receptor Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Interactions between CFTR and other ion channels</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Intracellular trafficking of CFTR</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>TNF-alpha and mucus production in lung epythelium</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>CFTR activity in the plasma membrane</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Translation Factors</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Urea cycle and metabolism of amino groups</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Adipogenesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Small Ligand GPCRs</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Oxidative Stress</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Focal Adhesion</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>VEGFR-3 signaling</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>VEGF-receptor Signal Transduction</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Genetic alterations of lung cancer</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Delta-Notch Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Serotonin and anxiety</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Brain derived neurotrophic factor</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Nuclear Receptors</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Osteoblast</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Spinal Cord Injury</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Sulindac Metabolic Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Chicken Limb Development</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Ovarian Infertility Genes</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Tryptophan metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Cytokines and Inflammatory Response (BioCarta)</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Matrix Metalloproteinases</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>mir219 in Oligodendrocyte Differentiation and Myelination</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Eicosanoid Synthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Prostaglandin Synthesis and Regulation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Glucocorticoid Metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Striated Muscle Contraction</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>IL-3 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Biogenic Amine Synthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Regulation of Actin Cytoskeleton</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>IL-1 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Acetylcholine Synthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Wnt myofibroblastic activation of Hepatic Stellate Cells</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Beta Oxidation Meta Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway NetPath</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Renin - Angiotensin System</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>GPCRs, Class B Secretin-like</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Proximal Tubule Transporters</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Thick Ascending Limb Transporters</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Angiotensin II signaling (acute) in thick ascending limbs</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Fructose Metabolism in Proximal Tubules</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Lipid Droplet Metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Hexoses metabolism in proximal tubules</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Id Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>GPCRs, Other</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Inflammatory Response Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Beta Oxidation of Unsaturated Fatty Acids</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Insulin induced PI3K-Akt and MAPK in hepatocytes</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Ethanol metabolism resulting in production of ROS by CYP2E1</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Cell cycle</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>GPCRs, Class C Metabotropic glutamate, pheromone</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Insulin Signaling</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Hypertrophy Model</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>MAPK Cascade</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>IL-5 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Vanillin and isovanillin metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>TNF-alpha NF-kB Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Glutathione metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>GPCRs, Class A Rhodopsin-like</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Alpha6-Beta4 Integrin Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation by HSP70</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Osteoclast</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Nucleotide GPCRs</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>TGF Beta Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Catecholamine synthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>mRNA Processing</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Complement and Coagulation Cascades</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>IL-2 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Cardiovascular Signaling</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Electron Transport Chain</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>EGFR1 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Cholesterol metabolism</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>p53 pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>p53 signal pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Steroid Biosynthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Insulin Signaling</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Integrin-mediated cell adhesion</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>EGFR1 Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Nuclear receptors in lipid metabolism and toxicity</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Kit Receptor Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Blood Clotting Cascade</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway and Pluripotency</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Apoptosis</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>mRNA Processing</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>NLR Proteins</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Mismatch repair</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Retinol metabolism</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Id Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Complement Activation, Classical Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Matrix Metalloproteinases</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Regulation of Actin Cytoskeleton</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Delta-Notch Signaling Pathway</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Nuclear Receptors</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Integrin-mediated cell adhesion</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Cell cycle</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>FAS pathway and Stress induction of HSP regulation</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>IL-9 Signaling Pathway</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>Signaling of Hepatocyte Growth Factor Receptor</td>
    <td>Rattus norvegicus</td>
  </tr>
  <tr>
    <td>IL-5 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of toll-like receptor signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Selenium Micronutrient Network</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nicotine Activity on Dopaminergic Neurons</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell Cycle</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eukaryotic Translation Termination</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-3, Interleukin-5 and GM-CSF signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurotransmitter release cycle</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sterol Regulatory Element-Binding Proteins (SREBP) signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell Differentiation - Index</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Retinoblastoma Gene in Cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PDGF Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sulindac Metabolic Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Primary Focal Segmental Glomerulosclerosis FSGS</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Aryl Hydrocarbon Receptor Netpath</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Elastic fibre formation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GABA synthesis, release, reuptake and degradation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Latent infection of Homo sapiens with Mycobacterium tuberculosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Collagen degradation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MyD88 dependent cascade initiated on endosome</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Activation of Matrix Metalloproteinases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by ERBB2</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by ERBB4</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MyD88 cascade initiated on plasma membrane</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mammary gland development pathway - Involution (Stage 4 of 4)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hematopoietic Stem Cell Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NRF2 pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Osteoblast Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Triacylglyceride Synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>let-7 inhibition of ES cell reprogramming</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases regulate CFTR trafficking</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RAF-independent MAPK1/3 activation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases Activate Formins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases Activate Rhotekin and Rhophilins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Photodynamic therapy-induced NF-kB survival signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Insulin signalling in human adipocytes (diabetic condition)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hepatitis C and Hepatocellular Carcinoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of Dichloroethylene by CYP450</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hypothesized Pathways in Pathogenesis of Cardiovascular Disease</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Selenoamino acid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of folate and pterines</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SALM protein interactions at the synapse</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of TP53 Activity through Methylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>rRNA processing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TGF-B Signaling in Thyroid Cells for Epithelial-Mesenchymal Transition</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cannabinoid receptor signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Canonical and Non-Canonical TGF-B signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>4-hydroxytamoxifen, Dexamethasone, and Retinoic Acids Regulation of p27 Expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Benzene metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>BMP Signaling Pathway in Eyelid Development</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Kennedy pathway from Sphingolipids</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Leptin Insulin Overlap</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serotonin and anxiety-related events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TYROBP Causal Network</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Prion disease pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interconversion of nucleotide di- and triphosphates</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eukaryotic Transcription Initiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ion channel transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PTF1A related regulatory pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>White fat cell differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GABA receptor Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional cascade regulating adipogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial complex I assembly model OXPHOS system</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Non-genomic actions of 1,25 dihydroxyvitamin D3</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>EGF/EGFR Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Class C/3 (Metabotropic glutamate/pheromone receptors)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G alpha (q) signalling events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biosynthesis of electrophilic ?-3 PUFA oxo-derivatives</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>LTF danger signal response pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ophthalmate biosynthesis in hepatocytes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gamma-Glutamyl Cycle for the biosynthesis and degradation of glutathione, including diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cancer immunotherapy by PD-1 blockade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Computational Model of Aerobic Glycolysis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Joubert Syndrome</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Genes involved in male infertility</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Urea cycle and metabolism of amino groups</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hypertrophy Model</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycolysis and Gluconeogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Complement and Coagulation Cascades</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Damage Response (only ATM dependent)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phase I biotransformations, non P450</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Target Of Rapamycin (TOR) Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MicroRNAs in cardiomyocyte hypertrophy</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fluoropyrimidine Activity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Complement cascade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Immunoregulatory interactions between a Lymphoid and a non-Lymphoid cell</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MAPK targets/ Nuclear events mediated by MAP kinases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Post-translational modification: synthesis of GPI-anchored proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Processing of Capped Intronless Pre-mRNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Rap1 signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Rho GTPases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by VEGF</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Integrated Breast Cancer Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRs in Muscle Cell Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell Differentiation - Index expanded</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL17 signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Arrhythmogenic Right Ventricular Cardiomyopathy</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Host Interactions of HIV factors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DAG and IP3 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by SCF-KIT</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MyD88-independent TLR4 cascade </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>M/G1 Transition</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Felbamate Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Proprotein convertase subtilisin/kexin type 9 (PCSK9) mediated LDL receptor degradation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Differentiation Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>eIF5A regulation in response to inhibition of the nuclear export system</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MAPK6/MAPK4 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases activate IQGAPs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RORA activates gene expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulated Necrosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NR1D1 (REV-ERBA) represses gene expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>FTO Obesity Variant Mechanism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NOTCH1 regulation of human endothelial cell calcification</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>HDR through Homologous Recombination (HRR) or Single Strand Annealing (SSA)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sulfur amino acid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>mir-124 predicted interactions with cell cycle and differentiation </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-1 Induced Activation of NF-kappa-B</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hematopoietic Stem Cell Gene Regulation by GABP alpha/beta Complex</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>EDA Signalling in Hair Follicle Development</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Prader-Willi and Angelman Syndrome</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pentose phosphate pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TBC/RABGAPs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phase I - Functionalization of compounds</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Intestinal infectious diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fatty acyl-CoA biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biosynthesis and regeneration of tetrahydrobiopterin (BH4) and catabolism of phenylalanine, including diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mevalonate arm of cholesterol biosynthesis pathway with inhibitors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ebola Virus Pathway on Host</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Thiamine metabolic pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Non-homologous end joining</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NGF processing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Integrin alphaIIb beta3 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Acetylcholine binding and downstream events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GABA receptor activation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Resistin as a regulator of inflammation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fragile X Syndrome </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Canonical NF-KB pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gastrin Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eicosanoid metabolism via Lipo Oxygenases (LOX)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Omega-3/Omega-6 FA synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sphingolipid Metabolism (general overview)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway Netpath</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cytokines and Inflammatory Response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tamoxifen metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Prostaglandin Synthesis and Regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Electron Transport Chain (OXPHOS system in mitochondria)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GPCRs, Other</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sphingolipid pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Globo Sphingolipid Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serotonin Transporter Activity</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Physiological and Pathological Hypertrophy  of the Heart</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Intrinsic Pathway for Apoptosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NCAM signaling for neurite out-growth</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Platelet Adhesion to exposed collagen</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Platelet Aggregation (Plug Formation)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Platelet homeostasis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transport of glycerol from adipocytes to the liver by Aquaporins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transmission across Electrical Synapses </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL-1 signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SREBF and miR33 in cholesterol and lipid homeostasis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Parkinsons Disease Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Dopamine metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TCA Cycle and Deficiency of Pyruvate Dehydrogenase complex (PDHc)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NAD Biosynthesis II (from tryptophan)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nanoparticle triggered autophagic cell death</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gastrin-CREB signalling pathway via PKC and MAPK</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by NODAL</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of cholesterol biosynthesis by SREBP (SREBF)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RAF/MAP kinase cascade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Degradation of beta-catenin by the destruction complex</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pre-NOTCH Expression and Processing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Assembly of collagen fibrils and other multimeric structures</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DDX1 as a regulatory component of the Drosha microprocessor</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Resolution of Abasic Sites (AP sites)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TNFs bind their physiological receptors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SIRT1 negatively regulates rRNA expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases activate CIT</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ovarian Infertility Genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Preimplantation Embryo</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>FasL/ CD95L signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>HDR through MMEJ (alt-NHEJ)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>trans-Golgi Network Vesicle Budding</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amplification and Expansion of Oncogenic Pathways as Metastatic Traits</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Striated Muscle Contraction</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Threonine catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of DNA replication proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of transcription factors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MAPK  and NFkB Signalling Pathways Inhibited by Yersinia YopJ</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Novel intracellular components of RIG-I-like receptor (RLR) pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PPAR signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ethanol effects on histone modifications</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synaptic adhesion-like molecules</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>E3 ubiquitin ligases ubiquitinate target proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glucose metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Collagen chain trimerization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Chromatin organization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Deubiquitination</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Lactose synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-6 family signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fibrin Complement Receptor 3 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurotransmitter Disorders</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Disorders of Folate Metabolism and Transport</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pancreatic adenocarcinoma pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Methionine metabolism leading to Sulphur Amino Acids and related disorders</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Viral Acute Myocarditis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Rett syndrome causing genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ciliary landscape</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of intracellular receptors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of ubiquitinylation proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Classical pathway of steroidogenesis, including diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synaptic signaling pathways associated with autism spectrum disorder</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Overview of leukocyte-intrinsic Hippo pathway functions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Translation inhibitors in chronically activated PDGFRA cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Blood clotting and drug effects</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glucose Homeostasis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Estrogen metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sudden Infant Death Syndrome (SIDS) Susceptibility Pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin A and Carotenoid Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRNA Regulation of DNA Damage Response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRNAs involved in DNA damage response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Codeine and Morphine Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation and Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cholesterol biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Damage Bypass</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nephrin family interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Netrin-1 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signal regulatory protein family interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Thrombin signalling through proteinase activated receptors (PARs)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transport of bile salts and organic acids, metal ions and amine compounds</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Follicle Stimulating Hormone (FSH) signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Pathogenic Escherichia coli infection</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Trans-sulfuration pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Small Ligand GPCRs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neurotoxicity of clostridium toxins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Meiotic recombination</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ubiquinol biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of steroid hormones</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional regulation of white adipocyte differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitotic Telophase/Cytokinesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Visual phototransduction</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sphingolipid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL-3 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Focal Adhesion</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling of Hepatocyte Growth Factor Receptor</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial translation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by FGFR3</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GPCRs, Class B Secretin-like</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases activate PAKs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Uptake and function of diphtheria toxin</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sialic acid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mismatch Repair</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Base-Excision Repair, AP Site Formation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hedgehog ligand biogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nonhomologous End-Joining (NHEJ)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cytosine methylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MicroRNA for Targeting Cancer Growth and Vascularization in Glioblastoma</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miR-517 relationship with ARCN1 and USP1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NAD+ metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Wnt/beta-catenin Signaling Pathway in Leukemia</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of chromatin organization proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ERK Pathway in Huntington's Disease</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Development of pulmonary dendritic cells and macrophage subsets</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miR-509-3p alteration of YAP1/ECM axis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Role of Osx and miRNAs in tooth development</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRNA regulation of prostate cancer signaling pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gene and protein expression by JAK-STAT signaling after Interleukin-12 stimulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>mRNA Processing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cilium Assembly</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Processing of SMDT1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Wnt Signaling in Kidney Disease</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mevalonate arm of cholesterol biosynthesis pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Phosphatidylcholine catabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Tumor suppressor activity of SMARCB1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hereditary leiomyomatosis and renal cell carcinoma pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hedgehog Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Non-small cell lung cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Bile Acids synthesis and enterohepatic circulation </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oxidation by Cytochrome P450</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G alpha (z) signalling events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G-protein beta:gamma signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of DNA methylation proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional Regulation by MECP2</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Genes related to primary cilium development (based on CRISPR)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oxysterols derived from cholesterol</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biomarkers for pyrimidine metabolism disorders</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eicosanoid metabolism via Cyclo Oxygenases (COX)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Eicosanoid metabolism via Cytochrome P450 Mono-Oxygenases (CYP) pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycerolipids and Glycerophospholipids</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Endochondral Ossification</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amino acid conjugation of benzoic acid</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ID signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Biogenic Amine Synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Polyol Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Damage Response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Bone Morphogenic Protein (BMP) Signalling and Regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycine Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin D Metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Insulin-like Growth Factor-2 mRNA Binding Proteins (IGF2BPs/IMPs/VICKZs) bind RNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Dissolution of Fibrin Clot</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-1 processing</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-1 family signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>mRNA Capping</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleosome assembly</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>IL-7 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Thymic Stromal LymphoPoietin (TSLP) Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RalA downstream regulated genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>miRNA Biogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Spinal Cord Injury</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Secretion of Hydrochloric Acid in Parietal Cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Erythrocytes take up oxygen and release carbon dioxide</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fertilization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fcgamma receptor (FCGR) dependent phagocytosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metabolism of Angiotensinogen to Angiotensins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Meiotic synapsis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ATF4 activates genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Binding and Uptake of Ligands by Scavenger Receptors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Syndecan interactions</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Farnesoid X Receptor  Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oxytocin signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fas Ligand (FasL) pathway and Stress induction of Heat Shock Proteins (HSP) regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Melatonin metabolism and effects</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Dual hijack model of Vif in HIV infection</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>POU5F1 (OCT4), SOX2, NANOG repress genes related to differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fanconi Anemia Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Class I MHC mediated antigen processing & presentation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Human metabolism overview</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Photodynamic therapy-induced AP-1 survival signaling.</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Photodynamic therapy-induced HIF-1 survival signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Insulin signalling in human adipocytes (normal condition)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway (Netpath)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of Wnt/B-catenin Signaling by Small Molecule Compounds</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin D (calciferol) metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ERCC6 (CSB) and EHMT2 (G9a) positively regulate rRNA expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TP53 Regulates Transcription of Cell Death Genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RNA polymerase II transcribes snRNA genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of TP53 Activity through Phosphorylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Striated Muscle Contraction Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Valproic acid pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ATR Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>BMP2-WNT4-FOXO1 Pathway in Human Primary Endometrial Stromal Cell Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Import of palmitoyl-CoA into the mitochondrial matrix</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RAB GEFs exchange GTP for GDP on RABs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Reelin signalling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional regulation by the AP-2 (TFAP2) family of transcription factors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Deregulated CDK5 triggers multiple neurodegenerative pathways in Alzheimer's disease models</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Neddylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GHB metabolic pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ethanol metabolism resulting in production of ROS by CYP2E1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Lamin A-processing pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-9 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>G alpha (i) signalling events</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Serine biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PI3K Cascade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glycosylation and related congenital defects</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MFAP5 effect on permeability and motility of endothelial cells via cytoskeleton rearrangement</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hepatitis B infection</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of Actin Cytoskeleton</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Complement Activation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ErbB Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Arylamine metabolism</td>
    <td>Equus caballus</td>
  </tr>
  <tr>
    <td>Metapathway biotransformation</td>
    <td>Equus caballus</td>
  </tr>
  <tr>
    <td>Phase I biotransformations, non P450</td>
    <td>Equus caballus</td>
  </tr>
  <tr>
    <td>Aflatoxin B1 metabolism</td>
    <td>Equus caballus</td>
  </tr>
  <tr>
    <td>Polyol pathway</td>
    <td>Equus caballus</td>
  </tr>
  <tr>
    <td>Insulin Signaling</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Heme Biosynthesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>IL-5 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Striated Muscle Contraction</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Small Ligand GPCRs</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Eicosanoid Synthesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>IL-2 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>IL-9 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>IL-6 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>EGFR1 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Nuclear receptors in lipid metabolism and toxicity</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Hypertrophy Model</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Alpha6-Beta4 Integrin Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Estrogen Signaling</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Adipogenesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Keap1-Nrf2</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Hypothetical Network for Drug Addiction</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Oxidative phosphorylation</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>EPO Receptor Signaling</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Peptide GPCRs</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Electron Transport Chain</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Kit Receptor Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Osteoclast</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>MAPK Cascade</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway and Pluripotency</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>T Cell Receptor Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>IL-7 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Androgen Receptor Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Wnt Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Apoptosis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>One Carbon Metabolism</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Glycolysis and Gluconeogenesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Selenium metabolism Selenoproteins</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>IL-3 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>NLR Proteins</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>p38 MAPK Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Calcium Regulation in the Cardiac Cell</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>ErbB Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Transformation Growth Factor (TGF) beta Receptor Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>TNF-alpha NF-kB Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>G Protein Signaling Pathways</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Oxidative Stress</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>GPCRs, Class C Metabotropic glutamate, pheromone</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Id Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Polyol pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>IL-4 signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Regulation of Actin Cytoskeleton</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>G13 Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Delta-Notch Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Endochondral Ossification</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Toll-like receptor signaling pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Integrin-mediated cell adhesion</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Cholesterol Biosynthesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Monoamine GPCRs</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Signal Transduction of S1P Receptor</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Apoptosis Modulation by HSP70</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Cell cycle</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Neurotransm. release in cholinergic motor neurons</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Cell Division: First embryonic mitosis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Metapathway UDP-glucuronosyltransferases</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Valine, leucine and isoleucine degradation</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Vulval development</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Photosynthetic Carbon Reduction</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>TOR signaling</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation 2</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Carbon assimilation C4 pathway</td>
    <td>Zea mays</td>
  </tr>
  <tr>
    <td>Hedgehog-related genes</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>FGF signaling pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Flavonoid Biosynthesis</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Metapathway Signal Transduction</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Biogenic Amine Synthesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Glycolysis and Gluconeogenesis</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Histidine metabolism</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Ascorbate and aldarate metabolism</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Biotin metabolism</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>D-Arginine and D-ornithine metabolism</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Fructose and mannose metabolism</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Lipoic acid metabolism</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Mechanosensory inputs influence pharyngeal activity via ivermectin sensitivity genes.</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>daf-2 or insulin signaling pathway</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Linoleate Biosynthesis</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation Meta</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Flower Development (Initiation)</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>BMP signaling pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Triacylglyceride Synthesis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Noncanonical Wnt Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Flowering Time Pathway</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Seed Development </td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Lycopene biosynthesis</td>
    <td>Zea mays</td>
  </tr>
  <tr>
    <td>Carotenoid Biosynthesis</td>
    <td>Zea mays</td>
  </tr>
  <tr>
    <td>Beta-alanine Biosynthesis</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Cardiolipin Biosynthesis</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Momilactone Biosynthesis</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Oryzalexin S biosynthesis</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Geranylgeranyldiphosphate biosynthesis II (plastidic)</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Methylerythritol phosphate pathway</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Notch signaling in Vulval Development</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>EGF Signaling in Vulval Development</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Wnt Signaling in Cell Polarity</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Ascaroside Biosynthesis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Cell engulfment</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Heterochronic gene regulation of development</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Left/Right Asymmetry in the Nervous System</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Chlorophyll b Degradation</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Regulation of immune response in the intestine</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Seed Development</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Biosynthesis and regulation of nematode bile acids</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Aging</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Vitamin B9 (folate) biosynthesis pathway</td>
    <td>Zea mays</td>
  </tr>
  <tr>
    <td>Heterchronic control of molting</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>TCA cycle</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Transcription initiation by Sigma factors</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Glyoxylate cycle</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>ER Stress-Unfolded Protein Response (UPRer)</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Cadmium and glutathione</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Glycolysis</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Starch Metabolism</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Sucrose Metabolism</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>TCA Cycle (Krebs Cycle)</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>ABA Biosynthesis</td>
    <td>Solanum lycopersicum</td>
  </tr>
  <tr>
    <td>Gluconeogenesis</td>
    <td>Solanum lycopersicum</td>
  </tr>
  <tr>
    <td>Superpathway of pyridoxal 5'-phosphate biosynthesis and salvage</td>
    <td>Solanum lycopersicum</td>
  </tr>
  <tr>
    <td>Pto kinase mediated signaling pathway leading to the oxidative burst in tomato</td>
    <td>Solanum lycopersicum</td>
  </tr>
  <tr>
    <td>Brassinolide biosynthetic pathway</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>The Glyoxylate, Anapleurotic and Succinyl CoA (GAS) pathway</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>Ethylene signaling pathway</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Primary Carbon Metabolism</td>
    <td>Populus trichocarpa</td>
  </tr>
  <tr>
    <td>Calvin cycle</td>
    <td>Populus trichocarpa</td>
  </tr>
  <tr>
    <td>Chloroplast electron transport chain</td>
    <td>Populus trichocarpa</td>
  </tr>
  <tr>
    <td>Glycolysis</td>
    <td>Populus trichocarpa</td>
  </tr>
  <tr>
    <td>Krebs cycle</td>
    <td>Populus trichocarpa</td>
  </tr>
  <tr>
    <td>Wnt Signaling - Q neuroblast migration</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Role of lipid metabolism in C. elegans</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Isoprenoid Precursor Biosynthesis in Pf apicoplasts</td>
    <td>Plasmodium falciparum</td>
  </tr>
  <tr>
    <td>Polar Auxin Transport</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Polar Auxin Transport</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Cytokinin signaling</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Cytokinin-Auxin interactions in plant development</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>UDP-L-arabinose Biosynthesis I (from UDP-xylose)</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Pentose Phosphate Pathway</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Nodal Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Flavonoid pathway</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>AtMetExpress overview</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Intercellular Auxin Transport</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Crystal Toxin Triggered Necrosis Pathway</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Genetic Interactions Between Sugar and Hormone Signaling</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Phytochrome Signalling Pathway to Turn On Photomorphogenesis</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Programmed Cell Death</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Glucouse Sensing and Signaling in Arabidopsis</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Copper homeostasis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Effect of L-carnitine on metabolism</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>PPAR Signaling Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Model of Fgf and Wnt crosstalk in tailbud </td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>ERK1 - ERK2 MAPK cascade</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>biosynthesis of the three types of mycolic acids</td>
    <td>Mycobacterium tuberculosis</td>
  </tr>
  <tr>
    <td>CRD motif and sFRPs influence on Wnt signaling</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Biosynthesis of gamma-Aminobutyric Acid (GABA) by Polyamine Oxidation</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Synthesis and Degradation of Ketone Bodies</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Biotic  Stress-response gene-network in rice </td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Glycogen Metabolism</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Signaling of Hepatocyte Growth Factor Receptor</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>G1 to S cell cycle control</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>DNA Replication</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Glucosinolate biosynthesis (from methionine)</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Glucosinolate biosynthesis (from aromatic amino acid)</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Glucosinolate biosynthesis (from branched-chain amino acid)</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>mRNA processing</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>ACE Inhibitor Pathway</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Proteasome Degradation</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Beta Oxidation of Unsaturated Fatty Acids</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Acetylcholine Synthesis</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Mitochondrial LC-Fatty Acid Beta-Oxidation</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Fatty Acid Beta Oxidation 3</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>FAS pathway and Stress induction of HSP regulation</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Cytoplasmic Ribosomal Proteins</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Neural crest development</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Exercise-induced Circadian Regulation</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Canonical wnt signaling</td>
    <td>Danio rerio</td>
  </tr>
  <tr>
    <td>Dauer formation</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Ureide biosynthesis</td>
    <td>Oryza sativa</td>
  </tr>
  <tr>
    <td>Flower Development</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Long-Day Flowering Time Pathway</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Abscisic Acid Biosynthesis</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Triacylglycerol Biosynthesis</td>
    <td>Arabidopsis thaliana</td>
  </tr>
  <tr>
    <td>Vulval Development and SynMuv</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Mismatch repair</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Homologous recombination</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>TCA Cycle</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>FAS pathway and Stress induction of HSP regulation</td>
    <td>Gallus gallus</td>
  </tr>
  <tr>
    <td>Glycolysis</td>
    <td>Caenorhabditis elegans</td>
  </tr>
  <tr>
    <td>Matrix Metalloproteinases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleotide-binding Oligomerization Domain (NOD) pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Osteopontin Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nicotine Activity on Chromaffin Cells</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TP53 Network</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Asparagine N-linked glycosylation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Processing of Capped Intron-Containing Pre-mRNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cori Cycle</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleotide Excision Repair</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TNF related weak inducer of apoptosis (TWEAK) Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Alzheimers Disease</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synaptic Vesicle Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TNF alpha Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-11 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cardiac Progenitor Differentiation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Common Pathways Underlying Drug Addiction</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Arachidonic acid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vasopressin regulates renal water homeostasis via Aquaporins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-7 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Notch Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Peptide hormone biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Toll-like Receptor Cascades</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>exRNA mechanism of action and biogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mammary gland development pathway - Puberty (Stage 2 of 4)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Apoptosis-related network due to altered Notch3 in ovarian cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TCA Cycle Nutrient Utilization and Invasiveness of Ovarian Cancer</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interactome of polycomb repressive complex 2 (PRC2) </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Overview of nanoparticle effects</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MFAP5-mediated ovarian cancer cell motility and invasiveness</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>SUMOylation of DNA damage response and repair proteins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by Leptin</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RHO GTPases Activate NADPH Oxidases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Assembly of the primary cilium</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA Double Strand Break Response</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Amine-derived hormones</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Imatinib and Chronic Myeloid Leukemia</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>BDNF-TrkB Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Major pathway of rRNA processing in the nucleolus and cytosol</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-17 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MAPK Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Chemokine signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Focal Adhesion-PI3K-Akt-mTOR-signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Oxidative Damage</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>DNA IR-damage and cellular response via ATR</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial Fatty Acid Beta-Oxidation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PTEN Regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Lipid particle organization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of TLR by endogenous ligand</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>rRNA modification in the mitochondrion</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Aryl hydrocarbon receptor signalling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamin E</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>The human immune response to tuberculosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Chromosomal and microsatellite instability in colorectal cancer </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Acrylamide Biotransformation and Exposure Biomarkers</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of sister chromatid separation at the metaphase-anaphase transition</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Vitamins A and D - action mechanisms</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Class B/2 (Secretin family receptors)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cells and Molecules involved in local acute inflammatory response </td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Selective expression of chemokine receptors during T-cell polarization</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>The alternative pathway of fetal androgen synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcription co-factors SKI and SKIL protein partners</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Urea cycle and associated pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Omega-9 FA synthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sphingolipid Metabolism (integrated pathway)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Notch Signaling Pathway Netpath</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>T-Cell antigen Receptor (TCR)  Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nucleotide GPCRs</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Translation Factors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Osteoclast Signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Type II diabetes mellitus</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nuclear Receptors</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cell surface interactions at the vascular wall</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Peroxisomal lipid metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Synthesis of DNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transport of inorganic cations/anions and amino acids/oligopeptides</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transport of vitamins, nucleosides, and related molecules</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Human Thyroid Stimulating Hormone (TSH) signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Leptin signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Endothelin Pathways</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Brain-Derived Neurotrophic Factor (BDNF) signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Alpha 6 Beta 4 signaling pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Nanoparticle-mediated activation of receptor signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Lidocaine metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TAK1 activates NFkB by phosphorylation and activation of IKKs complex</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Growth hormone receptor signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>ISG15 antiviral mechanism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Incretin synthesis, secretion, and inactivation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Regulation of mRNA stability by proteins that bind AU-rich elements</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Inositol phosphate metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Gamma carboxylation, hypusine formation and arylsulfatase activation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Reversible hydration of carbon dioxide</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Translocation of SLC2A4 (GLUT4) to the plasma membrane</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hair Follicle Development: Cytodifferentiation (Part 3 of 3)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NoRC negatively regulates rRNA expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>PRC2 methylates histones and DNA</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial biogenesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>POU5F1 (OCT4), SOX2, NANOG activate genes related to proliferation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Signaling by FGFR2</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Uptake and function of anthrax toxins</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Initiation of transcription and translation elongation at the HIV-1 LTR</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Abnormal conversion of 2-oxoglutarate to 2-hydroxyglutarate</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Cargo concentration in the ER</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Surfactant metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Fatty Acid Biosynthesis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sleep regulation</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>TP53 Regulates Transcription of DNA Repair Genes</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Simplified Depiction of MYD88 Distinct Input-Output Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>VEGFA-VEGFR2 Signaling Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Mitochondrial Gene Expression</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Leptin and adiponectin</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Lipid Metabolism Pathway</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>NADPH regeneration</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>HSP90 chaperone cycle for steroid hormone receptors (SHR)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-10 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RNA Polymerase I Transcription</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RUNX1 and FOXP3 control the development of regulatory T lymphocytes (Tregs)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Antimicrobial peptides</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Transcriptional regulation by RUNX1</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Protein ubiquitination</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>RUNX1 regulates genes involved in megakaryocyte differentiation and platelet function</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Hormonal control of Pubertal Growth Spurt</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>MAPK Cascade</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Ferroptosis</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Interleukin-15 signaling</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Class A/1 (Rhodopsin-like receptors)</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Carnosine's role in muscle contraction</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Intraflagellar transport proteins binding to dynein</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Urea cycle and related diseases</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>GPCRs, Class C Metabotropic glutamate, pheromone</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Sulfation Biotransformation Reaction</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Benzo(a)pyrene metabolism</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Metapathway biotransformation Phase I and II</td>
    <td>Homo sapiens</td>
  </tr>
  <tr>
    <td>Glutamate degradation VII</td>
    <td>Saccharomyces cerevisiae</td>
  </tr>
</table>
