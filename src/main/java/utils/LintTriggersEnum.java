package utils;

public enum LintTriggersEnum {
    MULTIPLY('*'),
    ADD('+'),
    DIFFERENCE('-'),
    DIVIDE('/'),
    AND('&'),
    EQUAL('='),
    OPENING_BRACKET('('),
    CLOSING_BRACKET(')'),
    ALTERNATIVE('|'),
    TABULATION('\t'),
    NEW_LINE('\n'),
    EMPTY_CHAR('\0'),
    SPACE(' '),
    SEMICOLON(';'),
    SQUARE_OPENING_BRACKET('['),
    SQUARE_CLOSING_BRACKET(']'),
    DOT('.'),
    COMMA(','),
    OPENING_CURLY_BRACKET('{'),
    CLOSING_CURLY_BRACKET('}');

    private final Character symbol;

    LintTriggersEnum(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }
}