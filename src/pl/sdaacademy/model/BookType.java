package pl.sdaacademy.model;

public enum BookType {

    COMICS("comics"), FANTASY("fantasy"), DEFAULT("default");

    private String type;

    BookType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
