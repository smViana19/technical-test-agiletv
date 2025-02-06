package com.samuel.technical_test_agiletv.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samuel.technical_test_agiletv.R
import com.samuel.technical_test_agiletv.ui.theme.TechnicaltestagiletvTheme

@Composable
fun AppCard(
  //id: Int
  text: String,
  onClick: () -> Unit
) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .clickable {
        onClick()
      },
    elevation = CardDefaults.cardElevation(1.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    shape = RoundedCornerShape(8.dp)
  ) {
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .background(Color.White),
      contentAlignment = Alignment.Center
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Column(
          modifier = Modifier.padding(start = 8.dp, end = 14.dp)
        ) {
        }
        Column(
          modifier = Modifier.weight(1f),
        ) {
          Text(
            text = text,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
          )
        }
        Row(
          modifier = Modifier.padding(end = 8.dp),
          horizontalArrangement = Arrangement.End
        ) {
          Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_navigate_right_24),
            contentDescription = "Next screen",
          )
        }
      }
    }
  }
}


@Preview(showBackground = true)
@Composable
private fun AppCardPreview() {
  TechnicaltestagiletvTheme {
    AppCard(text = "Pikachu", onClick = {})
  }
}