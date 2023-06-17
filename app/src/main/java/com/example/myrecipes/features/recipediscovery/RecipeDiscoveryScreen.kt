package com.example.myrecipes.features.recipediscovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myrecipes.model.Recipe

@Composable
fun RecipeDiscoveryScreen() {
    Column {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(5.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(recipeList) { recipe ->
                RecipeCard(recipe = recipe)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeDiscoveryScreenPreview() {
    //
}

// Sample data to use before we implement API call!
// We will populate our app with data from the Spoonacular API in the rest of the steps/branches.
val recipeList: List<Recipe> = listOf(
    Recipe(
        id = 1,
        title = "Farro With Mushrooms and Asparagus",
        imageUrl = "https://spoonacular.com/recipeImages/642605-556x370.jpg",
        summary = "Need a dairy free and vegetarian side dish? Farro With Mushrooms and Asparagus could be an excellent recipe to try."
    ),
    Recipe(
        id = 2,
        title = "Savory Cheese Dill Scones",
        imageUrl = "https://spoonacular.com/recipeImages/659463-556x370.jpg",
        summary = "The recipe Savory Cheese Dill Scones could satisfy your Scottish craving in roughly 45 minutes."
    ),
    Recipe(
        id = 3,
        title = "Fresh Apple Cake with Caramel Sauce",
        imageUrl = "https://spoonacular.com/recipeImages/643426-556x370.jpg",
        summary = "If you want to add more lacto ovo vegetarian recipes to your recipe box, Fresh Apple Cake With Caramel Sauce might be a recipe you should try."
    ),
    Recipe(
        id = 4,
        title = "Savory Olive & Goat Cheese Palmiers",
        imageUrl = "https://spoonacular.com/recipeImages/659479-556x370.jpg",
        summary = "Savory Olive & Goat Cheese Palmiers might be just the hor d'oeuvre you are searching for."
    ),
    Recipe(
        id = 5,
        title = "Shortbread Lemon Bars",
        imageUrl = "https://spoonacular.com/recipeImages/1005367-556x370.jpg",
        summary = "Shortbread Lemon Bars requires about <b>1 hour and 10 minutes</b> from start to finish"
    ),
    Recipe(
        id = 6,
        title = "Blueberry-Lavender Sauce and Ginger Snap Ice Cream Cups",
        imageUrl = "https://spoonacular.com/recipeImages/635561-556x370.jpg",
        summary = "Blueberry-Lavender Sauce and Ginger Snap Ice Cream Cups requires about about 45 minutes from start to finish."
    ),
    Recipe(
        id = 7,
        title = "Pesto & Yogurt Pasta",
        imageUrl = "https://spoonacular.com/recipeImages/655806-556x370.jpg",
        summary = "This pasta gets rave reviews from everyone who makes it!"
    ),
    Recipe(
        id = 8,
        title = "Chicken, Kielbasa and Shrimp Paella",
        imageUrl = "https://spoonacular.com/recipeImages/641911-556x370.jpg",
        summary = "You can never have too many main course recipes, so give Easy Chicken, Kielbasa and Shrimp Paella a try. This gluten free, dairy free, and foodmap friendly recipe serves 8."
    )
)


