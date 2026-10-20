package PracticeProblem;

/**
 * Problem 3: The Nickname Tag
 * Scenario: A chat app shows a friendly short nickname instead of your full name.
 */
public final class NameTag {
    private final String firstName;
    private final String lastNameInitial;
    private final String nickname;

    public NameTag(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length >= 2) {
            this.firstName = parts[0];
            this.lastNameInitial = parts[1].substring(0, 1).toUpperCase() + ".";
        } else {
            this.firstName = parts[0];
            this.lastNameInitial = "";
        }
        this.nickname = this.firstName + (this.lastNameInitial.isEmpty() ? "" : " " + this.lastNameInitial);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastNameInitial() {
        return lastNameInitial;
    }

    public String getNickname() {
        return nickname;
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());
    }
}
