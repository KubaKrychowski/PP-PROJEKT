package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LintHelpers {
    public final List<Character> charactersToPutBetweenSpaces = new ArrayList<>();
    private final List<Character> logicalOperators = new ArrayList<>();

    public boolean getCharacterFromSpacesList(char character) {
        return charactersToPutBetweenSpaces.stream().anyMatch((c) -> character == c);
    }

    public boolean getLogicalOperationFromList(char logicalOperator) {
        return logicalOperators.stream().anyMatch((c) -> logicalOperators.contains(logicalOperator));
    }

    public void addIndention(int level, StringBuilder sb) {
        sb.append(" ".repeat(Math.max(0, level * 4)));
    }

    public LintHelpers() {
        charactersToPutBetweenSpaces.addAll(Arrays.asList(
                LintTriggersEnum.ADD.getSymbol(),
                LintTriggersEnum.DIFFERENCE.getSymbol(),
                LintTriggersEnum.MULTIPLY.getSymbol(),
                LintTriggersEnum.DIVIDE.getSymbol(),
                LintTriggersEnum.AND.getSymbol(),
                LintTriggersEnum.EQUAL.getSymbol(),
                LintTriggersEnum.OPENING_BRACKET.getSymbol(),
                LintTriggersEnum.CLOSING_BRACKET.getSymbol()));

        logicalOperators.addAll(Arrays.asList(
                LintTriggersEnum.AND.getSymbol(),
                LintTriggersEnum.EQUAL.getSymbol(),
                LintTriggersEnum.ALTERNATIVE.getSymbol()));
    }
}
