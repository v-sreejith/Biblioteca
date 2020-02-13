package com.twu.biblioteca;

public class LibraryNumber {
    int[] codeOne;
    int[] codeTwo;

    LibraryNumber(int[] codeOne, int[] codeTwo) {
        this.codeOne = codeOne;
        this.codeTwo = codeTwo;
    }

    private String returnCode(int[] code) {
        String result = "";
        for (int number : code) result += number;
        return result;
    }

    public String number() {
        return "" + returnCode(codeOne) + "-" + returnCode(codeTwo);
    }
}
