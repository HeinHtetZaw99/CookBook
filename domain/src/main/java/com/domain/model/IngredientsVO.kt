package com.domain.model

data class IngredientsVO(
    var ingredientName: String = "",
    var ingredientAmount: String = ""
) {


    fun getThumbnailPic(): String {
        val baseLink = "https://www.themealdb.com/images/ingredients/"
        if (this.ingredientName == "")
            return ""
        val ingredient =
            if (this.ingredientName.contains(" "))
                this.ingredientName.toLowerCase().replace(" ", "%20")
            else this.ingredientName.toLowerCase()

        return "$baseLink$ingredient.png"

    }
}

