package difflib.examples;

import difflib.DiffUtils;
import difflib.TestConstants;
import difflib.patch.Patch;
import difflib.patch.PatchFailedException;
import java.util.List;

public class ApplyPatch extends Example {

    static final String ORIGINAL = TestConstants.MOCK_FOLDER + "issue10_base.txt";
    static final String PATCH = TestConstants.MOCK_FOLDER + "issue10_patch.txt";

    public static void main(String[] args) throws PatchFailedException {
        List<String> original = fileToLines(ORIGINAL);
        List<String> patched = fileToLines(PATCH);

        // At first, parse the unified diff file and get the patch
        Patch<String> patch = DiffUtils.parseUnifiedDiff(patched);

        // Then apply the computed patch to the given text
        List<String> result = DiffUtils.patch(original, patch);
        System.out.println(result);
        // / Or we can call patch.applyTo(original). There is no difference.
    }
}