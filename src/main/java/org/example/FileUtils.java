package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileUtils {
    public static Stream<String> readSqlFile(String filename) throws IOException {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(filename)).getFile());
        Stream<String> lines = Files.lines(Paths.get(file.getAbsolutePath()));
        return lines;
    }
}
