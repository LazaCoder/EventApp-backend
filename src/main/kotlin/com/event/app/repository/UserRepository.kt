package com.event.app.repository
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Entity
@Table(name = "Users")  // Assuming the table name also starts with a capital letter
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "Name", nullable = false)  // Adjusted to match database column name
    val name: String,

    @Column(name = "Surname", nullable = false)  // Adjusted to match database column name
    val surname: String,

    @Column(name = "Password", nullable = false)  // Adjusted to match database column name
    val password: String,

    @Column(name = "Age", nullable = false)  // Adjusted to match database column name
    val age: Int,

    @Column(name = "image_id", nullable = false)  // Adjusted to match database column name
    val image_id: Int,

    @Column(name = "Description", length = 500)  // Adjusted to match database column name
    val description: String,

    @Column(name = "Nickname", nullable = true)  // Adjusted to match database column name
    val nickname: String
)



@Repository
interface UserRepository : JpaRepository<User, Long> {
}