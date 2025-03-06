for file in ./openapi/*.yaml
do
  redocly lint ./"$file"
done
