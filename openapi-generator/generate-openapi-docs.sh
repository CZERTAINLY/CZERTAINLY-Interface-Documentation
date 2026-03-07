#!/bin/bash
set -e

# Script to generate OpenAPI YAML files for all groups defined in groups.yaml
# Arguments:
#   $1 - Path to groups.yaml
#   $2 - Server port
#   $3 - Output directory

GROUPS_YAML="$1"
SERVER_PORT="$2"
OUTPUT_DIR="$3"

if [ ! -f "$GROUPS_YAML" ]; then
    echo "Error: groups.yaml not found at $GROUPS_YAML"
    exit 1
fi

echo "Generating OpenAPI documentation files..."
echo "Groups config: $GROUPS_YAML"
echo "Server port: $SERVER_PORT"
echo "Output directory: $OUTPUT_DIR"
echo ""

# Parse groups.yaml using pure bash (no Python/yq dependencies)
# Extract group entries between "groups:" and "common:" sections

# Check if groups section exists
if ! grep -q "^groups:" "$GROUPS_YAML"; then
    echo "Error: No 'groups:' section found in $GROUPS_YAML"
    exit 1
fi

# Check if the output directory exists, if not create it
if [ ! -d "$OUTPUT_DIR" ]; then
    mkdir -p "$OUTPUT_DIR"
fi

# Function to process a single group
process_group() {
    local id="$1"
    local name="$2"
    
    local url="http://localhost:${SERVER_PORT}/v3/api-docs.yaml/${name}"
    local output_file="${OUTPUT_DIR}/${id}.yaml"

    echo "Generating $id from $url..."

    
    # Download OpenAPI YAML using curl
    if curl -s -f -o "$output_file" "$url"; then
        echo "  ✓ Generated: $output_file"
        return 0
    else
        echo "  ✗ Failed to generate $id" >&2
        echo "    URL: $url" >&2
        echo "    Check if Spring Boot application is running on port $SERVER_PORT" >&2
        return 1
    fi
}

# Extract the groups section (between "groups:" and "common:")
groups_section=$(sed -n '/^groups:/,/^common:/p' "$GROUPS_YAML" | sed '$d')

# Parse each group entry
group_count=0
current_id=""
current_name=""
failed=0

while IFS= read -r line; do
    # Skip empty lines and the "groups:" header
    if [[ -z "$line" ]] || [[ "$line" =~ ^groups: ]]; then
        continue
    fi
    
    # Detect new group entry (starts with "  - id:")
    if [[ "$line" =~ ^[[:space:]]*-[[:space:]]+id:[[:space:]]*(.+)$ ]]; then
        # Process previous group if we have one
        if [[ -n "$current_id" ]] && [[ -n "$current_name" ]]; then
            if process_group "$current_id" "$current_name"; then
                ((group_count++))
            else
                ((failed++))
            fi
        fi
        
        # Start new group
        current_id="${BASH_REMATCH[1]}"
        current_name=""
        
    # Extract groupName
    elif [[ "$line" =~ ^[[:space:]]+groupName:[[:space:]]*(.+)$ ]]; then
        current_name="${BASH_REMATCH[1]}"
    fi
done <<< "$groups_section"

# Process last group
if [[ -n "$current_id" ]] && [[ -n "$current_name" ]]; then
    if process_group "$current_id" "$current_name"; then
        ((group_count++))
    else
        ((failed++))
    fi
fi

echo ""
if [[ $failed -gt 0 ]]; then
    echo "Failed to generate $failed OpenAPI documentation file(s)"
    exit 1
fi

echo "Successfully generated $group_count OpenAPI documentation files"
echo "OpenAPI documentation generation complete!"
