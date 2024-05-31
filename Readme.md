# MetaFileType
MetaFileType is a Java library designed to detect the type of a file from JSON metadata. It supports various file types such as delimited, CSV, JSON, Avro, Parquet, and Excel.

## Features
- Detects file type from JSON metadata file.
- Detects file type from JSON metadata string.
- Supports multiple file types: delimited, CSV, JSON, Avro, Parquet, Excel, and unknown.

## Installation
# Importing MetaFileType Library

## Maven Dependency

To include MetaFileType in your Maven project, add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>org.xclusive43</groupId>
    <artifactId>MetaFileType</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
## Manual JAR Import
If you prefer to manually import the .jar file into your project, follow these steps:
1. Download the .jar file from here.
2. In your IDE (e.g., IntelliJ IDEA, Eclipse), right-click on your project.
3. Select "Add as Library" or "Add External JARs" depending on your IDE.
4. Choose the downloaded .jar file and click "OK" to add it to your project's build path.

## Gradle Dependency (Optional)
For Gradle projects, add the following dependency to your build.gradle file:
```groovy
implementation 'org.xclusive43:MetaFileType:1.0-SNAPSHOT'
```
These steps will allow you to easily import the MetaFileType library into your project and start using it.
```html
    This structure provides users with clear and concise instructions on how to import your library into their projects, catering to different preferences and build systems. Adjust the instructions as needed based on the specifics of your library and its distribution.
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
## Test Report
Here's the test report for the MetaFileType library:
[Test Report](MetaFileType_Detector.md)

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
