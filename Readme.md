# MetaFileType
MetaFileType is a Java library designed to detect the type of a file from JSON metadata. It supports various file types such as delimited, CSV, JSON, Avro, Parquet, and Excel.

## Features
- Detects file type from JSON metadata file.
- Detects file type from JSON metadata string.
- Supports multiple file types: delimited, CSV, JSON, Avro, Parquet, Excel, and unknown.

## Installation
To use MetaFileType in your Maven project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.xclusive43</groupId>
    <artifactId>MetaFileType</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
# Usage
## Detecting File Type from JSON File
```java
import org.xclusive43.FileTypeDetector;
import org.xclusive43.FileTypeDetector.FileType;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String jsonFilePath = "path/to/your/file.json";
            FileType fileType = FileTypeDetector.detectFileType(jsonFilePath);
            System.out.println("Detected file type: " + fileType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Detecting File Type from JSON String
```java
import org.xclusive43.FileTypeDetector;
import org.xclusive43.FileTypeDetector.FileType;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String jsonString = "{ \"type\": \"csv\" }";
            FileType fileType = FileTypeDetector.detectFileTypeFromString(jsonString);
            System.out.println("Detected file type: " + fileType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

# Building the Project
Commnd
```shell
mvn clean package
```

# Running Tests
To run the tests, use Maven:
```shell
mvn test
```
# Contributing
Contributions are welcome! Please open an issue or submit a pull request on GitHub.

# License
This project is licensed under the Apache License, Version 2.0. See the LICENSE file for details.

# Author Details
```html
AJAY PRAJAPATI
Address: Guwahati, Assam, India
Email: ajayxd43@gmail.com 
```
## Acknowledgments
Special thanks to the open-source community for their invaluable resources and contributions.

### Summary
This `README.md` provides an overview of the MetaFileType library, including installation instructions, usage examples, and build/test/deployment commands. It also includes author information and acknowledgment for contributions.
