status=0

for file in ./openapi/*.yaml;
do
  redocly lint ./"$file" || status=1
done

exit $status
