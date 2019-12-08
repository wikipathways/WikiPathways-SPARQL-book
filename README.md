# WikiPathways SPARQL Book

This repository contains the pre-Markdown sources of a book detailing
everything you can do with SPARQL in WikiPathways, as well as the
compiled Markdown sources.

## Requirements

- Groovy
- nodejs
- citation-js (see doi:[10.7717/peerj-cs.214](https://doi.org/10.7717/peerj-cs.214))
- make
- curl (optional, but handy)

## Install

The requirements can be installed on Debian GNU/Linux with:

```shell
sudo apt install groovy make nodejs curl
npm install citation-js
```

## Compile

```shell
cd sparql
make
cd ..
make
```

The website makes use of GitHub pages, and GitHub automatically converts
the `.md` files in the `docs/` folder to HTML when you push to the repository.

## Adding content

1. develop a new SPARQL query (and test it)
2. create a new `.rq` file in the `sparql/` folder
3. add content to one of the `.i.md` files and embed the SPARQL
   with the instruction `<sparql>foo</sparql>` for the `sparql/foo.rq` query
4. compile the code (see above)
5. make a pull request

### Pre-Markdown instructions

The following instructions can be used in the `.i.md` files:

- `<topic></topic>` to mark a word or term as topic, making it appear in the
  [indexList](docs/indexList.md)
- `<sparql></sparql>` on a single line embeds the SPARQL query at that position
- `<cite></cite>` for adding a reference, using the Wikidata Q-identifier for
  that paper (or book or ...)
