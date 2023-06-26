package com.example.myrecipes.features.recipediscovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myrecipes.R
import com.example.myrecipes.model.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .height(180.dp)
                .height(180.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            model = recipe.imageUrl,
            placeholder = painterResource(R.drawable.recipe_card_placeholder),
            contentDescription = "placeholder content description",
        )
        Text(
            text = recipe.title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        Recipe(1,"Cinnamon Rolls","","Tasty rolls")
    )
}