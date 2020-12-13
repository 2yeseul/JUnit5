package com.example.junit5test.DisplayName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Display Name Demo🤓")
public class DisplayNameDemo {
    @Test
    @DisplayName("공백 공백 공백 ")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("🎄")
    void testWithDisplayNameContainingEmoji() {
    }

}
