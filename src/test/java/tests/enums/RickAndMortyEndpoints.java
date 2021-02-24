package tests.enums;

public enum RickAndMortyEndpoints {

    RICK_AND_MORTY_CHARACTER ("https://rickandmortyapi.com/api/character"),
    RICK_AND_MORTY_LOCATION ("https://rickandmortyapi.com/api/location"),
    RICK_AND_MORTY_EPISODE ("https://rickandmortyapi.com/api/episode");
    private final String value;

    RickAndMortyEndpoints(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
