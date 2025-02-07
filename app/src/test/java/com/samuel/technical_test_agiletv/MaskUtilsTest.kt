package com.samuel.technical_test_agiletv

import com.samuel.technical_test_agiletv.utils.heightMask
import com.samuel.technical_test_agiletv.utils.weightMask
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MaskUtilsTest {

  @Test
  fun `Should be weight formatted in brazilian format`() {
    val weight = 1000
    val weightToKg = weightMask(weight)
    assertEquals("100,0", weightToKg)
  }

  @Test
  fun `Should be height formatted in brazilian format`() {
    val height = 18
    val heightToMetters = heightMask(height)
  assertEquals("1,8", heightToMetters)
  }
}