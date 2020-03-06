package offer.interview.com.litedoordash.service

import junit.framework.Assert.assertNotSame
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class RepositoryTest {

    @Test
    fun count_isCorrect() {
        runBlocking {
            val restaurantList = Repository.restaurantApi.getRestaurants()
            assertEquals(restaurantList.size, 49)
        }
    }

    @Test
    fun coverImg_isNonNull() {
        runBlocking {
            val restaurantList = Repository.restaurantApi.getRestaurants()
            val restaurant = restaurantList[0]
            assertNotNull(restaurant.cover_img_url)
        }
    }

    @Test
    fun name_isNonNull() {
        runBlocking {
            val restaurantList = Repository.restaurantApi.getRestaurants()
            val restaurant = restaurantList[0]
            assertNotNull(restaurant.name)
        }
    }

    @Test
    fun id_isNonZero() {
        runBlocking {
            val restaurantList = Repository.restaurantApi.getRestaurants()
            val restaurant = restaurantList[0]
            assertNotSame(restaurant.id, 0)
        }
    }

    @Test
    fun delivery_fee_isNonNull() {
        runBlocking {
            val restaurantList = Repository.restaurantApi.getRestaurants()
            val restaurant = restaurantList[0]
            assertNotNull(restaurant.delivery_fee)
        }
    }

    @Test
    fun status_isNonNull() {
        runBlocking {
            val restaurantList = Repository.restaurantApi.getRestaurants()
            val restaurant = restaurantList[0]
            assertNotNull(restaurant.status)
        }
    }

    @Test
    fun description_isNonNull() {
        runBlocking {
            val restaurantList = Repository.restaurantApi.getRestaurants()
            val restaurant = restaurantList[0]
            assertNotNull(restaurant.description)
        }
    }

}
