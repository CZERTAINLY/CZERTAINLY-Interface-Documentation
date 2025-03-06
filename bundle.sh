for file in ./openapi/*.yaml
do
  redocly build-docs ./"$file" -o ./"${file/yaml/html}"
done
