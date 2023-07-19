package com.example.myrecipes

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class CoroutineTestRule : TestWatcher() {

    private val testCoroutineDispatcher = UnconfinedTestDispatcher()
    private val testCoroutineScope = TestScope(testCoroutineDispatcher)

    val coroutineScope: CoroutineScope
        get() = testCoroutineScope

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
        testCoroutineScope.runTest{}
        testCoroutineDispatcher.cleanupTestCoroutines()
    }

    fun runBlockingTest(block: suspend TestScope.() -> Unit) {
        testCoroutineScope.runTest { block() }
    }

}
//) {
//
//    private val testCoroutineDispatcher = UnconfinedTestDispatcher()
//    private val testCoroutineScope = TestScope(testCoroutineDispatcher)
//
//    val coroutineScope: CoroutineScope
//        get() = testCoroutineScope
//
//    override fun starting(description: Description) {
//        super.starting(description)
//        Dispatchers.setMain(testCoroutineDispatcher)
//    }
//
//    override fun finished(description: Description) {
//        super.finished(description)
//        Dispatchers.resetMain()
//        testCoroutineScope.cleanupTestCoroutines()
//        testCoroutineDispatcher.cleanupTestCoroutines()
//    }
//
//    fun runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) {
//        testCoroutineScope.runBlockingTest { block() }
//    }
