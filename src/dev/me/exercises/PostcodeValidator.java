package dev.me.exercises;

import java.util.Objects;
import java.util.regex.Pattern;

public class PostcodeValidator {
    private static final String OUTWARD_CODE_REGEX = "^[A-Z]{1,2}\\d[A-Z\\d]?";
    // 9AA
    private static final String INWARD_CODE_REGEX = "^[0-9][A-Z]{2,2}";

    public boolean isValid(String postCode) {
        if (Objects.isNull(postCode) || postCode.isEmpty()) {
            return false;
        }

        postCode = postCode.toUpperCase();
        var tokens = postCode.split("\\s");
        return isOutwardCodeValid(tokens[0]) && isInwardCodeValid(tokens[1]);
    }

    /*
    Outward codes:
        Group 1:
            - AA9A
            - AA99

        Group 2:
            - A9A
            - A99
            - AA9

        Group 3:
            - A9
     */
    protected boolean isOutwardCodeValid(String outward) {
        var pattern = Pattern.compile(OUTWARD_CODE_REGEX);
        return pattern.matcher(outward).matches();
    }

    /*
        - 9AA
     */
    protected boolean isInwardCodeValid(String inward) {
        var pattern = Pattern.compile(INWARD_CODE_REGEX);
        return pattern.matcher(inward).matches();
    }

    public static void main(String[] args) {
        String[] validPostalCodes = {
                "AB10 1XG",
                "BT48 6DQ",
                "CH5 3TW",
                "DN16 1AL",
                "EX2 7AE",
                "FY8 1LS",
                "G1 1XQ",
                "HU10 6UA",
                "IG10 1EG",
                "JE2 3GF"
        };

        PostcodeValidator test = new PostcodeValidator();

        for (String postalCode: validPostalCodes) {
            System.out.println(postalCode + " is valid? " + test.isValid(postalCode));
        }
    }
}
