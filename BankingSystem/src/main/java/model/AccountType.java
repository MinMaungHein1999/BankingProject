package model;

public enum AccountType {
    SAVING(1),
    CURRENT(2),
    FOREIGN(3);

    private final int value;

    AccountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static AccountType fromInt(int value) {
        for (AccountType type : AccountType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Account type value not found for " + value);
    }

}
