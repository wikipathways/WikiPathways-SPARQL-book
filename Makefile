SOURCES := intro.i.md index.i.md
TARGETS := intro.md

all: ${TARGETS} index.md
	@mv ${TARGETS} docs/
	@cp sparql/*.code.md docs/sparql/

toc.txt: makeToC.groovy order.txt ${SOURCES}
	@echo "Making the ToC"
	@groovy makeToC.groovy > toc.txt

index.md: index.i.md toc.txt createMarkdown.groovy
	@echo "Creating $@"
	@groovy createMarkdown.groovy index.i.md > docs/index.md

%.md : %.i.md createMarkdown.groovy
	@echo "Creating $@"
	@groovy createMarkdown.groovy $< > $@

