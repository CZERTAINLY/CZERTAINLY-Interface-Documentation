package com.czertainly.openapi.codegen;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Handles type resolution and import management for generated code.
 * Detects naming conflicts when multiple classes share the same simple name
 * and determines when to use fully qualified names.
 */
public class TypeResolver {

    private final Set<String> conflictingNames;
    private final Set<String> imports;

    public TypeResolver(Class<?> interfaceClass) {
        Map<String, Set<Class<?>>> simpleNameToClasses = buildSimpleNameMap(interfaceClass);
        this.conflictingNames = detectConflicts(simpleNameToClasses);
        this.imports = collectImports(interfaceClass);
    }

    /**
     * Returns the set of import statements (fully qualified names) needed for the generated class.
     * Excludes imports for conflicting names (which will use FQN inline).
     */
    public Set<String> getNonConflictingImports() {
        Set<String> result = new LinkedHashSet<>();
        for (String imp : imports) {
            String simpleName = getSimpleName(imp);
            if (!conflictingNames.contains(simpleName)) {
                result.add(imp);
            }
        }
        return result;
    }

    /**
     * Gets the appropriate type name to use in generated code.
     * Returns simple name for non-conflicting types, fully qualified name for conflicting types.
     */
    public String getTypeName(Class<?> type) {
        if (type.isArray()) {
            return getTypeName(type.getComponentType()) + "[]";
        }

        String simpleName = type.getSimpleName();
        
        // Use fully qualified name if there's a conflict
        if (conflictingNames.contains(simpleName)) {
            return type.getName().replace('$', '.');
        }

        return simpleName;
    }

    /**
     * Builds a map from simple class names to their fully qualified Class objects
     * for all types used in the interface methods.
     */
    private Map<String, Set<Class<?>>> buildSimpleNameMap(Class<?> interfaceClass) {
        Map<String, Set<Class<?>>> map = new HashMap<>();

        for (Method method : interfaceClass.getMethods()) {
            if (isObjectMethod(method)) {
                continue;
            }

            addClassToMap(map, method.getReturnType());
            
            for (Parameter param : method.getParameters()) {
                addClassToMap(map, param.getType());
            }

            for (Class<?> exception : method.getExceptionTypes()) {
                addClassToMap(map, exception);
            }
        }

        return map;
    }

    /**
     * Adds a class and its component type (if array) to the simple name map.
     */
    private void addClassToMap(Map<String, Set<Class<?>>> map, Class<?> type) {
        if (type.isPrimitive()) {
            return;
        }
        
        if (type.isArray()) {
            addClassToMap(map, type.getComponentType());
            return;
        }

        if (shouldImportType(type)) {
            String simpleName = type.getSimpleName();
            map.computeIfAbsent(simpleName, k -> new HashSet<>()).add(type);
        }
    }

    /**
     * Detects class names that have multiple different fully qualified names.
     * Returns a set of simple names that have conflicts.
     */
    private Set<String> detectConflicts(Map<String, Set<Class<?>>> simpleNameToClass) {
        Set<String> conflicts = new HashSet<>();

        for (Map.Entry<String, Set<Class<?>>> entry : simpleNameToClass.entrySet()) {
            if (entry.getValue().size() > 1) {
                conflicts.add(entry.getKey());
            }
        }

        return conflicts;
    }

    /**
     * Collects all imports needed for the interface implementation.
     */
    private Set<String> collectImports(Class<?> interfaceClass) {
        Set<String> result = new LinkedHashSet<>();

        for (Method method : interfaceClass.getMethods()) {
            if (isObjectMethod(method)) {
                continue;
            }

            addImportForType(result, method.getReturnType());
            
            for (Parameter param : method.getParameters()) {
                addImportForType(result, param.getType());
            }

            for (Class<?> exception : method.getExceptionTypes()) {
                addImportForType(result, exception);
            }
        }

        return result;
    }

    /**
     * Adds import for a type if it's not a primitive or java.lang type.
     */
    private void addImportForType(Set<String> imports, Class<?> type) {
        if (type.isPrimitive()) {
            return;
        }
        
        if (type.isArray()) {
            addImportForType(imports, type.getComponentType());
            return;
        }

        if (shouldImportType(type)) {
            imports.add(type.getName().replace('$', '.'));
        }
    }

    /**
     * Determines if a type should be imported (not primitive, array, or java.lang).
     */
    private boolean shouldImportType(Class<?> type) {
        if (type.isPrimitive() || type.isArray()) {
            return false;
        }
        
        String packageName = type.getPackage() != null ? type.getPackage().getName() : "";
        return !packageName.isEmpty() && !packageName.equals("java.lang");
    }

    /**
     * Checks if a method is declared in the Object class.
     */
    private boolean isObjectMethod(Method method) {
        return method.getDeclaringClass().equals(Object.class);
    }

    /**
     * Extracts a simple name from a fully qualified name.
     */
    private String getSimpleName(String fullyQualifiedName) {
        return fullyQualifiedName.substring(fullyQualifiedName.lastIndexOf('.') + 1);
    }
}
