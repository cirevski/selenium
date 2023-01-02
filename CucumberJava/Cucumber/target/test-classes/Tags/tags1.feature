Feature: Testing tags


@smoke
Scenario: test1
Given step 1
Then step 2

@smoke @login
Scenario: test2
Given step1
Then step3

@regression
Scenario: test3
Given step3
Then step4

@login
Scenario: test4
Given step2
Then step5