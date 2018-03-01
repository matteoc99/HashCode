package testbench;

import utils.CodeUtils;

public class ReaderTest {

    public static void main(String[] args) {
        System.out.println(CodeUtils.readInString(System.getProperty("user.dir") + "/src/files/test.txt"));

    }
}

