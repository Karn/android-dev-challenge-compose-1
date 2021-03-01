/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

data class PuppyModel(
    val id: String,
    val name: String,
    val breed: String,
    val gender: String,
    val age: String,
    val weight: String,
    val color: String,
    val health: String,
    val characteristics: String,
    val images: List<Triple<String, Int, Int>>,
    val shelter: String,
    val bio: String,
    val link: String,
    var liked: Boolean = false,
)

class PuppyRepository {
    private val puppies = listOf(
        PuppyModel(
            id = "1",
            name = "Dorian",
            breed = "Mixed Breed",
            gender = "Male",
            age = "6 months",
            weight = "19 lbs",
            color = "Brown / Chocolate",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50629793/6/?bust=1614032108&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50629793/4/?bust=1614032059&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50629793/3/?bust=1614032076&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50629793/1/?bust=1614032032&width=1080", 0, 0),
            ),
            characteristics = "outdoorsy, confident, energetic, adventurous",
            shelter = "Fetch & Releash Dog Rescue",
            bio = """Meet Dorian! Dorian was rescued with his siblings when they were found by our partner shelter. They were not receiving the care they deserved, so their owners agreed to give them a better chance at life. Once they got to the shelter, they received much needed medical care and probably their first full meal. They were then cleared to make the trip to Canada in search of their forever homes!

Dorian loves to cuddle and will even fall asleep in your arms. His fosters say he is very communicative with his expressions and loves to tell you what he wants. He is food motivated and has made all training very easy! He is high energy, loving, sweet, protective, intelligent and curious. He will fit in with a family that loves to go for walks, is patient during training and enjoys spending time with an extra snuggly canine companion!

With people he knows, he will run up to say hello and his tail will be a hurricane of happy. With new people, he can be timid and will react out of fear. He is never aggressive but he will bark to express his discomfort and ask for space. Moving slow and being quiet is generally the best approach for strangers to begin interacting with him. He is very gentle so we predict he would do well with dog savvy children that are old enough to understand body language. All people need to go at his pace to earn his trust.

Dorian is still a baby so he needs frequent potty breaks throughout the day. He currently gets two walks that last about 30 minutes in duration. Once the weather is warmer and he is comfortable, he can go even longer! He has the occasional accident but is getting better at telling his humans when he has to use the washroom.

If Dorian wants attention, he may grab a shoe and run with it! He may also dig on the couch or bed. He needs to be consistently redirected with appropriate places to chew and would benefit from mental stimulation while indoors.

Dorian has been crate trained and settles quickly. He has some mild separation anxiety so it’s important his crate time is continued and he is encouraged to be on his own at times. He is a smart dog and has picked up some commands including sit, down, come and wait.

Dorian walks well on leash and prefers to be close to his humans. In new situations he startles easy and will bolt if given the chance. He will need to be safely secured at all times while outdoors. His confidence grows quickly but he will take some time to overcome his fears.

Dorian would love to have a backyard to spend time outdoors and have easy access to a secured space. He could adapt to a large apartment as long as his exercise needs are met. He would likely do best outside of the downtown core. Dorian would do fine with another well adjusted dog, but not essential as he prefers human attention anyway. His ideal family would be home more often than not and can include him in daily activities. Dorian has not been tested with cats.

If you’re interested in adopting Dorian please apply at https://www.fetchandreleash.ca/adoption-info#adoption-form

Dorian’s adoption fee is ${'$'}850. To learn more about our adoption fees and the adoption process, please visit our FAQs at https://www.fetchandreleash.ca/about-us#about-faqs.""",
            link = "https://www.petfinder.com/dog/dorian-adoption-pending-50629793/on/mississauga/fetch-releash-dog-rescue-on538/"
        ),
        PuppyModel(
            id = "2",
            name = "Buddy",
            breed = "Great Pyrenees & Maremma Sheepdog Mix",
            gender = "Male",
            age = "8 months",
            weight = "Large",
            color = "White, Mocha",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50674233/1/?bust=1614382820&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50674233/3/?bust=1614382891&width=1080", 0, 0),
            ),
            characteristics = "sensitive, submissive, gentle",
            shelter = "Blue Collared Canines",
            bio = """Buddy is a sweet and gentle 8 month old boy looking for his forever home. He has a very submissive nature and is super eager to please. Buddy is sensitive to corrections and needs a soft handler. He is very well behaved in the home and on leash and would be a great friend to children.""",
            link = "https://www.petfinder.com/dog/buddy-50674233/on/niagara-falls/blue-collared-canines-on305/"
        ),
        PuppyModel(
            id = "3",
            name = "Athena",
            breed = "Mixed Breed",
            gender = "Female",
            age = "15 months",
            weight = "39 lbs",
            color = "Chocolate, White",
            health = "Vaccinations up to date, spayed / neutered",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50605781/1/?bust=1614524142&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50605781/3/?bust=1614524143&width=1080", 0, 0),
            ),
            characteristics = "sensitive, submissive, gentle",
            shelter = "716 Promoting Animal Welfare & Safety (716 PAWS)",
            bio = """Meet Athena, shes had a rough start to life but that hasnt stop her from wanting to give you all her love! Those baby brown eyes will sucker you right in. She greets everyone with excitement and has not shown to be aggressive with the child or cats in her foster home. Athena is crate trained and is working on her potty training. A few things you should know, she gets scared being outside alone, she was left chained up and starving so please if you do not have another dog try not to leave her outside for a long period of time alone. Her favorite place if you let her is the couch cuddled up next to a human. This little girl is ready to find her forever home.

If you are interested in adopting Athena, please apply at our website https://www.716paws.org/foster-to-adopt or message us if you are already pre-approved.""",
            link = "https://www.petfinder.com/dog/athena-50605781/ny/amherst/716-promoting-animal-welfare-safety-716-paws-ny1515/"
        ),
        PuppyModel(
            id = "4",
            name = "Olive",
            breed = "Border Collie Mix",
            gender = "Female",
            age = "4 months",
            weight = "25 lbs",
            color = "Black, White",
            health = "Vaccinations up to date, spayed / neutered, special needs. She is blind.",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50668298/3/?bust=1614542263&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50668298/2/?bust=1614542283&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50668298/1/?bust=1614542263&width=1080", 0, 0),
            ),
            characteristics = "silly, energetic",
            shelter = "716 Promoting Animal Welfare & Safety (716 PAWS)",
            bio = """Olive is a floppy puppy who love to roll around upside whether she is playing or sleeping, she really just likes being upside down. She is very silly & is very happy when she can run at a million miles a hour. So if you are looking for a very energic puppy who is full of lot of love & tons of cuteness, Olive is your girl. She is pee pad trained but does need work on outside potty training as she came from Alabama and is still not used to these cold NY temperatures & would do well with another doggy brother or sister to help show her how the this whole outside potty thing works. She is also a little afraid of outside still so a harness NOT collar will have to be your method of training. She requires a fenced in yard. She absolutely loves her foster doggy brothers & sister & follows them everywhere & is learning to respect the cats that live with her foster mom. She is still a puppy & thinks they are moving toys right now.

If you are interested in adopting Olive, please fill out an application at www.716paws.org or message us if you are already pre-approved.""",
            link = "https://www.petfinder.com/dog/olive-50668298/ny/amherst/716-promoting-animal-welfare-safety-716-paws-ny1515/"
        ),
        PuppyModel(
            id = "5",
            name = "Darla",
            breed = "Labrador Retriever & Boxer Mix",
            gender = "Female",
            age = "4 months",
            weight = "30 lbs",
            color = "Black, Brindle",
            health = "Vaccinations up to date.",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50593230/4/?bust=1613688409&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50593230/5/?bust=1614131221&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50593230/1/?bust=1613688377&width=1080", 0, 0),
            ),
            characteristics = "snuggly, energetic",
            shelter = "New2U Rescues",
            bio = """Meet Darla!! She is was born 11/04/2020 and is (best guess) a lab/boxer mix, brindle color and is already 25-30 pounds already so we know she's going to be a big girl. As big as she is, her heart is even bigger. She loves to snuggle with her humans as well as play with her foster siblings (both big and small). She LOVES the snow and will require a fenced in yard so that she can get all her energy out! Because she's a bigger "pup" children under 5 are not recommended as she may knock them down by accident.
She will be going to his adoptive home under a foster to adopt contract until her spay is complete. You would be required to get her into our vet clinic once booked for 7:30 am in Rochester and then pick up (3 to 4 pm) from rescue to finalize adoption at that time. For this reason we will not adopt to anyone outside our immediate adoption area. If you would like to meet this adorable pup an application must be filled out https://www.cognitoforms.com/New2URescues/AdoptionApplication

You can learn more about our rescue and process at www.new2urescue.org or find us on facebook at https://new2urescue.org/adoption/adoption-application/ must be filled out to meet one of our dogs. You must be 25 yrs of age or older to adopt through us. We are in the Rochester NY area and adopt dogs out to area residents.



https://www.cognitoforms.com/New2URescues/AdoptionApplication
An application must be filled out to meet any of our dogs, to apply go to
http://new2urescue.org/adoption/adoption-application/ so foster can contact you. We do not have a shelter, dogs are in foster homes.

All animals are kept in foster homes so there is no shelter for you to visit animal. Please go to https://new2urescue.org/adoption/adoption-application/ if you would like to meet the foster animal or learn more.

All our dogs have been spayed/neutered; treated for worms; heartworm tested (if age appropriate -7 mths or older); treated for fleas/ticks; microchip; and examined by veterinarian and given age appropriate vaccinations. We take every effort to ensure the health of the animal and you will receive a copy of all vet work performed.

You can find us on Face Book at https://www.facebook.com/New2Urescue and our main website at https://www.new2urescue.org

New 2 U Rescue is registered as a New York State Shelter / Rescue. Our Registration No.: is RR033 and we are a Registered Non Profit with a 501c3. We help dogs in need in the Greater Rochester, NY area by taking them in, providing any needed vet care and helping them find a forever home.""",
            link = "https://www.petfinder.com/dog/darla-50593230/ny/rochester/new2u-rescues-ny1337/"
        ),
        PuppyModel(
            id = "6",
            name = "Puddin'",
            breed = "Australian Cattle Dog / Blue Heeler Mix",
            gender = "Female",
            age = "2.5 months",
            weight = "25 lbs",
            color = "Black, White, Yellow",
            health = "Vaccinations up to date, spayed / neutered.",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50691246/1/?bust=1614549330&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50691246/2/?bust=1614549331&width=1080", 0, 0),
            ),
            characteristics = "bossy, energetic",
            shelter = "G.R.A.S.P. Inc.",
            bio = """Please contact the Dog Team (dogapplications@yahoo.com) for more information about this pet.DOB: 12/19/20
Puddin' is also known as Miss Sassy Pants by her 9 year old foster human. She's the smallest of her sisters and loves to be in charge, but hey someone has to be right? She doesn't let anything slow her down and loves to play with toys until everyone is sick of her! She enjoys the company of others, both human and four legged friends, and will cuddle up on your lap when it's nap time. She does well with kids, cats and other dogs.
Her adoption fee is ${'$'}400.00""",
            link = "https://www.petfinder.com/dog/puddin-50691246/ny/rochester/grasp-inc-ny23/"
        ),
        PuppyModel(
            id = "7",
            name = "Pepita",
            breed = "Mixed Breed",
            gender = "Female",
            age = "24 months",
            weight = "48 lbs",
            color = "Black, Brown / Chocolate",
            health = "Vaccinations up to date, spayed / neutered.",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50636008/4/?bust=1614098442&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50636008/1/?bust=1614097891&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50636008/2/?bust=1614097906&width=1080", 0, 0),
            ),
            characteristics = "social, fearful, powerful",
            shelter = "Fetch & Releash Dog Rescue",
            bio = """Meet Pepita! Pepita was rescued from very poor conditions, but she holds nothing against humans. Pepita is spunky, friendly, high-energy, smart, affectionate, and attentive. She loves to greet her humans and has the wiggliest butt when she’s excited! Pepita loves all toys but especially tennis balls. She is food motivated so it has been a dream to train her in foster care. This lovable and loyal goofball is now ready for a family of her own!

Pepita is a social girl - and greets all humans with a friendly face. She can be a little weary at night time and may bark to alert her humans of a stranger approaching. She has not been tested with younger children but does fine with dog-savvy kids ages 14+.

Pepita has free reign of the home usually but is crated at night time. she settles right away without making a sound. She can be a bit of a begger, so she is also crated during meal times to create some boundaries.

Pepita is high energy and does best with three walks a day. While she is in the home she also appreciates some mental games and activities to keep her focused. Pepita does well on a leash with a halti, but she gets pretty distracted by other dogs. She is a powerful girl so she will need to be walked by a strong handler who is comfortable with consistent redirection. Adopters with some experience working with reactivity will be an asset. She is a smart girl and has been receptive to all training!

When Pepita enter foster care she was still working on her potty training. She had a few accidents the first few days but this was likely due to stress. As soon as she was able to decompress and learn the routine of her new home, she has very few accidents and will even wait at the door when she has to go!

Pepita’s ideal family would live in a detached house, with a fully fenced backyard. She needs a safely secured place to run, play, and get out some energy! She could adapt to the city as long as she gets enough exercise, and adopters comfortable with more triggers present. Pepita has not been officially tested with other dogs, but with the level of her current reactions, she wishes to be the only pet in the home. Pepita thrives with routine and clear boundaries!

If you’re interested in adopting Pepita please apply at https://www.fetchandreleash.ca/adoption-info#adoption-form

Pepita’s adoption fee is ${'$'}800. To learn more about our adoption fees and the adoption process, please visit our FAQs at https://www.fetchandreleash.ca/about-us#about-faqs.""",
            link = "https://www.petfinder.com/dog/pepita-50636008/on/mississauga/fetch-releash-dog-rescue-on538/"
        ),
        PuppyModel(
            id = "8",
            name = "Fred",
            breed = "Staffordshire Bull Terrier Mix",
            gender = "Male",
            age = "3 months",
            weight = "20 lbs",
            color = "Black, Brown / Chocolate",
            health = "Vaccinations up to date, spayed / neutered.",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50691245/1/?bust=1614548475&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50691245/2/?bust=1614548414&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50691245/3/?bust=1614548415&width=1080", 0, 0),
            ),
            characteristics = "playful, energetic, smart",
            shelter = "G.R.A.S.P. Inc.",
            bio = """Please contact the Dog Team (dogapplications@yahoo.com) for more information about this pet.DOB: 12/19/20
Fred is very playful and energetic! He loves to play with his toys and is very smart. He would make a great walking partner and would catch onto training quickly. He loves to snuggle, but has a wild puppy side too!
His adoption fee is ${'$'}400.00""",
            link = "https://www.petfinder.com/dog/fred-50691245/ny/rochester/grasp-inc-ny23/"
        ),
        PuppyModel(
            id = "9",
            name = "Fondue",
            breed = "Mixed Breed",
            gender = "Male",
            age = "9 months",
            weight = "29 lbs",
            color = "Brown / Chocolate",
            health = "Vaccinations up to date, spayed / neutered.",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50692907/1/?bust=1614559654&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50692907/2/?bust=1614559656&width=1080", 0, 0),
            ),
            characteristics = "Affectionate, adorable, timid, high energy, excitable, charming",
            shelter = "Fetch & Releash Dog Rescue",
            bio = """Meet Fondue! Fondue was found abandoned outside a shelter along with his mother and siblings. At only one month old, they were in rough shape at the time. Luckily they all made a full recovery and thrived in shelter care. They have all since made the trip to Canada in search of their forever homes!

Fondue is described by his foster Mom as an incredible charmer. He is comical and adorable at the same time! This guy is always on the go and seemingly never runs out of energy or zest for life. He will never say no to pets from his trusted people, and shows his affection by offering a hug. As much as he loves to play and run, he melts when he gets to nuzzle into his favorite person. He is extremely affectionate with is family and bonds closely to them. He is a good boy, looking for a family committed to exposing his true potential!

Being new to life as a pet, Fondue is fearful of new people entering the home. He is making strides in the comfort of his foster home, but will still bark and growl when strangers come in. He will generally keep his distance and it is advised that he is given time and space to warm up on his own. It will be the responsibility of his trusted people to ask strangers to keep their distance. Fondue will approach in his own time but if his space is not respected, he may react out of fear and bite to demand space. Adopters should have realistic expectations when meeting him and expect a few meetings before he is comfortable in their presence. Once you have earned the love and trust of Fondue, you will truly have a friend for life. Fondue is only looking for homes where he won’t have any exposure to children.

On leash Fondue has some reactivity to strange people. All of his reactions are fear based so he will need ongoing desensitization and counter conditioning when it comes to all new things. He may freeze if startled by something and need time to recollect himself and encouragement to continue. Fondue is best walked in quiet areas where he has less access to triggers. Leash walking and etiquette needs to be a priority in his journey.

When first entering foster care, Fondue was not used to the crate and would howl or bark to express his discomfort. After a few months of desensitizing he has become excellent at settling in his crate. As he is a chewer and still a puppy, it is advised that his crate training continues in his forever home. Some transition time should be expected when he changes environments. He is extremely smart and responsive to confident leadership. Given he receives adequate opportunities to use the washroom, Fondue is fully potty trained.

Fondue is HIGH energy and will need plenty of exercise and mental stimulation throughout the day. He has become accustom to having a backyard and would do best with one to get out his zoomies. Even in the backyard he will need supervision as he is a climber and occasional digger. Adopters should be prepared to provide puzzle toys and obedience/trick training to drain mental energy. If he has had enough exercise for the day, Fondue sleeps beautifully through the night in his dog bed.

Fondue has come far in his training but it will be an ongoing journey, as is the case for any puppy! When he changes environments he will need boundaries in place and calm leaders willing to show him the ropes. He can get over excited when he sees his humans so it’s best he is ignored and only calm energy is reinforced. As far as commands he has mastered sit, wait, outside, inside, paw, drop it and lie down. He is a sponge and always ready to learn more!

Fondue’s ideal home would be a detached house, with a fully fenced back yard. He would do best outside of the city as he is sensitive to unexpected noises and high traffic areas. Fondue will need adopters with some dog experience and a solid understanding of the work ahead with him. He will take time to open up and be his best self. Fondue bonds closer/faster to women so would do best with at least one woman in the home. Homes should be low traffic and have a predictable routine he can count on. He loves other dogs but canine companions should be patient and well adjusted. He can be pushy in play so humans must mentor and manage early stages of their relationship.

If you’re interested in adopting Fondue please apply at https://www.fetchandreleash.ca/adoption-info#adoption-form

Fondue’s adoption fee is ${'$'}850. To learn more about our adoption fees and the adoption process, please visit our FAQs at https://www.fetchandreleash.ca/about-us#about-faqs""",
            link = "https://www.petfinder.com/dog/fondue-50692907/on/mississauga/fetch-releash-dog-rescue-on538/"
        ),
        PuppyModel(
            id = "10",
            name = "Ella",
            breed = "Husky & Black Labrador Retriever Mix",
            gender = "Female",
            age = "5 months",
            weight = "25 lbs",
            color = "Black",
            health = "Vaccinations up to date, spayed / neutered.",
            images = listOf(
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50616456/1/?bust=1613916847&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50616456/2/?bust=1613916853&width=1080", 0, 0),
                Triple("https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50616456/4/?bust=1613916862&width=1080", 0, 0),
            ),
            characteristics = "Playful, Cuddly, Large Breed Puppy",
            shelter = "Mattie's Place",
            bio = """Ella is a beautiful 5 month old, large breed puppy.

She joined us from Manitoba and has been in foster care the past month and is now ready to find a forever family.

She has adjusted to City living quite well, but can still be a bit shy with new people and situations but we are really starting to see her blossom.

She is sweet and kind and everything puppy wonderful.

We have no idea what her breed is, but presumed husky/lab. Not knowing what breed she is means we have no idea how big she'll grow, so she could be a 50 pound dog, but could also skyrocket to be a 100 pound dog. We just have no idea. She is a BIG girl for 5 months and growing quick each day.

We're looking for a home for Ella that has someone home most often or a work from home/take your dog to work scenario. She loves people and would be happiest, we believe, not be left behind for full work days, waiting for her people to come home.

We also think she'll benefit from having an adult dog that is well balanced in the home, as she also has a passion for other dogs and enjoys the company.

FROM HER FOSTER MOM:

Super docile and while playful, will flip onto her back for a belly rub mid-game if given the chance!

A big cuddler and loves company; hates to be alone.

Good on the leash; and knows very basic commands like “sit” “lie down”.

House trained and excellent with other dogs (plays well with her large foster brother and doesn’t like to leave his side, whether awake or asleep!) and intuitively gives other dogs space in the street (doesn’t lunge, pull or get distracted).

Will eat anything put in front of her including your favourite shoes; and has a tendency to hoard things (toys, shoes, stuffed animals) in her bed.

Anybody would be lucky to have such a gentle, beautiful lady as part of the family!

---------------------

As of today, though our protocols could change tomorrow, we are still moving forward with adoptions. Our process has changed from some of the previous elements: We are a registered animal welfare organization, so we are deemed an essential service.

All paperwork completed online, video home visits, meet and greets outside respecting social distancing, leashes/collars/supplies wiped down and disinfected (GermiCide 3 wipes), disinfectant on the dog prior to handoff (Aqueos wipes for dogs)

-----------------------

To note: the above description is relevant to this dog in his current & previous setting. Home changes & adopter personalities can bring out different behaviours not previously seen.

We do not specifically kid/cat test our dogs when they arrive at Mattie's Place. That just wouldn't be fair to the dog or child/cat.

We also do not claim, endorse, suggest or hint at, that any of our dogs are hypoallergenic, low shed or no-shed.

Adoption fee includes: spay/neuter, deworming, defleaing, vaccinations, nose to tail health exam, leash|collar, 6 months of preventative based on season/need, DNA test for entertainment purposes, dishes, poop bags, food and any extras she has accumulated in foster care""",
            link = "https://www.petfinder.com/dog/ella-50616456/on/scarborough/matties-place-on571/"
        )
    )

    fun getPuppies(filter: String, onlyLiked: Boolean = false): List<PuppyModel> {
        if (filter.isBlank()) {
            return puppies.filter { if (onlyLiked) it.liked else true }
        }

        return puppies.filter {
            val queryMatch = it.name.contains(filter, ignoreCase = true) ||
                it.breed.contains(filter, ignoreCase = true) ||
                it.characteristics.contains(filter, ignoreCase = true)

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
        return listOf(puppies[0], puppies[8], puppies[5], puppies[6])
    }
}
