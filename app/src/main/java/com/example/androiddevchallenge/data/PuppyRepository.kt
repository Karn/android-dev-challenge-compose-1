package com.example.androiddevchallenge.data

data class PuppyModel(
    val id: String,
    val name: String,
    val category: String
)

class PuppyRepository {
    private val puppies = listOf<PuppyModel>()

    fun getCategories(): List<String> {
        return (0..6).map { "category $it" }
    }

    fun getPuppies(category: String? = null): List<PuppyModel> {
        if (category.isNullOrBlank()) {
            return puppies
        }

        return puppies.filter { it.category == category }
    }

    fun getSuggestedPuppies() {

    }
}