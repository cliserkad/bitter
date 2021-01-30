# Don't ever ask me to explain this... I don't know
printf "Aggregating git commit messages:\n\n"
export CHANGES=$(git log --pretty=format:"%s" $(git describe --tags --abbrev=0 @^)..@ --no-merges | sed -e :1 -e 's/\([.?!]\)[[:blank:]]\{1,\}\([^[:blank:]]\)/\1\n\2/;t1')
printenv CHANGES
