package com.copybook4j.core;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by anujjamwal on 11/07/17.
 */
public class Copybook extends GroupElement {
    Copybook(int level, String name) {
        super(level, name);
    }

    public static Copybook fromContent(String content) throws IOException {
        Parser parser = new Parser();
        return parser.parse(content);
    }

    static class Parser {
        private ElementFactory elementFactory = new ElementFactory();

        Copybook parse(String content) throws IOException {
            try (Scanner scanner = new Scanner(content)) {
                scanner.useDelimiter("\\.");
                return parse(scanner);
            }
        }

        private Copybook parse(Scanner scanner) {
            String[] tokens = scanner.next().trim().split("\\s+");
            int level = Integer.parseInt(tokens[0], 10);
            String name = tokens[1];
            Copybook copybook = new Copybook(level, name);
            parse(scanner, copybook);
            return copybook;
        }

        private void parse(Scanner scanner, GroupElement parent) {
            while (scanner.hasNext()) {
                String[] tokens = scanner.next().trim().toUpperCase().split("\\s+");
                int level = Integer.parseInt(tokens[0], 10);
                String name = tokens[1];

                if (tokens.length == 2) {
                    GroupElement element = new GroupElement(level, name);
                    parent.append(element);
                    parse(scanner, element);
                } else if (tokens[2].startsWith("PIC")) {
                    int index = 3;

                    if (tokens[index].equals("IS")) index++;

                    Element element = elementFactory.build(level, name, tokens, index);
                    parent.append(element);
                }
            }
        }
    }
}
