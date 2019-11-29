TARGETS := index.md

all: ${TARGETS}
	@mv ${TARGETS} docs/
	@cp sparql/*.code.md docs/.

%.md : %.i.md createMarkdown.groovy
	@echo "Creating $@"
	@groovy createMarkdown.groovy $< > $@

