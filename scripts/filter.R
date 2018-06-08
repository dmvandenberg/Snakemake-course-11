#!/usr/bin/env Rscript
args = commandArgs(trailingOnly=TRUE)

mygene <- read.delim(file=args[1], header=TRUE, sep = '\t')
sequences <- read.delim(file=args[2], header=TRUE, sep = '\t')
pm.ids <- read.delim(file=args[3], header=TRUE, sep = '\t')
pathways <- read.delim(file=args[4], header=TRUE, sep = '\t')

report <- subset(mygene,select= -c(X_score,X_id))
report <- merge(report, sequences, by="query")
report <- merge(report, pm.ids, by="query")
report <- merge(report, pathways, by="query")

levels(report$pubmed) <- c(levels(report$pubmed), NA)
report$pubmed[report$pubmed=="[]"] <- NA

report <- report[,c(1,6,4,9,8,10,3,7,2,5)]
print(colnames(report))

write.table(report, file = args[5], row.names = FALSE, na = "", sep = '\t', quote = FALSE)


