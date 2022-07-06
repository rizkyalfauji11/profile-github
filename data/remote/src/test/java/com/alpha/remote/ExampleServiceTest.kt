package com.alpha.remote

import com.alpha.remote.base.BaseTest
import org.junit.Test
import retrofit2.HttpException

class ExampleServiceTest: BaseTest() {

    @Test
    fun `get example success`() {

    }

    @Test(expected = HttpException::class)
    fun `get example fail`() {

    }
}