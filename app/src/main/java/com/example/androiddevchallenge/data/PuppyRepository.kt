package com.example.androiddevchallenge.data

data class PuppyModel(
    val id: String,
    val name: String,
    val breed: String,
    val gender: String,
    val color: String,
    val health: String,
    val characteristics: String,
    val images: List<String>,
    val shelter: String,
    var liked: Boolean = false,
)

class PuppyRepository {
    private val puppies = listOf(
        // https://www.petfinder.com/dog/jacinta-adoption-pending-50651219/on/mississauga/fetch-releash-dog-rescue-on538/
        PuppyModel(
            id = "1",
            name = "Jacinta",
            breed = "Mixed Breed",
            gender = "Female",
            color = "Black, Brown / Chocolate",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50651219/1/?bust=1614203263&width=1080",
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50651219/4/?bust=1614203231&width=1080"
            ),
            characteristics = "kind, warm, friendly",
            shelter = "Fetch & Releash Dog Rescue"
        ),
        // https://www.petfinder.com/dog/boop-adoption-pending-50594789/on/mississauga/fetch-releash-dog-rescue-on538/
        PuppyModel(
            id = "2",
            name = "Boop",
            breed = "Mixed Breed",
            gender = "Male",
            color = "Bicolor",
            health = "Spayed / neutered",
            images = listOf(
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50594789/3/?bust=1613698724&width=1080",
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50594789/1/?bust=1613698710&width=1080"
            ),
            characteristics = "energetic, outgoing, playful, loving, loyal, cautious, fearful",
            shelter = "Fetch & Releash Dog Rescue"
        ),
        // https://www.petfinder.com/dog/yoshio-50652151/on/burlington/dibs-rescue-on525/
        PuppyModel(
            id = "3",
            name = "Yoshio",
            breed = "Shepherd Mix",
            gender = "Male",
            color = "Black, Golden",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50652151/3/?bust=1614207964&width=1080",
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50652151/4/?bust=1614207967&width=1080"
            ),
            characteristics = "energetic, playful, shy, adventurous",
            shelter = "DIBS Rescue"
        ),
        // https://www.petfinder.com/dog/dorian-adoption-pending-50629793/on/mississauga/fetch-releash-dog-rescue-on538/
        PuppyModel(
            id = "4",
            name = "Dorian",
            breed = "Street Mix / North York",
            gender = "Male",
            color = "Brown / Chocolate",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50629793/3/?bust=1614032076&width=1080",
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50629793/1/?bust=1614032032&width=1080"
            ),
            characteristics = "outdoorsy, confident, energetic, adventurous",
            shelter = "Fetch & Releash Dog Rescue"
        ),
        // https://www.petfinder.com/dog/bomba-adoption-pending-50626114/on/mississauga/fetch-releash-dog-rescue-on538/
        PuppyModel(
            id = "5",
            name = "Boomba",
            breed = "Mixed Breed",
            gender = "Female",
            color = "Tricolor (Brown, Black, & White)",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50626114/2/?bust=1614012821&width=1080",
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50626114/6/?bust=1614012868&width=1080"
            ),
            characteristics = "affectionate, happy, energetic",
            shelter = "Fetch & Releash Dog Rescue"
        ),
        // https://www.petfinder.com/dog/lotto-50148898/ny/niagara-falls/niagara-dog-rescue-on522/
        PuppyModel(
            id = "6",
            name = "Lotto",
            breed = "Mixed Breed",
            gender = "Male",
            color = "Black",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50148898/1/?bust=1609186545&width=1080",
            ),
            characteristics = "affectionate",
            shelter = "Niagara Dog Rescue"
        ),
    )

    fun getPuppies(filter: String, onlyLiked: Boolean = false): List<PuppyModel> {
        if (filter.isBlank()) {
            return puppies.filter { if (onlyLiked) it.liked else true }
        }

        return puppies.filter {
            val queryMatch = it.name.contains(filter, ignoreCase = true)
                    || it.breed.contains(filter, ignoreCase = true)
                    || it.characteristics.contains(filter, ignoreCase = true)

            if (onlyLiked) {
                return@filter it.liked && queryMatch
            }

            return@filter queryMatch
        }
    }

    fun getPuppy(id: String): PuppyModel {
        return puppies.first { it.id == id }
    }

    fun setPuppyLiked(id: String, liked: Boolean) {
        puppies.firstOrNull { it.id == id }?.liked = liked
    }

    fun getSuggestedPuppies(): List<PuppyModel> {
        return puppies
    }
}