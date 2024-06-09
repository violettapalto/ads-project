**University of Klagenfurt** - 
Artificial Intelligence and Cybersecurity - 
*M. El-Kholany & M. Morak*

UE Algorithms and Data Structures - 
SS 2024 - 
Exercise dates: see Moodle

# Submission 2

Submission: 16.06.2024

## Objective of the task

In this practical programming task, the given Java interfaces are to be implemented, according to the description specified in the Java comments:

- `Ab2` This interface provides a factory pattern for creating the remaining interfaces.

- `AuDHashSetThis` interface specifies a simplified hashtable.

- `AuDQueueThis` interface specifies a simplified FIFO or LIFO queue.

- `AuDTreeSetThis` interface specifies the data structure of a sorted tree.

The points distribution is as follows: 4 points for the hashtable, 4 points for the implementation of the queue, and 7 points for the implementation of the sorted tree.

## Preparation

Download the Ab2-ZIP file provided in Moodle. The build tool Gradle is used, which supports you in your work and also when creating your uploadable ZIP file. The ZIP file contains the following components:

- Interface `Ab2` in the Java package `ab2`, as well as other interfaces to be implemented.
- "Empty" implementation (as a basic framework) of the above-mentioned `Ab2` interface in the package `ab2.impl.Surnames` (hereinafter referred to as _implementation package_). Your task is to implement the corresponding interface.
- A test class `Ab2Tests` in the package `ab2`, with which you can test your implementations. This test class (with additional test cases) will also be used to evaluate your submission (see point "Testing").

## Integration into your IDE (optional)

You can import the contents of the ZIP file as a Gradle project (e.g., in Eclipse or IntelliJ). Your IDE then has all the necessary information.

## Execution

The programming task can be processed in groups of up to 3 people. All names must be included in the submission (see points "Submission" below). The required algorithms are to be implemented in the implementation package (impl) without the use of Java libraries and system packages (except `java.lang`). In particular, the `java.util` package may not be used. No changes may be made to the given interfaces and the test class, except for renaming your implementation package. Only change the file "Ab2Impl.java" (or, if needed, new files can also be created in the folder "ab2/impl"). If you have any questions about the task, please contact your course leader.

## Testing

Call [`./gradlew`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fd%3A%2Fads-project%2Fgradlew%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "d:\ads-project\gradlew") test or [`gradlew.bat`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fd%3A%2Fads-project%2Fgradlew.bat%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "d:\ads-project\gradlew.bat") test to run the test cases. Alternatively, you can also run the tests in your development environment. Additional, non-issued test cases will be used to evaluate your submission. It is therefore advantageous if you implement additional test cases yourself and test your solution with them.

## Submission

Call [`./gradlew`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fd%3A%2Fads-project%2Fgradlew%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "d:\ads-project\gradlew") zip or [`gradlew.bat`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fd%3A%2Fads-project%2Fgradlew.bat%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "d:\ads-project\gradlew.bat") zip. You will now find the uploadable ZIP file in the build folder. Submit the ZIP file via Moodle. Only one submission is necessary per group. Before submitting, rename the package `ab2.impl.Surnames` accordingly by replacing Surnames with the surnames of your group members (e.g., `ab2.impl.HuberMeierMueller`).

# Evaluation

This programming task is evaluated with a maximum of 15 points. The points achieved are credited equally to all group members. For more than 3 people, the points achieved are reduced proportionally per person. The evaluation results from the following components:

- Functionality of your code. The number of successful unit tests is decisive for this. Note that not only the test cases of the issued test class are used for the evaluation, but also additional, extended test cases. Only the implementation package is used for testing from your ZIP file.
- Quality of your source code (inspection). Pay attention to commented, easily understandable, and efficient source code. The use of System.out is not permitted.
- Honesty: If you use unauthorized Java libraries (see above), or if you submit the same source code as another group, your submission can be evaluated with 0 points.
- Formatting: Format your code (standard formatting of your IDE is sufficient) and make sure that you do not use any unused imports.