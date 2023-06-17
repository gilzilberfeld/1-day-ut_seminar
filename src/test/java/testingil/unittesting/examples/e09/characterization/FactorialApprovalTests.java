package testingil.unittesting.examples.e09.characterization;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;
import testingil.unittesting.examples.e02.factorial.Factorial;

public class FactorialApprovalTests {
    @Test
    public void factorial_tests(){
        StringBuilder log = new StringBuilder();
        log.append("num 1:").append(Factorial.calculate(1)).append("\n");
        log.append("num 2:").append(Factorial.calculate(2)).append("\n");
        log.append("num 3:").append(Factorial.calculate(3)).append("\n");
        log.append("num 4:").append(Factorial.calculate(4)).append("\n");

        Approvals.verify(log.toString());
    }
}
