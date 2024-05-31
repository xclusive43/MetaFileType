package meta_file_type;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * A utility class to detect the type of file based on JSON metadata.
 *
 * <p>This class provides methods to determine the file type by inspecting
 * the metadata specified in a JSON file.</p>
 *
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see com.fasterxml.jackson.databind.JsonNode
 * @see com.fasterxml.jackson.databind.ObjectMapper
 * @see java.io.File
 * @see java.io.IOException
 *
 * @author AJAY PRAJAPATI
 */
public class MetaFileType {
    /**
     * Enumeration of supported file types.
     *
     * <p>This enum lists all the file types that this detector can recognize.
     * If a file type is not recognized, it returns {@code UNKNOWN}.</p>
     *
     * @since 1.0.0
     */
    public enum FileType {
        DELIMITED,
        CSV,
        JSON,
        AVRO,
        PARQUET,
        EXCEL,
        UNKNOWN
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Helper method to detect the file type based on the JSON node.
     *
     * <p>This method inspects the {@code type} field of the JSON node to determine
     * the file type.</p>
     *
     * @param root the JSON node containing metadata
     * @return the detected file type
     *
     * @since 1.0.0
     */
    private static FileType detectFileType(JsonNode root) {
        if (root.has("type")) {
            String type = root.get("type").asText().toLowerCase();
            switch (type) {
                case "delimited":
                    return FileType.DELIMITED;
                case "csv":
                    return FileType.CSV;
                case "json":
                    return FileType.JSON;
                case "avro":
                    return FileType.AVRO;
                case "parquet":
                    return FileType.PARQUET;
                case "excel":
                    return FileType.EXCEL;
                default:
                    return FileType.UNKNOWN;
            }
        }
        return FileType.UNKNOWN;
    }

    /**
     * Detects the file type based on the provided JSON file path.
     *
     * <p>This method reads the JSON metadata from the specified file path
     * and determines the file type by inspecting the {@code type} field.</p>
     *
     * @param jsonFilePath the path to the JSON file containing metadata
     * @return the detected file type
     * @throws IOException if an I/O error occurs while reading the JSON file
     *
     * @since 1.0.0
     */
    public static FileType detectFileTypeFromFile(String jsonFilePath) throws IOException {
        JsonNode root = objectMapper.readTree(new File(jsonFilePath));
        return detectFileType(root);
    }

    /**
     * Detects the file type based on the provided JSON string.
     *
     * <p>This method reads the JSON metadata from the provided JSON string
     * and determines the file type by inspecting the {@code type} field.</p>
     *
     * @param jsonString the JSON string containing metadata
     * @return the detected file type
     * @throws IOException if an error occurs while parsing the JSON string
     *
     * @since 1.0.0
     */
    public static FileType detectFileTypeFromString(String jsonString) throws IOException {
        JsonNode root = objectMapper.readTree(jsonString);
        return detectFileType(root);
    }
}
