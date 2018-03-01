package testbench;

import utils.CodeUtils;

import java.util.Arrays;

public class ReaderTest {

    public static void main(String[] args) {
        char[][] zeichn = CodeUtils.readInArray(System.getProperty("user.dir") + "/src/files/test.txt");
        System.out.println(Arrays.toString(zeichn[0]));
        CodeUtils.writeArray(zeichn, "test.out");

    }
}

