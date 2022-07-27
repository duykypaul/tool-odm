package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = FileUtils.readSqlFile("index.dta");
        updateODM1(lines);
    }

    /**
     * BN-4044
     * @param lines content file
     */
    public static void updateODM1(Stream<String> lines) {
        List<DTO> dtos = new ArrayList<>();
        Map<Integer, String> keyUpdates = new HashMap<>();
        keyUpdates.put(6, "<Param><![CDATA[07/25/2022 12:00:00 AM]]></Param>");
        keyUpdates.put(16, "<Param><![CDATA[07/25/2022 12:00:00 AM]]></Param>");

        dtos.add(new DTO("M001000700001", keyUpdates));
        dtos.add(new DTO("M001000800001", keyUpdates));
        dtos.add(new DTO("E001001400001", keyUpdates));
        dtos.add(new DTO("M001001100001", keyUpdates));
        dtos.add(new DTO("M001001000001", keyUpdates));
        dtos.add(new DTO("M001001300001", keyUpdates));
        dtos.add(new DTO("E001001150001", keyUpdates));
        dtos.add(new DTO("E001001150002", keyUpdates));
        dtos.add(new DTO("E001001150003", keyUpdates));
        dtos.add(new DTO("E001001150004", keyUpdates));
        dtos.add(new DTO("E001001150005", keyUpdates));
        dtos.add(new DTO("E001001150006", keyUpdates));
        dtos.add(new DTO("E001001150007", keyUpdates));
        dtos.add(new DTO("E001001150008", keyUpdates));
        dtos.add(new DTO("E001001150009", keyUpdates));
        dtos.add(new DTO("E001001150010", keyUpdates));
        dtos.add(new DTO("E001001150011", keyUpdates));
        dtos.add(new DTO("E001001150012", keyUpdates));
        List<String> contents = lines.collect(Collectors.toList());
        for (DTO item : dtos) {
            for (int i = 0; i < contents.size(); i++) {
                if (contents.get(i).contains(item.getKey())) {
                    int finalI = i;
                    item.getValueUpdates().forEach((k, v) -> {
                        String valueReplace = contents.get(finalI + k);
                        int spaceSize = valueReplace.length() - valueReplace.trim().length();
                        contents.set(finalI + k, valueReplace.substring(0, spaceSize).concat(v));
                    });
                    break;
                }
            }
        }
        contents.forEach(System.out::println);
    }
}

