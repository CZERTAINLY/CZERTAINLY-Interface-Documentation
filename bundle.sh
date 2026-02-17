for file in ./openapi/*.yaml
do
  redocly build-docs ./"$file" -o ./"${file/yaml/html}" --config=redocly-theme.yaml
done
