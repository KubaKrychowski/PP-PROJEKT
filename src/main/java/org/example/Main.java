package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import utils.LintHelpers;
import utils.LintTriggersEnum;

public class Main {
    public static String fileName = "foo.txt";

    public Main() {
    }

    public static void main(String[] args) {
        String fileContent = ReadFileToString(fileName);
        StringBuilder sb = new StringBuilder();
        LintHelpers helpers = new LintHelpers();
        int indentionLevel = 0;

        for (int charIndex = 0; charIndex < fileContent.length(); ++charIndex) {
            Character c = fileContent.charAt(charIndex);
            Character nextChar = LintTriggersEnum.EMPTY_CHAR.getSymbol();
            Character prevChar = LintTriggersEnum.EMPTY_CHAR.getSymbol();

            if (charIndex + 1 < fileContent.length()) nextChar = fileContent.charAt(charIndex + 1);
            if (charIndex > 0) prevChar = fileContent.charAt(charIndex - 1);

            if (helpers.getLogicalOperationFromList(c) && c == nextChar) {
                sb
                        .append(LintTriggersEnum.SPACE.getSymbol())
                        .append(c)
                        .append(nextChar)
                        .append(LintTriggersEnum.SPACE.getSymbol());
                ++charIndex;
                continue;
            }

            if (c == LintTriggersEnum.TABULATION.getSymbol()) {
                sb.append("    ");
                continue;
            }

            if (c == LintTriggersEnum.SPACE.getSymbol() && nextChar == LintTriggersEnum.SPACE.getSymbol()) {
                if (prevChar == LintTriggersEnum.NEW_LINE.getSymbol()) {
                    sb.append(c);
                } else {
                    sb.append(c);
                }

                continue;
            }

            if (c == LintTriggersEnum.SEMICOLON.getSymbol()) {
                sb.append(c);
                if (prevChar != LintTriggersEnum.OPENING_BRACKET.getSymbol() ||
                        nextChar != LintTriggersEnum.CLOSING_CURLY_BRACKET.getSymbol()) {
                    sb.append(LintTriggersEnum.NEW_LINE.getSymbol());
                }

                continue;
            }

            if (helpers.getCharacterFromSpacesList(c)) {
                sb
                        .append(LintTriggersEnum.SPACE.getSymbol())
                        .append(c)
                        .append(LintTriggersEnum.SPACE.getSymbol());
                continue;
            }

            if (c == LintTriggersEnum.SQUARE_OPENING_BRACKET.getSymbol()) {
                sb.append(c).append(LintTriggersEnum.SPACE.getSymbol());
                continue;
            }

            if (c == LintTriggersEnum.SQUARE_CLOSING_BRACKET.getSymbol()) {
                sb.append(LintTriggersEnum.SPACE.getSymbol()).append(c);
                continue;
            }

            if (
                    (c == LintTriggersEnum.COMMA.getSymbol() || c == LintTriggersEnum.DOT.getSymbol()) &&
                            nextChar != LintTriggersEnum.SPACE.getSymbol()) {
                sb.append(LintTriggersEnum.SPACE.getSymbol());
                continue;
            }

            if (c == LintTriggersEnum.OPENING_CURLY_BRACKET.getSymbol()) {
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != LintTriggersEnum.NEW_LINE.getSymbol())
                    sb.append(LintTriggersEnum.NEW_LINE.getSymbol());

                if (indentionLevel > 0) helpers.addIndention(indentionLevel, sb);

                sb.append(c).append(LintTriggersEnum.NEW_LINE.getSymbol());
                indentionLevel++;
                continue;
            }

            if (c == LintTriggersEnum.CLOSING_CURLY_BRACKET.getSymbol()) {
                indentionLevel--;

                sb.append(LintTriggersEnum.NEW_LINE.getSymbol());

                if (indentionLevel > 0) {
                    helpers.addIndention(indentionLevel, sb);
                }

                sb.append(c).append(LintTriggersEnum.NEW_LINE.getSymbol());

                continue;
            }

            if (!sb.isEmpty() && (prevChar == LintTriggersEnum.NEW_LINE.getSymbol() ||
                    sb.charAt(sb.length() - 1) == LintTriggersEnum.NEW_LINE.getSymbol())) {
                helpers.addIndention(indentionLevel, sb);
            }

            sb.append(c);
        }

        System.out.println(sb);
    }

    private static String ReadFileToString(String fileName) {
        String fileContent = "";

        try {
            FileInputStream inputStream = new FileInputStream(fileName);

            try {
                fileContent = IOUtils.toString(inputStream, StandardCharsets.US_ASCII);
            } catch (Throwable var6) {
                try {
                    inputStream.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            inputStream.close();
        } catch (IOException var7) {
            System.err.println(var7.getMessage());
        }

        return fileContent;
    }
}
