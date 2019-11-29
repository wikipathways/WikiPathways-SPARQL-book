TARGETS := intro.md

all: ${TARGETS}
	@mv ${TARGETS} docs/

%.md : %.i.md createMarkdown.groovy
	@echo "Creating $@"
	@groovy createMarkdown.groovy $< > $@

