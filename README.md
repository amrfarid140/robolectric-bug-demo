### Description
Assertion fails when asserting that all `reference_ids` in constraint group is set to true. The test works as expected when ran with Espresso but it fails when ran with Robolectric 4.1.

### Steps to Reproduce

**Background**
1. Create an Activity with a constrain group with some reference ids. For example two text views.
2. Create a function that turns them from GONE to VISIBLE.
3. Run a test that executes the function mentioned in (2) and assert that the views are visible.

**Expected**
Test passes

**Actual**
Test fails as all views are still GONE.

### Robolectric & Android Version
Robolectric version: 4.1
Target Android SDK: 28
Android Gradle Plugin : 3.3.0
