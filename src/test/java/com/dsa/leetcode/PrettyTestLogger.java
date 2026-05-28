package com.dsa.leetcode;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrettyTestLogger implements TestExecutionListener {

    private final Map<String, List<String[]>> resultsByClass = new LinkedHashMap<>();
    private int totalPassed = 0;
    private int totalFailed = 0;

    @Override
    public void executionFinished(TestIdentifier id, TestExecutionResult result) {
        if (!id.isTest()) return;

        id.getSource()
          .filter(s -> s instanceof MethodSource)
          .map(s -> (MethodSource) s)
          .ifPresent(source -> {
              String className = source.getClassName();
              String simpleName = className.substring(className.lastIndexOf('.') + 1);
              String methodName = source.getMethodName();
              boolean passed = result.getStatus() == TestExecutionResult.Status.SUCCESSFUL;

              resultsByClass.computeIfAbsent(simpleName, k -> new ArrayList<>())
                            .add(new String[]{methodName, passed ? "PASS" : "FAIL"});

              if (passed) totalPassed++; else totalFailed++;
          });
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println("                  TEST RESULTS SUMMARY");
        System.out.println("=".repeat(60));

        resultsByClass.forEach((className, tests) -> {
            System.out.println();
            System.out.println("  " + className);
            System.out.println("  " + "-".repeat(56));
            System.out.printf("  %-45s %s%n", "Test Case", "Status");
            System.out.println("  " + "-".repeat(56));
            tests.forEach(t ->
                System.out.printf("  %-45s %s%n", t[0], t[1].equals("PASS") ? "[PASS]" : "[FAIL]")
            );
        });

        System.out.println();
        System.out.println("=".repeat(60));
        System.out.printf("  Total: %-4d  Passed: %-4d  Failed: %d%n",
                totalPassed + totalFailed, totalPassed, totalFailed);
        System.out.println("=".repeat(60));
        System.out.println();
    }
}
