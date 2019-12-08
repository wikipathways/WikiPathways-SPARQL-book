# WikiPathways SPARQL Book

This repository contains the pre-Markdown sources of a book detailing
everything you can do with SPARQL in WikiPathways, as well as the
compiled Markdown sources.

## Requirements

- Groovy
- nodejs
- citation-js
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
