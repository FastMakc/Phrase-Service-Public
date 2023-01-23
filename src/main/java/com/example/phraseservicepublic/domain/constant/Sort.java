package com.example.phraseservicepublic.domain.constant;

public enum Sort {
    RANDOM("RAND()"),
    TIME_INSERT("phrase.rime_insert DESC");

    private final String value;
    Sort(String value) {this.value = value; }
    public String getValue() {return value; }

}
