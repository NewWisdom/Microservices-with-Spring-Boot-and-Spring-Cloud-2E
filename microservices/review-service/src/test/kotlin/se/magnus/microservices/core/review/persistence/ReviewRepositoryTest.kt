package se.magnus.microservices.core.review.persistence

import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.springframework.dao.OptimisticLockingFailureException
import org.springframework.data.repository.findByIdOrNull
import support.JpaRepositoryTest


@JpaRepositoryTest
class ReviewRepositoryTest(
    private val repository: ReviewRepository
) {

    @Test
    fun `findByProductId`() {
        val savedEntity = repository.save(ReviewEntity(1, 1, "a", "s", "sc"))

        val actual = repository.findByProductId(savedEntity.productId)

        assertThat(actual).hasSize(1)
    }

    @Ignore("예제는 CrudRepository를 사용해서 성공한거임")
    @Test
    fun `OptimisticLock Error`() {
        val savedEntity = repository.save(ReviewEntity(1, 1, "a", "s", "sc"))

        val entity1 = repository.findByIdOrNull(savedEntity.id)!!
        val entity2 = repository.findByIdOrNull(savedEntity.id)!!

        entity1.changeContent("change1")
        repository.saveAndFlush(entity1)
        val entity3 = repository.findByIdOrNull(savedEntity.id)!!

        assertThrows<OptimisticLockingFailureException> {
            entity2.changeContent("change2")
            repository.saveAndFlush(entity2)
        }

        val updatedEntity = repository.findByIdOrNull(savedEntity.id)!!
        assertAll (
            { assertThat(updatedEntity.version).isEqualTo(1) },
            { assertThat(updatedEntity.content).isEqualTo("change1") }
        )
    }
}