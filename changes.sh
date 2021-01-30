# Don't ever ask me to explain this... I don't know
printf "Aggregating git commit messages:\n\n"

rm change.log

printf "Since last tag:\n" >> change.log
printf "$(git log --pretty=format:"%s" $(git describe --tags --abbrev=0 @^)..@ --no-merges | sed -e :1 -e 's/\([.?!]\)[[:blank:]]\{1,\}\([^[:blank:]]\)/\1\n\2/;t1')" | sed -e 's/^/\t/' >> change.log
printf "\n\n" >> change.log
printf "Last 10 changes:\n" >> change.log
printf "$(git log --pretty=format:"%s" -10 --no-merges | sed -e :1 -e 's/\([.?!]\)[[:blank:]]\{1,\}\([^[:blank:]]\)/\1\n\2/;t1')" | sed -e 's/^/\t/' >> change.log
export CHANGES=$(cat change.log)

printenv CHANGES