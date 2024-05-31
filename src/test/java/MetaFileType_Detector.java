import meta_file_type.MetaFileType;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Unit tests for the MetaFileType class.
 *
 * <p>This class provides test methods to verify the behavior of the
 * {@code MetaFileType} class.</p>
 *
 * @version 1.0.0
 * @since 1.0.0
 *
 * @see meta_file_type.MetaFileType
 * @see org.junit.jupiter.api.Test
 *
 * @author AJAY PRAJAPATI
 */
public class MetaFileType_Detector {

    /**
     * Writes the given content to a temporary file and returns the file path.
     *
     * <p>This helper method is used to create temporary JSON files for testing
     * purposes.</p>
     *
     * @param content the content to write to the file
     * @return the file path of the temporary file
     * @throws IOException if an I/O error occurs while writing the file
     *
     * @since 1.0.0
     */
    private String createTempJsonFile(String content) throws IOException {
        File tempFile = File.createTempFile("fileType", ".json");
        tempFile.deleteOnExit();
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(content);
        }
        return tempFile.getAbsolutePath();
    }

    /**
     * Tests the detectFileType method with various file types.
     *
     * <p>This method tests the {@code detectFileType} method with different
     * JSON contents to verify that it correctly identifies the file types.</p>
     *
     * @throws IOException if an I/O error occurs
     *
     * @since 1.0.0
     */
    @Test
    public void testDetectFileType() throws IOException {
        String jsonDelimited = "{ \"type\": \"delimited\" }";
        String jsonCsv = "{ \"type\": \"csv\" }";
        String jsonJson = "{ \"type\": \"json\" }";
        String jsonAvro = "{ \"type\": \"avro\" }";
        String jsonParquet = "{ \"type\": \"parquet\" }";
        String jsonExcel = "{ \"type\": \"excel\" }";
        String jsonUnknown = "{ \"type\": \"unknown\" }";

        assertEquals(MetaFileType.FileType.DELIMITED, MetaFileType.detectFileTypeFromFile(createTempJsonFile(jsonDelimited)));
        assertEquals(MetaFileType.FileType.CSV, MetaFileType.detectFileTypeFromFile(createTempJsonFile(jsonCsv)));
        assertEquals(MetaFileType.FileType.JSON, MetaFileType.detectFileTypeFromFile(createTempJsonFile(jsonJson)));
        assertEquals(MetaFileType.FileType.AVRO, MetaFileType.detectFileTypeFromFile(createTempJsonFile(jsonAvro)));
        assertEquals(MetaFileType.FileType.PARQUET, MetaFileType.detectFileTypeFromFile(createTempJsonFile(jsonParquet)));
        assertEquals(MetaFileType.FileType.EXCEL, MetaFileType.detectFileTypeFromFile(createTempJsonFile(jsonExcel)));
        assertEquals(MetaFileType.FileType.UNKNOWN, MetaFileType.detectFileTypeFromFile(createTempJsonFile(jsonUnknown)));
    }

    /**
     * Tests the detectFileTypeFromString method with various file types.
     *
     * <p>This method tests the {@code detectFileTypeFromString} method with different
     * JSON strings to verify that it correctly identifies the file types.</p>
     *
     * @throws IOException if an I/O error occurs
     *
     * @since 1.0.1
     */
    @Test
    public void testDetectFileTypeFromString() throws IOException {
        String jsonDelimited = "{ \"type\": \"delimited\" }";
        String jsonCsv = "{ \"type\": \"csv\" }";
        String jsonJson = "{ \"type\": \"json\" }";
        String jsonAvro = "{ \"type\": \"avro\" }";
        String jsonParquet = "{ \"type\": \"parquet\" }";
        String jsonExcel = "{ \"type\": \"excel\" }";
        String jsonUnknown = "{ \"type\": \"unknown\" }";

        assertEquals(MetaFileType.FileType.DELIMITED, MetaFileType.detectFileTypeFromString(jsonDelimited));
        assertEquals(MetaFileType.FileType.CSV, MetaFileType.detectFileTypeFromString(jsonCsv));
        assertEquals(MetaFileType.FileType.JSON, MetaFileType.detectFileTypeFromString(jsonJson));
        assertEquals(MetaFileType.FileType.AVRO, MetaFileType.detectFileTypeFromString(jsonAvro));
        assertEquals(MetaFileType.FileType.PARQUET, MetaFileType.detectFileTypeFromString(jsonParquet));
        assertEquals(MetaFileType.FileType.EXCEL, MetaFileType.detectFileTypeFromString(jsonExcel));
        assertEquals(MetaFileType.FileType.UNKNOWN, MetaFileType.detectFileTypeFromString(jsonUnknown));
    }
}
